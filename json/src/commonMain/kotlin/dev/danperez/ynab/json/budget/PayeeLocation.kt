package dev.danperez.ynab.json.budget

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PayeeLocation(
    val id: String,
    @SerialName("payee_id") val payeeId: String,
    val latitude: String,
    val longitude: String,
    val deleted: Boolean,
)