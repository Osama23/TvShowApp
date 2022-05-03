package com.osama.tvshowapp.api

import com.osama.tvshowapp.helper.Constants
import com.osama.tvshowapp.models.TvShowResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(Constants.END_POINT)
    suspend fun getTvShows():Response<TvShowResponse>
}