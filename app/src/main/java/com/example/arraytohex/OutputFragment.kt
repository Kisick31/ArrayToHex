package com.example.arraytohex

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.arraytohex.ByteToHex.toHexString
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class OutputFragment : Fragment() {

    private lateinit var textViewArrayInHex: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_output, container, false)
        textViewArrayInHex = view.findViewById(R.id.textViewArrayInHex)

        val arrayLength = arguments?.getInt("length")
        if (arrayLength != null) {
            val byteArray = ByteArray(arrayLength) {
                ((Math.random() * Byte.MAX_VALUE * 2).toInt() - Byte.MAX_VALUE).toByte()
            }

            CoroutineScope(Dispatchers.IO).launch {
                val hexArray = toHexString(byteArray)

                launch(Dispatchers.Main) {
                    textViewArrayInHex.text = hexArray
                }
            }
        }

        return view
    }


}