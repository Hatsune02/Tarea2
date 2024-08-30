package com.navi.calculator.ui

import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.setPadding
import com.navi.calculator.R
import com.navi.calculator.backend.parser_lexer.errors.ErrorsLP

class TableActivity : AppCompatActivity() {
    private lateinit var tableLayout: TableLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_table)

        tableLayout = findViewById(R.id.tableLayout)

        for(err in ErrorsLP.getErrors()){
            val newData = arrayOf<Any>(err.lexeme, err.line, err.column, err.type, err.description)
            addRow(this, tableLayout, newData)
        }

    }
    private fun addRow(context: Context, tableLayout:TableLayout, rowData:Array<Any>){
        val newRow = TableRow(context)

        for(cellData in rowData){
            val cellTextView = TextView(context)

            //Convertir dato a string
            cellTextView.text =  when(cellData){
                is String -> cellData
                is Double ->
                    if (cellData == cellData.toInt().toDouble()) {
                        cellData.toInt().toString() // Mostrar como entero si es un número sin parte fraccionaria
                    } else {
                        "%.2f".format(cellData) // Formatear con dos decimales si tiene parte fraccionaria
                    }
                else -> cellData.toString()
            }
            cellTextView.setTextColor(context.resources.getColor(R.color.white))
            cellTextView.setPadding(8,8,8, 8)
            cellTextView.gravity = Gravity.CENTER
            cellTextView.setBackgroundColor(context.resources.getColor(R.color.background_table))
            cellTextView.layoutParams = TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f)

            // Agregar la celda a la fila
            newRow.addView(cellTextView)
        }

        // Agregar la nueva fila al TableLayout
        tableLayout.addView(newRow)
    }
}