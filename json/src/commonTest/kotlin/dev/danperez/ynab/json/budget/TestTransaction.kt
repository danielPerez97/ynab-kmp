package dev.danperez.ynab.json.budget

import dev.danperez.ynab.json.BaseJsonTest
import dev.danperez.ynab.json.OptionalProperty
import dev.danperez.ynab.json.readBufferedSource
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

        require(value.id is OptionalProperty.Present)
        assertEquals("My Transaction ID", (value.id as OptionalProperty.Present).value)
    }

    @Test
    fun testTransactionFullSerializes()
    {
        val source = "budget/TransactionFull.json".readBufferedSource()
        val valueResponse = json.decodeFromBufferedSource<Transaction>(source)

        require(valueResponse is Transaction.TransactionFull)
        assertEquals("My TransactionFull ID", (valueResponse.id as OptionalProperty.Present).value)
    }
}