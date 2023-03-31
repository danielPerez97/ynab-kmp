package dev.danperez.ynab.budget

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Payee(
    val id: String,
    val name: String,
    @SerialName("transfer_account_id") val transferAccountId: String,
    val deleted: Boolean,
)