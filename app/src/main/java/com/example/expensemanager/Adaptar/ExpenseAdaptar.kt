package com.example.expensemanager.Adaptar

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.expensemanager.ExpenseActivity
import com.example.expensemanager.Model.UserModel
import com.example.expensemanager.R

class ExpenseAdaptar(var ExpenseActivity : ExpenseActivity,var categorylist: ArrayList<UserModel>) : BaseAdapter() {
    override fun getCount(): Int {
        return categorylist.size
    }

    override fun getItem(p0: Int): Any? {
        return null
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

        val v : View = LayoutInflater.from(ExpenseActivity).inflate(R.layout.expense_item,null)
        val category = v.findViewById<TextView>(R.id.txtEname)
        category.text=categorylist[p0].name
        return v
    }
}