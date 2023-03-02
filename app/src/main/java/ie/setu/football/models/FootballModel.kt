package ie.setu.football.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FootballModel(var Name: String = "",
                         var Country: String = "") : Parcelable
