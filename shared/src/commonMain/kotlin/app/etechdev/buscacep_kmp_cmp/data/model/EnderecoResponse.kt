package app.etechdev.buscacep_kmp_cmp.data.model

import app.etechdev.buscacep_kmp_cmp.domain.model.Endereco
import kotlinx.serialization.Serializable

@Serializable
data class EnderecoResponse(
    val cep: String? = "",
    val logradouro: String? = "",
    val bairro: String? = "",
    val localidade: String? = "",
    val uf: String? = "",
    val erro: String? = ""
) {
    fun toDomain(): Endereco {
        return Endereco(
            cep = cep.orEmpty(),
            logradouro = logradouro.orEmpty(),
            bairro = bairro.orEmpty(),
            cidade = localidade.orEmpty(),
            uf = uf.orEmpty()
        )
    }
}