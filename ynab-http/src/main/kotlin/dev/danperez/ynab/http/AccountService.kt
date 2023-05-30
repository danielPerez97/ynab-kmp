package dev.danperez.ynab.http

import dev.danperez.ynab.json.Response
import dev.danperez.ynab.json.account.Account
import dev.danperez.ynab.json.account.NewAccount
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface AccountService
{
    @GET("/budget/{budget_id}/accounts")
    suspend fun getAccounts(@Path("budget_id") budgetId: String): Response<List<Account>>

    @POST("/budget/{budget_id}/accounts")
    suspend fun createAccount(@Path("budget_id") budgetId: String, @Body newAccount: NewAccount): Response<Account>

    @GET("/budget/{budget_id}/accounts/{account_id}")
    suspend fun getAccountById(@Path("budget_id") budgetId: String, @Path("account_id") accountId: String): Response<Account>
}