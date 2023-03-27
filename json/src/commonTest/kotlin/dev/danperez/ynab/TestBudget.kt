package dev.danperez.ynab

import dev.danperez.ynab.budget.Budget
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