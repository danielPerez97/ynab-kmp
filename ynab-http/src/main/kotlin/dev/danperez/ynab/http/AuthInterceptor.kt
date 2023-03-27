package dev.danperez.ynab.http

import okhttp3.Interceptor
import okhttp3.Response

/**
 * Takes a YNAB Access token and plugs it into an OkHttp Interceptor.
 */
class AuthInterceptor(val token: String): Interceptor
{
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val newRequest = request.newBuilder()
            .addHeader("Authorization", "Bearer $token")
            .build()

        return chain.proceed(newRequest)
    }

}