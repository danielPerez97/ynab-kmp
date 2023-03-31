package dev.danperez.ynab.budget.internal

import dev.danperez.ynab.budget.Transaction
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonObject

object TransactionSerializer: JsonContentPolymorphicSerializer<Transaction>(Transaction::class) {
    override fun selectDeserializer(element: JsonElement): DeserializationStrategy<Transaction> = when {
        "account_name" in element.jsonObject -> Transaction.TransactionFull.serializer()
        else -> Transaction.Lite.serializer()
    }

}