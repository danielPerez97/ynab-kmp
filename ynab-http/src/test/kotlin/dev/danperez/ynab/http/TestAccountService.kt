package dev.danperez.ynab.http

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test

@OptIn(ExperimentalCoroutinesApi::class)
class TestAccountService: BaseServiceTest<AccountService>(AccountService::class.java)
{
    @Test
    fun testGetAccounts() = runTest {
        enqueueResponse("account/Accounts.json", 200)
        val response = service.getAccounts("fake budget id")
    }

    @Test
    fun testGetAccountById() = runTest {
        enqueueResponse("account/Account.json", 200)
        val response = service.getAccountById("fake budget id", "fake account id")
    }
}