package com.example.arraytohex

import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

object ByteToHex {
    suspend fun toHexString(byteArray: ByteArray): String {
        return suspendCoroutine { continuation ->
            val file = byteArray.joinToString("") {
                String.format("%02X", (it.toInt() and 0xFF))
            }
            continuation.resume(file)
        }
    }
}
