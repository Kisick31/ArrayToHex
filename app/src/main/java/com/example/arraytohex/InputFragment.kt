package com.example.arraytohex

import android.os.Bundle
import android.view.*
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController


class InputFragment : Fragment() {

    private lateinit var editTextArrayLength: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_input, container, false)
        editTextArrayLength = view.findViewById(R.id.editTextArrayLength)
        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.navigation_menu, menu)
        menu.getItem(0).isVisible = false
        menu.getItem(1).isVisible = false
        menu.getItem(2).isVisible = true
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val bundle = Bundle()
        if (editTextArrayLength.text.isNotEmpty()) {
            try {
                bundle.putInt("length", editTextArrayLength.text.toString().toInt())
                findNavController().navigate(R.id.action_inputFragment_to_outputFragment, bundle)
            } catch (e: NumberFormatException) {
                editTextArrayLength.text.clear()
                Toast.makeText(requireContext(), getString(R.string.catch_for_array_length_field), Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(requireContext(), getString(R.string.toast_empty_field), Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }
}