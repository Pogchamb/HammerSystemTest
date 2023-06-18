package pa.chan.hammersystemtest.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import pa.chan.hammersystemtest.data.DishesApi
import pa.chan.hammersystemtest.data.DishesRepositoryImpl
import pa.chan.hammersystemtest.domain.DishesRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    companion object {
        private const val url = "https://run.mocky.io"

        @Provides
        @Singleton
        fun provideOkHttpClient(): OkHttpClient {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            return OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()
        }

        @Provides
        @Singleton
        fun provideRetrofitBuilder(okHttpClient: OkHttpClient): Retrofit {
            return Retrofit.Builder()
                .baseUrl(url)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        @Provides
        @Singleton
        fun provideDishesApi(retrofit: Retrofit): DishesApi =
            retrofit.create(DishesApi::class.java)


    }

    @Binds
    abstract fun bindDishesRepository(dishesRepositoryImpl: DishesRepositoryImpl): DishesRepository

}