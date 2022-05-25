package com.example.kuiscpp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ksoal extends AppCompatActivity {

    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ksoal);
        btn1 = findViewById(R.id.btn_s1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(ksoal.this,kuis.class);
                startActivity(a);
            }
        });
        btn2 = findViewById(R.id.btn_s2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent k = new Intent(ksoal.this,kuis1.class);
                startActivity(k);
            }
        });
        btn3 = findViewById(R.id.btn_s3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent c = new Intent(ksoal.this,kuis2.class);
                startActivity(c);
            }
        });
        btn4 = findViewById(R.id.btn_s4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent d = new Intent(ksoal.this,kuis3.class);
                startActivity(d);
            }
        });
        btn5 = findViewById(R.id.btn_s5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent e = new Intent(ksoal.this,kuis4.class);
                startActivity(e);
            }
        });
        btn6 = findViewById(R.id.btn_s6);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent f = new Intent(ksoal.this,kuis5.class);
                startActivity(f);
            }
        });
        btn7 = findViewById(R.id.btn_s7);
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent g = new Intent(ksoal.this,kuis6.class);
                startActivity(g);
            }
        });
        btn8 = findViewById(R.id.btn_s8);
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent h = new Intent(ksoal.this,kuis7.class);
                startActivity(h);
            }
        });
        btn9 = findViewById(R.id.btn_s9);
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent z = new Intent(ksoal.this,kuis8.class);
                startActivity(z);
            }
        });
        btn10 = findViewById(R.id.btn_s10);
        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j = new Intent(ksoal.this,kuis9.class);
                startActivity(j);
            }
        });
    }
}