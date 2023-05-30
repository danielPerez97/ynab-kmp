package dev.danperez.ynab.json.budget.internal

import dev.danperez.ynab.json.budget.Transaction
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonObject

internal object TransactionSerializer: JsonContentPolymorphicSerializer<Transaction>(Transaction::class) {
    override fun selectDeserializer(element: JsonElement): DeserializationStrategy<Transaction> = when {
        "account_name" in element.jsonObject -> Transaction.TransactionFull.serializer()
        else -> Transaction.Lite.serializer()
    }

}