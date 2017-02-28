package tech.ironsheep.babyburpproto.models

import java.util.*
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.module.kotlin.*
/**
 * Created by armis on 2/28/2017.
 */
data class Child(val name: String, val sex: String, val birthDate: Date, val treatments: Array<Treatment>) {

    companion object ChildFactory {
        fun createFromJSON(json: String): Child {
            val mapper = jacksonObjectMapper()
            mapper.configure( DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT, true )
            return mapper.readValue<Child>(json)
        }
    }
}