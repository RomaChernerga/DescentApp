package Chernega.DescentApp.ui

import Chernega.DescentApp.R
import Chernega.DescentApp.databinding.FragmentMainBinding
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnViewHeroes.setOnClickListener {
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.placeholder, HeroesFragment())
                .addToBackStack(null).commit()
        }
        binding.btnNewGame.setOnClickListener {
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.placeholder, NewGameFragment())
                .addToBackStack(null).commit()
        }
    }




}
