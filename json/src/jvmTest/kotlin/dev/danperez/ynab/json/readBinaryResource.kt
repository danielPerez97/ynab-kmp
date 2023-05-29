package dev.danperez.ynab.json

import okio.BufferedSource
import okio.buffer
import okio.source

actual fun String.readBufferedSource(): BufferedSource {
    return ClassLoader
        .getSystemResourceAsStream(this)!!
        .source()
        .buffer()
}