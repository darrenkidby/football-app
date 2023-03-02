package ie.setu.football.main

import android.app.Application
import ie.setu.football.models.FootballMemStore
import timber.log.Timber
import timber.log.Timber.i
// import ie.setu.football.models.FootballModel

class MainApp : Application() {

    // val footballTeams = ArrayList<FootballModel>()
    val footballTeams = FootballMemStore()

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        i("Football App Started")
    }
}