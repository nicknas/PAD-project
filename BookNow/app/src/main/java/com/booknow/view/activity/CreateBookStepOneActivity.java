package com.booknow.view.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.booknow.R;
import com.booknow.database.DatabaseHelper;
import com.booknow.database.model.RestaurantContract;

import java.util.ArrayList;
import java.util.List;

public class CreateBookStepOneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_book_step_one);
        AutoCompleteTextView textView = findViewById(R.id.restaurant_name_text_view);
        DatabaseHelper db = new DatabaseHelper(this);
        Cursor c = db.getAllRestaurants();
        if (c.getCount() != 0){
            List<String> regionsList = new ArrayList<>();
            while (c.moveToNext()){
                regionsList.add(c.getString(c.getColumnIndex(RestaurantContract.RestaurantEntry.NAME)));
            }
            String[] regions = new String[regionsList.size()];
            regions = regionsList.toArray(regions);
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, regions);
            textView.setAdapter(adapter);
        }
        c.close();
    }

    public void onAddRequisitesClick(View view){
        AutoCompleteTextView textView = findViewById(R.id.restaurant_name_text_view);
        DatabaseHelper db = new DatabaseHelper(this);
        if (db.isRestaurantAvailable(textView.getText().toString())){
            Intent i = new Intent(this, CreateBookStepTwoActivity.class);
            i.putExtra("restaurantName", textView.getText().toString());
            startActivity(i);
        }
        else{
            AlertDialog.Builder builder;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                builder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);
            } else {
                builder = new AlertDialog.Builder(this);
            }
            builder.setTitle("Restaurant not available")
                    .setMessage("The restaurant introduced is not available in the app")
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_info)
                    .show();
        }
    }
}
