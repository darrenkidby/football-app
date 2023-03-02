package ie.setu.football.main

import android.app.Application
import ie.setu.football.models.FootballModel
import timber.log.Timber
import timber.log.Timber.i

class MainApp : Application() {

    val footballTeams = ArrayList<FootballModel>()

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        i("Football App started")
    }
}