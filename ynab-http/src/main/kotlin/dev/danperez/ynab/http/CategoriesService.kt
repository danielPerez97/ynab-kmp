package dev.danperez.ynab.http

import dev.danperez.ynab.json.Response
import dev.danperez.ynab.json.budget.Category
import dev.danperez.ynab.json.budget.CategoryGroup
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.Path

interface CategoriesService
{
    /**
     * @param budgetId The id of the budget. “last-used” can be used to specify the last used budget and “default” can
     * be used if default budget selection is enabled (see: https://api.ynab.com/#oauth-default-budget).
     */
    @GET("/budget/{budget_id}/categories")
    suspend fun getCategories(
        @Path("budget_id") budgetId: String,
    ): Response<List<CategoryGroup>>

    /**
     * @param budgetId The id of the budget. “last-used” can be used to specify the last used budget and “default” can
     * be used if default budget selection is enabled (see: https://api.ynab.com/#oauth-default-budget).
     *
     * @param categoryId The id of the category
     */
    @GET("/budget/{budget_id}/categories/{category_id}")
    suspend fun getCategoryById(
        @Path("budget_id") budgetId: String,
        @Path("category_id") categoryId: String,
    ): Response<Category>

    /**
     * @param budgetId The id of the budget. “last-used” can be used to specify the last used budget and “default” can
     * be used if default budget selection is enabled (see: https://api.ynab.com/#oauth-default-budget).
     *
     * @param month The budget month in ISO format (e.g. 2016-12-01) (“current” can also be used to specify the current calendar month (UTC))
     *
     * @param categoryId The id of the category
     */
    @GET("/budget/{budget_id}/months/{month}/categories/{category_id}")
    suspend fun getCategoryForMonth(
        @Path("budget_id") budgetId: String,
        @Path("month") month: String,
        @Path("category_id") categoryId: String,
    ): Response<Category>

    /**
     * @param budgetId The id of the budget. “last-used” can be used to specify the last used budget and “default” can
     * be used if default budget selection is enabled (see: https://api.ynab.com/#oauth-default-budget).
     *
     * @param month The budget month in ISO format (e.g. 2016-12-01) (“current” can also be used to specify the current calendar month (UTC))
     *
     * @param categoryId The id of the category
     */
    @PATCH("/budget/{budget_id}/months/{month}/categories/{category_id}")
    suspend fun updateCategoryForMonth(
        @Path("budget_id") budgetId: String,
        @Path("month") month: String,
        @Path("category_id") categoryId: String,
    ): Response<Category>
}