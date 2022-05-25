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

public class kuis8 extends AppCompatActivity {
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
        setContentView(R.layout.activity_kuis8);
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
                        Toast.makeText(kuis8.this, "silahkan pilih opsi jawaban", Toast.LENGTH_SHORT).show();
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
        questionlist.add(new modelkuis("Operasi dasar file pada prinsipnya terbagi menjadi 3 tahap, yang bukan termasuk dalam operasi dasar adalah ….", "Membuka atau mengaktifkan file", "Melaksanakan pemrosesan file", "Menutup file", "Membagi file", 4));
        questionlist.add(new modelkuis("Apabila program C++ terdiri dari lebih dari satu fungsi (modul), maka pernyataan yang benar di bawah ini adalah ...", "Fungsi yang pertama kali dijalankan adalah fungsi yang paling bawah dari program C++ tersebut.", "Fungsi yang pertama kali dijalankan adalah fungsi main() dari program C++ tersebut.", "Fungsi yang pertama kali dijalankan adalah fungsi yang paling atas dari program C++ tersebut.", "Semua jawaban di atas benar", 2));
        questionlist.add(new modelkuis("Pernyataan  yang benar di bawah ini adalah : ", "Setiap program C++ terdiri dari  satu atau lebih fungsi. ", "Setiap program C++ hanya terdiri dari satu fungsi saja. ", "Fungsi yang pertama kali dikerjakan tidak harus fungsi main().", "Tidak ada jawaban yang benar.", 1));
        questionlist.add(new modelkuis("Pernyataan yang benar di bawah ini adalah : ", "Dalam Built In Data Type ada 5 buah Modifier yaitu : int, float, double, char, void.", "Dalam Built In Data Type ada 4 buah Tipe Data Dasar yaitu : unsigned, signed, short, dan long", "Ada 2 jenis tipe data pada C++ yaitu: Built In Data Type dan Abstract data Data Type.", "Abstract Data Type merupakan tipe data yang telah disediakan oleh kompiler C/C++.", 3));
        questionlist.add(new modelkuis("Untuk menampilkan tiga buah data ( misal: int  INT1, INT2, INT3; ) ke monitor, digunakan object class iostream dalam bentuk stream yang benar adalah:", "cin >> INT1, INT2, INT3;", "cout << INT1 << INT2 << INT3;", "cin << INT1 << INT2 << INT3;", "cout >> INT1 >> INT2 >> INT3", 2));
        questionlist.add(new modelkuis("Untuk membaca tiga buah data ( misal: float FLOAT1, FLOAT2, FLOAT3)dari keyboard, digunakan object class iostream dalam bentuk stream yang benar adalah...", "cin >> FLOAT1 >> FLOAT2 >> FLOAT3;", "cin << FLOAT1,  FLOAT2 ,  FLOAT3;", "cout << FLOAT1 << FLOAT2 << FLOAT3;", "cout >> FLOAT1 >> FLOAT2 >> FLOAT3", 1));
        questionlist.add(new modelkuis("Dibawah ini merupakan  tipe data yang bersifat numerik, kecuali....", "Char", "Float", "Short", "Long", 1));
        questionlist.add(new modelkuis("Sebutkan operator-operator yang terdapat dalam bahasa c++?", "Operator Logika", "Operator Bitwise", "Operator Artimatika", "a,b, dan c semua benar", 4));
        questionlist.add(new modelkuis("Penulisan header pada program diawali dengan....", "#include", "Int main", "Getch();", "iostream", 1));
        questionlist.add(new modelkuis("apakah fungsi dari header file pada program c++?", "Memanggil program", "Memanggil library-library yang ada", "Memanggil variabel pada program", "Memanggil konstanta yang ditentukan", 2));
        questionlist.add(new modelkuis("Dibawah ini yang tidak termasuk header file yaitu....", "Iostream.h", "Iomanpt.h", "Conio.h", "Stdio.h", 2));
        questionlist.add(new modelkuis("Yang merupakan perintah pada iostream.h, kecuali....", "Prinf", "Cout", "Endl", "Cin", 1));
        questionlist.add(new modelkuis(" Pada  math.h perintah pow berfungsi...", "Akar", "Bagi", "Sudut derajat", "Pangkat", 4));
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
        questionlist.add(new modelkuis("Apakah perbedaan dari cout dan cin?", "Keluaran dan keluaran", "Masukkan dan masukkan", "Keluaran dan masukkan", "Masukkan dan keluaran", 3));
        questionlist.add(new modelkuis(" Apakah perbedaan dari endl dan ends?", "Pindah baris dan penambah karakter null", "Pindah spasi dan pindah baris", "Pindah data dan tidak pindah program", "Pindah karakter dan penambah spasi", 1));
        questionlist.add(new modelkuis("Apakah perbedaan dari clrscr dan clreol?", "Membersihkan layar dan membersihkan karakter dalam suatu program", "Membersihkan layar dan menambah spasi dalam sebuah layar outputnya", "Menghapus spasi dan menghapus kalimat untuk program yang ditampilkan", "Membersihkan  seluruh layar dan membersihkan layar dari awal sampai akhir kursor", 4));

    }
}