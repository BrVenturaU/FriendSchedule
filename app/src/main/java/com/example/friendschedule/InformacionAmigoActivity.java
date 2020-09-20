package com.example.friendschedule;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.friendschedule.Entities.Amigo;
import com.example.friendschedule.Interfaces.IAmigoService;
import com.example.friendschedule.Services.AmigoService;

public class InformacionAmigoActivity extends AppCompatActivity {

    private Amigo amigo;
    private IAmigoService amigoService;
    private TextView tvNombreCompleto, tvTelefono, tvEmail, tvFechaNacimiento;

    //TODO Mostrar datos en la pantalla
    //TODO Permitir agregar a favoritos
    //TODO Permitir eliminar registro
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_amigo);

        final int idAmigo =getIntent().getExtras().getInt("idAmigo");
        amigoService = new AmigoService();
        amigo = amigoService.getById(InformacionAmigoActivity.this, idAmigo);

        tvNombreCompleto = findViewById(R.id.tvNombreCompleto);
        tvTelefono = findViewById(R.id.tvTelefono);
        tvEmail = findViewById(R.id.tvEmail);
        tvFechaNacimiento = findViewById(R.id.tvFechaNacimiento);

        String nombreCompleto = amigo.getPrimerNombre() + " " + amigo.getSegundoNombre() + " " + amigo.getPrimerApellido() + " " + amigo.getSegundoApellido();

        tvNombreCompleto.setText(nombreCompleto);
        tvTelefono.setText(amigo.getTelefono());
        tvEmail.setText(amigo.getEmail());
        tvFechaNacimiento.setText(amigo.getFechaNacimiento().toString());


    }
}