package pe.idat.appbasicmvvm.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AuthViewModel : ViewModel() {

    private val _usuario = MutableLiveData<String>()
    val usuario : LiveData<String> = _usuario

    fun onLoginValueChanged(usuario:String){
        _usuario.value = usuario
    }

    fun login(): Boolean{
       if(usuario.value == "lsalvat") {
           return true
       }
        return false
    }

}