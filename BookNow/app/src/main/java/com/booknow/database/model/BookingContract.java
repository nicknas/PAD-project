package com.booknow.database.model;

import android.provider.BaseColumns;

public class BookingContract {
    public static abstract class BookingEntry implements BaseColumns{
        public static final String TABLE_NAME = "BOOKING";
        public static final String DIA = "DIA";
        public static final String HORA = "HORA";
        public static final String NOMBRE_RESERVA = "NOMBRE_RESERVA";
        public static final String NUM_COMENSALES = "NUM_COMENSALES";
        public static final String ID_USUARIO = "ID_USUARIO";
        public static final String IS_PENDING = "IS_PENDING";
        public static final String IS_ACCEPTED = "IS_ACCEPTED";
    }
}
