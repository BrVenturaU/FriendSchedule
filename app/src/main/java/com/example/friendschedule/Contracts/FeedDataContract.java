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
    }


}
