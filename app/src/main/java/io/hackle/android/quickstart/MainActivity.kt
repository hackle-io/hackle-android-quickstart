package io.hackle.android.quickstart

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.Toast
import io.hackle.android.Hackle
import io.hackle.android.app
import io.hackle.android.user
import io.hackle.sdk.common.Variation.A
import io.hackle.sdk.common.Variation.B
import java.util.*

class MainActivity : Activity() {

    private val mainHandler = Handler(Looper.getMainLooper())

    private val user = Hackle.user(UUID.randomUUID().toString())
    private val sampleExperimentKey: Long = 1234

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn_purchase).apply {

            // 1. Variation 결정
            val variation = Hackle.app.variation(sampleExperimentKey, user)

            // 2. Variation 별 로직
            if (variation == A) {
                setBackgroundColor(Color.BLUE)
            } else if (variation == B) {
                setBackgroundColor(Color.RED)
            }

            setOnClickListener {

                // 3. Event 로깅
                Hackle.app.track("purchase_button_click", user)

                mainHandler.post {
                    Toast.makeText(this@MainActivity, "Click", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}