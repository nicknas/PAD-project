package com.booknow.view;

public class BookingListItem {
    public String bookingName;
    public String restaurantName;
    public String dateBooking;
    public String hourBooking;
    public String numDiners;

    public BookingListItem(String bookingName, String restaurantName, String dateBooking, String hourBooking, String numDiners){
        this.bookingName = bookingName;
        this.restaurantName = restaurantName;
        this.dateBooking = dateBooking;
        this.hourBooking = hourBooking;
        this.numDiners = numDiners;
    }

}
