package kr.co.donghyun.composenewsapplication.data.news.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.co.donghyun.composenewsapplication.data.news.network.NewsRemote
import kr.co.donghyun.composenewsapplication.data.news.repository.NewsRepository
import kr.co.donghyun.composenewsapplication.data.news.repository.SimpleNewsRepository

@InstallIn(SingletonComponent::class)
@Module
object NewsRepositoryModule {
    @Provides
    fun providesNewsRepository(remote : NewsRemote) : NewsRepository {
        return SimpleNewsRepository(remote)
    }
}