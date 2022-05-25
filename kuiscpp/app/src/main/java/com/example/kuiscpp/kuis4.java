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

public class kuis4 extends AppCompatActivity {
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
        setContentView(R.layout.activity_kuis4);
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
                        Toast.makeText(kuis4.this, "silahkan pilih opsi jawaban", Toast.LENGTH_SHORT).show();
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
        questionlist.add(new modelkuis("", "c;", "p;", "e;", "S;", 1));
        questionlist.add(new modelkuis("C merupakan bahasa pendahulu dari C++ yang termasuk dalam bahasa pemograman tingkat menengah dan diciptakan pada tahun 1972 oleh …", "Brian W. Kernighan", "Dennis M. Ritchie", "Jawaban A dan B benar", "Salah semua", 3));
        questionlist.add(new modelkuis("Bahasa pemograman C++ diciptakan satu decade setelah C yaitu pada tahun 1983 dari Laboratorium Bell, AT&T oleh …", "Bjarne Stroustroup", "Brian W. Kernighan", "Robert Stuart", "Brian Stroustroup", 1));
        questionlist.add(new modelkuis("Nama C++ diberinama oleh Rick Mascitti dengan tanda ++ yang berasal dari operator increment pada bahasa C. Pada awal mulanya C++ diberi nama …", "“A better C”", "+C+", "Turbo C", "Borland C", 1));
        questionlist.add(new modelkuis("Pengenal (identifier) adalah suatu nama yang biasa dipakai dalam pemrograman untuk menyatakan variabel, konstanta, tipe data, dan fungsi. Berikut yang bukan merupakan bentuk aturan dalam penulisan identifier adalah ….", "Tidak boleh menggunakan reserved words yang ada dalam C++.", "Tidak boleh ada spasi", "Tidak boleh menggunakan karakter-karakter\n" +
                "~ ! @ # $ % ^ & * ( ) + ` - = { } [ ] : \" ; ' < > ? , . / |\n", "Tidak boleh dimulai dengan karakter huruf", 4));
        questionlist.add(new modelkuis("Salah satu tipe data yang ada dalam pemrograman C++ adalah unsigned yaitu ….", "Tipe data unsigned nilainya selalu negatif", "Tipe data unsigned nilainya selalu posisif", "Tipe data unsigned nilainya tidak tetap", "Tipe data unsigned nilainya selalu berubah", 2));
        questionlist.add(new modelkuis("Proses assignment pada C ++ adalah ….", "Proses pemberian nilai kepada suatu fungsi yang telah dideklarasikan", "Proses pemberian nilai kepada suatu variabel yang tidak dideklarasikan", "Proses pemberian nilai kepada suatu variabel yang telah dideklarasikan", "Proses pemberian nilai kepada suatu fungsi yang tidak dideklarasikan", 3));
        questionlist.add(new modelkuis("Operator merupakan simbol yang biasa dilibatkan dalam program untuk melakukan suatu operasi atau manipulasi, berikut yang bukan merupakan penggunaan operator adalah untuk …", "Menjumlahkan dua nilai", "Memberikan nilai ke suatu variabel (assignment)", "Membandingkan kesamaan dua nilai", "Menginputkan suatu nilai", 4));
        questionlist.add(new modelkuis("Operator logika digunakan untuk menghubungkan 2 atau lebih statement operasi relasional yang menghasilkan nilai logika benar atau salah. Berikut yang bukan merupakan operator logika adalah ….", "AND", "OR", "WITH", "NOT", 3));
        questionlist.add(new modelkuis("Yang termasuk tipe data untuk bilangan bulat yang pada C ++ adalah …", "Float, void, int", "Short, long, double, void", "Char, int, short, long", "Float, double, long double", 3));
        questionlist.add(new modelkuis("Operasi dasar file pada prinsipnya terbagi menjadi 3 tahap, yang bukan termasuk dalam operasi dasar adalah ….", "Membuka atau mengaktifkan file", "Melaksanakan pemrosesan file", "Menutup file", "Membagi file", 4));
        questionlist.add(new modelkuis("Apabila program C++ terdiri dari lebih dari satu fungsi (modul), maka pernyataan yang benar di bawah ini adalah ...", "Fungsi yang pertama kali dijalankan adalah fungsi yang paling bawah dari program C++ tersebut.", "Fungsi yang pertama kali dijalankan adalah fungsi main() dari program C++ tersebut.", "Fungsi yang pertama kali dijalankan adalah fungsi yang paling atas dari program C++ tersebut.", "Semua jawaban di atas benar", 2));
        questionlist.add(new modelkuis("Pernyataan  yang benar di bawah ini adalah : ", "Setiap program C++ terdiri dari  satu atau lebih fungsi. ", "Setiap program C++ hanya terdiri dari satu fungsi saja. ", "Fungsi yang pertama kali dikerjakan tidak harus fungsi main().", "Tidak ada jawaban yang benar.", 1));
        questionlist.add(new modelkuis("Pernyataan yang benar di bawah ini adalah : ", "Dalam Built In Data Type ada 5 buah Modifier yaitu : int, float, double, char, void.", "Dalam Built In Data Type ada 4 buah Tipe Data Dasar yaitu : unsigned, signed, short, dan long", "Ada 2 jenis tipe data pada C++ yaitu: Built In Data Type dan Abstract data Data Type.", "Abstract Data Type merupakan tipe data yang telah disediakan oleh kompiler C/C++.", 3));
        questionlist.add(new modelkuis("Untuk menampilkan tiga buah data ( misal: int  INT1, INT2, INT3; ) ke monitor, digunakan object class iostream dalam bentuk stream yang benar adalah:", "cin >> INT1, INT2, INT3;", "cout << INT1 << INT2 << INT3;", "cin << INT1 << INT2 << INT3;", "cout >> INT1 >> INT2 >> INT3", 2));
        questionlist.add(new modelkuis("Untuk membaca tiga buah data ( misal: float FLOAT1, FLOAT2, FLOAT3)dari keyboard, digunakan object class iostream dalam bentuk stream yang benar adalah...", "cin >> FLOAT1 >> FLOAT2 >> FLOAT3;", "cin << FLOAT1,  FLOAT2 ,  FLOAT3;", "cout << FLOAT1 << FLOAT2 << FLOAT3;", "cout >> FLOAT1 >> FLOAT2 >> FLOAT3", 1));
        questionlist.add(new modelkuis("Pemberian nama variabel yang benar adalah: ", "Panjang maksimum adalah 255 karakter (ANSI).", "Tidak membedakan huruf kecil atau huruf besar.", "Boleh menggunakan kata-kata kunci (keywords) sebagai variabel.", "Diawali dengan huruf atau garis bawah (_ ) dan baru boleh dikuti dengan angka, huruf dan garis bawah", 4));
        questionlist.add(new modelkuis("Bila diketahui tiga buah bilangan :  int i = 79, j = 5;  dan  float k = i / j;  maka pernyataan: cout << “k = “;  cout.width(5); cout.precision(2);  cout << k << endl;  akan manampilkan hasil di bawah ini:", "k =  15.8", "k =  4.00", "k =  15", "k =  16", 3));
        questionlist.add(new modelkuis("Bila diketahui tiga buah bilangan :  floati = 79.0; int j = 5; floatk = i / j;  maka pernyataan: cout << “k = “; cout.width (5); cout.precision(2);  cout << k << endl;  akan manampilkan hasil di bawah ini:", "k =  15.8", "k =  4.00", "k =  15", "k =  16", 1));
        questionlist.add(new modelkuis("Pernyataan yang benar mengenai Akses anggota klass (class) di bawah ini adalah: ", "Protected adalah bagian class yang hanya dapat diakses oleh anggota dari class itu sendiri. ", "Public adalah bagian class yang  dapat diakses oleh anggota dari class itu sendiri maupun dari luar class.", "Private adalah bagian class yang hanya dapat diakses oleh anggota dari class itu sendiri dan anggota class   turunannya.", "Semua jawaban di atas benar", 2));
        questionlist.add(new modelkuis("Deklarasi konstanta di bawah ini mana yang benar : ", "const unsigned int Jumlah – Partai  24 ; ", "#define Jumlah – Partai    24 ", "const unsigned Jumlah   Partai = 24;", "#define Jumlah_Partai   24", 4));

    }
}