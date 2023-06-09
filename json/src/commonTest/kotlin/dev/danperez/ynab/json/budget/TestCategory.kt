package dev.danperez.ynab.json.budget

import dev.danperez.ynab.json.BaseJsonTest
import dev.danperez.ynab.json.Response
import dev.danperez.ynab.json.readBufferedSource
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
        val categoryResponse = json.decodeFromBufferedSource<Response<Category>>(source)

        require(categoryResponse is Response.Ok<Category>)
        assertEquals("string", categoryResponse.data.name)
    }
}