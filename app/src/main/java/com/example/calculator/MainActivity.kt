package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var strNumber = StringBuilder()
    private lateinit var solutionDisplay: TextView
    private lateinit var resultsDisplay: TextView
    private lateinit var operatorButtons: List<Button>
    private var operator: Operator = Operator.NONE
    private var isOperatorClicked: Boolean = false
    private var operand1: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeComponents()
        clearBTN.setOnClickListener {
            solutionDisplay.text = strNumber.clear()
        }
    }

    private fun initializeComponents() {
        solutionDisplay = findViewById(R.id.solutionDisplay)
        val numberButtons = arrayOf(
            sevenBTN,
            eightBTN,
            nineBTN,
            oneBTN,
            twoBTN,
            threeBTN,
            fourBTN,
            fiveBTN,
            sixBTN,
            sevenBTN
        )
        operatorButtons = listOf(multiplyBTN, divideBTN, addBTN, subtractBTN)
        for (i in numberButtons) {
            i.setOnClickListener { changeButtonNumber(i.text.toString()) }
        }
        for (i in operatorButtons) {
            i.setOnClickListener { operatorButtonClick(i.text.toString()) }
        }
        backspaceButton.setOnClickListener {
            val stringSize = strNumber.length
            strNumber.deleteCharAt(stringSize - 1 )
            solutionDisplay.text = strNumber

        }
        equalsBTN.setOnClickListener { buttonEqualClick() }

    }

    private fun buttonEqualClick() {
        val operand2 = strNumber.toString().toInt()
        val result:Int
        when (operator) {
            Operator.ADD -> result = operand1 + operand2
            Operator.SUB -> result = operand1 - operand2
            Operator.MUL -> result = operand1 * operand2
            Operator.DIV -> result = operand1 / operand2
            else -> result = 0
        }
        strNumber.clear()
        strNumber.append(result.toString())
        resultsDisplay.text = strNumber
    }

    private fun operatorButtonClick(btnText: String) {
        when (btnText) {
            "+" -> operator = Operator.ADD
            "-" -> operator = Operator.SUB
            "×" -> operator = Operator.MUL
            "÷" -> operator = Operator.DIV
        }
        isOperatorClicked = true


    }


    private fun changeButtonNumber(btnText: String) {
        if (isOperatorClicked){
            operand1 = strNumber.toString().toInt()
            strNumber.clear()
            isOperatorClicked = false
        }
        strNumber.append(btnText)
        solutionDisplay.text = strNumber
    }


}

enum class Operator {MUL, DIV, ADD, SUB, NONE}