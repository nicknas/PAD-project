package com.booknow.view.activity;

import android.app.DialogFragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.booknow.R;
import com.booknow.view.DatePickerFragment;
import com.booknow.view.TimePickerFragment;

import java.util.Calendar;

public class CreateBookStepTwoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_book_step_two);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Step Two");
        Calendar c = Calendar.getInstance();
        Button hourButton = findViewById(R.id.hour_booking_button);
        hourButton.setText(String.format("%02d:%02d", c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE)));
        Button dateButton = findViewById(R.id.date_booking_button);
        dateButton.setText(c.get(Calendar.DAY_OF_MONTH) + "/" + (c.get(Calendar.MONTH) + 1) + "/" + c.get(Calendar.YEAR));
    }

    public void onShowTimePickerDialog(View view){
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getFragmentManager(), "timePicker");

    }

    public void onShowDatePickerDialog(View view){
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getFragmentManager(), "datePicker");
    }
}
