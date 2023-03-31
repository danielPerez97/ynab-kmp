package dev.danperez.ynab.budget

import dev.danperez.ynab.BaseJsonTest
import dev.danperez.ynab.Response
import dev.danperez.ynab.readBufferedSource
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.okio.decodeFromBufferedSource
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalSerializationApi::class)
class TestScheduledSubtransaction: BaseJsonTest()
{

    @Test
    fun testScheduledSubtransactionSerializes()
    {
        val source = "budget/ScheduledSubtransaction.json".readBufferedSource()
        val value = json.decodeFromBufferedSource<ScheduledSubtransaction>(source)

        assertEquals("My Scheduled Subtransaction ID", value.id)
    }

    @Test
    fun testScheduledSubtransactionResponseSerializes()
    {
        val source = "budget/ScheduledSubtransactionResponse.json".readBufferedSource()
        val valueResponse = json.decodeFromBufferedSource<Response<ScheduledSubtransaction>>(source)

        require(valueResponse is Response.Ok<ScheduledSubtransaction>)
        assertEquals("My Scheduled Subtransaction ID", valueResponse.data.id)
    }
}