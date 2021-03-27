package com.example.arraytohex

object ByteToHex {
    fun ByteArray.toHexString(): String {
        return joinToString("") {
            "%02X".format(it)
        }
    }
}