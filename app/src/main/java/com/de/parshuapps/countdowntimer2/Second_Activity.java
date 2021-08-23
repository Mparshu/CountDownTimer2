package com.de.parshuapps.countdowntimer2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Second_Activity extends AppCompatActivity {

    TextView receiver_msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_activity);
        receiver_msg = (TextView)findViewById(R.id.received_value_id);


        // create the get Intent object
        Intent intent = getIntent();

        // receive the value by getStringExtra() method
        // and key must be same which is send by first activity
        String str = intent.getStringExtra("message_key");
        if (str != null){
        int num = Integer.parseInt(str);
        int num2 = (num * 10000)*6;



        // Time is in millisecond so 60sec = 60000 I have used
        // countdown Interveal is 1sec = 1000 I have used
        CountDownTimer start = new CountDownTimer(num2,1000) {
            public void onTick(long millisUntilFinished) {
                // Used for formatting digit to be in 2 digits only
                NumberFormat f = new DecimalFormat("00");
                long hour = (millisUntilFinished / 3600000) % 24;
                long min = (millisUntilFinished / 60000) % 60;
                long sec = (millisUntilFinished / 1000) % 60;
                receiver_msg.setText(f.format(min) + ":" + f.format(sec));
    }

            @Override
            public void onFinish()  { receiver_msg.setText("00:00:00"); }

        }.start();
}
    else Toast.makeText(Second_Activity.this,"Value",
                Toast.LENGTH_SHORT).show();
    }}