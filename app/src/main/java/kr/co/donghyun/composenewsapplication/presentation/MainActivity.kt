package kr.co.donghyun.composenewsapplication.presentation

import android.os.Build
import android.os.Bundle
import android.provider.CalendarContract.Colors
import android.view.View
import android.view.Window
import android.view.WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.core.view.WindowCompat
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import kr.co.donghyun.composenewsapplication.R
import kr.co.donghyun.composenewsapplication.presentation.components.ChipText
import kr.co.donghyun.composenewsapplication.presentation.components.ImageCardWithTextView
import kr.co.donghyun.composenewsapplication.presentation.components.NewsItemComponent
import kr.co.donghyun.composenewsapplication.presentation.screens.NewsFeedScreen
import kr.co.donghyun.composenewsapplication.presentation.ui.theme.ComposeNewsApplicationTheme
import kr.co.donghyun.composenewsapplication.presentation.ui.theme.GoloSansRegular
import kr.co.donghyun.composenewsapplication.presentation.ui.theme.GoloSansSemiBold
import kr.co.donghyun.composenewsapplication.presentation.viewmodel.HomeViewModel
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.util.Date


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setLightStatusBar(window)

        setContent {
            ComposeNewsApplicationTheme {
                NewsFeedScreen()
            }
        }
    }
}

fun setLightStatusBar(window : Window) {
    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        window.decorView.windowInsetsController?.setSystemBarsAppearance(0, APPEARANCE_LIGHT_STATUS_BARS)
    }else{
        @Suppress("DEPRECATION")
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeNewsApplicationTheme {
    }
}