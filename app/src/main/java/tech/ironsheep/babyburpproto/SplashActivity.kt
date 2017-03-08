package tech.ironsheep.babyburpproto

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.SystemClock
import kotlin.concurrent.thread

class SplashActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_splash);

        // Start the app main activity after a 1 second delay
        thread(start=true){
            SystemClock.sleep(1000)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

            // close this activity
            finish()
        }
    }
}
