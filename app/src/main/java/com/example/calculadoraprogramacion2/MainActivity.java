package com.example.calculadoraprogramacion2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    TextView tempVal;
    Button btn;
    FloatingActionButton btnRegresar;
    String id="", acccion="nuevo";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnRegresar =findViewById(R.id.fabListaAmigos);
        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regresarLista= new Intent(getApplicationContext(),lista_amigos.class);
                startActivity(regresarLista);
            }
        });

        btn=findViewById(R.id.BtnGuardarAmigo);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempVal= findViewById(R.id.txtNombre);
                String Nombre =tempVal.getText().toString();

                tempVal= findViewById(R.id.txtDireccion);
                String Direccion =tempVal.getText().toString();

                tempVal= findViewById(R.id.txtTelefono);
                String Telefono =tempVal.getText().toString();

                tempVal= findViewById(R.id.txtEmail);
                String Email =tempVal.getText().toString();

                tempVal= findViewById(R.id.txtDui);
                String Dui =tempVal.getText().toString();

                String[] datos=new String[]{id,Nombre,Direccion,Telefono,Email,Dui};
                Amigos db = new Amigos(getApplicationContext(),"",null,1);
                String respuesta = db.administrar_amigos(acccion,datos);
                if(respuesta.equals("ok")){
                    Toast.makeText(getApplicationContext(),"amigo registrado con exito ", Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(getApplicationContext(),"error al intentar registrar "+respuesta,Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}