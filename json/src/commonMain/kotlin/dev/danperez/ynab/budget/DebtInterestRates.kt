package dev.danperez.ynab.budget

import kotlinx.serialization.Serializable

@Serializable
data class DebtInterestRates(
    val additionalProp1: Int,
    val additionalProp2: Int,
    val additionalProp3: Int,
)