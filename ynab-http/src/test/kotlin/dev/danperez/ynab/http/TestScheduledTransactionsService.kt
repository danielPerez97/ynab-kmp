package dev.danperez.ynab.http

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test

@OptIn(ExperimentalCoroutinesApi::class)
class TestScheduledTransactionsService: BaseServiceTest<ScheduledTransactionsService>(ScheduledTransactionsService::class.java)
{
    @Test
    fun testGetScheduledTransactions() = runTest {
        enqueueResponse("scheduledtransactions/ScheduledTransactions.json", 200)
        val response = service.getScheduledTransactions("fake budget id")
    }

    @Test
    fun testGetScheduledTransactionById() = runTest {
        enqueueResponse("scheduledtransactions/ScheduledTransaction.json", 200)
        val response = service.getScheduledTransactionById("fake budget id", "fake scheduled transaction id")
    }
}