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

    @JvmStatic
    private val ignoredPathsInJwt: List<String> = ArrayList(
        listOf(
            UsersService.SIGN_IN_ENDPOINT, UsersService.REGISTER_ENDPOINT
        )
    )

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideInterceptor() = Interceptor { chain ->
        val request = chain.request()

        if (ignoredPathsInJwt.contains(request.url().encodedPath()) ||
            App.store == null ||
            App.store?.refreshToken.isNullOrEmpty() ||
            App.store?.accessToken.isNullOrEmpty()
        ) {
            return@Interceptor chain.proceed(request)
        } else {
            val authRequest = request.newBuilder()
                .addHeader("Authorization", "Bearer ${App.store!!.accessToken}")
                .build()

            return@Interceptor chain.proceed(authRequest)
        }

    }

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideOkHttpClient(interceptor: Interceptor): OkHttpClient {
        return OkHttpClient.Builder().connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(interceptor)
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()
    }

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder().baseUrl(getFullUrl())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideOperationsRest(retrofit: Retrofit): OperationsService =
        retrofit.create(OperationsService::class.java)

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideUsersService(retrofit: Retrofit): UsersService = retrofit.create(UsersService::class.java)

//    TODO: profourone: Create PartialsRest (RetrofitInterface for partials), then uncomment
//    @Provides
//    @Reusable
//    @JvmStatic
//    internal fun providePartialsRest(retrofit: Retrofit): PartialsRest = retrofit.create(PartialsRest::class.java)
}