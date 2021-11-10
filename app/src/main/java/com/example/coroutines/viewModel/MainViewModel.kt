package com.example.coroutines.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.coroutines.model.Model
import com.example.coroutines.repository.MainRepository
import kotlinx.coroutines.*

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {

    val errorMessage = MutableLiveData<String>()
    val dataList = MutableLiveData<List<Model>>()
    var job: Job? = null

    //Getting data from API
    fun getAllMovies() {
        job = CoroutineScope(Dispatchers.IO).launch {
            val response = mainRepository.getAllData()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    dataList.postValue(response.body())
                } else {
                    onError("Error : ${response.message()} ")
                }
            }
        }

    }

    private fun onError(message: String) {
        errorMessage.value = message
    }
    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }

}