package com.example.friendschedule;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.friendschedule.Entities.Amigo;
import com.example.friendschedule.Interfaces.IAmigoService;
import com.example.friendschedule.Services.AmigoService;

public class InformacionAmigoActivity extends AppCompatActivity {

    private Amigo amigo;
    private IAmigoService amigoService;

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
        Toast.makeText(InformacionAmigoActivity.this, amigo.getPrimerNombre(), Toast.LENGTH_SHORT).show();

    }
}