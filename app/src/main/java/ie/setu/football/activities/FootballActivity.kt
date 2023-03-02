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
        setContentView(R.layout.activity_football)

        app = application as MainApp
        i("Football App started...")

        binding = ActivityFootballBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbarAdd.title = title
        setSupportActionBar(binding.toolbarAdd)
        binding.addButton.setOnClickListener() {
            footballTeam.Name = binding.teamName.text.toString()
            footballTeam.Country = binding.country.text.toString()
            if (footballTeam.Name.isNotEmpty()) {
                app.footballTeams.add(footballTeam.copy())
                i("(Pressed Button) Added Team: $footballTeam")
                for (i in app.footballTeams.indices)
                { i("Football[$i]:${this.app.footballTeams[i]}") }
                setResult(RESULT_OK)
                finish()
            }
            else {
                Snackbar
                    .make(it,"Please Enter a Team Name", Snackbar.LENGTH_LONG)
                    .show()
            }
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