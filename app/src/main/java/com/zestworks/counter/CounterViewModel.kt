package com.zestworks.counter

import android.graphics.Color
import kotlinx.coroutines.flow.MutableStateFlow

class CounterViewModel {

    val stateStream = MutableStateFlow(defaultState)

    fun plusClicked() {
        val currentState = stateStream.value
        if (currentState.counterNumber >= 9) {
            return
        } else {
            val newCount = currentState.counterNumber + 1
            val newState = currentState.copy(
                counterNumber = newCount,
                counterColor = getColorForValue(newCount)
            )
            stateStream.value = newState
        }
    }

    fun minusClicked() {
        val currentState = stateStream.value
        if (currentState.counterNumber <= 0) {
            return
        } else {
            val newCount = currentState.counterNumber - 1
            val newState = currentState.copy(
                counterNumber = newCount,
                counterColor = getColorForValue(newCount)
            )
            stateStream.value = newState
        }
    }

    private fun getColorForValue(countValue: Int): Int =
        when (countValue) {
            in 0 until 5 -> Color.RED
            in 4 until 7 -> Color.BLUE
            in 7 until 10 -> Color.GREEN
            else -> Color.BLACK
        }
}