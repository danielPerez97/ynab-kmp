package dev.danperez.ynab.json.budget

import dev.danperez.ynab.json.BaseJsonTest
import dev.danperez.ynab.json.Response
import dev.danperez.ynab.json.readBufferedSource
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.okio.decodeFromBufferedSource
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalSerializationApi::class)
class TestCurrencyFormat: BaseJsonTest()
{

    @Test
    fun testCurrencyFormatSerializes()
    {
        val source = "budget/CurrencyFormat.json".readBufferedSource()
        val value = json.decodeFromBufferedSource<CurrencyFormat>(source)

        assertEquals("USD", value.isoCode)
    }

    @Test
    fun testCurrencyFormatResponseSerializes()
    {
        val source = "budget/CurrencyFormatResponse.json".readBufferedSource()
        val valueResponse = json.decodeFromBufferedSource<Response<CurrencyFormat>>(source)

        require(valueResponse is Response.Ok<CurrencyFormat>)
        assertEquals("USD", valueResponse.data.isoCode)
    }
}