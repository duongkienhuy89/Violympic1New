package com.violympic.modul;





import android.view.View;

import androidx.annotation.Keep;

import com.violympic.toanlop1.R;

@Keep
public class LevelUser {
    int id;
    int grade;
    int cmax;
    int score;
    int star;
    int status;


    public LevelUser(int id, int grade, int score,int mopen) {
        this.id = id;
        this.grade = grade;
        this.score = score;




        if(grade==1)
        {
            if(id<=3)
            {
                cmax=30;
            }else
            {
                cmax=60;
            }
        }else if(grade==20)
        {
            if(id==0)
            {
                cmax=30;
            }else if(id==1)
            {
                cmax=60;
            }else
            {
                cmax=100;
            }
        }
        else
        {
            cmax=300;
        }


        if(score>(cmax-3))
        {
          star=3;
          status=0;
        }else  if(score>(cmax-6))
        {
            star=2;
            status=0;
        }else  if(score>(cmax/2))
        {
            star=1;
            status=0;
        }else
        {
            if(id==mopen)
            {

                status=1;
            }else if(grade==1&&id==4)
            {

                status=3;
            }
            else {

                status=2;
            }
        }

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getCmax() {
        return cmax;
    }

    public void setCmax(int cmax) {
        this.cmax = cmax;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }



}
