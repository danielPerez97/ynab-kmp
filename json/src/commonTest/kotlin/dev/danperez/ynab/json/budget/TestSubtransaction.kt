package dev.danperez.ynab.json.budget

import dev.danperez.ynab.json.BaseJsonTest
import dev.danperez.ynab.json.Response
import dev.danperez.ynab.json.readBufferedSource
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.okio.decodeFromBufferedSource
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalSerializationApi::class)
class TestSubtransaction: BaseJsonTest()
{

    @Test
    fun testSubtransactionSerializes()
    {
        val source = "budget/Subtransaction.json".readBufferedSource()
        val value = json.decodeFromBufferedSource<Subtransaction>(source)

        assertEquals("My Subtransaction", value.id)
    }

    @Test
    fun testSubtransactionResponseSerializes()
    {
        val source = "budget/SubtransactionResponse.json".readBufferedSource()
        val valueResponse = json.decodeFromBufferedSource<Response<Subtransaction>>(source)

        require(valueResponse is Response.Ok<Subtransaction>)
        assertEquals("My Subtransaction", valueResponse.data.id)
    }
}