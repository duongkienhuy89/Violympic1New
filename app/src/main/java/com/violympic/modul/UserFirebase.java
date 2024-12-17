package com.violympic.modul;

public class UserFirebase {

    public UserFirebase()
    {

    }
    public UserFirebase(String key,String name_user,String name_school,String tinh,String huyen,String xa,String lop,int level)
    {
         this.key=key;
         this.name_user=name_user;
         this.name_school=name_school;
         this.tinh=tinh;
         this.huyen=huyen;
         this.xa=xa;
         this.lop=lop;
         this.level=level;
    }
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    String key="";

    public String getName_user() {
        return name_user;
    }

    public void setName_user(String name_user) {
        this.name_user = name_user;
    }

    String name_user="";

    public String getName_school() {
        return name_school;
    }

    public void setName_school(String name_school) {
        this.name_school = name_school;
    }

    String name_school="";

    public String getTinh() {
        return tinh;
    }

    public void setTinh(String tinh) {
        this.tinh = tinh;
    }

    String tinh="";

    public String getHuyen() {
        return huyen;
    }

    public void setHuyen(String huyen) {
        this.huyen = huyen;
    }

    String huyen="";

    public String getXa() {
        return xa;
    }

    public void setXa(String xa) {
        this.xa = xa;
    }

    String xa="";

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    String lop="";

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    int level=0;
}
