package com.example.smarthomeproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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

        light_on.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("home light");

                myRef.setValue(1);
                light.setText("Light ON");

                // Code here executes on main thread after user presses button
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