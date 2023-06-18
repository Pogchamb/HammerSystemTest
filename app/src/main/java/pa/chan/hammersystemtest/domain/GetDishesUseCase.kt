package pa.chan.hammersystemtest.domain

import pa.chan.hammersystemtest.domain.model.DishModel
import javax.inject.Inject

class GetDishesUseCase @Inject constructor(
    private val dishesRepository: DishesRepository
) {

    suspend operator fun invoke(): List<DishModel> {
        return dishesRepository.getDishes()
    }

}