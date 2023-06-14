package dev.danperez.ynab.json.budget

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class MultiTransactionUpdate(
    @SerialName("transaction_ids") val transactionIds: List<String>,
    @SerialName("transactions") val transactions: List<Transaction>,
    @SerialName("duplicate_import_ids") val duplicateImportIds: List<String>,
    @SerialName("server_knowledge") val server_knowledge: Int,
)