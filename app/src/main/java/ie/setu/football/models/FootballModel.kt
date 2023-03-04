package ie.setu.football.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FootballModel(var id: Long = 0,
                         var Name: String = "",
                         var Country: String = "",
                         var Trophies: Int = 0) : Parcelable
