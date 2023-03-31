package dev.danperez.ynab.budget

import dev.danperez.ynab.BaseJsonTest
import dev.danperez.ynab.Response
import dev.danperez.ynab.readBufferedSource
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.okio.decodeFromBufferedSource
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalSerializationApi::class)
class TestTransaction: BaseJsonTest()
{

    @Test
    fun testTransactionSerializes()
    {
        val source = "budget/Transaction.json".readBufferedSource()
        val value = json.decodeFromBufferedSource<Transaction>(source)

        assertEquals("My Transaction ID", value.id)
    }

    @Test
    fun testTransactionResponseSerializes()
    {
        val source = "budget/TransactionResponse.json".readBufferedSource()
        val valueResponse = json.decodeFromBufferedSource<Response<Transaction>>(source)

        require(valueResponse is Response.Ok<Transaction>)
        assertEquals("My Transaction ID", valueResponse.data.id)
    }
}