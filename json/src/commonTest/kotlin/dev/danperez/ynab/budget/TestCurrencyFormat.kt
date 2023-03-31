package dev.danperez.ynab.budget

import dev.danperez.ynab.BaseJsonTest
import dev.danperez.ynab.Response
import dev.danperez.ynab.readBufferedSource
import dev.danperez.ynab.user.User
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
        val source = "CurrencyFormat.json".readBufferedSource()
        val currencyFormat = json.decodeFromBufferedSource<CurrencyFormat>(source)

        assertEquals("USD", currencyFormat.isoCode)
    }

    @Test
    fun testCurrencyFormatResponseSerializes()
    {
        val source = "CurrencyFormatResponse.json".readBufferedSource()
        val userMessage = json.decodeFromBufferedSource<Response<CurrencyFormat>>(source)

        require(userMessage is Response.Ok<CurrencyFormat>)
        assertEquals("USD", userMessage.data.isoCode)
    }
}