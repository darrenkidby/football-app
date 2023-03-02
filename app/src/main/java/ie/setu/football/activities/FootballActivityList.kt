package ie.setu.football.activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ie.setu.football.R
import ie.setu.football.databinding.ActivityFootballListBinding
import ie.setu.football.databinding.CardFootballBinding
import ie.setu.football.main.MainApp
import ie.setu.football.models.FootballModel

class FootballActivityList : AppCompatActivity() {

    lateinit var app: MainApp
    private lateinit var binding: ActivityFootballListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFootballListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        app = application as MainApp

        val layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = FootballAdapter(app.footballTeams)

        binding.toolbar.title = title
        setSupportActionBar(binding.toolbar)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_add -> {
                val launcherIntent = Intent(this, FootballActivity::class.java)
                getResult.launch(launcherIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private val getResult =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {
            if (it.resultCode == Activity.RESULT_OK) {
                (binding.recyclerView.adapter)?.
                notifyItemRangeChanged(0,app.footballTeams.size)
            }
        }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

}

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