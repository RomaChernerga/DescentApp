package Chernega.DescentApp.view

import Chernega.DescentApp.ViewModel.Adapters.PlayersAdapter
import Chernega.DescentApp.model.*
import Chernega.DescentApp.databinding.FragmentNewGameBinding
import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Parcelable
import android.preference.PreferenceManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager
import java.util.*
import kotlin.collections.ArrayList


class NewGameFragment : Fragment() {
    private var _binding: FragmentNewGameBinding? = null
    private val binding get() = _binding
    private val dataModel: DataModel by activityViewModels()
    private val adapter = PlayersAdapter()
    private val list = ArrayList<HeroesModel>(getHeroesModels())
    private val countPlayers: Int = 6
    private var scoreHeroes: Double = 0.0
    private var player = "player_"

   var playersList : MutableList<PlayersModel> = ArrayList()





    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mainJob()
        // Inflate the layout for this fragment
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



    private fun mainJob() {

        createMaxAndMinBr(list)   /** 1СОЗДАНИЕ ГРАНИЦ ПО БОЕВОМУ РЕЙТИНГУ */

        createRandomHeroes()        /** 2.СОЗДАНИЕ РАНДОМНЫХ ГЕРОЕВ */

        createPlayersList_with_Names() /** 3 ИМЕНА ИГРОКОВ  */

        createFinalList(createPlayersList_with_Names()) /** 4 ПРИСВОЕНИЯ ИМЕНИ И РЕЙТИНГА ГЕРОЕВ В ОБЩИЙ ЛИСТ*/



    }





    private fun createMaxAndMinBr(list: List<HeroesModel>) {
        /* 1.СОЗДАНИЕ ГРАНИЦ ПО БОЕВОМУ РЕЙТИНГУ */
        var maxBr = 0
        var minBr = 0
        var sumBr = 0
        for (i in list.size - 1 downTo list.size - countPlayers) {
            maxBr += getHeroesModels()[i].br.toInt()
        }
        for (i in 0 until  countPlayers) {
            minBr += list[i].br.toInt()
        }
        for (hero in list) {
            sumBr += hero.br.toInt()
        }
        scoreHeroes = ((Math.random() * (maxBr - minBr) + 1) + minBr)
    }

    private fun createRandomHeroes(): HashSet<HeroesModel> {

        /*! 2.СОЗДАНИЕ РАНДОМНЫХ ГЕРОЕВ */
        val randomHeroes: HashSet<HeroesModel> = HashSet() // <- сюда будем копировать
        val rnd = Random()
        var checkBr = 0

        do {
            for (i in 0 until countPlayers) {
                val randomNumber = rnd.nextInt(list.size)
                val randomHero: HeroesModel = list[randomNumber]
                randomHeroes.add(randomHero)
                checkBr += randomHero.br.toInt()
            }
        } while (randomHeroes.size != countPlayers && (scoreHeroes - checkBr > 2 || checkBr - scoreHeroes > 2))

        return randomHeroes;

    }

    private fun createPlayersList_with_Names(): MutableList<PlayersModel> {

        /*! 3. ИМЕНА ИГРОКОВ */


        for (i in 0 until countPlayers) {
            player += (i + 1)
            playersList.add(PlayersModel(player, 0, "", "", 0, 0, 0,"",0,0,0,0,"",0.0 ))
            val sb = StringBuilder(player)
            sb.delete(7, sb.length)
            player = sb.toString()
        }
        return playersList
    }

    private fun createFinalList(playersList: MutableList<PlayersModel>): MutableList<PlayersModel> {

        /* 3.1. ПРИСВОЕНИЯ ИМЕНИ И РЕЙТИНГА ГЕРОЕВ В ОБЩИЙ ЛИСТ */
        val randomHeroes = createRandomHeroes()
        val randomHeroesLIST: List<HeroesModel> = ArrayList(randomHeroes)

        try {
            for (i in 0 until playersList.size) {
                playersList[i].name = randomHeroesLIST[i].name
                playersList[i].type = randomHeroesLIST[i].type
                playersList[i].speed = randomHeroesLIST[i].speed
                playersList[i].health = randomHeroesLIST[i].health
                playersList[i].stamina = randomHeroesLIST[i].stamina
                playersList[i].defenceDie = randomHeroesLIST[i].defenceDie
                playersList[i].strength = randomHeroesLIST[i].strength
                playersList[i].willpower = randomHeroesLIST[i].willpower
                playersList[i].knowledge = randomHeroesLIST[i].knowledge
                playersList[i].awareness = randomHeroesLIST[i].awareness
                playersList[i].expansion = randomHeroesLIST[i].expansion
                playersList[i].type = randomHeroesLIST[i].type
                playersList[i].br = randomHeroesLIST[i].br.toInt().toDouble()
            }
        } catch (e: IndexOutOfBoundsException) {
            e.printStackTrace()
        }


        return playersList



    }




}

