package com.example.friendschedule;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnAgregar, btnListado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnAgregar = findViewById(R.id.btnAgregar);
        btnListado = findViewById(R.id.btnListado);

        btnAgregar.setOnClickListener(HomeActivity.this);
        btnListado.setOnClickListener(HomeActivity.this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()){
            case R.id.btnAgregar:{
                intent = new Intent(HomeActivity.this, AgregarActivity.class);
                intent.putExtra("idAmigo", 0);
                startActivity(intent);
                break;
            }
            case R.id.btnListado:{
                intent = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            }
        }
    }
}