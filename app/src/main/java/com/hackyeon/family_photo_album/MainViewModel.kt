package com.hackyeon.family_photo_album

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hackyeon.family_photo_album.api.data.res.ResGetPhotoList
import com.hackyeon.family_photo_album.respository.PhotoRepository
import com.hackyeon.family_photo_album.ui.Screen
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    // repository
    private val repository = PhotoRepository()

    val photoList: LiveData<List<ResGetPhotoList>> = repository.photoList

    // screen state
    private val _screenState = MutableLiveData<Screen>(Screen.LOADING)
    val screenState: LiveData<Screen> = _screenState

    init {
        _screenState.postValue(if(repository.getLoginUser() == null) Screen.LOGIN else Screen.PHOTO_LIST)
    }



    fun join(id: String, password: String) = viewModelScope.launch(Dispatchers.IO) {
        repository.join(id, password) {
            _screenState.postValue(Screen.PHOTO_LIST)
        }
    }
    fun login(id: String, password: String) = viewModelScope.launch(Dispatchers.IO) {
        repository.login(id, password) {
            _screenState.postValue(Screen.PHOTO_LIST)
        }
    }

    val img = MutableLiveData<String>()




}