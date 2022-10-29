package Chernega.DescentApp.ui


import Chernega.DescentApp.R
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
//    private lateinit var binding: ActivityStartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
//        binding = ActivityStartBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.placeholder, MainFragment::class.java.newInstance())
                .commit()
        }

//        binding.btnNewGame.setOnClickListener {
//            startActivity(Intent(this, newGameActivity::class.java))
//        }
//        binding.btnViewHeroes.setOnClickListener {
//            supportFragmentManager.beginTransaction().replace(R.id.container, HeroesFragment()).addToBackStack(null).commit()
//        }
    }
}