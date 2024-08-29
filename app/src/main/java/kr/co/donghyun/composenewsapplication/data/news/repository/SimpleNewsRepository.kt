package kr.co.donghyun.composenewsapplication.data.news.repository

import kr.co.donghyun.composenewsapplication.data.news.model.NewsResponse
import kr.co.donghyun.composenewsapplication.data.news.network.NewsRemote
import retrofit2.Response
import javax.inject.Inject

class SimpleNewsRepository @Inject constructor(private val remote : NewsRemote) : NewsRepository  {
    override suspend fun fetchNewsFeeds(): Response<NewsResponse> {
        return remote.fetchNewsFeeds()
    }
}