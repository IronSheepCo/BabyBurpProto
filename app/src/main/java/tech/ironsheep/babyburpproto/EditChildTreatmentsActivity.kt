package tech.ironsheep.babyburpproto

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_edit_child_treatments.*
import tech.ironsheep.babyburpproto.models.Child
import tech.ironsheep.babyburpproto.models.Storage

class EditChildTreatmentsActivity : AppCompatActivity() {
    private lateinit var CurrentChild: Child

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_child_treatments)
        setSupportActionBar(toolbar)
        val childIndex = intent.getIntExtra("childIndex", 0)
        CurrentChild = Storage.data.children[childIndex]
        titleName.text = CurrentChild.name

    }
}
