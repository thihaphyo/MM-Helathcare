package com.padc.mmhelathcare.data.vos

import com.google.gson.annotations.SerializedName

/**
 *
 * Created by Phyo Thiha on 7/10/18.
 */
class HealthCareInfoVO {
    @SerializedName("id")
    val id: Int = 0
    @SerializedName("title")
    val title: String = ""
    @SerializedName("image")
    val image: String = ""
    @SerializedName("author")
    val author: AuthorVO? = null
    @SerializedName("short-description")
    val shortDescription: String = ""
    @SerializedName("published-date")
    val publishedDate: String = ""
    @SerializedName("complete-url")
    val completedUrl:String = ""
    @SerializedName("info-type")
    val infoType: String = ""
}