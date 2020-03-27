package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerViewActivity : AppCompatActivity() {
    //val dataSet= arrayListOf<Alumno>()
    companion object {
        val dataSet= arrayListOf<Alumno>()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        dataSet.add(Alumno(control = "15100221",carrera = "INGENIERIA EN SISTEMAS",nombre = "JESUS ANGEL"))
        LoadData()

        recyclerView.layoutManager=LinearLayoutManager(this)
        recyclerView.adapter=AlumnosAdapter(dataSet)
    }
    private fun LoadData()
    {
        for(i in 0..20)
        {
            dataSet.add(Alumno("Estudiante ${i}",
                    " 15100${i.toString().padStart(3,'0')} ",
                    "${if(i%2 == 0)"Ingenieria en Sistemas Computacionales" else "Ingenieria Industrial"}"))

        }
    }
}
