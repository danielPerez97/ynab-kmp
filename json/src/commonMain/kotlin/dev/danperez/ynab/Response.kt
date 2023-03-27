package dev.danperez.ynab

import dev.danperez.ynab.internal.MessageSerializer
import kotlinx.serialization.Serializable

@Serializable(with = MessageSerializer::class)
sealed class Response<out T>
{
    data class Ok<out T>(val data: T): Response<T>()
    data class Error(
        val id: String,
        val name: String,
        val detail: String,
    ): Response<Nothing>()
}