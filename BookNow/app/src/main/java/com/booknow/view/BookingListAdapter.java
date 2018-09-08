package com.booknow.view;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.booknow.R;
import com.booknow.view.activity.HomeActivity;
import com.booknow.view.activity.SummaryBookingActivity;

import java.util.List;

public class BookingListAdapter extends RecyclerView.Adapter<BookingListAdapter.BookingViewHolder> {
    @NonNull
    @Override
    public BookingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.booking_item_list, parent, false);
        BookingViewHolder bvh = new BookingViewHolder(v);
        return bvh;
    }

    @Override
    public void onBindViewHolder(@NonNull BookingViewHolder holder, final int position) {
        holder.dateBooking.setText(bookings.get(position).dateBooking);
        holder.bookingName.setText(bookings.get(position).bookingName);
        holder.restaurantName.setText(bookings.get(position).restaurantName);
        holder.numDiners.setText(bookings.get(position).numDiners);
        holder.hourBooking.setText(bookings.get(position).hourBooking);
        holder.itemView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                TextView bookingNameText = v.findViewById(R.id.mission_name);
                TextView numDinersText = v.findViewById(R.id.num_diners_booking);
                TextView dateBookingText = v.findViewById(R.id.date_booking);
                TextView hourBookingText = v.findViewById(R.id.hour_booking);
                System.out.println(bookingNameText.getText());
                Intent i = new Intent(v.getContext(), SummaryBookingActivity.class);
                i.putExtra("restaurantName", ((TextView)v.findViewById(R.id.restaurant_name)).getText().toString());
                i.putExtra("bookingName", bookingNameText.getText().toString());
                i.putExtra("numDiners", Integer.parseInt(numDinersText.getText().toString().split(" comensales")[0]));
                i.putExtra("date", dateBookingText.getText().toString());
                i.putExtra("hour", hourBookingText.getText().toString());
                i.putExtra("id", bookings.get(position).id);
                i.putExtra("idRestaurante", bookings.get(position).idRestaurant);
                v.getContext().startActivity(i);
            }
        });
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return bookings.size();
    }

    private List<BookingListItem> bookings;

    public BookingListAdapter(List<BookingListItem> bookings){
        this.bookings = bookings;
    }

    public static class BookingViewHolder extends RecyclerView.ViewHolder{
        public CardView cv;
        public TextView bookingName;
        public TextView restaurantName;
        public TextView dateBooking;
        public TextView hourBooking;
        public TextView numDiners;
        BookingViewHolder(View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.cv);
            bookingName = itemView.findViewById(R.id.mission_name);
            restaurantName = itemView.findViewById(R.id.restaurant_name);
            dateBooking = itemView.findViewById(R.id.date_booking);
            hourBooking =  itemView.findViewById(R.id.hour_booking);
            numDiners = itemView.findViewById(R.id.num_diners_booking);
        }

    }
}
