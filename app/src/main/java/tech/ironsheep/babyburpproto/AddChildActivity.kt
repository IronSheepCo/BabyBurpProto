package tech.ironsheep.babyburpproto

import android.app.DatePickerDialog
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.DatePicker

import kotlinx.android.synthetic.main.activity_add_child.*
import kotlinx.android.synthetic.main.content_add_child.*
import java.text.SimpleDateFormat
import java.util.*

class AddChildActivity : AppCompatActivity() {

    var calendar = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_child)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val updateData = {
            view:DatePicker, year:Int, month:Int, day:Int
            ->
            calendar.set( Calendar.YEAR, year)
            calendar.set( Calendar.MONTH, month)
            calendar.set( Calendar.DAY_OF_MONTH, day)
            updateDOBLabel()
        }

        dob.setOnClickListener { view ->
            DatePickerDialog(this, updateData,  calendar.get( Calendar.YEAR ), calendar.get( Calendar.MONTH ),
                    calendar.get( Calendar.DAY_OF_MONTH)).show()
        }
    }

    fun updateDOBLabel() {
        val format = "dd/MM/yyyy"
        val dateFormat = SimpleDateFormat( format, Locale.US )

        dob.setText( dateFormat.format( calendar.getTime() ) )
    }

}
