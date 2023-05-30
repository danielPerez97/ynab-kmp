package dev.danperez.ynab.json.account

import dev.danperez.ynab.json.BaseJsonTest
import kotlinx.serialization.encodeToString
import kotlin.test.Test
import kotlin.test.assertEquals

class TestNewAccount: BaseJsonTest()
{
    @Test
    fun testNewAccountSerializesCorrectly()
    {
        val newAccount = NewAccount(name = "string", type = "checking", balance = 0)
        val newAccountJson = json.encodeToString(newAccount)

        assertEquals("""
            {
                "account": {
                    "name": "string",
                    "type": "checking",
                    "balance": 0
                }
            }
        """.trimIndent(), newAccountJson)
    }
}