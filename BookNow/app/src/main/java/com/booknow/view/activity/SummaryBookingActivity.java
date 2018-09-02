package com.booknow.view.activity;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.booknow.R;
import com.booknow.database.DatabaseHelper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SummaryBookingActivity extends AppCompatActivity {

    private String restaurantName;
    private String bookingName;
    private String numDiners;
    private String date;
    private String hour;
    private int idBooking;
    private int idRestaurante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary_booking);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Summary");
        Intent i = getIntent();
        restaurantName = i.getStringExtra("restaurantName");
        bookingName = i.getStringExtra("bookingName");
        numDiners = Integer.toString(i.getIntExtra("numDiners", 0));
        date = i.getStringExtra("date");
        hour = i.getStringExtra("hour");
        idBooking = i.getIntExtra("id", -1);
        idRestaurante = i.getIntExtra("idRestaurante", -1);
        TextView bookingNameTextView = findViewById(R.id.textView9);
        TextView restaurantNameTextView = findViewById(R.id.restaurant_name_step_three);
        TextView dateBookingTextView = findViewById(R.id.date_booking_step_three);
        TextView hourBookingTextView = findViewById(R.id.hour_booking_step_three);
        TextView numDinersTextView = findViewById(R.id.textView13);
        bookingNameTextView.setText(bookingName);
        restaurantNameTextView.setText(restaurantName);
        dateBookingTextView.setText(date);
        hourBookingTextView.setText(hour);
        numDinersTextView.setText(numDiners);
    }

    public void onDeleteBookingClick(View view){
        DatabaseHelper db = new DatabaseHelper(this);
        DateFormat hourFormat = new SimpleDateFormat("HH:mm");
        Date hour = new Date();
        try {
            hour = hourFormat.parse(this.hour);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        db.deleteBookingById(idBooking, Integer.parseInt(numDiners), this.date, hour, idRestaurante);
        Intent i = new Intent(this, ActiveBookingActivity.class);
        startActivity(i);
        finish();
    }
}
