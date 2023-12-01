package com.example.expensemanager.Adaptar

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.expensemanager.ExpenseActivity
import com.example.expensemanager.R

class ModeAdapter(var payment : Array<String>) : BaseAdapter() {
    override fun getCount(): Int {
        return payment.size
    }

    override fun getItem(p0: Int): Any? {
        return null
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val view: View = LayoutInflater.from(parent?.context).inflate(R.layout.mode_item, null)
        val modeTextView = view.findViewById<TextView>(R.id.txtmode)

        modeTextView.text = payment[position]

        return view

    }}