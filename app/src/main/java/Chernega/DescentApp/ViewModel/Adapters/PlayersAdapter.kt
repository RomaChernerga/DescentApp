package Chernega.DescentApp.ViewModel.Adapters

import Chernega.DescentApp.R
import Chernega.DescentApp.model.PlayersModel

import Chernega.DescentApp.databinding.PlayersListViewBinding

import Chernega.DescentApp.view.NewGameFragment
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList
import kotlin.reflect.KMutableProperty1

class PlayersAdapter : RecyclerView.Adapter<PlayersAdapter.Holder>() {

//        private val playersList = ArrayList<PlayersModel>()
//    private val newGameFragment: NewGameFragment = NewGameFragment()

    val list: KMutableProperty1<NewGameFragment, MutableList<PlayersModel>> = NewGameFragment::playersList

    val finalPlayersList: ArrayList<PlayersModel> = ArrayList(list)




    class Holder(item: View) : RecyclerView.ViewHolder(item) {
        private val binding = PlayersListViewBinding.bind(item)
        fun bind(player: PlayersModel) = with(binding) {
            tViewName.text = "name: " + player.name
            tViewName.text = "name: " + player.name
            tViewType.text = "type: " + player.type
            tViewSpeed.text = "speed: " + player.speed.toString()
            tViewHealth.text = "Health: " + player.health.toString()
            tViewStamina.text = "Stamina: " + player.stamina.toString()
            tViewDefDice.text = "DefDice: " + player.defenceDie
            tViewStrength.text = "Strength: " + player.strength.toString()
            tViewWillpower.text = "Willpower: " + player.willpower.toString()
            tViewKnowledge.text = "Knowledge: " + player.knowledge.toString()
            tViewAwareness.text = "Awareness: " + player.knowledge.toString()
            tViewExpansion.text = "expansion: " + player.expansion
            tViewBr.text = "Rating: " + player.br.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.players_list_view, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(finalPlayersList[position])
    }

    override fun getItemCount(): Int = finalPlayersList.size

}