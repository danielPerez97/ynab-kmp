package dev.danperez.ynab.budget

import dev.danperez.ynab.BaseJsonTest
import dev.danperez.ynab.readBufferedSource
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.okio.decodeFromBufferedSource
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalSerializationApi::class)
class TestCategoryGroup: BaseJsonTest()
{

    @Test
    fun testCategoryGroupSerializes()
    {
        val source = "budget/CategoryGroup.json".readBufferedSource()
        val value = json.decodeFromBufferedSource<CategoryGroup>(source)
        require(value is CategoryGroup.Lite)

        assertEquals("My Category Group Name", value.name)
    }

    @Test
    fun testCategoryGroupWithCategoriesSerializes()
    {
        val source = "budget/CategoryGroupWithCategories.json".readBufferedSource()
        val valueResponse = json.decodeFromBufferedSource<CategoryGroup>(source)

        require(valueResponse is CategoryGroup.WithCategories)
        assertEquals("My Category Group Name With Categories", valueResponse.name)
    }
}