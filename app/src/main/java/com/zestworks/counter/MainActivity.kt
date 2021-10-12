package com.zestworks.counter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val viewModel = CounterViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val counterView: TextView = findViewById(R.id.counterValue)
        val minus: Button = findViewById(R.id.minus)
        val plus: Button = findViewById(R.id.plus)

        lifecycleScope.launch {
            viewModel.stateStream.collect { currentState ->
                counterView.text = currentState.counterNumber.toString()
                counterView.setTextColor(currentState.counterColor)
            }
        }
        plus.setOnClickListener {
            viewModel.plusClicked()
        }

        minus.setOnClickListener {
            viewModel.minusClicked()
        }

    }
}