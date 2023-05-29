package dev.danperez.ynab.json.budget

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ScheduledTransaction(
    val id: String,
    @SerialName("date_first") val dateFirst: String,
    @SerialName("date_next") val dateNext: String,
    val frequency: String,
    val amount: Int,
    val memo: String,
    @SerialName("flag_color") val flagColor: String,
    @SerialName("account_id") val accountId: String,
    @SerialName("payee_id") val payeeId: String,
    @SerialName("category_id") val categoryId: String,
    @SerialName("transfer_account_id") val transferAccountId: String,
    val deleted: Boolean,
)