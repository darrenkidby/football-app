package ie.setu.football.models

import timber.log.Timber.i

var lastId = 0L

internal fun getId(): Long {
    return lastId++
}

class FootballMemStore : FootballStore {

    val footballTeams = ArrayList<FootballModel>()

    override fun findAll(): List<FootballModel> {
        return footballTeams
    }

    override fun create(footballTeam: FootballModel) {
        footballTeam.id = getId()
        footballTeams.add(footballTeam)
        logAll()
    }

    override fun update(footballTeam: FootballModel) {
        var foundFootball: FootballModel? = footballTeams.find { p -> p.id == footballTeam.id }
        if (foundFootball != null) {
            foundFootball.Name = footballTeam.Name
            foundFootball.Country = footballTeam.Country
            logAll()
        }
    }

    fun logAll() {
        footballTeams.forEach{ i("${it}") }
    }
}