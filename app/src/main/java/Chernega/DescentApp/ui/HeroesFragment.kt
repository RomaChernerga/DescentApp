package Chernega.DescentApp.ui

import Chernega.DescentApp.HeroesAdapter
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
    /** СПИСОК ГЕРОЕВ */
//    private val heroes = listOf(
//        HeroesModel("Lord_Hawthorne", "Warrior",4,12,3,"Grey",4,2,3,2,	"Guardians of Deephall",44.57),
//        HeroesModel("Avric_Albright","Healer",4,12,4,"Grey",2,4,3,2,"Descent 2ed",44.5199999999999),
//        HeroesModel("Sir_Valadir","Warrior",4,12,4,"Grey",3,4,3,1,"Visions of Darkness",43.57),
//        HeroesModel("Lyssa","Mage",5,8,5,"Grey",2,2,3,4,"Bonds of the Wild",42.1666666666666),
//        HeroesModel("Mordrog","Warrior",4,14,4,"Grey",5,3,1,2,"Guardians of Deephall",43.6366666666666),
//        HeroesModel("Tatianna","Scout",5,12,4,"Grey",2,2,2,5,"Stewards of the Secret",42.8),
//        HeroesModel("Krutzbeck","Warrior",3,12,4,"Grey",4,3,2,2,"Treaty of Champions",42.3399999999999),
//        HeroesModel("Trenloe_The_Strong","Warrior",3,12,3,"Grey",4,4,1,2,"Oath of the Outcast",42.04),
//        HeroesModel("Widow_Tarha","Mage",4,10,4,"Grey",2,3,4,2,"Descent 2ed",41.0533333333333),
//        HeroesModel("Leorik_Of_TheBook","Mage",4,8,5,"Grey",1,2,5,3,"Descent 2ed",40.0866666666666),
//        HeroesModel("Steelhorns","Warrior",4,14,3,"Grey",5,3,1,2,"Shards of Everdark",41.9366666666666),
//        HeroesModel("Lindel","Scout",5,10,5,"Grey",3,3,3,3,"Crown of Destiny",40.5833333333333),
//        HeroesModel("Augur_Grisom","Healer",3,12,5,"Grey",4,3,2,2,"The Trollfens",40.9899999999999),
//        HeroesModel("Corbin","Warrior",3,12,5,"Grey",5,2,2,2,"Crown of Destiny",40.69),
//        HeroesModel("Shiver","Mage",4,10,4,"Grey",2,3,3,3,"Oath of the Outcast",39.9533333333333),
//        HeroesModel("Nara_The_Fang","Warrior",5,10,4,"Grey",4,2,1,4,"Visions of Darkness",39.9333333333333),
//        HeroesModel("Jaine_Fairwood","Scout",5,8,5,"Grey",2,2,3,4,"Descent 2ed",39.1166666666666),
//        HeroesModel("Karnon","Warrior",4,14,3,"Grey",6,2,1,2,"Shards of Everdark",40.8866666666666),
//        HeroesModel("Brother_Gherinn","Healer",3,12,4,"Grey",1,4,4,2,"Crown of Destiny",40.19),
//        HeroesModel("Ashrian","Healer",5,10,4,"Grey",2,3,2,4,"Descent 2ed",39.1833333333333),
//        HeroesModel("Nanok_Of_The_Blade","Warrior",4,12,4,"black",4,2,2,3,"Stewards of the Secret",48.77),
//        HeroesModel("Grisban_The_Thirsty","Warrior",3,14,4,"Grey",5,3,2,1,"Descent 2ed",40.3566666666666),
//        HeroesModel("Andira_Runehand","Healer",4,12,4,"Grey",2,4,3,2,"Crusade of the Forgotten",39.67),
//        HeroesModel("Ispher","Healer",4,10,4,"Grey",2,3,3,3,"Visions of Darkness",38.9533333333333),
//        HeroesModel("Alys_Raine","Warrior",4,12,4,"Grey",3,3,4,1,"Manor of Ravens",39.52),
//        HeroesModel("Reynhart_The_Worthy","Warrior",4,12,4,"Grey",3,4,1,3,"Lair of the Wyrm",39.52),
//        HeroesModel("Seer_Kel","Mage",4,10,4,"Grey",1,2,4,4,"Stewards of the Secret",38.8033333333333),
//        HeroesModel("Tahlia","Warrior",3,14,4,"Grey",3,3,2,3,"Crusade of the Forgotten",40.0066666666666),
//        HeroesModel("Jaes_The_Exile","Mage",4,12,3,"Grey",3,2,4,2,"Crown of Destiny",39.32),
//        HeroesModel("Vyrah_The_Falconer","Scout",4,10,4,"Grey",3,2,2,4,"Bonds of the Wild",38.6533333333333),
//        HeroesModel("Syndrael","Warrior",4,12,4,"Grey",4,2,3,2,"Descent 2ed",38.87),
//        HeroesModel("Pathfinder_Durik","Warrior",5,10,4,"Grey",3,2,2,4,"Labyrinth of Ruin",37.8833333333333),
//        HeroesModel("Tetherys","Scout",4,10,4,"Grey",3,1,2,5,"Crusade of the Forgotten",37.6533333333333),
//        HeroesModel("Challara","Mage",3,10,4,"Grey",3,3,4,1,"Bonds of the Wild",37.6002564102564),
//        HeroesModel("Grey Ker","Scout",4,12,5,"Grey",3,3,2,4,"Treaty of Champions",38.17),
//        HeroesModel("Jonas_The_Kind","Healer",4,10,4,"Grey",2,4,3,2,"Treaty of Champions",37.5033333333333),
//        HeroesModel("Roganna the Shade","Scout",5,10,4,"Grey",2,4,2,3,"The Trollfens",37.4333333333333),
//        HeroesModel("Astarra","Mage",4,10,5,"Grey",1,4,4,2,"Crusade of the Forgotten",37.4033333333333),
//        HeroesModel("Laurel_Of_Bloodwood","Scout",4,8,5,"Grey",2,2,3,4,"Oath of the Outcast",36.5866666666666),
//        HeroesModel("High_Mage_Quellen","Mage",4,10,4,"Grey",1,3,5,2,"Lair of the Wyrm",37.0033333333333),
//        HeroesModel("Logan_Lashley","Scout",4,10,4,"Grey",3,2,2,4,"Labyrinth of Ruin",37.0033333333333),
//        HeroesModel("Silhouette","Scout",5,10,4,"Grey",3,1,2,5,"Guardians of Deephall",36.8833333333333),
//        HeroesModel("Orkell_The_Swift","Warrior",5,10,5,"brown",4,2,1,4,"Shadow of Nerekhall",30.8166666666666),
//        HeroesModel("Elder_Mok","Healer",4,10,4,"Grey",2,4,3,2,"Oath of the Outcast",35.7033333333333),
//        HeroesModel("One_Fist","Warrior",4,10,4,"Grey",3,3,2,3,"Shards of Everdark",35.6533333333333),
//        HeroesModel("Ravaella_Lightfoot","Mage",4,8,5,"black",1,2,4,4,"Shadow of Nerekhall",40.5533333333333),
//        HeroesModel("Zyla","Mage",5,8,5,"Grey",1,3,4,3,"Treaty of Champions",34.6166666666666),
//        HeroesModel("Sahla","Healer",4,10,4,"Grey",2,3,3,3,"Guardians of Deephall",35.2533333333333),
//        HeroesModel("Tomble_Burrowell","Scout",4,8,5,"Grey",1,3,2,5,"Descent 2ed",34.5866666666666),
//        HeroesModel("Raythen","Scout",4,14,5,"brown",3,1,2,5,"Raythen Lieutenant Pack",28.1033333333333),
//        HeroesModel("Tinashi_The_Wanderer","Scout",4,12,4,"Grey",3,3,2,3,"Shadow of Nerekhall",35.67),
//        HeroesModel("Arvel_Worldwalker","Scout",4,10,4,"Grey",3,3,3,3,"Shards of Everdark",34.7783333333333),
//        HeroesModel("Master_Thorn","Mage",5,8,4,"Grey",1,3,5,2,"Visions of Darkness",33.6666666666666),
//        HeroesModel("Serena","Healer",3,8,6,"brown",1,5,3,2,"Serena Lieutenant Pack",29.3233333333333),
//        HeroesModel("Thaiden_Mistpeak","Scout",4,10,5,"Grey",3,2,1,5,"Manor of Ravens",34.1533333333333),
//        HeroesModel("Okaluk_And_Rakash","Healer",2,8,3,"Grey",3,3,2,3,"Stewards of the Secret",33.3266666666666),
//        HeroesModel("Rendiel","Healer",5,10,4,"Grey",2,5,3,1,"Shadow of Nerekhall",33.6333333333333),
//        HeroesModel("Ronan_Of_The_Wild","Scout",4,10,5,"Grey",3,4,1,3,"Bonds of the Wild",33.40333333333),
//        HeroesModel("Dezra_The_Vile","Mage",5,8,4,"Grey",2,2,4,3,"Labyrinth of Ruin",32.5666666666666),
//        HeroesModel("Ulma_Grimstone","Healer",4,8,5,"Grey",2,3,4,2,"Labyrinth of Ruin",30.5866666666666)
//    )


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