package com.booknow;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
        holder.missionName.setText(bookings.get(position).missionName);
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

    public List<BookingItems> bookings;

    public BookingListAdapter(List<BookingItems> bookings){
        this.bookings = bookings;
    }

    public static class BookingViewHolder extends RecyclerView.ViewHolder{
        public CardView cv;
        public TextView missionName;
        public TextView dateBooking;
        public TextView hourBooking;
        public TextView numDiners;
        BookingViewHolder(View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.cv);
            missionName = itemView.findViewById(R.id.mission_name);
            dateBooking = itemView.findViewById(R.id.date_booking);
            hourBooking =  itemView.findViewById(R.id.hour_booking);
            numDiners = itemView.findViewById(R.id.num_diners_booking);
        }
    }
}
