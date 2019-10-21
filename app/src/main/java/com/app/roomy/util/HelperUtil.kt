package com.app.roomy.util

import android.content.Context
import android.graphics.Typeface
import android.view.View
import android.widget.TextView
import android.view.ViewGroup
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols


class HelperUtil {
   fun changeBottomNavigationViewFont(context: Context, v: View)
    {
        try {
            if (v is ViewGroup) {
                val vg = v as ViewGroup
                for (i in 0 until vg.childCount) {
                    val child = vg.getChildAt(i)
                    changeBottomNavigationViewFont(context, child)
                }
            } else if (v is TextView) {
                v.setTypeface(Typeface.createFromAsset(context.getAssets(), "iransans_light.ttf"))
            }
        } catch (e: Exception) {
        }

    }
    fun convertPriceToFormattedPrice(price:Long):String
    {
        try {
            val symbols = DecimalFormatSymbols()
            symbols.setDecimalSeparator(',')
            val decimalFormat = DecimalFormat("###,###,###,###", symbols)
          return   decimalFormat.format(price)+" تومان "
        } catch (e: Exception)
        {
            return price.toString()
        }

    }


}