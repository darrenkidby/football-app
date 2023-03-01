package ie.setu.football.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import ie.setu.football.R
import ie.setu.football.databinding.ActivityFootballBinding
import timber.log.Timber
import timber.log.Timber.i
import ie.setu.football.models.FootballModel

class FootballActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFootballBinding
    var football = FootballModel()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_football)

        Timber.plant(Timber.DebugTree())
        i("Football App started...")

        binding = ActivityFootballBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.addButton.setOnClickListener() {
            football.name = binding.teamName.text.toString()
            if (football.name.isNotEmpty()) {
                i("(Pressed Button) Added Team: $football.name")
            }
            else {
                Snackbar
                    .make(it,"Please Enter a Team Name", Snackbar.LENGTH_LONG)
                    .show()
            }
        }
    }
}