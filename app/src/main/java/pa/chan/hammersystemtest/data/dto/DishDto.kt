package pa.chan.hammersystemtest.data.dto

import com.google.gson.annotations.SerializedName

data class DishDto(
    val id: Int,
    val name: String,
    val price: Int,
    val weight: Int,
    val description: String,
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("tegs")
    val tags: List<String>
)
