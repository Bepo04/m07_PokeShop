package com.ericandpau.pokeshopk.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    private var _nomUsuari:String = ""
    private var _password:String = ""
    private var _mail:String = ""

    private val _errorNomUsuari=MutableLiveData<String>("")
    private val _errorPassword=MutableLiveData<String>("")
    private val _errorMail=MutableLiveData<String>("")

    val errorNomUsuari: LiveData<String> = _errorNomUsuari
    val errorPassword: LiveData<String> = _errorPassword
    val errorMail: LiveData<String> = _errorPassword

    private val _formulariValid =MutableLiveData<Boolean>(false)
    val formulariValid:MutableLiveData<Boolean> = _formulariValid

    fun actualitzaNomUsuari(nomUsuari: String) {
        _nomUsuari = nomUsuari
    }

    fun actualitzaPassword(pswd: String) {
        _password = pswd
    }

    fun actualitzaMail(mail: String) {
        _mail = mail
    }

    public fun comprovaUsuari() {
        if (_nomUsuari.isEmpty()) {
            _errorNomUsuari.value = "El nom d'usuari és obligatori"
        }else{
            _errorNomUsuari.value = ""
        }
    }

    public fun comprovaEmail(email: String) {
        val regexEmail = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\$".toRegex()
        if (_mail.isBlank()) {
            _errorMail.value = "El correu és obligatori"
        } else if (!regexEmail.matches(_mail)) {
            _errorMail.value = "El correu no té un format correcte"
        } else {
            _errorMail.value = ""
        }
    }

    public fun comprovaContrassenya() {
        val contrassenyesFacils = listOf("12345678", "password", "qwerty", "111111111")
        if (_password.isBlank()) {
            _errorPassword.value = "La contrassenya és obligatòria"
        } else if (_password.trim().isEmpty()) {
            _errorPassword.value = "La contrassenya no pot contenir només espais en blanc"
        } else if (_password.length < 8) {
            _errorPassword.value = "La contrasenya ha de tenir com a mínim 8 caràcters"
        } else if (contrassenyesFacils.contains(_password)) {
            _errorPassword.value = "La contrasenya és massa fàcil, tria una contrasenya més segura"
        } else if (!_password.any { it.isUpperCase() } ||
            !_password.any { it.isLowerCase() } ||
            !_password.any { it.isDigit() } ||
            !_password.any { !it.isLetterOrDigit() }) {
            _errorPassword.value = "La contrasenya ha de contenir almenys una majúscula, una minúscula, un número i un símbol"
        } else {
            _errorPassword.value = ""
        }
    }
}