package dev.danperez.ynab.budget

import dev.danperez.ynab.BaseJsonTest
import dev.danperez.ynab.Response
import dev.danperez.ynab.readBufferedSource
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.okio.decodeFromBufferedSource
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalSerializationApi::class)
class TestCategory: BaseJsonTest()
{

    @Test
    fun testCategorySerializes()
    {
        val source = "budget/Category.json".readBufferedSource()
        val category = json.decodeFromBufferedSource<Category>(source)

        assertEquals("string", category.name)
    }

    @Test
    fun testCategoryResponseSerializes()
    {
        val source = "budget/CategoryResponse.json".readBufferedSource()
        val userMessage = json.decodeFromBufferedSource<Response<Category>>(source)

        require(userMessage is Response.Ok<Category>)
        assertEquals("string", userMessage.data.name)
    }
}