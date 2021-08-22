package com.example.calci

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)






        val num1 =findViewById<EditText>(R.id.num1)
        val num2 =findViewById<EditText>(R.id.num2)

        val plus = findViewById<RadioButton>(R.id.plus)
        val minus = findViewById<RadioButton>(R.id.minus)
        val multiply = findViewById<RadioButton>(R.id.multiply)
        val div = findViewById<RadioButton>(R.id.div)

        val answer = findViewById<TextView>(R.id.answer)

        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)

        radioGroup.setOnCheckedChangeListener { radioGroup, checkedId ->

            if (checkedId == R.id.plus){
                val result = add(num1.text.toString(), num2.text.toString())
                result.also { answer.text = it }
            }

            if (checkedId == R.id.minus){
                val result = minus(num1.text.toString(), num2.text.toString())
                result.also { answer.text = it }
            }

            if (checkedId == R.id.multiply){
                val result = multiply(num1.text.toString(), num2.text.toString())
                result.also { answer.text = it }
            }

            if (checkedId == R.id.div){
                val result = div(num1.text.toString(), num2.text.toString())
                result.also { answer.text = it }
            }

            if (checkedId == R.id.clear){
                radioGroup.clearCheck()
            }

        }

        Log.i("Lifecycle", "calci created.....")

        val userText = answer.text
        savedInstanceState?.let {
            val userText = savedInstanceState?.getCharSequence("savedText")
            answer.setText(userText)
            Log.i("LIFECYCLE", "onRestoreInstanceState")
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("Lifecycle", "calci started.....")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("Lifecycle", "calci Restarted.....")
    }

    override fun onStop() {
        super.onStop()
        Log.i("Lifecycle", "calci stopped.....")
    }

    override fun onPause() {
        super.onPause()
        Log.i("Lifecycle", "calci paused.....")
    }

    override fun onResume() {
        super.onResume()
        Log.i("Lifecycle", "calci resumed.....")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Lifecycle", "calci destroyed.....")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val answer = findViewById<TextView>(R.id.answer)
        val userText = answer.text
        outState?.putCharSequence("savedText", userText)

        Log.i("LIFECYCLE", "onSaveInstanceState")
    }



    private fun add(num1: String, num2: String) = (num1.toInt() + num2.toInt()).toString()
    private fun minus(num1: String, num2: String) = (num1.toInt() - num2.toInt()).toString()
    private fun multiply(num1: String, num2: String) = (num1.toInt() * num2.toInt()).toString()
    private fun div(num1: String, num2: String) = (num1.toDouble() / num2.toDouble()).toString()
}