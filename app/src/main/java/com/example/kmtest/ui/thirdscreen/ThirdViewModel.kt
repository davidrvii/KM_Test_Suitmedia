package com.example.kmtest.ui.thirdscreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.example.kmtest.data.repository.Repository
import com.example.kmtest.data.repository.Result
import com.example.kmtest.data.response.DataItem

class ThirdViewModel(private val repository: Repository) : ViewModel() {
    private val _dataItem = MediatorLiveData<Result<List<DataItem>>>()
    val dataItem: LiveData<Result<List<DataItem>>> = _dataItem

    fun getUsers(username: String) {
        val liveData = repository.getUsers(username)
        _dataItem.addSource(liveData) { result ->
            _dataItem.value = result
        }
    }
}