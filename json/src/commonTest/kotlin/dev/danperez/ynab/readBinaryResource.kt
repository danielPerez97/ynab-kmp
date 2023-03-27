package dev.danperez.ynab

import okio.BufferedSource

/**
 * Retrieves a buffered source from a file name.
 * Example: val bufferedSource = "budget.json".toBufferedSource()
 *
 * @return Returns an [okio.BufferedSource] to read from for fast serialization/deserialization.
 */
expect fun String.readBufferedSource(): BufferedSource