package com.ericandpau.pokeshopk.viewmodels

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

    private val _formulariValid =MutableLiveData<Boolean>(false)
    val formulariValid:MutableLiveData<Boolean> = _formulariValid

    fun setNomUsuari(nomUsuari: String) {
        _nomUsuari = nomUsuari
    }
}