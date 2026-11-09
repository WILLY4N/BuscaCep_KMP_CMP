package app.etechdev.buscacep_kmp_cmp.domain.repository

import app.etechdev.buscacep_kmp_cmp.domain.model.Endereco

interface CepRepository {
    suspend fun buscarCep(cep: String): Result<Endereco>

    @Throws(Exception::class)
    suspend fun buscarCepOrThrow(cep: String): Endereco = buscarCep(cep).getOrThrow()
}