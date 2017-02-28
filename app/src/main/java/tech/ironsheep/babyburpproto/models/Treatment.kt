package tech.ironsheep.babyburpproto.models

import java.util.*

/**
 * Created by armis on 2/28/2017.
 */
data class Treatment(val name: String, val startDate: Date, val span: Int, val drugs: MutableList<Drug> = mutableListOf<Drug>()) {

}