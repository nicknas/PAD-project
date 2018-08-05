package com.booknow.view.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.booknow.R;
import com.booknow.database.model.User;
import com.booknow.database.DatabaseHelper;


public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        SharedPreferences shared = getSharedPreferences("booknow", 0);
        if (shared.contains("login") && shared.contains("password")){
            Intent i = new Intent(this, HomeActivity.class);
            startActivity(i);
        }
    }

    public void onLoginButtonClick(View view){
        String login = ((EditText)findViewById(R.id.user_text)).getText().toString();
        String password = ((EditText)findViewById(R.id.password_text)).getText().toString();
        DatabaseHelper db = new DatabaseHelper(this);
        boolean isLogged = db.isUserLogged(login, password);
        if (isLogged){
            User u = db.getUserByLogin(login);
            SharedPreferences shared = getSharedPreferences("booknow", 0);
            SharedPreferences.Editor editor = shared.edit();
            editor.putString("login", u.getLogin());
            editor.putString("password", u.getPassword());
            editor.commit();
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        }
        else{
            AlertDialog.Builder builder;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                builder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);
            } else {
                builder = new AlertDialog.Builder(this);
            }
            builder.setTitle("Error")
                    .setMessage("User or password is incorrect")
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_info)
                    .show();
        }
    }
}
