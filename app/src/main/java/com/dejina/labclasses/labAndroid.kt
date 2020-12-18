package com.dejina.labclasses

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.DatePickerDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.view.isVisible
import java.util.*

class labAndroid : AppCompatActivity() {
    private lateinit var tvLoadCalender: EditText
    private val post = arrayOf("MD","Staff","Assistent")
    private lateinit var spinner: Spinner;
    private lateinit var tvEmpName : TextView
    private lateinit var tvEmpPost : TextView
    private lateinit var tvEmpDate : TextView
    private lateinit var tvAddress : TextView
    private lateinit var tvEmpNumber : TextView
    private lateinit var etEmpName : EditText
    private lateinit var etEmpPost : EditText
    private lateinit var etEmpDate : EditText
    private lateinit var etEmpAddress : EditText
    private lateinit var etEmpNumber : EditText
    private lateinit var btnSubmit : Button
    private var selectedPost = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinner=findViewById(R.id.spinner)
        tvLoadCalender = findViewById(R.id.tvLoadCalender)
        tvLoadCalender = findViewById(R.id.tvLoadCalender)
        etEmpName = findViewById(R.id.etEmpName)
        etEmpPost = findViewById(R.id.spinner)
        etEmpDate = findViewById(R.id.tvLoadCalender)
        etEmpAddress = findViewById(R.id.etEmpAddress)
        etEmpNumber = findViewById(R.id.etEmpNumber)
        btnSubmit = findViewById(R.id.btnSubmit)



        val adapter= ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            post
        )
        spinner.adapter=adapter
        spinner.onItemSelectedListener=object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?, view: View?, position:Int, id:Long
            ){
                val selectedItem=parent?.getItemAtPosition(position).toString()
                Toast.makeText(
                    this@labAndroid, "Selected item: $selectedItem", Toast.LENGTH_LONG).show()

            }
            override fun onNothingSelected(parent: AdapterView<*>?){
                TODO("Not yet implemented")
            }

        }

        tvLoadCalender.setOnClickListener{
            loadCalendar()
        }

        btnSubmit.setOnClickListener{
            submitData()
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
    @SuppressLint("SetTextI18n")
    private fun submitData(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Data")

        val adapter:ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1)
        adapter.add(etEmpName.text.toString())
        adapter.add(etEmpDate.text.toString())
        adapter.add(etEmpAddress.text.toString())
        adapter.add(post[spinner.selectedItemPosition])

        builder.setAdapter(
            adapter,
            object: DialogInterface.OnClickListener{
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    TODO("Not yet implemented")
                }

            }
        )
        builder.create().show()

    }
}