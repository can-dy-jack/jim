package com.ckh.jim.util

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.core.content.ContextCompat.startActivity
import com.ckh.jim.activity.WebActivity

/**
 * 通过浏览器打开网页
 * @param context
 * @url 网址
 */
fun openUrlByBrowser(context: Context, url: String) {
    if (url != "") {
        val intent = Intent()
        intent.action = "android.intent.action.VIEW"
        val contentUrl = Uri.parse(url)
        intent.data = contentUrl
        startActivity(context, intent, Bundle())
    }
}

fun openUrlByWebActivity(activity: Activity, url: String) {
    val intent = Intent(activity, WebActivity::class.java)
    intent.putExtra("extra_webUrlStr", url)
    activity.startActivity(intent)
}