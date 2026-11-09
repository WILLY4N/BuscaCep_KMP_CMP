package app.etechdev.buscacep_kmp_cmp.data.remote

import app.etechdev.buscacep_kmp_cmp.data.model.EnderecoResponse

interface ViaCepApi {
    suspend fun buscarCep(cep: String): EnderecoResponse
}