package com.nurozkaya.searchingapp.repository

import androidx.lifecycle.MutableLiveData
import com.nurozkaya.searchingapp.entity.Items
import com.nurozkaya.searchingapp.entity.ItemsResponse
import com.nurozkaya.searchingapp.retrofit.ApiUtils
import com.nurozkaya.searchingapp.retrofit.ItemsDaoInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ItemsDaoRepository {

    private val itemsList:MutableLiveData<List<Items>> = MutableLiveData()
    private val idaoi:ItemsDaoInterface = ApiUtils.getItemsDaoInterface()


    fun bringItems(): MutableLiveData<List<Items>> {
        return itemsList
    }


    fun getAllItems() {
        idaoi.allItems().enqueue(object : Callback<ItemsResponse> {

            override fun onResponse(
                call: Call<ItemsResponse>?,
                response: Response<ItemsResponse>
            ) {
                val list=response.body().items
                itemsList.value=list
            }

            override fun onFailure(call: Call<ItemsResponse>?, t: Throwable?) {
                println(t?.localizedMessage.toString())
            }
        })
    }

    fun getMovies() {
        idaoi.searchMovies().enqueue(object : Callback<ItemsResponse> {

            override fun onResponse(
                call: Call<ItemsResponse>?,
                response: Response<ItemsResponse>
            ) {
                val list=response.body().items
                itemsList.value=list
            }

            override fun onFailure(call: Call<ItemsResponse>?, t: Throwable?) {
                println(t?.localizedMessage.toString())
            }
        })
    }

    fun getMusic() {
        idaoi.searchMusic().enqueue(object : Callback<ItemsResponse> {

            override fun onResponse(
                call: Call<ItemsResponse>?,
                response: Response<ItemsResponse>
            ) {
                val list=response.body().items
                itemsList.value=list
            }

            override fun onFailure(call: Call<ItemsResponse>?, t: Throwable?) {
                println(t?.localizedMessage.toString())
            }
        })
    }

    fun getApps() {
        idaoi.searchApps().enqueue(object : Callback<ItemsResponse> {

            override fun onResponse(
                call: Call<ItemsResponse>?,
                response: Response<ItemsResponse>
            ) {
                val list=response.body().items
                itemsList.value=list
            }

            override fun onFailure(call: Call<ItemsResponse>?, t: Throwable?) {
                println(t?.localizedMessage.toString())
            }
        })
    }

    fun getBooks() {
        idaoi.searchBooks().enqueue(object : Callback<ItemsResponse> {

            override fun onResponse(
                call: Call<ItemsResponse>?,
                response: Response<ItemsResponse>
            ) {
                val list=response.body().items
                itemsList.value=list
            }

            override fun onFailure(call: Call<ItemsResponse>?, t: Throwable?) {
                println(t?.localizedMessage.toString())
            }
        })
    }


    fun searchItem(searchText:String) {
        idaoi.searchItem(searchText).enqueue(object :Callback<ItemsResponse> {
            override fun onResponse(
                call: Call<ItemsResponse>?,
                response: Response<ItemsResponse>
            ) {
                val list=response.body().items
                itemsList.value=list
            }

            override fun onFailure(call: Call<ItemsResponse>?, t: Throwable?) {
                println(t?.localizedMessage.toString())
            }
        })
    }
}