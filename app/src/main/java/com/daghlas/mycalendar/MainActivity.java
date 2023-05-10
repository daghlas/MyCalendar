package com.daghlas.mycalendar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    TextView dateToday;
    CalendarView calendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dateToday = findViewById(R.id.dateToday);
        calendarView = findViewById(R.id.calendarView);

        //getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.calendarColor));

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("k.d_kai's Calendar");
        }

        //set current date
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat sdf = new SimpleDateFormat("dd - MM - yyyy");
        String currentDate = sdf.format(new Date());
        dateToday.setText(currentDate);

        dateToday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goBackToCurrentDate();
            }
        });

    }

    //go back to current date
    public void goBackToCurrentDate() {
        Calendar calendar = Calendar.getInstance();
        calendarView.setDate(calendar.getTimeInMillis());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.reminder, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.add_reminder) {
            Toast.makeText(this, "Reminders coming soon..", Toast.LENGTH_SHORT).show();
        }
        super.onOptionsItemSelected(item);
        return true;
    }
}