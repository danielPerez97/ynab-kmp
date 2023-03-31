package dev.danperez.ynab.budget

import dev.danperez.ynab.BaseJsonTest
import dev.danperez.ynab.Response
import dev.danperez.ynab.readBufferedSource
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.okio.decodeFromBufferedSource
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalSerializationApi::class)
class TestPayee: BaseJsonTest()
{

    @Test
    fun testPayeeSerializes()
    {
        val source = "budget/Payee.json".readBufferedSource()
        val Payee = json.decodeFromBufferedSource<Payee>(source)

        assertEquals("My Payee", Payee.name)
    }

    @Test
    fun testPayeeResponseSerializes()
    {
        val source = "budget/PayeeResponse.json".readBufferedSource()
        val userMessage = json.decodeFromBufferedSource<Response<Payee>>(source)

        require(userMessage is Response.Ok<Payee>)
        assertEquals("My Payee", userMessage.data.name)
    }
}