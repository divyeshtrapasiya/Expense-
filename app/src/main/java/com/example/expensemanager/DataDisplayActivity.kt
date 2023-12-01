package com.example.expensemanager

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import com.example.expensemanager.Adaptar.CatagoryAdaptar
import com.example.expensemanager.Database.DatabaseHelper
import com.example.expensemanager.Model.UserModel
import com.example.expensemanager.databinding.ActivityDataDisplayBinding

class DataDisplayActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDataDisplayBinding
    lateinit var c: String
    val id: Int = 0
    private lateinit var databaseHelper: DatabaseHelper
    private var catagorylist = ArrayList<UserModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDataDisplayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initview()
    }

    private fun initview() {
        databaseHelper = DatabaseHelper(this, "catagory.db", null, 1)
        catagorylist = databaseHelper.displayrecord()
        binding.spnspinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

                c = catagorylist[position].name
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }

        val adapter = CatagoryAdaptar(this@DataDisplayActivity, catagorylist)
        binding.spnspinner.adapter = adapter

    }
}