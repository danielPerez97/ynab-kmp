package dev.danperez.ynab.internal

import dev.danperez.ynab.BaseJsonTest
import dev.danperez.ynab.Response
import dev.danperez.ynab.budget.Payee
import dev.danperez.ynab.readBufferedSource
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.okio.decodeFromBufferedSource
import okio.BufferedSource
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

@OptIn(ExperimentalSerializationApi::class)
class TestMessageSerializer: BaseJsonTest()
{
    @Test
    fun testMessageSerializerOk()
    {
        val source: BufferedSource = "internal/DataResponse.json".readBufferedSource()
        json.decodeFromBufferedSource<Response<List<Payee>>>(source)
    }

    @Test
    fun testMessageSerializerError()
    {
        val source: BufferedSource = "internal/DataErrorResponse.json".readBufferedSource()
        val response: Response<List<Payee>> = json.decodeFromBufferedSource(source)

        assertTrue { response is Response.Error }
        val error = response as Response.Error

        assertEquals("123", error.id)
        assertEquals("error_name", error.name)
        assertEquals("Error detail", error.detail)
    }
}