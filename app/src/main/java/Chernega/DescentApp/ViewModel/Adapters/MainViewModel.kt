package Chernega.DescentApp.ViewModel.Adapters

import Chernega.DescentApp.AppState
import Chernega.DescentApp.R
import Chernega.DescentApp.model.PlayersList
import Chernega.DescentApp.model.PlayersListImpl
import Chernega.DescentApp.view.HeroesFragment
import Chernega.DescentApp.view.MainFragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.lang.Thread.sleep

class MainViewModel: ViewModel() {

    private val liveDataToObserve: MutableLiveData<AppState> = MutableLiveData()
    private val playersList : PlayersList = PlayersListImpl()


}