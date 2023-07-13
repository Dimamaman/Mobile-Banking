package uz.gita.dima.mobile_banking.domain.usecase

interface StartScreenUseCase {
    suspend fun startScreen(): StartScreen
}

enum class StartScreen {
    PIN, LOGIN
}