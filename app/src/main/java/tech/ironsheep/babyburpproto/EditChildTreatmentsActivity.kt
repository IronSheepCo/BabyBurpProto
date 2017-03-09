package tech.ironsheep.babyburpproto

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_edit_child_treatments.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_edit_child_treatments.*
import tech.ironsheep.babyburpproto.models.Child
import tech.ironsheep.babyburpproto.models.Storage

class EditChildTreatmentsActivity : MenuActivity() {
    private lateinit var CurrentChild: Child

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_child_treatments)

        // set child name as page title
        val childIndex = intent.getIntExtra("childIndex", 0)
        CurrentChild = Storage.data.children[childIndex]
        title = "Detalii tratament: " + CurrentChild.name
        //populate child treatment list
        refreshTreatmentList()
        addTreatment.setOnClickListener {
            val intent = Intent(this, AddTreatmentActivity::class.java)
            intent.putExtra("childName", CurrentChild.name)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()

    }

    /**
     * Populates the treamtents list
     */
    private fun refreshTreatmentList() {

        // select treatment
        val treatmentNames = CurrentChild.treatments.map { it -> it.name}

        // create adapter
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1, treatmentNames)
        treatmentListView.setAdapter(adapter)

        // set click listener
        treatmentListView.setOnItemClickListener { adapterView, view, index, l ->
            run {
                val intent = Intent(this, EditChildTreatmentsActivity::class.java)
                intent.putExtra("treatmentIndex", index)
                startActivity(intent)
            }
        }
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
