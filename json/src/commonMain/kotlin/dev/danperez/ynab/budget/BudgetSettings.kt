package dev.danperez.ynab.budget

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BudgetSettings(
    @SerialName("date_format") val dateFormat: DateFormat,
    @SerialName("currency_format") val currencyFormat: CurrencyFormat,
)