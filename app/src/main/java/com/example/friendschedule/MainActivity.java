package com.example.friendschedule;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.widget.Toast;

import com.example.friendschedule.Contracts.FeedDataContract;
import com.example.friendschedule.DataContext.DbContextSqLiteHelper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creamos nuestra base de datos
        DbContextSqLiteHelper contextSqLiteHelper = new DbContextSqLiteHelper(MainActivity.this);
        //La convertimos a modo escritura
        SQLiteDatabase db = contextSqLiteHelper.getWritableDatabase();

        //Verificamos si la base de datos ha sido creada
        Toast.makeText(MainActivity.this, contextSqLiteHelper.getDatabaseName(), Toast.LENGTH_SHORT).show();

        ContentValues values = new ContentValues();

        //Inserción de valores (en este caso solo son los campos NOT NULL)
        values.put(FeedDataContract.AmigoEntry.COLUMN_PRIMER_NOMBRE, "Pancho");
        values.put(FeedDataContract.AmigoEntry.COLUMN_PRIMER_APELLIDO, "Mendoza");
        values.put(FeedDataContract.AmigoEntry.COLUMN_TELEFONO, "7499-0909");
        values.put(FeedDataContract.AmigoEntry.COLUMN_FECHA_NACIMIENTO, "17-09-2020");

        //Verificando si la inserción se realizo correctamente
        try {
            long newRowId = db.insert(FeedDataContract.AmigoEntry.TABLE_NAME, null, values);
            String message = newRowId != -1 ? "Registro creado correctamente"
                    : "No se ha podido registrar su amigo";
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
        }catch (SQLiteException ex){
            Toast.makeText(MainActivity.this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }

        //Obteniendo datos insertados
        String query = "SELECT * FROM " + FeedDataContract.AmigoEntry.TABLE_NAME;
        String[] readData = new String[0];
        Cursor filas = db.rawQuery(query, readData);
        if(filas.moveToFirst()){
            do{
                Toast.makeText(MainActivity.this, filas.getString(0), Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, filas.getString(1), Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, filas.getString(2), Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, filas.getString(3), Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, filas.getString(4), Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, filas.getString(5), Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, filas.getString(6), Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, filas.getString(7), Toast.LENGTH_SHORT).show();
            }while(filas.moveToNext());
        }



        //Cerramos la conexión
        db.close();
    }
}