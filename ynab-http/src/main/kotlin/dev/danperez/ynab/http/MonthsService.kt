package dev.danperez.ynab.http

import dev.danperez.ynab.json.Response
import dev.danperez.ynab.json.budget.Month
import retrofit2.http.GET
import retrofit2.http.Path

interface MonthsService
{

    /**
     * @param budgetId The id of the budget. “last-used” can be used to specify the last used budget and “default” can
     * be used if default budget selection is enabled (see: https://api.ynab.com/#oauth-default-budget).
     */
    @GET("/budgets/{budget_id}/months")
    suspend fun getMonths(@Path("budget_id") budgetId: String): Response<List<Month>>


    /**
     * @param budgetId The id of the budget. “last-used” can be used to specify the last used budget and “default” can
     * be used if default budget selection is enabled (see: https://api.ynab.com/#oauth-default-budget).
     * @param month The budget month in ISO format (e.g. 2016-12-01) (“current” can also be used to specify the current
     * calendar month (UTC))
     */
    @GET("/budgets/{budget_id}/months/{month}")
    suspend fun getMonthById(@Path("budget_id") budgetId: String, @Path("month") month: String): Response<Month>
}