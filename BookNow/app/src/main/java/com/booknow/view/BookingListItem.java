package com.booknow.view;

public class BookingListItem {
    public int id;
    public String bookingName;
    public String restaurantName;
    public String dateBooking;
    public String hourBooking;
    public String numDiners;
    public int idRestaurant;

    public BookingListItem(int id, String bookingName, String restaurantName, String dateBooking, String hourBooking, String numDiners, int idRestaurant){
        this.id = id;
        this.bookingName = bookingName;
        this.restaurantName = restaurantName;
        this.dateBooking = dateBooking;
        this.hourBooking = hourBooking;
        this.numDiners = numDiners;
        this.idRestaurant = idRestaurant;
    }

}
