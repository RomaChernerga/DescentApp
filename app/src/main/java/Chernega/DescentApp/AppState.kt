package Chernega.DescentApp

sealed class AppState {
    data class Success(val heroes: Any): AppState()
    data class Error(val error: Throwable): AppState()
    object Loading: AppState()

}
