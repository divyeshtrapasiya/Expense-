package com.example.expensemanager

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import androidx.appcompat.app.AppCompatActivity
import com.example.expensemanager.databinding.ActivityDaseBoardBinding

class DaseBoardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDaseBoardBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDaseBoardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initview()

    }


    fun initview() {


        binding.drower.setOnClickListener {

            binding.drawerlayout.openDrawer(binding.navigation)

        }

        binding.calendar.setOnClickListener {
            binding.datePicker.visibility = View.GONE
            datepicker()
        }


        binding.lincalandar.setOnClickListener {
            binding.datePicker.visibility = View.GONE
            datepicker()
        }

        binding.datePicker.init(2023, 0, 1,

            DatePicker.OnDateChangedListener { view, year, month, dayofmonth ->
                val selectdate = "$dayofmonth/${month + 1}/$year"
            })



        binding.rltaddcatagory.setOnClickListener {

            val i = Intent(this, AddCatagoryActivity::class.java)

            startActivity(i)

        }

        binding.rltaddexpense.setOnClickListener {

            val i = Intent(this, ExpenseActivity::class.java)
            i.putExtra("expense", 1)
            startActivity(i)

        }


        binding.rltaddincome.setOnClickListener {

            val i = Intent(this, ExpenseActivity::class.java)
            i.putExtra("expense", 0)
            startActivity(i)

        }

        binding.rltviewtransaction.setOnClickListener {

            val i = Intent(this, TransactionActivity::class.java)
            startActivity(i)

        }

        binding.linaddcatagory.setOnClickListener{

            val i = Intent(this, AddCatagoryActivity::class.java)
            startActivity(i)
        }

        binding.linhome.setOnClickListener{


            val i = Intent(this, DaseBoardActivity::class.java)
            startActivity(i)


        }


        binding.linrateapp.setOnClickListener{


            val i = Intent(this, RatingActivity::class.java)
            startActivity(i)
            finish()


        }




    }

    fun datepicker() {

        var initialYear = 2023
        var initialMonth = 0
        var initialDay = 1

        var datePickerDialog = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { view, year, month, dayofmonth ->
                val selectdate = "$dayofmonth/${month + 1}/$year"
            },

            initialYear,
            initialMonth,
            initialDay
        )
        datePickerDialog.show()
    }
}