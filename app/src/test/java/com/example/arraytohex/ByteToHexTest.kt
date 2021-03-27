package com.example.arraytohex

import com.example.arraytohex.ByteToHex.toHexString
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.junit.Test

class ByteToHexTest {

    @Test
    fun `checking the correctness of calculations`() {
        val byteArray = byteArrayOf(35, 111, 20, 87, 92)
        GlobalScope.launch {
            val result = toHexString(byteArray)
            assertThat(result).isEqualTo("236F14575C")
        }
    }
}