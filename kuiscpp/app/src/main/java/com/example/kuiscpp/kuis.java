package com.example.kuiscpp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class kuis extends AppCompatActivity {

    private TextView tvkuis, tvscore, tvkuisNo;
    private RadioGroup radioGroup;
    private RadioButton rb1, rb2, rb3, rb4;
    private List<modelkuis> questionlist;
    private Button btnnext;

    int totalkuis;
    int qCounter;

    private modelkuis currentkuis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuis);
        questionlist = new ArrayList<>();
        tvkuis = findViewById(R.id.tvkuis);
        tvscore = findViewById(R.id.tvscore);
        tvkuisNo = findViewById(R.id.tvnokuis);

        radioGroup = findViewById(R.id.rgroup1);
        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);
        rb4 = findViewById(R.id.rb4);

        addQuestionlist();
        totalkuis = questionlist.size();
        showNextQuestion();
    }

    private void showNextQuestion() {
        if (qCounter < totalkuis){
           currentkuis = questionlist.get(qCounter);
           tvkuis.setText(currentkuis.getKuis());
           rb1.setText(currentkuis.getOpsi1());
           rb2.setText(currentkuis.getOpsi2());
           rb3.setText(currentkuis.getOpsi3());
           rb4.setText(currentkuis.getOpsi4());
        }
        else {
            finish();
        }
    }

    private void addQuestionlist() {
        questionlist.add(new modelkuis("Aku seorang pelaut ?", "ya", "mungkin", "tidak", "bangun deck dah siang lu pengangguran :v", '4'));
        questionlist.add(new modelkuis("Apakah kamu temanku ?", "ya", "mungkin", "tidak", "Tch...",'2'));
        questionlist.add(new modelkuis("Apakah kamu mau bantu saya ikut event barter NLBB ?", "ya", "gass login", "tidak", "p ... invite",'4'));
        questionlist.add(new modelkuis("Apakah kamu mau adu mekanik dengan Yu-Zong saya ?", "gass", "mungkin", "tidak", "skuy login :v",'1'));

    }
}