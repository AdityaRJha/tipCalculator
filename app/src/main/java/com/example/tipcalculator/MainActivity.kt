package com.example.tipcalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tipcalculator.databinding.ActivityMainBinding
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    private lateinit var binder: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binder = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binder.root)

        binder.button.setOnClickListener {
            onClick()
        }
    }

    private fun onClick(){
        val amount : Float = binder.amount.text.toString().toFloat()
        val percent : Float = binder.percent.text.toString().toFloat()
        var amountBut = false

        if (binder.radioButtonAmount.isChecked){
            amountBut = true
        }
        if (binder.radioButtonPercent.isChecked){
            amountBut = false
        }

        var toBeDisplayed = ""

        when {
            binder.radioButton0.isChecked -> {
                toBeDisplayed = calcu(amount, percent, amountBut, 0.0)
            }
            binder.radioButton5.isChecked -> {
                toBeDisplayed = calcu(amount, percent, amountBut, 5.0)
            }
            binder.radioButton10.isChecked -> {
                toBeDisplayed = calcu(amount, percent, amountBut, 10.0)
            }
            binder.radioButton20.isChecked -> {
                toBeDisplayed = calcu(amount, percent, amountBut, 20.0)
            }
        }

        binder.textView.text = toBeDisplayed
    }


    private fun calcu(am: Float, perTax: Float, orNot: Boolean, per: Double): String {
        if(!orNot){
            val p = ((((perTax + per)/100)+1)*am).roundToInt().toString()
            return  p
        }
        return ((((per)/100)+1)*am + perTax).toString()
    }


}