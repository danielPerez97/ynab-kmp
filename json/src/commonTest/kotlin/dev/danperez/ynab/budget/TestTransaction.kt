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
        val source = "budget/TransactionLite.json".readBufferedSource()
        val value = json.decodeFromBufferedSource<Transaction.Lite>(source)

        assertEquals("My Transaction ID", value.id)
    }

    @Test
    fun testTransactionFullSerializes()
    {
        val source = "budget/TransactionFull.json".readBufferedSource()
        val valueResponse = json.decodeFromBufferedSource<Transaction>(source)

        require(valueResponse is Transaction.TransactionFull)
        assertEquals("My TransactionFull ID", valueResponse.id)
    }
}