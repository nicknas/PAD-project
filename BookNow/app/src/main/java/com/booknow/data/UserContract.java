package com.booknow.data;

import android.provider.BaseColumns;

public class UserContract {
    public static abstract class UserEntry implements BaseColumns{
        public static final String TABLE_NAME = "USER";
        public static final String LOGIN = "LOGIN";
        public static final String TELEFONO = "TELEFONO";
        public static final String PASSWORD = "PASSWORD";
        public static final String EMAIL = "EMAIL";
    }

}
