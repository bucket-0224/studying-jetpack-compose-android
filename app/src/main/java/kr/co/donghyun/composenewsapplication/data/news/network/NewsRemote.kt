package kr.co.donghyun.composenewsapplication.data.news.network

import kr.co.donghyun.composenewsapplication.data.news.model.NewsResponse
import kr.co.donghyun.composenewsapplication.data.util.Constants
import kr.co.donghyun.composenewsapplication.data.util.FormatUtil
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import java.time.LocalDate
import java.util.Date

interface NewsRemote {
    @GET("everything")
    suspend fun fetchNewsFeeds(
        @Query("q") query: String = "\"Premier League\"",
        @Query("from") fromDate : String = FormatUtil.formatDate(LocalDate.now().minusDays(7)),
        @Query("to") toDate : String = FormatUtil.formatDate(LocalDate.now()),
        @Query("source") sourceLanguage : String = "gb",
        @Query("sortBy") feedSortBy : String = "popularity",
        @Query("apiKey") apiKey : String = Constants.API_KEY
    ) : Response<NewsResponse>
}