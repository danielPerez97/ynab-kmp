package dev.danperez.ynab.http

import dev.danperez.ynab.Response
import dev.danperez.ynab.user.User
import retrofit2.http.GET

interface UserService
{
    @GET("/v1/user")
    suspend fun getAuthenticatedUserInformation(): Response<User>
}