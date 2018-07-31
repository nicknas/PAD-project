package com.booknow.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.booknow.R;

public class ManageExperiencesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_experiences);
    }

    public void onStartBookClick(View view){
        Intent i = new Intent(this, CreateBookStepOneActivity.class);
        startActivity(i);
    }
}
