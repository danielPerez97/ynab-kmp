package dev.danperez.ynab.budget

import dev.danperez.ynab.BaseJsonTest
import dev.danperez.ynab.Response
import dev.danperez.ynab.readBufferedSource
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
        val debtEscrowAmountsMessage = json.decodeFromBufferedSource<Response<DebtInterestRates>>(source)

        require(debtEscrowAmountsMessage is Response.Ok<DebtInterestRates>)
        assertEquals(0, debtEscrowAmountsMessage.data.additionalProp1)
    }
}