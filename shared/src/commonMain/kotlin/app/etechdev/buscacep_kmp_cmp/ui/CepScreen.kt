package app.etechdev.buscacep_kmp_cmp.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.etechdev.buscacep_kmp_cmp.ui.components.CepInputComponent
import app.etechdev.buscacep_kmp_cmp.ui.components.CepResultComponent

@Composable
fun CepScreen(viewModel: CepViewModel) {
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(viewModel.errorMessage) {
        viewModel.errorMessage?.let { message ->
            snackbarHostState.showSnackbar(message)
            viewModel.clearErrorMessage()
        }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            CepInputComponent(
                cepValue = viewModel.cepInput,
                isTextFieldEnabled = viewModel.isTextFieldEnabled,
                isButtonEnabled = viewModel.isCepValid,
                isLoading = viewModel.isLoading,
                onCepChanged = viewModel::onCepChanged,
                onSearchClick = viewModel::consultarCep
            )

            CepResultComponent(
                cepResult = viewModel.cepResult
            )
        }
    }
}