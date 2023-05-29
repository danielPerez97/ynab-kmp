package dev.danperez.ynab.json.account

import dev.danperez.ynab.json.BaseJsonTest
import dev.danperez.ynab.json.Response
import dev.danperez.ynab.json.readBufferedSource
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.okio.decodeFromBufferedSource
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalSerializationApi::class)
class TestAccount: BaseJsonTest()
{
    @Test
    fun testAccountSerializes()
    {
        val source = "account/Account.json".readBufferedSource()
        val account = json.decodeFromBufferedSource<Account>(source)

        assertEquals("string", account.id)
    }

    @Test
    fun testAccountResponseSerializes()
    {
        val source = "account/AccountResponse.json".readBufferedSource()
        val accountMessage = json.decodeFromBufferedSource<Response<Account>>(source)

        require(accountMessage is Response.Ok<Account>)
        assertEquals("string", accountMessage.data.id)
    }
}