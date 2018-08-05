package com.booknow.view.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.booknow.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Home");
        TextView welcomeText = findViewById(R.id.username);
        SharedPreferences shared = getSharedPreferences("booknow", 0);
        welcomeText.setText(shared.getString("login", "default"));
    }

    public void onManageExperiencesClick(View view){
        Intent i = new Intent(this, ManageExperiencesActivity.class);
        startActivity(i);

    }

    @Override
    public void onBackPressed() {
        return;
    }
}
