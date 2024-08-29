package kr.co.donghyun.composenewsapplication.data.news.repository

import kr.co.donghyun.composenewsapplication.data.news.model.NewsResponse
import retrofit2.Response

interface NewsRepository {
   suspend fun fetchNewsFeeds() : Response<NewsResponse>
}