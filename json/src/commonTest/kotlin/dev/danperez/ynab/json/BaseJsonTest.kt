package dev.danperez.ynab.json

import kotlinx.serialization.json.Json

abstract class BaseJsonTest {
    val json = Json {
        prettyPrint = true
    }
}
