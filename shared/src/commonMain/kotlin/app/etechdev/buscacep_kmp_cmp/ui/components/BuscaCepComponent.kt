package app.etechdev.buscacep_kmp_cmp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CepInputComponent(
    modifier: Modifier = Modifier,
    cepValue: String,
    isTextFieldEnabled: Boolean,
    isButtonEnabled: Boolean,
    isLoading: Boolean,
    onCepChanged: (String) -> Unit,
    onSearchClick: () -> Unit
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        OutlinedTextField(
            value = cepValue,
            onValueChange = onCepChanged,
            label = { Text("Digite o CEP") },
            enabled = isTextFieldEnabled,
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        ElevatedButton(
            onClick = onSearchClick,
            enabled = isButtonEnabled && !isLoading,
            modifier = Modifier.fillMaxWidth()
        ) {
            if (isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.size(24.dp),
                    strokeWidth = 2.dp,
                    color = MaterialTheme.colorScheme.primary
                )
            } else {
                Text("Buscar")
            }
        }
    }
}

@Preview(showBackground = true, name = "Estado Padrão")
@Composable
private fun CepInputComponentPreview() {
    Surface(modifier = Modifier.padding(16.dp)) {
        CepInputComponent(
            cepValue = "",
            onCepChanged = {},
            isTextFieldEnabled = true,
            isButtonEnabled = false,
            isLoading = false,
            onSearchClick = {}
        )
    }
}

@Preview(showBackground = true, name = "Com CEP Preenchido")
@Composable
private fun CepInputComponentFilledPreview() {
    Surface(modifier = Modifier.padding(16.dp)) {
        CepInputComponent(
            cepValue = "01001-000",
            onCepChanged = {},
            isTextFieldEnabled = true,
            isButtonEnabled = true,
            isLoading = false,
            onSearchClick = {}
        )
    }
}

@Preview(showBackground = true, name = "Carregando (Loading)")
@Composable
private fun CepInputComponentLoadingPreview() {
    Surface(modifier = Modifier.padding(16.dp)) {
        CepInputComponent(
            cepValue = "01001-000",
            onCepChanged = {},
            isTextFieldEnabled = false,
            isButtonEnabled = true,
            isLoading = true,
            onSearchClick = {}
        )
    }
}