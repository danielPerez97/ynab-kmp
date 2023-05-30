package dev.danperez.ynab.json.budget

import dev.danperez.ynab.json.budget.internal.SubtransactionSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable(SubtransactionSerializer::class)
sealed interface Subtransaction
{
    val id: String
    val transactionId: String
    val amount: Int
    val memo: String?
    val payeeId: String?
    val categoryId: String
    val transferAccountId: String?
    val deleted: Boolean
}

@Serializable
data class FullSubtransaction(
    override val id: String,
    @SerialName("transaction_id") override val transactionId: String,
    override val amount: Int,
    override val memo: String?,
    @SerialName("payee_id") override val payeeId: String?,
    @SerialName("category_id") override val categoryId: String,
    @SerialName("transfer_account_id") override val transferAccountId: String?,
    override val deleted: Boolean,
    @SerialName("payee_name") val payeeName: String,
    @SerialName("category_name") val categoryName: String,
    @SerialName("transfer_transaction_id") val transferTransactionId: String?,
): Subtransaction
@Serializable
data class PartialSubtransaction(
    override val id: String,
    @SerialName("transaction_id") override val transactionId: String,
    override val amount: Int,
    override val memo: String?,
    @SerialName("payee_id") override val payeeId: String?,
    @SerialName("category_id") override val categoryId: String,
    @SerialName("transfer_account_id") override val transferAccountId: String?,
    override val deleted: Boolean,
): Subtransaction