package dev.danperez.ynab.budget

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class Budget(
    val id: String,
    val name: String,
    @SerialName("last_modified_on") val lastModifiedOn: String,
    @SerialName("first_month") val firstMonth: String,
    @SerialName("last_month") val lastMonth: String,
)