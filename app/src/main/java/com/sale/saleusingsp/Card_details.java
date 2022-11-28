package com.sale.saleusingsp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Card_details extends AppCompatActivity {

    TextView txtView;
    TextView txtCard;
    EditText cardNo;
    EditText expNo;
    Button   subButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_details);

        txtView=findViewById(R.id.txtView);
        txtCard = findViewById(R.id.txtCard);
        cardNo=findViewById(R.id.cardNo);
        expNo=findViewById(R.id.expNo);
        subButton = findViewById(R.id.subButton);

        subButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
        Intent intent = new Intent(Card_details.this,Pin_Activity.class);
        String msg = cardNo.getText().toString();
        String msg1 = expNo.getText().toString();
        SharedPreferences shrd = getSharedPreferences("kish",MODE_PRIVATE);
        SharedPreferences shrd1 = getSharedPreferences("soumya",MODE_PRIVATE);
        SharedPreferences.Editor editor = shrd.edit();
        SharedPreferences.Editor editor1 = shrd1.edit();


        editor.putString("str",msg);
        editor1.putString("str",msg1);

        editor.apply();
        editor1.apply();

        txtView.setText(msg);
        txtCard.setText(msg1);
        startActivity(intent);
            }
        });
        SharedPreferences getShared = getSharedPreferences("kish",MODE_PRIVATE);
        String value = getShared.getString("str","show");
        txtView.setText(value);

    }
}