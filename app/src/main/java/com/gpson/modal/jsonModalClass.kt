package com.gpson.modal


import com.gpson.GeneriAdapter.GenericAdapter
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class jsonModalClass(
    @Json(name = "pets")
    val pets: List<Pet?>?
)

 {
    @JsonClass(generateAdapter = true)
    data class Pet(
        @Json(name = "content_url")
        val contentUrl: String?,
        @Json(name = "date_added")
        val dateAdded: String?,
        @Json(name = "image_url")
        val imageUrl: String?,
        @Json(name = "title")
        val title: String?
    ): ListItemViewModel()
}
abstract class ListItemViewModel{
    var adapterPosition: Int = -1
    var onListItemViewClickListener: GenericAdapter.OnListItemViewClickListener? = null
}
