package dev.danperez.ynab.budget

import dev.danperez.ynab.BaseJsonTest
import dev.danperez.ynab.Response
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
        val source = "budget/Budget.json".readBufferedSource()
        val budget = json.decodeFromBufferedSource<Budget>(source)

        assertEquals("My Budget", budget.name)
    }

    @Test
    fun testBudgetResponseSerializes()
    {
        val source = "budget/BudgetResponse.json".readBufferedSource()
        val userMessage = json.decodeFromBufferedSource<Response<Budget>>(source)

        require(userMessage is Response.Ok<Budget>)
        assertEquals("My Budget", userMessage.data.name)
    }
}