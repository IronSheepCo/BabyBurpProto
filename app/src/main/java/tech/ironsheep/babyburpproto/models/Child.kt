package tech.ironsheep.babyburpproto.models

import java.util.*

/**
 * Created by armis on 2/28/2017.
 */
data class Child(val name: String, val sex: String, val birthDate: Date, val treatments: Array<Treatment>) {
}