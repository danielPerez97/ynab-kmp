package dev.danperez.ynab.budget

import dev.danperez.ynab.BaseJsonTest
import dev.danperez.ynab.Response
import dev.danperez.ynab.readBufferedSource
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.okio.decodeFromBufferedSource
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalSerializationApi::class)
class TestMonth: BaseJsonTest()
{

    @Test
    fun testMonthSerializes()
    {
        val source = "budget/Month.json".readBufferedSource()
        val value = json.decodeFromBufferedSource<Month>(source)

        assertEquals("April", value.month)
    }

    @Test
    fun testMonthResponseSerializes()
    {
        val source = "budget/MonthResponse.json".readBufferedSource()
        val valueResponse = json.decodeFromBufferedSource<Response<Month>>(source)

        require(valueResponse is Response.Ok<Month>)
        assertEquals("April", valueResponse.data.month)
    }
}