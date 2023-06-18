package pa.chan.hammersystemtest.domain

import pa.chan.hammersystemtest.domain.model.DishModel
import javax.inject.Inject

class GetCategoriesUseCase @Inject constructor(
    private val dishesRepository: DishesRepository
) {

    suspend operator fun invoke(dishes: List<DishModel>): Set<String> {
        return dishesRepository.getCategories(dishes)
    }

}