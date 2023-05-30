package dev.danperez.ynab.http

import dev.danperez.ynab.json.Response
import dev.danperez.ynab.json.budget.Budget
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals

class TestBudgetService: BaseServiceTest<BudgetService>(BudgetService::class.java)
{

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun testGetBudgets() = runTest {
        enqueueResponse("budget/Budgets.json", 200)
        val response = service.getBudgets()

        require(response is Response.Ok)
        require(response.data.first() is Budget.BudgetData)
        assertEquals(1, response.data.size)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun testGetBudget() = runTest {
        enqueueResponse("budget/Budget.json", 200)
        val response = service.getBudget("fake budget id")

        require(response is Response.Ok)
        require(response.data is Budget.BudgetData)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun testGetBudgetSettings() = runTest {
        enqueueResponse("budget/BudgetSettings.json", 200)
        val response = service.getBudgetSettings("fake budget id")

        require(response is Response.Ok)
    }

}