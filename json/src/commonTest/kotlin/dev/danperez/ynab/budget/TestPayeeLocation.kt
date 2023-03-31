package dev.danperez.ynab.budget

import dev.danperez.ynab.BaseJsonTest
import dev.danperez.ynab.Response
import dev.danperez.ynab.readBufferedSource
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.okio.decodeFromBufferedSource
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalSerializationApi::class)
class TestPayeeLocation: BaseJsonTest()
{

    @Test
    fun testPayeeSerializes()
    {
        val source = "budget/PayeeLocation.json".readBufferedSource()
        val payee = json.decodeFromBufferedSource<PayeeLocation>(source)

        assertEquals("My Payee ID", payee.payeeId)
    }

    @Test
    fun testPayeeResponseSerializes()
    {
        val source = "budget/PayeeLocationResponse.json".readBufferedSource()
        val userMessage = json.decodeFromBufferedSource<Response<PayeeLocation>>(source)

        require(userMessage is Response.Ok<PayeeLocation>)
        assertEquals("My Payee ID", userMessage.data.payeeId)
    }
}