package dev.danperez.ynab.json.user

import dev.danperez.ynab.json.BaseJsonTest
import dev.danperez.ynab.json.Response
import dev.danperez.ynab.json.readBufferedSource
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.okio.decodeFromBufferedSource
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalSerializationApi::class)
class TestUser: BaseJsonTest()
{
    @Test
    fun testUserSerializes()
    {
        val source = "user/User.json".readBufferedSource()
        val user = json.decodeFromBufferedSource<User>(source)

        assertEquals("0", user.id)
    }

    @Test
    fun testUserResponseSerializes()
    {
        val source = "user/UserResponse.json".readBufferedSource()
        val userMessage = json.decodeFromBufferedSource<Response<User>>(source)

        require(userMessage is Response.Ok<User>)
        assertEquals("0", userMessage.data.id)
    }
}