package org.hyperskill.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button0 = findViewById<Button>(R.id.button0)
        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)
        val button4 = findViewById<Button>(R.id.button4)
        val button5 = findViewById<Button>(R.id.button5)
        val button6 = findViewById<Button>(R.id.button6)
        val button7 = findViewById<Button>(R.id.button7)
        val button8 = findViewById<Button>(R.id.button8)
        val button9 = findViewById<Button>(R.id.button9)

        val dotButton = findViewById<Button>(R.id.dotButton)

        val clearButton = findViewById<Button>(R.id.clearButton)
        val divideButton = findViewById<Button>(R.id.divideButton)
        val multiplyButton = findViewById<Button>(R.id.multiplyButton)
        val subtractButton = findViewById<Button>(R.id.subtractButton)
        val addButton = findViewById<Button>(R.id.addButton)
        val equalButton = findViewById<Button>(R.id.equalButton)

        val editText = findViewById<EditText>(R.id.editText)

        var result: Double = 0.0
        var txt2Display: String = "0"
        var previousNumber = 0.0

        var action: Char? = null




        fun display() {
            var toDisplay: String = txt2Display
            if (txt2Display.toDouble() % 1 == 0.0) {

                toDisplay = txt2Display.toDouble().toInt().toString()
            }
            editText.setText(toDisplay)
        }

        fun numberStore() {
            previousNumber = txt2Display.toDouble()
            editText.hint = txt2Display
            txt2Display = "0"
            display()
        }

        fun buttonPressed(num: Int) {
//            if (txt2Display[0] == '0' && !txt2Display.contains('.')) {
            if (txt2Display == "0") {
                if (num != 0) {
                    txt2Display = num.toString()
                }
            } else if (txt2Display == "-0") {
                if (num != 0) {
                    txt2Display = "-$num"
                }
            }
            else {
                txt2Display += num
            }
            display()
        }

        fun buttonPressedClear() {
            result = 0.0
            previousNumber = 0.0
            txt2Display = "0"
            display()
            action = null
            editText.hint = "0"
        }

        fun buttonPressedEqual() {
            if (action == '-') {
                previousNumber -= txt2Display.toDouble()
                txt2Display = previousNumber.toString()
            } else if (action == '+') {
                previousNumber += txt2Display.toDouble()
                txt2Display = previousNumber.toString()
            } else if (action == '*') {
                previousNumber *= txt2Display.toDouble()
                txt2Display = previousNumber.toString()
            } else if (action == '/') {
                if (txt2Display.toDouble() != 0.0) {
                    previousNumber /= txt2Display.toDouble()
                    txt2Display = previousNumber.toString()
                }

            }
            display()
        }


        fun buttonPressedDot() {
            if (!txt2Display.contains('.')) {
//                if (txt2Display == "-") {
//                    txt2Display = "-0."
//                } else {

                    txt2Display += '.'
//                }
                display()
            }
        }

        fun buttonPressedSubtract() {
            if (txt2Display == "0") {
                txt2Display = "-0"
            } else {
                action = '-'
                numberStore()
            }
        }

        fun buttonPressedDivide() {
            action = '/'
            numberStore()
        }

        fun buttonPressedAdd() {
            action = '+'
            numberStore()
        }

        fun buttonPressedMultiply() {
            action = '*'
            numberStore()
        }







        button0.setOnClickListener { buttonPressed(0) }
        button1.setOnClickListener { buttonPressed(1) }
        button2.setOnClickListener { buttonPressed(2) }
        button3.setOnClickListener { buttonPressed(3) }
        button4.setOnClickListener { buttonPressed(4) }
        button5.setOnClickListener { buttonPressed(5) }
        button6.setOnClickListener { buttonPressed(6) }
        button7.setOnClickListener { buttonPressed(7) }
        button8.setOnClickListener { buttonPressed(8) }
        button9.setOnClickListener { buttonPressed(9) }

        clearButton.setOnClickListener { buttonPressedClear() }
        dotButton.setOnClickListener { buttonPressedDot() }
        subtractButton.setOnClickListener { buttonPressedSubtract() }
        equalButton.setOnClickListener { buttonPressedEqual() }
        divideButton.setOnClickListener { buttonPressedDivide() }
        addButton.setOnClickListener { buttonPressedAdd() }
        multiplyButton.setOnClickListener { buttonPressedMultiply() }

    }
}
