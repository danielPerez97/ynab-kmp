package dev.danperez.ynab.budget

import dev.danperez.ynab.BaseJsonTest
import dev.danperez.ynab.readBufferedSource
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