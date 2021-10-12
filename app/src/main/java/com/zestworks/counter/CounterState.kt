package com.zestworks.counter

import android.graphics.Color

data class CounterState(
    val counterNumber: Int,
    val counterColor: Int
)

val defaultState = CounterState(0, Color.YELLOW)