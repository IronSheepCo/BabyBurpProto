package tech.ironsheep.babyburpproto

import android.app.DatePickerDialog
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.widget.DatePicker

import kotlinx.android.synthetic.main.activity_add_child.*
import kotlinx.android.synthetic.main.content_add_child.*
import tech.ironsheep.babyburpproto.models.Child
import tech.ironsheep.babyburpproto.models.Storage
import java.text.SimpleDateFormat
import java.util.*

class AddChildActivity : AppCompatActivity() {

    var calendar = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_child)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            var error = ""

            if( childName.text.isEmpty())
                error += "Alegeți un nume.\n"

            if( dob.text.isEmpty())
                error += "Alegeți data nașterii.\n"

            if( error != "" ) {
                Snackbar.make(view, error, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show()
            }
            else {

                //write to persistent storage
                val child:Child = Child(childName.text.toString(), genderSpinner.selectedItem.toString(), Date(dob.text.toString()))

                Storage.addChild(child).save()

                //move to previous activity
                //val intent = Intent(this, MainActivity::class.java)
                //startActivity(intent)

                finish()
            }
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
