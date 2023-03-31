package dev.danperez.ynab.user

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id: String,
)