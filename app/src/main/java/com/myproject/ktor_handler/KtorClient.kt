package com.myproject.ktor_handler

import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.features.HttpTimeout
import io.ktor.client.features.defaultRequest
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.features.logging.Logger
import io.ktor.client.features.logging.Logging
import io.ktor.client.request.accept
import io.ktor.http.ContentType
import io.ktor.http.contentType
import kotlinx.serialization.json.Json

object KtorClient {

    val json = Json {
        //When set to true, this property formats the JSON output with indentation
        // and line breaks, making it more human-readable.
        prettyPrint = true

        //This property determines whether the JSON parser should be lenient or strict when parsing JSON
        // content. When set to true, the parser is forgiving of non-standard JSON syntax,
        // such as missing quotes around keys or single quotes instead of double quotes
        isLenient = true


        useAlternativeNames = true

        //When set to true, this property tells the JSON parser to ignore any JSON object keys that
        // do not correspond to properties in the target Kotlin class during deserialization.
        // This is helpful when dealing with JSON payloads that may contain additional fields not relevant to your application.
        ignoreUnknownKeys = true


        //This property determines whether default values of Kotlin properties should be encoded
        // during serialization. When set to true, default values are included in the JSON output
        encodeDefaults = false
    }

    val httpClient = HttpClient(Android) {

        install(Logging) {
            logger = object : Logger {
                override fun log(message: String) {
                    print("Log =========> $message")
                }
            }
        }

        install(HttpTimeout) {
            requestTimeoutMillis = 30000
            connectTimeoutMillis = 30000
            socketTimeoutMillis = 30000
        }

        install(JsonFeature) {
            serializer = KotlinxSerializer(json)
        }

        defaultRequest {
            contentType(ContentType.Application.Json)
            accept(ContentType.Application.Json)
        }


    }

}