package com.example.youtubesecond.data.model

data class MainResponseYoutube (
    val kind:String,
    val etag: String,
    val nextPageToken: String,
    val pageInfo: PageInfo,
    val items: List<Items>
)



data class PageInfo(
   val totalResults:String,
   val resultPerPage : String
)




data class Items(
    val kind: String,
    val etag: String,
    val id : String
)
