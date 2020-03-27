package com.example.myapplication

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_alumnorecicler.view.*

class AlumnosAdapter(private val dataSet: List<Alumno>):RecyclerView.Adapter<AlumnosAdapter.ViewHolder>()  {
    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val tvControl=v.tvcontrol
        val tvNombre=v.tvNombre
        val tvCarrera=v.tvCarrera
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view.
        val v = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.layout_alumnorecicler, viewGroup, false)

        return ViewHolder(v)
    }

    override fun getItemCount()=dataSet.size

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemView.setOnClickListener{
           // Toast.makeText(viewHolder.itemView.context,dataSet.get(position).nombre,Toast.LENGTH_LONG).show()
            val intent= Intent(viewHolder.itemView.context,DatosAlumnoActivity::class.java)
            intent.putExtra("control",dataSet.get(position).control)
            intent.putExtra("nombre",dataSet.get(position).nombre)
            intent.putExtra("carrera",dataSet.get(position).carrera)
            viewHolder.itemView.context.startActivity(intent)
        }

        Log.e("HOLA",dataSet.get(position).control)
        viewHolder.tvControl.text = dataSet.get(position).control
        viewHolder.tvNombre.text = dataSet.get(position).nombre
        viewHolder.tvCarrera.text = dataSet.get(position).carrera
    }
}