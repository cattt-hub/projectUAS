package com.example.projectuas

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SearchFragment : Fragment() {

    private lateinit var searchInput: EditText
    private lateinit var searchButton: Button
    private lateinit var searchResults: RecyclerView
    private lateinit var adapter: SearchResultsAdapter
    private var resultsList: MutableList<String> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_search, container, false)

        searchInput = view.findViewById(R.id.search_input)
        searchButton = view.findViewById(R.id.search_button)
        searchResults = view.findViewById(R.id.search_results)

        adapter = SearchResultsAdapter(resultsList)
        searchResults.layoutManager = LinearLayoutManager(context)
        searchResults.adapter = adapter

        searchButton.setOnClickListener { performSearch() }

        return view
    }

    private fun performSearch() {
        val query = searchInput.text.toString().trim()
        if (TextUtils.isEmpty(query)) {
            Toast.makeText(context, "Please enter a search term", Toast.LENGTH_SHORT).show()
            return
        }

        // Simulasi pencarian
        resultsList.clear()
        resultsList.add("Result 1 for $query")
        resultsList.add("Result 2 for $query")
        resultsList.add("Result 3 for $query")
        adapter.notifyDataSetChanged()
    }
}