package dev.danperez.ynab

import kotlinx.serialization.json.Json

abstract class BaseJsonTest {
    val json = Json {
        prettyPrint = true
    }
}
