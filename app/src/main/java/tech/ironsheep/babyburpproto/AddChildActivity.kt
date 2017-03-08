package tech.ironsheep.babyburpproto

import android.app.DatePickerDialog
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.widget.DatePicker

import kotlinx.android.synthetic.main.activity_add_child.*
import kotlinx.android.synthetic.main.content_add_child.*
import tech.ironsheep.babyburpproto.models.Child
import tech.ironsheep.babyburpproto.models.Storage
import java.text.SimpleDateFormat
import java.util.*

class AddChildActivity : AppCompatActivity() {

    var calendar = Calendar.getInstance()

    /**
     * Activity ctor()
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_child)
        setSupportActionBar(toolbar)

        // display a back button in the menu
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar()?.setHomeButtonEnabled(true)

        // click listener for floating action button (fab)
        addChild.setOnClickListener { view ->
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

                // close this activity (return to home)
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

    /**
     * Set date of birth label
     */
    fun updateDOBLabel() {
        val format = "dd/MM/yyyy"
        val dateFormat = SimpleDateFormat( format, Locale.US )

        dob.setText( dateFormat.format( calendar.getTime() ) )
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
