package dev.danperez.ynab.json.budget

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class SingleTransactionUpdate(@SerialName("transaction") val singleTransactionUpdate: Transaction)