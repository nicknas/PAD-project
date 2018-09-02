package com.booknow.view.activity;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.booknow.R;

public class ManageExperiencesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_experiences);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Manage Experiences");
    }

    public void onStartBookClick(View view){
        Intent i = new Intent(this, CreateBookStepOneActivity.class);
        startActivity(i);
    }

    public void onActiveBookClick(View view){
        Intent i = new Intent(this, ActiveBookingActivity.class);
        startActivity(i);
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(this, HomeActivity.class);
        startActivity(i);
        finish();
    }
}
