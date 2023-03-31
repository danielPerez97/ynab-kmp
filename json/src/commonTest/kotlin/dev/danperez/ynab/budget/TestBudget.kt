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
        val value = json.decodeFromBufferedSource<Budget>(source)

        assertEquals("My Budget", value.name)
    }

    @Test
    fun testBudgetResponseSerializes()
    {
        val source = "budget/BudgetResponse.json".readBufferedSource()
        val valueResponse = json.decodeFromBufferedSource<Response<Budget>>(source)

        require(valueResponse is Response.Ok<Budget>)
        assertEquals("My Budget", valueResponse.data.name)
    }
}