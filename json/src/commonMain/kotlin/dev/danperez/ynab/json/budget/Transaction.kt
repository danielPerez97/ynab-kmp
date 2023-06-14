package dev.danperez.ynab.json.budget

import dev.danperez.ynab.json.OptionalProperty
import dev.danperez.ynab.json.budget.internal.TransactionSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable(TransactionSerializer::class)
sealed interface Transaction
{
    val id: OptionalProperty<String>
    val date: String
    val amount: Int
    val memo: String?
    val cleared: String
    val approved: Boolean
    val flagColor: String?
    val accountId: String
    val payeeId: String?
    val categoryId: String?
    val transferAccountId: OptionalProperty<String?>
    val transferTransactionId: OptionalProperty<String?>
    val matchedTransactionId: OptionalProperty<String?>
    val importId: String?
    val importPayeeName: OptionalProperty<String?>
    val importPayeeNameOriginal: OptionalProperty<String?>
    val debtTransactionType: String?
    val payeeName: String?
    val subtransactions: OptionalProperty<List<Subtransaction>>

    @Serializable
    data class Lite(
        override val id: OptionalProperty<String> = OptionalProperty.NotPresent,
        override val date: String,
        override val amount: Int,
        override val memo: String?,
        override val cleared: String,
        override val approved: Boolean,
        @SerialName("flag_color") override val flagColor: String?,
        @SerialName("account_id") override val accountId: String,
        @SerialName("payee_id") override val payeeId: String?,
        @SerialName("category_id") override val categoryId: String?,
        @SerialName("transfer_account_id") override val transferAccountId: OptionalProperty<String?> = OptionalProperty.NotPresent,
        @SerialName("transfer_transaction_id") override val transferTransactionId: OptionalProperty<String?> = OptionalProperty.NotPresent,
        @SerialName("matched_transaction_id") override val matchedTransactionId: OptionalProperty<String?> = OptionalProperty.NotPresent,
        @SerialName("import_id") override val importId: String?,
        @SerialName("import_payee_name") override val importPayeeName: OptionalProperty<String?> = OptionalProperty.NotPresent,
        @SerialName("import_payee_name_original") override val importPayeeNameOriginal: OptionalProperty<String?> = OptionalProperty.NotPresent,
        @SerialName("debt_transaction_type") override val debtTransactionType: String? = null,
        @SerialName("payee_name") override val payeeName: String? = null,
        val deleted: Boolean? = null,
        override val subtransactions: OptionalProperty<List<Subtransaction>> = OptionalProperty.NotPresent
    ): Transaction

    @Serializable
    data class TransactionFull(
        override val id: OptionalProperty<String> = OptionalProperty.NotPresent,
        override val date: String,
        override val amount: Int,
        override val memo: String?,
        override val cleared: String,
        override val approved: Boolean,
        @SerialName("flag_color") override val flagColor: String?,
        @SerialName("account_id") override val accountId: String,
        @SerialName("payee_id") override val payeeId: String?,
        @SerialName("category_id") override val categoryId: String?,
        @SerialName("transfer_account_id") override val transferAccountId: OptionalProperty<String?>,
        @SerialName("transfer_transaction_id") override val transferTransactionId: OptionalProperty<String?>,
        @SerialName("matched_transaction_id") override val matchedTransactionId: OptionalProperty<String?>,
        @SerialName("import_id") override val importId: String?,
        @SerialName("import_payee_name") override val importPayeeName: OptionalProperty<String?>,
        @SerialName("import_payee_name_original") override val importPayeeNameOriginal: OptionalProperty<String?>,
        @SerialName("debt_transaction_type") override val debtTransactionType: String? = null,
        @SerialName("payee_name") override val payeeName: String? = null,
        val deleted: Boolean? = null,
        @SerialName("account_name") val accountName: String,
        @SerialName("category_name") val categoryName: String,
        override val subtransactions: OptionalProperty<List<Subtransaction>> = OptionalProperty.NotPresent
    ): Transaction
}