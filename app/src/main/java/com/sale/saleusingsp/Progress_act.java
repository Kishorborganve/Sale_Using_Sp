package com.sale.saleusingsp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Progress_act extends AppCompatActivity {


    ProgressBar proGressBar;
    TextView txtWait;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);


        proGressBar=findViewById(R.id.proGressBar);
        txtWait=findViewById(R.id.txtWait);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Progress_act.this, Result_Activity.class);
                startActivity(intent);
            }
        }, 2500);
    }
}