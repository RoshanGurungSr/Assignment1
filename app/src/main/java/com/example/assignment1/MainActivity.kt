package com.example.assignment1

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val button: Button = findViewById(R.id.btnView1)
        val details: TextView = findViewById(R.id.txtView1)
        val imageView = findViewById<ImageView>(R.id.imgView1)

        var flag: String = "Default"
        val spinnerVal : Spinner = findViewById(R.id.spinnerView1)
        var options = arrayOf("Default", "200000-400000", "400000-600000", ">600000")
        spinnerVal.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
            options)

        button.setOnClickListener { view ->
            val x1: String = "Bedroom 2 \nBathroom 1 \nFloor: 1 \nBasement: Yes " +
                    "\nLocation: 22 Algoma Street";
            val x2: String = "Bedroom 3 \nBathroom 2 \nFloor: 1 \nBasement: Yes " +
                    "\nLocation: 10 Waterfront Street";
            val x3: String = "Bedroom 4 \nBathroom 2 \nFloor: 2 \nBasement: Yes " +
                    "\nLocation: 13 Oliver Road";

            if (flag == "Default") {
                details.text = x1;
                imageView.setImageResource(R.drawable.img_x1)
            }

            else if (flag == "200000-400000") {
                details.text = x1;
                imageView.setImageResource(R.drawable.img_x1)
            }

            else if (flag == "400000-600000"){
                details.text = x2;
                imageView.setImageResource(R.drawable.img_x2)
            }

            else if (flag == ">600000"){
                details.text = x3;
                imageView.setImageResource(R.drawable.img_x3)
            }

        }

        spinnerVal.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = options.get(p2)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

    }
}