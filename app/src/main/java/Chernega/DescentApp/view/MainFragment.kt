package Chernega.DescentApp.view

import Chernega.DescentApp.R
import Chernega.DescentApp.databinding.FragmentMainBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.Fragment
import android.view.ViewGroup


class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.btnViewHeroes?.setOnClickListener {
            lookAllHeroes() }


        binding?.btnNewGame?.setOnClickListener {
            startNewGame()
        }
    }
    private fun startNewGame() {
        val dialogFragment = nGameDialogFragment()
        fragmentManager?.let { dialogFragment.show(it, "") }
    }

    private fun lookAllHeroes() {
        fragmentManager
            ?.beginTransaction()
            ?.replace(R.id.placeholder, HeroesFragment())
            ?.addToBackStack(null)?.commit()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }




}


