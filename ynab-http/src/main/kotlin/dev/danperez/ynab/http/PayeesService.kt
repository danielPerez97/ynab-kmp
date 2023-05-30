package dev.danperez.ynab.http

import dev.danperez.ynab.json.Response
import dev.danperez.ynab.json.budget.Payee
import retrofit2.http.GET
import retrofit2.http.Path

interface PayeesService
{
    @GET("/budget/{budget_id}/payees")
    suspend fun getPayees(@Path("budget_id") budgetId: String): Response<List<Payee>>

    @GET("/budget/{budget_id}/payees/{payee_id}")
    suspend fun getPayeesById(@Path("budget_id") budgetId: String, @Path("payee_id") payeeId: String): Response<Payee>
}