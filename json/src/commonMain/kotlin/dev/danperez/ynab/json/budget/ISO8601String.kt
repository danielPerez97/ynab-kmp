package dev.danperez.ynab.json.budget

import kotlinx.serialization.Serializable

@Serializable
@JvmInline
value class ISO8601String(val date: String)