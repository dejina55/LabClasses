package com.dejina.labclasses

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class lab5 : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var Si: TextView
    private lateinit var Sie: EditText
    private lateinit var radioGroup: RadioGroup
    private val department = arrayOf("Academic","IT")
    private val batch = arrayOf("25","26")
    private lateinit var spinner: Spinner
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab5)
        spinner = findViewById(R.id.spinner)
        textView = findViewById(R.id.textView)
        Si = findViewById(R.id.Si)
        Sie = findViewById(R.id.Sie)




        radioGroup = findViewById(R.id.radioGroup)

        radioGroup.setOnCheckedChangeListener(object:RadioGroup.OnCheckedChangeListener{
            override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
                when(checkedId){
                    R.id.rbStudent->{
                        spinner.adapter = ArrayAdapter(this@lab5,
                            android.R.layout.simple_list_item_1,
                            batch
                        )
                        textView.setText("Batch")
                        textView.visibility = View.VISIBLE
                        Si.visibility = View.VISIBLE
                        Sie.visibility = View.VISIBLE

                    }
                    R.id.rbStaff->{
                        val adapter = ArrayAdapter(this@lab5,
                            android.R.layout.simple_list_item_1,
                            department
                        )
                        textView.setText("Department")
                        Si.visibility = View.GONE;
                        Sie.visibility = View.GONE;
                        spinner.adapter = adapter
                    }
                }

            }
        })
        radioGroup.check(R.id.rbStudent)

    }
}