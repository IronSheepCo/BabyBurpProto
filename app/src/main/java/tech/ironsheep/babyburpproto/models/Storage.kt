package tech.ironsheep.babyburpproto.models

import android.content.Context
import android.util.Log
import java.io.File

/**
 * Created by mongoose on 3/8/2017.
 */
object Storage {

    val STORAGE_FILENAME = "storage.json"
    var data: Data = Data()
    lateinit var appContext: Context

    /**
     * Initialize
     * Create/Open storage file
     * Read it
     */
    fun initialize(context: Context) {

        this.appContext = context

        var f: File = getFile()

        var json: String = f.readText()
        data = Data.createFromJSON(json)
    }

    /**
     *
     */
    fun getFile(): File {

        var f:File = File(appContext.getFilesDir(), STORAGE_FILENAME)

        if(!f.exists()) {
            f.createNewFile()
        }

        return f
    }

    /**
     * Add new child
     */
    open fun addChild(child: Child): Storage {
        data.addChild(child)
        return this
    }

    /**
     * Save json to disk
     */
    fun save() {
        var file: File = getFile()
        var contents = data.toJSON()
        Log.d("BabyBurp", "writing data: " + contents)
        file.writeText(contents)
    }

    /**
     * Clear json
     */
    fun clear() {
        data.children.clear()
        save()
    }
}