package pa.chan.hammersystemtest.domain

import pa.chan.hammersystemtest.domain.model.DishModel

interface DishesRepository {

    suspend fun getDishes(): List<DishModel>

    suspend fun getCategories(dishes: List<DishModel>): Set<String>
}