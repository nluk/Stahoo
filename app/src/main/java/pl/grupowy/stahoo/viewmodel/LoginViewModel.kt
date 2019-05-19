package pl.grupowy.stahoo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pl.grupowy.stahoo.network.form.users.LoginForm

class LoginViewModel : ViewModel() {

    private val credentials: MutableLiveData<LoginForm> = MutableLiveData()

}