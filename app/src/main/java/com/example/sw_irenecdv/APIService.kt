package com.example.sw_irenecdv

import com.example.sw_irenecdv.Datos.SWResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIService {

        @GET
        suspend fun getSW(@Url url:String): Response<SWResponse>
    }
