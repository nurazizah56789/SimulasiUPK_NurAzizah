package com.example.simulasiupk_nurazizah

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterBBI (private val dataSet : MutableList<DataBBI>)
    :RecyclerView.Adapter<AdapterBBI.BBIHolder>() {
    class BBIHolder(view: View):RecyclerView.ViewHolder(view) {
        val nm = view.findViewById<TextView>(R.id.nm)
        val tb = view.findViewById<TextView>(R.id.tb)
        val hsl = view.findViewById<TextView>(R.id.hasil)
        val hps = view.findViewById<ImageView>(R.id.rvhps)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BBIHolder {
        val view =LayoutInflater.from(parent.context).inflate(
            R.layout.activity_adapter_bbi,parent,false)
        return BBIHolder(view)
    }
    override fun onBindViewHolder(holder: BBIHolder, position: Int) {
        holder.nm.text =dataSet[position].nama
        holder.tb.text =dataSet[position].tb_bdn
        holder.hsl.text =dataSet[position].hasil
        holder.hps.setOnClickListener{
            dataSet.removeAt(position)
            notifyItemRangeRemoved(position,dataSet.size)
            notifyDataSetChanged()
        }
    }
    override fun getItemCount(): Int {
        return dataSet.size
    }
}