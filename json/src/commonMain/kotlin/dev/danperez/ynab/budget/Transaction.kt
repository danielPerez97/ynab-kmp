package dev.danperez.ynab.budget

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Transaction(
    val id: String,
    val date: String,
    val amount: Int,
    val memo: String,
    val cleared: String,
    val approved: Boolean,
    @SerialName("flag_color") val flagColor: String,
    @SerialName("account_id") val accountId: String,
    @SerialName("payee_id") val payeeId: String,
    @SerialName("category_id") val categoryId: String,
    @SerialName("transfer_account_id") val transferAccountId: String,
    @SerialName("transfer_transaction_id") val transferTransactionId: String,
    @SerialName("matched_transaction_id") val matchedTransactionId: String,
    @SerialName("import_id") val importId: String,
    @SerialName("import_payee_name") val importPayeeName: String,
    @SerialName("import_payee_name_original") val importPayeeNameOriginal: String,
    @SerialName("debt_transaction_type") val debtTransactionType: String,
    val deleted: Boolean,
)