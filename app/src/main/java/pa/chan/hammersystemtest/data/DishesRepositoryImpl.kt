package pa.chan.hammersystemtest.data

import pa.chan.hammersystemtest.data.extension.toModel
import pa.chan.hammersystemtest.domain.DishesRepository
import pa.chan.hammersystemtest.domain.model.DishModel
import javax.inject.Inject

class DishesRepositoryImpl @Inject constructor(
    private val dishesRemoteDatasource: DishesRemoteDatasource
) : DishesRepository {
    override suspend fun getDishes(): List<DishModel> {
        return dishesRemoteDatasource.getDishes().map {
            it.toModel()
        }
    }

    override suspend fun getCategories(dishes: List<DishModel>): Set<String> {
        val categories: MutableList<String> = mutableListOf()
        dishes.forEach { dishModel ->
            dishModel.tags?.forEach {
                if (it != null) {
                    categories.add(it)
                }
            }
        }
        return categories.toSet()
    }

}