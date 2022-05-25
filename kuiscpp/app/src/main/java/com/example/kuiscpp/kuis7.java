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

public class kuis7 extends AppCompatActivity {
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
        setContentView(R.layout.activity_kuis7);
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
                        Toast.makeText(kuis7.this, "silahkan pilih opsi jawaban", Toast.LENGTH_SHORT).show();
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
        questionlist.add(new modelkuis("Dibawah ini yang bukan merupakan operator asignment yaitu....", "=", "&", "And", "Xor", 1));
        questionlist.add(new modelkuis("Dibawah ini merupakan operator bitwise,kecuali....", "&", "^", "<<", "<=", 4));
        questionlist.add(new modelkuis("Increase atau Incremen adalah....", "Proses pengurangan satu", "Proses penambahan satu", "Proses pembagian satu", "Proses perkalian satu", 2));
        questionlist.add(new modelkuis("Dibawah ini penulisan For yang benar pada suatu program yaitu....", "For(inisialisai;syarat;penambahan)pernyataan;", "For(penambahan;inisialisasi;syarat)pernyataan;", "For(inisialisai;penambahan;syarat)pernyataan;", "For(penambahan;syarat;inisialisai)pernyataan;", 1));
        questionlist.add(new modelkuis("Apakah fungsi dari frintf?", "Menampilkan variabel", "Menampilkan hasil program", "Menampilkan tulisan", "Menghapus kalimat", 3));
        questionlist.add(new modelkuis("Apakah fungsi dari scanf?", "Menampilkan hasil input", "Mengeksekusi program", "Menghilangkan variabel", "Menampilkan hasil output", 1));
        questionlist.add(new modelkuis(" Apakah fungsi dari getche?", "Manampilkan karakter tanpa menekan tombol enter", "Membuat program berjalan", "Menahan agar program dapat di compile", "Membaca spasi pada program", 1));
        questionlist.add(new modelkuis("Apakah perbedaan dari cout dan cin?", "Keluaran dan keluaran", "Masukkan dan masukkan", "Keluaran dan masukkan", "Masukkan dan keluaran", 3));
        questionlist.add(new modelkuis(" Apakah perbedaan dari endl dan ends?", "Pindah baris dan penambah karakter null", "Pindah spasi dan pindah baris", "Pindah data dan tidak pindah program", "Pindah karakter dan penambah spasi", 1));
        questionlist.add(new modelkuis("\t#include <iostream>\n" +
                "using namespace std;\n" +
                "int main() {\n" +
                "\tstring nama[5]={\"Dimas\",\"Rini\",\"Aldi\",\"Bayu\",\"Putri\"};\n" +
                "\tcout<<nama[1]<<endl;\n" +
                "\tcout<<nama[3]<<endl;\n" +
                "}\n" +
                "Perhatikan program diatas, hasil output dari program tersebut adalah?\n", "Dimas dan Aldi", "Rini dan Bayu", "Dimas dan Bayu", "Rini dan Putri", 2));
        questionlist.add(new modelkuis("Fungsi dari perintah Clrscr adalah?", "Menampilkan output", "Membersihkan layar", "Menahan tampilan output", "Menampilkan karakter tertentu", 2));
        questionlist.add(new modelkuis("Berikut Sintak yang benar untuk menghasilkan output ‘Hello World’ di C++ ?", "cout<<“Hello World”;", "print<<“Hello World”;", "echo “Hello World”;", "System.out.print(“Hello World”);", 1));
        questionlist.add(new modelkuis("Perintah untuk menginput suatu nilai dari keyboard untuk di proses di dalam program adalah?", "cout", "cin", "getch", "input", 2));
        questionlist.add(new modelkuis("Suatu tempat yang berfungsi untuk menampung data atau nilai yang dapat berubah-ubah selama program berjalan disebut?", "konstanta", "variabel", "define", "function", 2));
        questionlist.add(new modelkuis("Tipe data yang digunakan untuk menghasilkan nilai TRUE dan FALSE adalah?", "integer", "booelan", "double", "float", 2));
        questionlist.add(new modelkuis("#include <iostream>\n" +
                "use namespace std;\n" +
                "int main()\n" +
                "{\n" +
                "int x = 10, y = 3;\n" +
                "Sebuah\n" +
                "int z;\n" +
                "z = x X y;\n" +
                "cout << x << “ X ” << y << “ = ” << z;\n" +
                "cout<<endl;\n" +
                "return 0;\n" +
                "}\n" +
                "Dari program diatas, penulisannya yang tidak benar?", "use namespace std;", "z = x X y;", "cout << x << “ X ” << y << “ = ” << z;", "cout<<endl;", 2));
        questionlist.add(new modelkuis("++ dan -- merupakan operator...", "Operator Aritmetika", "Operator Increment dan Decrement", "Operator Majemuk", "Operator Logika", 2));
        questionlist.add(new modelkuis("Compiler C++ yang telah beredar di pasaran antara lain, kecuali...", "Microsoft C / C++", "Visual C++", "Dev C++", "Pascal C++✓", 4));
        questionlist.add(new modelkuis("Pernyataan yang sesuai untuk mendefinisikan tipe data bilangan adalah...", "Tipe data yang berfungsi menampung data yang memiliki angka di belakang koma", "Tipe data yang digunakan untuk angka yang tidak memiliki angka bulat di belakang koma", "Tipe data yang menyimpan lebih dari satu variabel", "Data yang mempresentasikan data berupa karakter", 3));
        questionlist.add(new modelkuis("Perintah Cin pada Program C++ digunakan untuk...", "Data pada layar", "Menginput suatu nilai dari suatu piranti masukan (keyboard)", "Pendeklarasian variabel", "Mengulang proses looping pada program", 2));

    }
}