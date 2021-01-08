package com.example.firstapplication

import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private var count:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn_click_me: Button = findViewById(R.id.btnDatePicker)
        btn_click_me.setOnClickListener{view:View ->
            clickDatePicker(view)
            Toast.makeText(this, "You clicked me", Toast.LENGTH_LONG).show()
        }
        val ageBtn:Button = findViewById(R.id.button)
        ageBtn.setOnClickListener{
            changeAgeBtnText(it as Button)
        }
        val countBtn = findViewById<TextView>(R.id.countView)
        countBtn.setOnClickListener { view ->
            (view as TextView).setText(count++.toString())
        }
    }
    fun clickDatePicker(view: View){
        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val formatter = SimpleDateFormat("dd MMMM yyyy")
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)
        DatePickerDialog(this, {
            view, year, month, day ->
            Log.i("DateFormat", year.toString())
            myCalendar.set(year, month, day)
            Toast.makeText(this, "Chosen is ${formatter.format(myCalendar.time)}", Toast.LENGTH_LONG).show()
                               }, year, month, day).show()
        Toast.makeText(this, "Today is ${formatter.format(myCalendar.time)}", Toast.LENGTH_LONG).show()
        }
    fun changeAgeBtnText(view:Button){
        view.setText("Button was clicked")
    }
}