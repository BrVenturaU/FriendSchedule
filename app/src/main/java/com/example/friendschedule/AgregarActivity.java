package com.example.friendschedule;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.friendschedule.Entities.Amigo;
import com.example.friendschedule.Interfaces.IAmigoService;
import com.example.friendschedule.Services.AmigoService;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AgregarActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnGuardar, btnCancelar;
    private EditText etPrimerNombre, etSegundoNombre, etPrimerApellido, etSegundoApellido, etTelefono, etEmail, etFechaNacimiento;
    private IAmigoService amigoService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);

        amigoService = new AmigoService();
        btnGuardar = findViewById(R.id.btnGuardar);
        btnCancelar=findViewById(R.id.btnCancelar);
        etPrimerNombre=findViewById(R.id.etPrimerNombre);
        etSegundoNombre=findViewById(R.id.etSegundoNombre);
        etPrimerApellido=findViewById(R.id.etPrimerApellido);
        etSegundoApellido=findViewById(R.id.etSegundoApellido);
        etTelefono=findViewById(R.id.etTelefono);
        etEmail=findViewById(R.id.etEmail);
        etFechaNacimiento = findViewById(R.id.etFechaNacimiento);

        btnGuardar.setOnClickListener(AgregarActivity.this);
        btnCancelar.setOnClickListener(AgregarActivity.this);

    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()){
            case R.id.btnGuardar:{
                String primerNombre = etPrimerNombre.getText().toString();
                String segundoNombre = etSegundoNombre.getText().toString();
                String primerApellido = etPrimerApellido.getText().toString();
                String segundoApellido = etSegundoApellido.getText().toString();
                String telefono = etTelefono.getText().toString();
                String email = etEmail.getText().toString();
                String fecha = etFechaNacimiento.getText().toString();

                boolean isValidData = validateData(primerNombre, primerApellido, telefono);
                if(isValidData){
                    try {
                        Date fechaNacimiento = new SimpleDateFormat("dd-MM-yyyy").parse(fecha);
                        Amigo amigo = new Amigo(primerNombre, segundoNombre, primerApellido,
                                segundoApellido, telefono, email, fechaNacimiento, false);
                        long res  = amigoService.insert(AgregarActivity.this, amigo);
                        if(res!= -1){
                            Toast.makeText(AgregarActivity.this, "Contacto guardado", Toast.LENGTH_SHORT).show();
                            intent = new Intent(AgregarActivity.this, InformacionAmigoActivity.class);
                            intent.putExtra("idAmigo", res);
                            startActivity(intent);
                            finish();
                        }else{
                            Toast.makeText(AgregarActivity.this, "No se pudo registrar el contacto.", Toast.LENGTH_SHORT).show();
                        }
                    }catch (Exception ex){
                        Log.e("amigo", ex.getMessage());
                        Toast.makeText(AgregarActivity.this, ex.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
                break;
            }
            case R.id.btnCancelar:{
                Toast.makeText(AgregarActivity.this , "No hay contenido para guardar. Contacto descardato.", Toast.LENGTH_SHORT).show();
                intent = new Intent(AgregarActivity.this, MainActivity.class);
                startActivity(intent);
                finish();

                break;
            }
        }
    }

    private boolean validateData(String primerNombre, String primerApellido, String telefono){
        if(primerNombre.isEmpty()){
            Toast.makeText(AgregarActivity.this, "El primer nombre es obligatorio", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(primerApellido.isEmpty()){
            Toast.makeText(AgregarActivity.this, "El primer apellido es obligatorio", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(telefono.isEmpty()){
            Toast.makeText(AgregarActivity.this, "El telefono es obligatorio", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
}