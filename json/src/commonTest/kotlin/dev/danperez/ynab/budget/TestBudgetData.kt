package dev.danperez.ynab.budget

import dev.danperez.ynab.BaseJsonTest
import dev.danperez.ynab.Response
import dev.danperez.ynab.readBufferedSource
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.okio.decodeFromBufferedSource
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalSerializationApi::class)
class TestBudgetData: BaseJsonTest()
{

    @Test
    fun testBudgetDataSerializes()
    {
        val source = "budget/BudgetData.json".readBufferedSource()
        val value = json.decodeFromBufferedSource<Budget.BudgetData>(source)

        assertEquals("My Budget Data Budget ID", value.id)
    }

    @Test
    fun testBudgetDataResponseSerializes()
    {
        val source = "budget/BudgetDataResponse.json".readBufferedSource()
        val valueResponse = json.decodeFromBufferedSource<Response<Budget.BudgetData>>(source)

        require(valueResponse is Response.Ok<Budget.BudgetData>)
        assertEquals("My Budget Data Budget ID", valueResponse.data.id)
        assertEquals<Int?>(0, valueResponse.serverKnowledge)
    }
}