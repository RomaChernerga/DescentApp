package Chernega.DescentApp.view

import Chernega.DescentApp.ViewModel.Adapters.HeroesAdapter
import Chernega.DescentApp.databinding.FragmentHeroesBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager

class HeroesFragment : Fragment() {


    private var adapter = HeroesAdapter()
    private var _binding: FragmentHeroesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHeroesBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.apply {
            heroesRecyclerView.layoutManager = LinearLayoutManager(activity)
            heroesRecyclerView.adapter = adapter
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
    companion object {
        fun newInstance() = HeroesFragment()
    }
}