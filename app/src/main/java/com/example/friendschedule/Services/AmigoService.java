package com.example.friendschedule.Services;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import android.widget.Toast;

import com.example.friendschedule.Contracts.FeedDataContract;
import com.example.friendschedule.DataContext.DbContextSqLiteHelper;
import com.example.friendschedule.Entities.Amigo;
import com.example.friendschedule.Interfaces.IAmigoService;

import java.util.ArrayList;

public class AmigoService implements IAmigoService {

    //TODO listar no favoritos y favoritos
    //TODO Actualizar un registro a favorito o no favorito
    //TODO Eliminar un amigo
    public AmigoService() {
    }

    private DbContextSqLiteHelper contextSqLiteHelper;
    private SQLiteDatabase db;
    private String query;

    public ArrayList<Amigo> listOfAmigos(Context context, Integer favorito){
        contextSqLiteHelper = new DbContextSqLiteHelper(context);

        db = contextSqLiteHelper.getWritableDatabase();

        ArrayList<Amigo> amigos = new ArrayList<>();
        String[] parametros = {favorito.toString()};
        String[] campos = {FeedDataContract.AmigoEntry._ID, FeedDataContract.AmigoEntry.COLUMN_PRIMER_NOMBRE, FeedDataContract.AmigoEntry.COLUMN_PRIMER_APELLIDO,
            FeedDataContract.AmigoEntry.COLUMN_TELEFONO, FeedDataContract.AmigoEntry.COLUMN_ES_FAVORITO};

        try{
            Cursor cursor = db.query(FeedDataContract.AmigoEntry.TABLE_NAME, campos, "esFavorito = ?", parametros,
                    null, null, null);
            if(cursor != null){
                cursor.moveToFirst();
                do{
                    Integer  id = cursor.getInt(cursor.getColumnIndex(FeedDataContract.AmigoEntry._ID));
                    String nombre = cursor.getString(cursor.getColumnIndex(FeedDataContract.AmigoEntry.COLUMN_PRIMER_NOMBRE));
                    String apellido = cursor.getString(cursor.getColumnIndex(FeedDataContract.AmigoEntry.COLUMN_PRIMER_APELLIDO));
                    String telefono = cursor.getString(cursor.getColumnIndex(FeedDataContract.AmigoEntry.COLUMN_TELEFONO));
                    Integer esFavorito = cursor.getInt(cursor.getColumnIndex(FeedDataContract.AmigoEntry.COLUMN_ES_FAVORITO));

                    amigos.add(cursor.getPosition(),
                            new Amigo(id, nombre, apellido, telefono, esFavorito == 0 ? false : true));
                }while(cursor.moveToNext());
            }

            //Cerramos cursor y la base de datos
            cursor.close();
            db.close();

            return amigos;

        } catch (SQLiteException ex){
            Log.e("amigo", ex.getMessage());
            return null;
        }
    }


}
