package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_datos_alumno.*

class DatosAlumnoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datos_alumno)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", View.OnClickListener {
                        miMetodo()
                    }).show()
        }
        val control=intent.extras.getString("control","NA")
        val nombre=intent.extras.getString("nombre","NA")
        val carrera=intent.extras.getString("carrera","NA")
        Toast.makeText(this,"${control} ${nombre}",Toast.LENGTH_LONG).show()
    }

    private fun miMetodo() {
        Toast.makeText(this,"se invoco a mi metodo2",Toast.LENGTH_LONG).show()
    }

}
