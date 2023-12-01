package com.example.expensemanager

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.expensemanager.Adaptar.ExpenseAdaptar
import com.example.expensemanager.Adaptar.ModeAdapter
import com.example.expensemanager.Database.DatabaseHelper
import com.example.expensemanager.Model.UserModel
import com.example.expensemanager.databinding.ActivityExpenseBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale


class ExpenseActivity : AppCompatActivity() {


    private lateinit var binding: ActivityExpenseBinding
    private lateinit var databaseHelper: DatabaseHelper
    private var catagorylist = ArrayList<UserModel>()
    lateinit var c: String
    lateinit var s: String


    var payment = arrayOf("Cash", "Credit Card", "Debit Card", "Net Banking", "Cheque", "Online")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExpenseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initview()
        spinner()
    }

    private fun spinner() {


        binding.modespinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?, view: View?, position: Int, id: Long
            ) {
                s = payment[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }

        val adapter = ModeAdapter(payment)
        binding.modespinner.adapter = adapter
    }


    private fun initview() {


        databaseHelper = DatabaseHelper(this, "catagory.db", null, 1)

        binding.txttime.text = "${getcurrenttime()}"


        var data = intent.getIntExtra("expense", 1)


        if (data == 1) {
            binding.txtexpensename.text = "Add Expense"
            binding.raexpense.isChecked = true
        } else {
            binding.txtexpensename.text = "Add Income"
            binding.raincome.isChecked = true
        }



        binding.txtdate.setOnClickListener {

            val c = Calendar.getInstance()

            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(
                this,
                { view, year, monthOfYear, dayOfMonth ->
                    val dat = (dayOfMonth.toString() + "/" + (monthOfYear + 1) + "/" + year)
                    binding.txtdate.setText(dat)
                },
                year,
                month,
                day
            )

            datePickerDialog.show()
        }

        binding.txttime.setOnClickListener {

            val calendar = Calendar.getInstance()
            val currentHour = calendar.get(Calendar.HOUR_OF_DAY)
            val currentMinute = calendar.get(Calendar.MINUTE)

            val textView: TextView = findViewById(R.id.txttime)


            val timePickerDialog = TimePickerDialog(
                this,
                TimePickerDialog.OnTimeSetListener { _, hourOfDay, minute ->
                    val selectedTime =
                        String.format(Locale.getDefault(), "%02d:%02d", currentHour, minute)
                    textView.text = selectedTime
                },
                currentHour,
                currentMinute,
                false
            )
            getcurrenttime()
            timePickerDialog.show()

        }

        databaseHelper = DatabaseHelper(this, "catagory.db", null, 1)
        catagorylist = databaseHelper.displayrecord()
        binding.Catagoryspinner.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?, view: View?, position: Int, id: Long
                ) {
                    c = catagorylist[position].name
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {

                }

            }

        val adapter = ExpenseAdaptar(this@ExpenseActivity, catagorylist)
        binding.Catagoryspinner.adapter = adapter

        binding.back.setOnClickListener {
            val i = Intent(this, DaseBoardActivity::class.java)
            startActivity(i)

        }

        binding.btnsubmit.setOnClickListener {

            val amount = binding.edtamount.text.toString().toInt()
            val catagory = c
            val date = binding.txtdate.text.toString()
            val time = binding.txttime.text.toString()
            val mode = s
            val note = binding.edtnote.text.toString()

            databaseHelper.expenseData(amount, catagory, date, time, mode, note)


            val i = Intent(this@ExpenseActivity, TransactionActivity::class.java)
            startActivity(i)
            finish()
        }

    }

    private fun getcurrenttime(): String {
        var dateFormat = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
        var currentTime = dateFormat.format(Date())
        return currentTime

    }
}
