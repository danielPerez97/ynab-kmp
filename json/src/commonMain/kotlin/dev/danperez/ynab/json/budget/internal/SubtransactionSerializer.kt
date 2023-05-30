package dev.danperez.ynab.json.budget.internal

import dev.danperez.ynab.json.budget.FullSubtransaction
import dev.danperez.ynab.json.budget.PartialSubtransaction
import dev.danperez.ynab.json.budget.Subtransaction
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonObject

internal object SubtransactionSerializer  : JsonContentPolymorphicSerializer<Subtransaction>(Subtransaction::class)
{
    override fun selectDeserializer(element: JsonElement): DeserializationStrategy<Subtransaction> = when {
        "payee_name" in element.jsonObject -> FullSubtransaction.serializer()
        else -> PartialSubtransaction.serializer()
    }

}