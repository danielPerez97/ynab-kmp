package dev.danperez.ynab.http

import dev.danperez.ynab.json.Response
import dev.danperez.ynab.json.budget.PayeeLocation
import retrofit2.http.GET
import retrofit2.http.Path

interface PayeeLocationsService
{
    /**
     * @param budgetId The id of the budget. “last-used” can be used to specify the last used budget and “default” can
     * be used if default budget selection is enabled (see: https://api.ynab.com/#oauth-default-budget).
     */
    @GET("/budgets/{budget_id}/payee_locations")
    suspend fun getPayeeLocations(
        @Path("budget_id") budgetId: String,
    ): Response<List<PayeeLocation>>

    /**
     * @param budgetId The id of the budget. “last-used” can be used to specify the last used budget and “default” can
     * be used if default budget selection is enabled (see: https://api.ynab.com/#oauth-default-budget).
     * @param payeeLocationId id of payee location
     */
    @GET("/budgets/{budget_id}/payee_locations/{payee_location_id}")
    suspend fun getPayeeLocationById(
        @Path("budget_id") budgetId: String,
        @Path("payee_location_id") payeeLocationId: String,
    ): Response<PayeeLocation>

    /**
     * @param budgetId The id of the budget. “last-used” can be used to specify the last used budget and “default” can
     * be used if default budget selection is enabled (see: https://api.ynab.com/#oauth-default-budget).
     * @param payeeId id of payee
     */
    @GET("/budgets/{budget_id}/payees/{payee_id}/payee_locations")
    suspend fun getLocationsForPayee(
        @Path("budget_id") budgetId: String,
        @Path("payee_id") payeeId: String,
    ): Response<List<PayeeLocation>>
}