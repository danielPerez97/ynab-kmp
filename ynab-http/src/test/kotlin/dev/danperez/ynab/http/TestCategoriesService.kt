package dev.danperez.ynab.http

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test

@OptIn(ExperimentalCoroutinesApi::class)
class TestCategoriesService: BaseServiceTest<CategoriesService>(CategoriesService::class.java)
{
    @Test
    fun testGetCategories() = runTest {
        enqueueResponse("categories/CategoryGroups.json", 200)
        service.getCategories("fake budget id")
    }

    @Test
    fun testGetCategoryById() = runTest {
        enqueueResponse("categories/Category.json", 200)
        service.getCategoryById("fake budget id", "fake category id")
    }

    @Test
    fun testGetCategoryForMonth() = runTest {
        enqueueResponse("categories/Category.json", 200)
        service.getCategoryForMonth("fake budget id", "2016-12-01", "fake category id")
    }

    @Test
    fun testUpdateCategoryForMonth() = runTest {
        enqueueResponse("categories/Category.json", 200)
        service.updateCategoryForMonth("fake budget id", "2016-12-01", "fake category id")
    }
}