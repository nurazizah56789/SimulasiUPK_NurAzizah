package com.example.simulasiupk_nurazizah

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private var BeratBadan:Int=0
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerViewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var nama = findViewById<EditText>(R.id.txtnama)
        var tinggibadan = findViewById<EditText>(R.id.txttb_bdn)
        var jklakilaki= findViewById<RadioButton>(R.id.rblk)
        var jkperempuan = findViewById<RadioButton>(R.id.rbpr)
        var hasil = findViewById<TextView>(R.id.txthasil)
        var hitung = findViewById<Button>(R.id.btnhitung)
        var simpan = findViewById<Button>(R.id.btnsimpan)
        recyclerView=findViewById(R.id.listdata)

        val data = mutableListOf<DataBBI>()
        viewManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        recyclerViewAdapter = AdapterBBI (data)
        recyclerView.adapter= recyclerViewAdapter
        recyclerView.layoutManager = viewManager

        simpan.setOnClickListener {
            val nm =nama.text.toString()
            val tb = tinggibadan.text.toString()
            val hsl = hasil.text.toString()

            val dataBBI = DataBBI(nm, tb, hsl)
            data.add(dataBBI)
            recyclerViewAdapter.notifyDataSetChanged()
        }

        hitung.setOnClickListener {
            var tinggi = tinggibadan.text.toString().toInt()

            if (jklakilaki.isChecked) {
                BeratBadan = (tinggi - 100) - ((tinggi - 100) * 10/100)
                hasil.setText (BeratBadan.toString() +"kg")
            }else if (jkperempuan.isChecked){
                BeratBadan = (tinggi - 100) - ((tinggi - 100) * 15/100)
                hasil.setText (BeratBadan.toString() + "kg")
            }else{
                hasil.setText("Pilih Jenis Kelamin Dahulu")
            }
        }

    }
}