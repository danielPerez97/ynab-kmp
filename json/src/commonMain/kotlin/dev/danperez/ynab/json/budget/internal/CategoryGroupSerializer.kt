package dev.danperez.ynab.json.budget.internal

import dev.danperez.ynab.json.budget.CategoryGroup
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonObject

internal object CategoryGroupSerializer: JsonContentPolymorphicSerializer<CategoryGroup>(CategoryGroup::class) {
    override fun selectDeserializer(element: JsonElement): DeserializationStrategy<CategoryGroup> = when {
        "categories" in element.jsonObject -> CategoryGroup.WithCategories.serializer()
        else -> CategoryGroup.Lite.serializer()
    }

}