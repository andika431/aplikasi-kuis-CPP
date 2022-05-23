package com.example.kuiscpp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class kuis extends AppCompatActivity {

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
        setContentView(R.layout.activity_kuis);
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
                        Toast.makeText(kuis.this, "silahkan pilih opsi jawaban", Toast.LENGTH_SHORT).show();
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
            score++;
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
        questionlist.add(new modelkuis("Berikut Sintak yang benar untuk menghasilkan output ‘Hello World’ di C++ ?", "cout<<“Hello World”;", "print<<“Hello World”;", "echo “Hello World”;", "System.out.print(“Hello World”);", 1));
        questionlist.add(new modelkuis("Bagaimana cara membuat komentar di C++ ?", "/* Ini komentar", "# Ini komentar", "// Ini komentar", "< Ini komentar >",3));
        questionlist.add(new modelkuis("Setiap perintah di dalam C++ selalu diakhiri dengan tanda?", ".", "#", ":", ";",4));
        questionlist.add(new modelkuis("Tipe data apa yang digunakan untuk menyimpan variabel dengan nilai teks?", "string", "String", "txt", "Text",1));
        questionlist.add(new modelkuis("Dibawah ini adalah cara yang tepat untuk deklarasi variabel bilangan dengan tipe integer di C++!", "bilangan int;", "var bilangan;", "int bilangan;", "$bilangan;",3));
        questionlist.add(new modelkuis("Tipe data yang digunakan untuk bilangan pecahan adalah ?", "Char", "String", "integer", "Double",4));
        questionlist.add(new modelkuis("Tipe data yang digunakan untuk bilangan bulat adalah?", "Char", "String", "integer", "Double",3));
        questionlist.add(new modelkuis("Dibawah ini merupakan tipe data numerik kecuali ...", "Char", "String", "integer", "Double",1));
        questionlist.add(new modelkuis("Untuk melakukan operasi perkalian maka harus menggunakan operator?", "Operator pembanding", "Operator Relasi", "Operator Aritmatika", "Operator Logika",3));
        questionlist.add(new modelkuis("Operator pembanding digunakan untuk melakukan?", "Penjumlahan antara dua nilai", "Kombinasi antara dua nilai", "Hubungan antara dua nilai ", "Perbandingan antara dua nilai",4));
        questionlist.add(new modelkuis("Berikut ini adalah operator increment dan decrement adalah...", "++ dan --", "++ dan **", "|| dan &&", "-- dan !!",1));
        questionlist.add(new modelkuis("Berikut ini bentuk jenis perulangan di C++ Kecuali...", "For", "While", "Do While", "Switch",4));
        questionlist.add(new modelkuis("Berikut ini manakah yang termasuk bentuk umum perulangan for...", "for (inisialisasi; syarat; modifier) pernyataan;", "for (syarat; inisialisasi; modifier) pernyataan;", "for (modifier; syarat; inisialisasi) pernyataan;", "Semua opsi salah",1));
        questionlist.add(new modelkuis("Fungsi yang dapat menghentikan program (secara normal) menggunakan fungsi?", "break()", "close()", "exit()", "goto()",3));
        questionlist.add(new modelkuis("Berikut adalah file header yang berfungsi untuk menangani input/output di C++?", "#include < stream >", "#include < iostream >", "#include < conio.h >", "#include < iostring >",2));
        questionlist.add(new modelkuis("Berikut adalah cara yang benar untuk mendeklarasikan array di C++ !", "int nilai{10};", "int nilai[10];", "int [] nilai = new int[10];", "int nilai;",2));
        questionlist.add(new modelkuis("Bentuk umum perulangan do while adalah...", "while (kondisi) pernyataan;", "do {pernyataan} while (kondisi);", "while (do) {pernyataan}", "do (pernyataan) while (kondisi)",2));
        questionlist.add(new modelkuis("Method atau fungsi yang digunakan untuk mendapatkan panjang string adalah ?", "getZise()", "length()", "len()", "getLen()",2));
        questionlist.add(new modelkuis("Untuk mendeklarasikan array di C++ di tandai dengan tanda?", "{}", "||", "[]", "()",3));
        questionlist.add(new modelkuis("Bagaimana cara membuat fungsi di C++?", "namaFungsi[]", "namaFungsi()", "(namaFungsi)", "function namaFungsi",2));

    }
}