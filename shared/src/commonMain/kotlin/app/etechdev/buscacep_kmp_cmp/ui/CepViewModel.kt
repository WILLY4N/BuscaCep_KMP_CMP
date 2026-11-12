package app.etechdev.buscacep_kmp_cmp.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.etechdev.buscacep_kmp_cmp.data.model.EnderecoResponse
import app.etechdev.buscacep_kmp_cmp.data.repository.CepRepositoryImpl
import app.etechdev.buscacep_kmp_cmp.domain.repository.CepRepository
import kotlinx.coroutines.launch

class CepViewModel(
    private val cepRepository: CepRepository = CepRepositoryImpl()
) : ViewModel() {
    var cepInput by mutableStateOf("")
        private set

    var isTextFieldEnabled by mutableStateOf(true)
        private set

    var isLoading by mutableStateOf(false)
        private set

    var cepResult by mutableStateOf(EnderecoResponse())
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set

    val isCepValid: Boolean
        get() {
            val cleaned = cepInput.replace(Regex("[^0-9]"), "")
            return cleaned.length == 8
        }

    fun onCepChanged(newValue: String) {
        cepInput = newValue
    }

    fun consultarCep() {
        if (!isCepValid) return

        viewModelScope.launch {
            isLoading = true
            isTextFieldEnabled = false
            cepResult = EnderecoResponse()
            errorMessage = null

            try {
                val result = cepRepository.buscarCep(cepInput)

                kotlinx.coroutines.delay(2000) // Simular atraso de rede

                result.fold(
                    onSuccess = { endereco ->
                        cepResult = EnderecoResponse(
                            cep = endereco.cep,
                            logradouro = endereco.logradouro,
                            bairro = endereco.bairro,
                            localidade = endereco.cidade,
                            uf = endereco.uf
                        )
                    },
                    onFailure = { exception ->
                        errorMessage =
                            "Ocorreu um erro ao consultar o CEP. Aguarde um momento e tente novamente."
                    }
                )
            } catch (e: Exception) {
                errorMessage =
                    "Ocorreu um erro ao consultar o CEP. Aguarde um momento e tente novamente."
            } finally {
                isLoading = false
                isTextFieldEnabled = true
            }
        }
    }

    fun clearErrorMessage() {
        errorMessage = null
    }
}