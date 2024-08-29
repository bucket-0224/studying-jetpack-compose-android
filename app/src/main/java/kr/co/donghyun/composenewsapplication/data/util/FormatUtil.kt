package kr.co.donghyun.composenewsapplication.data.util

import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.ZoneId
import java.util.Date
import java.util.Locale

object FormatUtil {
    fun formatDate(date: LocalDate?): String {
        return if (date != null) {
            val dateAsDate = Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant())
            val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            dateFormat.format(dateAsDate)
        } else {
            "1970-01-01"
        }
    }
}