package com.booknow.view.activity;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.booknow.R;

public class SummaryBookingActivity extends AppCompatActivity {

    private String restaurantName;
    private String bookingName;
    private String numDiners;
    private String date;
    private String hour;

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

    }
}
