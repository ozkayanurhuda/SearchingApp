package com.nurozkaya.searchingapp.retrofit

class ApiUtils {
    companion object{
        val BASE_URL = "https://developer.apple.com/"

        fun getItemsDaoInterface(): ItemsDaoInterface {
            return RetrofitClient.getClient(BASE_URL)
                .create(ItemsDaoInterface::class.java)
        }


    }
}