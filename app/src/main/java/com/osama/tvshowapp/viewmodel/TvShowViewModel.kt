package com.osama.tvshowapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.osama.tvshowapp.models.TvShowItem
import com.osama.tvshowapp.repository.TvShowRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TvShowViewModel @Inject constructor(private val tvShowRepository: TvShowRepository) :
    ViewModel() {

    private val _response = MutableLiveData<List<TvShowItem>>()

    val responseTvShow: LiveData<List<TvShowItem>>
        get() = _response

    init {
        getAllTvShows()
    }

    private fun getAllTvShows() = viewModelScope.launch{
        tvShowRepository.getTvShows().let {response ->

            if (response.isSuccessful){
                _response.postValue(response.body())
            }else{
                Log.d("tag", "getAllTvShows Error: ${response.code()}")
            }
        }
    }

}