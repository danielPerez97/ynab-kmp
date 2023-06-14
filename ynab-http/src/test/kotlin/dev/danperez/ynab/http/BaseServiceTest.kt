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
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.TestInstance
import retrofit2.Retrofit
import java.nio.charset.StandardCharsets
import java.util.concurrent.TimeUnit

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
abstract class BaseServiceTest<T: Any>(val serviceClass: Class<T>)
{

    protected val mockWebServer = MockWebServer()
    protected lateinit var service: T

    @BeforeEach
    fun setup() {
        val client = OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.SECONDS)
            .readTimeout(1, TimeUnit.SECONDS)
            .writeTimeout(1, TimeUnit.SECONDS)
            .build()

        val mediaType = "application/json; charset=utf-8".toMediaType()

        val json = Json {
            prettyPrint = true
        }

        val retrofit = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .client(client)
            .addConverterFactory(json.asConverterFactory(mediaType))
            .build()

        service = retrofit.create(serviceClass)
    }

    @AfterEach
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

    protected fun enqueueResponse(mockResponse: MockResponse) {
        mockWebServer.enqueue(mockResponse)
    }

    private fun String.readBufferedSource(): BufferedSource {
        return ClassLoader
            .getSystemResourceAsStream(this)!!
            .source()
            .buffer()
    }
}