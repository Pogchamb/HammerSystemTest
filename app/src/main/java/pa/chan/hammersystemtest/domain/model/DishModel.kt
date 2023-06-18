package pa.chan.hammersystemtest.domain.model

data class DishModel(
    val name: String,
    val price: Int,
    val weight: Int,
    val description: String,
    val imageUrl: String,
    val tags: List<String?>?
)
