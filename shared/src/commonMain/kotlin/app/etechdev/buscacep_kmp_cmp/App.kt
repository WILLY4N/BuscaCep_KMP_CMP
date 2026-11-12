package app.etechdev.buscacep_kmp_cmp

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import app.etechdev.buscacep_kmp_cmp.ui.CepScreen
import app.etechdev.buscacep_kmp_cmp.ui.CepViewModel

@Composable
@Preview
fun App() {
    MaterialTheme {
        val viewModel = viewModel { CepViewModel() }
        CepScreen(viewModel = viewModel)
    }
}