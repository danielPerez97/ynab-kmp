package dev.danperez.ynab.http

import dev.danperez.ynab.json.Response
import dev.danperez.ynab.json.budget.MultiTransactionUpdate
import dev.danperez.ynab.json.budget.MultipleCreatableTransactions
import dev.danperez.ynab.json.budget.SingleCreatableTransaction
import dev.danperez.ynab.json.budget.SingleTransactionUpdate
import dev.danperez.ynab.json.budget.Transaction
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface TransactionsService
{
    /**
     * @param budgetId The id of the budget. “last-used” can be used to specify the last used budget and “default” can
     * be used if default budget selection is enabled (see: https://api.ynab.com/#oauth-default-budget).
     */
    @GET("/budgets/{budget_id}/transactions")
    suspend fun getTransactions(
        @Path("budget_id") budgetId: String,
    ): Response<List<Transaction>>

    /**
     * @param budgetId The id of the budget. “last-used” can be used to specify the last used budget and “default” can
     * be used if default budget selection is enabled (see: https://api.ynab.com/#oauth-default-budget).
     */
    @POST("/budgets/{budget_id}/transactions")
    suspend fun createSingleTransaction(
        @Path("budget_id") budgetId: String,
        @Body transaction: SingleCreatableTransaction,
    ): SingleTransactionUpdate

    /**
     * @param budgetId The id of the budget. “last-used” can be used to specify the last used budget and “default” can
     * be used if default budget selection is enabled (see: https://api.ynab.com/#oauth-default-budget).
     */
    @POST("/budgets/{budget_id}/transactions")
    suspend fun createMultipleTransactions(
        @Path("budget_id") budgetId: String,
        @Body transactions: MultipleCreatableTransactions,
    ): Response<MultiTransactionUpdate>

    /**
     * @param budgetId The id of the budget. “last-used” can be used to specify the last used budget and “default” can
     * be used if default budget selection is enabled (see: https://api.ynab.com/#oauth-default-budget).
     */
    @PATCH("/budgets/{budget_id}/transactions")
    suspend fun updateMultipleTransactions(
        @Path("budget_id") budgetId: String,
        @Body transactions: MultipleCreatableTransactions,
    ): Response<MultiTransactionUpdate>

    /**
     * Imports available transactions on all linked accounts for the given budget. Linked accounts allow transactions to
     * be imported directly from a specified financial institution and this endpoint initiates that import. Sending a
     * request to this endpoint is the equivalent of clicking “Import” on each account in the web application or tapping
     * the “New Transactions” banner in the mobile applications. The response for this endpoint contains the transaction
     * ids that have been imported.
     *
     * @param budgetId The id of the budget. “last-used” can be used to specify the last used budget and “default” can
     * be used if default budget selection is enabled (see: https://api.ynab.com/#oauth-default-budget).
     */
    @POST("/budgets/{budget_id}/transactions/import")
    suspend fun importTransactions(
        @Path("budget_id") budgetId: String,
    )

    /**
     * @param budgetId The id of the budget. “last-used” can be used to specify the last used budget and “default” can
     * be used if default budget selection is enabled (see: https://api.ynab.com/#oauth-default-budget).
     */
    @GET("/budgets/{budget_id}/transactions/{transaction_id}")
    suspend fun getTransactionById(
        @Path("budget_id") budgetId: String,
        @Path("transaction_id") transactionId: String,
    )

    /**
     * @param budgetId The id of the budget. “last-used” can be used to specify the last used budget and “default” can
     * be used if default budget selection is enabled (see: https://api.ynab.com/#oauth-default-budget).
     */
    @PUT("/budgets/{budget_id}/transactions/{transaction_id}")
    suspend fun updateTransaction(
        @Path("budget_id") budgetId: String,
        @Path("transaction_id") transactionId: String,
    )

    /**
     * @param budgetId The id of the budget. “last-used” can be used to specify the last used budget and “default” can
     * be used if default budget selection is enabled (see: https://api.ynab.com/#oauth-default-budget).
     */
    @DELETE("/budgets/{budget_id}/transactions/{transaction_id}")
    suspend fun deleteTransaction(
        @Path("budget_id") budgetId: String,
        @Path("transaction_id") transactionId: String,
    )

    /**
     * @param budgetId The id of the budget. “last-used” can be used to specify the last used budget and “default” can
     * be used if default budget selection is enabled (see: https://api.ynab.com/#oauth-default-budget).
     */
    @GET("/budgets/{budget_id}/accounts/{account_id}/transactions")
    suspend fun getAccountTransactions(
        @Path("budget_id") budgetId: String,
        @Path("account_id") accountId: String,
    )

    /**
     * @param budgetId The id of the budget. “last-used” can be used to specify the last used budget and “default” can
     * be used if default budget selection is enabled (see: https://api.ynab.com/#oauth-default-budget).
     */
    @GET("/budgets/{budget_id}/categories/{category_id}/transactions")
    suspend fun getCategoryTransactions(
        @Path("budget_id") budgetId: String,
        @Path("category_id") categoryId: String,
    )

    /**
     * @param budgetId The id of the budget. “last-used” can be used to specify the last used budget and “default” can
     * be used if default budget selection is enabled (see: https://api.ynab.com/#oauth-default-budget).
     */
    @GET("/budgets/{budget_id}/payees/{payee_id}/transactions")
    suspend fun getPayeeTransactions(
        @Path("budget_id") budgetId: String,
        @Path("payee_id") payeeId: String,
    )
}