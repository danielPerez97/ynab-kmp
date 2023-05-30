package dev.danperez.ynab.http

import dev.danperez.ynab.json.Response
import dev.danperez.ynab.json.budget.ScheduledTransaction
import retrofit2.http.GET
import retrofit2.http.Path

interface ScheduledTransactionsService
{

    /**
     * @param budgetId The id of the budget. “last-used” can be used to specify the last used budget and “default” can
     * be used if default budget selection is enabled (see: https://api.ynab.com/#oauth-default-budget).
     */
    @GET("/budgets/{budget_id}/scheduled_transactions")
    suspend fun getScheduledTransactions(@Path("budget_id") budgetId: String): Response<List<ScheduledTransaction>>

    /**
     * @param budgetId The id of the budget. “last-used” can be used to specify the last used budget and “default” can
     * be used if default budget selection is enabled (see: https://api.ynab.com/#oauth-default-budget).
     * @param scheduledTransactionId The id of the scheduled transaction.
     */
    @GET("/budgets/{budget_id}/scheduled_transactions/{scheduled_transaction_id}")
    suspend fun getScheduledTransactionById(@Path("budget_id") budgetId: String, @Path("scheduled_transaction_id") scheduledTransactionId: String): Response<ScheduledTransaction>
}