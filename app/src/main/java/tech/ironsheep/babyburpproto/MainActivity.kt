package tech.ironsheep.babyburpproto

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import kotlinx.android.synthetic.main.activity_main.*
import tech.ironsheep.babyburpproto.models.Storage
import android.widget.ArrayAdapter


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Storage.initialize(applicationContext)

        Log.d("BabyBurp", Storage.data.toJSON())

        //select baby names
        val childNames = Storage.data.children.map { it -> it.name }
        //create adapter
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1, childNames)
        childListView.setAdapter(adapter)

        add_child.setOnClickListener {
            val intent = Intent(this, AddChildActivity::class.java)
            startActivity(intent)
        }
    }
}
