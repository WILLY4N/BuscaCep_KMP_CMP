package app.etechdev.buscacep_kmp_cmp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.etechdev.buscacep_kmp_cmp.data.model.EnderecoResponse

@Composable
fun CepResultComponent(
    modifier: Modifier = Modifier,
    cepResult: EnderecoResponse
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(text = "CEP: ${cepResult.cep}")
        Text(text = "Logradouro: ${cepResult.logradouro}")
        Text(text = "Bairro: ${cepResult.bairro}")
        Text(text = "Localidade: ${cepResult.localidade}")
        Text(text = "UF: ${cepResult.uf}")
    }
}

@Preview(showBackground = true, name = "Resultado do CEP")
@Composable
private fun CepResultComponentPreview() {
    CepResultComponent(
        cepResult = EnderecoResponse(
            cep = "01001-000",
            logradouro = "Praça da Sé",
            bairro = "Sé",
            localidade = "São Paulo",
            uf = "SP"
        )
    )
}