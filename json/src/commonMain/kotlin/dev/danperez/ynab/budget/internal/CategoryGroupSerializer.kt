package dev.danperez.ynab.budget.internal

import dev.danperez.ynab.budget.CategoryGroup
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonObject

object CategoryGroupSerializer: JsonContentPolymorphicSerializer<CategoryGroup>(CategoryGroup::class) {
    override fun selectDeserializer(element: JsonElement): DeserializationStrategy<CategoryGroup> = when {
        "categories" in element.jsonObject -> CategoryGroup.WithCategories.serializer()
        else -> CategoryGroup.Lite.serializer()
    }

}