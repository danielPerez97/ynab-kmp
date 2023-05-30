package dev.danperez.ynab.json.account.internal

import dev.danperez.ynab.json.account.NewAccount
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

/**
 * Converts a [NewAccount] object to serialize with a wrapping JSON object around it.
 *
 * A [NewAccount] would normally look like the following:
 *
 * {"name": "string","type": "checking","balance": 0}
 *
 *
 * But the YNAB API needs a wrapping JSON object around it when POSTing to the `/budgets/{budget_id}/accounts` endpoint:
 *
 * {"account": {"name": "string","type": "checking","balance": 0}}
 */
internal object WrapNewAccountInJsonObjectSerializer: KSerializer<NewAccount>
{
    override val descriptor: SerialDescriptor = NewAccountSurrogate.serializer().descriptor

    override fun serialize(encoder: Encoder, value: NewAccount) {
        val surrogate = NewAccountSurrogate(NameTypeBalance(name = value.name, value.type, value.balance))
        encoder.encodeSerializableValue(NewAccountSurrogate.serializer(), surrogate)
    }

    override fun deserialize(decoder: Decoder): NewAccount {
        val surrogate = decoder.decodeSerializableValue(NewAccountSurrogate.serializer())
        val (name, type, balance) = surrogate.nameTypeBalance
        return NewAccount(name = name, type = type, balance = balance)
    }

    @Serializable
    private class NewAccountSurrogate(@SerialName("account") val nameTypeBalance: NameTypeBalance)

    @Serializable
    private data class NameTypeBalance(val name: String, val type: String, val balance: Int)
}