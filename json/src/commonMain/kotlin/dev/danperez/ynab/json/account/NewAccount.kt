package dev.danperez.ynab.json.account

import dev.danperez.ynab.json.account.internal.WrapNewAccountInJsonObjectSerializer
import kotlinx.serialization.Serializable

@Serializable(WrapNewAccountInJsonObjectSerializer::class)
class NewAccount(
    val name: String,
    val type: String,
    val balance: Int,
)