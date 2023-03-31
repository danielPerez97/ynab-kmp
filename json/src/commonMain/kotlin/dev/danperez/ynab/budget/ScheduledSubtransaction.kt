package dev.danperez.ynab.budget

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class ScheduledSubtransaction(
    val id: String,
    @SerialName("scheduled_transaction_id") val scheduledTransactionId: String,
    val amount: Int,
    val memo: String,
    @SerialName("payee_id") val payeeId: String,
    @SerialName("category_id") val categoryId: String,
    @SerialName("transfer_account_id") val transferAccountId: String,
    val deleted: Boolean,
)