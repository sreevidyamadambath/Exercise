package com.example.intent1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button b;
    EditText mark1,mark2;
    EditText name1,name2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = (Button) findViewById(R.id.b1);
        mark1 = (EditText) findViewById(R.id.edt1);
        mark2 = (EditText) findViewById(R.id.edt1);
        name1=(EditText) findViewById(R.id.tv1);
        name2=(EditText)findViewById(R.id.tv2);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int m1 = Integer.parseInt(mark1.getText().toString());
                int m2 = Integer.parseInt(mark2.getText().toString());
                int totalm = m1 + m2;
                String name=name1.getText().toString();
                String namee=name2.getText().toString();
                int percent = (totalm*100) / 200;
                SharedPreferences sharedPref=getSharedPreferences("user_details",MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPref.edit();
                editor.putInt("Toyal:",totalm);
                editor.putInt("Perc:",percent);
                editor.putString("Name:",name);
                editor.putString("Lat:",namee);

                editor.apply();
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("Total", totalm);
                intent.putExtra("Percentage", percent);
                intent.putExtra("Last",namee);
                startActivity(intent);
            }
        });



        }
    }
