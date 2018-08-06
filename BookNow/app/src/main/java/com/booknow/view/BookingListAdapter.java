package com.booknow.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.booknow.R;

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
    public void onBindViewHolder(@NonNull BookingViewHolder holder, int position) {
        holder.dateBooking.setText(bookings.get(position).dateBooking);
        holder.bookingName.setText(bookings.get(position).bookingName);
        holder.restaurantName.setText(bookings.get(position).restaurantName);
        holder.numDiners.setText(bookings.get(position).numDiners);
        holder.hourBooking.setText(bookings.get(position).hourBooking);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return bookings.size();
    }

    public List<BookingListItem> bookings;

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
