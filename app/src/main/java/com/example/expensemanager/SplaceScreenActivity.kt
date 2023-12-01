package com.example.expensemanager

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplaceScreenActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splacescreen)

        initview()

    }

    private fun initview() {
        Handler().postDelayed({
            val mainIntent = Intent(this@SplaceScreenActivity, DaseBoardActivity::class.java)
            startActivity(mainIntent)
            finish()
        }, 3000)
    }
}