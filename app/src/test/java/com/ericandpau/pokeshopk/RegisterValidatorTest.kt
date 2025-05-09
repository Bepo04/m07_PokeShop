package com.ericandpau.pokeshopk

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.ericandpau.pokeshopk.validation.RegisterValidator
import com.ericandpau.pokeshopk.viewmodels.RegistreViewModel
import junit.framework.TestCase.assertEquals
import org.junit.Rule
import org.junit.Test
class RegisterValidatorTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private val viewModel = RegistreViewModel()

    @Test
    fun `test actualitzaNomUsuari retorna error si està buit`() {
        viewModel.setNomUsuari("")
        viewModel.actualitzaNomUsuari()
        assertEquals("El nom d'usuari és obligatori", viewModel.errorNomUsuari.value)
    }

    @Test
    fun `test actualitzaNomUsuari retorna error si comença per símbol`() {
        viewModel.setNomUsuari("&usuari")
        viewModel.actualitzaNomUsuari()
        assertEquals("El nom d'usuari no pot començar per símbol", viewModel.errorNomUsuari.value)
    }

    @Test
    fun `test actualitzaNomUsuari no retorna error si és correcte`() {
        viewModel.setNomUsuari("anakin123")
        viewModel.actualitzaNomUsuari()
        assertEquals("", viewModel.errorNomUsuari.value)
    }

    @Test
    fun `test actualitzaNom retorna error si està buit`() {
        viewModel.setNom("")
        viewModel.actualitzaNom()
        assertEquals("El nom és obligatori", viewModel.errorNom.value)
    }

    @Test
    fun `test actualitzaCognom retorna error si està buit`() {
        viewModel.setCognom("")
        viewModel.actualitzaCognom()
        assertEquals("El cognom és obligatori", viewModel.errorCognom.value)
    }

    @Test
    fun `test actualitzaCorreu retorna error si no és gmail`() {
        viewModel.setEmail("usuari@hotmail.com")
        viewModel.actualitzaCorreu()
        assertEquals("Només s’accepten correus @gmail.com", viewModel.errorEmail.value)
    }

    @Test
    fun `test actualitzaCodiPostal retorna error si està buit`() {
        viewModel.setCodPostal("")
        viewModel.actualitzaCodiPostal()
        assertEquals("El codi postal és obligatori", viewModel.errorCodPostal.value)
    }

    @Test
    fun `test actualitzaTelefon retorna error si té format incorrecte`() {
        viewModel.setTelf("1234")
        viewModel.actualitzaTelefon()
        assertEquals("El número de telèfon no és vàlid", viewModel.errorTelf.value)
    }

    @Test
    fun `test comparaContrassenyes retorna error si no coincideixen`() {
        viewModel.setPassword("SecurePass1!")
        viewModel.setPswdConfirmation("SecurePass2!")
        viewModel.comparaContrassenyes()
        assertEquals("Les contrassenyes no coincideixen", viewModel.errorPswdConfirmation.value)
    }

    @Test
    fun `test comparaContrassenyes no retorna error si coincideixen`() {
        viewModel.setPassword("SecurePass1!")
        viewModel.setPswdConfirmation("SecurePass1!")
        viewModel.comparaContrassenyes()
        assertEquals("", viewModel.errorPswdConfirmation.value)
    }
}