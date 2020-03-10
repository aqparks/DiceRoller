package com.example.android.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    val diceMap: MutableMap<String, Int> = mutableMapOf(
        "d4" to 1, "d6" to 1, "d8" to 1,
        "d10" to 1, "d12" to 1, "d20" to 1
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollD4Button: Button = findViewById(R.id.roll_d4_button)
        val increaseD4Button: Button = findViewById(R.id.increase_d4_button)
        val decreaseD4Button: Button = findViewById(R.id.decrease_d4_button)
        val d4_rolled_values: TextView = findViewById(R.id.d4_rolled_values)
        val d4_roll_value: TextView = findViewById(R.id.d4_roll_value)
        rollD4Button.setOnClickListener { rollDice("d4", d4_rolled_values, d4_roll_value) }
        increaseD4Button.setOnClickListener { increaseNumberOfDice("d4", rollD4Button) }
        decreaseD4Button.setOnClickListener { decreaseNumberOfDice("d4", rollD4Button) }

        val rollD6Button: Button = findViewById(R.id.roll_d6_button)
        val increaseD6Button: Button = findViewById(R.id.increase_d6_button)
        val decreaseD6Button: Button = findViewById(R.id.decrease_d6_button)
        val d6_rolled_values: TextView = findViewById(R.id.d6_rolled_values)
        val d6_roll_value: TextView = findViewById(R.id.d6_roll_value)
        rollD6Button.setOnClickListener { rollDice("d6", d6_rolled_values, d6_roll_value) }
        increaseD6Button.setOnClickListener { increaseNumberOfDice("d6", rollD6Button) }
        decreaseD6Button.setOnClickListener { decreaseNumberOfDice("d6", rollD6Button) }

        val rollD8Button: Button = findViewById(R.id.roll_d8_button)
        val increaseD8Button: Button = findViewById(R.id.increase_d8_button)
        val decreaseD8Button: Button = findViewById(R.id.decrease_d8_button)
        val d8_rolled_values: TextView = findViewById(R.id.d8_rolled_values)
        val d8_roll_value: TextView = findViewById(R.id.d8_roll_value)
        rollD8Button.setOnClickListener { rollDice("d8", d8_rolled_values, d8_roll_value) }
        increaseD8Button.setOnClickListener { increaseNumberOfDice("d8", rollD8Button) }
        decreaseD8Button.setOnClickListener { decreaseNumberOfDice("d8", rollD8Button) }

        val rollD10Button: Button = findViewById(R.id.roll_d10_button)
        val increaseD10Button: Button = findViewById(R.id.increase_d10_button)
        val decreaseD10Button: Button = findViewById(R.id.decrease_d10_button)
        val d10_rolled_values: TextView = findViewById(R.id.d10_rolled_values)
        val d10_roll_value: TextView = findViewById(R.id.d10_roll_value)
        rollD10Button.setOnClickListener { rollDice("d10", d10_rolled_values, d10_roll_value) }
        increaseD10Button.setOnClickListener { increaseNumberOfDice("d10", rollD10Button) }
        decreaseD10Button.setOnClickListener { decreaseNumberOfDice("d10", rollD10Button) }

        val rollD12Button: Button = findViewById(R.id.roll_d12_button)
        val increaseD12Button: Button = findViewById(R.id.increase_d12_button)
        val decreaseD12Button: Button = findViewById(R.id.decrease_d12_button)
        val d12_rolled_values: TextView = findViewById(R.id.d12_rolled_values)
        val d12_roll_value: TextView = findViewById(R.id.d12_roll_value)
        rollD12Button.setOnClickListener { rollDice("d12", d12_rolled_values, d12_roll_value) }
        increaseD12Button.setOnClickListener { increaseNumberOfDice("d12", rollD12Button) }
        decreaseD12Button.setOnClickListener { decreaseNumberOfDice("d12", rollD12Button) }

        val rollD20Button: Button = findViewById(R.id.roll_d20_button)
        val increaseD20Button: Button = findViewById(R.id.increase_d20_button)
        val decreaseD20Button: Button = findViewById(R.id.decrease_d20_button)
        val d20_rolled_values: TextView = findViewById(R.id.d20_rolled_values)
        val d20_roll_value: TextView = findViewById(R.id.d20_roll_value)
        rollD20Button.setOnClickListener { rollDice("d20", d20_rolled_values, d20_roll_value) }
        increaseD20Button.setOnClickListener { increaseNumberOfDice("d20", rollD20Button) }
        decreaseD20Button.setOnClickListener { decreaseNumberOfDice("d20", rollD20Button) }
    }

    private fun increaseNumberOfDice(dice: String, button: Button) {
        val newValue: Int = this.diceMap.get(dice)!! + 1
        this.diceMap.put(dice, newValue)
        button.text = newValue.toString() + dice
    }

    private fun decreaseNumberOfDice(dice: String, button: Button) {
        var newValue: Int = this.diceMap.get(dice)!! - 1
        if (newValue < 1)
            newValue = 1
        this.diceMap.put(dice, newValue)
        button.text = newValue.toString() + dice
    }

    private fun rollDice(diceKey: String, numbersRolledTextView: TextView, totalRollTextView: TextView) {
        Toast.makeText(this, "Roll baby roll", Toast.LENGTH_SHORT).show()
        var totalValue = 0
        val numbers = mutableListOf<Int>()
        val dice = this.diceMap.get(diceKey)!!
        val max = diceKey.substring(1).toInt()
        println(diceKey)
        for (x in dice.downTo(1)) {
            val roll: Int = (1..max).random()
            numbers.add(roll)
            totalValue = totalValue + roll
        }

        totalRollTextView.text = totalValue.toString()
        numbersRolledTextView.text = numbers.joinToString("+", "(", ")")
    }
}
