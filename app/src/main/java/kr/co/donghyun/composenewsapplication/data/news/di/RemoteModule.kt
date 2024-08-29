package kr.co.donghyun.composenewsapplication.data.news.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.co.donghyun.composenewsapplication.data.news.network.NewsRemote
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@InstallIn(SingletonComponent::class)
@Module
object RemoteModule {
    @Provides
    fun provideRemote() : NewsRemote {
        return Retrofit.Builder().baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsRemote::class.java)
    }
}