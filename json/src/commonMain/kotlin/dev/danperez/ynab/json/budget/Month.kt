package dev.danperez.ynab.json.budget

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Month(
    val month: String,
    val note: String?,
    val income: Int,
    val budgeted: Int,
    val activity: Int,
    @SerialName("to_be_budgeted") val toBeBudgeted: Int,
    @SerialName("age_of_money") val ageOfMoney: Int,
    val deleted: Boolean,
    val categories: List<Category> = emptyList(),
)
