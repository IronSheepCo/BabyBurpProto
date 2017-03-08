package tech.ironsheep.babyburpproto

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import kotlinx.android.synthetic.main.activity_main.*
import tech.ironsheep.babyburpproto.models.Storage

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Storage.initialize(applicationContext)

        Log.d("BabyBurp", Storage.data.toJSON())

        add_child.setOnClickListener {
            val intent = Intent(this, AddChildActivity::class.java)
            startActivity(intent)
        }
    }
}
