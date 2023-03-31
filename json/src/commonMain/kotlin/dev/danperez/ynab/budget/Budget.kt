package dev.danperez.ynab.budget

import dev.danperez.ynab.account.Account
import dev.danperez.ynab.budget.internal.BudgetSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable(BudgetSerializer::class)
sealed interface Budget {
    val id: String
    val name: String
    @SerialName("last_modified_on") val lastModifiedOn: String
    @SerialName("first_month") val firstMonth: String
    @SerialName("last_month") val lastMonth: String
    @SerialName("date_format") val dateFormat: DateFormat

    @Serializable
    data class Lite(
        override val id: String,
        override val name: String,
        @SerialName("last_modified_on") override val lastModifiedOn: String,
        @SerialName("first_month") override val firstMonth: String,
        @SerialName("last_month") override val lastMonth: String,
        @SerialName("date_format") override val dateFormat: DateFormat,
    ): Budget

    @Serializable
    data class BudgetData(
        override val id: String,
        override val name: String,
        @SerialName("last_modified_on") override val lastModifiedOn: String,
        @SerialName("first_month") override val firstMonth: String,
        @SerialName("last_month") override val lastMonth: String,
        @SerialName("date_format") override val dateFormat: DateFormat,
        @SerialName("currency_format") val currencyFormat: CurrencyFormat,
        val accounts: List<Account>,
        val payees: List<Payee>,
        @SerialName("payee_locations") val payeeLocations: List<PayeeLocation>,
        @SerialName("category_groups") val categoryGroups: List<CategoryGroup>,
        val categories: List<Category>,
        val months: List<Month>,
        val transactions: List<Transaction.Lite>,
        val subtransactions: List<Subtransaction>,
        @SerialName("scheduled_transactions") val scheduledTransactions: List<ScheduledTransaction>,
        @SerialName("scheduled_subtransactions") val scheduledSubtransactions: List<ScheduledSubtransaction>,
    ): Budget
}