package pa.chan.hammersystemtest.data

import pa.chan.hammersystemtest.data.dto.DishDto
import javax.inject.Inject

class DishesRemoteDatasource @Inject constructor(
    private val dishesApi: DishesApi
) {

    suspend fun getDishes(): List<DishDto> {
        return dishesApi.getDishes().dishes
    }

}