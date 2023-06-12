package Chernega.DescentApp.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class DataModel: ViewModel() {
    val players: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
}