package com.booknow.data;

import android.provider.BaseColumns;

public class RestaurantContract {
    public static abstract class RestaurantEntry implements BaseColumns {
        public static final String TABLE_NAME = "RESTAURANT";
        public static final String NAME = "NAME";
        public static final String INAUGURACION = "INAUGURACION";
        public static final String DIRECCION = "DIRECCION";
        public static final String CHEF = "CHEF";
        public static final String HORARIO_APERTURA = "HORARIO_APERTURA";
        public static final String HORARIO_CIERRE = "HORARIO_CIERRE";
    }

}
