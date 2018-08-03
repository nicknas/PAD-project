package com.booknow.view.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.booknow.R;
import com.booknow.database.DatabaseHelper;
import com.booknow.database.model.Restaurant;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CreateBookStepThreeActivity extends AppCompatActivity {

    private String restaurantName;
    private String bookingName;
    private String numDiners;
    private String date;
    private String hour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_book_step_three);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Step three");
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

    public void onConfirmBookingClick(View view){
        DatabaseHelper db = new DatabaseHelper(this);
        Restaurant r = db.getRestaurantByName(restaurantName);
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        DateFormat hourFormat = new SimpleDateFormat("HH:mm");
        Calendar date = Calendar.getInstance();
        Calendar hour = Calendar.getInstance();
        try {
            date.setTime(dateFormat.parse(this.date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            hour.setTime(hourFormat.parse(this.hour));
        } catch (ParseException e){
            e.printStackTrace();
        }
        try {
            db.createNewBooking(date.getTime(), hour.getTime(), bookingName, Integer.parseInt(numDiners), 1, r.getId());
            AlertDialog.Builder builder;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                builder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);
            } else {
                builder = new AlertDialog.Builder(this);
            }
            builder.setTitle("Success")
                    .setMessage("The booking was created")
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_info)
                    .show();
            Intent i = new Intent(this, HomeActivity.class);
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
