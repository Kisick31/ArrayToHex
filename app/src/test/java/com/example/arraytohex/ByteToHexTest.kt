package com.example.arraytohex

import com.example.arraytohex.ByteToHex.toHexString
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class ByteToHexTest {

    @Test
    fun toHexString() {
        val byteArray = byteArrayOf(35, 111, 20, 87, 92)
        val result = byteArray.toHexString()
        assertThat(result).isEqualTo("236F14575C")
    }
}