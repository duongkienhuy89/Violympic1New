package com.violympic.modul;

public class Zero {
    public int getBefore() {
        return before;
    }

    public void setBefore(int before) {
        this.before = before;
    }

    int before;

    public int getAffter() {
        return affter;
    }

    public void setAffter(int affter) {
        this.affter = affter;
    }

    int affter;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    int result;

    public boolean isAdd() {
        return isAdd;
    }

    public void setAdd(boolean add) {
        isAdd = add;
    }

    boolean isAdd;
    public Zero(int before,int affter, int result,boolean isAdd)
    {
        this.before=before;
        this.affter=affter;
        this.result=result;
        this.isAdd=isAdd;
    }
}
