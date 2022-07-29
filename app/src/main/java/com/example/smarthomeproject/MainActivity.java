package com.example.smarthomeproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button light_on=findViewById(R.id.light_on);
        Button light_off=findViewById(R.id.light_off);
        Button buzzer_off=findViewById(R.id.buzzer_off);
        Button fan_on=findViewById(R.id.fan_on);
        Button fan_off=findViewById(R.id.fan_off);
        TextView light=findViewById(R.id.light);
        TextView fan=findViewById(R.id.fan);
        TextView alarm=findViewById(R.id.alarm);
        TextView temp=findViewById(R.id.temp);
        TextView humidity=findViewById(R.id.humidity);

        light_on.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("home light");

                myRef.setValue(1);
                light.setText("Light ON");

                // Code here executes on main thread after user presses button
            }
        });

        DatabaseReference temp1 = FirebaseDatabase.getInstance().getReference().child("temp");
        // Read from the database
        temp1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                temp.setText("Temperature: "+value);
            }


            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("temp", "Failed to read value.", error.toException());
            }
        });

        DatabaseReference humidity1 = FirebaseDatabase.getInstance().getReference().child("humidity");
        // Read from the database
        humidity1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                humidity.setText("Humidity: "+value);
            }


            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("temp", "Failed to read value.", error.toException());
            }
        });



        light_off.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("home light");

                myRef.setValue(0);
                light.setText("Light OFF");


                // Code here executes on main thread after user presses button
            }
        });


        buzzer_off.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("buzzer");

                myRef.setValue(0);
                alarm.setText("Alarm OFF");

                // Code here executes on main thread after user presses button
            }
        });
        fan_on.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("fan");

                myRef.setValue(1);
                fan.setText("Exaust fan ON");

                // Code here executes on main thread after user presses button
            }
        });
        fan_off.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("fan");

                myRef.setValue(0);
                fan.setText("Exaust fan OFF");

                // Code here executes on main thread after user presses button
            }
        });



    }



}