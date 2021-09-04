package com.nurozkaya.searchingapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nurozkaya.searchingapp.entity.Items
import com.nurozkaya.searchingapp.repository.ItemsDaoRepository

class SearchScreenViewModel : ViewModel(){

    var itemsList= MutableLiveData<List<Items>>()
    var idaor=ItemsDaoRepository()

    init {
        loadItems()
        itemsList=idaor.bringItems()
    }

    fun loadItems() {
        idaor.getAllItems()
    }

    fun searchItem(searchText:String) {
        idaor.searchItem(searchText)
    }

    fun searchMusic() {
        idaor.getMusic()
    }

    fun searchApps() {
        idaor.getApps()
    }

    fun searchMovies() {
        idaor.getMovies()
    }

    fun searchBooks() {
        idaor.getBooks()
    }
}