package kr.co.donghyun.composenewsapplication.presentation.components

import android.view.RoundedCorner
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import kr.co.donghyun.composenewsapplication.data.news.model.Article
import kr.co.donghyun.composenewsapplication.presentation.ui.theme.GoloSansBold
import kr.co.donghyun.composenewsapplication.presentation.ui.theme.GoloSansRegular
import kr.co.donghyun.composenewsapplication.presentation.ui.theme.GoloSansSemiMedium
import kr.co.donghyun.composenewsapplication.presentation.util.FormatUtil.formatDate
import kr.co.donghyun.composenewsapplication.presentation.util.FormatUtil.parseDate
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


@Composable
fun ImageCardWithTextView(
    article: Article?,
    contentDescription : String,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier.apply {
            fillMaxWidth()
            padding(16.dp)
        },
        shape = RoundedCornerShape(16.dp),
    ) {
        Box(modifier = Modifier.height(224.dp)) {
            AsyncImage(
                modifier = Modifier.fillMaxSize(),
                model = article?.urlToImage,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomStart)
                    .background(Color.DarkGray.copy(alpha = 0.8f))
                    .padding(vertical = 8.dp, horizontal = 12.dp)
            ) {
                Column {
                    Text(
                        text = article?.title ?: "",
                        fontFamily = GoloSansSemiMedium,
                        color = Color.White,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = formatDate(parseDate(article?.publishedAt ?: "")),
                        fontSize = 12.sp,
                        fontFamily = GoloSansRegular,
                        color = Color.White
                    )
                }
            }
        }
    }
}