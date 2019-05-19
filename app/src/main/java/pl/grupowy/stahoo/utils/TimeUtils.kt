package pl.grupowy.stahoo.utils

import java.util.*

class TimeUtils private constructor() {

    companion object {
        fun calculateExpiredTime(timeUnit: Int, length: Int): Date {
            val calendar = Calendar.getInstance()
            calendar.add(timeUnit, length)

            return calendar.time
        }
    }

}