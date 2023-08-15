package com.unilith.Back.V1.Util.DateUtils

import java.text.SimpleDateFormat
import java.util.*

class DateUtil {

     fun  convertStringToDate(stringDate:String): Date {
        val formatter = SimpleDateFormat(DateFormat.AMERICANO.formato)
        return formatter.parse(stringDate)
    }

    fun  convertStringToDate(stringDate:String,formato:DateFormat): Date {
        val formatter = SimpleDateFormat(formato.formato)
        return formatter.parse(stringDate)
    }
}