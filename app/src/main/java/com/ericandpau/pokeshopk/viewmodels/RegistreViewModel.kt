package com.ericandpau.pokeshopk.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RegistreViewModel : ViewModel() {

    private var _nom:String = ""
    private var _cognom:String = ""
    private var _email:String = ""
    private var _telf:String = ""
    private var _adresa:String = ""
    private var _codPostal:String = ""
    private var _nomUsuari:String = ""
    private var _password:String = ""

    // Privades - MutableLiveData
    private val _errorNom = MutableLiveData<String>("")
    private val _errorCognom = MutableLiveData<String>("")
    private val _errorEmail = MutableLiveData<String>("")
    private val _errorTelf = MutableLiveData<String>("")
    private val _errorAdresa = MutableLiveData<String>("")
    private val _errorCodPostal = MutableLiveData<String>("")
    private val _errorNomUsuari = MutableLiveData<String>("")
    private val _errorPassword = MutableLiveData<String>("")

    // Públiques - LiveData
    val errorNom: LiveData<String> = _errorNom
    val errorCognom: LiveData<String> = _errorCognom
    val errorEmail: LiveData<String> = _errorEmail
    val errorTelf: LiveData<String> = _errorTelf
    val errorAdresa: LiveData<String> = _errorAdresa
    val errorCodPostal: LiveData<String> = _errorCodPostal
    val errorNomUsuari: LiveData<String> = _errorNomUsuari
    val errorPassword: LiveData<String> = _errorPassword

    private val _formulariValid =MutableLiveData<Boolean>(false)
    val formulariValid:MutableLiveData<Boolean> = _formulariValid

    fun setNomUsuari(nomUsuari: String) {
        _nomUsuari = nomUsuari
    }
}