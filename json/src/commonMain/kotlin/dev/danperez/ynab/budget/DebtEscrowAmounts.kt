package dev.danperez.ynab.budget

import kotlinx.serialization.Serializable

@Serializable
data class DebtEscrowAmounts(
    val additionalProp1: Int,
    val additionalProp2: Int,
    val additionalProp3: Int,
)