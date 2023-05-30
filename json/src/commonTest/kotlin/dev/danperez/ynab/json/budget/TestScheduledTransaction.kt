package dev.danperez.ynab.json.budget

import dev.danperez.ynab.json.BaseJsonTest
import dev.danperez.ynab.json.Response
import dev.danperez.ynab.json.readBufferedSource
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.okio.decodeFromBufferedSource
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalSerializationApi::class)
class TestScheduledTransaction: BaseJsonTest()
{

    @Test
    fun testScheduledTransactionSerializes()
    {
        val source = "budget/ScheduledTransaction.json".readBufferedSource()
        val value = json.decodeFromBufferedSource<ScheduledTransactionLite>(source)

        assertEquals("My Scheduled Transaction ID", value.id)
    }

    @Test
    fun testScheduledTransactionResponseSerializes()
    {
        val source = "budget/ScheduledTransactionResponse.json".readBufferedSource()
        val valueResponse = json.decodeFromBufferedSource<Response<ScheduledTransactionLite>>(source)

        require(valueResponse is Response.Ok<ScheduledTransactionLite>)
        assertEquals("My Scheduled Transaction ID", valueResponse.data.id)
    }
}