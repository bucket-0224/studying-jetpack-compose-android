package kr.co.donghyun.composenewsapplication.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.co.donghyun.composenewsapplication.R
import kr.co.donghyun.composenewsapplication.presentation.ui.theme.GoloSansRegular

@Composable
fun ChipText(
    modifier: Modifier = Modifier,
    text: String,
    fontSize: TextUnit = 10.sp,
) {
    Text(
        text = text,
        fontSize = fontSize,
        fontFamily = GoloSansRegular,
        color = Color.Gray,
        modifier = modifier
            .clip(RoundedCornerShape(100.dp))
            .background(colorResource(id = R.color.white).copy(alpha = 0.2f))
            .padding(horizontal = 16.dp, vertical = 4.dp),
    )
}
