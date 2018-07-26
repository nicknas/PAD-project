package com.booknow.database.model;

import android.provider.BaseColumns;

public class HoursRestaurantContract {
    public static abstract class HoursRestaurantEntry implements BaseColumns{
        public static final String TABLE_NAME = "HOURS_DINERS";
        public static final String DIA = "DIA";
        public static final String HORA = "HORA";
        public static final String ID_RESTAURANTE = "ID_RESTAURANTE";
        public static final String COMENSALES_DISPONIBLES = "COMENSALES_DISPONIBLES";
    }
}
