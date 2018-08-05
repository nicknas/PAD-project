package com.booknow.view.activity;

import android.app.AlertDialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.booknow.R;
import com.booknow.database.DatabaseHelper;
import com.booknow.database.model.Restaurant;
import com.booknow.view.DatePickerFragment;
import com.booknow.view.TimePickerFragment;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CreateBookStepTwoActivity extends AppCompatActivity {

    private String restaurantName;
    private String bookingName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_book_step_two);
        Intent i = getIntent();
        restaurantName = i.getStringExtra("restaurantName");
        bookingName = i.getStringExtra("bookingName");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Step Two");
        Calendar c = Calendar.getInstance();
        Button hourButton = findViewById(R.id.hour_booking_button);
        hourButton.setText(String.format("%02d:%02d", c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE)));
        Button dateButton = findViewById(R.id.date_booking_button);
        dateButton.setText(c.get(Calendar.DAY_OF_MONTH) + "/" + (c.get(Calendar.MONTH) + 1) + "/" + c.get(Calendar.YEAR));
        Spinner dinersSpinner = findViewById(R.id.dinersSpinner);
        String[] dinersArray = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dinersArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dinersSpinner.setAdapter(adapter);
    }

    public void onShowTimePickerDialog(View view){
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getFragmentManager(), "timePicker");

    }

    public void onShowDatePickerDialog(View view){
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getFragmentManager(), "datePicker");
    }

    public void onGoToStepThreeClick(View view){

        Button dateButton = findViewById(R.id.date_booking_button);
        Button hourButton = findViewById(R.id.hour_booking_button);
        Spinner dinersSpinner = findViewById(R.id.dinersSpinner);
        Intent i = new Intent(this, CreateBookStepThreeActivity.class);
        i.putExtra("restaurantName", restaurantName);
        i.putExtra("bookingName", bookingName);
        i.putExtra("numDiners", Integer.parseInt((String)dinersSpinner.getSelectedItem()));
        i.putExtra("date", dateButton.getText().toString());
        i.putExtra("hour", hourButton.getText().toString());
        startActivity(i);

    }
}
