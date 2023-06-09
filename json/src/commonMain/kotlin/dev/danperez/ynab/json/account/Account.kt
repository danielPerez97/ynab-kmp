package dev.danperez.ynab.json.account

import dev.danperez.ynab.json.budget.ISO8601String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Account(
    val id: String,
    val name: String,
    val type: String,
    @SerialName("on_budget") val onBudget: Boolean,
    val closed: Boolean,
    val note: String?,
    val balance: Int,
    @SerialName("cleared_balance") val clearedBalance: Int,
    @SerialName("uncleared_balance") val unclearedBalance: Int,
    @SerialName("transfer_payee_id") val transferPayeeId: String,
    @SerialName("direct_import_linked") val directImportLinked: Boolean,
    @SerialName("direct_import_in_error") val directImportInError: Boolean,
    @SerialName("last_reconciled_at") val lastReconciledAt: String?,
    @SerialName("debt_original_balance") val debtOriginalBalance: Int?,
    @SerialName("debt_interest_rates") val debtInterestRates: Map<ISO8601String, Int>,
    @SerialName("debt_minimum_payments") val debtMinimumPayments: Map<ISO8601String, Int>,
    @SerialName("debt_escrow_amounts") val debtEscrowAmounts: Map<ISO8601String, Int>,
    val deleted: Boolean
)