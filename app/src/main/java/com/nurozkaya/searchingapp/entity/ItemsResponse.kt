package com.nurozkaya.searchingapp.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ItemsResponse (@SerializedName("items")
                          @Expose
                          var items:List<Items>,

                          @SerializedName("success")
                          @Expose
                          var success:Int) {
}