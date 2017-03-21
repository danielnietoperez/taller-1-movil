package com.example.android.holamundo;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Saludo extends AppCompatActivity {

    private TextView saludo;
    private  Bundle b;
    private String aux,nomb,apell,Snombre,Sapell,edad,sexo;
    private Resources res;


    @Override
    //on create es lo primero que se ejecuta
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saludo);

        saludo = (TextView)findViewById(R.id.txtSaludo);
        b= getIntent().getExtras();
        nomb = b.getString("Nombre");
        apell=b.getString("Apellido");
        Snombre=b.getString("Snombre");
        Sapell=b.getString("Sapellido");
        edad=b.getString("Edad");
        sexo=b.getString("Sexo");
        res = this.getResources();

        aux=res.getString(R.string.saludo)+" "+nomb+" "+Snombre+" "+apell+" "+Sapell+" "+res.getString(R.string.TuEdadEs)+" "+edad+" "+res.getString(R.string.TuSexoEs)+" "+sexo;
        saludo.setText(aux);
    }
}
