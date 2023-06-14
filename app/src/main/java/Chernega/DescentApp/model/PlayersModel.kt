package Chernega.DescentApp.model

import android.os.Parcelable
import java.io.Serializable

data class PlayersModel (
    var playerName: String,
    var logo: Int,
    var name: String,
    var type: String,
    var speed: Int,
    var health: Int,
    var stamina: Int,
    var defenceDie: String,
    var strength: Int,
    var willpower: Int,
    var knowledge: Int,
    var awareness: Int,
    var expansion: String,
    var br: Double


)
