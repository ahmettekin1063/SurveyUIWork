package com.ahmettekin.repossurveyui

import android.graphics.Color.red
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat
import androidx.core.text.buildSpannedString

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       /* val text = buildSpannedString {
            append("My red text")
            setSpan(
                ForegroundColorSpan(ContextCompat.getColor(this@MainActivity, R.color.Red)),
                3,
                6,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        }*/
        findViewById<TextView>(R.id.tvTest).append("*", R.color.DarkRed)
    }
}

fun TextView.append(string: String?, @ColorRes color: Int) {
    if (string == null || string.isEmpty()) {
        return
    }

    val spannable: Spannable = SpannableString(string)
    spannable.setSpan(
        ForegroundColorSpan(ContextCompat.getColor(context, color)),
        0,
        spannable.length,
        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
    )

    append(spannable)
}