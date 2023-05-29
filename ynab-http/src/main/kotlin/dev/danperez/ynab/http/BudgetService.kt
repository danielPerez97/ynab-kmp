package dev.danperez.ynab.http

import dev.danperez.ynab.json.Response
import dev.danperez.ynab.json.budget.Budget
import retrofit2.http.GET

interface BudgetService
{
    @GET("/budgets")
    suspend fun getBudgets(): Response<List<Budget>>
}