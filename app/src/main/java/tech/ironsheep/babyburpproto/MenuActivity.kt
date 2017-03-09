package tech.ironsheep.babyburpproto

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem

import kotlinx.android.synthetic.main.header.*

/**
 * Created by mongoose on 3/9/2017.
 */

open class MenuActivity : AppCompatActivity() {

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()

        setSupportActionBar(toolbar)

        // display a back button in the menu
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar()?.setHomeButtonEnabled(true)

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