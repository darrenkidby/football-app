package ie.setu.football.models

import timber.log.Timber.i

class FootballMemStore : FootballStore {

    val footballTeams = ArrayList<FootballModel>()

    override fun findAll(): List<FootballModel> {
        return footballTeams
    }

    override fun create(footballTeam: FootballModel) {
        footballTeams.add(footballTeam)
        logAll()
    }

    fun logAll() {
        footballTeams.forEach{ i("${it}") }
    }
}