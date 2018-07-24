package com.booknow.data;

import android.provider.BaseColumns;

public class HoursDinersContract {
    public static abstract class HoursDinersEntry implements BaseColumns{
        public static final String TABLE_NAME = "HOURS_DINERS";
        public static final String DIA = "DIA";
        public static final String HORA = "HORA";
        public static final String ID_RESTAURANTE = "ID_RESTAURANTE";
        public static final String COMENSALES_DISPONIBLES = "COMENSALES_DISPONIBLES";
    }
}
