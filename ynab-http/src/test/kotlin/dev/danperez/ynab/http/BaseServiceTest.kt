package dev.danperez.ynab.http

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.BufferedSource
import okio.buffer
import okio.source
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.TestInstance
import retrofit2.Retrofit
import java.nio.charset.StandardCharsets
import java.util.concurrent.TimeUnit

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
abstract class BaseServiceTest<T>(`class`: Class<T>)
{
    private val mockWebServer = MockWebServer()

    private val client = OkHttpClient.Builder()
        .connectTimeout(1, TimeUnit.SECONDS)
        .readTimeout(1, TimeUnit.SECONDS)
        .writeTimeout(1, TimeUnit.SECONDS)
        .build()

    private val mediaType = "application/json".toMediaType()

    private val json = Json

    private val retrofit = Retrofit.Builder()
        .baseUrl(mockWebServer.url("/"))
        .client(client)
        .addConverterFactory(json.asConverterFactory(mediaType))
        .build()

    val service: T = retrofit.create(`class`)

    @AfterAll
    fun tearDown() {
        mockWebServer.shutdown()
    }

    protected fun enqueueResponse(fileName: String, code: Int) {
        val source = ClassLoader
            .getSystemResourceAsStream("api-responses/$fileName")!!
            .source()
            .buffer()

        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(code)
                .setBody(source.readString(StandardCharsets.UTF_8))
        )
    }

    private fun String.readBufferedSource(): BufferedSource {
        return ClassLoader
            .getSystemResourceAsStream(this)!!
            .source()
            .buffer()
    }
}