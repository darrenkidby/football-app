package ie.setu.football

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import ie.setu.football.databinding.ActivityFootballBinding
import timber.log.Timber
import timber.log.Timber.i

class FootballActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFootballBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_football)

        Timber.plant(Timber.DebugTree())
        i("Football App started...")

        binding = ActivityFootballBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.addButton.setOnClickListener() {
            val teamName = binding.teamName.text.toString()
            if (teamName.isNotEmpty()) {
                i("(Pressed Button) Added Team: $teamName")
            }
            else {
                Snackbar
                    .make(it,"Please Enter a Team Name", Snackbar.LENGTH_LONG)
                    .show()
            }
        }
    }
}