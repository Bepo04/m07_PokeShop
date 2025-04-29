package com.ericandpau.pokeshopk.validation

object LoginValidator {

    fun comprovaUsuari(text: String): String? {
        return when {
            text.isBlank() -> "El nom d'usuari és obligatori"
            else -> null
        }
    }

    fun comprovaEmail(email: String): String? {
        return when {
            email.isBlank() -> "El correu és obligatori"
            else -> null
        }
    }

    fun comprovaContrasenya(password: String): String? {
        if (password.isBlank()) return "La contrasenya és obligatòria"
        if (password.trim().isEmpty()) return "La contrasenya no pot contenir només espais en blanc"
        if (password.length < 8) return "La contrasenya ha de tenir com a mínim 8 caràcters"

        val contrasenyesFacils = listOf("12345678", "password", "qwerty", "11111111")
        if (contrasenyesFacils.contains(password)) {
            return "La contrasenya és massa fàcil, tria una contrasenya més segura"
        }

        if (!password.any { it.isUpperCase() } ||
            !password.any { it.isLowerCase() } ||
            !password.any { it.isDigit() } ||
            !password.any { !it.isLetterOrDigit() }) {
            return "La contrasenya ha de contenir almenys una majúscula, una minúscula, un número i un símbol"
        }

        return null
    }
}
