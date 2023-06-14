package dev.danperez.ynab.json

import dev.danperez.ynab.json.internal.ResponseSerializer
import kotlinx.serialization.Serializable

@Serializable(with = ResponseSerializer::class)
sealed class Response<out T>
{
    @Serializable
    data class Ok<out T>(
        val data: T,
        val serverKnowledge: Int? = null,
    ): Response<T>()

    @Serializable
    data class Error(
        val id: String,
        val name: String,
        val detail: String,
    ): Response<Nothing>()
}