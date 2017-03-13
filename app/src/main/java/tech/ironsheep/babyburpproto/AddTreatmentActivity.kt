package tech.ironsheep.babyburpproto

import android.app.DatePickerDialog
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.DatePicker
import kotlinx.android.synthetic.main.activity_add_treatment.*
import kotlinx.android.synthetic.main.content_add_child.*
import kotlinx.android.synthetic.main.content_add_treatment.*
import tech.ironsheep.babyburpproto.models.Child
import tech.ironsheep.babyburpproto.models.Drug
import tech.ironsheep.babyburpproto.models.Storage
import tech.ironsheep.babyburpproto.models.Treatment
import java.text.SimpleDateFormat
import java.util.*

class AddTreatmentActivity : MenuActivity() {
    var calendar = Calendar.getInstance()
    lateinit var CurrentChild : Child

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_treatment)

        // set child name as page title
        val childName = intent.getStringExtra("childName")
        title = childName + " - Adauga tratament"

        //Find the current child that's being edited
        CurrentChild = Storage.data.children.first({ it -> it.name == childName})

        confirmButton.setOnClickListener { view ->
            var error = ""

            if( treatmentNameEditText.text.isEmpty())
                error += "Alegeți un nume de tratament.\n"

            if( startDateEdit.text.isEmpty())
                error += "Alegeți data start.\n"

            if( error != "" ) {
                Snackbar.make(view, error, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show()
            }
            else {

                //write to persistent storage
                CurrentChild.treatments.add(Treatment(treatmentNameEditText.text.toString(), Date(startDateEdit.text.toString()),0, mutableListOf<Drug>() ))
                Storage.save()

                // close this activity (return to home)
                finish()
            }
        }
        val updateData = {
            view: DatePicker, year:Int, month:Int, day:Int
            ->
            calendar.set( Calendar.YEAR, year)
            calendar.set( Calendar.MONTH, month)
            calendar.set( Calendar.DAY_OF_MONTH, day)
            updateStartDateLabel()
        }

        startDateEdit.setOnClickListener { view ->
            DatePickerDialog(this, updateData,  calendar.get( Calendar.YEAR ), calendar.get( Calendar.MONTH ),
                    calendar.get( Calendar.DAY_OF_MONTH)).show()
        }
    }
    /**
     * Set date of birth label
     */
    fun updateStartDateLabel() {
        val format = "dd/MM/yyyy"
        val dateFormat = SimpleDateFormat( format, Locale.US )

        startDateEdit.setText( dateFormat.format( calendar.getTime() ) )
    }

}
