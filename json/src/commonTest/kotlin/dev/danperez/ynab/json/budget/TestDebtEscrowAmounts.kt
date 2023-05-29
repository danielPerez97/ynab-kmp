package dev.danperez.ynab.json.budget

import dev.danperez.ynab.json.BaseJsonTest
import dev.danperez.ynab.json.Response
import dev.danperez.ynab.json.readBufferedSource
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.okio.decodeFromBufferedSource
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalSerializationApi::class)
class TestDebtEscrowAmounts: BaseJsonTest()
{

    @Test
    fun testDebtEscrowAmountsSerializes()
    {
        val source = "budget/DebtEscrowAmounts.json".readBufferedSource()
        val debtEscrowAmounts = json.decodeFromBufferedSource<DebtInterestRates>(source)

        assertEquals(0, debtEscrowAmounts.additionalProp1)
    }

    @Test
    fun testDebtEscrowAmountsResponseSerializes()
    {
        val source = "budget/DebtEscrowAmountsResponse.json".readBufferedSource()
        val valueResponse = json.decodeFromBufferedSource<Response<DebtInterestRates>>(source)

        require(valueResponse is Response.Ok<DebtInterestRates>)
        assertEquals(0, valueResponse.data.additionalProp1)
    }
}