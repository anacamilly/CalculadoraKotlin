package com.example.calculadora

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class RecebeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recebe)

        val variavel = intent.extras?.getString("variavel")
        val valor = intent.extras?.getInt("valor")

        val labelVariavel = findViewById<TextView>(R.id.TextViewLabelVariavel)
        val editTextVariavel = findViewById<EditText>(R.id.EditTextVariavel)

        labelVariavel.text = variavel
        editTextVariavel.setText(valor.toString())

        val buttonOk = findViewById<Button>(R.id.buttonOk)
        val buttonCancelar = findViewById<Button>(R.id.buttonCancelar)

        buttonOk.setOnClickListener {
            val i = Intent()
            val b = Bundle()

            val editTextVariavel =findViewById<EditText>(R.id.EditTextVariavel)
            b.putInt("valor", editTextVariavel.text.toString().toInt())
            i.putExtras(b)

            setResult(RESULT_OK, i)
            finish()
        }
        buttonCancelar.setOnClickListener {
            setResult(RESULT_CANCELED)
            finish()
        }
    }
}