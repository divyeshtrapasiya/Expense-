package com.example.expensemanager.Database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteDatabase.CursorFactory
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.example.expensemanager.Model.ExpenseModal
import com.example.expensemanager.Model.UserModel

class DatabaseHelper(context: Context, name: String, factory: CursorFactory?, version: Int) :
    SQLiteOpenHelper(context, name, factory, version) {
    override fun onCreate(db: SQLiteDatabase?) {
        val sql = "create table catagoryTb (cid integer primary key autoincrement,name text)"
        db?.execSQL(sql)



        val sql1 =
            "create table expenseTb (eid integer primary key autoincrement,amount integer,catagory text,date text,time integer,mode text,note text)"
        db?.execSQL(sql1)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {

    }

    fun Catagorydata(name: String) {
        val db = writableDatabase
        val c = ContentValues()

        c.put("name", name)

        val result = db.insert("catagoryTb", null, c)
        Log.e("TAG", "insert: $result")
    }


    fun expenseData(
        amount: Int,
        catagory: String,
        date: String,
        time: String,
        mode: String,
        note: String
    ) {
        val db = writableDatabase
        val c = ContentValues()

        c.put("amount", amount)
        c.put("catagory", catagory)
        c.put("date", date)
        c.put("time", time)
        c.put("mode", mode)
        c.put("note", note)

        val result = db.insert("expenseTb", null, c)
        Log.e("TAG", "insert: $result")
    }

    fun displayrecord(): ArrayList<UserModel> {

        val list = ArrayList<UserModel>()
        list.clear()
        val db = readableDatabase
        val sql = "select * from catagoryTb "
        val cursor: Cursor = db.rawQuery(sql, null)


        if (cursor.moveToFirst()) {
            do {

                val id = cursor.getInt(0)
                val name = cursor.getString(1)

                Log.e("TAG", "displayrecord: " + id + " " + name)

                val amodal = UserModel(id, name)
                list.add(amodal)

            } while (cursor.moveToNext())
        }
        return list
    }


    fun display(): ArrayList<ExpenseModal> {

        val list = ArrayList<ExpenseModal>()
        list.clear()
        val db = readableDatabase
        val sql = "select * from expenseTb"
        val cursor: Cursor = db.rawQuery(sql, null)


        if (cursor.moveToFirst()) {
            do {

                val id = cursor.getInt(0)
                val amount = cursor.getInt(1)
                val catagory = cursor.getString(2)
                val date = cursor.getString(3)
                val time = cursor.getString(4)
                val mode = cursor.getString(5)
                val note = cursor.getString(6)



                val modal = ExpenseModal(id, amount, catagory, date, time, mode, note)
                list.add(modal)

            } while (cursor.moveToNext())
        }
        return list
    }

}

