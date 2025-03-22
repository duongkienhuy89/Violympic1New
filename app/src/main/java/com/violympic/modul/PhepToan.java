package com.violympic.modul;

import androidx.annotation.Keep;

@Keep
public class PhepToan {
    public String getTamcongthuc() {
        return tamcongthuc;
    }

    public void setTamcongthuc(String tamcongthuc) {
        this.tamcongthuc = tamcongthuc;
    }

    String tamcongthuc;
    public String getCongthuc() {
        return congthuc;
    }

    public void setCongthuc(String congthuc) {
        this.congthuc = congthuc;
    }

    String congthuc;

    public double getKetqua() {
        return ketqua;
    }

    public void setKetqua(double ketqua) {
        this.ketqua = ketqua;
    }

    double ketqua;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    int level;

    public int getIs_flag() {
        return is_flag;
    }

    public void setIs_flag(int is_flag) {
        this.is_flag = is_flag;
    }

    int is_flag=0;



//    public int getIsFloat() {
//        return isFloat;
//    }
//
//    public void setIsFloat(int isFloat) {
//        this.isFloat = isFloat;
//    }
//
//    int isFloat=0;
}
