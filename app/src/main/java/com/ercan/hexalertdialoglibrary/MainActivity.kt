package com.ercan.hexalertdialoglibrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ercan.hexalertdialog.HexAlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        helloTw.setOnClickListener {

            HexAlertDialog(this).apply {
                title = "Title"
                message = "This is the message."
                positiveBtnClickListener = {
                    // Do some work here.
                }
                negativeBtnClickListener = {
                    // Do some work here.
                }
            }.show()

        }
    }
}
