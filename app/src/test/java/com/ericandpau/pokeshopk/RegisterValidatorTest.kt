package com.ericandpau.pokeshopk

import com.ericandpau.pokeshopk.validation.RegisterValidator
import junit.framework.TestCase.assertEquals
import kotlin.test.Test

class RegisterValidatorTest {

    @Test
    fun `test actualitzaNomUsuari retorna error si està buit`() {
        val resultat = RegisterValidator.actualitzaNomUsuari("")
        assertEquals("El nom d'usuari és obligatori", resultat)
    }

    @Test
    fun `test actualitzaNomUsuari retorna error si comença per símbol`() {
        val resultat = RegisterValidator.actualitzaNomUsuari("&usuari")
        assertEquals("El nom d'usuari no pot començar per símbol", resultat)
    }

    @Test
    fun `test actualitzaNomUsuari no retorna error si és correcte`() {
        val resultat = RegisterValidator.actualitzaNomUsuari("anakin123")
        assertEquals(null, resultat)
    }

    @Test
    fun `test actualitzaNom retorna error si està buit`() {
        val resultat = RegisterValidator.actualitzaNom("")
        assertEquals("El nom és obligatori", resultat)
    }

    @Test
    fun `test actualitzaCognom retorna error si està buit`() {
        val resultat = RegisterValidator.actualitzaCognom("")
        assertEquals("El cognom és obligatori", resultat)
    }

    @Test
    fun `test actualitzaCorreu retorna error si no és gmail`() {
        val resultat = RegisterValidator.actualitzaCorreu("usuari@hotmail.com")
        assertEquals("Només s’accepten correus @gmail.com", resultat)
    }

    @Test
    fun `test actualitzaCodiPostal retorna error si està buit`() {
        val resultat = RegisterValidator.actualitzaCodiPostal("")
        assertEquals("El codi postal és obligatori", resultat)
    }

    @Test
    fun `test actualitzaTelefon retorna error si té format incorrecte`() {
        val resultat = RegisterValidator.actualitzaTelefon("1234")
        assertEquals("El número de telèfon no és vàlid", resultat)
    }

}