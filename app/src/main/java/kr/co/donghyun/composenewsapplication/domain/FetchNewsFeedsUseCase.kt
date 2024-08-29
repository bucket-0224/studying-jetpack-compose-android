package kr.co.donghyun.composenewsapplication.domain

import kr.co.donghyun.composenewsapplication.data.news.model.NewsResponse
import kr.co.donghyun.composenewsapplication.data.news.repository.NewsRepository
import retrofit2.Response
import javax.inject.Inject

class FetchNewsFeedsUseCase @Inject constructor(private val repository: NewsRepository) {
    suspend fun fetchNewsFeeds(): Response<NewsResponse> {
        return repository.fetchNewsFeeds()
    }
}