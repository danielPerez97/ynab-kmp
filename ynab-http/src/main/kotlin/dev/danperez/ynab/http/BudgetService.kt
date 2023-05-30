package dev.danperez.ynab.http

import dev.danperez.ynab.json.Response
import dev.danperez.ynab.json.budget.Budget
import dev.danperez.ynab.json.budget.BudgetSettings
import retrofit2.http.GET
import retrofit2.http.Path

interface BudgetService
{
    @GET("/budgets")
    suspend fun getBudgets(): Response<List<Budget>>

    @GET("/budget/{budget_id}")
    suspend fun getBudget(@Path("budget_id") budgetId: String): Response<Budget>

    @GET("/budget/{budget_id}/settings")
    suspend fun getBudgetSettings(@Path("budget_id") budgetId: String): Response<BudgetSettings>
}