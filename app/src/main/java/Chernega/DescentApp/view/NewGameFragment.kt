package Chernega.DescentApp.view

import Chernega.DescentApp.ViewModel.Adapters.PlayersAdapter
import Chernega.DescentApp.databinding.FragmentNewGameBinding
import Chernega.DescentApp.model.DataModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager


class NewGameFragment : Fragment() {
    private var _binding: FragmentNewGameBinding? = null
    private val binding get() = _binding
    private val dataModel: DataModel by activityViewModels()
    private val adapter = PlayersAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentNewGameBinding.inflate(inflater, container, false)
        return binding?.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataModel.players.observe(activity as LifecycleOwner) {
            binding?.tViewPlayers?.text = it
        }
        initRecyclerView()

    }
    private fun initRecyclerView() {
        binding?.apply {
            recViewActualHeroes.layoutManager = LinearLayoutManager(activity)
            recViewActualHeroes.adapter = adapter
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}

