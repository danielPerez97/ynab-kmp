package dev.danperez.ynab.http

import dev.danperez.ynab.json.Response
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TestPayeesService: BaseServiceTest<PayeesService>(PayeesService::class.java)
{

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun testGetPayees() = runTest {
        enqueueResponse("payees/Payees.json", 200)
        val response = service.getPayees("fake budget id")

        require(response is Response.Ok)
        assertEquals(1, response.data.size)
    }

}