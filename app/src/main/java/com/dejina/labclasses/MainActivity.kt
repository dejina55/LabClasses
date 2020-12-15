package com.dejina.labclasses

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import java.util.*


class MainActivity : AppCompatActivity() {
    private lateinit var tvLoadCalender: EditText
    private val post = arrayOf("MD","Staff","Assistent")
    private lateinit var spinner:Spinner;
    private lateinit var tvEmpName : TextView
    private lateinit var tvEmpPost : TextView
    private lateinit var tvEmpDate : TextView
    private lateinit var tvAddress : TextView
    private lateinit var tvEmpNumber : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinner=findViewById(R.id.spinner)
        tvLoadCalender = findViewById(R.id.tvLoadCalender)
        tvLoadCalender = findViewById(R.id.tvLoadCalender)

        val adapter= ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            post
        )
        spinner.adapter=adapter
        spinner.onItemSelectedListener=object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent:AdapterView<*>?, view: View?, position:Int, id:Long
            ){
                val selectedItem=parent?.getItemAtPosition(position).toString()
                Toast.makeText(
                    this@MainActivity, "Selected item: $selectedItem",Toast.LENGTH_LONG).show()

            }
            override fun onNothingSelected(parent:AdapterView<*>?){
                TODO("Not yet implemented")
            }

        }

        tvLoadCalender.setOnClickListener{
            loadCalendar()
        }

    }
    private fun loadCalendar(){
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this, DatePickerDialog.OnDateSetListener{
                    view, year, month, dayOfMonth ->
                tvLoadCalender.setText("$dayOfMonth/${month+1}/$year")
            }, year, month, day
        )

        datePickerDialog.show()
    }



}