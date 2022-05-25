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

public class kuis3 extends AppCompatActivity {
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
        setContentView(R.layout.activity_kuis3);
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
                        Toast.makeText(kuis3.this, "silahkan pilih opsi jawaban", Toast.LENGTH_SHORT).show();
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
        questionlist.add(new modelkuis("Fungsi dari operator % sebagai...", "Mencari sisa pembagian 2 bilangan", "Prosentase bilangan", "Pembagian 2 bilangan", "Membagi perseratus persen", 1));
        questionlist.add(new modelkuis("Pernyataan a = 7% 4 akan menghasilkan a = ...", "3", "4", "5", "2", 1));
        questionlist.add(new modelkuis("Perhatikan program berikut\n" +
                "#include <iostream>\n" +
                "Using namespace std;\n" +
                "int main(){\n" +
                "cout << “!1 = ” << !1 << endl;\n" +
                "cout << “!0 = ” << !0 << endl;\n" +
                "return 0\n" +
                "}\n" +
                "Program diatas secara berurutan akan menghasilkan...\n", "!1 dan !0", "1 dan 0", "!1 = 0 dan !0 = 1", "0 dan 1", 3));
        questionlist.add(new modelkuis("Keuntungan memakai fungsi pada C++ adalah...", "Menguraikan tugas pemrograman yang rumit menjadi langkah-langkah yang lebih sederhana atau kecil.", "Mengurangi duplikasi kode (kode yang sama yang ditulis berulang-ulang) dalam program.", "Menyembunyikan informasi dari pengguna sehingga mencegah adanya perbuatan seperti mengubah atau mengubah program yang kita buat.", "Tipe data nama fungsi(daftar parameter)", 4));
        questionlist.add(new modelkuis("perintah yang menggunakan untuk menampilkan suatu informasi ke perangkat keluaran (layar) adalah...", "cin", "cout", "stdio.h", "getch", 2));
        questionlist.add(new modelkuis("Perhatikan program berikut !\n" +
                "#include <iostream>\n" +
                "Using namespace std;\n" +
                "Int utama{\n" +
                "Int x, y, z = 20;\n" +
                "Cout<<x<<endl;\n" +
                "Cout << y << endl;\n" +
                "Cout<<z<<endl;\n" +
                "\n" +
                "Return 0\n" +
                "}\n" +
                "Bagian yang digaris bawahi bekerja untuk...\n", "Memberi nilai 20 pada z saja", "Memberi nilai x, y, z dengan nilai 20", "Membuat variabel global", "Semua jawaban salah", 1));
        questionlist.add(new modelkuis("operator logika yang menyatakan “atau” dalam lambang berikut ini adalah...", "&&", "!", "||", "<>", 3));
        questionlist.add(new modelkuis("Operator yang digunakan dalam operasi yang melibatkan tiga buah operand adalah...", "Operator Unary", "Operator Bitwise", "Operator Fungsi", "Operator Ternary", 4));
        questionlist.add(new modelkuis("Operator logika && adalah...", "dan", "nand", "atau", "untuk", 1));
        questionlist.add(new modelkuis("#include <iostream>\n" +
                "using namespace std;\n" +
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
        questionlist.add(new modelkuis("Pengertian dari konstanta adalah...", "Suatu nilai yang dapat diubah selama program ", "Suatu nilai yang berubah-ubah selama program berlangsung", "Suatu nilai yang tidak dapat diubah selama program berlangsung", "Suatu nilai yang tidak dapat diubah meskipun program tidak berjalan", 3));
        questionlist.add(new modelkuis("Misalkan suatu variabel string katakanlah kalimat [30] akan diberi nilai \"SAYA BELAJAR C++\", maka perintah yang benar adalah...", "char kalimat [30] = \"SAYA BELAJAR C++\"", "char kalimat [30] = \"SAYA BELAJAR C++\";", "charter kalimat[30] = \"SAYA BELAJAR C++\"", "charter kalimat [30] = \"SAYA BELAJAR C++\";", 2));
        questionlist.add(new modelkuis("Penggunaan operator aritmatika yang benar dalam C++ yaitu...", "While(i<=30);", "T = x + angka;", "I++;", "T = x + angka", 2));
        questionlist.add(new modelkuis("Bilangan yang that have, paling sedikit ada satu digit angka sebelum dan sebelum titik itu termasuk dalam tipe data...", "Riil", "Booelan", "int", "Byte", 1));
        questionlist.add(new modelkuis("Yang termasuk operator logika ingkaran adalah...", "&&", "<>", "!", "||", 3));
        questionlist.add(new modelkuis("double angka; .\n" +
                "kode program disamping merupakan tipe data... \n", "Bilangan Bulat", "Logika", "Bilangan Riil", "Karakter", 3));

    }
}