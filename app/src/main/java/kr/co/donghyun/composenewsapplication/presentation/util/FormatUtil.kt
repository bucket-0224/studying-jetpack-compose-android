package kr.co.donghyun.composenewsapplication.presentation.util

import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.Locale
import java.util.TimeZone

object FormatUtil {
    fun formatDate(date: Date?): String {
        if(date != null) {
            val dateFormat = SimpleDateFormat("yyyy.MM.dd", Locale.getDefault())
            return dateFormat.format(date)
        }else{
            return "1970.01.01"
        }
    }

    fun parseDate(dateString: String): Date? {
        val isoFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
        isoFormat.timeZone = TimeZone.getTimeZone("UTC")
        return try {
            isoFormat.parse(dateString)
        } catch (e: Exception) {
            null
        }
    }
}