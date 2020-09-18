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
    public AmigoService() {
    }

    private DbContextSqLiteHelper contextSqLiteHelper;
    private SQLiteDatabase db;
    private String query;

    public ArrayList<Amigo> listOfAmigos(Context context){
        contextSqLiteHelper = new DbContextSqLiteHelper(context);

        db = contextSqLiteHelper.getWritableDatabase();

        ArrayList<Amigo> amigos = new ArrayList<>();
        String[] parametros = null;
        String[] campos = {FeedDataContract.AmigoEntry._ID, FeedDataContract.AmigoEntry.COLUMN_PRIMER_NOMBRE, FeedDataContract.AmigoEntry.COLUMN_PRIMER_APELLIDO,
            FeedDataContract.AmigoEntry.COLUMN_TELEFONO, FeedDataContract.AmigoEntry.COLUMN_ES_FAVORITO};

        try{
            Cursor cursor = db.query(FeedDataContract.AmigoEntry.TABLE_NAME, campos, null, null,
                    null, null, null);
            while(cursor.moveToNext()){
                amigos.add(cursor.getPosition(),
                        new Amigo(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2),
                        cursor.getString(3), cursor.getInt(4) == 0 ? false : true));
            }
            return amigos;

        } catch (SQLiteException ex){
            Log.e("amigo", ex.getMessage());
            return null;
        }
    }


}
