package dev.danperez.ynab.json.internal

import dev.danperez.ynab.json.Response
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PolymorphicKind
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.buildSerialDescriptor
import kotlinx.serialization.descriptors.element
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.contentOrNull
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

/**
 * The [ResponseSerializer] is a convenience serializer to skip serializing the wrapper "data" object in the json. For
 * example, serializing the following JSON would require a class definition akin to the following on the "data" key.
 *
 * Kotlin:
 * data class MonthResponse(val month: Month)
 *
 * JSON:
 * {
 *   "data": {
 *     "month": {
 *       "month": "April",
 *       "note": "string",
 *       "income": 0,
 *       "budgeted": 0,
 *       "activity": 0,
 *       "to_be_budgeted": 0,
 *       "age_of_money": 0,
 *       "deleted": true,
 *       "categories": []
 *     }
 *   }
 * }
 *
 * The ResponseSerializer will let you skip the data key so you don't have to return a MonthResponse, as long as there
 * is ONLY ONE key other than server_knowledge, which the serializer is smart enough to account for.
 */
@OptIn(ExperimentalSerializationApi::class)
internal class ResponseSerializer<T>(private val dataSerializer: KSerializer<T>): KSerializer<Response<T>> {
    @OptIn(InternalSerializationApi::class)
    override val descriptor: SerialDescriptor = buildSerialDescriptor("Message", PolymorphicKind.SEALED) {
        element("data", buildClassSerialDescriptor("data") {
            element<String>("data")
        })
        element("error", dataSerializer.descriptor)
    }

    override fun deserialize(decoder: Decoder): Response<T> {
        // Decoder -> JsonDecoder
        require(decoder is JsonDecoder) // this class can be decoded only by Json
        // JsonDecoder -> JsonElement
        val element: JsonElement = decoder.decodeJsonElement()
        // JsonElement -> value
        require(element is JsonObject)

        if ("error" in element)
        {
            val errorElement = element["error"]!!.jsonObject
            return Response.Error(
                id = errorElement["id"]!!.jsonPrimitive.content,
                name = errorElement["name"]!!.jsonPrimitive.content,
                detail = errorElement["detail"]!!.jsonPrimitive.content,
            )
        }
        val dataElement: JsonObject = element["data"]!!.jsonObject
        val serverKnowledge = dataElement["server_knowledge"]?.jsonPrimitive
        val keySizeWithoutServerKnowledge = dataElement.keys.size.let { if(serverKnowledge != null) it - 1 else it }
        println("Key Size: $keySizeWithoutServerKnowledge")

        return if(keySizeWithoutServerKnowledge == 1) {
            val nextElement = dataElement[dataElement.keys.first()]!!
            Response.Ok(
                data = decoder.json.decodeFromJsonElement(dataSerializer, nextElement),
                serverKnowledge = serverKnowledge?.contentOrNull?.toInt()
            )
        } else {
            Response.Ok(
                data = decoder.json.decodeFromJsonElement(dataSerializer, dataElement),
                serverKnowledge = serverKnowledge?.contentOrNull?.toInt(),
            )
        }
//        val nextElement: JsonElement = nextObject[nextObject.keys.first()]!!
//        val keys = (nextElement as JsonObject).keys.size
//        println("Keys Size: $keys")
//        return Response.Ok(
//            data = decoder.json.decodeFromJsonElement(dataSerializer, nextElement),
//            serverKnowledge = serverKnowledge?.contentOrNull?.toInt()
//        )
    }

    override fun serialize(encoder: Encoder, value: Response<T>) {
        error("Serialization not supported")
    }
}