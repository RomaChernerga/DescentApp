package Chernega.DescentApp

import Chernega.DescentApp.data.HeroesModel
import Chernega.DescentApp.data.getHeroesModels
import Chernega.DescentApp.databinding.ListViewBinding
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class HeroesAdapter : RecyclerView.Adapter<HeroesAdapter.Holder>() {

    val heroesList = ArrayList<HeroesModel>(getHeroesModels())

    class Holder(item: View): RecyclerView.ViewHolder(item) {
        private val binding = ListViewBinding.bind(item)
        fun bind(hero: HeroesModel) = with(binding) {
            iViewFace.setImageResource(hero.logo)
            tViewName.text = hero.name
            tViewType.text = hero.type
            tViewSpeed.text = "speed: " + hero.speed.toString()
            tViewHealth.text = "Health: " +hero.health.toString()
            tViewStamina.text = "Stamina: " +hero.stamina.toString()
            tViewDefDice.text = "DefDice: " +hero.defenceDie
            tViewStrength.text = "Strength: " +hero.strength.toString()
            tViewWillpower.text = "Willpower: " +hero.willpower.toString()
            tViewKnowledge.text = "Knowledge: " +hero.knowledge.toString()
            tViewAwareness.text = "Awareness: " +hero.knowledge.toString()
            tViewExpansion.text = hero.expansion
            tViewBr.text = "Rating: " +hero.br.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_view, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(heroesList[position])
    }

    override fun getItemCount(): Int {
        return heroesList.size
    }

}

