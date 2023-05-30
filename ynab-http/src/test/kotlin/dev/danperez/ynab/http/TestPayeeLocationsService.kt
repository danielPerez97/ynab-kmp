package dev.danperez.ynab.http

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test

@OptIn(ExperimentalCoroutinesApi::class)
class TestPayeeLocationsService: BaseServiceTest<PayeeLocationsService>(PayeeLocationsService::class.java)
{
    @Test
    fun testGetPayeeLocations() = runTest {
        enqueueResponse("payeelocations/PayeeLocations.json", 200)
        service.getPayeeLocations("fake budget id")
    }

    @Test
    fun testGetPayeeLocationById() = runTest {
        enqueueResponse("payeelocations/PayeeLocation.json", 200)
        service.getPayeeLocationById("fake budget id", "fake payee location id")
    }

    @Test
    fun testGetLocationsForPayee() = runTest {
        enqueueResponse("payeelocations/LocationsForPayee.json", 200)
        service.getLocationsForPayee("fake budget id", "fake payee id")
    }
}