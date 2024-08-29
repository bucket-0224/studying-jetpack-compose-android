package kr.co.donghyun.composenewsapplication.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import kr.co.donghyun.composenewsapplication.R
import kr.co.donghyun.composenewsapplication.data.news.model.Article
import kr.co.donghyun.composenewsapplication.presentation.util.FormatUtil
import kr.co.donghyun.composenewsapplication.presentation.util.FormatUtil.formatDate
import kr.co.donghyun.composenewsapplication.presentation.util.FormatUtil.parseDate
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.Locale

@Composable
fun NewsItemComponent(
    modifier: Modifier = Modifier.padding(horizontal = 16.dp),
    contentDescription: String,
    newsArticle: Article?,
) {
    Card(modifier =
    modifier
        .fillMaxWidth()
        .padding(vertical = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(
                modifier = Modifier
                    .size(84.dp)
                    .padding(8.dp)
            ) {
                AsyncImage(
                    modifier = Modifier.fillMaxSize(),
                    model = newsArticle?.urlToImage,
                    contentDescription = contentDescription,
                    contentScale = ContentScale.Crop
                )
            }

            Column(
                modifier = Modifier.apply {
                    fillMaxWidth()
                    fillMaxHeight()
                },
                verticalArrangement = Arrangement.Center
            ) {
                Row(verticalAlignment = Alignment.Top) {
                    Text(
                        text = newsArticle?.title ?: "",
                        modifier = Modifier.padding(bottom = 4.dp).fillMaxWidth(0.7f),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(
                        modifier = Modifier.fillMaxSize().padding(end = 8.dp),
                        text = formatDate(parseDate(newsArticle?.publishedAt ?: "")),
                        maxLines = 1,
                        fontSize = 10.sp,
                        overflow = TextOverflow.Ellipsis,
                        textAlign = TextAlign.End
                    )
                }
                Text(
                    text = newsArticle?.content ?: "",
                    fontSize = 12.sp,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}
