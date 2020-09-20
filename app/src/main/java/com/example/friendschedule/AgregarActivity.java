package com.example.friendschedule;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AgregarActivity extends AppCompatActivity {
    private Button btnGuardar, btnCancelar;
    private EditText etNombre, etNumero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);

        btnGuardar = findViewById(R.id.btnGuardar);
        btnCancelar=findViewById(R.id.btnCancelar);
//        etNombre=findViewById(R.id.etNombre);
//        etNumero=findViewById(R.id.etNumero);

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AgregarActivity.this, MainActivity.class);
                startActivity(intent);

                Toast.makeText(AgregarActivity.this , "No hay contenido para guardar. Contacto descardato.", Toast.LENGTH_LONG).show();
            }
        });

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (view.getId()){
                    case R.id.btnCancelar:
                        limpiar();
                        break;

                    case R.id.btnGuardar:
//                        String nombre  = etNombre.getText().toString();
//                        int numero = Integer.valueOf(etNumero.getText().toString());
//                        Agregar a = new Agregar(nombre, numero);
//                        AgregarDAO dao = new AgregarDAO(AgregarActivity.this);
//                        long res  = dao.insert(a);
//                        if(res!= -1){
//                            Toast.makeText(AgregarActivity.this, "Contacto guardado "+ res, Toast.LENGTH_LONG).show();
//                            limpiar();
//                        }
//                        break;
                }


                Intent intent = new Intent(AgregarActivity.this, MainActivity.class);
                startActivity(intent);

                Toast.makeText(AgregarActivity.this, "Nuevo contacto guardado.", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void limpiar(){
        etNombre.setText("");
        etNumero.setText("");
    }
}