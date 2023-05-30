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
    /**
     * @param budgetId The id of the budget. “last-used” can be used to specify the last used budget and “default” can
     * be used if default budget selection is enabled (see: https://api.ynab.com/#oauth-default-budget).
     */
    @GET("/budget/{budget_id}/accounts")
    suspend fun getAccounts(@Path("budget_id") budgetId: String): Response<List<Account>>

    /**
     * @param budgetId The id of the budget. “last-used” can be used to specify the last used budget and “default” can
     * be used if default budget selection is enabled (see: https://api.ynab.com/#oauth-default-budget).
     * @param newAccount The account to create.
     */
    @POST("/budget/{budget_id}/accounts")
    suspend fun createAccount(@Path("budget_id") budgetId: String, @Body newAccount: NewAccount): Response<Account>

    /**
     * @param budgetId The id of the budget. “last-used” can be used to specify the last used budget and “default” can
     * be used if default budget selection is enabled (see: https://api.ynab.com/#oauth-default-budget).
     * @param accountId The id of the account.
     */
    @GET("/budget/{budget_id}/accounts/{account_id}")
    suspend fun getAccountById(@Path("budget_id") budgetId: String, @Path("account_id") accountId: String): Response<Account>
}