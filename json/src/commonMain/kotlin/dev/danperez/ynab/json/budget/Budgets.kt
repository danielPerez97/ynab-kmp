package dev.danperez.ynab.json.budget

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Budgets(
    val budgets: List<Budget>,
    @SerialName("default_budget") val defaultBudget: Budget?
)