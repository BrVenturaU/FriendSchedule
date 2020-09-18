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

import java.sql.Date;
import java.util.ArrayList;

public class AmigoService implements IAmigoService {

    //TODO Actualizar un registro a favorito o no favorito
    //TODO Eliminar un amigo
    public AmigoService() {
    }

    private DbContextSqLiteHelper contextSqLiteHelper;
    private SQLiteDatabase db;
    private String query;

    public ArrayList<Amigo> getAll(Context context, Integer favorito){
        //Conección con la base de datos
        contextSqLiteHelper = new DbContextSqLiteHelper(context);
        db = contextSqLiteHelper.getWritableDatabase();

        //Creamos array de amigos
        ArrayList<Amigo> amigos = new ArrayList<>();

        //Parametros de seleccion y campos de la tabla a seleccionar
        String[] parametros = {favorito.toString()};
        String[] campos = {FeedDataContract.AmigoEntry._ID, FeedDataContract.AmigoEntry.COLUMN_PRIMER_NOMBRE, FeedDataContract.AmigoEntry.COLUMN_PRIMER_APELLIDO,
            FeedDataContract.AmigoEntry.COLUMN_TELEFONO, FeedDataContract.AmigoEntry.COLUMN_ES_FAVORITO};

        try{
            //Consultamos los datos (Select)
            Cursor cursor = db.query(FeedDataContract.AmigoEntry.TABLE_NAME, campos, FeedDataContract.AmigoEntry.COLUMN_ES_FAVORITO + " = ?", parametros,
                    null, null, null);
            if(cursor != null){
                //Recorremos cada registro
                cursor.moveToFirst();
                do{
                    Integer  id = cursor.getInt(cursor.getColumnIndex(FeedDataContract.AmigoEntry._ID));
                    String nombre = cursor.getString(cursor.getColumnIndex(FeedDataContract.AmigoEntry.COLUMN_PRIMER_NOMBRE));
                    String apellido = cursor.getString(cursor.getColumnIndex(FeedDataContract.AmigoEntry.COLUMN_PRIMER_APELLIDO));
                    String telefono = cursor.getString(cursor.getColumnIndex(FeedDataContract.AmigoEntry.COLUMN_TELEFONO));
                    Integer esFavorito = cursor.getInt(cursor.getColumnIndex(FeedDataContract.AmigoEntry.COLUMN_ES_FAVORITO));

                    Amigo amigo = new Amigo(id, nombre, apellido, telefono, esFavorito == 0 ? false : true);

                    //Agregamos un amigo a la lista
                    amigos.add(amigo);
                }while(cursor.moveToNext());
            }

            //Cerramos cursor y la base de datos
            cursor.close();
            db.close();

            return amigos;

        } catch (SQLiteException ex){
            //Registramos en el Logcat el error con el tag 'amigo'
            db.close();
            Log.e("amigo", ex.getMessage());
            return null;
        }
    }

    public Amigo getById(Context context, Integer id){
        contextSqLiteHelper = new DbContextSqLiteHelper(context);
        db = contextSqLiteHelper.getWritableDatabase();

        //Creamos array de amigos
        ArrayList<Amigo> amigos = new ArrayList<>();

        //Parametros de seleccion y campos de la tabla a seleccionar
        String[] parametros = {id.toString()};
        String[] campos = null;
        Amigo amigo = null;

        try{
            Cursor cursor = db.query(FeedDataContract.AmigoEntry.TABLE_NAME, campos, FeedDataContract.AmigoEntry._ID + " = ?", parametros,
                    null, null, null );
            if(cursor.moveToFirst()){
                //Recogemos los datos en variables individuales
                Integer idAmigo = cursor.getInt(cursor.getColumnIndex(FeedDataContract.AmigoEntry._ID));
                String primerNombre = cursor.getString(cursor.getColumnIndex(FeedDataContract.AmigoEntry.COLUMN_PRIMER_NOMBRE));
                String segundoNombre = cursor.getString(cursor.getColumnIndex(FeedDataContract.AmigoEntry.COLUMN_SEGUNDO_NOMBRE));
                String primerApellido = cursor.getString(cursor.getColumnIndex(FeedDataContract.AmigoEntry.COLUMN_PRIMER_APELLIDO));
                String segundoApellido = cursor.getString(cursor.getColumnIndex(FeedDataContract.AmigoEntry.COLUMN_SEGUNDO_APELLIDO));
                String telefono = cursor.getString(cursor.getColumnIndex(FeedDataContract.AmigoEntry.COLUMN_TELEFONO));
                String email = cursor.getString(cursor.getColumnIndex(FeedDataContract.AmigoEntry.COLUMN_EMAIL));
                String fechaNacimiento = cursor.getString(cursor.getColumnIndex(FeedDataContract.AmigoEntry.COLUMN_FECHA_NACIMIENTO));
                Integer esFavorito = cursor.getInt(cursor.getColumnIndex(FeedDataContract.AmigoEntry.COLUMN_ES_FAVORITO));

                //Pasamos los datos al objeto amigo
                amigo = new Amigo(idAmigo, primerNombre, segundoNombre, primerApellido, segundoApellido, telefono,
                        email, Date.valueOf(fechaNacimiento), esFavorito == 0 ? false : true);
            }

            return amigo;
        }catch (SQLiteException ex){

            Log.e("amigo", ex.getMessage());
            return null;
        }
    }


}
