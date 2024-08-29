package kr.co.donghyun.composenewsapplication.presentation.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kr.co.donghyun.composenewsapplication.data.news.model.Article
import kr.co.donghyun.composenewsapplication.domain.FetchNewsFeedsUseCase
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val newsFeedsUseCase: FetchNewsFeedsUseCase
) : ViewModel() {

    private val _articleLists = mutableStateListOf<Article?>()
    val articleLists: List<Article?>
        get() = _articleLists

    init {
        fetchNewsFeeds()
    }

    private fun fetchNewsFeeds() {
        viewModelScope.launch {
            val response = newsFeedsUseCase.fetchNewsFeeds()

            if(response.isSuccessful) {
                println("response : ${response.body()}")
                _articleLists.apply {
                    clear()
                    addAll(response.body()?.articles ?: listOf())
                }
            }else{
                println("response error : ${response.errorBody()?.string()}")
            }
        }
    }
}