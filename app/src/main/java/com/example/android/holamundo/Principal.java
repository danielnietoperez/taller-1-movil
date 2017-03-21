package com.example.android.holamundo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Principal extends AppCompatActivity {
//declaramos variable
    private EditText cajaNombre;
    private EditText cajaSnombre;
    private EditText cajaApellido;
    private EditText cajaSapellido;
    private EditText cajaSexo;
    private EditText cajaEdad;
    private TextView lblMessage;
    private Intent i;
    private Bundle b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
//capturamos las cajas
        cajaNombre = (EditText) findViewById(R.id.txtNombre);
        cajaSnombre=(EditText) findViewById(R.id.txtSegundonombre);
        cajaApellido = (EditText) findViewById(R.id.txtApellido);
        cajaSapellido=(EditText) findViewById(R.id.txtSegundoapellido);
        cajaEdad=(EditText) findViewById(R.id.txtEdad);
        cajaSexo=(EditText) findViewById(R.id.txtSexo);
        //creamos el objeto intet que sirve para pasar de una actividad a otra
        i = new Intent(this,Saludo.class);
        //se crea el objeto bundle que sirver para encapsular datos
        b = new Bundle();
    }

    public void Borrar(View v){
        cajaNombre.setText("");
        cajaSnombre.setText("");
        cajaApellido.setText("");
        cajaSapellido.setText("");
        cajaEdad.setText("");
        cajaSexo.setText("");
    }

    public void saludar(View v) {
        String nomb,apell,Snombre,Sapell,edad,sexo;
        if (validar()) {
            //tomo el valor que la persona ingreso tanto en nombre como en apellido
            nomb = cajaNombre.getText().toString();
            apell = cajaApellido.getText().toString();
            Snombre= cajaSnombre.getText().toString();
            Sapell= cajaSapellido.getText().toString();
            edad=cajaEdad.getText().toString();
            sexo=cajaSexo.getText().toString();
            //Encapsulo los valores previamente tomados
            b.putString("Nombre", nomb);
            b.putString("Apellido", apell);
            b.putString("Snombre", Snombre);
            b.putString("Sapellido", Sapell);
            b.putString("Edad", edad);
            b.putString("Sexo", sexo);
            //le paso al intent todos los datos en forma encapsulada con el bundle
            i.putExtras(b);
            //Arranco la actividad que el intent me diga
            startActivity(i);
        }
    }


    public boolean validar(){
        if (cajaNombre.getText().toString().isEmpty()){
            //tambien puede usar this en ves del getaplicationcontext
            cajaNombre.setError(getResources().getString(R.string.error_1));
            //Toast.makeText(getApplicationContext(),"Digite el nombre por favor",Toast.LENGTH_SHORT).show();
            return false;
        }
        if (cajaSnombre.getText().toString().isEmpty()){
            cajaSnombre.setError(getResources().getString(R.string.error_3));
            //Toast.makeText(getApplicationContext(),"Digite el segundo nombre por favor",Toast.LENGTH_SHORT).show();
            return false;
        }
        if (cajaApellido.getText().toString().isEmpty()){
            cajaApellido.setError(getResources().getString(R.string.error_2));
            //Toast.makeText(getApplicationContext(),"Digite el apellido por favor",Toast.LENGTH_SHORT).show();
            return false;
        }

        if (cajaSapellido.getText().toString().isEmpty()){
            cajaSapellido.setError(getResources().getString(R.string.error_4));
            //Toast.makeText(getApplicationContext(),"Digite el segundo apellido por favor",Toast.LENGTH_SHORT).show();
            return false;
        }
        if (cajaEdad.getText().toString().isEmpty()){
            cajaEdad.setError(getResources().getString(R.string.error_5));
            //Toast.makeText(getApplicationContext(),"Digite la edad por favor",Toast.LENGTH_SHORT).show();
            return false;
        }
        if (cajaSexo.getText().toString().isEmpty()){
            cajaSexo.setError(getResources().getString(R.string.error_6));
            //Toast.makeText(getApplicationContext(),"Digite el sexo por favor",Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
