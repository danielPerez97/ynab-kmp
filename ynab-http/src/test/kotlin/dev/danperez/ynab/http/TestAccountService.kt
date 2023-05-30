package dev.danperez.ynab.http

import dev.danperez.ynab.json.account.NewAccount
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
    fun testPostAccount() = runTest {
        enqueueResponse("account/Account.json", 200)
        val newAccount = NewAccount(name = "Test", type = "test", balance = 0)
        val response = service.createAccount("fake budget id", newAccount)
    }

    @Test
    fun testGetAccountById() = runTest {
        enqueueResponse("account/Account.json", 200)
        val response = service.getAccountById("fake budget id", "fake account id")
    }
}