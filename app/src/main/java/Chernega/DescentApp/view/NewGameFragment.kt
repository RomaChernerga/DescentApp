package Chernega.DescentApp.view

import Chernega.DescentApp.ViewModel.Adapters.PlayersAdapter
import Chernega.DescentApp.model.*
import Chernega.DescentApp.databinding.FragmentNewGameBinding
import android.os.Bundle
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
        val countPlayers: Int = 6
            /* 1.СОЗДАНИЕ ГРАНИЦ ПО БОЕВОМУ РЕЙТИНГУ */
        var maxBr = 0
        var minBr = 0
        var sumBr = 0
        for (i in getHeroesModels().size - 1 downTo getHeroesModels().size - countPlayers) {
            maxBr += getHeroesModels()[i].br.toInt()
        }
        for (i in 0 until  countPlayers) {
            minBr += getHeroesModels()[i].br.toInt()
        }
        for (hero in getHeroesModels()) {
            sumBr += hero.br.toInt()
        }
        val scoreHeroes = ((Math.random() * (maxBr - minBr) + 1) + minBr);



        /*! 2.СОЗДАНИЕ РАНДОМНЫХ ГЕРОЕВ */
        val randomHeroes: HashSet<HeroesModel> = HashSet() // <- сюда будем копировать
        val rnd = Random()
        var checkBr = 0

        do {
            for (i in 0 until countPlayers) {
                val randomNumber = rnd.nextInt(getHeroesModels().size)
                val randomHero: HeroesModel = getHeroesModels()[randomNumber]
                randomHeroes.add(randomHero)
                checkBr += randomHero.br.toInt()
            }
        } while (randomHeroes.size != countPlayers && (scoreHeroes - checkBr > 2 || checkBr - scoreHeroes > 2))

        /*! 3. ИМЕНА ИГРОКОВ */
        val playersList : MutableList<PlayersModel> = getPlayersModels()
        var player = "player_"

        for (i in 0 until countPlayers) {
            player += (i + 1)
            playersList.add(PlayersModel(player, 0, "", "", 0, 0, 0,"",0,0,0,0,"",0.0 ))
            val sb = StringBuilder(player)
            sb.delete(7, sb.length)
            player = sb.toString()
        }

        /* 3.1. ПРИСВОЕНИЯ ИМЕНИ И РЕЙТИНГА ГЕРОЕВ В ОБЩИЙ ЛИСТ */
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
    }


}