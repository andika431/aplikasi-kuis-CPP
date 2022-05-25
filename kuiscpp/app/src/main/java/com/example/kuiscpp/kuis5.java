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

public class kuis5 extends AppCompatActivity {
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
        setContentView(R.layout.activity_kuis5);
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
                        Toast.makeText(kuis5.this, "silahkan pilih opsi jawaban", Toast.LENGTH_SHORT).show();
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
        questionlist.add(new modelkuis("Bahasa c++ adalah....", "Sebuah bahasa pemrograman tingkat tinggi", "Sebuah bahasa pemrograman tingkat atas", "Sebuah  bahasa pemrograman tingkat menengah", "Sebuah bahasa pemrograman tingkat rendah", 1));
        questionlist.add(new modelkuis("Siapakah yang pertama kali mememukan bahasa c++?", "Dennis Ritchie", "Nikleus Wirth", "Bjarne Stroustrup", "Bill Gates", 3));
        questionlist.add(new modelkuis("Bahasa pemrograman c++ diberi nama oleh Rick Mascitti, namun pada awal pembuatannya diberi nama?", "A better B", "A better D", "A better A", "A better C", 1));
        questionlist.add(new modelkuis("Pada tahun berapakah c++ mulai diperkenalkan ?", "1981", "1982", "1983", "1984", 3));
        questionlist.add(new modelkuis("Apakah fungsi dari tanda // pada bahasa c++?", "Memberikan syarat pada program", "Memberikan komentar pada program", "Memberikan kritik pada program", "Memberikan nilai pada program", 2));
        questionlist.add(new modelkuis("Apakah fungsi dari tanda {} pada c++?", "Mengkompile program", "Mengeksekusi program", "Memberikan Komentar", "Memblok Program", 4));
        questionlist.add(new modelkuis("Fungsi dari gets adalah....", "Menampilkan tulisan", "Menampilkan huruf besar", "Membaca spasi", "Membaca garis bawah", 3));
        questionlist.add(new modelkuis(" Tipe data berikut akan memberi nilai output, kecuali...", "int", "float", "char", "void", 4));
        questionlist.add(new modelkuis("Dibawah ini yang merupakan tipe data dalam c++...", "Int,float,char,double,const", "Float,int,double,const", "Int,float,char,double", "Const,main,void,double", 3));
        questionlist.add(new modelkuis("Penulisan kode program untuk identifier yang benar adalah...", "Long 4000;", "Float?2;", "Long break;", "Int a,b,c;", 4));
        questionlist.add(new modelkuis("Identifier yang digunakan untuk mengidentifikasi data yang nilainya sudah ditentukan. Dan tidak dapat dirubah saat program berjalan, disebut?", "Variabel", "Konstanta", "Tipe data", "Label", 2));
        questionlist.add(new modelkuis("Apakah fungsi dari frintf?", "Menampilkan variabel", "Menampilkan hasil program", "Menampilkan tulisan", "Menghapus kalimat", 3));
        questionlist.add(new modelkuis("Apakah fungsi dari scanf?", "Menampilkan hasil input", "Mengeksekusi program", "Menghilangkan variabel", "Menampilkan hasil output", 1));
        questionlist.add(new modelkuis(" Apakah fungsi dari getche?", "Manampilkan karakter tanpa menekan tombol enter", "Membuat program berjalan", "Menahan agar program dapat di compile", "Membaca spasi pada program", 1));
        questionlist.add(new modelkuis("Apakah perbedaan dari cout dan cin?", "Keluaran dan keluaran", "Masukkan dan masukkan", "Keluaran dan masukkan", "Masukkan dan keluaran", 3));
        questionlist.add(new modelkuis(" Apakah perbedaan dari endl dan ends?", "Pindah baris dan penambah karakter null", "Pindah spasi dan pindah baris", "Pindah data dan tidak pindah program", "Pindah karakter dan penambah spasi", 1));
        questionlist.add(new modelkuis("Apakah perbedaan dari clrscr dan clreol?", "Membersihkan layar dan membersihkan karakter dalam suatu program", "Membersihkan layar dan menambah spasi dalam sebuah layar outputnya", "Menghapus spasi dan menghapus kalimat untuk program yang ditampilkan", "Membersihkan  seluruh layar dan membersihkan layar dari awal sampai akhir kursor", 4));
        questionlist.add(new modelkuis("Fungsi yang digunakan untuk membuat string menjadi capital adalah...", "Strcpy", "Strupr", "Strcmp", "Strcat", 2));
        questionlist.add(new modelkuis("Fungsi yang digunakan untuk mengubah huruf menjadi kecil semua adalah....", "Strcmp", "Strump", "Strlwr", "Strcat", 3));
        questionlist.add(new modelkuis("Mengapa program bahasa c++ bersifat case sensitive?", "Huruf besar dan kecil sama", "Huruf besar dan kecil sama-sama", "Huruf besar dan kecil berbeda-beda tetapi tetap satu", "Huruf besar dan kecil dianggap beda", 4));

    }
}