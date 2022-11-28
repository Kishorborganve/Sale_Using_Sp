package com.sale.saleusingsp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Pin_Activity extends AppCompatActivity {

    TextView txtExpname;
    TextView txtPin;
    EditText etPwd;
    Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin);

        txtExpname = findViewById(R.id.txtExpname);
        txtPin = findViewById(R.id.txtPin);
        etPwd = findViewById(R.id.etPwd);
        btnSend = findViewById(R.id.btnSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Pin_Activity.this,Progress_act.class);
                String msg = etPwd.getText().toString();
                SharedPreferences shrd = getSharedPreferences("kis",MODE_PRIVATE);
                SharedPreferences.Editor editor = shrd.edit();

                editor.putString("str",msg);
                editor.apply();
                txtExpname.setText(msg);
                startActivity(intent);
            }
        });
    }
}