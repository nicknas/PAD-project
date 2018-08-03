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
import android.widget.Button;

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
        DatabaseHelper db = new DatabaseHelper(this);
        Restaurant r = db.getRestaurantByName(restaurantName);
        Button dateButton = findViewById(R.id.date_booking_button);
        Button hourButton = findViewById(R.id.hour_booking_button);
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        DateFormat hourFormat = new SimpleDateFormat("HH:mm");
        Calendar date = Calendar.getInstance();
        Calendar hour = Calendar.getInstance();
        try {
            date.setTime(dateFormat.parse(dateButton.getText().toString()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            hour.setTime(hourFormat.parse(hourButton.getText().toString()));
        } catch (ParseException e){
            e.printStackTrace();
        }
        try {
            db.createNewBooking(date.getTime(), hour.getTime(), bookingName, 5, 1, r.getId());
            Intent i = new Intent(this, CreateBookStepThreeActivity.class);
            i.putExtra("restaurantName", restaurantName);
            i.putExtra("bookingName", bookingName);
            i.putExtra("numDiners", 5);
            i.putExtra("date", dateButton.getText().toString());
            i.putExtra("hour", hourButton.getText().toString());
            startActivity(i);
        } catch (Exception e) {
            AlertDialog.Builder builder;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                builder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);
            } else {
                builder = new AlertDialog.Builder(this);
            }
            builder.setTitle("Error")
                    .setMessage(e.getMessage())
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }
    }
}
