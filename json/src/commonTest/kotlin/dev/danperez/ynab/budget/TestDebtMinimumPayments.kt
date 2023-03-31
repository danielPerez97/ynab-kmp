package dev.danperez.ynab.budget

import dev.danperez.ynab.BaseJsonTest
import dev.danperez.ynab.Response
import dev.danperez.ynab.readBufferedSource
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.okio.decodeFromBufferedSource
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalSerializationApi::class)
class TestDebtMinimumPayments: BaseJsonTest()
{

    @Test
    fun testDebtMinimumPaymentsSerializes()
    {
        val source = "budget/DebtMinimumPayments.json".readBufferedSource()
        val debtMinimumPayments = json.decodeFromBufferedSource<DebtInterestRates>(source)

        assertEquals(0, debtMinimumPayments.additionalProp1)
    }

    @Test
    fun testDebtMinimumPaymentsResponseSerializes()
    {
        val source = "budget/DebtMinimumPaymentsResponse.json".readBufferedSource()
        val debtMinimumPaymentsMessage = json.decodeFromBufferedSource<Response<DebtInterestRates>>(source)

        require(debtMinimumPaymentsMessage is Response.Ok<DebtInterestRates>)
        assertEquals(0, debtMinimumPaymentsMessage.data.additionalProp1)
    }
}