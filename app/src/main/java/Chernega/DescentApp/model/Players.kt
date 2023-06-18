package Chernega.DescentApp.model


import Chernega.DescentApp.view.playersCount
import android.os.Bundle
import java.util.Random
import kotlin.coroutines.startCoroutine


fun players() {
    mainJob()
}


private val list = ArrayList<HeroesModel>(getHeroesModels())
private val countPlayers: Int = playersCount
private var scoreHeroes: Double = 0.0
val rnd = Random()
var checkBr = 0
private var player = "player_"
var maxBr = 0



val bundle = Bundle()
var playersList: MutableList<PlayersModel> = mutableListOf()

fun mainJob() {

    createMaxAndMinBr(list)
    /** 1СОЗДАНИЕ ГРАНИЦ ПО БОЕВОМУ РЕЙТИНГУ */



    createRandomHeroes()
    /** 2.СОЗДАНИЕ РАНДОМНЫХ ГЕРОЕВ */

//    createPlayersList_with_Names()
//    /** 3 ИМЕНА ИГРОКОВ  */

    createFinalList(playersList)
    /** 4 ПРИСВОЕНИЯ ИМЕНИ И РЕЙТИНГА ГЕРОЕВ В ОБЩИЙ ЛИСТ*/


}

fun createMaxAndMinBr(list: List<HeroesModel>): Int {

    /* 1.СОЗДАНИЕ ГРАНИЦ ПО БОЕВОМУ РЕЙТИНГУ */

    var minBr = 0
    var sumBr = 0

    for( i in 0 until countPlayers) {
        maxBr += getHeroesModels()[i].br.toInt()
    }



    for (i in 0 until countPlayers) {
        minBr += list[i].br.toInt()
    }
    for (hero in list) {
        sumBr += hero.br.toInt()
    }
    scoreHeroes = ((Math.random() * (maxBr - minBr) + 1) + minBr)
    return maxBr
}



private fun createRandomHeroes(): HashSet<HeroesModel> {

    /*! 2.СОЗДАНИЕ РАНДОМНЫХ ГЕРОЕВ */
    val randomHeroes: HashSet<HeroesModel> = HashSet() // <- сюда будем копировать


    do {
        for (i in 0 until countPlayers) {
            val randomNumber = rnd.nextInt(list.size)
            val randomHero: HeroesModel = list[randomNumber]
            randomHeroes.add(randomHero)
            checkBr += randomHero.br.toInt()
        }
    } while (randomHeroes.size != countPlayers && (scoreHeroes - checkBr > 2 || checkBr - scoreHeroes > 2))

    return randomHeroes

}


private fun createFinalList(playersList: MutableList<PlayersModel>): MutableList<PlayersModel> {
    /*! 3. ИМЕНА ИГРОКОВ */


    for (i in 0 until countPlayers) {
        player += (i + 1)
        playersList.add(PlayersModel(player, 0, "", "", 0, 0, 0, "", 0, 0, 0, 0, "", 0.0))
        val sb = StringBuilder(player)
        sb.delete(7, sb.length)
        player = sb.toString()
    }


    /* 3.1. ПРИСВОЕНИЯ ИМЕНИ И РЕЙТИНГА ГЕРОЕВ В ОБЩИЙ ЛИСТ */
    val randomHeroes = createRandomHeroes()
    val randomHeroesLIST: List<HeroesModel> = ArrayList(randomHeroes)

    try {
        for (i in 0 until playersList.size) {
            playersList[i].logo = randomHeroesLIST[i].logo
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


fun getPlayersModels(): MutableList<PlayersModel> {

    return playersList

}


