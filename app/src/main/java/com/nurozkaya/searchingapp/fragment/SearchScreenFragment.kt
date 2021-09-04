package com.nurozkaya.searchingapp.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.nurozkaya.searchingapp.R
import com.nurozkaya.searchingapp.adapter.ItemsAdapter
import com.nurozkaya.searchingapp.databinding.FragmentSearchScreenBinding
import com.nurozkaya.searchingapp.viewmodel.SearchScreenViewModel


class SearchScreenFragment : Fragment(), SearchView.OnQueryTextListener {

    private lateinit var design:FragmentSearchScreenBinding
    private lateinit var adapter:ItemsAdapter
    private lateinit var viewModel:SearchScreenViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setHasOptionsMenu(true)

        val temp:SearchScreenViewModel by viewModels()
        viewModel=temp
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        design=DataBindingUtil.inflate(inflater, R.layout.fragment_search_screen, container, false)
        design.searchScreenFragment=this

        design.rv.layoutManager=GridLayoutManager(requireContext(),2)

        (activity as AppCompatActivity).setSupportActionBar(design.toolbarHome)
        design.searchScreenToolbarTitle="Search"

        viewModel.itemsList.observe(viewLifecycleOwner, {itemsList ->
            adapter= ItemsAdapter(requireContext(), itemsList)
            design.adapter=adapter
        })

        design.chipApps.setOnClickListener {
            viewModel.searchApps()
        }

        design.chipBooks.setOnClickListener {
            viewModel.searchBooks()
        }

        design.chipMovies.setOnClickListener {
            viewModel.searchMovies()
        }

        design.chipMusic.setOnClickListener {
            viewModel.searchMusic()
        }
        return design.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.toolbar_search,menu)
        val item=menu.findItem(R.id.action_search)
        val searchView=item.actionView as SearchView
        searchView.setOnQueryTextListener(this)
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        viewModel.searchItem(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        viewModel.searchItem(newText)
        return true
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadItems()
    }
}