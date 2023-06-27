package Chernega.DescentApp.view

import Chernega.DescentApp.R
import Chernega.DescentApp.ViewModel.Adapters.PlayersAdapter
import Chernega.DescentApp.databinding.FragmentNewGameBinding
import Chernega.DescentApp.model.DataModel
import Chernega.DescentApp.model.PlayersModel
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager


class NewGameFragment : Fragment() {
    private var _binding: FragmentNewGameBinding? = null
    private val binding get() = _binding
    private val dataModel: DataModel by activityViewModels()
    private val adapter = PlayersAdapter()
    private val cardView = view?.findViewById<CardView>(R.id.card_view_player)



    companion object {
        fun newInstance(bundle: Bundle): NewGameFragment {
            val newGameFragment = NewGameFragment()
            newGameFragment.arguments = bundle
            return newGameFragment
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        _binding = FragmentNewGameBinding.inflate(inflater, container, false)
        return binding?.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataModel.players.observe(activity as LifecycleOwner) {
            binding?.tViewPlayers?.text = it
        }


        val maxBr = arguments?.getInt("final")
        binding?.tViewBr?.text = maxBr.toString()

        initRecyclerView()


        binding?.recViewActualHeroes?.adapter = adapter
        adapter.listener = PlayersAdapter.OnItemClick { player ->
            Toast.makeText(requireContext(), player.name, Toast.LENGTH_SHORT).show()

        }
    }




    private fun initRecyclerView() {
        binding?.apply {
            recViewActualHeroes.layoutManager = LinearLayoutManager(activity)
            recViewActualHeroes.adapter = adapter
        }
    }


    override fun onCreateContextMenu(
        menu: ContextMenu,
        v: View,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)

    }


    override fun onContextItemSelected(item: MenuItem): Boolean {
        return super.onContextItemSelected(item)

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}

