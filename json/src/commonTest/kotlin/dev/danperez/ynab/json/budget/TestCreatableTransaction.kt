package dev.danperez.ynab.json.budget

import dev.danperez.ynab.json.BaseJsonTest
import kotlinx.serialization.encodeToString
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TestCreatableTransaction: BaseJsonTest()
{
    @Test
    fun testCreatableTransactionSerializesCorrectly()
    {
        val creatableTransaction = SingleCreatableTransaction(
            CreatableTransaction(
                accountId = "string",
                date = "string",
                amount = 0,
                payeeId = "string",
                payeeName = "string",
                categoryId = "string",
                memo = "string",
                cleared = "string",
                approved = true,
                flagColor = "red",
                importId = "string",
                subtransactions = emptyList()
            )
        )
        val newAccountJson = json.encodeToString(creatableTransaction)

        assertEquals("""
        {
            "transaction": {
                "account_id": "string",
                "date": "string",
                "amount": 0,
                "payee_id": "string",
                "payee_name": "string",
                "category_id": "string",
                "memo": "string",
                "cleared": "string",
                "approved": true,
                "flag_color": "red",
                "import_id": "string",
                "subtransactions": [
                ]
            }
        }
        """.trimIndent(), newAccountJson)
    }

    @Test
    fun testCreatableTransactionsSerializesCorrectly()
    {
        val creatableTransactions: MultipleCreatableTransactions = MultipleCreatableTransactions(listOf(
            CreatableTransaction(
                accountId = "string",
                date = "string",
                amount = 0,
                payeeId = "string",
                payeeName = "string",
                categoryId = "string",
                memo = "string",
                cleared = "string",
                approved = true,
                flagColor = "red",
                importId = "string",
                subtransactions = emptyList()
            )
        )
        )
        val wrappedCreatableTransactionsJson = json.encodeToString(creatableTransactions)

        assertEquals("""
        {
            "transactions": [
                {
                    "account_id": "string",
                    "date": "string",
                    "amount": 0,
                    "payee_id": "string",
                    "payee_name": "string",
                    "category_id": "string",
                    "memo": "string",
                    "cleared": "string",
                    "approved": true,
                    "flag_color": "red",
                    "import_id": "string",
                    "subtransactions": [
                    ]
                }
            ]
        }
        """.trimIndent(), wrappedCreatableTransactionsJson)
    }
}