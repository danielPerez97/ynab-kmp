package dev.danperez.ynab.json.budget

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Subtransaction(
    val id: String,
    @SerialName("transaction_id") val transactionId: String,
    val amount: Int,
    val memo: String,
    @SerialName("payee_id") val payeeId: String,
    @SerialName("payee_name") val payeeName: String,
    @SerialName("category_id") val categoryId: String,
    @SerialName("category_name") val categoryName: String,
    @SerialName("transfer_account_id") val transferAccountId: String,
    @SerialName("transfer_transaction_id") val transferTransactionId: String,
    val deleted: Boolean,
)