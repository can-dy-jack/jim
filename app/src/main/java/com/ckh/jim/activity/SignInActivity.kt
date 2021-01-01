package com.ckh.jim.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ckh.jim.R
import com.ckh.jim.util.openUrlByBrowser
import com.ckh.jim.util.toast
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        btnCancel.setOnClickListener {
            nactvSignUser.setText("")
            pwSignPassword.setText("")

        }
        btnSubmit.setOnClickListener {
            if (nactvSignUser.text.toString() == "123"&& pwSignPassword.text.toString() == "2"){
                openUrlByBrowser(this,"https://github.com/Moriafly")
            }else{
                toast("密码或用户名错误！")
            }
        }
    }
}