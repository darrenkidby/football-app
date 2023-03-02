package ie.setu.football.models

interface FootballStore {
    fun findAll(): List<FootballModel>
    fun create(footballTeam: FootballModel)

    fun update(footballTeam: FootballModel)
}