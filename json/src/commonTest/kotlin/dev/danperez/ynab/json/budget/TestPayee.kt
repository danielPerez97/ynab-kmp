package dev.danperez.ynab.json.budget

import dev.danperez.ynab.json.BaseJsonTest
import dev.danperez.ynab.json.Response
import dev.danperez.ynab.json.readBufferedSource
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
        val value = json.decodeFromBufferedSource<Payee>(source)

        assertEquals("My Payee", value.name)
    }

    @Test
    fun testPayeeResponseSerializes()
    {
        val source = "budget/PayeeResponse.json".readBufferedSource()
        val valueResponse = json.decodeFromBufferedSource<Response<Payee>>(source)

        require(valueResponse is Response.Ok<Payee>)
        assertEquals("My Payee", valueResponse.data.name)
    }
}