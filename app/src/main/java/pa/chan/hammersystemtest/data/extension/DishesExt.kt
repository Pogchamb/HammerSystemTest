package pa.chan.hammersystemtest.data.extension

import pa.chan.hammersystemtest.data.dto.DishDto
import pa.chan.hammersystemtest.domain.model.DishModel

fun DishDto.toModel(): DishModel = DishModel(
    name = this.name,
    price = this.price,
    weight = this.weight,
    description = this.description,
    imageUrl = this.imageUrl,
    tags = this.tags
)