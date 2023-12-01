package com.example.expensemanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.expensemanager.Adaptar.TrasactionAdaptar
import com.example.expensemanager.Database.DatabaseHelper
import com.example.expensemanager.Model.ExpenseModal
import com.example.expensemanager.databinding.ActivityTransactionBinding

class TransactionActivity : AppCompatActivity() {

    lateinit var binding: ActivityTransactionBinding
    lateinit var databaseHelper: DatabaseHelper
    lateinit var myadapter : TrasactionAdaptar
    lateinit var list : ArrayList<ExpenseModal>



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTransactionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initview()

    }

    private fun initview() {

        databaseHelper = DatabaseHelper(this,"catagory.db",null,1)

        list = databaseHelper.display()

        myadapter = TrasactionAdaptar(list)

        val manager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        binding.recycleview.layoutManager = manager

        binding.recycleview.adapter = myadapter

    }
}