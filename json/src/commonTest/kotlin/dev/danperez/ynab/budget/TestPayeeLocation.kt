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
    fun testPayeeLocationSerializes()
    {
        val source = "budget/PayeeLocation.json".readBufferedSource()
        val value = json.decodeFromBufferedSource<PayeeLocation>(source)

        assertEquals("My Payee ID", value.payeeId)
    }

    @Test
    fun testPayeeLocationResponseSerializes()
    {
        val source = "budget/PayeeLocationResponse.json".readBufferedSource()
        val valueResponse = json.decodeFromBufferedSource<Response<PayeeLocation>>(source)

        require(valueResponse is Response.Ok<PayeeLocation>)
        assertEquals("My Payee ID", valueResponse.data.payeeId)
    }
}