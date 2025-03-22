package com.violympic.toanlop1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

public class DuphongActivity extends AppCompatActivity {

    TextView tv_dp_txt;

    ArrayList<String> lstID;
    ArrayList<String> lstName;

    String tmp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duphong);
        tv_dp_txt=(TextView) findViewById(R.id.tv_dp_txt);


        tmp="";
        lstID=new ArrayList<String>();
        lstName=new ArrayList<String>();
        getAllCountryCodes();
        for (int i=0;i<lstID.size();i++)
        {
            tmp+=i+"-"+lstID.get(i)+":"+lstName.get(i)+getFlagEmoji(lstID.get(i))+"\n";
            //tmp+=i+"-"+lstID.get(i)+":"+lstName.get(i)+"\n";
        }
        tv_dp_txt.setText(""+tmp);
        Log.e("toan12345",""+tmp);

    }

    public  void getAllCountryCodes() {
        for (int i=0;i<Locale.getISOCountries().length;i++)
        {
            lstID.add(Locale.getISOCountries()[i]);
            lstName.add((new Locale("", Locale.getISOCountries()[i])).getDisplayCountry());
        }

    }

    public  String getFlagEmoji(String countryCode) {
        if (countryCode == null || countryCode.length() != 2) return "";

        // Chuyển thành chữ in hoa (viết hoa ISO Alpha-2)
        countryCode = countryCode.toUpperCase();

        // Tạo emoji từ hai ký tự chữ cái
        int firstLetter = Character.codePointAt(countryCode, 0) - 'A' + 0x1F1E6;
        int secondLetter = Character.codePointAt(countryCode, 1) - 'A' + 0x1F1E6;

        return new String(Character.toChars(firstLetter)) + new String(Character.toChars(secondLetter));
    }
}