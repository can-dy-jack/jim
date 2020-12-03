package com.ckh.jim.activity

import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.LinearInterpolator
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import com.ckh.jim.R
import kotlinx.android.synthetic.main.activity_bilibili.*

class PaActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bilibili)

        etDanMu.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_GO) {
                if (switchDanMu.isChecked) {
                    sendDanMu()
                } else {
                    Toast.makeText(this, "给爷爬去打开弹幕开关", Toast.LENGTH_SHORT).show()
                }

            }
            return@setOnEditorActionListener true
        }
    }

    private fun sendDanMu() {
        val text = etDanMu.text.toString()
        etDanMu.setText("")
        tvDanMu.text = text
        // Toast.makeText(this, "啦", Toast.LENGTH_SHORT).show()
        ObjectAnimator.ofFloat(tvDanMu, "translationX", 0f, -3000f).apply {
            interpolator = LinearInterpolator()
            duration = 4000
            start()
        }

    }
}