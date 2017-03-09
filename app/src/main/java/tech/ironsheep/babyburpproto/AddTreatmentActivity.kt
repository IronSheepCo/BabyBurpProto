package tech.ironsheep.babyburpproto

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import kotlinx.android.synthetic.main.activity_add_treatment.*
import tech.ironsheep.babyburpproto.models.Storage

class AddTreatmentActivity : MenuActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_treatment)

        // set child name as page title
        val childName = intent.getStringExtra("childName")
        //CurrentChild = Storage.data.children[childIndex]
        title = childName + " - Adauga tratament"

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

}
