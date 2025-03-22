package com.violympic.general;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;


import com.violympic.toanlop1.MainActivity;
import com.violympic.toanlop1.R;


public class clsHandleT {
    static Activity mActivity;

    public static void showDialog_Award_Love(Activity activity,String pName,String pLienHe){
        mActivity=activity;

        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_award_love);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));


        EditText et_name_award=(EditText)dialog.findViewById(R.id.et_name_award);
        et_name_award.setText(""+pName);

        EditText et_code_award=(EditText)dialog.findViewById(R.id.et_code_award);

        TextView tv_lienhe_award_love=(TextView)dialog.findViewById(R.id.tv_lienhe_award_love);
        tv_lienhe_award_love.setText(""+pLienHe);

        TextView tv_cancel_award = (TextView) dialog.findViewById(R.id.tv_cancel_award);
        tv_cancel_award.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
            }
        });

        TextView tv_ok_award = (TextView) dialog.findViewById(R.id.tv_ok_award);
        tv_ok_award.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(et_name_award.getText().toString().length()<5)
                {
                    CustomToast.makeText(mActivity.getApplicationContext(),"Vui lòng nhập đầy đủ Họ và Tên",CustomToast.LONG,true);
                }else if(et_code_award.getText().toString().length()<5)
                {
                    CustomToast.makeText(mActivity.getApplicationContext(),"Phản hồi phải từ 6 ký tự trở lên",CustomToast.LONG,true);
                }else {
                    ((MainActivity) mActivity).doSend_Award_Love("" + et_name_award.getText().toString(), "" + et_code_award.getText().toString().toLowerCase());
                    dialog.cancel();
                }
            }
        });


        dialog.show();
        Window window = dialog.getWindow();
        window.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
    }
    public static void showDialogVip(Activity activity){
        mActivity=activity;

        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_buy_vip);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));



        Button dialogBtn_cancel = (Button) dialog.findViewById(R.id.btn_cancel_vip);
        dialogBtn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
            }
        });

        Button dialogBtn_okay = (Button) dialog.findViewById(R.id.btn_okay_vip);
        dialogBtn_okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ((MainActivity)mActivity).doResetEqual();
                ((MainActivity)mActivity).doResetMoutain();
                ((MainActivity)mActivity).doResetMonkey();
                ((MainActivity)mActivity).doBuyVipMain();
                dialog.cancel();

            }
        });
        try {
            dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE, WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
        }catch (Exception e)
        {

        }
        dialog.show();
    }
    public static void showDialogFeedBack(Activity activity){
        mActivity=activity;

        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_feedback);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));



        Button dialogBtn_cancel = (Button) dialog.findViewById(R.id.btn_cancel_feedback);
        dialogBtn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
            }
        });

        Button dialogBtn_okay = (Button) dialog.findViewById(R.id.btn_okay_feedback);
        dialogBtn_okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ((MainActivity)mActivity).doFeedBack();
                dialog.cancel();

            }
        });
        try {
            dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE, WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
        }catch (Exception e)
        {

        }
        dialog.show();
    }
    public static void showDialog(Activity activity, String pTitle, String pContent, String pLink, String pAvata, SharedPreferences.Editor editor){
        mActivity=activity;
        final SharedPreferences.Editor mEditor=editor;
        final String cLink=pLink;
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_rate_app);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        ImageView ivLinkDialog=(ImageView) dialog.findViewById(R.id.ivLinkDialog) ;
        TextView textTitle = (TextView) dialog.findViewById(R.id.txt_file_path);
        TextView textContent = (TextView) dialog.findViewById(R.id.txt_content_rate);
        LottieAnimationView la_rate_5star=(LottieAnimationView) dialog.findViewById(R.id.la_rate_5star);
        textTitle.setText(pTitle);
        textContent.setText(pContent);
        if(pLink.trim().equals(""))
        {
            textTitle.setVisibility(View.GONE);
            la_rate_5star.setVisibility(View.VISIBLE);
        }else
        {
            la_rate_5star.setVisibility(View.GONE);
            textTitle.setVisibility(View.VISIBLE);
        }

        if(!pAvata.equals(""))
        {
            Bitmap myBitmap= BitmapFactory.decodeFile(pAvata);
            ivLinkDialog.setImageBitmap(myBitmap);
        }

        TextView dialogBtn_cancel = (TextView) dialog.findViewById(R.id.btn_cancel);
        dialogBtn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                    Toast.makeText(getApplicationContext(),"Cancel" ,Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        TextView dialogBtn_okay = (TextView) dialog.findViewById(R.id.btn_okay);
        dialogBtn_okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                if(cLink.trim().equals("")) {

                    try {
                        i = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("http://play.google.com/store/apps/details?id=" + mActivity.getPackageName()));
                        mActivity.startActivity(i);

                        mEditor.putInt("rateapp", 1);
                        mEditor.commit();
                    }catch (Exception e)
                    {

                    }


                }else
                {
                    try {
                        i = new Intent(Intent.ACTION_VIEW,
                                Uri.parse(cLink));
                        mActivity.startActivity(i);
                    }catch (Exception e)
                    {

                    }

                }

                dialog.cancel();
            }
        });
        try {
            dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE, WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
        }catch (Exception e)
        {

        }
        dialog.show();
    }
    public static void showDialogReset(Activity activity){
        mActivity=activity;

        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_home_zero);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));



        Button dialogBtn_cancel = (Button) dialog.findViewById(R.id.btn_cancel_zero);
        dialogBtn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        Button dialogBtn_okay = (Button) dialog.findViewById(R.id.btn_okay_zero);
        dialogBtn_okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ((MainActivity)mActivity).doBackHomeZero();
                dialog.cancel();
            }
        });
        try {
            dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE, WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
        }catch (Exception e)
        {

        }
        dialog.show();
    }
    public static void showDialogReport(Activity activity){
        mActivity=activity;

        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_report_question);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));


        RadioButton rb_dapan=(RadioButton)dialog.findViewById(R.id.rb_dapan);
        RadioButton rb_de=(RadioButton)dialog.findViewById(R.id.rb_de);
        RadioButton rb_khac=(RadioButton)dialog.findViewById(R.id.rb_khac);
        EditText et_other_report=(EditText)dialog.findViewById(R.id.et_other_report);

        Button dialogBtn_cancel = (Button) dialog.findViewById(R.id.btn_cancel_report);
        dialogBtn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        Button dialogBtn_okay = (Button) dialog.findViewById(R.id.btn_okay_report);
        dialogBtn_okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rb_dapan.isChecked())
                {
                    ((MainActivity)mActivity).doSendReport("dap_an");
                }else if(rb_de.isChecked())
                {
                    ((MainActivity)mActivity).doSendReport("de_bai");
                }else
                {
                    ((MainActivity)mActivity).doSendReport("khac:"+et_other_report.getText().toString());
                }

                dialog.cancel();
            }
        });
        try {
            dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE, WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
        }catch (Exception e)
        {

        }
        dialog.show();
    }
    public static void doClickShare(String pText,String pSend,Activity activity) {
        try {

            mActivity=activity;
            Intent share = new Intent(android.content.Intent.ACTION_SEND);
            share.setType("text/plain");
            share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);

            // Add data to the intent, the receiving app will decide
            // what to do with it.
            share.putExtra(Intent.EXTRA_SUBJECT, mActivity.getString(R.string.app_name));
            share.putExtra(Intent.EXTRA_TEXT,pText);

            mActivity.startActivity(Intent.createChooser(share, pSend));

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static String CoverTimeToString(int mTime)
    {
        String stTime = "";
        int timeN = mTime / 60;
        int timeD = mTime % 60;
        if (timeD >= 10)
        {
            stTime = "" + timeN + ":" + timeD;
        }
        else
        {
            stTime = "" + timeN + ":0" + timeD;
        }
        return stTime;
    }
    public static void RotateImage(ImageView pIV, long pDuration) {
        RotateAnimation rotate = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(pDuration);
        rotate.setRepeatCount(999999);
        rotate.setInterpolator(new LinearInterpolator());
        pIV.startAnimation(rotate);
    }
    public static boolean doCheckExistFile(String pFile) {
        File file = new File(pFile);
        if (file.exists()) {
            return true;
        } else {
            return false;
        }
    }
    public static Intent onpenFanpage(Context context)
    {
        try {
            context.getPackageManager().getPackageInfo("com.facebook.katana", 0);
            return new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/468522249867795"));
        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/To%C3%A1n-l%E1%BB%9Bp-12345-H%E1%BB%8Dc-Tr%E1%BB%B1c-Tuy%E1%BA%BFn-468522249867795"));
        }

    }
    public static void doPlaySoundUrlLocal(String pUrlLocal, MediaPlayer player, Context context) {
        if (doCheckExistFile(pUrlLocal) &&((MainActivity) context).checkOnPause==false) {
//        if (doCheckExistFile(pUrlLocal))
//        {
            try {
                player.stop();
                player.reset();
                player.setDataSource(pUrlLocal);
                player.prepare();
                player.start();
            } catch (Exception ex) {

            }

        }
    }
    public static void doPlaySoundAssets(String mp3,String pContry, MediaPlayer player,Boolean pLoop, Context context)  {

        if (((MainActivity) context).checkOnPause==false) {

            AssetFileDescriptor afd;
            try {
                if(!pContry.equals(""))
                {
                    afd = context.getAssets().openFd("sounds/"+pContry+"/"+ mp3);
                }else
                {
                    afd = context.getAssets().openFd("sounds/"+ mp3);
                }
                player.stop();
                player.reset();
                player.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
                afd.close();
                player.prepare();
                player.start();
                if(pLoop)
                {
                    player.setLooping(true);
                }

            } catch (Exception ex) {
//Loge("ex:"+ex);
            }
        }
    }
    public static void doPlaySoundBG(String mp3, MediaPlayer player, Context context)  {

        // if (((MainActivity) context).checkOnPause==false) {

        AssetFileDescriptor afd;
        try {
            afd = context.getAssets().openFd("" + mp3);
            player.stop();
            player.reset();
            player.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
            afd.close();
            player.prepare();
            player.start();
            player.setLooping(true);

        } catch (Exception ex) {
//Loge("ex:"+ex);
        }
        // }
    }
    public static boolean isAssetExists(Context context,String pathInAssetsDir){
        AssetManager mg = context.getResources().getAssets();
        InputStream is = null;
        try {
            is = mg.open(pathInAssetsDir);
            return true;
        } catch (IOException ex) {
            return false;
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }
    }
    public static Integer doNumberDay(String mTextDay)
    {
        try {
            if(mTextDay.contains("-"))
            {
                String []tmpArray=mTextDay.split("-");
                return Integer.parseInt(tmpArray[0])+Integer.parseInt(tmpArray[1])*30+Integer.parseInt(tmpArray[2]);
            }
        }catch (Exception exception)
        {
            return 0;
        }

        return 0;
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

    public static String capitalizeWords(String input) {
        // Tách chuỗi thành các từ dựa trên khoảng trắng
        String[] words = input.split("\\s+");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (word.length() > 0) {
                // Viết hoa chữ cái đầu tiên và các ký tự còn lại viết thường
                result.append(Character.toUpperCase(word.charAt(0)))  // Chữ cái đầu viết hoa
                        .append(word.substring(1).toLowerCase())         // Các ký tự còn lại viết thường
                        .append(" ");                                    // Thêm dấu cách giữa các từ
            }
        }

        // Loại bỏ khoảng trắng thừa ở cuối chuỗi và trả về kết quả
        return result.toString().trim();
    }

    public static  String getFlagEmoji(String countryCode) {
        if (countryCode == null || countryCode.length() != 2) return "";

        // Chuyển thành chữ in hoa (viết hoa ISO Alpha-2)
        countryCode = countryCode.toUpperCase();

        // Tạo emoji từ hai ký tự chữ cái
        int firstLetter = Character.codePointAt(countryCode, 0) - 'A' + 0x1F1E6;
        int secondLetter = Character.codePointAt(countryCode, 1) - 'A' + 0x1F1E6;

        return new String(Character.toChars(firstLetter)) + new String(Character.toChars(secondLetter));
    }
    public static   void Loge(String pContent)
    {
       // Log.e("toan12345",""+pContent);
    }
}
