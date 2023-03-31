package dev.danperez.ynab.internal

import dev.danperez.ynab.Response
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
        val nextObject: JsonObject = element["data"]!!.jsonObject
        val nextElement: JsonElement = nextObject[nextObject.keys.first()]!!
        val serverKnowledge = element["server_knowledge"]?.jsonPrimitive
        return Response.Ok(
            data = decoder.json.decodeFromJsonElement(dataSerializer, nextElement),
            serverKnowledge = serverKnowledge?.contentOrNull?.toInt()
        )
    }

    override fun serialize(encoder: Encoder, value: Response<T>) {
        error("Serialization not supported")
    }
}