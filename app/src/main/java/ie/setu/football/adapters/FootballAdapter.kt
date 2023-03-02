package ie.setu.football.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ie.setu.football.databinding.CardFootballBinding
import ie.setu.football.models.FootballModel

class FootballAdapter constructor(private var footballTeams: List<FootballModel>) :
    RecyclerView.Adapter<FootballAdapter.MainHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val binding = CardFootballBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return MainHolder(binding)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        val footballTeam = footballTeams[holder.adapterPosition]
        holder.bind(footballTeam)
    }

    override fun getItemCount(): Int = footballTeams.size

    class MainHolder(private val binding : CardFootballBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(footballTeam: FootballModel) {
            binding.teamName.text = footballTeam.Name
            binding.country.text = footballTeam.Country
        }
    }
}