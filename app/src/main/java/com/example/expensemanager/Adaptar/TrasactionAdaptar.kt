package com.example.expensemanager.Adaptar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.expensemanager.Model.ExpenseModal
import com.example.expensemanager.R

class TrasactionAdaptar( val list: ArrayList<ExpenseModal>) : RecyclerView.Adapter<TrasactionAdaptar.MyviewHolhar>() {
    class MyviewHolhar(v: View) : RecyclerView.ViewHolder(v) {

        val amount: TextView = v.findViewById(R.id.txtamount)
        val catagory: TextView = v.findViewById(R.id.txtcatagory)
        val date: TextView = v.findViewById(R.id.txtdate)
        val time: TextView = v.findViewById(R.id.txttime)
        val mode: TextView = v.findViewById(R.id.txtmode)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolhar {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.transaction_item, parent, false)
        val holder = MyviewHolhar(v)

        return holder

    }

    override fun getItemCount(): Int {

        return list.size

    }

    override fun onBindViewHolder(holder: MyviewHolhar, position: Int) {


        holder.amount.text = list.get(position).amount.toString()
        holder.catagory.text = list.get(position).catagory
        holder.date.text = list.get(position).date
        holder.time.text = list.get(position).time
        holder.mode.text = list.get(position).mode
    }
}