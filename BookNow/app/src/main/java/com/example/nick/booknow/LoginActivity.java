package com.example.nick.booknow;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.nick.booknow.data.User;
import com.example.nick.booknow.data.UserDbHelper;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void onLoginButtonClick(View view){
        String login = ((EditText)findViewById(R.id.user_text)).getText().toString();
        String password = ((EditText)findViewById(R.id.password_text)).getText().toString();
        UserDbHelper db = new UserDbHelper(this);
        boolean isLogged = db.isUserLogged(login, password);
        if (isLogged){
            User u = db.getUserByLogin(login);
            Intent intent = new Intent(this, HomeActivity.class);
            intent.putExtra("login", u.getLogin());
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
