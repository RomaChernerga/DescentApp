package Chernega.DescentApp.ViewModel.Adapters

import Chernega.DescentApp.R
import Chernega.DescentApp.model.HeroesModel
import Chernega.DescentApp.model.getHeroesModels
import Chernega.DescentApp.databinding.ListViewBinding
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation


class HeroesAdapter : RecyclerView.Adapter<HeroesAdapter.Holder>() {

    private val heroesList = ArrayList<HeroesModel>(getHeroesModels())

    class Holder(item: View): RecyclerView.ViewHolder(item) {
        private val binding = ListViewBinding.bind(item)

        fun bind(hero: HeroesModel) = with(binding) {
            iViewLogo.load(hero.logo){
                transformations(CircleCropTransformation())
            }
            tViewName.text = "name: " + hero.name
            tViewType.text = "type: " + hero.type
            tViewSpeed.text = "speed: " + hero.speed.toString()
            tViewHealth.text = "Health: " +hero.health.toString()
            tViewStamina.text = "Stamina: " +hero.stamina.toString()
            tViewDefDice.text = "DefDice: " +hero.defenceDie
            tViewStrength.text = "Strength: " +hero.strength.toString()
            tViewWillpower.text = "Willpower: " +hero.willpower.toString()
            tViewKnowledge.text = "Knowledge: " +hero.knowledge.toString()
            tViewAwareness.text = "Awareness: " +hero.knowledge.toString()
            tViewExpansion.text = "expansion: " + hero.expansion
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



