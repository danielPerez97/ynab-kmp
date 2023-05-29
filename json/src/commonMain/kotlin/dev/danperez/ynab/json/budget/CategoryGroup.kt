package dev.danperez.ynab.json.budget

import dev.danperez.ynab.json.budget.internal.CategoryGroupSerializer
import kotlinx.serialization.Serializable

@Serializable(CategoryGroupSerializer::class)
sealed interface CategoryGroup
{

    val id: String
    val name: String
    val hidden: Boolean
    val deleted: Boolean

    @Serializable
    data class WithCategories(
        override val id: String,
        override val name: String,
        override val hidden: Boolean,
        override val deleted: Boolean,
        val categories: List<Category>,
    ): CategoryGroup

    @Serializable
    data class Lite(
        override val id: String,
        override val name: String,
        override val hidden: Boolean,
        override val deleted: Boolean,
    ): CategoryGroup
}