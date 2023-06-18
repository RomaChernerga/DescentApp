package Chernega.DescentApp.model

class PlayersListImpl : PlayersList {
    override fun savePlayersList(){
        TODO("Not yet implemented")
    }

    override fun loadPlayersList(): PlayersModel {
        TODO("Not yet implemented")
    }

    override fun deletePlayersList(){
        playersList.removeAll(playersList)
    }
}