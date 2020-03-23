package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
EditText etCantidad;
TextView tvResultado;
EditText etTipodeCambio;
ImageView Img;
RadioGroup rgMoneda;
CheckBox chk;
boolean Dollar=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etCantidad= findViewById(R.id.tipoCambio);
        tvResultado=findViewById(R.id.tvResultado);
        etTipodeCambio=findViewById(R.id.Cantidad);
        Img= findViewById(R.id.IVBandera);
        chk = findViewById(R.id.chkMostrar);
        chk.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                {
                    Img.setVisibility(View.VISIBLE);

                }
                else
                {
                    Img.setVisibility(View.INVISIBLE);
                }
            }
        });
        rgMoneda=findViewById(R.id.RGroup);
        rgMoneda.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch (checkedId)
                {
                    case R.id.RBPeso:ActivarPeso();
                        break;
                    case R.id.RBDollar:ActivarDollar();
                        break;
                }
            }
        });
    }
    public void ActivarPeso()
    {
        Dollar=true;
        Convertir2();
        Img.setImageResource(R.drawable.bandera_de_mexico_e1567990939713);
    }
    public void ActivarDollar()
    {
        Dollar=false;
        Convertir2();
        Img.setImageResource(R.drawable.usa);
    }
    public void Convertir2(){
        double Cantidad;
        double TipoDeCambio;
        if (etCantidad.getText().toString().trim().isEmpty())
        {
            Cantidad=1;
        }else {
            Cantidad = Double.parseDouble(etCantidad.getText().toString());
        }
        if (etTipodeCambio.getText().toString().trim().isEmpty())
        {
            TipoDeCambio=1;
        }else {
            TipoDeCambio = Double.parseDouble(etTipodeCambio.getText().toString());
        }
        double resultado;
        if(Dollar==true) {
            resultado= Cantidad / TipoDeCambio;
        }
        else
        {
            resultado=Cantidad * TipoDeCambio;
        }
        tvResultado.setText("Resultado: "+resultado);
    }
}
