package com.example.nick.booknow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PendingBookingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RecyclerView rv = findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        List<BookingItems> bookingList = new ArrayList<>();
        bookingList.add(new BookingItems("Misión 1", "6/05/2018", "14:00 - 15:00", "2 comensales"));
        bookingList.add(new BookingItems("Misión 1", "6/05/2018", "18:00 - 19:00", "5 comensales"));
        BookingListAdapter adapter = new BookingListAdapter(bookingList);
        setContentView(R.layout.activity_pending_booking);
    }
}
