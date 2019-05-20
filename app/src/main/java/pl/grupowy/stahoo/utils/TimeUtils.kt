package pl.grupowy.stahoo.utils

import java.text.SimpleDateFormat
import java.util.*

class TimeUtils private constructor() {

    companion object {
        fun calculateExpiredTime(timeUnit: Int, length: Int): Date {
            val calendar = Calendar.getInstance()
            calendar.add(timeUnit, length)

            return calendar.time
        }

        fun convertToDate(date: String): Date {
            return SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").parse(date)
        }
    }

}