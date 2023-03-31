package dev.danperez.ynab.budget

import kotlinx.serialization.Serializable

@Serializable
class CategoryGroup(
    val id: String,
    val name: String,
    val hidden: Boolean,
    val deleted: Boolean,
)