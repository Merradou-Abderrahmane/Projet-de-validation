import com.example.projet_validation.DAO.API.ApiServicesInterface
import com.example.projet_validation.Model.Surah
import com.example.projet_validation.Model.Univer
import com.example.projet_validation.Model.User
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Dao {

    companion object {
        private var url = "https://43f2-160-179-237-227.ngrok-free.app/api/"

        private fun getRetrofit(): Retrofit {
            val gson = GsonBuilder().setLenient().create()

            return Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
        }

        val apiService: ApiServicesInterface = getRetrofit().create(ApiServicesInterface::class.java)
    }


    suspend fun store(surah: Surah) = apiService.store(surah)
    suspend fun getAll() = apiService.getAll()
    suspend fun ListFavorite() = apiService.ListFavorite()
    suspend fun delete(id: Int) = apiService.delete(id)
    suspend fun login(user: User) = apiService.login(user)
}
