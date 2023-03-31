package dev.danperez.ynab

import dev.danperez.ynab.internal.ResponseSerializer
import kotlinx.serialization.Serializable

@Serializable(with = ResponseSerializer::class)
sealed class Response<out T>
{
    data class Ok<out T>(
        val data: T,
        val serverKnowledge: Int? = null,
    ): Response<T>()
    data class Error(
        val id: String,
        val name: String,
        val detail: String,
    ): Response<Nothing>()
}