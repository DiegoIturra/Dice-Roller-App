package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    /*Al ser lateinit evitamos en cada llamada al metodo rollDice() que
    se inicialize, optimizando un poco la App*/
    lateinit private var diceImage:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //obtener referencia del boton creado
        val rollButton:Button = findViewById(R.id.roll_button)

        //inicializar el recurso de imagen
        diceImage = findViewById(R.id.dice_image)
        //darle funcionalidad al boton
        rollButton.setOnClickListener{
            //ejecuta una funcion que muestra numeros aleatorios
            rollDice()
        }
    }

    private fun rollDice() {
        val randomInt = Random.nextInt(6)+1 // [0-5] + 1
        val drawableResource:Int = when(randomInt){
            /*drawableResource almacena la imagen correspondiente al
            * dado segun el valor obtenido*/
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        //setea la imagen correspondiente al valor obtenido
        diceImage.setImageResource(drawableResource)
    }

}
