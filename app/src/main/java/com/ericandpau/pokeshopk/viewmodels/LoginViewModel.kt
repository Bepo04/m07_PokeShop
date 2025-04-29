package com.ericandpau.pokeshopk.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    private var _nomUsuari:String = ""
    private var _password:String = ""

    private val _formulariValid =MutableLiveData<Boolean>(false)
    val formulariValid:MutableLiveData<Boolean> = _formulariValid

    fun setNomUsuari(nomUsuari: String) {
        _nomUsuari = nomUsuari
    }
}