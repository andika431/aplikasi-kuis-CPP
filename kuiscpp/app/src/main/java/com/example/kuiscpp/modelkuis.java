package com.example.kuiscpp;

public class modelkuis {
    private String kuis, opsi1, opsi2, opsi3, opsi4;
    private  int correctansNo;

    public modelkuis(String kuis, String opsi1, String opsi2, String opsi3, String opsi4, int correctansNo) {
        this.kuis = kuis;
        this.opsi1 = opsi1;
        this.opsi2 = opsi2;
        this.opsi3 = opsi3;
        this.opsi4 = opsi4;
        this.correctansNo = correctansNo;
    }

    public String getKuis() {
        return kuis;
    }

    public void setKuis(String kuis) {
        this.kuis = kuis;
    }

    public String getOpsi1() {
        return opsi1;
    }

    public void setOpsi1(String opsi1) {
        this.opsi1 = opsi1;
    }

    public String getOpsi2() {
        return opsi2;
    }

    public void setOpsi2(String opsi2) {
        this.opsi2 = opsi2;
    }

    public String getOpsi3() {
        return opsi3;
    }

    public void setOpsi3(String opsi3) {
        this.opsi3 = opsi3;
    }

    public String getOpsi4() {
        return opsi4;
    }

    public void setOpsi4(String opsi4) {
        this.opsi4 = opsi4;
    }

    public int getCorrectansNo() {
        return correctansNo;
    }

    public void setCorrectansNo(int correctansNo) {
        this.correctansNo = correctansNo;
    }
}
