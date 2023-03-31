package dev.danperez.ynab.budget

import dev.danperez.ynab.BaseJsonTest
import dev.danperez.ynab.readBufferedSource
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.okio.decodeFromBufferedSource
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalSerializationApi::class)
class TestBudget: BaseJsonTest()
{

    @Test
    fun testBudgetSerializes()
    {
        val source = "Budget.json".readBufferedSource()
        val budget = json.decodeFromBufferedSource<Budget>(source)

        assertEquals("My Budget", budget.name)
    }
}