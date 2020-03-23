package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_kotlin.*

class KotlinMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)
        //Listener
        val chkMostrar = findViewById<CheckBox>(R.id.chkMostrar)
        chkMostrar.setOnClickListener{
            if(chkMostrar.isChecked)
                IVBandera.visibility=View.VISIBLE
            else
                IVBandera.visibility=View.INVISIBLE
        }
        val radioGroup = findViewById<RadioGroup>(R.id.RGroup)
        radioGroup.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { radioGroup, i ->
            if (RBDollar.isChecked)
                ConvertirDP()
            else
                ConvertirPD()
        })
    }

    fun RegresarTipoDeCambio(): Double {
    if(tipoCambio.text.toString().isEmpty())
    {
        return 0.0
    }
    else
    {
        return tipoCambio.text.toString().toDouble()
    }
}
    fun RegresarCantidad(): Double {
        if(Cantidad.text.toString().isEmpty())
        {
            return 0.0
        }
        else
        {
            return Cantidad.text.toString().toDouble()
        }
    }
    //Funciones
    fun ConvertirPD()
    {

        var tipoCambio=RegresarTipoDeCambio()
        var cantidad=RegresarCantidad()
        var resultado= 0.0
        resultado=cantidad*tipoCambio
        tvResultado.text= "$$resultado"
        IVBandera.setImageResource(R.drawable.usa)
    }
    fun ConvertirDP()
    {
        var tipoCambio=RegresarTipoDeCambio()
        var cantidad=RegresarCantidad()
        var resultado= 0.0
        resultado=cantidad/tipoCambio
        tvResultado.text= "$$resultado"
        IVBandera.setImageResource(R.drawable.bandera_de_mexico_e1567990939713)
    }
}
