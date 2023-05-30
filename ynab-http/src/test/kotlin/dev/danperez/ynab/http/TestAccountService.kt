package dev.danperez.ynab.http

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test

@OptIn(ExperimentalCoroutinesApi::class)
class TestAccountService: BaseServiceTest<AccountService>(AccountService::class.java)
{
    @Test
    fun testGetBudgetSettings() = runTest {
        enqueueResponse("account/Account.json", 200)
        val response = service.getBudgetSettings("fake budget id")
    }
}