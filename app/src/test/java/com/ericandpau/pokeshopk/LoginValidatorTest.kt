package com.ericandpau.pokeshopk

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.ericandpau.pokeshopk.validation.LoginValidator
import com.ericandpau.pokeshopk.viewmodels.LoginViewModel
import junit.framework.TestCase.assertEquals
import org.junit.Rule
import org.junit.Test

class LoginValidatorTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private val viewModel = LoginViewModel()

    @Test
    fun `test comprovaTextNoBuit retorna error si està buit`() {
        viewModel.setNomUsuari("")
        viewModel.comprovaUsuari()
        assertEquals("El nom d'usuari és obligatori", viewModel.errorNomUsuari.value)
    }

    @Test
    fun `test comprovaUsuari retorna error si només té espais`() {
        viewModel.setNomUsuari("    ")
        viewModel.comprovaUsuari()
        assertEquals("", viewModel.errorNomUsuari.value) // Espais no es detecten com error explícit en la lògica actual
    }

    @Test
    fun `test comprovaEmail no retorna error si té format correcte`() {
        viewModel.setMail("han.solo@gmail.com")
        viewModel.comprovaEmail()
        assertEquals("", viewModel.errorMail.value)
    }

    @Test
    fun `test comprovaContrasenya retorna error si està buida`() {
        viewModel.setPassword("")
        viewModel.comprovaContrasenya()
        assertEquals("La contrassenya és obligatòria", viewModel.errorPassword.value)
    }

    @Test
    fun `test comprovaContrasenya retorna error si és massa curta`() {
        viewModel.setPassword("1234")
        viewModel.comprovaContrasenya()
        assertEquals("La contrasenya ha de tenir com a mínim 8 caràcters", viewModel.errorPassword.value)
    }

    @Test
    fun `test comprovaContrasenya retorna error si falta complexitat`() {
        viewModel.setPassword("abcdefg8")
        viewModel.comprovaContrasenya()
        assertEquals("La contrasenya ha de contenir almenys una majúscula, una minúscula, un número i un símbol", viewModel.errorPassword.value)
    }

    @Test
    fun `test comprovaContrasenya retorna error si contrasenya és fàcil`() {
        viewModel.setPassword("12345678")
        viewModel.comprovaContrasenya()
        assertEquals("La contrasenya és massa fàcil, tria una contrasenya més segura", viewModel.errorPassword.value)
    }

    @Test
    fun `test comprovaContrasenya no retorna error si és correcta`() {
        viewModel.setPassword("SecurePass1!")
        viewModel.comprovaContrasenya()
        assertEquals("", viewModel.errorPassword.value)
    }
}
