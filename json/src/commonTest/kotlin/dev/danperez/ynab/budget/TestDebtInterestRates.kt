package dev.danperez.ynab.budget

import dev.danperez.ynab.BaseJsonTest
import dev.danperez.ynab.Response
import dev.danperez.ynab.readBufferedSource
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.okio.decodeFromBufferedSource
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalSerializationApi::class)
class TestDebtInterestRates: BaseJsonTest()
{

    @Test
    fun testDebtInterestRateSerializes()
    {
        val source = "budget/DebtInterestRates.json".readBufferedSource()
        val debtInterestRate = json.decodeFromBufferedSource<DebtInterestRates>(source)

        assertEquals(0, debtInterestRate.additionalProp1)
    }

    @Test
    fun testDebtInterestRateResponseSerializes()
    {
        val source = "budget/DebtInterestRatesResponse.json".readBufferedSource()
        val debtInterestRateMessage = json.decodeFromBufferedSource<Response<DebtInterestRates>>(source)

        require(debtInterestRateMessage is Response.Ok<DebtInterestRates>)
        assertEquals(0, debtInterestRateMessage.data.additionalProp1)
    }
}