package dev.danperez.ynab.budget

import dev.danperez.ynab.BaseJsonTest
import dev.danperez.ynab.Response
import dev.danperez.ynab.readBufferedSource
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
        val value = json.decodeFromBufferedSource<ScheduledTransaction>(source)

        assertEquals("My Scheduled Transaction ID", value.id)
    }

    @Test
    fun testScheduledTransactionResponseSerializes()
    {
        val source = "budget/ScheduledTransactionResponse.json".readBufferedSource()
        val valueResponse = json.decodeFromBufferedSource<Response<ScheduledTransaction>>(source)

        require(valueResponse is Response.Ok<ScheduledTransaction>)
        assertEquals("My Scheduled Transaction ID", valueResponse.data.id)
    }
}