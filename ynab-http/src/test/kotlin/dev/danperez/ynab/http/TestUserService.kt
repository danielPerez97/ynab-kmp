package dev.danperez.ynab.http

import dev.danperez.ynab.Response
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

@Suppress("JUnitMixedFramework")
class TestUserService: BaseServiceTest<UserService>(UserService::class.java)
{

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun testUserServiceGetAuthInformation() = runTest {
        enqueueResponse("user/User.json", 200)
        val response = service.getAuthenticatedUserInformation()

        require(response is Response.Ok)
        assertEquals(0L, response.data.id.toLong())
    }
}