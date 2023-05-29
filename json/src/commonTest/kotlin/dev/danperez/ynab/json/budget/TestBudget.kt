package dev.danperez.ynab.json.budget

import dev.danperez.ynab.json.BaseJsonTest
import dev.danperez.ynab.json.Response
import dev.danperez.ynab.json.readBufferedSource
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.okio.decodeFromBufferedSource
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalSerializationApi::class)
class TestBudget: BaseJsonTest()
{

    @Test
    fun testBudgetLiteSerializes()
    {
        val source = "budget/BudgetLite.json".readBufferedSource()
        val value = json.decodeFromBufferedSource<Budget>(source)

        assertEquals("My Budget", value.name)
    }

    @Test
    fun testBudgetResponseSerializes()
    {
        val source = "budget/BudgetLiteResponse.json".readBufferedSource()
        val valueResponse = json.decodeFromBufferedSource<Response<Budget>>(source)
        require(valueResponse is Response.Ok<Budget>)
        assertEquals("My Budget", valueResponse.data.name)
    }
}