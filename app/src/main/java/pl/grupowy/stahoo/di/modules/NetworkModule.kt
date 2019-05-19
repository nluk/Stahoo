package pl.grupowy.stahoo.di.modules

import dagger.Module
import dagger.Provides
import dagger.Reusable
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import pl.grupowy.stahoo.BuildConfig
import pl.grupowy.stahoo.application.App
import pl.grupowy.stahoo.network.services.OperationsService
import pl.grupowy.stahoo.network.services.UsersService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module(includes = [ViewModelModule::class])
object NetworkModule {
    @JvmStatic
    internal fun getFullUrl(): String = "${BuildConfig.PROTOCOL}://${BuildConfig.HOST}/${BuildConfig.PATH}/"

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(getFullUrl())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

//    TODO: profourone: Provide OkHttpClient, Interceptor

//    TODO: profourone: Create OperationsRest (RetrofitInterface for operations), then uncomment
//    @Provides
//    @Reusable
//    @JvmStatic
//    internal fun provideOperationsRest(retrofit: Retrofit): OperationsRest = retrofit.create(OperationsRest::class.java)

//    TODO: profourone: Create UsersRest (RetrofitInterface for users), then uncomment
//    @Provides
//    @Reusable
//    @JvmStatic
//    internal fun provideUsersRest(retrofit: Retrofit): UsersRest = retrofit.create(UsersRest::class.java)

//    TODO: profourone: Create PartialsRest (RetrofitInterface for partials), then uncomment
//    @Provides
//    @Reusable
//    @JvmStatic
//    internal fun providePartialsRest(retrofit: Retrofit): PartialsRest = retrofit.create(PartialsRest::class.java)
}