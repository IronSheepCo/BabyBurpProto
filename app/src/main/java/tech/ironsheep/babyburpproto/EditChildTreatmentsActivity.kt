package tech.ironsheep.babyburpproto

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_edit_child_treatments.*
import tech.ironsheep.babyburpproto.models.Child
import tech.ironsheep.babyburpproto.models.Storage

class EditChildTreatmentsActivity : AppCompatActivity() {
    private lateinit var CurrentChild: Child

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_child_treatments)
        setSupportActionBar(toolbar)

        // display a back button in the menu
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar()?.setHomeButtonEnabled(true)

        // set child name as page title
        val childIndex = intent.getIntExtra("childIndex", 0)
        CurrentChild = Storage.data.children[childIndex]
        title = CurrentChild.name
    }

    /**
     * Back button functionality
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            android.R.id.home -> {
                finish()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}
