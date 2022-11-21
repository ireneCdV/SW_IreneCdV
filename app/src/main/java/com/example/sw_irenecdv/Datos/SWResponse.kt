package com.example.sw_irenecdv.Datos

data class SWResponse(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Result>
)