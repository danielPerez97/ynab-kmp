package dev.danperez.ynab.http

import dev.danperez.ynab.json.Response
import dev.danperez.ynab.json.account.Account
import retrofit2.http.GET
import retrofit2.http.Path

interface AccountService
{
    @GET("/budget/{budget_id}/accounts")
    suspend fun getBudgetSettings(@Path("budget_id") budgetId: String): Response<List<Account>>
}