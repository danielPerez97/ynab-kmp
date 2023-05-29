package dev.danperez.ynab.json.budget

import dev.danperez.ynab.json.BaseJsonTest
import dev.danperez.ynab.json.readBufferedSource
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.okio.decodeFromBufferedSource
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalSerializationApi::class)
class TestBudgetSettings: BaseJsonTest()
{

    @Test
    fun testBudgetSettingsSerializes()
    {
        val source = "budget/BudgetSettings.json".readBufferedSource()
        val value = json.decodeFromBufferedSource<BudgetSettings>(source)

        assertEquals("My Budget Settings Currency Format ISO Code", value.currencyFormat.isoCode)
    }
}