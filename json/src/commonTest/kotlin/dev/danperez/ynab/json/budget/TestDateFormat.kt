package dev.danperez.ynab.json.budget

import dev.danperez.ynab.json.BaseJsonTest
import dev.danperez.ynab.json.readBufferedSource
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.okio.decodeFromBufferedSource
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalSerializationApi::class)
class TestDateFormat: BaseJsonTest()
{

    @Test
    fun testDateFormatSerializes()
    {
        val source = "budget/DateFormat.json".readBufferedSource()
        val value = json.decodeFromBufferedSource<DateFormat>(source)

        assertEquals("MM/DD/YYYY", value.format)
    }
}