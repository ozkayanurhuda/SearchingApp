package com.nurozkaya.searchingapp.retrofit

import com.nurozkaya.searchingapp.entity.ItemsResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ItemsDaoInterface {
    @GET("items.php")
    fun allItems(): Call<ItemsResponse>

    @POST("searchItem.php")
    @FormUrlEncoded
    fun searchItem(@Field("item_name") item_name:String):Call<ItemsResponse>

    @GET("movies.php")
    @FormUrlEncoded
    fun searchMovies():Call<ItemsResponse>

    @GET("music.php")
    @FormUrlEncoded
    fun searchMusic():Call<ItemsResponse>

    @GET("books.php")
    @FormUrlEncoded
    fun searchBooks():Call<ItemsResponse>

    @GET("apps.php")
    @FormUrlEncoded
    fun searchApps():Call<ItemsResponse>


}