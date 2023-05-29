package dev.danperez.ynab.http

import dev.danperez.ynab.json.Response
import dev.danperez.ynab.json.user.User
import retrofit2.http.GET

interface UserService
{
    @GET("/v1/user")
    suspend fun getAuthenticatedUserInformation(): Response<User>
}