package com.example.intent1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    private TextView text1,text2,text3,text4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        text1=(TextView) findViewById(R.id.tv1);
        text2=(TextView) findViewById(R.id.tv2);
        text3=(TextView) findViewById(R.id.tv3);
        text4=(TextView) findViewById(R.id.tv4);
        Intent intent=getIntent();
        int texto=intent.getIntExtra("Total",0);
        int textt=intent.getIntExtra("Percentage",0);
        String textth=intent.getStringExtra("Last");
        SharedPreferences sharedPref=getSharedPreferences("user_details",MODE_PRIVATE);
        text3.setText("Fname"+sharedPref.getString("Name:",""));
        text1.setText("Total:"+texto);
        text2.setText("Percent:"+textt);
        text4.setText("Last:"+textth);
    }
}