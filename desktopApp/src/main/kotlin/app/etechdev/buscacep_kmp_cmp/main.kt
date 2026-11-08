package app.etechdev.buscacep_kmp_cmp

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "BuscaCep_KMP_CMP",
    ) {
        App()
    }
}