package kr.co.donghyun.composenewsapplication.presentation.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.viewModelFactory
import kr.co.donghyun.composenewsapplication.R
import kr.co.donghyun.composenewsapplication.presentation.components.ChipText
import kr.co.donghyun.composenewsapplication.presentation.components.ImageCardWithTextView
import kr.co.donghyun.composenewsapplication.presentation.components.NewsItemComponent
import kr.co.donghyun.composenewsapplication.presentation.ui.theme.GoloSansSemiBold
import kr.co.donghyun.composenewsapplication.presentation.viewmodel.HomeViewModel
import androidx.hilt.navigation.compose.hiltViewModel
import kr.co.donghyun.composenewsapplication.presentation.components.RowNewsItemComponent

@Composable
fun NewsFeedScreen(
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val articles = remember { homeViewModel.articleLists }

    Scaffold(modifier = Modifier.apply {
        fillMaxSize()
    }) { innerPadding ->
        LazyColumn {
            item {
                Text(modifier = Modifier.padding(top = (innerPadding.calculateTopPadding() + 32.dp), start = 16.dp, end = 16.dp), text = "Breaking News This Week", fontSize = 24.sp, fontFamily = GoloSansSemiBold)
                AnimatedVisibility(visible = true) {
                    ImageCardWithTextView(
                        article = if(articles.isEmpty()) null else articles.first(),
                        contentDescription = "Breaking News This Week.",
                        modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
                    )
                }
                Text(modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp), text = "Most Popular News", fontSize = 24.sp, fontFamily = GoloSansSemiBold)
                LazyRow(modifier = Modifier.padding(horizontal = 16.dp)) {
                    itemsIndexed(items = if(articles.isEmpty()) listOf() else articles.subList(1, 6)) { _, article ->
                        RowNewsItemComponent(article = article, contentDescription = "", modifier = Modifier.padding(end = 12.dp))
                    }
                }
                Text(modifier = Modifier.padding(top = 16.dp, bottom = 8.dp, start = 16.dp, end = 16.dp), text = "Top Headline News", fontSize = 24.sp, fontFamily = GoloSansSemiBold)
            }
            itemsIndexed(items = if(articles.isEmpty()) listOf() else articles.subList(6, articles.lastIndex)) { _, article ->
                NewsItemComponent(contentDescription = "", newsArticle = article)
            }
        }
    }
}