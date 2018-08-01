package com.booknow.view;


import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.app.DialogFragment;
import android.app.Fragment;
import java.util.Calendar;

import android.text.format.DateFormat;
import android.widget.Button;
import android.widget.TimePicker;


import com.booknow.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {


    public TimePickerFragment() {

    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        return new TimePickerDialog(getActivity(), this, hour, minute,
                DateFormat.is24HourFormat(getActivity()));

    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

    }
}
