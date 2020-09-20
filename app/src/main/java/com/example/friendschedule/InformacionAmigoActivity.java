package com.example.friendschedule;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.friendschedule.Entities.Amigo;
import com.example.friendschedule.Interfaces.IAmigoService;
import com.example.friendschedule.Services.AmigoService;

import java.text.SimpleDateFormat;

public class InformacionAmigoActivity extends AppCompatActivity implements View.OnClickListener {

    private Amigo amigo;
    private IAmigoService amigoService;
    private TextView tvNombreCompleto, tvTelefono, tvEmail, tvFechaNacimiento;
    private ImageButton btnFavorito, btnEliminar;

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
        btnFavorito = findViewById(R.id.btnFavorito);
        btnEliminar = findViewById(R.id.btnEliminar);

        btnFavorito.setOnClickListener(InformacionAmigoActivity.this);
        btnEliminar.setOnClickListener(InformacionAmigoActivity.this);
        setAmigoData();
    }

    @Override
    protected void onDestroy() {
        Intent intent = new Intent(InformacionAmigoActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
        super.onDestroy();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnFavorito:{
                amigo = amigoService.changeFavorite(InformacionAmigoActivity.this, amigo.getId(),
                        amigo.getEsFavorito() ? 0 : 1);
                if(amigo != null){
                    if(amigo.getEsFavorito()){
                        setAmigoData();
                    }
                    else{
                        setAmigoData();
                        btnFavorito.setImageResource(R.drawable.ic_favorite_remove);
                    }
                }
                break;
            }
            case R.id.btnEliminar:{
                Boolean isDeleted = amigoService.delete(InformacionAmigoActivity.this, amigo.getId());
                if(isDeleted){
                    Intent intent = new Intent(InformacionAmigoActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                break;
            }
        }
    }

    private void setAmigoData(){
        btnFavorito.setImageResource(amigo.getEsFavorito() ? R.drawable.ic_favorite_added : R.drawable.ic_favorite_remove);
        String primerNombre = amigo.getPrimerNombre();
        String segundoNombre = amigo.getSegundoNombre() == null ? "" : amigo.getSegundoNombre();
        String primerApellido = amigo.getPrimerApellido();
        String segundoApellido = amigo.getSegundoApellido() == null ? "" : amigo.getSegundoApellido();
        String nombreCompleto = primerNombre + " " + segundoNombre + " " + primerApellido + " " + segundoApellido;
        String email = amigo.getEmail();
        String patron = "dd-MM-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(patron);
        String fechaNacimiento = simpleDateFormat.format(amigo.getFechaNacimiento());

        tvNombreCompleto.setText(nombreCompleto);
        tvTelefono.setText(amigo.getTelefono());

        tvEmail.setText(email == null ? "No se ha agregado." : email);
        tvFechaNacimiento.setText(fechaNacimiento);
    }
}