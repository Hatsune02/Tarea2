package com.navi.calculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.navi.calculator.backend.Compile
import com.navi.calculator.backend.parser_lexer.errors.*
import com.navi.calculator.ui.TableActivity

class MainActivity : AppCompatActivity() {
    private lateinit var editText: EditText
    private lateinit var compileButton: Button
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Vincular
        editText = findViewById(R.id.inputExpression)
        compileButton = findViewById(R.id.btnCalculate)
        resultTextView = findViewById(R.id.resultTextView)

        compileButton.setOnClickListener {
            if(editText.toString().isNotEmpty()){
                val inputText = editText.text.toString()
                Compile.compile(inputText)
                if(ErrorsLP.getErrors().isEmpty()){
                    val res = Compile.getResult().toString()
                    resultTextView.text = res
                }
                else{
                    // Crear un Intent para iniciar TableActivity
                    val intent = Intent(this, TableActivity::class.java)
                    startActivity(intent)
                }
            }
        }

    }


}