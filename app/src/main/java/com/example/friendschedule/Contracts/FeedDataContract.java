package com.example.friendschedule.Contracts;

import android.provider.BaseColumns;

import java.util.Date;

public final class FeedDataContract {

    private FeedDataContract() { }

    public static class AmigoEntry implements BaseColumns{
        public static final String TABLE_NAME = "Amigo";
        public static final String COLUMN_PRIMER_NOMBRE = "primerNombre";
        public static final String COLUMN_SEGUNDO_NOMBRE = "segundoNombre";
        public static final String COLUMN_PRIMER_APELLIDO = "primerApellido";
        public static final String COLUMN_SEGUNDO_APELLIDO = "segundoApellido";
        public static final String COLUMN_TELEFONO = "telefono";
        public static final String COLUMN_EMAIL = "email";
        public static final String COLUMN_FECHA_NACIMIENTO = "fechaNacimiento";

        public static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + AmigoEntry.TABLE_NAME + " (" +
                        AmigoEntry._ID + " INTEGER PRIMARY KEY NOT NULL, " +
                        AmigoEntry.COLUMN_PRIMER_NOMBRE + " VARCHAR(20) NOT NULL, " +
                        AmigoEntry.COLUMN_SEGUNDO_NOMBRE + " VARCHAR(20), " +
                        AmigoEntry.COLUMN_PRIMER_APELLIDO + " VARCHAR(20) NOT NULL, " +
                        AmigoEntry.COLUMN_SEGUNDO_APELLIDO + " VARCHAR(20), " +
                        AmigoEntry.COLUMN_TELEFONO + " VARCHAR(15) NOT NULL, " +
                        AmigoEntry.COLUMN_EMAIL + " VARCHAR(20), " +
                        AmigoEntry.COLUMN_FECHA_NACIMIENTO + " DATE);";

        public static  final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + AmigoEntry.TABLE_NAME;
    }


}
