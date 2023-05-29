package dev.danperez.ynab.json.budget

import dev.danperez.ynab.json.BaseJsonTest
import dev.danperez.ynab.json.Response
import dev.danperez.ynab.json.readBufferedSource
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
        val value = json.decodeFromBufferedSource<DebtInterestRates>(source)

        assertEquals(0, value.additionalProp1)
    }

    @Test
    fun testDebtMinimumPaymentsResponseSerializes()
    {
        val source = "budget/DebtMinimumPaymentsResponse.json".readBufferedSource()
        val valueResponse = json.decodeFromBufferedSource<Response<DebtInterestRates>>(source)

        require(valueResponse is Response.Ok<DebtInterestRates>)
        assertEquals(0, valueResponse.data.additionalProp1)
    }
}