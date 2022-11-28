package com.sale.saleusingsp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Amount_Activity extends AppCompatActivity {

    TextView tvDisplay;
    EditText etAmount;
    Button   btnPay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amount);

        tvDisplay= findViewById(R.id.tvDisplay);
        etAmount = findViewById(R.id.etAmount);
        btnPay=findViewById(R.id.btnPay);

        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Amount_Activity.this,Card_details.class);
                String msg = etAmount.getText().toString();
                SharedPreferences shrd = getSharedPreferences("kishor",MODE_PRIVATE);
                SharedPreferences.Editor editor = shrd.edit();

                editor.putString("str",msg);
                editor.apply();
                tvDisplay.setText(msg);
                startActivity(intent);
            }
        });
        SharedPreferences getShared = getSharedPreferences("kishor",MODE_PRIVATE);
        String value = getShared.getString("str","show");
        tvDisplay.setText(value);
    }
}