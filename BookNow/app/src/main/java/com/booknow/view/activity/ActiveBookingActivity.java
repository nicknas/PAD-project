package com.booknow.view.activity;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.booknow.database.DatabaseHelper;
import com.booknow.database.model.BookingContract;
import com.booknow.database.model.Restaurant;
import com.booknow.view.BookingListItem;
import com.booknow.view.BookingListAdapter;
import com.booknow.R;

import java.util.ArrayList;
import java.util.List;

public class ActiveBookingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_active_booking);
        DatabaseHelper db = new DatabaseHelper(this);
        Cursor c = db.getActiveBookings(1);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Active Bookings");
        RecyclerView rv = findViewById(R.id.rv);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        List<BookingListItem> bookingList = new ArrayList<>();
        while (c.moveToNext()){
            Restaurant r = db.getRestaurantById(c.getInt(c.getColumnIndex(BookingContract.BookingEntry.ID_RESTAURANTE)));
            bookingList.add(new BookingListItem(c.getString(c.getColumnIndex(BookingContract.BookingEntry.NOMBRE_RESERVA)),
                    r.getName(), c.getString(c.getColumnIndex(BookingContract.BookingEntry.DIA)),
                    c.getString(c.getColumnIndex(BookingContract.BookingEntry.HORA)),
                    c.getString(c.getColumnIndex(BookingContract.BookingEntry.NUM_COMENSALES)) + " comensales"));
        }
        c.close();
        BookingListAdapter adapter = new BookingListAdapter(bookingList);
        rv.setAdapter(adapter);
        rv.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                View view = rv.findChildViewUnder(e.getX(), e.getY());
                TextView bookingNameText = view.findViewById(R.id.mission_name);
                System.out.println(bookingNameText.getText());
                Intent i = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(i);
                return true;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });
    }
}
