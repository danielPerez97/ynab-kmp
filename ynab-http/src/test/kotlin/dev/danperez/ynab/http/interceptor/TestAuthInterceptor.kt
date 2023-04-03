package dev.danperez.ynab.http.interceptor

import dev.danperez.ynab.http.interceptor.AuthInterceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import java.util.concurrent.TimeUnit

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestAuthInterceptor
{
    private lateinit var server: MockWebServer
    private val client = OkHttpClient.Builder()
        .addInterceptor(AuthInterceptor("test"))
        .readTimeout(1, TimeUnit.SECONDS)
        .build()

    @BeforeAll
    fun setup()
    {
        server = MockWebServer()
        server.start()
    }

    @Test
    fun testTokenAddedToRequest()
    {
        val server = MockWebServer()
        server.start()
        server.enqueue(MockResponse().setResponseCode(200))
        val serverUrl = server.url("/")

        val request = Request.Builder()
            .url(serverUrl)
            .build()
        client.newCall(request).execute()

        val recordedRequest = server.takeRequest()
        val header = recordedRequest.getHeader("Authorization")

        assertTrue { header != null }
        assertEquals("Bearer test", header)
    }

    @AfterAll
    fun teardown()
    {
        server.shutdown()
    }
}