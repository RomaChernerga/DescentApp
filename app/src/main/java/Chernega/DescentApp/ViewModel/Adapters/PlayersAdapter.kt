package Chernega.DescentApp.ViewModel.Adapters

import Chernega.DescentApp.R
import Chernega.DescentApp.databinding.PlayersListViewBinding
import Chernega.DescentApp.model.PlayersModel
import Chernega.DescentApp.model.getPlayersModels
import Chernega.DescentApp.view.AboutFragment
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation


class PlayersAdapter : RecyclerView.Adapter<PlayersAdapter.Holder>() {
    var listener: OnItemClick? = null

    private val finalPlayersList = getPlayersModels()

    inner class Holder(item: View) : RecyclerView.ViewHolder(item) {

        private val binding = PlayersListViewBinding.bind(item)

        fun bind(player: PlayersModel) = with(binding) {
            itemView.apply {
                iViewLogo.load(player.logo) {
                    transformations(CircleCropTransformation())
                }
                tViewPlayer.text = player.playerName
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


                cardViewPlayer.setOnClickListener {
//                    listener?.onClick(player)
                    Toast.makeText(context,player.name, Toast.LENGTH_SHORT).show()

                }
                cardViewPlayer.setOnLongClickListener {
                    val popUp = PopupMenu(context, it, Gravity.CENTER)
                    popUp.inflate(R.menu.card_menu)
                    popUp.setOnMenuItemClickListener { item ->
                        when (item.itemId) {
                            R.id.about -> {
                                onAboutFragmentClick(player)
                            }
                            R.id.delete ->{Toast.makeText(context,"Delete", Toast.LENGTH_SHORT).show()}
                        }
                        true
                    }
                    popUp.show()
                    return@setOnLongClickListener true
                }
            }
        }

        private fun onAboutFragmentClick(player: PlayersModel, view: View) {
            val activity = view.context
            val aboutFr = AboutFragment()


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

    fun interface OnItemClick {
        fun onClick(player: PlayersModel)
    }

}