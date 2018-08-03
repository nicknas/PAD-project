package com.booknow.view;


import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.app.DialogFragment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.text.format.DateFormat;
import android.widget.Button;
import android.widget.TimePicker;


import com.booknow.R;

public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

    public TimePickerFragment() {

    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Button hourButton = getActivity().findViewById(R.id.hour_booking_button);
        SimpleDateFormat hourFormat = new SimpleDateFormat("HH:mm");

        Date date = new Date();
        try {
            date = hourFormat.parse(hourButton.getText().toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        TimePickerDialog t = new TimePickerDialog(getActivity(), this, date.getHours(), date.getMinutes(),
                DateFormat.is24HourFormat(getActivity()));
        t.setTitle("Set hour");
        return t;

    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        Button hourButton = getActivity().findViewById(R.id.hour_booking_button);
        String horaString = String.format("%02d:%02d", hourOfDay, minute);
        hourButton.setText(horaString);
    }
}
