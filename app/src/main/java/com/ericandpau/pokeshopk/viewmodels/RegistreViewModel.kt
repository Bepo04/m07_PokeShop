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
        private var _pswdConfirmation: String = ""

        // Privades - MutableLiveData
        private val _errorNom = MutableLiveData<String>("")
        private val _errorCognom = MutableLiveData<String>("")
        private val _errorEmail = MutableLiveData<String>("")
        private val _errorTelf = MutableLiveData<String>("")
        private val _errorAdresa = MutableLiveData<String>("")
        private val _errorCodPostal = MutableLiveData<String>("")
        private val _errorNomUsuari = MutableLiveData<String>("")
        private val _errorPassword = MutableLiveData<String>("")
        private val _errorPswdConfirmation = MutableLiveData<String>("")

        // Públiques - LiveData
        val errorNom: LiveData<String> = _errorNom
        val errorCognom: LiveData<String> = _errorCognom
        val errorEmail: LiveData<String> = _errorEmail
        val errorTelf: LiveData<String> = _errorTelf
        val errorAdresa: LiveData<String> = _errorAdresa
        val errorCodPostal: LiveData<String> = _errorCodPostal
        val errorNomUsuari: LiveData<String> = _errorNomUsuari
        val errorPassword: LiveData<String> = _errorPassword
        val errorPswdConfirmation: LiveData<String> = _errorPswdConfirmation

        private val _formulariValid =MutableLiveData<Boolean>(false)
        val formulariValid:MutableLiveData<Boolean> = _formulariValid

        fun setNomUsuari(nomUsuari: String) {
            _nomUsuari = nomUsuari
        }
        fun setNom(nom: String) {
            _nom = nom
        }
        fun setCognom(cognom: String) {
            _cognom = cognom
        }
        fun setAdresa(adresa: String) {
            _adresa = adresa
        }
        fun setEmail(email: String) {
            _email = email
        }
        fun setTelf(telf: String) {
            _telf = telf
        }
        fun setCodPostal(codPostal: String) {
            _codPostal = codPostal
        }
        fun setPassword(password: String) {
            _password = password
        }
        fun setPswdConfirmation(pswdConfirmation: String) {
            _pswdConfirmation = pswdConfirmation
        }

        fun actualitzaNomUsuari() {
            if (_nomUsuari.isBlank()) {
                _errorNomUsuari.value = "El nom d'usuari és obligatori"
            } else if (_nomUsuari.firstOrNull()?.isLetterOrDigit() == false) {
                _errorNomUsuari.value = "El nom d'usuari no pot començar per símbol"
            } else {
                _errorNomUsuari.value = ""
            }
        }

        fun actualitzaNom() {
            if (_nom.isBlank()) {
                _errorNom.value = "El nom és obligatori"
            } else if (_nom.trim().isEmpty()) {
                _errorNom.value = "El nom no pot contenir només espais en blanc"
            } else {
                _errorNom.value = ""
            }
        }

        fun actualitzaCognom() {
            if (_cognom.isBlank()) {
                _errorCognom.value = "El cognom és obligatori"
            } else if (_cognom.trim().isEmpty()) {
                _errorCognom.value = "El cognom no pot contenir només espais en blanc"
            } else {
                _errorCognom.value = ""
            }
        }

        fun actualitzaCorreu() {
            if (_email.isBlank()) {
                _errorEmail.value = "El correu és obligatori"
            } else if (_email.trim().isEmpty()) {
                _errorEmail.value = "El correu no pot contenir només espais en blanc"
            } else if (!_email.endsWith("@gmail.com")) {
                _errorEmail.value = "Només s’accepten correus @gmail.com"
            } else {
                _errorEmail.value = ""
            }
        }

        fun actualitzaAdreca() {
            if (_adresa.isBlank()) {
                _errorAdresa.value = "L’adreça és obligatòria"
            } else if (_adresa.trim().isEmpty()) {
                _errorAdresa.value = "L’adreça no pot contenir només espais en blanc"
            } else {
                _errorAdresa.value = ""
            }
        }

        fun actualitzaCodiPostal() {
            if (_codPostal.isBlank()) {
                _errorCodPostal.value = "El codi postal és obligatori"
            } else {
                val codi = _codPostal.toIntOrNull()
                if (codi == null || codi !in 1000..52999) {
                    _errorCodPostal.value = "El codi postal no és vàlid"
                } else {
                    _errorCodPostal.value = ""
                }
            }
        }

        fun actualitzaTelefon() {
            if (_telf.isBlank()) {
                _errorTelf.value = "El telèfon és obligatori"
            } else {
                val regex = Regex("""^(\+34)?[6-7]\d{8}$""")
                if (!regex.matches(_telf)) {
                    _errorTelf.value = "El número de telèfon no és vàlid"
                } else {
                    _errorTelf.value = ""
                }
            }
        }

        public fun actualitzaContrassenya() {
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

        public fun comparaContrassenyes() {
            if (_password != _pswdConfirmation) {
                _errorPswdConfirmation.value = "Les contrassenyes no coincideixen"
            } else {
                _errorPswdConfirmation.value = ""
            }
        }
    }