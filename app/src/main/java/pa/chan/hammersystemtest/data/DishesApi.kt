package pa.chan.hammersystemtest.data

import pa.chan.hammersystemtest.data.dto.DishesDto
import retrofit2.http.GET


interface DishesApi {

    @GET(value = "/v3/aba7ecaa-0a70-453b-b62d-0e326c859b3b")
    suspend fun getDishes(): DishesDto

}