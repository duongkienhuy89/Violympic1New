package com.violympic.general;

import android.content.Context;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

public class clsDataBase {
    public static String LoadDataAssets(String inFile, Context context) {
        String tContents = "";
        try {
            InputStream stream = context.getAssets().open(inFile);

            int size = stream.available();
            byte[] buffer = new byte[size];
            stream.read(buffer);
            stream.close();
            tContents = new String(buffer);
        } catch (IOException e) {
            // Handle exceptions here
        }
        return tContents;
    }
    public static String loadDataApp(File file) {
        //Read text from file
        StringBuilder text = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {//loi
                text.append(line);
                text.append('\n');//loi
            }
            br.close();
        } catch (Exception e) {
            //You'll need to add proper error handling here
        }
        return "" + text;
    }
}
