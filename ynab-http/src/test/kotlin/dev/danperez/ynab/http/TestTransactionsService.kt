package dev.danperez.ynab.http

import dev.danperez.ynab.json.OptionalProperty
import dev.danperez.ynab.json.budget.CreatableTransaction
import dev.danperez.ynab.json.budget.MultipleCreatableTransactions
import dev.danperez.ynab.json.budget.SingleCreatableTransaction
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

@OptIn(ExperimentalCoroutinesApi::class)
class TestTransactionsService: BaseServiceTest<TransactionsService>(TransactionsService::class.java)
{
    @Test
    fun testGetTransactions() = runTest {
        enqueueResponse("transactions/Transactions.json", 200)
        val response = service.getTransactions("fake budget id")
        val request = mockWebServer.takeRequest()

        // Verify the outgoing request
        assertEquals(request.path, "/budgets/fake%20budget%20id/transactions")
    }

    @Test
    fun testCreateSingleTransaction() = runTest {
        enqueueResponse("transactions/Transaction.json", 200)
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
        val response = service.createSingleTransaction("fake budget id", creatableTransaction)
        val request = mockWebServer.takeRequest()

        assertEquals("/budgets/fake%20budget%20id/transactions", request.path)
        assertEquals("POST", request.method)
        assertEquals("application/json; charset=utf-8", request.headers["Content-Type"])
        assertEquals(
            """
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
        """.trimIndent(), request.body.readUtf8()
        )
    }

    @Test
    fun testCreateMultipleTransactions() = runTest {
        enqueueResponse("transactions/MultiTransactionUpdateResponse.json", 200)
        val creatableTransactions = MultipleCreatableTransactions(
            listOf(
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
        val response = service.createMultipleTransactions("fake budget id", creatableTransactions)
        val request = mockWebServer.takeRequest()

        assertEquals("/budgets/fake%20budget%20id/transactions", request.path)
        assertEquals("POST", request.method)
        assertEquals("application/json; charset=utf-8", request.headers["Content-Type"])
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
        """.trimIndent(), request.body.readUtf8())
    }

    @Test
    fun testUpdateMultipleTransactions() = runTest {
        enqueueResponse("transactions/MultiTransactionUpdateResponse.json", 200)
        val updates = MultipleCreatableTransactions(
            listOf(
                CreatableTransaction(
                    id = OptionalProperty.Present("string"),
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
            ),
        )
        val response = service.updateMultipleTransactions("fake budget id", updates)
        val request = mockWebServer.takeRequest()
        assertEquals("""
            {
                "transactions": [
                    {
                        "id": "string",
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
        """.trimIndent(), request.body.readUtf8())
    }

    @Test
    fun testImportTransactions() = runTest {
//        enqueueResponse(MockResponse())
//        val updates = MultiTransactionUpdate(
//            listOf(
//                Transaction.Lite(
//                    id = OptionalProperty.Present("string"),
//                    accountId = "string",
//                    date = "string",
//                    amount = 0,
//                    payeeId = "string",
//                    payeeName = "string",
//                    categoryId = "string",
//                    memo = "string",
//                    cleared = "cleared",
//                    approved = true,
//                    flagColor = "red",
//                    importId = "string",
//                )
//            )
//        )
//        val response = service.importTransactions("fake budget id")
//        val request = mockWebServer.takeRequest()
//        assertEquals("""
//            {
//                "transactions": [
//                    {
//                        "id": "string",
//                        "date": "string",
//                        "amount": 0,
//                        "memo": "string",
//                        "cleared": "cleared",
//                        "approved": true,
//                        "flag_color": "red",
//                        "account_id": "string",
//                        "payee_id": "string",
//                        "category_id": "string",
//                        "import_id": "string",
//                        "payee_name": "string"
//                    }
//                ]
//            }
//        """.trimIndent(), request.body.readUtf8())
        TODO()
    }

    @Test
    fun testGetTransactionById() = runTest {
        TODO()
    }

    @Test
    fun testUpdateTransaction() = runTest {
        TODO()
    }

    @Test
    fun testDeleteTransactions() = runTest {
        TODO()
    }

    @Test
    fun testGetAccountTransactions() = runTest {
        TODO()
    }

    @Test
    fun testGetCategoryTransactions() = runTest {
        TODO()
    }

    @Test
    fun testGetPayeeTransactions() = runTest {
        TODO()
    }
}