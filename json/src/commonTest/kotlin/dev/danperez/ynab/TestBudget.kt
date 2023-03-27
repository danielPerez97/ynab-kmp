package dev.danperez.ynab

import dev.danperez.ynab.budget.Budget
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.okio.decodeFromBufferedSource
import kotlin.test.Test

@OptIn(ExperimentalSerializationApi::class)
class TestBudget: BaseJsonTest()
{

    @Test
    fun testBudgetSerializes()
    {
        val source = "budget.json".readBufferedSource()
        json.decodeFromBufferedSource<Budget>(source)
    }
}