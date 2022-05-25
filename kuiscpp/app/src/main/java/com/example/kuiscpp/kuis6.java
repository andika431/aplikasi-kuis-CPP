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

public class kuis6 extends AppCompatActivity {
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
        setContentView(R.layout.activity_kuis6);
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
                        Toast.makeText(kuis6.this, "silahkan pilih opsi jawaban", Toast.LENGTH_SHORT).show();
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
        questionlist.add(new modelkuis("Apakah fungsi dari tipe data char?", "Menulis karakter", "Menulis nilai huruf", "Memberikan efek", "Memberi warna", 1));
        questionlist.add(new modelkuis("Apakah fungsi dari tipe data string?", "Untuk teks", "Untuk angka", "Untuk bilangan", "Untuk nilai", 1));
        questionlist.add(new modelkuis("Dibawah ini cara penuliasan  program pointer yang benar adalah...", "P=*alamat;", "P=&a;", "P=+a;", "P=*tujuan;.", 2));
        questionlist.add(new modelkuis("Dibawah ini merupakan operator aritmatika, kecuali....", "+", "-", "/", ">/", 4));
        questionlist.add(new modelkuis("Yang merupakan operator logika adalah...", "And", "Don’t", "Sit", "endl", 1));
        questionlist.add(new modelkuis(" yang tidak termasuk pada operator relasional adalah....", "< ", "==", "<=", "<&", 4));
        questionlist.add(new modelkuis("Dibawah ini yang bukan merupakan operator asignment yaitu....", "=", "&", "And", "Xor", 1));
        questionlist.add(new modelkuis("Dibawah ini merupakan operator bitwise,kecuali....", "&", "^", "<<", "<=", 4));
        questionlist.add(new modelkuis("Increase atau Incremen adalah....", "Proses pengurangan satu", "Proses penambahan satu", "Proses pembagian satu", "Proses perkalian satu", 2));
        questionlist.add(new modelkuis("Dibawah ini penulisan For yang benar pada suatu program yaitu....", "For(inisialisai;syarat;penambahan)pernyataan;", "For(penambahan;inisialisasi;syarat)pernyataan;", "For(inisialisai;penambahan;syarat)pernyataan;", "For(penambahan;syarat;inisialisai)pernyataan;", 1));
        questionlist.add(new modelkuis("Dibawah ini merupakan  tipe data yang bersifat numerik, kecuali....", "Char", "Float", "Short", "Long", 1));
        questionlist.add(new modelkuis("Sebutkan operator-operator yang terdapat dalam bahasa c++?", "Operator Logika", "Operator Bitwise", "Operator Artimatika", "a,b, dan c semua benar", 4));
        questionlist.add(new modelkuis("Penulisan header pada program diawali dengan....", "#include", "Int main", "Getch();", "iostream", 1));
        questionlist.add(new modelkuis("apakah fungsi dari header file pada program c++?", "Memanggil program", "Memanggil library-library yang ada", "Memanggil variabel pada program", "Memanggil konstanta yang ditentukan", 2));
        questionlist.add(new modelkuis("Dibawah ini yang tidak termasuk header file yaitu....", "Iostream.h", "Iomanpt.h", "Conio.h", "Stdio.h", 2));
        questionlist.add(new modelkuis("Yang merupakan perintah pada iostream.h, kecuali....", "Prinf", "Cout", "Endl", "Cin", 1));
        questionlist.add(new modelkuis(" Pada  math.h perintah pow berfungsi...", "Akar", "Bagi", "Sudut derajat", "Pangkat", 4));
        questionlist.add(new modelkuis(" Perintah dibawah ini yang tidak termasuk pada math.h adalah...", "Max", "Min", "Pow", "Semua benar", 4));
        questionlist.add(new modelkuis(" Perintah yang terdapat pada iomanip.h adalah...", "Strlaw", "Strcat", "Setiosflags", "setioflashy", 3));
        questionlist.add(new modelkuis("Tipe data apa yang digunakan untuk menyimpan variabel dengan nilai teks?", "string", "String", "txt", "Text",1));

    }
}