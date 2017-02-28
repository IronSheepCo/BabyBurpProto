package tech.ironsheep.babyburpproto.models



/**
 * Created by armis on 2/28/2017.
 */
data class Drug(var name: String, var span: Int, var dose: String, var icon: String) {
    var type: String = ""
    var morning = false
    var noon = false
    var evening = false
    var startingHour = 9
    var interval = 6
}