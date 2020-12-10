package io.hackle.android.quickstart

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.hackle.android.Hackle
import io.hackle.android.initialize

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Hackle.initialize(this, "YOUR_APP_SDK_KEY") {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}
