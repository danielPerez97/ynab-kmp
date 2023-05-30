package dev.danperez.ynab.json.budget.internal

import dev.danperez.ynab.json.budget.ScheduledTransaction
import dev.danperez.ynab.json.budget.ScheduledTransactionFull
import dev.danperez.ynab.json.budget.ScheduledTransactionLite
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonObject

internal object ScheduledTransactionSerializer: JsonContentPolymorphicSerializer<ScheduledTransaction>(ScheduledTransaction::class)
{
    override fun selectDeserializer(element: JsonElement): DeserializationStrategy<ScheduledTransaction> = when {
        "account_name" in element.jsonObject -> ScheduledTransactionFull.serializer()
        else -> ScheduledTransactionLite.serializer()
    }

}