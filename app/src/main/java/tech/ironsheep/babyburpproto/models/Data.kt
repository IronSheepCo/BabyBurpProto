package tech.ironsheep.babyburpproto.models

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue

/**
 * Created by mongoose on 3/8/2017.
 */
data class Data(val children: MutableList<Child> = mutableListOf()) {

    companion object DataFactory {

        open fun createFromJSON(json: String): Data {
            val mapper = jacksonObjectMapper()
            mapper.configure( DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT, true )
            return if (json == "") Data() else mapper.readValue<Data>(json)
        }
    }

    /**
     * Add new child
     */
    open fun addChild(child: Child) {
        this.children.add(child)
    }

    fun toJSON(): String {

        val mapper = jacksonObjectMapper()
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        return mapper.writeValueAsString(this)
    }
}