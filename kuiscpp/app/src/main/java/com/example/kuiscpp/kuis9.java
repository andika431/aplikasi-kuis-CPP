package com.example.kuiscpp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class kuis9 extends AppCompatActivity {
    private TextView tvkuis, tvscore, tvkuisNo;
    private RadioGroup radioGroup;
    private RadioButton rb1, rb2, rb3, rb4;
    private List<modelkuis> questionlist;
    private Button btnnext;

    int totalkuis;
    int qCounter = 0;
    int score ;

    ColorStateList dfRbColor;
    boolean answered;

    private modelkuis currentkuis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuis9);
        questionlist = new ArrayList<>();
        tvkuis = findViewById(R.id.tvkuis);
        tvscore = findViewById(R.id.tvscore);
        tvkuisNo = findViewById(R.id.tvnokuis);

        radioGroup = findViewById(R.id.radiogroup);
        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);
        rb4 = findViewById(R.id.rb4);
        btnnext = findViewById(R.id.btnnext1);

        dfRbColor = rb1.getTextColors();

        addQuestionlist();
        totalkuis = questionlist.size();
        showNextQuestion();

        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answered == false){
                    if (rb1.isChecked() || rb2.isChecked() || rb3.isChecked() || rb4.isChecked()){
                        checkAnswer();
                    }
                    else{
                        Toast.makeText(kuis9.this, "silahkan pilih opsi jawaban", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    showNextQuestion();
                }
            }
        });
    }

    private void checkAnswer() {
        answered = true;
        RadioButton rbSelected = findViewById(radioGroup.getCheckedRadioButtonId());
        int answerNo = radioGroup.indexOfChild(rbSelected)+1;
        if(answerNo == currentkuis.getCorrectansNo()){
            score ++;
            tvscore.setText("Score : "+score);
        }
        rb1.setTextColor(Color.RED);
        rb2.setTextColor(Color.RED);
        rb3.setTextColor(Color.RED);
        rb4.setTextColor(Color.RED);
        switch (currentkuis.getCorrectansNo()){
            case 1:
                rb1.setTextColor(Color.GREEN);
                break;
            case 2:
                rb2.setTextColor(Color.GREEN);
                break;
            case 3:
                rb3.setTextColor(Color.GREEN);
                break;
            case 4:
                rb4.setTextColor(Color.GREEN);
                break;
        }
        if (qCounter < totalkuis){
            btnnext.setText("Next");
        }else{
            btnnext.setText("finish");
        }
    }

    private void showNextQuestion() {

        radioGroup.clearCheck();
        rb1.setTextColor(dfRbColor);
        rb2.setTextColor(dfRbColor);
        rb3.setTextColor(dfRbColor);
        rb4.setTextColor(dfRbColor);

        qCounter++;
        btnnext.setText("submit");
        tvkuisNo.setText("question = "+qCounter+"/"+totalkuis);
        answered = false;

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
        questionlist.add(new modelkuis("B?", "c;", "p;", "e;", "S;", 1));
        questionlist.add(new modelkuis("Dibawah ini adalah cara yang tepat untuk deklarasi variabel bilangan dengan tipe integer di C++!", "bilangan int;", "var bilangan;", "int bilangan;", "$bilangan;",3));
        questionlist.add(new modelkuis("Tipe data yang digunakan untuk bilangan pecahan adalah ?", "Char", "String", "integer", "Double",4));
        questionlist.add(new modelkuis("Tipe data yang digunakan untuk bilangan bulat adalah?", "Char", "String", "integer", "Double",3));
        questionlist.add(new modelkuis("Dibawah ini merupakan tipe data numerik kecuali ...", "Char", "String", "integer", "Double",1));
        questionlist.add(new modelkuis("Untuk melakukan operasi perkalian maka harus menggunakan operator?", "Operator pembanding", "Operator Relasi", "Operator Aritmatika", "Operator Logika",3));
        questionlist.add(new modelkuis("Tipe data yang digunakan untuk menghasilkan nilai TRUE dan FALSE adalah?", "integer", "booelan", "double", "float", 2));
        questionlist.add(new modelkuis("Di bawah ini adalah salah satu contoh operator pembanding...", "**", "%", "||", "==", 4));
        questionlist.add(new modelkuis("Di bawah ini contoh operator logika, kecuali ?", "&&", "||", "**", "!", 3));
        questionlist.add(new modelkuis("Berikut adalah bentuk umum perulangan for, yaitu...", "for (inisialisasi; syarat; modifier) pernyataan;", "for (syarat; inisialisasi; modifier) pernyataan;", "for (modifier; syarat; inisialisasi) pernyataan;", "Semuanya salah", 1));
        questionlist.add(new modelkuis("Berikut adalah pernyataan yang digunakan untuk menghentikan perulangan...", "stop", "break", "exit", "return", 2));
        questionlist.add(new modelkuis("Pernyataan yang sesuai untuk mendefinisikan tipe data bilangan adalah...", "Tipe data yang berfungsi menampung data yang memiliki angka di belakang koma", "Tipe data yang digunakan untuk angka yang tidak memiliki angka bulat di belakang koma", "Tipe data yang menyimpan lebih dari satu variabel", "Data yang mempresentasikan data berupa karakter", 3));
        questionlist.add(new modelkuis("Perintah Cin pada Program C++ digunakan untuk...", "Data pada layar", "Menginput suatu nilai dari suatu piranti masukan (keyboard)", "Pendeklarasian variabel", "Mengulang proses looping pada program", 2));
        questionlist.add(new modelkuis("Pengertian dari konstanta adalah...", "Suatu nilai yang dapat diubah selama program ", "Suatu nilai yang berubah-ubah selama program berlangsung", "Suatu nilai yang tidak dapat diubah selama program berlangsung", "Suatu nilai yang tidak dapat diubah meskipun program tidak berjalan", 3));
        questionlist.add(new modelkuis("Misalkan suatu variabel string katakanlah kalimat [30] akan diberi nilai \"SAYA BELAJAR C++\", maka perintah yang benar adalah...", "char kalimat [30] = \"SAYA BELAJAR C++\"", "char kalimat [30] = \"SAYA BELAJAR C++\";", "charter kalimat[30] = \"SAYA BELAJAR C++\"", "charter kalimat [30] = \"SAYA BELAJAR C++\";", 2));
        questionlist.add(new modelkuis("Penggunaan operator aritmatika yang benar dalam C++ yaitu...", "While(i<=30);", "T = x + angka;", "I++;", "T = x + angka", 2));
        questionlist.add(new modelkuis("C merupakan bahasa pendahulu dari C++ yang termasuk dalam bahasa pemograman tingkat menengah dan diciptakan pada tahun 1972 oleh …", "Brian W. Kernighan", "Dennis M. Ritchie", "Jawaban A dan B benar", "Salah semua", 3));
        questionlist.add(new modelkuis("Bahasa pemograman C++ diciptakan satu decade setelah C yaitu pada tahun 1983 dari Laboratorium Bell, AT&T oleh …", "Bjarne Stroustroup", "Brian W. Kernighan", "Robert Stuart", "Brian Stroustroup", 1));
        questionlist.add(new modelkuis("Nama C++ diberinama oleh Rick Mascitti dengan tanda ++ yang berasal dari operator increment pada bahasa C. Pada awal mulanya C++ diberi nama …", "“A better C”", "+C+", "Turbo C", "Borland C", 1));
        questionlist.add(new modelkuis("Pengenal (identifier) adalah suatu nama yang biasa dipakai dalam pemrograman untuk menyatakan variabel, konstanta, tipe data, dan fungsi. Berikut yang bukan merupakan bentuk aturan dalam penulisan identifier adalah ….", "Tidak boleh menggunakan reserved words yang ada dalam C++.", "Tidak boleh ada spasi", "Tidak boleh menggunakan karakter-karakter\n" +
                "~ ! @ # $ % ^ & * ( ) + ` - = { } [ ] : \" ; ' < > ? , . / |\n", "Tidak boleh dimulai dengan karakter huruf", 4));
        questionlist.add(new modelkuis("Salah satu tipe data yang ada dalam pemrograman C++ adalah unsigned yaitu ….", "Tipe data unsigned nilainya selalu negatif", "Tipe data unsigned nilainya selalu posisif", "Tipe data unsigned nilainya tidak tetap", "Tipe data unsigned nilainya selalu berubah", 2));

    }
}