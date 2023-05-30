package dev.danperez.ynab.http

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test

@OptIn(ExperimentalCoroutinesApi::class)
class TestMonthsService: BaseServiceTest<MonthsService>(MonthsService::class.java)
{
    @Test
    fun testGetMonths() = runTest {
        enqueueResponse("months/Months.json", 200)
        val response = service.getMonths("fake budget id")
    }

    @Test
    fun testGetMonth() = runTest {
        enqueueResponse("months/Month.json", 200)
        val response = service.getMonthById("fake budget id", "month")
    }
}