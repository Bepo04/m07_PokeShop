package com.ericandpau.pokeshopk.validation

object RegisterValidator {

    fun actualitzaNomUsuari(username: String): String? {
        if (username.isBlank()) return "El nom d'usuari és obligatori"
        if (username.firstOrNull()?.isLetterOrDigit() == false) return "El nom d'usuari no pot començar per símbol"
        return null
    }

    fun actualitzaNom(nom: String): String? {
        if (nom.isBlank()) return "El nom és obligatori"
        if (nom.trim().isEmpty()) return "El nom no pot contenir només espais en blanc"
        return null
    }

    fun actualitzaCognom(cognom: String): String? {
        if (cognom.isBlank()) return "El cognom és obligatori"
        if (cognom.trim().isEmpty()) return "El cognom no pot contenir només espais en blanc"
        return null
    }

    fun actualitzaCorreu(correu: String): String? {
        if (correu.isBlank()) return "El correu és obligatori"
        if (correu.trim().isEmpty()) return "El correu no pot contenir només espais en blanc"
        if (!correu.endsWith("@gmail.com")) return "Només s’accepten correus @gmail.com"
        return null
    }

    fun actualitzaAdreca(adreca: String): String? {
        if (adreca.isBlank()) return "L’adreça és obligatòria"
        if (adreca.trim().isEmpty()) return "L’adreça no pot contenir només espais en blanc"
        return null
    }

    fun actualitzaCodiPostal(codiPostal: String): String? {
        if (codiPostal.isBlank()) return "El codi postal és obligatori"
        val codi = codiPostal.toIntOrNull() ?: return "El codi postal no és vàlid"
        if (codi !in 1000..52999) return "El codi postal no és vàlid"
        return null
    }

    fun actualitzaTelefon(telefon: String): String? {
        if (telefon.isBlank()) return "El telèfon és obligatori"
        val regex = Regex("""^(\+34)?[6-7]\d{8}$""")
        if (!regex.matches(telefon)) return "El número de telèfon no és vàlid"
        return null
    }
}
