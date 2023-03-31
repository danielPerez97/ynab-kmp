package dev.danperez.ynab.budget.internal

import dev.danperez.ynab.budget.Budget
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonObject

internal object BudgetSerializer : JsonContentPolymorphicSerializer<Budget>(Budget::class) {
    override fun selectDeserializer(element: JsonElement): DeserializationStrategy<Budget> = when {
        "currency_format" in element.jsonObject -> Budget.BudgetData.serializer()
        else -> Budget.Lite.serializer()
    }

}