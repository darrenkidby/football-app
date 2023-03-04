package ie.setu.football.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.snackbar.Snackbar
import ie.setu.football.R
import ie.setu.football.databinding.ActivityFootballBinding
import ie.setu.football.main.MainApp
import timber.log.Timber
import timber.log.Timber.i
import ie.setu.football.models.FootballModel

class FootballActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFootballBinding
    var footballTeam = FootballModel()
    lateinit var app : MainApp
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        var edit = false

        binding = ActivityFootballBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbarAdd.title = title
        setSupportActionBar(binding.toolbarAdd)

        app = application as MainApp

        if (intent.hasExtra("football_edit")) {
            edit = true
            footballTeam = intent.extras?.getParcelable("football_edit")!!
            binding.teamName.setText(footballTeam.Name)
            binding.country.setText(footballTeam.Country)
            binding.addButton.setText(R.string.save_football_team)
        }

        binding.addButton.setOnClickListener() {
            footballTeam.Name = binding.teamName.text.toString()
            footballTeam.Country = binding.country.text.toString()
            footballTeam.Trophies = binding.trophies.text.toString().toInt()
            if (footballTeam.Name.isEmpty()) {
                Snackbar
                    .make(it,R.string.enter_football_team_name, Snackbar.LENGTH_LONG)
                    .show()
            }
            else {
                if (edit) {
                    app.footballTeams.update(footballTeam.copy())
                } else {
                    app.footballTeams.create(footballTeam.copy())
                }
            }
            setResult(RESULT_OK)
            finish()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.football_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_cancel -> { finish() }
        }
        return super.onOptionsItemSelected(item)
    }
}