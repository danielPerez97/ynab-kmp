package dev.danperez.ynab.http

import dev.danperez.ynab.json.Response
import dev.danperez.ynab.json.budget.Budget
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TestBudgetService: BaseServiceTest<BudgetService>(BudgetService::class.java)
{
    @Test
    fun testGetBudgets() = runTest {
        enqueueResponse("budget/Budgets.json", 200)
        val response = service.getBudgets()

        require(response is Response.Ok)
        require(response.data.first() is Budget.BudgetData)
        assertEquals(1, response.data.size)
    }
}