package dev.danperez.ynab.json.budget

import dev.danperez.ynab.json.budget.internal.TransactionSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable(TransactionSerializer::class)
sealed interface Transaction
{
    val id: String
    val date: String
    val amount: Int
    val memo: String
    val cleared: String
    val approved: Boolean
    val flagColor: String
    val accountId: String
    val payeeId: String
    val categoryId: String
    val transferAccountId: String
    val transferTransactionId: String
    val matchedTransactionId: String
    val importId: String
    val importPayeeName: String
    val importPayeeNameOriginal: String
    val debtTransactionType: String
    val deleted: Boolean

    @Serializable
    data class Lite(
        override val id: String,
        override val date: String,
        override val amount: Int,
        override val memo: String,
        override val cleared: String,
        override val approved: Boolean,
        @SerialName("flag_color") override val flagColor: String,
        @SerialName("account_id") override val accountId: String,
        @SerialName("payee_id") override val payeeId: String,
        @SerialName("category_id") override val categoryId: String,
        @SerialName("transfer_account_id") override val transferAccountId: String,
        @SerialName("transfer_transaction_id") override val transferTransactionId: String,
        @SerialName("matched_transaction_id") override val matchedTransactionId: String,
        @SerialName("import_id") override val importId: String,
        @SerialName("import_payee_name") override val importPayeeName: String,
        @SerialName("import_payee_name_original") override val importPayeeNameOriginal: String,
        @SerialName("debt_transaction_type") override val debtTransactionType: String,
        override val deleted: Boolean,
    ): Transaction

    @Serializable
    data class TransactionFull(
        override val id: String,
        override val date: String,
        override val amount: Int,
        override val memo: String,
        override val cleared: String,
        override val approved: Boolean,
        @SerialName("flag_color") override val flagColor: String,
        @SerialName("account_id") override val accountId: String,
        @SerialName("payee_id") override val payeeId: String,
        @SerialName("category_id") override val categoryId: String,
        @SerialName("transfer_account_id") override val transferAccountId: String,
        @SerialName("transfer_transaction_id") override val transferTransactionId: String,
        @SerialName("matched_transaction_id") override val matchedTransactionId: String,
        @SerialName("import_id") override val importId: String,
        @SerialName("import_payee_name") override val importPayeeName: String,
        @SerialName("import_payee_name_original") override val importPayeeNameOriginal: String,
        @SerialName("debt_transaction_type") override val debtTransactionType: String,
        override val deleted: Boolean,
        @SerialName("account_name") val accountName: String,
        @SerialName("payee_name") val payeeName: String,
        @SerialName("category_name") val categoryName: String,
        val subtransactions: List<Subtransaction>
    ): Transaction
}