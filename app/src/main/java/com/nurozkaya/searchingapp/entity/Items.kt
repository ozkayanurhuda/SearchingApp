package com.nurozkaya.searchingapp.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Items(@SerializedName("artworkUrl100")
                 @Expose
                 var artWorkUrl:String,

                 @SerializedName("collectionPrice")
                 @Expose
                 var collectionPrice:String,

                 @SerializedName("collectionName")
                 @Expose
                 var collectionName:String,

                 @SerializedName("releaseDate")
                 @Expose
                 var releaseDate:String
):Serializable {
}