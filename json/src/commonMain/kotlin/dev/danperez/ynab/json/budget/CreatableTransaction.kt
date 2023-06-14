package dev.danperez.ynab.json.budget

import dev.danperez.ynab.json.OptionalProperty
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CreatableTransaction(
    @SerialName("id") val id: OptionalProperty<String> = OptionalProperty.NotPresent,
    @SerialName("account_id") val accountId: String,
    val date: String,
    val amount: Int,
    @SerialName("payee_id") val payeeId: String,
    @SerialName("payee_name") val payeeName: String,
    @SerialName("category_id") val categoryId: String?,
    val memo: String,
    val cleared: String,
    val approved: Boolean,
    @SerialName("flag_color") val flagColor: String,
    @SerialName("import_id") val importId: String?,
    val subtransactions: List<Subtransaction>,
)


@Serializable
class SingleCreatableTransaction(@SerialName("transaction") val creatableTransaction: CreatableTransaction)

@Serializable
class MultipleCreatableTransactions(@SerialName("transactions") val creatableTransaction: List<CreatableTransaction>)