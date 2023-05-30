package dev.danperez.ynab.json.budget

import dev.danperez.ynab.json.budget.internal.ScheduledTransactionSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable(ScheduledTransactionSerializer::class)
sealed interface ScheduledTransaction
{
    val id: String
    val dateFirst: String
    val dateNext: String
    val frequency: String
    val amount: Int
    val memo: String
    val flagColor: String
    val accountId: String
    val payeeId: String
    val categoryId: String
    val transferAccountId: String
    val deleted: Boolean
}

@Serializable
data class ScheduledTransactionLite(
    override val id: String,
    @SerialName("date_first") override val dateFirst: String,
    @SerialName("date_next") override val dateNext: String,
    override val frequency: String,
    override val amount: Int,
    override val memo: String,
    @SerialName("flag_color") override val flagColor: String,
    @SerialName("account_id") override val accountId: String,
    @SerialName("payee_id") override val payeeId: String,
    @SerialName("category_id") override val categoryId: String,
    @SerialName("transfer_account_id") override val transferAccountId: String,
    override val deleted: Boolean,
): ScheduledTransaction

@Serializable
data class ScheduledTransactionFull(
    override val id: String,
    @SerialName("date_first") override val dateFirst: String,
    @SerialName("date_next") override val dateNext: String,
    override val frequency: String,
    override val amount: Int,
    override val memo: String,
    @SerialName("flag_color") override val flagColor: String,
    @SerialName("account_id") override val accountId: String,
    @SerialName("payee_id") override val payeeId: String,
    @SerialName("category_id") override val categoryId: String,
    @SerialName("transfer_account_id") override val transferAccountId: String,
    override val deleted: Boolean,
    @SerialName("account_name") val accountName: String,
    @SerialName("payee_name") val payeeName: String,
    @SerialName("category_name") val categoryName: String,
    val subtransactions: List<ScheduledSubtransaction>
): ScheduledTransaction