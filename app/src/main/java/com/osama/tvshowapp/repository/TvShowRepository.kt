package com.osama.tvshowapp.repository

import com.osama.tvshowapp.api.ApiService
import javax.inject.Inject

class TvShowRepository
@Inject
constructor(private val apiService: ApiService){

    suspend fun getTvShows() = apiService.getTvShows()
}