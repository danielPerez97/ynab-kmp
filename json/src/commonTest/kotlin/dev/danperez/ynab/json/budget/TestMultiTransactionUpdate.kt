package dev.danperez.ynab.json.budget

import dev.danperez.ynab.json.BaseJsonTest
import dev.danperez.ynab.json.Response
import dev.danperez.ynab.json.readBufferedSource
import kotlinx.serialization.json.okio.decodeFromBufferedSource
import org.junit.jupiter.api.Test

class TestMultiTransactionUpdate: BaseJsonTest()
{
    @Test
    fun testMultiTransactionUpdateDeserializesCorrectly()
    {
        val source = "budget/MultiTransactionUpdate.json".readBufferedSource()
        val response = json.decodeFromBufferedSource<MultiTransactionUpdate>(source)
    }

    @Test
    fun testMultiTransactionUpdateResponseDeserializesCorrectly()
    {
        val source = "budget/MultiTransactionUpdateResponse.json".readBufferedSource()
        val response = json.decodeFromBufferedSource<Response<MultiTransactionUpdate>>(source)
    }
}