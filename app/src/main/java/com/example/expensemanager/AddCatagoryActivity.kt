package com.example.expensemanager

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.expensemanager.Database.DatabaseHelper
import com.example.expensemanager.databinding.ActivityAddCatagoryBinding

class AddCatagoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddCatagoryBinding
    lateinit var databaseHelper : DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddCatagoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initview()

    }

    private fun initview() {

        val databaseHelper = DatabaseHelper(this, "catagory.db", null, 1)


        binding.btncatagory.setOnClickListener {


            val name = binding.edtname.text.toString()


            val i = Intent(this, DaseBoardActivity::class.java)
            startActivity(i)


            databaseHelper.Catagorydata(name)

            Toast.makeText(this, "Catagory Data add successfully", Toast.LENGTH_SHORT).show()

            binding.edtname.text = null

        }



    }
}