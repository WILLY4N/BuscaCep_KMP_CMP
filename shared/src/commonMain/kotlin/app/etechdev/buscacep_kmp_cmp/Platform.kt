package app.etechdev.buscacep_kmp_cmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform