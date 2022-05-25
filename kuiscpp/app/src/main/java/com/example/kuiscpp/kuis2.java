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

public class kuis2 extends AppCompatActivity {
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
        setContentView(R.layout.activity_kuis2);
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
                        Toast.makeText(kuis2.this, "silahkan pilih opsi jawaban", Toast.LENGTH_SHORT).show();
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
        questionlist.add(new modelkuis("\t#include <iostream>\n" +
                "using namespace std;\n" +
                "int main() {\n" +
                "\tstring nama[5]={\"Dimas\",\"Rini\",\"Aldi\",\"Bayu\",\"Putri\"};\n" +
                "\tcout<<nama[1]<<endl;\n" +
                "\tcout<<nama[3]<<endl;\n" +
                "}\n" +
                "Perhatikan program diatas, hasil output dari program tersebut adalah?\n", "Dimas dan Aldi", "Rini dan Bayu", "Dimas dan Bayu", "Rini dan Putri", 2));
        questionlist.add(new modelkuis("Bagaimana cara membuat fungsi di C++?", "namaFungsi[]", "namaFungsi() ", "(namaFungsi)", "function namaFungsi", 2));
        questionlist.add(new modelkuis("Di bawah ini adalah perbedaan fungsi dan prosedur...", "Fungsi menghasilkan nilai balik sementara prosedur tidak", "Fungsi dapat di deklarasikan di dalam fungsi lain, sementara prosedur tidak", "Fungsi dapat dipanggil di dalam fungsi main() sementara prosedur tidak", "Fungsi mempunyai parameter sedangkan prosedur tidak", 1));
        questionlist.add(new modelkuis("Kata kunci yang digunakan untuk menyatakan nilai balik di dalam fungsi?", "void", "return", "get", "break", 2));
        questionlist.add(new modelkuis("Perhatikan kode program C++ berikut ini:\n" +
                "#include <iostream>\n" +
                "using namespace std;\n" +
                "int Penjumlahan(int a, int b){\n" +
                "\treturn a+b;\n" +
                "}\n" +
                "int main(){\n" +
                "\tcout<<\"Hasil penjumlahan 20 + 4 = \"<<Penjumlahan(20,4)<<endl;\n" +
                "}\n" +
                "Program tersebut menggunakan ?\n", "Prosedur", "Fungsi", "class", "array", 2));
        questionlist.add(new modelkuis("Fungsi dari perintah Clrscr adalah?", "Menampilkan output", "Membersihkan layar", "Menahan tampilan output", "Menampilkan karakter tertentu", 2));
        questionlist.add(new modelkuis("Berikut Sintak yang benar untuk menghasilkan output ‘Hello World’ di C++ ?", "cout<<“Hello World”;", "print<<“Hello World”;", "echo “Hello World”;", "System.out.print(“Hello World”);", 1));
        questionlist.add(new modelkuis("Perintah untuk menginput suatu nilai dari keyboard untuk di proses di dalam program adalah?", "cout", "cin", "getch", "input", 2));
        questionlist.add(new modelkuis("Suatu tempat yang berfungsi untuk menampung data atau nilai yang dapat berubah-ubah selama program berjalan disebut?", "konstanta", "variabel", "define", "function", 2));
        questionlist.add(new modelkuis("Tipe data yang digunakan untuk menghasilkan nilai TRUE dan FALSE adalah?", "integer", "booelan", "double", "float", 2));
        questionlist.add(new modelkuis("Di bawah ini adalah salah satu contoh operator pembanding...", "**", "%", "||", "==", 4));
        questionlist.add(new modelkuis("Di bawah ini contoh operator logika, kecuali ?", "&&", "||", "**", "!", 3));
        questionlist.add(new modelkuis("Berikut adalah bentuk umum perulangan for, yaitu...", "for (inisialisasi; syarat; modifier) pernyataan;", "for (syarat; inisialisasi; modifier) pernyataan;", "for (modifier; syarat; inisialisasi) pernyataan;", "Semuanya salah", 1));
        questionlist.add(new modelkuis("Berikut adalah pernyataan yang digunakan untuk menghentikan perulangan...", "stop", "break", "exit", "return", 2));
        questionlist.add(new modelkuis("Apakah fungsi dari tipe data string?", "Untuk teks", "Untuk angka", "Untuk bilangan", "Untuk nilai", 1));
        questionlist.add(new modelkuis("Dibawah ini cara penuliasan  program pointer yang benar adalah...", "P=*alamat;", "P=&a;", "P=+a;", "P=*tujuan;.", 2));
        questionlist.add(new modelkuis("Dibawah ini merupakan operator aritmatika, kecuali....", "+", "-", "/", ">/", 4));
        questionlist.add(new modelkuis("Apakah fungsi dari tanda {} pada c++?", "Mengkompile program", "Mengeksekusi program", "Memberikan Komentar", "Memblok Program", 4));
        questionlist.add(new modelkuis("Fungsi dari gets adalah....", "Menampilkan tulisan", "Menampilkan huruf besar", "Membaca spasi", "Membaca garis bawah", 3));
        questionlist.add(new modelkuis(" Tipe data berikut akan memberi nilai output, kecuali...", "int", "float", "char", "void", 4));

    }
}