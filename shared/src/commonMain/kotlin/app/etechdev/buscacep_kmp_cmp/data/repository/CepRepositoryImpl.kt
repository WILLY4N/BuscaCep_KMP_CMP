package app.etechdev.buscacep_kmp_cmp.data.repository

import app.etechdev.buscacep_kmp_cmp.data.remote.ViaCepApi
import app.etechdev.buscacep_kmp_cmp.data.remote.ViaCepApiImpl
import app.etechdev.buscacep_kmp_cmp.domain.model.Endereco
import app.etechdev.buscacep_kmp_cmp.domain.repository.CepRepository

class CepRepositoryImpl(
    private val api: ViaCepApi
) : CepRepository {

    constructor() : this(ViaCepApiImpl())

    override suspend fun buscarCep(cep: String): Result<Endereco> {
        return runCatching {
            val response = api.buscarCep(cep)
            if (response.erro.equals("true", ignoreCase = true)) {
                throw NoSuchElementException("CEP não encontrado.")
            }
            response.toDomain()
        }
    }
}