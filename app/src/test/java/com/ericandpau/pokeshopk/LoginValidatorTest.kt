package com.ericandpau.pokeshopk

import com.ericandpau.pokeshopk.validation.LoginValidator
import junit.framework.TestCase.assertEquals
import org.junit.Test

class LoginValidatorTest {

    @Test
    fun `test comprovaTextNoBuit retorna error si està buit`() {
        val resultat = LoginValidator.comprovaUsuari("")
        assertEquals("El nom d'usuari és obligatori", resultat)
    }

    @Test
    fun `test comprovaTextNoBuit retorna error si només té espais`() {
        val resultat = LoginValidator.comprovaUsuari("    ")
        assertEquals("El nom d'usuari és obligatori", resultat)
    }

    @Test
    fun `test comprovaTextNoBuit no retorna error si té contingut`() {
        val resultat = LoginValidator.comprovaEmail("han.solo")
        assertEquals(null, resultat)
    }

    @Test
    fun `test comprovaContrasenya retorna error si està buida`() {
        val resultat = LoginValidator.comprovaContrasenya("")
        assertEquals("La contrasenya és obligatòria", resultat)
    }

    @Test
    fun `test comprovaContrasenya retorna error si és massa curta`() {
        val resultat = LoginValidator.comprovaContrasenya("1234")
        assertEquals("La contrasenya ha de tenir com a mínim 8 caràcters", resultat)
    }

    @Test
    fun `test comprovaContrasenya retorna error si falta complexitat`() {
        val resultat = LoginValidator.comprovaContrasenya("abcdefg8")
        assertEquals("La contrasenya ha de contenir almenys una majúscula, una minúscula, un número i un símbol", resultat)
    }

    @Test
    fun `test comprovaContrasenya retorna error si contrasenya és fàcil`() {
        val resultat = LoginValidator.comprovaContrasenya("12345678")
        assertEquals("La contrasenya és massa fàcil, tria una contrasenya més segura", resultat)
    }

    @Test
    fun `test comprovaContrasenya no retorna error si és correcta`() {
        val resultat = LoginValidator.comprovaContrasenya("SecurePass1!")
        assertEquals(null, resultat)
    }
}
