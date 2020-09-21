package com.example.friendschedule.Utils;

import com.example.friendschedule.Contracts.FeedDataContract;

public class Table_Utils {

    private Table_Utils() {
    }

    public static final String SQL_CREAR_ENTRADAS_AMIGO =
            "CREATE TABLE " + FeedDataContract.AmigoEntry.TABLE_NAME + " (" +
                    FeedDataContract.AmigoEntry._ID + " INTEGER PRIMARY KEY NOT NULL, " +
                    FeedDataContract.AmigoEntry.COLUMN_PRIMER_NOMBRE + " VARCHAR(20) NOT NULL, " +
                    FeedDataContract.AmigoEntry.COLUMN_SEGUNDO_NOMBRE + " VARCHAR(20), " +
                    FeedDataContract.AmigoEntry.COLUMN_PRIMER_APELLIDO + " VARCHAR(20) NOT NULL, " +
                    FeedDataContract.AmigoEntry.COLUMN_SEGUNDO_APELLIDO + " VARCHAR(20), " +
                    FeedDataContract.AmigoEntry.COLUMN_TELEFONO + " VARCHAR(15) NOT NULL, " +
                    FeedDataContract.AmigoEntry.COLUMN_EMAIL + " VARCHAR(20), " +
                    FeedDataContract.AmigoEntry.COLUMN_FECHA_NACIMIENTO + " DATE, " +
                    FeedDataContract.AmigoEntry.COLUMN_ES_FAVORITO + " INTEGER);";

    public static  final String SQL_BORRAR_ENTRADAS_AMIGO =
            "DROP TABLE IF EXISTS " + FeedDataContract.AmigoEntry.TABLE_NAME;
}
