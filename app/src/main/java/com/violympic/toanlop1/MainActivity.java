package com.violympic.toanlop1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.Html;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.airbnb.lottie.LottieAnimationView;
import com.android.billingclient.api.AcknowledgePurchaseParams;
import com.android.billingclient.api.AcknowledgePurchaseResponseListener;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.ProductDetails;
import com.android.billingclient.api.ProductDetailsResponseListener;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchasesResponseListener;
import com.android.billingclient.api.PurchasesUpdatedListener;
import com.android.billingclient.api.QueryProductDetailsParams;
import com.android.billingclient.api.QueryPurchasesParams;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.ump.ConsentForm;
import com.google.android.ump.ConsentInformation;
import com.google.android.ump.ConsentRequestParameters;
import com.google.android.ump.UserMessagingPlatform;
import com.google.common.collect.ImmutableList;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import com.violympic.adapter.AdapterFrame;
import com.violympic.adapter.CountryAdapter;
import com.violympic.adapter.EqualAdapter20;
import com.violympic.adapter.EqualAdapter6;
import com.violympic.adapter.EqualOneAdapter12;
import com.violympic.adapter.HuyenXaAdapter;
import com.violympic.adapter.LevelAdapter;
import com.violympic.adapter.TinhAdapter;
import com.violympic.adapter.UserAdapter;
import com.violympic.general.AdmobManager;
import com.violympic.general.CustomToast;
import com.violympic.general.DownloadHtpps;
import com.violympic.general.RoundedTransformation;
import com.violympic.general.clsHandleT;
import com.violympic.modul.Award_Love;
import com.violympic.modul.Huyen_Xa;
import com.violympic.modul.LevelUser;
import com.violympic.modul.LoiVan;
import com.violympic.modul.Mountain;
import com.violympic.modul.Notifi;
import com.violympic.modul.PhepToan;
import com.violympic.modul.Tinh;
import com.violympic.modul.UserFirebase;
import com.violympic.modul.Zero;
import com.violympic.services.ScheduleNotifi;
import com.google.firebase.analytics.FirebaseAnalytics;

public class MainActivity extends FragmentActivity  {

    GridView gv_level;
    GridView gv_equal;
    GridView gv_equal_one;
    GridView gv_equal_one_12;
    LevelAdapter levelAdapter;
    EqualAdapter20 equalAdapter;
    EqualAdapter6 equalAdapter1;
    EqualOneAdapter12 equalOneAdapter12;
    ViewFlipper viewFlipperMath;
    TextView tv_score_summary;
    TextView tv_status_summary;
    ImageView iv_star_summary;
    TextView tv_main_start;
    int mRateApp;
    public  String mLinkAvata = "";

    public static int mGrade;
    int mLevel;
    public static int mMaxScore;
    ArrayList<PhepToan> lstPhepToan;
    ArrayList<PhepToan> lstPhepToanLevel;
    ArrayList<PhepToan> lstPhepToanLevelTMP;
    ArrayList<PhepToan> lstPhepToanLevel20;

    ArrayList<LoiVan> lstLoiVan;
    ArrayList<LoiVan> lstLoiVanLevel;


    ArrayList<Mountain> lstMountain;
    ArrayList<Mountain> lstMountainLevel;
    LoiVan mLoiVan;
    Mountain mMountain;
    // ArrayList<LoiVan> lstLoiVanLevel_10;

    public static ArrayList<PhepToan> lstPhepToanLevel10_1;
    public static ArrayList<PhepToan> lstPhepToanLevel10_2;
    public static ArrayList<Integer> lstSelectedMonkey;
    public static PhepToan[] lstSelectedObjectMonkey;



    Random rd;
    int mChon;

    Boolean mCheckCongThuc=true;
    PhepToan mTmpPhepToan1;
    PhepToan mTmpPhepToan2;
    ImageView rlEqual_1;
    ImageView rlEqual_2;
    View mViewEqual_1;
    View mViewEqual_2;
    double mEqual_1;
    double mEqual_2;
    int mPositionTMP;
    int mScore_Equal;
    int mNext_False_Equal;
    TextView tv_score_equal;
    TextView tv_time_ingame_equal;


    TextView tv_score_equal_one;
    TextView tv_time_ingame_equal_one;
    ImageView iv_avata_equal_one;
    ImageView iv_false_equal_one;

    TextView tv_score_equal_one_12;
    TextView tv_time_ingame_equal_one_12;
    ImageView iv_avata_equal_one_12;
    ImageView iv_false_equal_one_12;


    ImageView iv_false_equal;

    ImageView iv_flase_equal_gameover;
    TextView tv_score_equal_gameover;
TextView tv_title_gameover_equal;
    ImageView iv_avata_monkey;
    RelativeLayout rl_monkey_avata_pheptoan_bg;
    ImageView iv_monkey_avata_pheptoan_bg;
    TextView tv_monkey_avata_pheptoan;
    TextView tv_monkey_avata_phantram_ps ;
    TextView tv_monkey_avata_tuso_phantram ;
    TextView tv_monkey_avata_mauso_phantram ;
    TextView tv_monkey_avata_cua_ps1;
    TextView tv_monkey_avata_tuso_cua1;
    TextView tv_monkey_avata_mauso_cua1 ;
    TextView tv_monkey_avata_tuso_cua2 ;
    TextView tv_monkey_avata_mauso_cua2 ;
    TextView tv_monkey_avata_pheptoan_hs ;
    TextView tv_monkey_avata_hs1 ;
    TextView tv_monkey_avata_tuso_hs1 ;
    TextView tv_monkey_avata_mauso_hs1 ;
    TextView tv_monkey_avata_hs2;
    TextView tv_monkey_avata_tuso_hs2;
    TextView tv_monkey_avata_mauso_hs2 ;
    TextView tv_monkey_avata_cua_ps2;
    TextView tv_monkey_avata_tuso_cua3;
    TextView tv_monkey_avata_mauso_cua3;
    TextView tv_score_monkey;
    TextView tv_time_ingame_monkey;
    ImageView iv_false_monkey;
    public static PhepToan mMonkeyPhepToan;
    int mChonGenary;
    int mScore_MonKey;
    int mNext_False_Monkey;
    TextView tv_score_monkey_gameover;
    ImageView iv_flase_monkey_gameover;

    int mScore_Moutain;
    int mNext_False_Moutain;
    String mResultMoutain;


    ImageView iv_avata_moutain0;
    ImageView iv_avata_moutain1;
    ImageView iv_avata_moutain2;
    ImageView iv_avata_moutain3;
    ImageView iv_avata_moutain4;
    ImageView iv_avata_moutain5;
    ImageView iv_avata_moutain6;
    ImageView iv_avata_moutain7;
    ImageView iv_avata_moutain8;
    ImageView iv_avata_moutain9;
    ImageView iv_avata_moutain10;
    ImageView iv_monkey_moutain;
    ImageView iv_sumit_moutain;
    TextView tv_result_moutain;
    TextView tv_question_moutain;
    RelativeLayout rl_question_moutain;
    LinearLayout ll_number_moutain;
    ImageView iv_false_moutain;
    TextView tv_score_moutain;
    TextView tv_time_ingame_moutain;
    ImageView iv_continue_moutain;
    TextView tv_report;
    TextView tv_score_moutain_gameover;
    ImageView iv_flase_moutain_gameover;

    TextView tv_A;
    TextView tv_B;
    TextView tv_C;
    TextView tv_D;

    ImageView iv_main_buyvip;




    ImageView iv_logo_monkey;

    ImageView iv_logo_monkey_gameover;




    Animation anim_tbequal;
   // Animation anim_blink_max;
    Animation anim_tbmonkey;
   // Animation aniZoom;
 //   Animation aniZoomQuestion;
    //Animation aniShake_Summary;

   // Animation aniZoom_Plus;
    Animation aniZoom_Subs;
  //  Animation aniIn_Up;
    //Animation aninGitbox;
    Animation aniOut_Up;
   // Animation aniMoveTapZero;
   // Animation aniMoveCloud;
    Animation aninShake_Main;
    Animation aninOut_Up_Main;
    Animation aninShake_Grade;
   // Animation aninShake;
    ImageView iv_star1;
    ImageView iv_star2;
    ImageView iv_star3;
    LinearLayout ll_star_zero;


    AdapterFrame adapterMonkey;
    ViewPager viewpagerMonkey;


    public CountDownTimer mCdt_TimeGame;
    int mFirtTime;
    long mTimeLine=0;
    public static   String DeviceLang;
    public static   String DeviceLang_Root;
    String[] spinnerTitlesContry;
    CountryAdapter countryAdapter;
    Spinner sp_country;
    String mLevelScore;
    String []mArrayLevel=new String[20];
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    ImageView iv_dinhnui_summary;
    Boolean doubleBackToExitPressedOnce = false;
    MediaPlayer player;
    MediaPlayer playerBg;
    int lengthMediaBg;

    public LottieAnimationView animation_view_summary;
    LottieAnimationView la_dog_summary;
    LottieAnimationView la_firework_equal;
    LottieAnimationView la_firework_equal_one;
    LottieAnimationView la_firework_equal_one12;
    LottieAnimationView la_firework_monkey;
    LottieAnimationView la_tap_swipe;
    LottieAnimationView la_buy_vip;


    public static String mModeUrlQuestion_Math;

    ImageView iv_backLevel_opera;
    LinearLayout ll_operator;
    ConstraintLayout cl_min_max;
    ImageView iv_check_10;
    ImageView iv_check_20;
    ImageView iv_check_50;
    ImageView iv_check_100;

    ConstraintLayout cl_ingame_opera;
    LinearLayout rl_cloud1;
    ImageView iv_clou1_1;
    ImageView iv_clou1_2;
    ImageView iv_operator;
    LinearLayout rl_cloud2;
    ImageView iv_clou2_1;
    ImageView iv_clou2_2;
    ImageView iv_operator_equal;
    ImageView iv_cloud3;
    LinearLayout ll_result1;
    LinearLayout ll_result2;
    LinearLayout ll_result3;
    TextView tv_level_operator;
    ImageView iv_operator_home;
    RelativeLayout rl_game_over;
    TextView tv_score_zero_gameover;
    ImageView iv_zero_rate;

    RelativeLayout rl_d1;
    ImageView iv_D1_1;
    ImageView iv_D1_2;
    RelativeLayout rl_d2;
    ImageView iv_D2_1;
    ImageView iv_D2_2;
    RelativeLayout rl_d3;
    ImageView iv_D3_1;
    ImageView iv_D3_2;
    ImageView iv_x1;
    ImageView iv_x2;
    ImageView iv_x3;
    LottieAnimationView la_firework_zero;
    ImageView iv_continue_zero;
    TextView iv_zero_score;
    TextView tv_title_operator;
    LottieAnimationView la_sun_grade0;
    ImageView iv_grade_0;
    ImageView iv_grade_0_en;
    ImageView iv_grade_1;
    ImageView iv_grade_2;
    ImageView iv_grade_3;
    ImageView iv_grade_4;
    ImageView iv_grade_5;

    ImageView iv_grade_20;

    ImageView iv_backgrade;
    ImageView iv_backLevel;

    ImageView iv_tap_zero;
    TextView tv_grade_level;
    TextView tv_buy_vip;
    TextView tv_title_vip_item;

    TextView tv_content_buy_vip;
    View v_grade;
    public static int mMemberVip1 = 0;
    public static int mMemberVip2 = 0;
    public static int mMemberVip3 = 0;
    public static int mMemberVip4 = 0;
    public static int mMemberVip5 = 0;

    public static int mMemberVip_Flag = 0;
    public static int mMemberVip_All = 0;
    TextView tv_title_notifi;
    TextView tv_content_notifi;
    ImageView iv_notifi_main;
    public int checkOpenTemplate=0;
    int mZeloOperator;
    int mZeloMax;
    private float xCoOrdinate, yCoOrdinate,xResult, yResult,xCloudD1,yCloudD1,xCloudD2,yCloudD2,xCloudD3,yCloudD3,xCurerent,yCurerent,wResult,hResult;
    int mSelectCloud;
    int mScore_Zero;
    int mLevelZero;
    public static Typeface typeUTM;
    DatabaseReference mDatabase;
    FirebaseRemoteConfig mFirebaseRemoteConfig;
    RelativeLayout rl_link_main;


    ImageView iv_halo_link_main;
    ImageView iv_logo_link_main;
    public Boolean checkOnPause=false;
    String mLinkDataBase;
    TextView tv_Share_Main;
    Calendar calendar;
    LinearLayout ll_item_vip1;
    LinearLayout ll_item_vip2;
    LinearLayout ll_item_vip3;
    LinearLayout ll_item_vip4;
    LinearLayout ll_item_vip5;
    LinearLayout ll_item_vip_flag;
    LinearLayout ll_item_vip_all;

    TextView tv_item_vip1;
    TextView tv_item_vip2;
    TextView tv_item_vip3;
    TextView tv_item_vip4;
    TextView tv_item_vip5;

    TextView tv_item_flag;
    TextView tv_item_vipall;
    ImageView iv_logo_moutain_start;
    ImageView iv_logo_moutain_end;
    TextView tv_zero_add;
    TextView tv_zero_sub;
    TextView tv_zero_mix;


    ImageView iv_xephang_main;

ConstraintLayout cl_profile_king;
TextView tv_name_profile_king;
TextView tv_lop_top;
TextView tv_top_profile_king;
TextView tv_rank_tinh;
TextView tv_rank_huyen;
TextView tv_rank_xa;
TextView tv_rank_school;
TextView tv_score_profile_king;
RecyclerView recyclerUser_king;

RelativeLayout rl_profile_detail;
Spinner sp_tinh;
Spinner sp_huyen;
Spinner sp_xa;
Spinner sp_lop;
EditText et_school;
EditText et_name;




  //  Animation anim_innext;
   // Animation anim_inback;
    //Animation anim_blink;

    public enum Status{MAIN,EQUAL,EQUAL_CLICK_1,EQUAL_CLICK_2,
        GAME_OVER_EQUAL,MONKEY,MONKEY_CLICK,GAME_OVER_MONKEY,
        MOUTAIN,MOUTAIN_SUMIT,GAME_OVER_MOUTAIN,ZERO_LOCK,ZERO_OPEN,MOUTAIN_SELECT,MOUTAIN_SELECT_LOCK,LOAD_TEMP};
    public static Status currentStatus=Status.MAIN;
    public static Handler handler = new Handler();
    public  float mWidthDesktop;
    public static   Boolean mISO1;
    TextView tv_content_start_equal;
    TextView tv_title_start_equal;
TextView tv_conten_moutain;

TextView tv_Feed_Back;

ImageView iv_vip_love;

TextView tv_lienhe_list_vip;
    private ConsentInformation consentInformation;
    FirebaseAnalytics mFirebaseAnalytics;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        setContentView(R.layout.activity_main);

        viewFlipperMath = (ViewFlipper) findViewById(R.id.viewFliper);
        gv_level = (GridView) findViewById(R.id.gv_level);
        tv_grade_level = (TextView) findViewById(R.id.tv_grade_level);
        tv_score_summary = (TextView) findViewById(R.id.tv_score_summary);
        tv_status_summary = (TextView) findViewById(R.id.tv_status_summary);
        iv_star_summary = (ImageView) findViewById(R.id.iv_star_summary);
        tv_main_start = (TextView) findViewById(R.id.tv_main_start);

        iv_dinhnui_summary = (ImageView) findViewById(R.id.iv_dinhnui_summary);



        gv_equal = (GridView) findViewById(R.id.gv_equal);
        tv_score_equal = (TextView) findViewById(R.id.tv_score_equal);

        tv_time_ingame_equal = (TextView) findViewById(R.id.tv_time_ingame_equal);

        gv_equal_one = (GridView) findViewById(R.id.gv_equal_one);
        tv_score_equal_one = (TextView) findViewById(R.id.tv_score_equal_one);
        iv_avata_equal_one = (ImageView) findViewById(R.id.iv_avata_equal_one);
        tv_time_ingame_equal_one = (TextView) findViewById(R.id.tv_time_ingame_equal_one);
        iv_false_equal_one = (ImageView) findViewById(R.id.iv_false_equal_one);

        gv_equal_one_12 = (GridView) findViewById(R.id.gv_equal_one_12);
        tv_score_equal_one_12 = (TextView) findViewById(R.id.tv_score_equal_one_12);
        iv_avata_equal_one_12 = (ImageView) findViewById(R.id.iv_avata_equal_one_12);
        tv_time_ingame_equal_one_12 = (TextView) findViewById(R.id.tv_time_ingame_equal_one_12);
        iv_false_equal_one_12 = (ImageView) findViewById(R.id.iv_false_equal_one_12);

        iv_false_equal = (ImageView) findViewById(R.id.iv_false_equal);
        tv_score_equal_gameover = (TextView) findViewById(R.id.tv_score_equal_gameover);
        iv_flase_equal_gameover = (ImageView) findViewById(R.id.iv_flase_equal_gameover);

        tv_title_gameover_equal=(TextView)findViewById(R.id.tv_title_gameover_equal);
        rd = new Random();

        iv_avata_monkey = (ImageView) findViewById(R.id.iv_avata_monkey);
        viewpagerMonkey = (ViewPager) findViewById(R.id.viewpagerMonKey);
        rl_monkey_avata_pheptoan_bg = (RelativeLayout) findViewById(R.id.rl_monkey_avata_pheptoan_bg);
        iv_monkey_avata_pheptoan_bg = (ImageView) findViewById(R.id.iv_monkey_avata_pheptoan_bg);
        tv_monkey_avata_pheptoan = (TextView) findViewById(R.id.tv_monkey_avata_pheptoan);
        tv_monkey_avata_phantram_ps = (TextView) findViewById(R.id.tv_monkey_avata_phantram_ps);
        tv_monkey_avata_tuso_phantram = (TextView) findViewById(R.id.tv_monkey_avata_tuso_phantram);
        tv_monkey_avata_mauso_phantram = (TextView) findViewById(R.id.tv_monkey_avata_mauso_phantram);
        tv_monkey_avata_cua_ps1 = (TextView) findViewById(R.id.tv_monkey_avata_cua_ps1);
        tv_monkey_avata_tuso_cua1 = (TextView) findViewById(R.id.tv_monkey_avata_tuso_cua1);
        tv_monkey_avata_mauso_cua1 = (TextView) findViewById(R.id.tv_monkey_avata_mauso_cua1);
        tv_monkey_avata_tuso_cua2 = (TextView) findViewById(R.id.tv_monkey_avata_tuso_cua2);
        tv_monkey_avata_mauso_cua2 = (TextView) findViewById(R.id.tv_monkey_avata_mauso_cua2);

        tv_monkey_avata_pheptoan_hs = (TextView) findViewById(R.id.tv_monkey_avata_pheptoan_hs);
        tv_monkey_avata_hs1 = (TextView) findViewById(R.id.tv_monkey_avata_hs1);
        tv_monkey_avata_tuso_hs1 = (TextView) findViewById(R.id.tv_monkey_avata_tuso_hs1);
        tv_monkey_avata_mauso_hs1 = (TextView) findViewById(R.id.tv_monkey_avata_mauso_hs1);
        tv_monkey_avata_hs2 = (TextView) findViewById(R.id.tv_monkey_avata_hs2);
        tv_monkey_avata_tuso_hs2 = (TextView) findViewById(R.id.tv_monkey_avata_tuso_hs2);
        tv_monkey_avata_mauso_hs2 = (TextView) findViewById(R.id.tv_monkey_avata_mauso_hs2);
        tv_monkey_avata_cua_ps2 = (TextView) findViewById(R.id.tv_monkey_avata_cua_ps2);
        tv_monkey_avata_tuso_cua3 = (TextView) findViewById(R.id.tv_monkey_avata_tuso_cua3);
        tv_monkey_avata_mauso_cua3 = (TextView) findViewById(R.id.tv_monkey_avata_mauso_cua3);
        tv_score_monkey = (TextView) findViewById(R.id.tv_score_monkey);
        tv_time_ingame_monkey = (TextView) findViewById(R.id.tv_time_ingame_monkey);
        iv_false_monkey = (ImageView) findViewById(R.id.iv_false_monkey);
        tv_score_monkey_gameover = (TextView) findViewById(R.id.tv_score_monkey_gameover);
        iv_flase_monkey_gameover = (ImageView) findViewById(R.id.iv_flase_monkey_gameover);

        iv_avata_moutain0 = (ImageView) findViewById(R.id.iv_avata_moutain0);
        iv_avata_moutain1 = (ImageView) findViewById(R.id.iv_avata_moutain1);
        iv_avata_moutain2 = (ImageView) findViewById(R.id.iv_avata_moutain2);
        iv_avata_moutain3 = (ImageView) findViewById(R.id.iv_avata_moutain3);
        iv_avata_moutain4 = (ImageView) findViewById(R.id.iv_avata_moutain4);
        iv_avata_moutain5 = (ImageView) findViewById(R.id.iv_avata_moutain5);
        iv_avata_moutain6 = (ImageView) findViewById(R.id.iv_avata_moutain6);
        iv_avata_moutain7 = (ImageView) findViewById(R.id.iv_avata_moutain7);
        iv_avata_moutain8 = (ImageView) findViewById(R.id.iv_avata_moutain8);
        iv_avata_moutain9 = (ImageView) findViewById(R.id.iv_avata_moutain9);
        iv_avata_moutain10 = (ImageView) findViewById(R.id.iv_avata_moutain10);
        iv_monkey_moutain = (ImageView) findViewById(R.id.iv_monkey_moutain);
        iv_sumit_moutain = (ImageView) findViewById(R.id.iv_sumit_moutain);

        tv_result_moutain = (TextView) findViewById(R.id.tv_result_moutain);
        tv_question_moutain = (TextView) findViewById(R.id.tv_question_moutain);
        rl_question_moutain = (RelativeLayout) findViewById(R.id.rl_question_moutain);
        ll_number_moutain = (LinearLayout) findViewById(R.id.ll_number_moutain);

        iv_false_moutain = (ImageView) findViewById(R.id.iv_false_moutain);
        tv_score_moutain = (TextView) findViewById(R.id.tv_score_moutain);
        tv_time_ingame_moutain = (TextView) findViewById(R.id.tv_time_ingame_moutain);
        iv_continue_moutain = (ImageView) findViewById(R.id.iv_continue_moutain);
        tv_report = (TextView) findViewById(R.id.tv_report);
        tv_score_moutain_gameover = (TextView) findViewById(R.id.tv_score_moutain_gameover);
        iv_flase_moutain_gameover = (ImageView) findViewById(R.id.iv_flase_moutain_gameover);
        tv_A=(TextView) findViewById(R.id.tv_A);
        tv_B=(TextView) findViewById(R.id.tv_B);
        tv_C=(TextView) findViewById(R.id.tv_C);
        tv_D=(TextView) findViewById(R.id.tv_D);

        iv_main_buyvip = (ImageView) findViewById(R.id.iv_main_buyvip);
        tv_buy_vip = (TextView) findViewById(R.id.tv_buy_vip);


        iv_logo_monkey = (ImageView) findViewById(R.id.iv_logo_monkey);

        iv_logo_monkey_gameover = (ImageView) findViewById(R.id.iv_logo_monkey_gameover);

        sp_country=(Spinner)findViewById(R.id.sp_country);


        animation_view_summary = (LottieAnimationView) findViewById(R.id.animation_view_summary);
        la_dog_summary = (LottieAnimationView) findViewById(R.id.la_dog_summary);
        la_firework_equal = (LottieAnimationView) findViewById(R.id.la_firework_equal);
        la_firework_equal_one = (LottieAnimationView) findViewById(R.id.la_firework_equal_one);
        la_firework_equal_one12 = (LottieAnimationView) findViewById(R.id.la_firework_equal_one12);
        la_firework_monkey = (LottieAnimationView) findViewById(R.id.la_firework_monkey);
        la_sun_grade0 = (LottieAnimationView) findViewById(R.id.la_sun_grade0);
        iv_grade_0 = (ImageView) findViewById(R.id.iv_grade_0);
        iv_grade_0_en= (ImageView) findViewById(R.id.iv_grade_0_en);
        iv_grade_1 = (ImageView) findViewById(R.id.iv_grade_1);
        iv_grade_2 = (ImageView) findViewById(R.id.iv_grade_2);
        iv_grade_3 = (ImageView) findViewById(R.id.iv_grade_3);
        iv_grade_4 = (ImageView) findViewById(R.id.iv_grade_4);
        iv_grade_5 = (ImageView) findViewById(R.id.iv_grade_5);
        iv_grade_20=(ImageView) findViewById(R.id.iv_grade_20);
        iv_backgrade= (ImageView) findViewById(R.id.iv_backgrade);
        iv_backLevel= (ImageView) findViewById(R.id.iv_backLevel);

        la_tap_swipe = (LottieAnimationView) findViewById(R.id.la_tap_swipe);
        la_buy_vip = (LottieAnimationView) findViewById(R.id.la_buy_vip);

        iv_backLevel_opera = (ImageView) findViewById(R.id.iv_backLevel_opera);
        ll_operator = (LinearLayout) findViewById(R.id.ll_operator);
        cl_min_max = (ConstraintLayout) findViewById(R.id.cl_min_max);
        iv_check_10 = (ImageView) findViewById(R.id.iv_check_10);
        iv_check_20 = (ImageView) findViewById(R.id.iv_check_20);
        iv_check_50 = (ImageView) findViewById(R.id.iv_check_50);
        iv_check_100 = (ImageView) findViewById(R.id.iv_check_100);

        cl_ingame_opera = (ConstraintLayout) findViewById(R.id.cl_ingame_opera);
        rl_cloud1 = (LinearLayout) findViewById(R.id.rl_cloud1);
        iv_clou1_1 = (ImageView) findViewById(R.id.iv_clou1_1);
        iv_clou1_2 = (ImageView) findViewById(R.id.iv_clou1_2);
        iv_operator = (ImageView) findViewById(R.id.iv_operator);
        rl_cloud2 = (LinearLayout) findViewById(R.id.rl_cloud2);
        iv_clou2_1 = (ImageView) findViewById(R.id.iv_clou2_1);
        iv_clou2_2 = (ImageView) findViewById(R.id.iv_clou2_2);
        iv_operator_equal = (ImageView) findViewById(R.id.iv_operator_equal);
        iv_cloud3 = (ImageView) findViewById(R.id.iv_cloud3);
        tv_level_operator = (TextView) findViewById(R.id.tv_level_operator);
        iv_operator_home = (ImageView) findViewById(R.id.iv_operator_home);
        rl_game_over = (RelativeLayout) findViewById(R.id.rl_game_over);
        tv_score_zero_gameover = (TextView) findViewById(R.id.tv_score_zero_gameover);
        iv_zero_rate = (ImageView) findViewById(R.id.iv_zero_rate);
        tv_title_operator = (TextView) findViewById(R.id.tv_title_operator);

        rl_d1 = (RelativeLayout) findViewById(R.id.rl_d1);
        iv_D1_1 = (ImageView) findViewById(R.id.iv_D1_1);
        iv_D1_2 = (ImageView) findViewById(R.id.iv_D1_2);
        rl_d2 = (RelativeLayout) findViewById(R.id.rl_d2);
        iv_D2_1 = (ImageView) findViewById(R.id.iv_D2_1);
        iv_D2_2 = (ImageView) findViewById(R.id.iv_D2_2);
        rl_d3 = (RelativeLayout) findViewById(R.id.rl_d3);
        iv_D3_1 = (ImageView) findViewById(R.id.iv_D3_1);
        iv_D3_2 = (ImageView) findViewById(R.id.iv_D3_2);
        iv_tap_zero = (ImageView) findViewById(R.id.iv_tap_zero);

        rl_link_main = (RelativeLayout) findViewById(R.id.rl_link_main);

        iv_halo_link_main = (ImageView) findViewById(R.id.iv_halo_link_main);
        iv_logo_link_main = (ImageView) findViewById(R.id.iv_logo_link_main);
        tv_title_vip_item = (TextView) findViewById(R.id.tv_title_vip_item);
        tv_content_buy_vip = (TextView) findViewById(R.id.tv_content_buy_vip);

         iv_vip_love= (ImageView) findViewById(R.id.iv_vip_love);

         tv_lienhe_list_vip= (TextView) findViewById(R.id.tv_lienhe_list_vip);

        iv_x1 = (ImageView) findViewById(R.id.iv_x1);
        iv_x2 = (ImageView) findViewById(R.id.iv_x2);
        iv_x3 = (ImageView) findViewById(R.id.iv_x3);
        la_firework_zero = (LottieAnimationView) findViewById(R.id.la_firework_zero);
        iv_continue_zero = (ImageView) findViewById(R.id.iv_continue_zero);
        iv_zero_score = (TextView) findViewById(R.id.iv_zero_score);
        iv_star1 = (ImageView) findViewById(R.id.iv_star1);
        iv_star2 = (ImageView) findViewById(R.id.iv_star2);
        iv_star3 = (ImageView) findViewById(R.id.iv_star3);
        ll_star_zero = (LinearLayout) findViewById(R.id.ll_star_zero);
        tv_Share_Main = (TextView) findViewById(R.id.tv_Share_Main);
        tv_Feed_Back=(TextView)findViewById(R.id.tv_Feed_Back);

        ll_item_vip1=(LinearLayout) findViewById(R.id.ll_item_vip1);
        ll_item_vip2=(LinearLayout) findViewById(R.id.ll_item_vip2);
        ll_item_vip3=(LinearLayout) findViewById(R.id.ll_item_vip3);
        ll_item_vip4=(LinearLayout) findViewById(R.id.ll_item_vip4);
        ll_item_vip5=(LinearLayout) findViewById(R.id.ll_item_vip5);
        ll_item_vip_flag=(LinearLayout)findViewById(R.id.ll_item_vip_flag);
        ll_item_vip_all=(LinearLayout) findViewById(R.id.ll_item_vip_all);

         tv_item_vip1=(TextView)findViewById(R.id.tv_item_vip1);
        tv_item_vip2=(TextView)findViewById(R.id.tv_item_vip2);
        tv_item_vip3=(TextView)findViewById(R.id.tv_item_vip3);
        tv_item_vip4=(TextView)findViewById(R.id.tv_item_vip4);
        tv_item_vip5=(TextView)findViewById(R.id.tv_item_vip5);
        tv_item_flag=(TextView)findViewById(R.id.tv_item_flag);
        tv_item_vipall=(TextView)findViewById(R.id.tv_item_vipall);

        tv_content_start_equal=(TextView) findViewById(R.id.tv_content_start_equal);
        tv_title_start_equal=(TextView) findViewById(R.id.tv_title_start_equal);

        tv_conten_moutain=(TextView)findViewById(R.id.tv_conten_moutain);
        iv_logo_moutain_start=(ImageView)findViewById(R.id.iv_logo_moutain_start);
        iv_logo_moutain_end=(ImageView)findViewById(R.id.iv_logo_moutain_end);
        ll_result1=(LinearLayout) findViewById(R.id.ll_result1);
        ll_result2=(LinearLayout) findViewById(R.id.ll_result2);
        ll_result3=(LinearLayout) findViewById(R.id.ll_result3);

         tv_zero_add=(TextView)findViewById(R.id.tv_zero_add);
         tv_zero_sub=(TextView)findViewById(R.id.tv_zero_sub);
         tv_zero_mix=(TextView)findViewById(R.id.tv_zero_mix);

        iv_xephang_main=(ImageView)findViewById(R.id.iv_xephang_main);
         cl_profile_king=(ConstraintLayout)findViewById(R.id.cl_profile_king);
         tv_name_profile_king=(TextView)findViewById(R.id.tv_name_profile_king);
         tv_lop_top=(TextView)findViewById(R.id.tv_lop_top);
         tv_top_profile_king=(TextView)findViewById(R.id.tv_top_profile_king);
         tv_rank_tinh=(TextView)findViewById(R.id.tv_rank_tinh);
         tv_rank_huyen=(TextView)findViewById(R.id.tv_rank_huyen);
         tv_rank_xa=(TextView)findViewById(R.id.tv_rank_xa);
         tv_rank_school=(TextView)findViewById(R.id.tv_rank_school);
         tv_score_profile_king=(TextView)findViewById(R.id.tv_score_profile_king);
         recyclerUser_king=(RecyclerView)findViewById(R.id.recyclerUser_king);

         rl_profile_detail=(RelativeLayout)findViewById(R.id.rl_profile_detail);
         sp_tinh=(Spinner)findViewById(R.id.sp_tinh);
         sp_huyen=(Spinner)findViewById(R.id.sp_huyen);
         sp_xa=(Spinner)findViewById(R.id.sp_xa);
         sp_lop=(Spinner)findViewById(R.id.sp_lop);
         et_school=(EditText)findViewById(R.id.et_school);
         et_name=(EditText)findViewById(R.id.et_name);

        pref = getApplicationContext().getSharedPreferences("lop1", 0);// 0 - là chế độ private
        editor = pref.edit();
        mModeUrlQuestion_Math = pref.getString("modeurl", "");
        mRateApp = pref.getInt("rateapp", 0);
        mLinkAvata = pref.getString("link", "");
        mMemberVip1 = pref.getInt("vips", 0);
        mMemberVip2 = pref.getInt("vips2", 0);
        mMemberVip3 = pref.getInt("vips3", 0);
        mMemberVip4 = pref.getInt("vips4", 0);
        mMemberVip5 = pref.getInt("vips5", 0);
        mMemberVip_Flag= pref.getInt("vipsflag", 0);
        mMemberVip_All = pref.getInt("vipsall", 0);

        DeviceLang=pref.getString("device_lang", "");

        xCloudD1 = 0;
        yCloudD1 = 0;
        xCloudD2 = 0;
        yCloudD2 = 0;
        xCloudD3 = 0;
        yCloudD3 = 0;
        rl_d1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getActionMasked()) {
                    case MotionEvent.ACTION_DOWN:
                        if (currentStatus == Status.ZERO_OPEN && Integer.parseInt(v.getTag().toString()) >= 0) {
                            mSelectCloud = 1;
                            xCoOrdinate = v.getX() - event.getRawX();
                            yCoOrdinate = v.getY() - event.getRawY();
                            xResult = iv_cloud3.getX();
                            yResult = iv_cloud3.getY();
                            if (xCloudD1 == 0 && yCloudD1 == 0 && xCloudD2 == 0 && yCloudD2 == 0 && xCloudD3 == 0 && yCloudD3 == 0) {
                                xCloudD1 = rl_d1.getX();
                                yCloudD1 = rl_d1.getY();
                                xCloudD2 = rl_d2.getX();
                                yCloudD2 = rl_d2.getY();
                                xCloudD3 = rl_d3.getX();
                                yCloudD3 = rl_d3.getY();
                            }
                            wResult = iv_cloud3.getWidth();
                            hResult = iv_cloud3.getHeight();
                        }
                        break;
                    case MotionEvent.ACTION_MOVE:
                        if (Integer.parseInt(v.getTag().toString()) >= 0) {
                            v.animate().x(event.getRawX() + xCoOrdinate).y(event.getRawY() + yCoOrdinate).setDuration(0).start();
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        if (currentStatus == Status.ZERO_OPEN && Integer.parseInt(v.getTag().toString()) >= 0) {
                            // tv_redady.setText(xX+" k:"+yY);
                            xCurerent = v.getX();
                            yCurerent = v.getY();
                            mSelectCloud = 1;
                            doHandlerProcessZero();
                        }
                        break;
                    default:
                        return false;
                }
                return true;
            }
        });
        rl_d2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getActionMasked()) {
                    case MotionEvent.ACTION_DOWN:
                        if (currentStatus == Status.ZERO_OPEN && Integer.parseInt(v.getTag().toString()) >= 0) {
                            mSelectCloud = 2;
                            xCoOrdinate = v.getX() - event.getRawX();
                            yCoOrdinate = v.getY() - event.getRawY();
                            xResult = iv_cloud3.getX();
                            yResult = iv_cloud3.getY();
                            if (xCloudD1 == 0 && yCloudD1 == 0 && xCloudD2 == 0 && yCloudD2 == 0 && xCloudD3 == 0 && yCloudD3 == 0) {
                                xCloudD1 = rl_d1.getX();
                                yCloudD1 = rl_d1.getY();
                                xCloudD2 = rl_d2.getX();
                                yCloudD2 = rl_d2.getY();
                                xCloudD3 = rl_d3.getX();
                                yCloudD3 = rl_d3.getY();
                            }
                            wResult = iv_cloud3.getWidth();
                            hResult = iv_cloud3.getHeight();
                        }
                        break;
                    case MotionEvent.ACTION_MOVE:
                        if (currentStatus == Status.ZERO_OPEN && Integer.parseInt(v.getTag().toString()) >= 0) {
                            v.animate().x(event.getRawX() + xCoOrdinate).y(event.getRawY() + yCoOrdinate).setDuration(0).start();
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        if (currentStatus == Status.ZERO_OPEN && Integer.parseInt(v.getTag().toString()) >= 0) {
                            // tv_redady.setText(xX+" k:"+yY);

                            xCurerent = v.getX();
                            yCurerent = v.getY();
                            mSelectCloud = 2;
                            doHandlerProcessZero();
                        }
                        break;
                    default:
                        return false;
                }
                return true;
            }
        });
        rl_d3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getActionMasked()) {
                    case MotionEvent.ACTION_DOWN:
                        if (currentStatus == Status.ZERO_OPEN && Integer.parseInt(v.getTag().toString()) >= 0) {
                            mSelectCloud = 3;
                            xCoOrdinate = v.getX() - event.getRawX();
                            yCoOrdinate = v.getY() - event.getRawY();
                            xResult = iv_cloud3.getX();
                            yResult = iv_cloud3.getY();
                            if (xCloudD1 == 0 && yCloudD1 == 0 && xCloudD2 == 0 && yCloudD2 == 0 && xCloudD3 == 0 && yCloudD3 == 0) {
                                xCloudD1 = rl_d1.getX();
                                yCloudD1 = rl_d1.getY();
                                xCloudD2 = rl_d2.getX();
                                yCloudD2 = rl_d2.getY();
                                xCloudD3 = rl_d3.getX();
                                yCloudD3 = rl_d3.getY();
                            }
                            wResult = iv_cloud3.getWidth();
                            hResult = iv_cloud3.getHeight();
                        }
                        break;
                    case MotionEvent.ACTION_MOVE:
                        if (currentStatus == Status.ZERO_OPEN && Integer.parseInt(v.getTag().toString()) >= 0) {
                            v.animate().x(event.getRawX() + xCoOrdinate).y(event.getRawY() + yCoOrdinate).setDuration(0).start();
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        if (currentStatus == Status.ZERO_OPEN && Integer.parseInt(v.getTag().toString()) >= 0) {
                            // tv_redady.setText(xX+" k:"+yY);

                            xCurerent = v.getX();
                            yCurerent = v.getY();
                            mSelectCloud = 3;
                            doHandlerProcessZero();
                        }
                        break;
                    default:
                        return false;
                }
                return true;
            }
        });


       // anim_innext=AnimationUtils.loadAnimation(getApplicationContext(), R.anim.innext);
       // anim_inback=AnimationUtils.loadAnimation(getApplicationContext(), R.anim.inback);

       // anim_blink=AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);

       // anim_blink_max = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink_max);
        anim_tbequal = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shake_equal);
        anim_tbequal.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                try {

                    iv_avata_equal_one.setImageResource(R.drawable.monkey_question);
                    iv_avata_equal_one_12.setImageResource(R.drawable.monkey_question);
                    iv_avata_monkey.setImageResource(R.drawable.khihoi);
                    iv_monkey_moutain.setImageResource(R.drawable.monkey_question);
                } catch (Exception e) {

                }

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        anim_tbmonkey = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shake_monkey);
        anim_tbmonkey.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                try {
                    iv_avata_monkey.setImageResource(R.drawable.khihoi);
                    iv_monkey_moutain.setImageResource(R.drawable.monkey_question);
                } catch (Exception e) {

                }

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
       // aniZoom = AnimationUtils.loadAnimation(MainActivity.this, R.anim.scala_animation);
       // aniZoomQuestion = AnimationUtils.loadAnimation(MainActivity.this, R.anim.scala_animation_question);

        //aniMoveTapZero = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move);
       // aniMoveCloud = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move_cloud);
        tv_main_start.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move_cloud));
        aninOut_Up_Main = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.out_up_main);
        aninOut_Up_Main.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                tv_main_start.clearAnimation();
                viewFlipperMath.setDisplayedChild(1);
                tv_main_start.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move_cloud));
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        aninShake_Main = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shake_main);
        aninShake_Main.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                tv_main_start.clearAnimation();
                tv_main_start.startAnimation(aninOut_Up_Main);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        aninShake_Grade = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shake_grade);
        aninShake_Grade.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                v_grade.clearAnimation();
                viewFlipperMath.setDisplayedChild(2);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        //aninGitbox = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shake_gitbox);
        aniOut_Up = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.out_up);
        aniOut_Up.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                iv_star1.setVisibility(View.GONE);
                iv_star2.setVisibility(View.GONE);
                iv_star3.setVisibility(View.GONE);

                iv_star1.clearAnimation();
                iv_star2.clearAnimation();
                iv_star3.clearAnimation();
                ll_star_zero.clearAnimation();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


       // aniZoom_Plus = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoomplus);
        aniZoom_Subs = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoomsubs);
      //  aniIn_Up = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.in_up);
        aniZoom_Subs.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {


                rl_d1.setX(xCloudD1);
                rl_d1.setY(yCloudD1);

                rl_d2.setX(xCloudD2);
                rl_d2.setY(yCloudD2);

                rl_d3.setX(xCloudD3);
                rl_d3.setY(yCloudD3);

                if (mLevelZero > 15) {
                    rl_d1.setVisibility(View.GONE);
                    rl_d2.setVisibility(View.GONE);
                    rl_d3.setVisibility(View.GONE);
                    rl_cloud1.setVisibility(View.GONE);
                    iv_operator.setVisibility(View.GONE);
                    rl_cloud2.setVisibility(View.GONE);
                    iv_operator_equal.setVisibility(View.GONE);
                    iv_cloud3.setVisibility(View.GONE);
                    iv_x1.setVisibility(View.GONE);
                    iv_x2.setVisibility(View.GONE);
                    iv_x3.setVisibility(View.GONE);
                    iv_continue_zero.setVisibility(View.GONE);
                    iv_continue_zero.setVisibility(View.GONE);

                    rl_game_over.setVisibility(View.VISIBLE);
                    rl_game_over.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoomplus));

                    if(DeviceLang.equals("vi_vn"))
                    {
                        tv_score_zero_gameover.setText("Điểm:" + mScore_Zero);
                    }else  if(DeviceLang.equals("fr"))
                    {
                        tv_score_zero_gameover.setText("Score:" + mScore_Zero);
                    }
                    else  if(DeviceLang.equals("de"))
                    {
                        tv_score_zero_gameover.setText("Punktzahl:" + mScore_Zero);
                    }
                    else
                    {
                        tv_score_zero_gameover.setText("Score:" + mScore_Zero);
                    }

                    try {
                        if (mScore_Zero > 144) {
                            iv_zero_rate.setImageResource(R.drawable.basao);
                        } else if (mScore_Zero > 138) {
                            iv_zero_rate.setImageResource(R.drawable.haisao);
                        } else {
                            iv_zero_rate.setImageResource(R.drawable.motsao);
                        }
                    } catch (Exception e) {

                    }
                    clsHandleT.doPlaySoundAssets("win.mp3", "", player, false, MainActivity.this);
                    if (((int) mFirebaseRemoteConfig.getValue("b_ads_inapp_zero").asDouble()) != 0
                            &&mMemberVip1==0
                            &&mMemberVip2==0
                            &&mMemberVip3==0
                            &&mMemberVip4==0
                            &&mMemberVip5==0
                            &&mMemberVip_Flag==0
                            &&mMemberVip_All==0) {
                        if (rd.nextInt(((int) mFirebaseRemoteConfig.getValue("b_ads_inapp_zero").asDouble())) == 0) {
                            AdmobManager.doShowInterstitialAd(MainActivity.this);
                        }
                    }

                } else {
                    tv_level_operator.setText(mLevelZero + "/" + 15);
                    doSuggetZero();
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
      //  aninShake = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shake);
        typeUTM = Typeface.createFromAsset(getAssets(), "UTMCooper.ttf");


        player = new MediaPlayer();
        playerBg = new MediaPlayer();


        DeviceLang_Root=Locale.getDefault().toString().toLowerCase();
       // clsHandleT.Loge("delang:"+DeviceLang_Root);
        if(DeviceLang.equals("")) {
            DeviceLang = Locale.getDefault().toString().toLowerCase();
            if(DeviceLang.startsWith("fr_"))
            {
                DeviceLang="fr";
            }

            if(DeviceLang.startsWith("de_"))
            {
                DeviceLang="de";
            }

            if((DeviceLang.equals("vi_vn")==false)&&(DeviceLang.equals("fr")==false)&&(DeviceLang.equals("de")==false))
            {
                DeviceLang="en";
            }
            editor.putString("device_lang", DeviceLang);
            editor.commit();

        }

        mDatabase = FirebaseDatabase.getInstance("https://vioedu-toan-lop-1-default-rtdb.firebaseio.com").getReference();
        mFirebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
        FirebaseRemoteConfigSettings configSettings = new FirebaseRemoteConfigSettings.Builder()
                .setMinimumFetchIntervalInSeconds(3600)
                .build();
        mFirebaseRemoteConfig.setConfigSettingsAsync(configSettings);
        mFirebaseRemoteConfig.setDefaultsAsync(R.xml.remote_config_defaults);
        mFirebaseRemoteConfig.fetchAndActivate()
                .addOnCompleteListener(this, new OnCompleteListener<Boolean>() {
                    @Override
                    public void onComplete(@NonNull Task<Boolean> task) {
                        if (task.isSuccessful()) {
                            boolean updated = task.getResult();

                            if (DeviceLang.equals("vi_vn"))
                            {

                                tv_content_buy_vip.setText(mFirebaseRemoteConfig.getString("inapp_content_vn").replace("\\n", "\n"));
                            }
                            else if (DeviceLang.equals("fr"))
                            {
                                tv_content_buy_vip.setText(mFirebaseRemoteConfig.getString("inapp_content_fr").replace("\\n", "\n"));
                            }
                            else if (DeviceLang.equals("de"))
                            {
                                tv_content_buy_vip.setText(mFirebaseRemoteConfig.getString("inapp_content_de").replace("\\n", "\n"));
                            }
                            else
                            {
                                tv_content_buy_vip.setText(mFirebaseRemoteConfig.getString("inapp_content_en").replace("\\n", "\n"));
                            }
                        } else {

                        }
                        // displayWelcomeMessage();
                    }
                });
        if (((int) mFirebaseRemoteConfig.getValue("b_vs_logo_link").asDouble()) != pref.getInt("vslogolink", 0)) {
            doDowloadLinkAvata();
            editor.putInt("vslogolink", ((int) mFirebaseRemoteConfig.getValue("b_vs_logo_link").asDouble()));
            editor.commit();
        }
//         Db("type:"+((int) mFirebaseRemoteConfig.getValue("link_type").asDouble()));
//        Db("DIV:"+DeviceLang);
//        Db("title:"+mFirebaseRemoteConfig.getString("link_title"));
//        Db("domai:"+mFirebaseRemoteConfig.getString("domain_key"));
//        Db("alow_inapp:"+ ((int) mFirebaseRemoteConfig.getValue("alow_inapp").asDouble()));

        if (((int) mFirebaseRemoteConfig.getValue("link_type").asDouble()) > 0 && DeviceLang.equals("vi_vn")) {
            try {
                rl_link_main.setVisibility(View.VISIBLE);
                tv_Share_Main.setVisibility(View.VISIBLE);
                tv_Feed_Back.setVisibility(View.VISIBLE);
                if (!mLinkAvata.equals("")) {


                    clsHandleT.RotateImage(iv_halo_link_main, 15000);

                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            Bitmap myBitmap = BitmapFactory.decodeFile(mLinkAvata);
                            iv_logo_link_main.post(new Runnable() {
                                @Override
                                public void run() {
                                    iv_logo_link_main.setImageBitmap(myBitmap);
                                }
                            });
                        }
                    }).start();

                } else {
                    iv_logo_link_main.setImageResource(R.drawable.avata2);
                }
            } catch (Exception exception) {
                rl_link_main.setVisibility(View.GONE);
                tv_Share_Main.setVisibility(View.GONE);
                tv_Feed_Back.setVisibility(View.GONE);

            }
        } else {
            rl_link_main.setVisibility(View.GONE);
            tv_Share_Main.setVisibility(View.GONE);
            tv_Feed_Back.setVisibility(View.GONE);
        }


        if(DeviceLang.equals("vi_vn"))
        {
            spinnerTitlesContry = new String[]{"Tiếng Việt","English","France","Deutsch"};
        }else  if(DeviceLang.equals("de"))
        {
            spinnerTitlesContry = new String[]{"Deutsch","English","Tiếng Việt","France"};
        }
        else  if(DeviceLang.equals("fr"))
        {
            spinnerTitlesContry = new String[]{"France","English","Tiếng Việt","Deutsch"};
        }
        else
        {
            spinnerTitlesContry = new String[]{"English","Tiếng Việt","France","Deutsch"};
        }
        countryAdapter=new CountryAdapter(this,spinnerTitlesContry);
        sp_country.setAdapter(countryAdapter);
        sp_country.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if(spinnerTitlesContry[i].equals("Tiếng Việt"))
                {
                    DeviceLang="vi_vn";

                }else if(spinnerTitlesContry[i].equals("France"))
                {
                    DeviceLang="fr";
                    doSetGrade_FR();
                }else if(spinnerTitlesContry[i].equals("Deutsch"))
                {
                    DeviceLang="de";
                }
                else
                {
                    DeviceLang="en";
                }

                editor.putString("device_lang", DeviceLang);
                editor.commit();

                setMutilang();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        setMutilang();

        if(((int) mFirebaseRemoteConfig.getValue("alow_lienhe_list").asDouble()) == 1&&DeviceLang.equals("vi_vn")) {
            tv_lienhe_list_vip.setText(mFirebaseRemoteConfig.getString("lien_he_zalo"));
        }else
        {
            tv_lienhe_list_vip.setText("");
        }

        if(((int) mFirebaseRemoteConfig.getValue("alow_award_love").asDouble()) == 1&&DeviceLang_Root.equals("vi_vn")) {
            iv_vip_love.setVisibility(View.VISIBLE);
        }

        if(((int) mFirebaseRemoteConfig.getValue("alow_rank").asDouble()) == 1&&DeviceLang_Root.equals("vi_vn")) {
            iv_xephang_main.setVisibility(View.VISIBLE);
        }


        try {
            cl_profile_king.setBackgroundColor(Color.parseColor(mFirebaseRemoteConfig.getString("bg_profile_color")));
        }catch (Exception e)
        {

        }

        createNotificationChannel("toancap1");
        calendar = Calendar.getInstance();
        if (pref.getInt("notifiday", 0) != calendar.get(Calendar.DAY_OF_MONTH)) {

            editor.putInt("notifiday", calendar.get(Calendar.DAY_OF_MONTH));
            editor.commit();

            doNotifiHenGio();
        }
        // Create a ConsentRequestParameters object.
        ConsentRequestParameters params = new ConsentRequestParameters
                .Builder()
                .build();

        consentInformation = UserMessagingPlatform.getConsentInformation(this);
        consentInformation.requestConsentInfoUpdate(
                this,
                params,
                (ConsentInformation.OnConsentInfoUpdateSuccessListener) () -> {
                    // TODO: Load and show the consent form.
                    UserMessagingPlatform.loadAndShowConsentFormIfRequired(
                            this,
                            (ConsentForm.OnConsentFormDismissedListener) loadAndShowError -> {
                                if (loadAndShowError != null) {
                                    // Consent gathering failed.
                                    Log.e("kkkkk", String.format("%s: %s",
                                            loadAndShowError.getErrorCode(),
                                            loadAndShowError.getMessage()));
                                }

                                // Consent has been gathered.
                                if (consentInformation.canRequestAds()) {
                                    AdmobManager.doInitialize(MainActivity.this);
                                }
                            }
                    );
                },
                (ConsentInformation.OnConsentInfoUpdateFailureListener) requestConsentError -> {
                    // Consent gathering failed.
                    Log.e("kkkkk", String.format("%s: %s",
                            requestConsentError.getErrorCode(),
                            requestConsentError.getMessage()));
                });

        //clsHandleT.Loge("mm:"+((int) mFirebaseRemoteConfig.getValue("altp_open").asDouble()));


        mWidthDesktop=getSizeDesktopWith();
        mISO1=getIOS1();
        if(mISO1==false)
        {

            iv_avata_equal_one.setVisibility(View.GONE);
            iv_avata_equal_one_12.setVisibility(View.GONE);
            tv_content_start_equal.setWidth((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 310, getResources().getDisplayMetrics()));
            tv_conten_moutain.setWidth((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 270, getResources().getDisplayMetrics()));


            iv_sumit_moutain.getLayoutParams().width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 100, getResources().getDisplayMetrics());
            iv_sumit_moutain.getLayoutParams().height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 76, getResources().getDisplayMetrics());

            iv_logo_moutain_start.getLayoutParams().width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 180, getResources().getDisplayMetrics());
            iv_logo_moutain_start.getLayoutParams().height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 80, getResources().getDisplayMetrics());

            iv_grade_0.getLayoutParams().width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 85, getResources().getDisplayMetrics());
            iv_grade_0.getLayoutParams().height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 81, getResources().getDisplayMetrics());

            iv_grade_0_en.getLayoutParams().width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 85, getResources().getDisplayMetrics());
            iv_grade_0_en.getLayoutParams().height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 82, getResources().getDisplayMetrics());

            iv_grade_1.getLayoutParams().width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 92, getResources().getDisplayMetrics());
            iv_grade_1.getLayoutParams().height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 80, getResources().getDisplayMetrics());

            iv_grade_2.getLayoutParams().width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 92, getResources().getDisplayMetrics());
            iv_grade_2.getLayoutParams().height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 80, getResources().getDisplayMetrics());

            iv_grade_3.getLayoutParams().width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 92, getResources().getDisplayMetrics());
            iv_grade_3.getLayoutParams().height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 80, getResources().getDisplayMetrics());

            iv_grade_4.getLayoutParams().width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 92, getResources().getDisplayMetrics());
            iv_grade_4.getLayoutParams().height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 80, getResources().getDisplayMetrics());

            iv_grade_5.getLayoutParams().width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 92, getResources().getDisplayMetrics());
            iv_grade_5.getLayoutParams().height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 80, getResources().getDisplayMetrics());

            iv_backgrade.getLayoutParams().width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 48, getResources().getDisplayMetrics());
            iv_backgrade.getLayoutParams().height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 47, getResources().getDisplayMetrics());


            iv_backLevel_opera.getLayoutParams().width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 48, getResources().getDisplayMetrics());
            iv_backLevel_opera.getLayoutParams().height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 47, getResources().getDisplayMetrics());


            iv_backLevel.getLayoutParams().width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 48, getResources().getDisplayMetrics());
            iv_backLevel.getLayoutParams().height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 47, getResources().getDisplayMetrics());


            iv_main_buyvip.getLayoutParams().width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 150, getResources().getDisplayMetrics());
            iv_main_buyvip.getLayoutParams().height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 108, getResources().getDisplayMetrics());


            iv_operator_home.getLayoutParams().width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 40, getResources().getDisplayMetrics());
            iv_operator_home.getLayoutParams().height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 40, getResources().getDisplayMetrics());

            tv_grade_level.setTextSize((float) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 12, getResources().getDisplayMetrics()));


            rl_cloud1.getLayoutParams().width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 120, getResources().getDisplayMetrics());
            rl_cloud1.getLayoutParams().height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 90, getResources().getDisplayMetrics());
            iv_clou1_1.getLayoutParams().width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 32, getResources().getDisplayMetrics());
            iv_clou1_1.getLayoutParams().height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50, getResources().getDisplayMetrics());
            iv_clou1_2.getLayoutParams().width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 32, getResources().getDisplayMetrics());
            iv_clou1_2.getLayoutParams().height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50, getResources().getDisplayMetrics());


            iv_operator.getLayoutParams().width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 56, getResources().getDisplayMetrics());
            iv_operator.getLayoutParams().height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 56, getResources().getDisplayMetrics());

            rl_cloud2.getLayoutParams().width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 122, getResources().getDisplayMetrics());
            rl_cloud2.getLayoutParams().height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 90, getResources().getDisplayMetrics());
            iv_clou2_1.getLayoutParams().width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 32, getResources().getDisplayMetrics());
            iv_clou2_1.getLayoutParams().height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50, getResources().getDisplayMetrics());
            iv_clou2_2.getLayoutParams().width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 32, getResources().getDisplayMetrics());
            iv_clou2_2.getLayoutParams().height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50, getResources().getDisplayMetrics());

            iv_operator_equal.getLayoutParams().width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 52, getResources().getDisplayMetrics());
            iv_operator_equal.getLayoutParams().height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 52, getResources().getDisplayMetrics());

            iv_cloud3.getLayoutParams().width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 130, getResources().getDisplayMetrics());
            iv_cloud3.getLayoutParams().height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 85, getResources().getDisplayMetrics());


            ll_result1.getLayoutParams().width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 130, getResources().getDisplayMetrics());
            ll_result1.getLayoutParams().height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 85, getResources().getDisplayMetrics());
            iv_D3_1.getLayoutParams().width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 32, getResources().getDisplayMetrics());
            iv_D3_1.getLayoutParams().height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50, getResources().getDisplayMetrics());
            iv_D3_2.getLayoutParams().width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 32, getResources().getDisplayMetrics());
            iv_D3_2.getLayoutParams().height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50, getResources().getDisplayMetrics());



            ll_result2.getLayoutParams().width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 130, getResources().getDisplayMetrics());
            ll_result2.getLayoutParams().height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 85, getResources().getDisplayMetrics());
            iv_D2_1.getLayoutParams().width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 32, getResources().getDisplayMetrics());
            iv_D2_1.getLayoutParams().height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50, getResources().getDisplayMetrics());
            iv_D2_2.getLayoutParams().width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 32, getResources().getDisplayMetrics());
            iv_D2_2.getLayoutParams().height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50, getResources().getDisplayMetrics());

            ll_result3.getLayoutParams().width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 130, getResources().getDisplayMetrics());
            ll_result3.getLayoutParams().height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 85, getResources().getDisplayMetrics());
            iv_D1_1.getLayoutParams().width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 32, getResources().getDisplayMetrics());
            iv_D1_1.getLayoutParams().height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50, getResources().getDisplayMetrics());
            iv_D1_2.getLayoutParams().width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 32, getResources().getDisplayMetrics());
            iv_D1_2.getLayoutParams().height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50, getResources().getDisplayMetrics());

        }else
        {
            tv_content_start_equal.setWidth((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 360, getResources().getDisplayMetrics()));
            tv_conten_moutain.setWidth((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 330, getResources().getDisplayMetrics()));
        }

        Bundle extras = getIntent().getExtras();
        if (extras != null && checkOpenTemplate == 0 && currentStatus == Status.MAIN && DeviceLang.equals("vi_vn")) {

            doLoadTempNoti();
        }



        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        mFirebaseAnalytics.setAnalyticsCollectionEnabled(true);
    }

    public void doSetGrade_FR()
    {
        if(DeviceLang.equals("fr"))
        {
            iv_grade_1.setImageResource(R.drawable.lop1_fr);
            iv_grade_2.setImageResource(R.drawable.lop2_fr);
            iv_grade_3.setImageResource(R.drawable.lop3_fr);
            iv_grade_4.setImageResource(R.drawable.lop4_fr);
            iv_grade_5.setImageResource(R.drawable.lop5_fr);
        }else
        {
            iv_grade_1.setImageResource(R.drawable.lop1);
            iv_grade_2.setImageResource(R.drawable.lop2);
            iv_grade_3.setImageResource(R.drawable.lop3);
            iv_grade_4.setImageResource(R.drawable.lop4);
            iv_grade_5.setImageResource(R.drawable.lop5);
        }
    }
    public  Boolean getIOS1()
    {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
//            Log.e("kkkkkkkkk","px w:"+displayMetrics.widthPixels);
//            Log.e("kkkkkkkkk","densi:"+displayMetrics.density);
//            Log.e("kkkkkkkkk","wwwa:"+(float)(displayMetrics.widthPixels / displayMetrics.density));

            if((float)(displayMetrics.widthPixels / displayMetrics.density)>=713)
            {
               // clsHandleT.Loge("true");
                return true;
            }else
            {
               // clsHandleT.Loge("flase");
                return false;
            }



        }catch (Exception exception)
        {
            return false;
        }

    }
    public  float getSizeDesktopWith()
    {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

//            Log.e("kkkkkkkkk","widthPixels:"+displayMetrics.widthPixels);
//            Log.e("kkkkkkkkk","widthPixels DP:"+(float)(displayMetrics.widthPixels / displayMetrics.density));
//
//            Log.e("kkkkkkkkk","densi:"+displayMetrics.density);
//
//            Log.e("kkkkkkkkk","heightPixels:"+displayMetrics.heightPixels);
//            Log.e("kkkkkkkkk","heightPixels DP:"+(float)(displayMetrics.heightPixels / displayMetrics.density));

            return displayMetrics.widthPixels / displayMetrics.density;
        }catch (Exception exception)
        {
            return 713;
        }

    }
    public void  doCheckTextItemVip()
    {
        try {
            if(mMemberVip1==10&&mMemberVip2==10&&mMemberVip3==10&&mMemberVip4==10&&mMemberVip5==10&&mMemberVip_Flag==10)
            {
                mMemberVip_All=10;
            }

            if(mMemberVip_All==10)
            {
                tv_item_vip1.setText(getString(R.string.vip1_check));
                tv_item_vip2.setText(getString(R.string.vip2_check));
                tv_item_vip3.setText(getString(R.string.vip3_check));
                tv_item_vip4.setText(getString(R.string.vip4_check));
                tv_item_vip5.setText(getString(R.string.vip5_check));
                tv_item_flag.setText(getString(R.string.vip_flag_check));
                tv_item_vipall.setText(getString(R.string.vip_all_check));
            }else
            {
                if(mMemberVip1==10)
                {
                    tv_item_vip1.setText(getString(R.string.vip1_check));
                }else
                {
                    tv_item_vip1.setText(getString(R.string.vip1_warning));
                }

                if(mMemberVip2==10)
                {
                    tv_item_vip2.setText(getString(R.string.vip2_check));
                }else
                {
                    tv_item_vip2.setText(getString(R.string.vip2_warning));
                }

                if(mMemberVip3==10)
                {
                    tv_item_vip3.setText(getString(R.string.vip3_check));
                }else
                {
                    tv_item_vip3.setText(getString(R.string.vip3_warning));
                }

                if(mMemberVip4==10)
                {
                    tv_item_vip4.setText(getString(R.string.vip4_check));
                }else
                {
                    tv_item_vip4.setText(getString(R.string.vip4_warning));
                }

                if(mMemberVip5==10)
                {
                    tv_item_vip5.setText(getString(R.string.vip5_check));
                }else
                {
                    tv_item_vip5.setText(getString(R.string.vip5_warning));
                }

                if(mMemberVip_Flag==10)
                {
                    tv_item_flag.setText(getString(R.string.vip_flag_check));
                }else
                {
                    tv_item_flag.setText(getString(R.string.vip_flag_warning));
                }
            }
        }catch (Exception e)
        {

        }
    }
    public void doNotifiHenGio()
    {
        try {
            AlarmManager alarmMgr = (AlarmManager) this.getApplicationContext().getSystemService(this.getApplicationContext().ALARM_SERVICE);

            Intent intent = new Intent(this.getApplicationContext(), ScheduleNotifi.class);
            intent.putExtra("NOTIFIID", Integer.parseInt(calendar.get(Calendar.DAY_OF_MONTH) + "" + calendar.get(Calendar.MONTH) + "" + calendar.get(Calendar.YEAR)));
            intent.setAction(calendar.get(Calendar.DAY_OF_MONTH) + "" + calendar.get(Calendar.MONTH) + "" + calendar.get(Calendar.YEAR));
            PendingIntent alarmIntent;


            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.S) {
                alarmIntent = PendingIntent.getBroadcast(this.getApplicationContext(), 0, intent, PendingIntent.FLAG_MUTABLE);
            }else
            {
                alarmIntent = PendingIntent.getBroadcast(this.getApplicationContext(), 0, intent, 0);
            }

            Calendar calendarNotifi= Calendar.getInstance();
            // int trc=calendarNotifi.get(Calendar.DAY_OF_YEAR);
            calendarNotifi.setTimeInMillis(System.currentTimeMillis());
            calendarNotifi.set(Calendar.HOUR_OF_DAY, 19);
            calendarNotifi.set(Calendar.MINUTE, 00);
            calendarNotifi.set(Calendar.MONTH, calendar.get(Calendar.MONTH));
            calendarNotifi.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH)+1);
            calendarNotifi.set(Calendar.YEAR, calendar.get(Calendar.YEAR));

            alarmMgr.setRepeating(AlarmManager.RTC_WAKEUP, calendarNotifi.getTimeInMillis(),
                    AlarmManager.RTC_WAKEUP, alarmIntent);
        }catch (Exception ex)
        {

        }


    }

    Notifi notifi=new Notifi();
    public void doLoadTempNoti()
    {
        try {
            viewFlipperMath.setDisplayedChild(17);
            if (checkOpenTemplate == 0) {

                currentStatus = Status.LOAD_TEMP;
                tv_title_notifi=(TextView)findViewById(R.id.tv_title_notifi);
                tv_content_notifi=(TextView)findViewById(R.id.tv_content_notifi);
                iv_notifi_main=(ImageView)findViewById(R.id.iv_notifi_main);
                mDatabase.child("notifition").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        try {

                            notifi = dataSnapshot.getValue(Notifi.class);
                            if (currentStatus == Status.LOAD_TEMP ) {
                                if(!notifi.getTitle().equals("")) {
                                    tv_title_notifi.setText(notifi.getTitle());
                                    tv_content_notifi.setText(notifi.getContent());
                                    iv_notifi_main.setVisibility(View.VISIBLE);
                                }
                                checkOpenTemplate = 1;
                            }

                        } catch (Exception ex) {

                            // Toast.makeText(MainActivity.this, "loi", Toast.LENGTH_LONG).show();

                            viewFlipperMath.setDisplayedChild(0);
                            currentStatus=Status.MAIN;

                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        // Log.e("loi",""+databaseError);

                        viewFlipperMath.setDisplayedChild(0);
                        currentStatus=Status.MAIN;

                    }
                });
            }
        }catch (Exception exception)
        {
            viewFlipperMath.setDisplayedChild(0);
            currentStatus=Status.MAIN;
        }
    }
    public void onClick_NotifiHenGio(View view)
    {
        doLoadTempNoti();
    }
    private void createNotificationChannel(String pID) {
        try {
            // Create the NotificationChannel, but only on API 26+ because
            // the NotificationChannel class is new and not in the support library
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                CharSequence name = "Nhắc Nhở";
                String description = "Luyện tập chăm chỉ";

                int importance = NotificationManager.IMPORTANCE_HIGH;

                NotificationChannel channel = new NotificationChannel(pID, name, importance);
                channel.setDescription(description);
                // Register the channel with the system; you can't change the importance
                // or other notification behaviors after this
                NotificationManager notificationManager = getSystemService(NotificationManager.class);
                notificationManager.createNotificationChannel(channel);
            }
        } catch (Exception ex) {

        }
    }
    public void  setMutilang() {
        try {
            if (DeviceLang.equals("vi_vn"))
            {
                try {
                    iv_grade_0.setVisibility(View.VISIBLE);
                    iv_grade_0_en.setVisibility(View.GONE);
                    tv_content_buy_vip.setText(mFirebaseRemoteConfig.getString("inapp_content_vn").replace("\\n", "\n"));
                    tv_main_start.setText("Bắt đầu");
                    tv_content_start_equal.setText(mFirebaseRemoteConfig.getString("start_equal_vn").replace("\\n", "\n"));
                    tv_title_start_equal.setText("Tìm Cặp Bằng Nhau");
                    tv_title_gameover_equal.setText("Tìm Cặp Bằng Nhau");
                    tv_conten_moutain.setText("\uD83D\uDC49 Bạn hãy đi tới đỉnh núi\n \nBằng cách trả lời tất cả các câu hỏi chương trình đưa ra.");

                    tv_zero_add.setText("Phép cộng");
                    tv_zero_sub.setText("Phép trừ");
                    tv_zero_mix.setText("Phép cộng\n và \nPhép trừ");

                }catch (Exception e)
                {

                }

            }else
            {

                try {
                    iv_main_buyvip.setImageResource(R.drawable.buy_vip_pro_en);
                    iv_logo_monkey.setImageResource(R.drawable.monkey);
                    iv_logo_monkey_gameover.setImageResource(R.drawable.monkey);

                    iv_grade_0.setVisibility(View.GONE);
                    iv_grade_0_en.setVisibility(View.VISIBLE);

                    iv_logo_moutain_start.setImageResource(R.drawable.moutian_logo_en);
                    iv_logo_moutain_end.setImageResource(R.drawable.moutian_logo_en);

                    if (DeviceLang.equals("fr"))
                    {
                        tv_content_buy_vip.setText(mFirebaseRemoteConfig.getString("inapp_content_fr").replace("\\n", "\n"));
                        tv_main_start.setText("Démarrer");
                        tv_content_start_equal.setText(mFirebaseRemoteConfig.getString("start_equal_fr").replace("\\n", "\n"));
                        tv_title_start_equal.setText("Trouver la paire égale");
                        tv_title_gameover_equal.setText("Trouver la paire égale");
                        tv_conten_moutain.setText("Vous choisissez l'une des quatre réponses dans la case pour obtenir un résultat correspondant.");
                        tv_zero_add.setText("Addition");
                        tv_zero_sub.setText("Soustraction");
                        tv_zero_mix.setText("Addition\n vs \nSoustraction");
                    }
                    else if (DeviceLang.equals("de"))
                    {
                        tv_content_buy_vip.setText(mFirebaseRemoteConfig.getString("inapp_content_de").replace("\\n", "\n"));
                        tv_main_start.setText("Starten");
                        tv_content_start_equal.setText(mFirebaseRemoteConfig.getString("start_equal_de").replace("\\n", "\n"));
                        tv_title_start_equal.setText("Finde das gleiche Paar");
                        tv_title_gameover_equal.setText("Finde das gleiche Paar");
                        tv_conten_moutain.setText("Du wählst eine von vier Antworten im Feld aus, um das passende Ergebnis zu finden.");
                        tv_zero_add.setText("Addition");
                        tv_zero_sub.setText("Subtraktion");
                        tv_zero_mix.setText("Addition\n vs \nSubtraktion");
                    }else
                    {
                        tv_content_buy_vip.setText(mFirebaseRemoteConfig.getString("inapp_content_en").replace("\\n", "\n"));
                        tv_main_start.setText("Start");
                        tv_content_start_equal.setText(mFirebaseRemoteConfig.getString("start_equal_en").replace("\\n", "\n"));
                        tv_title_start_equal.setText("Find Equal Pair");
                        tv_title_gameover_equal.setText("Find Equal Pair");
                        tv_conten_moutain.setText("You choose one of four answers in the box for matching results.");
                        tv_zero_add.setText("Addition");
                        tv_zero_sub.setText("Subtraction");
                        tv_zero_mix.setText("Addition\n vs \nSubtraction");
                    }


                }catch (Exception e)
                {

                }

            }
            iv_zero_score.setTypeface(typeUTM);
            tv_level_operator.setTypeface(typeUTM);
            tv_score_zero_gameover.setTypeface(typeUTM);
            tv_title_operator.setTypeface(typeUTM);
            tv_status_summary.setTypeface(typeUTM);
            tv_score_summary.setTypeface(typeUTM);
        } catch (Exception ex) {

        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(viewFlipperMath.getDisplayedChild()==0||viewFlipperMath.getDisplayedChild()==1||viewFlipperMath.getDisplayedChild()==2||viewFlipperMath.getDisplayedChild()==12||viewFlipperMath.getDisplayedChild()==17) {

            clsHandleT.doPlaySoundBG("sounds/nhacnen.mp3", playerBg, this);
        }
        checkOnPause=false;
    }

    @Override
    protected void onPause() {
        super.onPause();
        playerBg.pause();
        if (player.isPlaying()) {
            player.pause();
            // mLengthMediaPlayer = player.getCurrentPosition();
        }
        checkOnPause=true;
    }
    //region Grade0
    public void onClickPlayOperator(View view)
    {
        try {
            cl_min_max.clearAnimation();
            cl_min_max.setVisibility(View.GONE);
            cl_ingame_opera.setVisibility(View.VISIBLE);
            rl_game_over.setVisibility(View.GONE);
            rl_game_over.clearAnimation();

            mScore_Zero=0;
            mLevelZero=1;
            tv_level_operator.setText(mLevelZero+"/"+15);
            iv_zero_score.setText("");
            doLoadZeroData();
            doSuggetZero();
            playerBg.pause();
            lengthMediaBg=playerBg.getCurrentPosition();
            if (((int) mFirebaseRemoteConfig.getValue("b_ads_inapp_zero").asDouble()) != 0
                    &&mMemberVip1==0
                    &&mMemberVip2==0
                    &&mMemberVip3==0
                    &&mMemberVip4==0
                    &&mMemberVip5==0
                    &&mMemberVip_Flag==0
                    &&mMemberVip_All==0) {
                AdmobManager.doLoadInterstitialAd(this);
            }

            //clsHandleT.doPlaySoundAssets("click.ogg","",player, false, this);
        }catch (Exception exception)
        {

        }
    }
    public void onClick_Back_Home_Zero(View view)
    {
        try {
            if(currentStatus==Status.ZERO_OPEN) {
                clsHandleT.showDialogReset(MainActivity.this);
                doPlayClick();
            }
        }catch (Exception exception)
        {

        }
    }
    public void doBackHomeZero()
    {
        try {
            playerBg.seekTo(lengthMediaBg);
            playerBg.start();
            doOpenOpera();
            doPlayClick();
            if (((int) mFirebaseRemoteConfig.getValue("b_ads_inapp_zero").asDouble()) != 0
                    &&mMemberVip1==0
                    &&mMemberVip2==0
                    &&mMemberVip3==0
                    &&mMemberVip4==0
                    &&mMemberVip5==0
                    &&mMemberVip_Flag==0
                    &&mMemberVip_All==0) {
                AdmobManager.doShowInterstitialAd(this);
            }
        }catch (Exception exception)
        {

        }

    }
    public void onClick_Home_Operator_GameOver(View view)
    {
        try {
            playerBg.seekTo(lengthMediaBg);
            playerBg.start();
            doOpenOpera();
            doPlayClick();

        }catch (Exception exception)
        {

        }
    }
    ArrayList<Zero> lstZero;
    Zero mZero;
    ArrayList<Integer> lstResultZero;
    ArrayList<Integer> lstResultTMG;
    public void doLoadZeroData()
    {
        try {
            lstZero=new ArrayList<Zero>();
            switch (mZeloOperator)
            {

                case 1:
                    for(int i=1;i<mZeloMax-1;i++)
                    {
                        for (int j=0;j<mZeloMax-1;j++)
                        {
                            if((i+j)>=mZeloMax)
                                continue;
                            lstZero.add(new Zero(i,j,i+j,true));
                        }
                    }
                    break;
                case 2:
                    for(int i=1;i<mZeloMax-1;i++)
                    {
                        for (int j=0;j<mZeloMax-1;j++)
                        {
                            if(i<=j)
                                continue;
                            lstZero.add(new Zero(i,j,i-j,false));
                        }
                    }
                    break;
                default:
                    for(int i=1;i<mZeloMax-1;i++)
                    {
                        for (int j=0;j<mZeloMax-1;j++)
                        {
                            if((i+j)>=mZeloMax)
                                continue;
                            lstZero.add(new Zero(i,j,i+j,true));
                        }
                    }
                    for(int i=1;i<mZeloMax-1;i++)
                    {
                        for (int j=0;j<mZeloMax-1;j++)
                        {
                            if(i<=j)
                                continue;
                            lstZero.add(new Zero(i,j,i-j,false));
                        }
                    }
                    break;
            }
            Collections.shuffle(lstZero);
        }catch (Exception exception)
        {

        }
    }
    void doSuggetZero() {
        try {
            rl_d1.setVisibility(View.GONE);
            rl_d2.setVisibility(View.GONE);
            rl_d3.setVisibility(View.GONE);
            rl_cloud1.setVisibility(View.GONE);
            iv_operator.setVisibility(View.GONE);
            rl_cloud2.setVisibility(View.GONE);
            iv_operator_equal.setVisibility(View.GONE);
            iv_cloud3.setVisibility(View.GONE);
            iv_x1.setVisibility(View.GONE);
            iv_x2.setVisibility(View.GONE);
            iv_x3.setVisibility(View.GONE);
            iv_continue_zero.setVisibility(View.GONE);
            iv_continue_zero.setVisibility(View.GONE);

            rl_d1.clearAnimation();
            rl_d2.clearAnimation();
            rl_d3.clearAnimation();
            rl_cloud1.clearAnimation();
            iv_operator.clearAnimation();
            rl_cloud2.clearAnimation();
            iv_operator_equal.clearAnimation();
            iv_cloud3.clearAnimation();
            iv_x1.clearAnimation();
            iv_x2.clearAnimation();
            iv_x3.clearAnimation();
            iv_continue_zero.clearAnimation();
            iv_continue_zero.clearAnimation();


            lstResultZero = new ArrayList<Integer>();
            mZero = lstZero.get(rd.nextInt(lstZero.size() - 1));
            doSuggetItemZero(mZero.getBefore(), iv_clou1_1, iv_clou1_2);
            if (mZero.isAdd()) {
                iv_operator.setImageResource(R.drawable.cong);
//                Picasso.get().load("file:///android_asset/img/cong.png")
//                        .placeholder(R.drawable.cong)
//                        .error(R.drawable.cong)
//                        .transform(new RoundedTransformation(0, 0))
//                        .fit().centerCrop()
//                        .into(iv_operator);
            } else {
                iv_operator.setImageResource(R.drawable.tru);
//                Picasso.get().load("file:///android_asset/img/tru.png")
//                        .placeholder(R.drawable.tru)
//                        .error(R.drawable.tru)
//                        .transform(new RoundedTransformation(0, 0))
//                        .fit().centerCrop()
//                        .into(iv_operator);
            }
            doSuggetItemZero(mZero.getAffter(), iv_clou2_1, iv_clou2_2);

            lstResultZero.add(mZero.getResult());
            if (mZero.getResult() <= 1) {
                lstResultZero.add(0);
                lstResultZero.add(2);
            } else if (mZero.getResult() >= 98) {
                lstResultZero.add(97);
                lstResultZero.add(96);
            } else {
                lstResultTMG = new ArrayList<Integer>();
                lstResultTMG.add(mZero.getResult() - 1);
                lstResultTMG.add(mZero.getResult() - 2);
                lstResultTMG.add(mZero.getResult() + 1);
                lstResultTMG.add(mZero.getResult() + 2);
                Collections.shuffle(lstResultTMG);
                lstResultZero.add(lstResultTMG.get(0));
                lstResultZero.add(lstResultTMG.get(1));
            }
            Collections.shuffle(lstResultZero);
            doSuggetItemZero(lstResultZero.get(0), iv_D1_1, iv_D1_2, rl_d1);
            doSuggetItemZero(lstResultZero.get(1), iv_D2_1, iv_D2_2, rl_d2);
            doSuggetItemZero(lstResultZero.get(2), iv_D3_1, iv_D3_2, rl_d3);


            rl_d1.clearAnimation();
            rl_d2.clearAnimation();
            rl_d3.clearAnimation();
            clsHandleT.doPlaySoundAssets("c2.mp3", "", player, false, MainActivity.this);
            handler.postDelayed(timerShowCloud1, 300);
        } catch (Exception exception) {

        }
    }

    Runnable timerShowCloud1= new Runnable() {
        @Override
        public void run() {

            rl_cloud1.setVisibility(View.VISIBLE);
            rl_cloud1.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoomplus));
            handler.postDelayed(timerShowOpreator,650);

        }
    };
    Runnable timerShowOpreator= new Runnable() {
        @Override
        public void run() {
            clsHandleT.doPlaySoundAssets("c2.mp3","", player, false, MainActivity.this);
            rl_cloud1.clearAnimation();
            iv_operator.setVisibility(View.VISIBLE);
            iv_operator.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoomplus));
            handler.postDelayed(timerShowCloud2,650);

        }
    };
    Runnable timerShowCloud2= new Runnable() {
        @Override
        public void run() {
            // clsHandleT.doPlaySoundAssets("c2.mp3","", player, false, MainActivity.this);
            iv_operator.clearAnimation();
            rl_cloud2.setVisibility(View.VISIBLE);
            rl_cloud2.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoomplus));
            handler.postDelayed(timerShowEqual,650);

        }
    };
    Runnable timerShowEqual= new Runnable() {
        @Override
        public void run() {
            clsHandleT.doPlaySoundAssets("c2.mp3","", player, false, MainActivity.this);
            rl_cloud2.clearAnimation();
            iv_operator_equal.setVisibility(View.VISIBLE);
            iv_operator_equal.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoomplus));
            handler.postDelayed(timerShowResult,650);

        }
    };
    Runnable timerShowResult= new Runnable() {
        @Override
        public void run() {
            //clsHandleT.doPlaySoundAssets("c2.mp3","", player, false, MainActivity.this);
            iv_operator_equal.clearAnimation();
            iv_cloud3.setVisibility(View.VISIBLE);
            iv_cloud3.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoomplus));
            handler.postDelayed(timerShowOptionsResult,650);

        }
    };
    Runnable timerShowOptionsResult= new Runnable() {
        @Override
        public void run() {
            clsHandleT.doPlaySoundAssets("d1.mp3","", player, false, MainActivity.this);
            iv_cloud3.clearAnimation();

            rl_d1.setVisibility(View.VISIBLE);
            rl_d2.setVisibility(View.VISIBLE);
            rl_d3.setVisibility(View.VISIBLE);

            rl_d1.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.in_up));
            rl_d2.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.in_up));
            rl_d3.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.in_up));
            currentStatus=Status.ZERO_OPEN;

            if(mScore_Zero<=0) {
                iv_tap_zero.clearAnimation();
                iv_tap_zero.setVisibility(View.VISIBLE);
                iv_tap_zero.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move));
                handler.postDelayed(timerShowCloseMoveTap, 6000);
            }
        }
    };
    Runnable timerShowCloseMoveTap= new Runnable() {
        @Override
        public void run() {
            iv_tap_zero.clearAnimation();
            iv_tap_zero.setVisibility(View.GONE);
        }
    };

    //---
    void doHandlerProcessZero()
    {
        currentStatus=Status.ZERO_LOCK;
        handler.postDelayed(timerProcessZero,100);
    }
    Runnable timerProcessZero = new Runnable() {
        @Override
        public void run() {
            switch (mSelectCloud)
            {
                case 1:
                    currentStatus=Status.ZERO_LOCK;
                    if(yCurerent<(yResult+(hResult/3))&&xCurerent>(xResult-(wResult/4)))
                    {

                        rl_d1.animate().x(xResult).y(yResult).setDuration(150).start();
                        if(Integer.parseInt(rl_d1.getTag().toString())==mZero.getResult())
                        {
                            handler.postDelayed(timerZeroTrue,400);
                        }else
                        {
                            handler.postDelayed(timerZeroFalse,400);
                        }
                    }else
                    {
                        rl_d1.animate().x(xCloudD1).y(yCloudD1).setDuration(300).start();

                        handler.postDelayed(timerZeroOpenLock,350);
                    }

                    break;
                case 2:
                    currentStatus=Status.ZERO_LOCK;
                    if(yCurerent<(yResult+(hResult/3))&&xCurerent>(xResult-(wResult/4)))
                    {

                        rl_d2.animate().x(xResult).y(yResult).setDuration(150).start();
                        if(Integer.parseInt(rl_d2.getTag().toString())==mZero.getResult())
                        {
                            handler.postDelayed(timerZeroTrue,400);
                        }else
                        {

                            handler.postDelayed(timerZeroFalse,400);
                        }
                    }else
                    {
                        rl_d2.animate().x(xCloudD2).y(yCloudD2).setDuration(300).start();

                        handler.postDelayed(timerZeroOpenLock,350);
                    }
                    break;
                case 3:
                    currentStatus=Status.ZERO_LOCK;
                    if(yCurerent<(yResult+(hResult/3))&&xCurerent>(xResult-(wResult/4)))
                    {

                        rl_d3.animate().x(xResult).y(yResult).setDuration(150).start();
                        if(Integer.parseInt(rl_d3.getTag().toString())==mZero.getResult())
                        {
                            handler.postDelayed(timerZeroTrue,400);
                        }else
                        {

                            handler.postDelayed(timerZeroFalse,400);
                        }
                    }else
                    {
                        rl_d3.animate().x(xCloudD3).y(yCloudD3).setDuration(300).start();

                        handler.postDelayed(timerZeroOpenLock,350);
                    }
                    break;
            }
            //tv_redady.animate().x(xX).y(yY).setDuration(500).start();
        }
    };
    Runnable timerZeroOpenLock= new Runnable() {
        @Override
        public void run() {
            currentStatus=Status.ZERO_OPEN;
        }
    };
    Runnable timerZeroTrue= new Runnable() {
        @Override
        public void run() {
            clsHandleT.doPlaySoundAssets("win.mp3","", player, false, MainActivity.this);
            handler.postDelayed(timer_True_MediaPlay,player.getDuration());
            mScore_Zero+=10;
            rl_d1.setTag(-1);
            rl_d2.setTag(-1);
            rl_d3.setTag(-1);
            iv_zero_score.setText(""+mScore_Zero);
            la_firework_zero.playAnimation();
            iv_star1.setVisibility(View.VISIBLE);
            iv_star2.setVisibility(View.VISIBLE);
            iv_star3.setVisibility(View.VISIBLE);

            iv_star1.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shake_gitbox));
            iv_star2.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shake_gitbox));
            iv_star3.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shake_gitbox));

            ll_star_zero.startAnimation(aniOut_Up);


            handler.postDelayed(timerShowContinueZero,player.getDuration()+1000);
        }
    };
    Runnable timerShowContinueZero= new Runnable() {
        @Override
        public void run() {
            iv_continue_zero.setVisibility(View.VISIBLE);
            iv_continue_zero.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoomplus));
        }
    };
    public void onClickContinueZero(View view) {
        try {
            rl_cloud1.clearAnimation();
            iv_operator.clearAnimation();
            rl_cloud2.clearAnimation();
            iv_operator_equal.clearAnimation();
            iv_cloud3.clearAnimation();
            rl_d1.clearAnimation();
            rl_d2.clearAnimation();
            rl_d3.clearAnimation();
            iv_continue_zero.clearAnimation();



            rl_cloud1.startAnimation(aniZoom_Subs);
            iv_operator.startAnimation(aniZoom_Subs);
            rl_cloud2.startAnimation(aniZoom_Subs);
            iv_operator_equal.startAnimation(aniZoom_Subs);
            iv_cloud3.startAnimation(aniZoom_Subs);
            rl_d1.startAnimation(aniZoom_Subs);
            rl_d2.startAnimation(aniZoom_Subs);
            rl_d3.startAnimation(aniZoom_Subs);
            iv_continue_zero.startAnimation(aniZoom_Subs);

            mLevelZero=mLevelZero+1;

        } catch (Exception exception) {

        }
    }
    Runnable timerZeroFalse= new Runnable() {
        @Override
        public void run() {

            clsHandleT.doPlaySoundAssets("over.mp3","", player, false, MainActivity.this);
            if(mScore_Zero>5)
            {
                mScore_Zero--;
                iv_zero_score.setText(""+mScore_Zero);
            }
            switch (mSelectCloud)
            {
                case 1:
                    rl_d1.setTag(-1);
                    iv_x1.setVisibility(View.VISIBLE);
                    break;
                case 2:
                    rl_d2.setTag(-1);
                    iv_x2.setVisibility(View.VISIBLE);
                    break;
                case 3:
                    rl_d3.setTag(-1);
                    iv_x3.setVisibility(View.VISIBLE);
                    break;
            }
            handler.postDelayed(timerZeroMove,500);
        }
    };
    Runnable timerZeroMove= new Runnable() {
        @Override
        public void run() {

            switch (mSelectCloud)
            {
                case 1:
                    rl_d1.animate().x(xCloudD1).y(yCloudD1).setDuration(500).start();

                    break;
                case 2:
                    rl_d2.animate().x(xCloudD2).y(yCloudD2).setDuration(500).start();
                    break;
                case 3:
                    rl_d3.animate().x(xCloudD3).y(yCloudD3).setDuration(500).start();

                    break;
            }
            currentStatus=Status.ZERO_OPEN;
        }
    };



    void doSuggetItemZero(int pValue,ImageView pIvA, ImageView pIvB,RelativeLayout pLL)
    {
        pLL.setTag(pValue);
        if(pValue<10)
        {
            pIvA.setVisibility(View.VISIBLE);
            pIvB.setVisibility(View.GONE);
            switch (pValue)
            {
                case 0:
                    pIvA.setBackgroundResource(R.drawable.ngayle_0);
                    break;
                case 1:
                    pIvA.setBackgroundResource(R.drawable.ngayle_1);
                    break;
                case 2:
                    pIvA.setBackgroundResource(R.drawable.ngayle_2);
                    break;
                case 3:
                    pIvA.setBackgroundResource(R.drawable.ngayle_3);
                    break;
                case 4:
                    pIvA.setBackgroundResource(R.drawable.ngayle_4);
                    break;
                case 5:
                    pIvA.setBackgroundResource(R.drawable.ngayle_5);
                    break;
                case 6:
                    pIvA.setBackgroundResource(R.drawable.ngayle_6);
                    break;
                case 7:
                    pIvA.setBackgroundResource(R.drawable.ngayle_7);
                    break;
                case 8:
                    pIvA.setBackgroundResource(R.drawable.ngayle_8);
                    break;
                default:
                    pIvA.setBackgroundResource(R.drawable.ngayle_9);
                    break;
            }
        }else
        {
            pIvA.setVisibility(View.VISIBLE);
            pIvB.setVisibility(View.VISIBLE);
            switch (pValue/10)
            {
                case 0:
                    pIvA.setBackgroundResource(R.drawable.ngayle_0);
                    break;
                case 1:
                    pIvA.setBackgroundResource(R.drawable.ngayle_1);
                    break;
                case 2:
                    pIvA.setBackgroundResource(R.drawable.ngayle_2);
                    break;
                case 3:
                    pIvA.setBackgroundResource(R.drawable.ngayle_3);
                    break;
                case 4:
                    pIvA.setBackgroundResource(R.drawable.ngayle_4);
                    break;
                case 5:
                    pIvA.setBackgroundResource(R.drawable.ngayle_5);
                    break;
                case 6:
                    pIvA.setBackgroundResource(R.drawable.ngayle_6);
                    break;
                case 7:
                    pIvA.setBackgroundResource(R.drawable.ngayle_7);
                    break;
                case 8:
                    pIvA.setBackgroundResource(R.drawable.ngayle_8);
                    break;
                default:
                    pIvA.setBackgroundResource(R.drawable.ngayle_9);
                    break;
            }
            switch (pValue%10)
            {
                case 0:
                    pIvB.setBackgroundResource(R.drawable.ngayle_0);
                    break;
                case 1:
                    pIvB.setBackgroundResource(R.drawable.ngayle_1);
                    break;
                case 2:
                    pIvB.setBackgroundResource(R.drawable.ngayle_2);
                    break;
                case 3:
                    pIvB.setBackgroundResource(R.drawable.ngayle_3);
                    break;
                case 4:
                    pIvB.setBackgroundResource(R.drawable.ngayle_4);
                    break;
                case 5:
                    pIvB.setBackgroundResource(R.drawable.ngayle_5);
                    break;
                case 6:
                    pIvB.setBackgroundResource(R.drawable.ngayle_6);
                    break;
                case 7:
                    pIvB.setBackgroundResource(R.drawable.ngayle_7);
                    break;
                case 8:
                    pIvB.setBackgroundResource(R.drawable.ngayle_8);
                    break;
                default:
                    pIvB.setBackgroundResource(R.drawable.ngayle_9);
                    break;
            }
        }
    }
    void doSuggetItemZero(int pValue,ImageView pIvA, ImageView pIvB)
    {

        if(pValue<10)
        {
            pIvA.setVisibility(View.VISIBLE);
            pIvB.setVisibility(View.GONE);
            switch (pValue)
            {
                case 0:
                    pIvA.setBackgroundResource(R.drawable.ngayle_0);
                    break;
                case 1:
                    pIvA.setBackgroundResource(R.drawable.ngayle_1);
                    break;
                case 2:
                    pIvA.setBackgroundResource(R.drawable.ngayle_2);
                    break;
                case 3:
                    pIvA.setBackgroundResource(R.drawable.ngayle_3);
                    break;
                case 4:
                    pIvA.setBackgroundResource(R.drawable.ngayle_4);
                    break;
                case 5:
                    pIvA.setBackgroundResource(R.drawable.ngayle_5);
                    break;
                case 6:
                    pIvA.setBackgroundResource(R.drawable.ngayle_6);
                    break;
                case 7:
                    pIvA.setBackgroundResource(R.drawable.ngayle_7);
                    break;
                case 8:
                    pIvA.setBackgroundResource(R.drawable.ngayle_8);
                    break;
                default:
                    pIvA.setBackgroundResource(R.drawable.ngayle_9);
                    break;
            }
        }else
        {
            pIvA.setVisibility(View.VISIBLE);
            pIvB.setVisibility(View.VISIBLE);
            switch (pValue/10)
            {
                case 0:
                    pIvA.setBackgroundResource(R.drawable.ngayle_0);
                    break;
                case 1:
                    pIvA.setBackgroundResource(R.drawable.ngayle_1);
                    break;
                case 2:
                    pIvA.setBackgroundResource(R.drawable.ngayle_2);
                    break;
                case 3:
                    pIvA.setBackgroundResource(R.drawable.ngayle_3);
                    break;
                case 4:
                    pIvA.setBackgroundResource(R.drawable.ngayle_4);
                    break;
                case 5:
                    pIvA.setBackgroundResource(R.drawable.ngayle_5);
                    break;
                case 6:
                    pIvA.setBackgroundResource(R.drawable.ngayle_6);
                    break;
                case 7:
                    pIvA.setBackgroundResource(R.drawable.ngayle_7);
                    break;
                case 8:
                    pIvA.setBackgroundResource(R.drawable.ngayle_8);
                    break;
                default:
                    pIvA.setBackgroundResource(R.drawable.ngayle_9);
                    break;
            }
            switch (pValue%10)
            {
                case 0:
                    pIvB.setBackgroundResource(R.drawable.ngayle_0);
                    break;
                case 1:
                    pIvB.setBackgroundResource(R.drawable.ngayle_1);
                    break;
                case 2:
                    pIvB.setBackgroundResource(R.drawable.ngayle_2);
                    break;
                case 3:
                    pIvB.setBackgroundResource(R.drawable.ngayle_3);
                    break;
                case 4:
                    pIvB.setBackgroundResource(R.drawable.ngayle_4);
                    break;
                case 5:
                    pIvB.setBackgroundResource(R.drawable.ngayle_5);
                    break;
                case 6:
                    pIvB.setBackgroundResource(R.drawable.ngayle_6);
                    break;
                case 7:
                    pIvB.setBackgroundResource(R.drawable.ngayle_7);
                    break;
                case 8:
                    pIvB.setBackgroundResource(R.drawable.ngayle_8);
                    break;
                default:
                    pIvB.setBackgroundResource(R.drawable.ngayle_9);
                    break;
            }
        }
    }
    public void onClickOpera(View view)
    {
        try {
            doPlayClick();
            mZeloOperator=Integer.parseInt(view.getTag().toString());
            ll_operator.clearAnimation();
            ll_operator.setVisibility(View.GONE);
            iv_backLevel_opera.setVisibility(View.GONE);
            cl_min_max.clearAnimation();

            cl_min_max.setVisibility(View.VISIBLE);
            iv_check_10.setVisibility(View.VISIBLE);
            iv_check_20.setVisibility(View.GONE);
            iv_check_50.setVisibility(View.GONE);
            iv_check_100.setVisibility(View.GONE);
            mZeloMax=10;


            if(DeviceLang.equals("vi_vn"))
            {
                switch (mZeloOperator)
                {
                    case 1:
                        tv_title_operator.setText("Phép cộng");
                        break;
                    case 2:
                        tv_title_operator.setText("Phép trừ");
                        break;
                    default:
                        tv_title_operator.setText("Phép cộng và Phép trừ");
                        break;
                }
            }
            else  if(DeviceLang.equals("fr"))
            {
                switch (mZeloOperator)
                {
                    case 1:
                        tv_title_operator.setText("Addition");
                        break;
                    case 2:
                        tv_title_operator.setText("Soustraction");
                        break;
                    default:
                        tv_title_operator.setText("Addition vs Soustraction");
                        break;
                }
            }
             else  if(DeviceLang.equals("de"))
            {
                switch (mZeloOperator)
                {
                    case 1:
                        tv_title_operator.setText("Addition");
                        break;
                    case 2:
                        tv_title_operator.setText("Subtraktion");
                        break;
                    default:
                        tv_title_operator.setText("Addition vs Subtraktion");
                        break;
                }
            }
            else
            {
                switch (mZeloOperator)
                {
                    case 1:
                        tv_title_operator.setText("Addition");
                        break;
                    case 2:
                        tv_title_operator.setText("Subtraction");
                        break;
                    default:
                        tv_title_operator.setText("Addition vs Subtraction");
                        break;
                }
            }


            cl_min_max.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoomplus));
            // Db("K:"+mZeloOperator);
        }catch (Exception exception)
        {

        }
    }
    public void onClickMaxMin(View view)
    {
        try {
            doMaxMin(Integer.parseInt(view.getTag().toString()));
            doPlayClick();
        }catch (Exception exception)
        {

        }
    }
    public void doMaxMin(int pMax)
    {
        mZeloMax=pMax;
        switch (pMax)
        {
            case 20:
                iv_check_10.setVisibility(View.GONE);
                iv_check_20.setVisibility(View.VISIBLE);
                iv_check_50.setVisibility(View.GONE);
                iv_check_100.setVisibility(View.GONE);
                break;
            case 50:
                iv_check_10.setVisibility(View.GONE);
                iv_check_20.setVisibility(View.GONE);
                iv_check_50.setVisibility(View.VISIBLE);
                iv_check_100.setVisibility(View.GONE);
                break;
            case 100:
                iv_check_10.setVisibility(View.GONE);
                iv_check_20.setVisibility(View.GONE);
                iv_check_50.setVisibility(View.GONE);
                iv_check_100.setVisibility(View.VISIBLE);
                break;
            default:
                iv_check_10.setVisibility(View.VISIBLE);
                iv_check_20.setVisibility(View.GONE);
                iv_check_50.setVisibility(View.GONE);
                iv_check_100.setVisibility(View.GONE);
                break;
        }
//         Db("h:"+mZeloMax);
    }

    public void onClickOperator(View view)
    {
        try {
            if(currentStatus==Status.MAIN) {
                clsHandleT.doPlaySoundAssets("win.mp3","",player, false, this);
                currentStatus = Status.ZERO_LOCK;
                la_sun_grade0.clearAnimation();

                la_sun_grade0.setVisibility(View.VISIBLE);
                la_sun_grade0.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoomplus));
                //la_sun_grade0.playAnimation();
                handler.postDelayed(timerShowOperator, 2300);
                iv_grade_0.setVisibility(View.GONE);
                iv_grade_0_en.setVisibility(View.GONE);
                iv_grade_1.setVisibility(View.GONE);
                iv_grade_2.setVisibility(View.GONE);
                iv_grade_3.setVisibility(View.GONE);
                iv_grade_4.setVisibility(View.GONE);
                iv_grade_5.setVisibility(View.GONE);
                iv_grade_20.setVisibility(View.GONE);
            }
        }catch (Exception exception)
        {

        }

    }
    Runnable timerShowOperator = new Runnable() {
        @Override
        public void run() {
            viewFlipperMath.setDisplayedChild(15);
            doOpenOpera();
        }
    };

    public void onClickCloseMax(View view)
    {
        try {
            doOpenOpera();
            doPlayClick();
        }catch (Exception exception)
        {

        }
    }
    void doOpenOpera()
    {

        ll_operator.clearAnimation();
        ll_operator.setVisibility(View.VISIBLE);
        iv_backLevel_opera.setVisibility(View.VISIBLE);
        cl_min_max.clearAnimation();
        cl_min_max.setVisibility(View.GONE);
        cl_ingame_opera.setVisibility(View.GONE);
        rl_game_over.setVisibility(View.GONE);

        rl_game_over.clearAnimation();
        iv_zero_score.setText("");
        ll_operator.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoomplus));
        currentStatus=Status.ZERO_LOCK;
    }
    //endregion

    //region Moutain Input

    void doStartMoutain()
    {

        try {
            Collections.shuffle(lstLoiVanLevel);
            doResetMoutain();
//            doRandomMoutain();

//            doRunTimeInGame(mFirtTime*1000,tv_time_ingame_moutain,3);
        }catch (Exception exception)
        {

        }

        try {
            viewFlipperMath.setDisplayedChild(9);

            clsHandleT.doPlaySoundAssets("start_moutain.mp3",DeviceLang, player, false, MainActivity.this);
            if(mGrade>3)
            {
                try {
                    rl_question_moutain.setBackgroundResource(R.drawable.round_layout_moutain);
                }catch (Exception ex)
                {

                }


            }else {
                try {
                    rl_question_moutain.setBackgroundResource(R.drawable.bg_question_moutain);
                }catch (Exception ex)
                {

                }

            }
        }catch (Exception exception)
        {

        }


    }

    public void doRandomMoutain()
    {
        try {
            mChonGenary=rd.nextInt(lstLoiVanLevel.size());
            mLoiVan=lstLoiVanLevel.get(mChonGenary);
            rl_question_moutain.setVisibility(View.VISIBLE);

            //tv_question_moutain.setText(mLoiVan.getQuestion());
            tv_question_moutain.setText(Html.fromHtml("<b>"+mLoiVan.getQuestion()+"</b>"));
            try {
                iv_monkey_moutain.setImageResource(R.drawable.monkey_question);
            }catch (Exception e)
            {

            }
            mResultMoutain="0";
            tv_result_moutain.setText(mResultMoutain);
            iv_continue_moutain.setVisibility(View.GONE);
            tv_report.setVisibility(View.GONE);
            iv_sumit_moutain.setVisibility(View.VISIBLE);
            ll_number_moutain.setVisibility(View.VISIBLE);

            currentStatus=Status.MOUTAIN;
            tv_question_moutain.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.scala_animation_question));
            if(clsHandleT.doCheckExistFile(mModeUrlQuestion_Math + "/grade" + mGrade + "/" + mLoiVan.getId() + ".mp3"))
            {
                clsHandleT.doPlaySoundUrlLocal(mModeUrlQuestion_Math + "/grade" + mGrade + "/" + mLoiVan.getId() + ".mp3",player,MainActivity.this);
            } else if(clsHandleT.isAssetExists(this, "sounds/grade"+mGrade+"/" + mLoiVan.getId() + ".mp3"))
            {
                clsHandleT.doPlaySoundAssets(mLoiVan.getId() + ".mp3","grade" + mGrade, player, false, MainActivity.this);
            }
            //rl_question_moutain.startAnimation(aniZoomQuestion);
        }catch (Exception exception)
        {

        }
    }

    public void doResetMoutain()
    {
        mScore_Moutain=0;
        mNext_False_Moutain=0;
        mFirtTime=1200;
        mResultMoutain="0";
        tv_result_moutain.setText(mResultMoutain);
        try {
            iv_false_moutain.setImageResource(R.drawable.bamau);
        }catch (Exception e)
        {

        }

        if(DeviceLang.equals("vi_vn"))
        {
            tv_score_moutain.setText("Điểm: 00");
        }
        else   if(DeviceLang.equals("fr"))
        {
            tv_score_moutain.setText("Score: 00");
        }
         else   if(DeviceLang.equals("de"))
        {
            tv_score_moutain.setText("Punktzahl: 00");
        }
        else
        {
            tv_score_moutain.setText("Score: 00");
        }

        tv_time_ingame_moutain.setText("⏰ ");
        doNextAvataMotain();

        tv_A.setBackgroundResource(R.drawable.round_bt_item);
        tv_B.setBackgroundResource(R.drawable.round_bt_item);
        tv_C.setBackgroundResource(R.drawable.round_bt_item);
        tv_D.setBackgroundResource(R.drawable.round_bt_item);
    }
    public void onClickMoutainSumit(View view)
    {
        try {
            if(currentStatus==Status.MOUTAIN)
            {
                doPlayClick();
                if(!mResultMoutain.equals("")) {
                    currentStatus = Status.MOUTAIN_SUMIT;
                    iv_sumit_moutain.setVisibility(View.GONE);
                    ll_number_moutain.setVisibility(View.GONE);
                    try {
                        iv_monkey_moutain.setImageResource(R.drawable.monkey_answer);
                    }catch (Exception e)
                    {

                    }
                    if(mLoiVan.getResult()==Integer.parseInt(mResultMoutain))
                    {
                        handler.postDelayed(timerProcessMouTainTrue, 1000);
                    }else
                    {
                        handler.postDelayed(timerProcessMoutainFasle, 1000);
                    }
                }else
                {
                    tv_result_moutain.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.scala_animation));
                    clsHandleT.doPlaySoundAssets("noemty.mp3",DeviceLang, player, false, MainActivity.this);
                    Toast.makeText(this,""+getString(R.string.inputnotblank),Toast.LENGTH_LONG).show();
                }

            }
        }catch (Exception exception)
        {

        }
    }
    Runnable timerProcessMouTainTrue = new Runnable() {
        @Override
        public void run() {
            clsHandleT.doPlaySoundAssets("guess_true.ogg","", player, false, MainActivity.this);

            if(currentStatus==Status.MOUTAIN_SELECT_LOCK)
            {
              switch (mMountain.getTruecase())
              {
                  case 1:
                      tv_A.setBackgroundResource(R.drawable.round_bt_item_true);
                      tv_A.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink));
                      break;
                  case 2:
                      tv_B.setBackgroundResource(R.drawable.round_bt_item_true);
                      tv_B.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink));
                      break;
                  case 3:
                      tv_C.setBackgroundResource(R.drawable.round_bt_item_true);
                      tv_C.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink));
                      break;
                  default:
                      tv_D.setBackgroundResource(R.drawable.round_bt_item_true);
                      tv_D.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink));
                      break;
              }
            }

            handler.postDelayed(timer_True_MediaPlay, player.getDuration());
            try {
                iv_monkey_moutain.setImageResource(R.drawable.monkey_laugh);
            }catch (Exception e)
            {

            }
            iv_monkey_moutain.setAnimation(anim_tbequal);

            mScore_Moutain=mScore_Moutain+10;


            if(DeviceLang.equals("vi_vn"))
            {

                tv_score_moutain.setText("Điểm: "+mScore_Moutain);
            }
            else   if(DeviceLang.equals("fr"))
            {
                tv_score_moutain.setText("Score: "+mScore_Moutain);
            }
            else   if(DeviceLang.equals("de"))
            {
                tv_score_moutain.setText("Punktzahl: "+mScore_Moutain);
            }
            else
            {
                tv_score_moutain.setText("Score: "+mScore_Moutain);
            }


            if(currentStatus == Status.MOUTAIN_SUMIT)
            {

                rl_question_moutain.setVisibility(View.GONE);
                handler.postDelayed(timerProcessMoutainNextUp, 1200);

            }else
            {
                handler.postDelayed(timerDelayMoutainUpSelect, 2200);
            }




        }
    };
    Runnable timerProcessMoutainNextUp= new Runnable() {
        @Override
        public void run() {

            doNextAvataMotain();
//            if(currentStatus==Status.MOUTAIN_SELECT_LOCK) {
//                clsHandleT.doPlaySoundAssets("sfx_wing.mp3", "", player, false, MainActivity.this);
//            }

            if(mScore_Moutain>91)
            {
                handler.postDelayed(timer_GameOver_Moutain, 1700);
            }else {
                if(currentStatus == Status.MOUTAIN_SUMIT)
                {
                    lstLoiVanLevel.remove(mChonGenary);
                }else
                {
                    lstMountain.remove(mChonGenary);
                }

                handler.postDelayed(timerRadomMotain, player.getDuration()+200);
            }
        }
    };
    Runnable timer_GameOver_Moutain= new Runnable() {
        @Override
        public void run() {
            handler.removeCallbacksAndMessages(null);
            currentStatus=Status.GAME_OVER_MOUTAIN;



            if(DeviceLang.equals("vi_vn"))
            {

                tv_score_moutain_gameover.setText("Điểm: "+mScore_Moutain);

            }
            else   if(DeviceLang.equals("fr"))
            {
                tv_score_moutain_gameover.setText("Score: "+mScore_Moutain);
            }
            else   if(DeviceLang.equals("de"))
            {
                tv_score_moutain_gameover.setText("Punktzahl: "+mScore_Moutain);
            }
            else
            {
                tv_score_moutain_gameover.setText("Score: "+mScore_Moutain);
            }

            try {
                if(mNext_False_Moutain==1)
                {
                    iv_flase_moutain_gameover.setImageResource(R.drawable.haimau);
                }else  if(mNext_False_Moutain==2)
                {
                    iv_flase_moutain_gameover.setImageResource(R.drawable.motmau);
                }else if(mNext_False_Moutain==3)
                {
                    iv_flase_moutain_gameover.setImageResource(R.drawable.khongmau);
                }else
                {
                    iv_flase_moutain_gameover.setImageResource(R.drawable.bamau);
                }
            }catch (Exception e)
            {

            }
            viewFlipperMath.setDisplayedChild(11);
            mCdt_TimeGame.cancel();
        }
    };
    Runnable timerRadomMotain= new Runnable() {
        @Override
        public void run() {

            if(currentStatus == Status.MOUTAIN_SUMIT)
            {
                doRandomMoutain();
            }else
            {
                doRandomMoutain_Select();
            }

        }
    };
    Runnable timerProcessMoutainFasle = new Runnable() {
        @Override
        public void run() {

            //  handler.postDelayed(timer_False_MediaPlay,20);
            if(currentStatus == Status.MOUTAIN_SUMIT)
            {
                clsHandleT.doPlaySoundAssets("sai"+(rd.nextInt(5)+1)+".mp3",DeviceLang, player, false, MainActivity.this);
            }else
            {
                clsHandleT.doPlaySoundAssets("over.mp3", "", player, false, MainActivity.this);
            }

            mNext_False_Moutain++;
//            rl_monkey_avata_pheptoan_bg.setVisibility(View.GONE);
            try {
                iv_monkey_moutain.setImageResource(R.drawable.monkey_cry);
                if(mNext_False_Moutain==1)
                {
                    iv_false_moutain.setImageResource(R.drawable.haimau);
                }else  if(mNext_False_Moutain==2)
                {
                    iv_false_moutain.setImageResource(R.drawable.motmau);
                }else
                {
                    iv_false_moutain.setImageResource(R.drawable.khongmau);
                }
            }catch (Exception e)
            {

            }

            if(mScore_Moutain>5)
            {
                mScore_Moutain--;



                if(DeviceLang.equals("vi_vn"))
                {

                    tv_score_moutain.setText("Điểm: "+mScore_Moutain);

                }
                else   if(DeviceLang.equals("fr"))
                {
                    tv_score_moutain.setText("Score: "+mScore_Moutain);
                }
                else   if(DeviceLang.equals("de"))
                {
                    tv_score_moutain.setText("Punktzahl: "+mScore_Moutain);
                }
                else
                {
                    tv_score_moutain.setText("Score: "+mScore_Moutain);
                }

            }

            if(currentStatus == Status.MOUTAIN_SUMIT)
            {
                tv_report.setVisibility(View.VISIBLE);



                if(DeviceLang.equals("vi_vn"))
                {
                    if(mLoiVan.getExplain().equals("gta")||mLoiVan.getExplain().equals("giaithich"))
                    {
                        tv_question_moutain.setText(Html.fromHtml("<b>"+mLoiVan.getQuestion()+"</b>"+"\n\n"+"<p>Đáp số: "+mLoiVan.getResult()+"</p>"));
                        // tv_question_moutain.setText(mLoiVan.getQuestion() + "\n\n" + getString(R.string.result)+" " + mLoiVan.getResult());
                    }else {
                        // tv_question_moutain.setText(mLoiVan.getQuestion() + "\n\n" + getString(R.string.resolve)+" " + mLoiVan.getExplain());
                        tv_question_moutain.setText(Html.fromHtml("<b>"+mLoiVan.getQuestion()+"</b>"+"\n\n"+"<p>Lời Giải: "+mLoiVan.getExplain()+"</p>"));
                    }
                }
                else  if(DeviceLang.equals("fr"))
                {
                    if(mLoiVan.getExplain().equals("gta")||mLoiVan.getExplain().equals("giaithich"))
                    {
                        tv_question_moutain.setText(Html.fromHtml("<b>"+mLoiVan.getQuestion()+"</b>"+"\n\n"+"<p>Résultat: "+mLoiVan.getResult()+"</p>"));
                        // tv_question_moutain.setText(mLoiVan.getQuestion() + "\n\n" + getString(R.string.result)+" " + mLoiVan.getResult());
                    }else {
                        // tv_question_moutain.setText(mLoiVan.getQuestion() + "\n\n" + getString(R.string.resolve)+" " + mLoiVan.getExplain());
                        tv_question_moutain.setText(Html.fromHtml("<b>"+mLoiVan.getQuestion()+"</b>"+"\n\n"+"<p>Résoudre: "+mLoiVan.getExplain().replace("Result:","")+"</p>"));
                    }
                }
                    else  if(DeviceLang.equals("de"))
                {
                    if(mLoiVan.getExplain().equals("gta")||mLoiVan.getExplain().equals("giaithich"))
                    {
                        tv_question_moutain.setText(Html.fromHtml("<b>"+mLoiVan.getQuestion()+"</b>"+"\n\n"+"<p>Ergebnis: "+mLoiVan.getResult()+"</p>"));
                        // tv_question_moutain.setText(mLoiVan.getQuestion() + "\n\n" + getString(R.string.result)+" " + mLoiVan.getResult());
                    }else {
                        // tv_question_moutain.setText(mLoiVan.getQuestion() + "\n\n" + getString(R.string.resolve)+" " + mLoiVan.getExplain());
                        tv_question_moutain.setText(Html.fromHtml("<b>"+mLoiVan.getQuestion()+"</b>"+"\n\n"+"<p>Lösen: "+mLoiVan.getExplain().replace("Result:","")+"</p>"));
                    }
                }
                else
                {
                    if(mLoiVan.getExplain().equals("gta")||mLoiVan.getExplain().equals("giaithich"))
                    {
                        tv_question_moutain.setText(Html.fromHtml("<b>"+mLoiVan.getQuestion()+"</b>"+"\n\n"+"<p>Result: "+mLoiVan.getResult()+"</p>"));
                        // tv_question_moutain.setText(mLoiVan.getQuestion() + "\n\n" + getString(R.string.result)+" " + mLoiVan.getResult());
                    }else {
                        // tv_question_moutain.setText(mLoiVan.getQuestion() + "\n\n" + getString(R.string.resolve)+" " + mLoiVan.getExplain());
                        tv_question_moutain.setText(Html.fromHtml("<b>"+mLoiVan.getQuestion()+"</b>"+"\n\n"+"<p>Resolve: "+mLoiVan.getExplain().replace("Result:","")+"</p>"));
                    }
                }

            }else
            {

                    switch (mMountain.getTruecase())
                    {
                        case 1:
                            tv_A.setBackgroundResource(R.drawable.round_bt_item_true);
                            tv_A.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink));
                            break;
                        case 2:
                            tv_B.setBackgroundResource(R.drawable.round_bt_item_true);
                            tv_B.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink));
                            break;
                        case 3:
                            tv_C.setBackgroundResource(R.drawable.round_bt_item_true);
                            tv_C.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink));
                            break;
                        default:
                            tv_D.setBackgroundResource(R.drawable.round_bt_item_true);
                            tv_D.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink));
                            break;
                    }

                if(mMountain.getGiaithich().equals("gta")||mMountain.getGiaithich().equals("giaithich"))
                {



                    if(DeviceLang.equals("vi_vn"))
                    {
                        switch (mMountain.getTruecase())
                        {
                            case  1:
                                tv_question_moutain.setText(Html.fromHtml("<b>"+mMountain.getQuestion()+"</b>"+"\n\n"+"<p>Đáp số: "+mMountain.getCasea()+"</p>"));
                                break;
                            case  2:
                                tv_question_moutain.setText(Html.fromHtml("<b>"+mMountain.getQuestion()+"</b>"+"\n\n"+"<p>Đáp số: "+mMountain.getCaseb()+"</p>"));
                                break;
                            case  3:
                                tv_question_moutain.setText(Html.fromHtml("<b>"+mMountain.getQuestion()+"</b>"+"\n\n"+"<p>Đáp số: "+mMountain.getCasec()+"</p>"));
                                break;
                            case  4:
                                tv_question_moutain.setText(Html.fromHtml("<b>"+mMountain.getQuestion()+"</b>"+"\n\n"+"<p>Đáp số: "+mMountain.getCased()+"</p>"));
                                break;
                        }
                    }
                    else if(DeviceLang.equals("fr"))
                    {
                        switch (mMountain.getTruecase())
                        {
                            case  1:
                                tv_question_moutain.setText(Html.fromHtml("<b>"+mMountain.getQuestion()+"</b>"+"\n\n"+"<p>Résultat: "+mMountain.getCasea()+"</p>"));
                                break;
                            case  2:
                                tv_question_moutain.setText(Html.fromHtml("<b>"+mMountain.getQuestion()+"</b>"+"\n\n"+"<p>Résultat: "+mMountain.getCaseb()+"</p>"));
                                break;
                            case  3:
                                tv_question_moutain.setText(Html.fromHtml("<b>"+mMountain.getQuestion()+"</b>"+"\n\n"+"<p>Résultat: "+mMountain.getCasec()+"</p>"));
                                break;
                            case  4:
                                tv_question_moutain.setText(Html.fromHtml("<b>"+mMountain.getQuestion()+"</b>"+"\n\n"+"<p>Résultat: "+mMountain.getCased()+"</p>"));
                                break;
                        }
                    }
                    else if(DeviceLang.equals("de"))
                    {
                        switch (mMountain.getTruecase())
                        {
                            case  1:
                                tv_question_moutain.setText(Html.fromHtml("<b>"+mMountain.getQuestion()+"</b>"+"\n\n"+"<p>Ergebnis: "+mMountain.getCasea()+"</p>"));
                                break;
                            case  2:
                                tv_question_moutain.setText(Html.fromHtml("<b>"+mMountain.getQuestion()+"</b>"+"\n\n"+"<p>Ergebnis: "+mMountain.getCaseb()+"</p>"));
                                break;
                            case  3:
                                tv_question_moutain.setText(Html.fromHtml("<b>"+mMountain.getQuestion()+"</b>"+"\n\n"+"<p>Ergebnis: "+mMountain.getCasec()+"</p>"));
                                break;
                            case  4:
                                tv_question_moutain.setText(Html.fromHtml("<b>"+mMountain.getQuestion()+"</b>"+"\n\n"+"<p>Ergebnis: "+mMountain.getCased()+"</p>"));
                                break;
                        }
                    }
                    else
                    {
                        switch (mMountain.getTruecase())
                        {
                            case  1:
                                tv_question_moutain.setText(Html.fromHtml("<b>"+mMountain.getQuestion()+"</b>"+"\n\n"+"<p>Result: "+mMountain.getCasea()+"</p>"));
                                break;
                            case  2:
                                tv_question_moutain.setText(Html.fromHtml("<b>"+mMountain.getQuestion()+"</b>"+"\n\n"+"<p>Result: "+mMountain.getCaseb()+"</p>"));
                                break;
                            case  3:
                                tv_question_moutain.setText(Html.fromHtml("<b>"+mMountain.getQuestion()+"</b>"+"\n\n"+"<p>Result: "+mMountain.getCasec()+"</p>"));
                                break;
                            case  4:
                                tv_question_moutain.setText(Html.fromHtml("<b>"+mMountain.getQuestion()+"</b>"+"\n\n"+"<p>Result: "+mMountain.getCased()+"</p>"));
                                break;
                        }
                    }


                    // tv_question_moutain.setText(mLoiVan.getQuestion() + "\n\n" + getString(R.string.result)+" " + mLoiVan.getResult());
                }else {
                    // tv_question_moutain.setText(mLoiVan.getQuestion() + "\n\n" + getString(R.string.resolve)+" " + mLoiVan.getExplain());

                    if(DeviceLang.equals("vi_vn"))
                    {
                        tv_question_moutain.setText(Html.fromHtml("<b>"+mMountain.getQuestion()+"</b>"+"\n\n"+"<p>Đáp số: "+mMountain.getGiaithich()+"</p>"));
                    }
                    else    if(DeviceLang.equals("fr"))
                    {
                        tv_question_moutain.setText(Html.fromHtml("<b>"+mMountain.getQuestion()+"</b>"+"\n\n"+"<p>Résoudre: "+mMountain.getGiaithich().replace("Résultat:","")+"</p>"));
                    }
                     else    if(DeviceLang.equals("de"))
                    {
                        tv_question_moutain.setText(Html.fromHtml("<b>"+mMountain.getQuestion()+"</b>"+"\n\n"+"<p>Lösen: "+mMountain.getGiaithich().replace("Ergebnis:","")+"</p>"));
                    }
                      else
                    {
                        tv_question_moutain.setText(Html.fromHtml("<b>"+mMountain.getQuestion()+"</b>"+"\n\n"+"<p>Resolve: "+mMountain.getGiaithich().replace("Result:","")+"</p>"));
                    }

                }

            }

            if(mNext_False_Moutain>=3)
            {
                currentStatus=Status.GAME_OVER_MOUTAIN;
                mCdt_TimeGame.cancel();
            }
//            else
//            {
            iv_continue_moutain.setVisibility(View.VISIBLE);



            //}

        }
    };
    public void doDowloadLinkAvata() {

        Thread dataThread =
                new Thread(new Runnable() {
                    public void run() {
                        try {

                            StorageReference pStorageRef = FirebaseStorage.getInstance().getReference().child("link/avata.png");

                            File rootPath = new File(getApplicationContext().getFilesDir().getPath(), "avatalink");
                            if (!rootPath.exists()) {
                                rootPath.mkdirs();
                            }


                            final File localFile = new File(rootPath, "avata.png");

                            pStorageRef.getFile(localFile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                                @Override
                                public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {

                                    if (localFile.exists()) {
                                        if(mLinkAvata.trim().equals("")) {
                                            mLinkAvata = localFile.toString();
                                            editor.putString("link", localFile.toString());
                                            editor.commit();
                                        }

                                    }

                                    //  updateDb(timestamp,localFile.toString(),position);
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception exception) {
                                    //  Log.e("firebase ",";local tem file not created  created " +exception.toString());
                                    doDowloadLinkAvataAPI();
                                }
                            });
                        } catch (Exception ex) {

                        }
                    }
                });
        dataThread.start();

    }
    public void doDowloadLinkAvataAPI() {
        //Log.e("tuvi","kkk:"+mToDayNotifi);
        new Thread(new Runnable() {
            public void run() {
                try {
                    String fileURL = mFirebaseRemoteConfig.getString("http_domain_key")+"/link/avata.png";
                    //  String saveDir = getApplicationContext().getFilesDir().getPath()+"/database";

                    File rootPath = new File(getApplicationContext().getFilesDir().getPath(), "avatalink");
                    if(!rootPath.exists()) {
                        rootPath.mkdirs();
                    }


                    DownloadHtpps.downloadFile(fileURL, rootPath.toString(),"");

                    final File localFile = new File(rootPath,"avata.png");

                    mLinkAvata = localFile.toString();
                    editor.putString("link", localFile.toString());
                    editor.commit();


                } catch (IOException ex) {
                    //  ex.printStackTrace();
                }
            }
        }).start();
    }
    public void doDownloadQuestion(String pSoundQuestion)
    {
        final String soundQuestion=pSoundQuestion;
        // Db("firebase2:"+soundQuestion);
        Thread dataThread=
                new Thread(new Runnable() {
                    public void run() {
                        try {
                            StorageReference pStorageRef= FirebaseStorage.getInstance("gs://vioedu-toan-lop-1.appspot.com").getReference().child("sounds/"+ DeviceLang+"/grade"+mGrade+"/"+soundQuestion+".mp3");
                            File rootPath = new File(getApplicationContext().getFilesDir().getPath(), "sounds/"+ DeviceLang+"/grade"+mGrade);
                            if(!rootPath.exists()) {
                                rootPath.mkdirs();
                            }

                            if(MainActivity.mModeUrlQuestion_Math.trim().equals(""))
                            {
                                String tmpPath=rootPath.getPath();
                                int tmpIndex=tmpPath.lastIndexOf("/");
                                tmpPath=tmpPath.substring(0,tmpIndex);
                                MainActivity.mModeUrlQuestion_Math=tmpPath;

                                editor.putString("modeurl", MainActivity.mModeUrlQuestion_Math);
                                editor.commit();
                            }
                            //  Db("firebase1:"+MainActivity.mModeUrlQuestion_Math);

                            // Log.e("firebase ","11");
                            final File localFile = new File(rootPath,soundQuestion+".mp3");

                            pStorageRef.getFile(localFile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                                @Override
                                public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                                    // Log.e("firebase ",";thanh cong tao file:" +localFile.toString());
                                    if(localFile.exists())
                                    {
                                        //Log.e("firebase ","ton tai");
                                        // String myData=loadDataApp(new File(localFile.toString()));
                                        // Log.e("firebase ","==>"+localFile.toString());

                                    }else
                                    {
                                    }

                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception exception) {
                                    doDownloadQuestionAPI(soundQuestion);
                                }
                            });

                        } catch (Exception e) {

                        }
                    }
                });
        dataThread.start();
    }
    public void doDownloadQuestionAPI(String pSoundQuestion)
    {
        final String soundQuestion=pSoundQuestion;

        Thread dataThread=
                new Thread(new Runnable() {
                    public void run() {
                        try {
                            String fileURL = mFirebaseRemoteConfig.getString("http_domain_key")+"/sounds/"+ DeviceLang+"/grade"+mGrade+"/"+soundQuestion+".mp3";

                            File rootPath = new File(getApplicationContext().getFilesDir().getPath(), "sounds/"+ DeviceLang+"/grade"+mGrade);
                            if(!rootPath.exists()) {
                                rootPath.mkdirs();
                            }
                            DownloadHtpps.downloadFile(fileURL, rootPath.toString(),"");
                            if(MainActivity.mModeUrlQuestion_Math.trim().equals(""))
                            {
                                String tmpPath=rootPath.getPath();
                                int tmpIndex=tmpPath.lastIndexOf("/");
                                tmpPath=tmpPath.substring(0,tmpIndex);
                                MainActivity.mModeUrlQuestion_Math=tmpPath;

                                editor.putString("modeurl", MainActivity.mModeUrlQuestion_Math);
                                editor.commit();
                            }

                        } catch (Exception e) {

                        }
                    }
                });
        dataThread.start();

    }

    public void onClickMoutainContinue(View view) {
        try {
            doPlayClick();
            if (mNext_False_Moutain >= 3) {

                handler.postDelayed(timer_GameOver_Moutain, player.getDuration() + 1);
            } else {

                handler.postDelayed(timerRadomMotain, 100);
            }
        }catch (Exception exception)
        {

        }
    }
    public  void onClickReportQuestion(View view)
    {
        try {
            clsHandleT.showDialogReport(MainActivity.this);
            clsHandleT.doPlaySoundAssets("khieulai.mp3",DeviceLang, player, false, MainActivity.this);

        }catch (Exception exception)
        {

        }
    }
    public void doSendReport(String pReport)
    {
        try {
            String tmKeyCap = mDatabase.child("question").push().getKey();
            mDatabase.child("question").child("lop"+mGrade).child("cau"+mLoiVan.getId()).child(tmKeyCap).setValue("=>"+mLoiVan.getResult()+"=>"+pReport+" : "+mLoiVan.getQuestion());
            Toast.makeText(this,"Khiếu lại đã được gửi đi để xem xét !",Toast.LENGTH_SHORT).show();
            tv_report.setVisibility(View.GONE);
            doPlayClick();
        }catch (Exception exception)
        {

        }

    }

    public void doNextAvataMotain()
    {
        iv_avata_moutain0.setVisibility(View.GONE);
        iv_avata_moutain1.setVisibility(View.GONE);
        iv_avata_moutain2.setVisibility(View.GONE);
        iv_avata_moutain3.setVisibility(View.GONE);
        iv_avata_moutain4.setVisibility(View.GONE);
        iv_avata_moutain5.setVisibility(View.GONE);
        iv_avata_moutain6.setVisibility(View.GONE);
        iv_avata_moutain7.setVisibility(View.GONE);
        iv_avata_moutain8.setVisibility(View.GONE);
        iv_avata_moutain9.setVisibility(View.GONE);
        iv_avata_moutain10.setVisibility(View.GONE);
        if(mScore_Moutain>0&&mScore_Moutain<=10)
        {
            iv_avata_moutain1.setVisibility(View.VISIBLE);
        }else  if(mScore_Moutain>11&&mScore_Moutain<=20)
        {
            iv_avata_moutain2.setVisibility(View.VISIBLE);
        }else  if(mScore_Moutain>21&&mScore_Moutain<=30)
        {
            iv_avata_moutain3.setVisibility(View.VISIBLE);
        }else  if(mScore_Moutain>31&&mScore_Moutain<=40)
        {
            iv_avata_moutain4.setVisibility(View.VISIBLE);
        }else  if(mScore_Moutain>41&&mScore_Moutain<=50)
        {
            iv_avata_moutain5.setVisibility(View.VISIBLE);
        }else  if(mScore_Moutain>51&&mScore_Moutain<=60)
        {
            iv_avata_moutain6.setVisibility(View.VISIBLE);
        }else  if(mScore_Moutain>61&&mScore_Moutain<=70)
        {
            iv_avata_moutain7.setVisibility(View.VISIBLE);
        }else  if(mScore_Moutain>71&&mScore_Moutain<=80)
        {
            iv_avata_moutain8.setVisibility(View.VISIBLE);
        }else  if(mScore_Moutain>81&&mScore_Moutain<=90)
        {
            iv_avata_moutain9.setVisibility(View.VISIBLE);
        }else  if(mScore_Moutain>91&&mScore_Moutain<=100)
        {
            iv_avata_moutain10.setVisibility(View.VISIBLE);
        }else
        {
            iv_avata_moutain0.setVisibility(View.VISIBLE);
        }

    }
    public void onClickBt0(View view)
    {
        view.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.scala_animation));
        doInputNumber("0");
    }
    public void onClickBt1(View view)
    {
        view.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.scala_animation));
        doInputNumber("1");
    }
    public void onClickBt2(View view)
    {
        view.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.scala_animation));
        doInputNumber("2");
    }
    public void onClickBt3(View view)
    {
        view.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.scala_animation));
        doInputNumber("3");
    }
    public void onClickBt4(View view)
    {
        view.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.scala_animation));
        doInputNumber("4");
    }
    public void onClickBt5(View view)
    {
        view.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.scala_animation));
        doInputNumber("5");
    }
    public void onClickBt6(View view)
    {
        view.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.scala_animation));
        doInputNumber("6");
    }
    public void onClickBt7(View view)
    {
        view.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.scala_animation));
        doInputNumber("7");
    }
    public void onClickBt8(View view)
    {
        view.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.scala_animation));
        doInputNumber("8");
    }
    public void onClickBt9(View view)
    {
        view.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.scala_animation));
        doInputNumber("9");
    }
    public void onClickBtB(View view)
    {
        view.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.scala_animation));
        doInputNumber("b");
    }
    public void onClickBtD(View view)
    {
        view.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.scala_animation));
        doInputNumber("d");
    }
    public void doInputNumber(String pNumber)
    {
        try {
            if(currentStatus==Status.MOUTAIN) {
                if (pNumber.equals("d")) {
                    mResultMoutain = "0";
                    clsHandleT.doPlaySoundAssets("chamnuoc.ogg","", player, false, MainActivity.this);
                } else if (pNumber.equals("b")) {
                    if (mResultMoutain.length()>1) {
                        mResultMoutain = mResultMoutain.substring(0, mResultMoutain.length() - 1);
                        clsHandleT.doPlaySoundAssets("chamnuoc.ogg","", player, false, MainActivity.this);
                    }else
                    {
                        mResultMoutain = "0";
                        clsHandleT.doPlaySoundAssets("over.mp3","", player, false, this);
                    }
                } else {
                    clsHandleT.doPlaySoundAssets("chamnuoc.ogg","", player, false, MainActivity.this);
                    if(mResultMoutain.length()<9) {

                        if(mResultMoutain.equals("0"))
                        {
                            mResultMoutain = pNumber;
                        }else
                        {
                            if(mResultMoutain.startsWith("0"))
                            {
                                mResultMoutain=mResultMoutain.substring(0,1)+pNumber;
                            }else {
                                mResultMoutain += pNumber;
                            }
                        }

                    }
                }
                tv_result_moutain.setText(mResultMoutain);
            }
        }catch (Exception exception)
        {

        }
    }
    public void onClickContinueGameOverMoutain(View view)
    {
        try {
            doPlayClick();
            view.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shake));
            handler.postDelayed(timer_Game_Over_Moutain,950);
        }catch (Exception exception)
        {

        }
    }
    Runnable timer_Game_Over_Moutain= new Runnable() {
        @Override
        public void run() {
            doStartMonkey();
        }
    };

    public void onClickPlayMoutain(View view)
    {
        try {
            doPlayClick();
            view.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shake));
            handler.postDelayed(timer_Click_Play_Moutain,950);
        }catch (Exception exception)
        {

        }
    }
    Runnable timer_Click_Play_Moutain= new Runnable() {
        @Override
        public void run() {
            //clsHandleT.doPlaySoundUrlLocal(mModeUrlQuestion + "/grade" + mGrade + "/" + mLoiVan.getId() + ".mp3",player,MainActivity.this);
          try {
              if(DeviceLang.equals("vi_vn")) {
//                  if (clsHandleT.doCheckExistFile(mModeUrlQuestion_Math + "/grade" + mGrade + "/" + mLoiVan.getId() + ".mp3")) {
//                      clsHandleT.doPlaySoundUrlLocal(mModeUrlQuestion_Math + "/grade" + mGrade + "/" + mLoiVan.getId() + ".mp3", player, MainActivity.this);
//                  } else if (clsHandleT.isAssetExists(MainActivity.this, "sounds/grade" + mGrade + "/" + mLoiVan.getId() + ".mp3")) {
//                      clsHandleT.doPlaySoundAssets(mLoiVan.getId() + ".mp3", "grade" + mGrade, player, false, MainActivity.this);
//                  }
                  viewFlipperMath.setDisplayedChild(10);

                  tv_result_moutain.setVisibility(View.VISIBLE);
                  iv_sumit_moutain.setVisibility(View.VISIBLE);
                  ll_number_moutain.setVisibility(View.VISIBLE);
                  tv_A.setVisibility(View.GONE);
                  tv_B.setVisibility(View.GONE);
                  tv_C.setVisibility(View.GONE);
                  tv_D.setVisibility(View.GONE);

                  doRandomMoutain();
                  doRunTimeInGame(mFirtTime*1000,tv_time_ingame_moutain,3);
              }else
              {
                  viewFlipperMath.setDisplayedChild(10);

                  tv_result_moutain.setVisibility(View.GONE);
                  iv_sumit_moutain.setVisibility(View.GONE);
                  ll_number_moutain.setVisibility(View.GONE);
                  tv_A.setVisibility(View.VISIBLE);
                  tv_B.setVisibility(View.VISIBLE);
                  tv_C.setVisibility(View.VISIBLE);
                  tv_D.setVisibility(View.VISIBLE);
                  doRandomMoutain_Select();
                  doRunTimeInGame(mFirtTime*1000,tv_time_ingame_moutain,4);

              }
          }catch (Exception e)
          {

          }

        }
    };

    //endregion

    //region Moutain_Select

    void doStartMoutain_Select()
    {

        try {
            Collections.shuffle(lstMountainLevel);
            doResetMoutain();
//            doRandomMoutain();
//
//            doRunTimeInGame(mFirtTime*1000,tv_time_ingame_moutain,3);
        }catch (Exception exception)
        {

        }

        try {
            viewFlipperMath.setDisplayedChild(9);

            clsHandleT.doPlaySoundAssets("win.mp3", "", player, false, MainActivity.this);
            if(mGrade>3)
            {
                try {
                    rl_question_moutain.setBackgroundResource(R.drawable.round_layout_moutain);
                }catch (Exception ex)
                {

                }


            }else {
                try {
                    rl_question_moutain.setBackgroundResource(R.drawable.bg_question_moutain);
                }catch (Exception ex)
                {

                }

            }
        }catch (Exception exception)
        {

        }
    }

    public void doRandomMoutain_Select()
    {
        try {
            mChonGenary=rd.nextInt(lstMountainLevel.size());

            mMountain=lstMountainLevel.get(mChonGenary);
            rl_question_moutain.setVisibility(View.VISIBLE);

            tv_A.setVisibility(View.VISIBLE);
            tv_B.setVisibility(View.VISIBLE);
            tv_C.setVisibility(View.VISIBLE);
            tv_D.setVisibility(View.VISIBLE);


            tv_A.setBackgroundResource(R.drawable.round_bt_item);
            tv_B.setBackgroundResource(R.drawable.round_bt_item);
            tv_C.setBackgroundResource(R.drawable.round_bt_item);
            tv_D.setBackgroundResource(R.drawable.round_bt_item);
            //tv_question_moutain.setText(mLoiVan.getQuestion());
            tv_question_moutain.setText(Html.fromHtml("<b>"+mMountain.getQuestion()+"</b>"));
            tv_A.setText(mMountain.getCasea());
            tv_B.setText(mMountain.getCaseb());
            tv_C.setText(mMountain.getCasec());
            tv_D.setText(mMountain.getCased());
            try {
                iv_monkey_moutain.setImageResource(R.drawable.monkey_question);
            }catch (Exception e)
            {

            }


            iv_continue_moutain.setVisibility(View.GONE);
            tv_report.setVisibility(View.GONE);



            currentStatus=Status.MOUTAIN_SELECT;
            tv_question_moutain.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.scala_animation_question));

            tv_A.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.innext));
            tv_C.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.innext));
            tv_B.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.inback));
            tv_D.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.inback));

           // clsHandleT.Loge("ket qua:"+mMountain.getTruecase());

            //rl_question_moutain.startAnimation(aniZoomQuestion);
        }catch (Exception exception)
        {

        }
    }
    public void doInputNumber(int pSelect) {
        try {
            if (currentStatus == Status.MOUTAIN_SELECT) {
                currentStatus = Status.MOUTAIN_SELECT_LOCK;
                clsHandleT.doPlaySoundAssets("select_ans.ogg","", player, false, MainActivity.this);
                iv_monkey_moutain.setImageResource(R.drawable.monkey_answer);
                switch (pSelect)
                {
                    case 1:
                        tv_A.setBackgroundResource(R.drawable.round_bt_item_select);
                        break;
                    case 2:
                        tv_B.setBackgroundResource(R.drawable.round_bt_item_select);
                        break;
                    case 3:
                        tv_C.setBackgroundResource(R.drawable.round_bt_item_select);
                        break;
                    case 4:
                        tv_D.setBackgroundResource(R.drawable.round_bt_item_select);
                        break;

                }

                if(pSelect==mMountain.getTruecase())
                {
                    handler.postDelayed(timerProcessMouTainTrue, 1000);
                }else
                {
                    handler.postDelayed(timerProcessMoutainFasle, 1000);
                }

            }
        } catch (Exception e) {

        }

    }

    Runnable timerDelayMoutainUpSelect= new Runnable() {
        @Override
        public void run() {

            rl_question_moutain.setVisibility(View.GONE);
            tv_A.setVisibility(View.GONE);
            tv_B.setVisibility(View.GONE);
            tv_C.setVisibility(View.GONE);
            tv_D.setVisibility(View.GONE);
            handler.postDelayed(timerProcessMoutainNextUp, 1100);

        }
    };
    public  void OnClickBtA(View view)
    {
        doInputNumber(1);
    }
    public  void OnClickBtB(View view)
    {
        doInputNumber(2);
    }
    public  void OnClickBtC(View view)
    {
        doInputNumber(3);
    }
    public  void OnClickBtD(View view)
    {
        doInputNumber(4);
    }

    //endregion

    //region MONKEY

    public void onClickPlayMonkey(View view)
    {
        try {
            doPlayClick();
            view.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shake));
            handler.postDelayed(timer_Click_Play_Monkey,950);
        }catch (Exception exception)
        {

        }
    }
    Runnable timer_Click_Play_Monkey= new Runnable() {
        @Override
        public void run() {
            viewFlipperMath.setDisplayedChild(7);
            la_tap_swipe.setVisibility(View.VISIBLE);
            handler.postDelayed(timerHideSwipe,5000);

        }
    };

    Runnable timerHideSwipe = new Runnable() {
        @Override
        public void run() {
            la_tap_swipe.setVisibility(View.GONE);
        }
    };
    void doStartMonkey()
    {
        try {
            doLoadSugetMonkey();
            viewFlipperMath.setDisplayedChild(6);
            clsHandleT.doPlaySoundAssets("start_monkey.mp3",DeviceLang, player, false, MainActivity.this);
            adapterMonkey =new AdapterFrame(getSupportFragmentManager(),this);
            adapterMonkey.setmCount(10);

            viewpagerMonkey.setAdapter(null);
            viewpagerMonkey.setAdapter(adapterMonkey);
            viewpagerMonkey.setCurrentItem(0);
            viewpagerMonkey.getAdapter().notifyDataSetChanged();

            doResetMonkey();
            doRandomMonkey();
            doRunTimeInGame(mFirtTime*1000,tv_time_ingame_monkey,2);
        }catch (Exception exception)
        {

        }

    }
    public void doResetMonkey()
    {
        mScore_MonKey=0;
        mNext_False_Monkey=0;
        mFirtTime=1200;
        lstSelectedMonkey=new ArrayList<Integer>();
        lstSelectedObjectMonkey=new PhepToan[10];
        try {
            iv_false_monkey.setImageResource(R.drawable.bamau);
        }catch (Exception e)
        {

        }



        if(DeviceLang.equals("vi_vn"))
        {

            tv_score_monkey.setText("Điểm: 00");

        }
        else   if(DeviceLang.equals("fr"))
        {
            tv_score_monkey.setText("Score: 00");
        }
        else   if(DeviceLang.equals("de"))
        {
            tv_score_monkey.setText("Punktzahl: 00");
        }
        else
        {
            tv_score_monkey.setText("Score: 00");
        }

        tv_time_ingame_monkey.setText("⏰ ");
    }
    void doRandomMonkey()
    {
        try {
            currentStatus=Status.MONKEY;
            mChonGenary=rd.nextInt(lstPhepToanLevel10_2.size());
            mMonkeyPhepToan=lstPhepToanLevel10_2.get(mChonGenary);
            rl_monkey_avata_pheptoan_bg.setVisibility(View.VISIBLE);
            try {
                iv_avata_monkey.setImageResource(R.drawable.khihoi);
            }catch (Exception e)
            {

            }
            setPhepToanMonkey(lstPhepToanLevel10_2.get(mChonGenary));
        }catch (Exception exception)
        {

        }
    }
    public Integer doSeclecMonkey(double pSelect,int pPosition)
    {
        if(currentStatus==Status.MONKEY && doCheckExitsSelectedMonkey(pPosition)==false)
        {
            currentStatus=Status.MONKEY_CLICK;
            try {
                iv_avata_monkey.setImageResource(R.drawable.khixet);
            }catch (Exception exception)
            {

            }

            if(mMonkeyPhepToan.getKetqua()==pSelect)
            {
                lstSelectedMonkey.add(pPosition);
                lstSelectedObjectMonkey[pPosition]=lstPhepToanLevel10_2.get(mChonGenary);
                lstPhepToanLevel10_2.remove(mChonGenary);
                handler.postDelayed(timerProcessMonkeyTrue, 1100);
                return 1;
            }else
            {
                handler.postDelayed(timerProcessMonkeyFasle, 1000);
                return 2;
            }
        }
        clsHandleT.doPlaySoundAssets("over.mp3","", player, false, MainActivity.this);
        return 0;
    }
    Runnable timerProcessMonkeyTrue = new Runnable() {
        @Override
        public void run() {
            clsHandleT.doPlaySoundAssets("guess_true.ogg","", player, false, MainActivity.this);
            la_firework_monkey.playAnimation();
            handler.postDelayed(timer_True_MediaPlay,player.getDuration());
            try {
                iv_avata_monkey.setImageResource(R.drawable.khicuoi);
            }catch (Exception e)
            {

            }
            rl_monkey_avata_pheptoan_bg.setVisibility(View.GONE);
            iv_avata_monkey.setAnimation(anim_tbmonkey);
            mScore_MonKey=mScore_MonKey+10;



            if(DeviceLang.equals("vi_vn"))
            {

                tv_score_monkey.setText("Điểm: "+mScore_MonKey);

            }
            else   if(DeviceLang.equals("fr"))
            {
                tv_score_monkey.setText("Score: "+mScore_MonKey);
            }
            else   if(DeviceLang.equals("de"))
            {
                tv_score_monkey.setText("Punktzahl: "+mScore_MonKey);
            }
            else
            {
                tv_score_monkey.setText("Score: "+mScore_MonKey);
            }

            if(mScore_MonKey>91)
            {
                handler.postDelayed(timer_GameOver_Monkey, 1500);
            }else {
                handler.postDelayed(timerRadomMonkey, 1700);
            }
        }
    };
    Runnable timerProcessMonkeyFasle = new Runnable() {
        @Override
        public void run() {

            if(DeviceLang.equals("vi_vn")) {

                clsHandleT.doPlaySoundAssets("sai" + (rd.nextInt(5) + 1) + ".mp3", DeviceLang, player, false, MainActivity.this);
            }else
            {
                clsHandleT.doPlaySoundAssets("over.mp3","", player, false, MainActivity.this);
            }
            //handler.postDelayed(timer_False_MediaPlay,player.getDuration()+20);
            mNext_False_Monkey++;
            rl_monkey_avata_pheptoan_bg.setVisibility(View.GONE);

            try {
                iv_avata_monkey.setImageResource(R.drawable.khikhoc);
                if(mNext_False_Monkey==1)
                {
                    iv_false_monkey.setImageResource(R.drawable.haimau);
                }else  if(mNext_False_Monkey==2)
                {
                    iv_false_monkey.setImageResource(R.drawable.motmau);
                }else
                {
                    iv_false_monkey.setImageResource(R.drawable.khongmau);
                }
            }catch (Exception e)
            {

            }

            if(mScore_MonKey>5)
            {
                mScore_MonKey--;


                if(DeviceLang.equals("vi_vn"))
                {

                    tv_score_monkey.setText("Điểm: "+mScore_MonKey);

                }
                else   if(DeviceLang.equals("fr"))
                {
                    tv_score_monkey.setText("Score: "+mScore_MonKey);
                }
                else   if(DeviceLang.equals("de"))
                {
                    tv_score_monkey.setText("Punktzahl: "+mScore_MonKey);
                }
                else
                {
                    tv_score_monkey.setText("Score: "+mScore_MonKey);
                }
            }
            if(mNext_False_Monkey>=3)
            {
                handler.postDelayed(timer_GameOver_Monkey, player.getDuration()+500);
            }
            else
            {
                handler.postDelayed(timerRadomMonkey, 1700);
            }
        }
    };
    Runnable timer_GameOver_Monkey= new Runnable() {
        @Override
        public void run() {
            handler.removeCallbacksAndMessages(null);
            currentStatus=Status.GAME_OVER_MONKEY;



            if(DeviceLang.equals("vi_vn"))
            {

                tv_score_monkey_gameover.setText("Điểm: "+mScore_MonKey);

            }
            else   if(DeviceLang.equals("fr"))
            {
                tv_score_monkey_gameover.setText("Score: "+mScore_MonKey);
            }
            else   if(DeviceLang.equals("de"))
            {
                tv_score_monkey_gameover.setText("Punktzahl: "+mScore_MonKey);
            }
            else
            {
                tv_score_monkey_gameover.setText("Score: "+mScore_MonKey);
            }


            try {
                if(mNext_False_Monkey==1)
                {
                    iv_flase_monkey_gameover.setImageResource(R.drawable.haimau);

                }else  if(mNext_False_Monkey==2)
                {

                    iv_flase_monkey_gameover.setImageResource(R.drawable.motmau);
                }else if(mNext_False_Monkey==3)
                {

                    iv_flase_monkey_gameover.setImageResource(R.drawable.khongmau);
                }else
                {

                    iv_flase_monkey_gameover.setImageResource(R.drawable.bamau);
                }
            }catch (Exception e)
            {

            }
            viewFlipperMath.setDisplayedChild(8);
            mCdt_TimeGame.cancel();
        }
    };

    Runnable timerRadomMonkey= new Runnable() {
        @Override
        public void run() {
            doRandomMonkey();
        }
    };
    private Boolean doCheckExitsSelectedMonkey(int pPosition)
    {
        for (int i=0;i<lstSelectedMonkey.size();i++)
        {
            if(lstSelectedMonkey.get(i)==pPosition)
            {
                return true;
            }
        }
        return false;
    }


    void doLoadSugetMonkey()
    {
        try {
            lstPhepToanLevelTMP=lstPhepToanLevel;
            Collections.shuffle(lstPhepToanLevelTMP);
            lstPhepToanLevel10_1 = new ArrayList<PhepToan>();
            lstPhepToanLevel10_2 = new ArrayList<PhepToan>();



            while (lstPhepToanLevel10_1.size() < 10) {
                mTmpPhepToan1 = new PhepToan();
                mChon = rd.nextInt(lstPhepToanLevelTMP.size());

                mTmpPhepToan1 = lstPhepToanLevelTMP.get(mChon);



                mTmpPhepToan2 = new PhepToan();
                mCheckCongThuc = true;
                if ((mGrade == 2 && mTmpPhepToan1.getLevel() == 10)||
                        (mGrade == 3 && mTmpPhepToan1.getLevel() == 14)||
                        (mGrade == 3 && mTmpPhepToan1.getLevel() == 15)||
                        (mGrade == 5 && mTmpPhepToan1.getLevel() == 5)) {

                    lstPhepToanLevelTMP.remove(mChon);
                    for (int i = 0; i < lstPhepToanLevelTMP.size(); i++) {
                        if (mTmpPhepToan1.getKetqua() == lstPhepToanLevelTMP.get(i).getKetqua()) {
                            mTmpPhepToan2 = lstPhepToanLevelTMP.get(i);
                            mCheckCongThuc = false;
                            break;
                        }
                    }
                    if (mCheckCongThuc) {
                        if(mGrade == 2 && mTmpPhepToan1.getLevel() == 10) {
                            mTmpPhepToan2.setCongthuc(mTmpPhepToan1.getTamcongthuc() + "cm");
                        }
                        if (mGrade == 3 && mTmpPhepToan1.getLevel() == 14)
                        {
                            mTmpPhepToan2.setCongthuc(mTmpPhepToan1.getTamcongthuc() + " mm");
                        }
                        if (mGrade == 3 && mTmpPhepToan1.getLevel() == 15)
                        {
                            mTmpPhepToan2.setCongthuc(mTmpPhepToan1.getTamcongthuc() + " m");
                        }
                        if (mGrade == 5 && mTmpPhepToan1.getLevel() == 5)
                        {
                            mTmpPhepToan2.setCongthuc(mTmpPhepToan1.getTamcongthuc() + " mm");
                        }
                        mTmpPhepToan2.setKetqua(mTmpPhepToan1.getKetqua());
                    }


                } else {
                    if (mChon % 2 == 0 &&mGrade>1) {
                        lstPhepToanLevelTMP.remove(mChon);
                        for (int i = 0; i < lstPhepToanLevelTMP.size(); i++) {
                            if (mTmpPhepToan1.getKetqua() == lstPhepToanLevelTMP.get(i).getKetqua()) {
                                mTmpPhepToan2 = lstPhepToanLevelTMP.get(i);
                                mCheckCongThuc = false;
                                break;
                            }
                        }
                        if (mCheckCongThuc) {
                            mTmpPhepToan2.setCongthuc("" + mTmpPhepToan1.getTamcongthuc());
                            mTmpPhepToan2.setKetqua(mTmpPhepToan1.getKetqua());
                        }

                    } else {
                        mTmpPhepToan2.setCongthuc("" + lstPhepToanLevelTMP.get(mChon).getTamcongthuc());
                        mTmpPhepToan2.setKetqua(lstPhepToanLevelTMP.get(mChon).getKetqua());
                        lstPhepToanLevelTMP.remove(mChon);
                    }
                }
                if(rd.nextInt(6)%2==0)
                {
                    lstPhepToanLevel10_1.add(mTmpPhepToan1);
                    lstPhepToanLevel10_2.add(mTmpPhepToan2);
                }else
                {
                    lstPhepToanLevel10_1.add(mTmpPhepToan2);
                    lstPhepToanLevel10_2.add(mTmpPhepToan1);
                }

            }
            Collections.shuffle(lstPhepToanLevel10_1);
            Collections.shuffle(lstPhepToanLevel10_2);
        }catch (Exception exception)
        {

        }
    }
    public void setPhepToanMonkey(PhepToan pPhepToan)
    {
        try {
            tv_monkey_avata_pheptoan.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
            tv_monkey_avata_pheptoan.setText("");
            tv_monkey_avata_phantram_ps.setText("");
            tv_monkey_avata_tuso_phantram.setText("");
            tv_monkey_avata_mauso_phantram.setText("");
            tv_monkey_avata_cua_ps1.setText("");
            tv_monkey_avata_tuso_cua1.setText("");
            tv_monkey_avata_mauso_cua1.setText("");
            tv_monkey_avata_tuso_cua2.setText("");
            tv_monkey_avata_mauso_cua2.setText("");
            tv_monkey_avata_pheptoan_hs.setText("");
            tv_monkey_avata_hs1.setText("");
            tv_monkey_avata_tuso_hs1.setText("");
            tv_monkey_avata_mauso_hs1.setText("");
            tv_monkey_avata_hs2.setText("");
            tv_monkey_avata_tuso_hs2.setText("");
            tv_monkey_avata_mauso_hs2.setText("");
            tv_monkey_avata_cua_ps2.setText("");
            tv_monkey_avata_tuso_cua3.setText("");
            tv_monkey_avata_mauso_cua3.setText("");

            if(pPhepToan.getKetqua()<0)
            {
                if(pPhepToan.getKetqua()==-1)
                {
                    if(pPhepToan.getCongthuc().equals("tron"))
                    {
                        // rl_monkey_avata_pheptoan_bg.setBackgroundResource(R.drawable.hinhtron);
                        Picasso.get().load(R.drawable.hinhtron)
                                .placeholder(R.drawable.hinhtron)
                                .error(R.drawable.hinhtron)
                                .transform(new RoundedTransformation(0, 0))
                                .fit().centerCrop()
                                .into(iv_monkey_avata_pheptoan_bg);
                    }else {
                        tv_monkey_avata_pheptoan.setText(pPhepToan.getCongthuc());
                    }
                }
                if(pPhepToan.getKetqua()==-2)
                {
                    if(pPhepToan.getCongthuc().equals("vuong"))
                    {
                        // rl_monkey_avata_pheptoan_bg.setBackgroundResource(R.drawable.hinhvuong);
                        Picasso.get().load(R.drawable.hinhvuong)
                                .placeholder(R.drawable.hinhvuong)
                                .error(R.drawable.hinhvuong)
                                .transform(new RoundedTransformation(0, 0))
                                .fit().centerCrop()
                                .into(iv_monkey_avata_pheptoan_bg);
                    }else {
                        tv_monkey_avata_pheptoan.setText(pPhepToan.getCongthuc());
                    }
                }
                if(pPhepToan.getKetqua()==-3)
                {
                    if(pPhepToan.getCongthuc().equals("tamgiac"))
                    {
                        // rl_monkey_avata_pheptoan_bg.setBackgroundResource(R.drawable.hinhtamgiac);
                        Picasso.get().load(R.drawable.hinhtamgiac)
                                .placeholder(R.drawable.hinhtamgiac)
                                .error(R.drawable.hinhtamgiac)
                                .transform(new RoundedTransformation(0, 0))
                                .fit().centerCrop()
                                .into(iv_monkey_avata_pheptoan_bg);
                    }else {
                        tv_monkey_avata_pheptoan.setText(pPhepToan.getCongthuc());
                    }
                }
                if(pPhepToan.getKetqua()==-5)
                {
                    if(pPhepToan.getCongthuc().equals("chunhat"))
                    {
                        //rl_monkey_avata_pheptoan_bg.setBackgroundResource(R.drawable.hinhchunhat);
                        Picasso.get().load(R.drawable.hinhchunhat)
                                .placeholder(R.drawable.hinhchunhat)
                                .error(R.drawable.hinhchunhat)
                                .transform(new RoundedTransformation(0, 0))
                                .fit().centerCrop()
                                .into(iv_monkey_avata_pheptoan_bg);
                    }else {
                        tv_monkey_avata_pheptoan.setText(pPhepToan.getCongthuc());
                    }
                }
                if(pPhepToan.getKetqua()==-6)
                {
                    if(pPhepToan.getCongthuc().equals("ngugiac"))
                    {
                        //  rl_monkey_avata_pheptoan_bg.setBackgroundResource(R.drawable.hinhngugiac);
                        Picasso.get().load(R.drawable.hinhngugiac)
                                .placeholder(R.drawable.hinhngugiac)
                                .error(R.drawable.hinhngugiac)
                                .transform(new RoundedTransformation(0, 0))
                                .fit().centerCrop()
                                .into(iv_monkey_avata_pheptoan_bg);
                    }else {
                        tv_monkey_avata_pheptoan.setText(pPhepToan.getCongthuc());
                    }
                }
                if(pPhepToan.getKetqua()==-7)
                {
                    if(pPhepToan.getCongthuc().equals("lucgiac"))
                    {
                        //rl_monkey_avata_pheptoan_bg.setBackgroundResource(R.drawable.hinhlucgiac);
                        Picasso.get().load(R.drawable.hinhlucgiac)
                                .placeholder(R.drawable.hinhlucgiac)
                                .error(R.drawable.hinhlucgiac)
                                .transform(new RoundedTransformation(0, 0))
                                .fit().centerCrop()
                                .into(iv_monkey_avata_pheptoan_bg);
                    }else {
                        tv_monkey_avata_pheptoan.setText(pPhepToan.getCongthuc());
                    }
                }
            }else {

                tv_monkey_avata_tuso_cua3.setPaintFlags(tv_monkey_avata_tuso_cua3.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
                tv_monkey_avata_tuso_hs1.setPaintFlags(tv_monkey_avata_tuso_hs1.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
                tv_monkey_avata_tuso_hs2.setPaintFlags(tv_monkey_avata_tuso_hs2.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
                tv_monkey_avata_tuso_cua2.setPaintFlags(tv_monkey_avata_tuso_cua2.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
                tv_monkey_avata_tuso_cua1.setPaintFlags(tv_monkey_avata_tuso_cua1.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
                tv_monkey_avata_tuso_phantram.setPaintFlags(tv_monkey_avata_tuso_phantram.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

                if (pPhepToan.getCongthuc().contains("%c")) {
                    if (pPhepToan.getCongthuc().contains("/")) {
                        tv_monkey_avata_phantram_ps.setText(pPhepToan.getCongthuc().substring(0, pPhepToan.getCongthuc().indexOf("c")) + " của");
                        tv_monkey_avata_tuso_phantram.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("c") + 1, pPhepToan.getCongthuc().indexOf("/")));
                        tv_monkey_avata_mauso_phantram.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/") + 1));
                    } else {
                        tv_monkey_avata_pheptoan.setText(pPhepToan.getCongthuc().replaceAll("c", " của "));
                    }
                } else if (pPhepToan.getCongthuc().contains("c")) {

                    try {
                        if (pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("c") + 1).contains("/")) {
                            tv_monkey_avata_tuso_cua1.setText(pPhepToan.getCongthuc().substring(0, pPhepToan.getCongthuc().indexOf("/")));
                            tv_monkey_avata_mauso_cua1.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/") + 1, pPhepToan.getCongthuc().indexOf("c")));
                            tv_monkey_avata_cua_ps1.setText(" của ");
                            tv_monkey_avata_tuso_cua2.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("c") + 1, pPhepToan.getCongthuc().indexOf("/", pPhepToan.getCongthuc().indexOf("/") + 1)));
                            tv_monkey_avata_mauso_cua2.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/", pPhepToan.getCongthuc().indexOf("/") + 1) + 1));

                        } else {
                            tv_monkey_avata_tuso_cua1.setText(pPhepToan.getCongthuc().substring(0, pPhepToan.getCongthuc().indexOf("/")));
                            tv_monkey_avata_mauso_cua1.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/") + 1, pPhepToan.getCongthuc().indexOf("c")));
                            tv_monkey_avata_cua_ps1.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("c")).replaceAll("c", " của "));

                        }
                    }catch (Exception e)
                    {
                        tv_monkey_avata_tuso_cua1.setText("");
                        tv_monkey_avata_mauso_cua1.setText("");
                        tv_monkey_avata_cua_ps1.setText("");
                        tv_monkey_avata_tuso_cua2.setText("");
                        tv_monkey_avata_mauso_cua2.setText("");

                        tv_monkey_avata_pheptoan.setText(pPhepToan.getCongthuc());
                        if(pPhepToan.getCongthuc().length()<=8)
                        {
                            tv_monkey_avata_pheptoan.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
                        }
                    }


                } else if (pPhepToan.getCongthuc().contains("]") && (pPhepToan.getCongthuc().contains("+") || pPhepToan.getCongthuc().contains("-") || pPhepToan.getCongthuc().contains("x") || pPhepToan.getCongthuc().contains(":"))) {
                    if (pPhepToan.getCongthuc().contains("x")) {
                        tv_monkey_avata_pheptoan_hs.setText(" x ");
                        tv_monkey_avata_mauso_hs1.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/") + 1, pPhepToan.getCongthuc().indexOf("x")));
                        tv_monkey_avata_hs2.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("x") + 1, pPhepToan.getCongthuc().indexOf("]", pPhepToan.getCongthuc().indexOf("]") + 1)));
                    }
                    if (pPhepToan.getCongthuc().contains(":")) {
                        tv_monkey_avata_pheptoan_hs.setText(" : ");
                        tv_monkey_avata_mauso_hs1.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/") + 1, pPhepToan.getCongthuc().indexOf(":")));
                        tv_monkey_avata_hs2.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf(":") + 1, pPhepToan.getCongthuc().indexOf("]", pPhepToan.getCongthuc().indexOf("]") + 1)));
                    }
                    if (pPhepToan.getCongthuc().contains("+")) {
                        tv_monkey_avata_pheptoan_hs.setText(" + ");
                        tv_monkey_avata_mauso_hs1.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/") + 1, pPhepToan.getCongthuc().indexOf("+")));
                        tv_monkey_avata_hs2.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("+") + 1, pPhepToan.getCongthuc().indexOf("]", pPhepToan.getCongthuc().indexOf("]") + 1)));
                    }
                    if (pPhepToan.getCongthuc().contains("-")) {
                        tv_monkey_avata_pheptoan_hs.setText(" - ");
                        tv_monkey_avata_mauso_hs1.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/") + 1, pPhepToan.getCongthuc().indexOf("-")));
                        tv_monkey_avata_hs2.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("-") + 1, pPhepToan.getCongthuc().indexOf("]", pPhepToan.getCongthuc().indexOf("]") + 1)));
                    }
                    tv_monkey_avata_hs1.setText(pPhepToan.getCongthuc().substring(0, pPhepToan.getCongthuc().indexOf("]")));
                    tv_monkey_avata_tuso_hs1.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("]") + 1, pPhepToan.getCongthuc().indexOf("/")));
                    tv_monkey_avata_tuso_hs2.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("]", pPhepToan.getCongthuc().indexOf("]") + 1) + 1, pPhepToan.getCongthuc().indexOf("/", pPhepToan.getCongthuc().indexOf("/") + 1)));
                    tv_monkey_avata_mauso_hs2.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/", pPhepToan.getCongthuc().indexOf("/") + 1) + 1));
                } else if (pPhepToan.getCongthuc().contains("]")) {
                    tv_monkey_avata_hs1.setText(pPhepToan.getCongthuc().substring(0, pPhepToan.getCongthuc().indexOf("]")));
                    tv_monkey_avata_tuso_hs1.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("]") + 1, pPhepToan.getCongthuc().indexOf("/")));
                    tv_monkey_avata_mauso_hs1.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/") + 1));
                } else if (pPhepToan.getCongthuc().contains("/") && pPhepToan.getCongthuc().contains(")")) {
                    tv_monkey_avata_tuso_cua1.setText(pPhepToan.getCongthuc().substring(0, pPhepToan.getCongthuc().indexOf("/")).replaceAll("\\)", "").replaceAll("\\(", ""));
                    tv_monkey_avata_mauso_hs1.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/") + 1).replaceAll("\\)", "").replaceAll("\\(", ""));
                } else if (pPhepToan.getCongthuc().contains("/")) {
                    if (pPhepToan.getCongthuc().contains("+") || pPhepToan.getCongthuc().contains("-") || pPhepToan.getCongthuc().contains("x") || pPhepToan.getCongthuc().contains(":")) {
                        String[] mang = pPhepToan.getCongthuc().split("\\+|x|:|-");
                        if (mang.length >= 3) {
                            //String pheptoan=pPhepToan.getCongthuc();
                            String dau1 = "";
                            String dau2 = "";
                            if (pPhepToan.getCongthuc().contains("+") && pPhepToan.getCongthuc().contains("-")) {
                                int vtd1 = pPhepToan.getCongthuc().indexOf('+');
                                int vtd2 = pPhepToan.getCongthuc().indexOf('-');
                                if (vtd1 > vtd2) {
                                    dau1 = "-";
                                    dau2 = "+";
                                } else {
                                    dau1 = "+";
                                    dau2 = "-";
                                }

                            } else if (pPhepToan.getCongthuc().contains("+") && pPhepToan.getCongthuc().contains("x")) {
                                int vtd1 = pPhepToan.getCongthuc().indexOf('+');
                                int vtd2 = pPhepToan.getCongthuc().indexOf('x');
                                if (vtd1 > vtd2) {
                                    dau1 = "x";
                                    dau2 = "+";
                                } else {
                                    dau1 = "+";
                                    dau2 = "x";
                                }
                            } else if (pPhepToan.getCongthuc().contains("+") && pPhepToan.getCongthuc().contains(":")) {
                                int vtd1 = pPhepToan.getCongthuc().indexOf('+');
                                int vtd2 = pPhepToan.getCongthuc().indexOf(':');
                                if (vtd1 > vtd2) {
                                    dau1 = ":";
                                    dau2 = "+";
                                } else {
                                    dau1 = "+";
                                    dau2 = ":";
                                }
                            } else if (pPhepToan.getCongthuc().contains("-") && pPhepToan.getCongthuc().contains("x")) {
                                int vtd1 = pPhepToan.getCongthuc().indexOf('-');
                                int vtd2 = pPhepToan.getCongthuc().indexOf('x');
                                if (vtd1 > vtd2) {
                                    dau1 = "x";
                                    dau2 = "-";
                                } else {
                                    dau1 = "-";
                                    dau2 = "x";
                                }
                            } else if (pPhepToan.getCongthuc().contains("-") && pPhepToan.getCongthuc().contains(":")) {
                                int vtd1 = pPhepToan.getCongthuc().indexOf('-');
                                int vtd2 = pPhepToan.getCongthuc().indexOf(':');
                                if (vtd1 > vtd2) {
                                    dau1 = ":";
                                    dau2 = "-";
                                } else {
                                    dau1 = "-";
                                    dau2 = ":";
                                }
                            } else if (pPhepToan.getCongthuc().contains("x") && pPhepToan.getCongthuc().contains(":")) {
                                int vtd1 = pPhepToan.getCongthuc().indexOf('x');
                                int vtd2 = pPhepToan.getCongthuc().indexOf(':');
                                if (vtd1 > vtd2) {
                                    dau1 = ":";
                                    dau2 = "x";
                                } else {
                                    dau1 = "x";
                                    dau2 = ":";
                                }
                            } else if (pPhepToan.getCongthuc().contains("+")) {
                                dau1 = "+";
                                dau2 = "+";
                            } else if (pPhepToan.getCongthuc().contains("-")) {
                                dau1 = "-";
                                dau2 = "-";
                            } else if (pPhepToan.getCongthuc().contains("x")) {
                                dau1 = "x";
                                dau2 = "x";
                            } else if (pPhepToan.getCongthuc().contains(":")) {
                                dau1 = ":";
                                dau2 = ":";
                            }
                            tv_monkey_avata_tuso_cua1.setText(mang[0].substring(0, mang[0].indexOf("/")));
                            tv_monkey_avata_mauso_cua1.setText(mang[0].substring(mang[0].indexOf("/") + 1));
                            tv_monkey_avata_cua_ps1.setText(" " + dau1 + " ");

                            tv_monkey_avata_tuso_cua2.setText(mang[1].substring(0, mang[1].indexOf("/")));
                            tv_monkey_avata_mauso_cua2.setText(mang[1].substring(mang[1].indexOf("/") + 1));
                            tv_monkey_avata_cua_ps2.setText(" " + dau2 + " ");
                            tv_monkey_avata_tuso_cua3.setText(mang[2].substring(0, mang[2].indexOf("/")));
                            tv_monkey_avata_mauso_cua3.setText(mang[2].substring(mang[2].indexOf("/") + 1));

                            //--------------------------------------
                        } else {
                            if (pPhepToan.getCongthuc().contains("+")) {
                                if (pPhepToan.getCongthuc().substring(0, pPhepToan.getCongthuc().indexOf("+") + 1).contains("/")) {
                                    if (pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("+") + 1).contains("/")) {
                                        //ca 2 cung co
                                        tv_monkey_avata_tuso_cua1.setText(pPhepToan.getCongthuc().substring(0, pPhepToan.getCongthuc().indexOf("/")));
                                        tv_monkey_avata_mauso_cua1.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/") + 1, pPhepToan.getCongthuc().indexOf("+")));
                                        tv_monkey_avata_cua_ps1.setText(" + ");
                                        tv_monkey_avata_tuso_cua2.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("+") + 1, pPhepToan.getCongthuc().indexOf("/", pPhepToan.getCongthuc().indexOf("/") + 1)));
                                        tv_monkey_avata_mauso_cua2.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/", pPhepToan.getCongthuc().indexOf("/") + 1) + 1));
                                    } else {
                                        //ben trai co
                                        tv_monkey_avata_tuso_cua1.setText(pPhepToan.getCongthuc().substring(0, pPhepToan.getCongthuc().indexOf("/")));
                                        tv_monkey_avata_mauso_cua1.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/") + 1, pPhepToan.getCongthuc().indexOf("+")));
                                        tv_monkey_avata_cua_ps1.setText(" + " + pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("+") + 1));
                                    }
                                } else {
                                    //Ben phai co
                                    tv_monkey_avata_cua_ps1.setText(pPhepToan.getCongthuc().substring(0, pPhepToan.getCongthuc().indexOf("+")) + " + ");
                                    tv_monkey_avata_tuso_cua2.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("+") + 1, pPhepToan.getCongthuc().indexOf("/")));
                                    tv_monkey_avata_mauso_cua2.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/") + 1));
                                }
                            } else if (pPhepToan.getCongthuc().contains("-")) {
                                if (pPhepToan.getCongthuc().substring(0, pPhepToan.getCongthuc().indexOf("-") + 1).contains("/")) {
                                    if (pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("-") + 1).contains("/")) {
                                        //ca 2 cung co
                                        tv_monkey_avata_tuso_cua1.setText(pPhepToan.getCongthuc().substring(0, pPhepToan.getCongthuc().indexOf("/")));
                                        tv_monkey_avata_mauso_cua1.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/") + 1, pPhepToan.getCongthuc().indexOf("-")));
                                        tv_monkey_avata_cua_ps1.setText(" - ");
                                        tv_monkey_avata_tuso_cua2.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("-") + 1, pPhepToan.getCongthuc().indexOf("/", pPhepToan.getCongthuc().indexOf("/") + 1)));
                                        tv_monkey_avata_mauso_cua2.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/", pPhepToan.getCongthuc().indexOf("/") + 1) + 1));
                                    } else {
                                        //ben trai co
                                        tv_monkey_avata_tuso_cua1.setText(pPhepToan.getCongthuc().substring(0, pPhepToan.getCongthuc().indexOf("/")));
                                        tv_monkey_avata_mauso_cua1.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/") + 1, pPhepToan.getCongthuc().indexOf("-")));
                                        tv_monkey_avata_cua_ps1.setText(" - " + pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("-") + 1));
                                    }
                                } else {
                                    //Ben phai co
                                    tv_monkey_avata_cua_ps1.setText(pPhepToan.getCongthuc().substring(0, pPhepToan.getCongthuc().indexOf("-")) + " - ");
                                    tv_monkey_avata_tuso_cua2.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("-") + 1, pPhepToan.getCongthuc().indexOf("/")));
                                    tv_monkey_avata_mauso_cua2.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/") + 1));
                                }
                            } else if (pPhepToan.getCongthuc().contains("x")) {
                                if (pPhepToan.getCongthuc().substring(0, pPhepToan.getCongthuc().indexOf("x") + 1).contains("/")) {
                                    if (pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("x") + 1).contains("/")) {
                                        //ca 2 cung co
                                        tv_monkey_avata_tuso_cua1.setText(pPhepToan.getCongthuc().substring(0, pPhepToan.getCongthuc().indexOf("/")));
                                        tv_monkey_avata_mauso_cua1.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/") + 1, pPhepToan.getCongthuc().indexOf("x")));
                                        tv_monkey_avata_cua_ps1.setText(" x ");
                                        tv_monkey_avata_tuso_cua2.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("x") + 1, pPhepToan.getCongthuc().indexOf("/", pPhepToan.getCongthuc().indexOf("/") + 1)));
                                        tv_monkey_avata_mauso_cua2.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/", pPhepToan.getCongthuc().indexOf("/") + 1) + 1));
                                    } else {
                                        //ben trai co
                                        tv_monkey_avata_tuso_cua1.setText(pPhepToan.getCongthuc().substring(0, pPhepToan.getCongthuc().indexOf("/")));
                                        tv_monkey_avata_mauso_cua1.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/") + 1, pPhepToan.getCongthuc().indexOf("x")));
                                        tv_monkey_avata_cua_ps1.setText(" x " + pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("x") + 1));
                                    }
                                } else {
                                    //Ben phai co
                                    tv_monkey_avata_cua_ps1.setText(pPhepToan.getCongthuc().substring(0, pPhepToan.getCongthuc().indexOf("x")) + " x ");
                                    tv_monkey_avata_tuso_cua2.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("x") + 1, pPhepToan.getCongthuc().indexOf("/")));
                                    tv_monkey_avata_mauso_cua2.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/") + 1));
                                }
                            } else if (pPhepToan.getCongthuc().contains(":")) {
                                if (pPhepToan.getCongthuc().substring(0, pPhepToan.getCongthuc().indexOf(":") + 1).contains("/")) {
                                    if (pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf(":") + 1).contains("/")) {
                                        //ca 2 cung co
                                        tv_monkey_avata_tuso_cua1.setText(pPhepToan.getCongthuc().substring(0, pPhepToan.getCongthuc().indexOf("/")));
                                        tv_monkey_avata_mauso_cua1.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/") + 1, pPhepToan.getCongthuc().indexOf(":")));
                                        tv_monkey_avata_cua_ps1.setText(" : ");
                                        tv_monkey_avata_tuso_cua2.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf(":") + 1, pPhepToan.getCongthuc().indexOf("/", pPhepToan.getCongthuc().indexOf("/") + 1)));
                                        tv_monkey_avata_mauso_cua2.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/", pPhepToan.getCongthuc().indexOf("/") + 1) + 1));
                                    } else {
                                        //ben trai co
                                        tv_monkey_avata_tuso_cua1.setText(pPhepToan.getCongthuc().substring(0, pPhepToan.getCongthuc().indexOf("/")));
                                        tv_monkey_avata_mauso_cua1.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/") + 1, pPhepToan.getCongthuc().indexOf(":")));
                                        tv_monkey_avata_cua_ps1.setText(" : " + pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf(":") + 1));
                                    }
                                } else {
                                    //Ben phai co
                                    tv_monkey_avata_cua_ps1.setText(pPhepToan.getCongthuc().substring(0, pPhepToan.getCongthuc().indexOf(":")) + " : ");
                                    tv_monkey_avata_tuso_cua2.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf(":") + 1, pPhepToan.getCongthuc().indexOf("/")));
                                    tv_monkey_avata_mauso_cua2.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/") + 1));
                                }
                            }
                        }
                    } else {
                        tv_monkey_avata_tuso_cua1.setText(pPhepToan.getCongthuc().substring(0, pPhepToan.getCongthuc().indexOf("/")));
                        tv_monkey_avata_mauso_cua1.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/") + 1));
                    }
                } else {
                    tv_monkey_avata_pheptoan.setText(pPhepToan.getCongthuc());
                    if(pPhepToan.getCongthuc().length()<=8)
                    {
                        tv_monkey_avata_pheptoan.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
                    }
                }
            }
        }catch (Exception exception)
        {
            tv_monkey_avata_pheptoan.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
            tv_monkey_avata_pheptoan.setText("");
            tv_monkey_avata_phantram_ps.setText("");
            tv_monkey_avata_tuso_phantram.setText("");
            tv_monkey_avata_mauso_phantram.setText("");
            tv_monkey_avata_cua_ps1.setText("");
            tv_monkey_avata_tuso_cua1.setText("");
            tv_monkey_avata_mauso_cua1.setText("");
            tv_monkey_avata_tuso_cua2.setText("");
            tv_monkey_avata_mauso_cua2.setText("");
            tv_monkey_avata_pheptoan_hs.setText("");
            tv_monkey_avata_hs1.setText("");
            tv_monkey_avata_tuso_hs1.setText("");
            tv_monkey_avata_mauso_hs1.setText("");
            tv_monkey_avata_hs2.setText("");
            tv_monkey_avata_tuso_hs2.setText("");
            tv_monkey_avata_mauso_hs2.setText("");
            tv_monkey_avata_cua_ps2.setText("");
            tv_monkey_avata_tuso_cua3.setText("");
            tv_monkey_avata_mauso_cua3.setText("");

            tv_monkey_avata_pheptoan.setText(pPhepToan.getCongthuc());
            if(pPhepToan.getCongthuc().length()<=8)
            {
                tv_monkey_avata_pheptoan.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);

            }
        }

    }
    public void onClickContinueGameOverMonkey(View view)
    {
        view.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shake));
        handler.postDelayed(timer_Game_Over_Monkey,950);

    }
    Runnable timer_Game_Over_Monkey= new Runnable() {
        @Override
        public void run() {
            doShowSummary();
        }
    };

    void doShowSummary() {
        try {
            if ( mGrade >= 2) {

                if(DeviceLang.equals("vi_vn"))
                {
                    tv_score_summary.setText("Tổng điểm: " + (mScore_Equal + mScore_Moutain + mScore_MonKey) + "/" + mMaxScore);
                }
                else if(DeviceLang.equals("fr"))
                {
                    tv_score_summary.setText("Résumé : " + (mScore_Equal + mScore_Moutain + mScore_MonKey) + "/" + mMaxScore);
                }
                  else  if(DeviceLang.equals("de"))
                {
                    tv_score_summary.setText("Zusammenfassung : " + (mScore_Equal + mScore_Moutain + mScore_MonKey) + "/" + mMaxScore);
                }
                    else
                {
                    tv_score_summary.setText("Summary : " + (mScore_Equal + mScore_Moutain + mScore_MonKey) + "/" + mMaxScore);
                }

                if ((mScore_Equal + mScore_Moutain + mScore_MonKey) > (mMaxScore / 2)) {


                    if(pref.getInt("maxgrade" + mGrade, 0)<=mLevel) {
                        editor.putInt("maxgrade" + mGrade, mLevel+1);
                        editor.commit();
                    }

                    clsHandleT.doPlaySoundAssets("win.mp3", "", player, false, MainActivity.this);
                    handler.postDelayed(timerPlayThanhCong, player.getDuration());

                    if(DeviceLang.equals("vi_vn"))
                    {
                        tv_status_summary.setText("Thành công");
                    }
                    else if(DeviceLang.equals("fr"))
                    {
                        tv_status_summary.setText("Réussir");
                    }
                     else if(DeviceLang.equals("de"))
                    {
                        tv_status_summary.setText("Bestehen");
                    }
                    else
                    {
                        tv_status_summary.setText("Pass");
                    }


                    iv_dinhnui_summary.setVisibility(View.GONE);
                    la_dog_summary.setVisibility(View.VISIBLE);
                    try {
                        if ((mScore_Equal + mScore_Moutain + mScore_MonKey) > (mMaxScore - 3)) {
                            iv_star_summary.setImageResource(R.drawable.basao);
                        } else if ((mScore_Equal + mScore_Moutain + mScore_MonKey) > (mMaxScore - 6)) {
                            iv_star_summary.setImageResource(R.drawable.haisao);
                        } else {
                            iv_star_summary.setImageResource(R.drawable.motsao);
                        }
                    }catch (Exception e)
                    {

                    }
                    if ((mScore_Equal + mScore_Moutain + mScore_MonKey) > Integer.parseInt(mArrayLevel[mLevel])) {
                        mArrayLevel[mLevel] = "" + (mScore_Equal + mScore_Moutain + mScore_MonKey);
                        mLevelScore = "";
                        for (int i = 0; i < mArrayLevel.length; i++) {
                            if (i == (mArrayLevel.length - 1)) {
                                mLevelScore += mArrayLevel[i];
                            } else {
                                mLevelScore += mArrayLevel[i] + "^";
                            }
                        }
                        editor.putString("levelscore" + mGrade, mLevelScore);
                        editor.commit();
                        levelAdapter.notifyDataSetChanged();
                    }
                    animation_view_summary.setVisibility(View.VISIBLE);
                    animation_view_summary.playAnimation();

                } else {
                    clsHandleT.doPlaySoundAssets("thatbai.mp3", DeviceLang, player, false, MainActivity.this);
                    handler.postDelayed(timerRePlaySoudsBackGround,player.getDuration());
                    tv_status_summary.setText(getString(R.string.thatbai));

                    try {
                        iv_star_summary.setImageResource(R.drawable.khongsao);
                    }catch (Exception e)
                    {

                    }

                    iv_dinhnui_summary.setVisibility(View.VISIBLE);
                    la_dog_summary.setVisibility(View.GONE);
                }
            } else {

                if(DeviceLang.equals("vi_vn"))
                {
                    tv_score_summary.setText("Tổng điểm: "+ + (mScore_Equal + mScore_MonKey) + "/" + mMaxScore);
                }
                else if(DeviceLang.equals("fr"))
                {
                    tv_score_summary.setText("Résumé : "+ + (mScore_Equal + mScore_MonKey) + "/" + mMaxScore);
                }
                else if(DeviceLang.equals("de"))
                {
                    tv_score_summary.setText("Zusammenfassung : "+ + (mScore_Equal + mScore_MonKey) + "/" + mMaxScore);
                }
                else
                {
                    tv_score_summary.setText("Summary : "+ + (mScore_Equal + mScore_MonKey) + "/" + mMaxScore);
                }

                if ((mScore_Equal + mScore_MonKey) > (mMaxScore / 2)) {

                    if(pref.getInt("maxgrade" + mGrade, 0)<=mLevel) {
                        editor.putInt("maxgrade" + mGrade, mLevel+1);
                        editor.commit();
                    }

                    clsHandleT.doPlaySoundAssets("win.mp3", "", player, false, MainActivity.this);
                    handler.postDelayed(timerPlayThanhCong, player.getDuration());

                    if(DeviceLang.equals("vi_vn"))
                    {
                        tv_status_summary.setText("Thành công");
                    }
                    else if(DeviceLang.equals("fr"))
                    {
                        tv_status_summary.setText("Réussir");
                    }
                     else if(DeviceLang.equals("de"))
                    {
                        tv_status_summary.setText("Bestehen");
                    }
                    else
                    {
                        tv_status_summary.setText("Pass");
                    }

                    iv_dinhnui_summary.setVisibility(View.GONE);
                    la_dog_summary.setVisibility(View.VISIBLE);
                    try {
                        if ((mScore_Equal + mScore_MonKey) > (mMaxScore - 3)) {
                            iv_star_summary.setImageResource(R.drawable.basao);
                        } else if ((mScore_Equal + mScore_MonKey) > (mMaxScore - 6)) {
                            iv_star_summary.setImageResource(R.drawable.haisao);
                        } else {
                            iv_star_summary.setImageResource(R.drawable.motsao);
                        }
                    }catch (Exception e)
                    {

                    }
                    if ((mScore_Equal + mScore_MonKey) > Integer.parseInt(mArrayLevel[mLevel])) {
                        mArrayLevel[mLevel] = "" + (mScore_Equal + mScore_MonKey);
                        mLevelScore = "";
                        for (int i = 0; i < mArrayLevel.length; i++) {
                            if (i == (mArrayLevel.length - 1)) {
                                mLevelScore += mArrayLevel[i];
                            } else {
                                mLevelScore += mArrayLevel[i] + "^";
                            }
                        }
                        editor.putString("levelscore" + mGrade, mLevelScore);
                        editor.commit();
                        levelAdapter.notifyDataSetChanged();
                    }
                    animation_view_summary.setVisibility(View.VISIBLE);
                    animation_view_summary.playAnimation();
                } else {
                    clsHandleT.doPlaySoundAssets("thatbai.mp3", DeviceLang, player, false, MainActivity.this);
                    handler.postDelayed(timerRePlaySoudsBackGround,player.getDuration());

                    if(DeviceLang.equals("vi_vn"))
                    {
                        tv_status_summary.setText("Thất bại");
                    }
                    else if(DeviceLang.equals("fr"))
                    {
                        tv_status_summary.setText("Échoué");
                    }
                    else if(DeviceLang.equals("de"))
                    {
                        tv_status_summary.setText("Durchgefallen");
                    }
                    else
                    {
                        tv_status_summary.setText("Failed");
                    }


                    try {
                        iv_star_summary.setImageResource(R.drawable.khongsao);
                    }catch (Exception e)
                    {

                    }

                    iv_dinhnui_summary.setVisibility(View.VISIBLE);
                    la_dog_summary.setVisibility(View.GONE);
                }
            }

            viewFlipperMath.setDisplayedChild(12);
        } catch (Exception exception) {

        }
    }

    Runnable timerPlayThanhCong= new Runnable() {
        @Override
        public void run() {
            clsHandleT.doPlaySoundAssets("chucmung"+(rd.nextInt(2)+1)+".mp3",DeviceLang, player, false, MainActivity.this);
            handler.postDelayed(timerRePlaySoudsBackGround,player.getDuration());
        }
    };
    Runnable timerRePlaySoudsBackGround= new Runnable() {
        @Override
        public void run() {
            playerBg.seekTo(lengthMediaBg);
            playerBg.start();
        }
    };


    //endregion

    //region Equal
    void doLoadSugetEqual()
    {
        try {
            lstPhepToanLevelTMP=lstPhepToanLevel;
            Collections.shuffle(lstPhepToanLevelTMP);
            lstPhepToanLevel20 = new ArrayList<PhepToan>();

            if(mGrade==1)
            {
                if(mLevel==0)
                {

                    mTmpPhepToan1 = new PhepToan();
                    mTmpPhepToan1.setCongthuc("vuong");
                    mTmpPhepToan1.setKetqua(-2);
                    mTmpPhepToan1.setLevel(1);
                    mTmpPhepToan1.setTamcongthuc("Vuong");
                    lstPhepToanLevel20.add(mTmpPhepToan1);

                    mTmpPhepToan2 = new PhepToan();

                    if(DeviceLang.equals("vi_vn"))
                    {
                        mTmpPhepToan2.setCongthuc("Hình vuông");
                    }
                    else if(DeviceLang.equals("fr"))
                    {
                        mTmpPhepToan2.setCongthuc("Carré");
                    }
                    else if(DeviceLang.equals("de"))
                    {
                        mTmpPhepToan2.setCongthuc("Quadrat");
                    }
                    else
                    {
                        mTmpPhepToan2.setCongthuc("Square");
                    }
                    mTmpPhepToan2.setKetqua(-2);
                    mTmpPhepToan2.setLevel(1);
                    mTmpPhepToan2.setTamcongthuc("Vuong");
                    lstPhepToanLevel20.add(mTmpPhepToan2);
                    //------------------------------------
                    mTmpPhepToan1 = new PhepToan();
                    mTmpPhepToan1.setCongthuc("tron");
                    mTmpPhepToan1.setKetqua(-1);
                    mTmpPhepToan1.setLevel(1);
                    mTmpPhepToan1.setTamcongthuc("Tron");
                    lstPhepToanLevel20.add(mTmpPhepToan1);

                    mTmpPhepToan2 = new PhepToan();
                  //  mTmpPhepToan2.setCongthuc(getString(R.string.hinhtron));
                    if(DeviceLang.equals("vi_vn"))
                    {
                        mTmpPhepToan2.setCongthuc("Hình tròn");
                    }
                    else if(DeviceLang.equals("fr"))
                    {
                        mTmpPhepToan2.setCongthuc("Cercle");
                    }
                    else if(DeviceLang.equals("de"))
                    {
                        mTmpPhepToan2.setCongthuc("Kreis");
                    }
                    else
                    {
                        mTmpPhepToan2.setCongthuc("Circle");
                    }
                    mTmpPhepToan2.setKetqua(-1);
                    mTmpPhepToan2.setLevel(1);
                    mTmpPhepToan2.setTamcongthuc("Tron");
                    lstPhepToanLevel20.add(mTmpPhepToan2);
                    //---------------------------------
                    mTmpPhepToan1 = new PhepToan();
                    int tmpT=rd.nextInt(9)+1;
                   // mTmpPhepToan1.setCongthuc(tmpT+" "+getString(R.string.ga));
                    if(DeviceLang.equals("vi_vn"))
                    {
                        mTmpPhepToan1.setCongthuc(tmpT+" con vịt");
                    }
                    else if(DeviceLang.equals("fr"))
                    {
                        mTmpPhepToan1.setCongthuc(tmpT+" canard");
                    }
                    else if(DeviceLang.equals("de"))
                    {
                        mTmpPhepToan1.setCongthuc(tmpT+" ente");
                    }
                    else
                    {
                        mTmpPhepToan1.setCongthuc(tmpT+" duck");
                    }
                    mTmpPhepToan1.setKetqua(tmpT);
                    mTmpPhepToan1.setLevel(2);
                    mTmpPhepToan1.setTamcongthuc("chicken");
                    lstPhepToanLevel20.add(mTmpPhepToan1);

                    mTmpPhepToan2 = new PhepToan();
                    mTmpPhepToan2.setCongthuc("chicken");
                    mTmpPhepToan2.setKetqua(tmpT);
                    mTmpPhepToan2.setLevel(2);
                    mTmpPhepToan2.setTamcongthuc("chicken");
                    lstPhepToanLevel20.add(mTmpPhepToan2);

                }else if(mLevel==1)
                {
                    mTmpPhepToan1 = new PhepToan();
                    mTmpPhepToan1.setCongthuc("chunhat");
                    mTmpPhepToan1.setKetqua(-5);
                    mTmpPhepToan1.setLevel(2);
                    mTmpPhepToan1.setTamcongthuc("ChuNhat");
                    lstPhepToanLevel20.add(mTmpPhepToan1);

                    mTmpPhepToan2 = new PhepToan();
                  //  mTmpPhepToan2.setCongthuc(getString(R.string.hinhchunhat));
                    if(DeviceLang.equals("vi_vn"))
                    {
                        mTmpPhepToan2.setCongthuc("Hình chữ nhật");
                    }
                    else if(DeviceLang.equals("fr"))
                    {
                        mTmpPhepToan2.setCongthuc("Rectangle");
                    }
                     else if(DeviceLang.equals("de"))
                    {
                        mTmpPhepToan2.setCongthuc("Rechteck");
                    }
                    else
                    {
                        mTmpPhepToan2.setCongthuc("Rectangle");
                    }
                    mTmpPhepToan2.setKetqua(-5);
                    mTmpPhepToan2.setLevel(2);
                    mTmpPhepToan2.setTamcongthuc("ChuNhat");
                    lstPhepToanLevel20.add(mTmpPhepToan2);
                    //------------------------------------
                    mTmpPhepToan1 = new PhepToan();
                    mTmpPhepToan1.setCongthuc("sao");
                    mTmpPhepToan1.setKetqua(-4);
                    mTmpPhepToan1.setLevel(2);
                    mTmpPhepToan1.setTamcongthuc("Sao");
                    lstPhepToanLevel20.add(mTmpPhepToan1);

                    mTmpPhepToan2 = new PhepToan();
                  //  mTmpPhepToan2.setCongthuc(getString(R.string.hinhsao));
                    if(DeviceLang.equals("vi_vn"))
                    {
                        mTmpPhepToan2.setCongthuc("Hình ngôi sao");
                    }
                    else if(DeviceLang.equals("fr"))
                    {
                        mTmpPhepToan2.setCongthuc("Étoile");
                    }
                    else if(DeviceLang.equals("de"))
                    {
                        mTmpPhepToan2.setCongthuc("Stern");
                    }
                    else
                    {
                        mTmpPhepToan2.setCongthuc("Star");
                    }
                    mTmpPhepToan2.setKetqua(-4);
                    mTmpPhepToan2.setLevel(2);
                    mTmpPhepToan2.setTamcongthuc("Sao");
                    lstPhepToanLevel20.add(mTmpPhepToan2);
                    //---------------------------------
                    mTmpPhepToan1 = new PhepToan();
                    int tmpT=rd.nextInt(9)+1;
                    mTmpPhepToan1.setCongthuc(tmpT+" "+getString(R.string.flower));
                    if(DeviceLang.equals("vi_vn"))
                    {
                        mTmpPhepToan1.setCongthuc(tmpT+" bông hoa");
                    }
                    else if(DeviceLang.equals("fr"))
                    {
                        mTmpPhepToan1.setCongthuc(tmpT+" fleur");
                    }
                     else if(DeviceLang.equals("de"))
                    {
                        mTmpPhepToan1.setCongthuc(tmpT+" blume");
                    }
                    else
                    {
                        mTmpPhepToan1.setCongthuc(tmpT+" flower");
                    }
                    mTmpPhepToan1.setKetqua(tmpT);
                    mTmpPhepToan1.setLevel(2);
                    mTmpPhepToan1.setTamcongthuc("hoa");
                    lstPhepToanLevel20.add(mTmpPhepToan1);

                    mTmpPhepToan2 = new PhepToan();
                    mTmpPhepToan2.setCongthuc("hoa");
                    mTmpPhepToan2.setKetqua(tmpT);
                    mTmpPhepToan2.setLevel(2);
                    mTmpPhepToan2.setTamcongthuc("hoa");
                    lstPhepToanLevel20.add(mTmpPhepToan2);

                }else if(mLevel==2)
                {
                    lstResultTMG=new ArrayList<Integer>();
                    for (int i=1;i<=9;i++)
                    {
                        lstResultTMG.add(i);
                    }
                    while (lstPhepToanLevel20.size() < 6) {

                        if(rd.nextInt(6)%2==0)
                        {
                            mTmpPhepToan1 = new PhepToan();
                            mChon = rd.nextInt(lstResultTMG.size());
                           // mTmpPhepToan1.setCongthuc(lstResultTMG.get(mChon)+" "+getString(R.string.flower));

                            if(DeviceLang.equals("vi_vn"))
                            {
                                mTmpPhepToan1.setCongthuc(lstResultTMG.get(mChon)+" bông hoa");
                            }
                            else if(DeviceLang.equals("fr"))
                            {
                                mTmpPhepToan1.setCongthuc(lstResultTMG.get(mChon)+" fleur");
                            }
                              else if(DeviceLang.equals("de"))
                            {
                                mTmpPhepToan1.setCongthuc(lstResultTMG.get(mChon)+" blume");
                            }
                            else
                            {
                                mTmpPhepToan1.setCongthuc(lstResultTMG.get(mChon)+" flower");
                            }

                            mTmpPhepToan1.setKetqua(lstResultTMG.get(mChon));
                            mTmpPhepToan1.setLevel(3);
                            mTmpPhepToan1.setTamcongthuc("hoa");

                            mTmpPhepToan2 = new PhepToan();
                            mTmpPhepToan2.setCongthuc("hoa");
                            mTmpPhepToan2.setKetqua(lstResultTMG.get(mChon));
                            mTmpPhepToan2.setLevel(3);
                            mTmpPhepToan2.setTamcongthuc("hoa");

                            lstResultTMG.remove(mChon);

                        }else
                        {
                            mTmpPhepToan1 = new PhepToan();
                            mChon = rd.nextInt(lstResultTMG.size());
                           // mTmpPhepToan1.setCongthuc(lstResultTMG.get(mChon)+" "+getString(R.string.ga));
                            if(DeviceLang.equals("vi_vn"))
                            {
                                mTmpPhepToan1.setCongthuc(lstResultTMG.get(mChon)+" con vịt");
                            }
                            else if(DeviceLang.equals("fr"))
                            {
                                mTmpPhepToan1.setCongthuc(lstResultTMG.get(mChon)+" canard");
                            }
                            else if(DeviceLang.equals("de"))
                            {
                                mTmpPhepToan1.setCongthuc(lstResultTMG.get(mChon)+" ente");
                            }
                            else
                            {
                                mTmpPhepToan1.setCongthuc(lstResultTMG.get(mChon)+" duck");
                            }
                            mTmpPhepToan1.setKetqua(lstResultTMG.get(mChon));
                            mTmpPhepToan1.setLevel(3);
                            mTmpPhepToan1.setTamcongthuc("chicken");

                            mTmpPhepToan2 = new PhepToan();
                            mTmpPhepToan2.setCongthuc("chicken");
                            mTmpPhepToan2.setKetqua(lstResultTMG.get(mChon));
                            mTmpPhepToan2.setLevel(3);
                            mTmpPhepToan2.setTamcongthuc("chicken");

                            lstResultTMG.remove(mChon);
                        }
                        lstPhepToanLevel20.add(mTmpPhepToan1);
                        lstPhepToanLevel20.add(mTmpPhepToan2);
                    }

                }else if(mLevel==3)
                {
                    while (lstPhepToanLevel20.size() < 6) {
                        mTmpPhepToan1 = new PhepToan();
                        mChon = rd.nextInt(lstPhepToanLevelTMP.size());
                        mTmpPhepToan1 = lstPhepToanLevelTMP.get(mChon);

                        mTmpPhepToan2 = new PhepToan();
                        mTmpPhepToan2.setCongthuc("" + lstPhepToanLevelTMP.get(mChon).getTamcongthuc());
                        mTmpPhepToan2.setKetqua(lstPhepToanLevelTMP.get(mChon).getKetqua());

                        lstPhepToanLevelTMP.remove(mChon);

                        lstPhepToanLevel20.add(mTmpPhepToan1);
                        lstPhepToanLevel20.add(mTmpPhepToan2);
                    }
                }else
                {
                    while (lstPhepToanLevel20.size() < 12) {
                        mTmpPhepToan1 = new PhepToan();
                        mChon = rd.nextInt(lstPhepToanLevelTMP.size());
                        mTmpPhepToan1 = lstPhepToanLevelTMP.get(mChon);

                        mTmpPhepToan2 = new PhepToan();
                        mTmpPhepToan2.setCongthuc("" + lstPhepToanLevelTMP.get(mChon).getTamcongthuc());
                        mTmpPhepToan2.setKetqua(lstPhepToanLevelTMP.get(mChon).getKetqua());

                        lstPhepToanLevelTMP.remove(mChon);

                        lstPhepToanLevel20.add(mTmpPhepToan1);
                        lstPhepToanLevel20.add(mTmpPhepToan2);
                    }
                }

            }else if(mGrade==20)
            {
                if(mLevel==0)
                {
                    while (lstPhepToanLevel20.size() < 6) {
                        mTmpPhepToan1 = new PhepToan();
                        mChon = rd.nextInt(lstPhepToanLevelTMP.size());
                        mTmpPhepToan1 = lstPhepToanLevelTMP.get(mChon);

                        mTmpPhepToan2 = new PhepToan();
                        mTmpPhepToan2.setCongthuc("" + clsHandleT.getFlagEmoji(lstPhepToanLevelTMP.get(mChon).getTamcongthuc()));
                        mTmpPhepToan2.setIs_flag(1);
                        mTmpPhepToan2.setKetqua(lstPhepToanLevelTMP.get(mChon).getKetqua());

                        lstPhepToanLevelTMP.remove(mChon);

                        lstPhepToanLevel20.add(mTmpPhepToan1);
                        lstPhepToanLevel20.add(mTmpPhepToan2);
                    }


                }else   if(mLevel==1)
                {
                    while (lstPhepToanLevel20.size() < 12) {
                        mTmpPhepToan1 = new PhepToan();
                        mChon = rd.nextInt(lstPhepToanLevelTMP.size());
                        mTmpPhepToan1 = lstPhepToanLevelTMP.get(mChon);

                        mTmpPhepToan2 = new PhepToan();
                        mTmpPhepToan2.setCongthuc("" + clsHandleT.getFlagEmoji(lstPhepToanLevelTMP.get(mChon).getTamcongthuc()));
                        mTmpPhepToan2.setIs_flag(1);
                        mTmpPhepToan2.setKetqua(lstPhepToanLevelTMP.get(mChon).getKetqua());

                        lstPhepToanLevelTMP.remove(mChon);

                        lstPhepToanLevel20.add(mTmpPhepToan1);
                        lstPhepToanLevel20.add(mTmpPhepToan2);
                    }


                }else
                {
                    while (lstPhepToanLevel20.size() < 20) {
                        mTmpPhepToan1 = new PhepToan();
                        mChon = rd.nextInt(lstPhepToanLevelTMP.size());

                        mTmpPhepToan1 = lstPhepToanLevelTMP.get(mChon);


                        mTmpPhepToan2 = new PhepToan();
                        //mCheckCongThuc = true;

                        mTmpPhepToan2.setCongthuc("" + clsHandleT.getFlagEmoji(lstPhepToanLevelTMP.get(mChon).getTamcongthuc()));
                        mTmpPhepToan2.setIs_flag(1);
                        mTmpPhepToan2.setKetqua(lstPhepToanLevelTMP.get(mChon).getKetqua());

                        lstPhepToanLevelTMP.remove(mChon);

                        lstPhepToanLevel20.add(mTmpPhepToan1);
                        lstPhepToanLevel20.add(mTmpPhepToan2);
                    }
                }
            }   else {
                    if (mGrade == 2 && lstPhepToanLevelTMP.get(0).getLevel() == 1) {
                    if (rd.nextInt(5) % 2 == 0) {
                        mTmpPhepToan1 = new PhepToan();
                        mTmpPhepToan1.setCongthuc("tamgiac");
                        mTmpPhepToan1.setKetqua(-3);
                        mTmpPhepToan1.setLevel(lstPhepToanLevelTMP.get(0).getLevel());
                        mTmpPhepToan1.setTamcongthuc("TamGiac");
                        lstPhepToanLevel20.add(mTmpPhepToan1);

                        mTmpPhepToan2 = new PhepToan();
                     //   mTmpPhepToan2.setCongthuc(getString(R.string.hinhtamgiac));
                        if(DeviceLang.equals("vi_vn"))
                        {
                            mTmpPhepToan2.setCongthuc("Hình tam giác");
                        }
                        else if(DeviceLang.equals("fr"))
                        {
                            mTmpPhepToan2.setCongthuc("Triangle");
                        }
                        else if(DeviceLang.equals("de"))
                        {
                            mTmpPhepToan2.setCongthuc("Dreieck");
                        }
                        else
                        {
                            mTmpPhepToan2.setCongthuc("Triangle");
                        }

                        mTmpPhepToan2.setKetqua(-3);
                        mTmpPhepToan2.setLevel(lstPhepToanLevelTMP.get(0).getLevel());
                        mTmpPhepToan2.setTamcongthuc("TamGiac");
                        lstPhepToanLevel20.add(mTmpPhepToan2);
//---------------------------------------------------------------

                        mTmpPhepToan1 = new PhepToan();
                        mTmpPhepToan1.setCongthuc("vuong");
                        mTmpPhepToan1.setKetqua(-2);
                        mTmpPhepToan1.setLevel(lstPhepToanLevelTMP.get(0).getLevel());
                        mTmpPhepToan1.setTamcongthuc("Vuong");
                        lstPhepToanLevel20.add(mTmpPhepToan1);

                        mTmpPhepToan2 = new PhepToan();
                      //  mTmpPhepToan2.setCongthuc(getString(R.string.hinhvuong));

                        if(DeviceLang.equals("vi_vn"))
                        {
                            mTmpPhepToan2.setCongthuc("Hình vuông");
                        }
                        else if(DeviceLang.equals("fr"))
                        {
                            mTmpPhepToan2.setCongthuc("Carré");
                        }
                         else if(DeviceLang.equals("de"))
                        {
                            mTmpPhepToan2.setCongthuc("Quadrat");
                        }
                        else
                        {
                            mTmpPhepToan2.setCongthuc("Square");
                        }


                        mTmpPhepToan2.setKetqua(-2);
                        mTmpPhepToan2.setLevel(lstPhepToanLevelTMP.get(0).getLevel());
                        mTmpPhepToan2.setTamcongthuc("Vuong");
                        lstPhepToanLevel20.add(mTmpPhepToan2);
                    } else {
                        mTmpPhepToan1 = new PhepToan();
                        mTmpPhepToan1.setCongthuc("tron");
                        mTmpPhepToan1.setKetqua(-1);
                        mTmpPhepToan1.setLevel(lstPhepToanLevelTMP.get(0).getLevel());
                        mTmpPhepToan1.setTamcongthuc("Tron");
                        lstPhepToanLevel20.add(mTmpPhepToan1);

                        mTmpPhepToan2 = new PhepToan();
                     //   mTmpPhepToan2.setCongthuc(getString(R.string.hinhtron));
                        if(DeviceLang.equals("vi_vn"))
                        {
                            mTmpPhepToan2.setCongthuc("Hình tròn");
                        }
                        else  if(DeviceLang.equals("fr"))
                        {
                            mTmpPhepToan2.setCongthuc("Cercle");
                        }
                        else  if(DeviceLang.equals("de"))
                        {
                            mTmpPhepToan2.setCongthuc("Kreis");
                        }
                        else
                        {
                            mTmpPhepToan2.setCongthuc("Circle");
                        }

                        mTmpPhepToan2.setKetqua(-1);
                        mTmpPhepToan2.setLevel(lstPhepToanLevelTMP.get(0).getLevel());
                        mTmpPhepToan2.setTamcongthuc("Tron");
                        lstPhepToanLevel20.add(mTmpPhepToan2);
//---------------------------------------------------------------
                        mTmpPhepToan1 = new PhepToan();
                        mTmpPhepToan1.setCongthuc("chunhat");
                        mTmpPhepToan1.setKetqua(-5);
                        mTmpPhepToan1.setLevel(lstPhepToanLevelTMP.get(0).getLevel());
                        mTmpPhepToan1.setTamcongthuc("ChuNhat");
                        lstPhepToanLevel20.add(mTmpPhepToan1);

                        mTmpPhepToan2 = new PhepToan();
                       // mTmpPhepToan2.setCongthuc(getString(R.string.hinhchunhat));
                        if(DeviceLang.equals("vi_vn"))
                        {
                            mTmpPhepToan2.setCongthuc("Hình chữ nhật");
                        }
                        else if(DeviceLang.equals("fr"))
                        {
                            mTmpPhepToan2.setCongthuc("Rectangle");
                        }
                          else if(DeviceLang.equals("de"))
                        {
                            mTmpPhepToan2.setCongthuc("Rechteck");
                        }
                        else
                        {
                            mTmpPhepToan2.setCongthuc("Rectangle");
                        }

                        mTmpPhepToan2.setKetqua(-5);
                        mTmpPhepToan2.setLevel(lstPhepToanLevelTMP.get(0).getLevel());
                        mTmpPhepToan2.setTamcongthuc("ChuNhat");
                        lstPhepToanLevel20.add(mTmpPhepToan2);
                    }
                }
                if (mGrade == 2 && lstPhepToanLevelTMP.get(0).getLevel() == 2) {
                    mTmpPhepToan1 = new PhepToan();
                    mTmpPhepToan1.setCongthuc("ngugiac");
                    mTmpPhepToan1.setKetqua(-6);
                    mTmpPhepToan1.setLevel(lstPhepToanLevelTMP.get(0).getLevel());
                    mTmpPhepToan1.setTamcongthuc("NguGiac");
                    lstPhepToanLevel20.add(mTmpPhepToan1);

                    mTmpPhepToan2 = new PhepToan();
                   // mTmpPhepToan2.setCongthuc(getString(R.string.hinhngugiac));
                    if(DeviceLang.equals("vi_vn"))
                    {
                        mTmpPhepToan2.setCongthuc("Hình ngũ giác");
                    }
                    else if(DeviceLang.equals("fr"))
                    {
                        mTmpPhepToan2.setCongthuc("Pentagone");
                    }
                     else if(DeviceLang.equals("de"))
                    {
                        mTmpPhepToan2.setCongthuc("Fünfeck");
                    }
                    else
                    {
                        mTmpPhepToan2.setCongthuc("Pentagon");
                    }

                    mTmpPhepToan2.setKetqua(-6);
                    mTmpPhepToan2.setLevel(lstPhepToanLevelTMP.get(0).getLevel());
                    mTmpPhepToan2.setTamcongthuc("NguGiac");
                    lstPhepToanLevel20.add(mTmpPhepToan2);
//---------------------------------------------------------------
                    mTmpPhepToan1 = new PhepToan();
                    mTmpPhepToan1.setCongthuc("lucgiac");
                    mTmpPhepToan1.setKetqua(-7);
                    mTmpPhepToan1.setLevel(lstPhepToanLevelTMP.get(0).getLevel());
                    mTmpPhepToan1.setTamcongthuc("LucGiac");
                    lstPhepToanLevel20.add(mTmpPhepToan1);

                    mTmpPhepToan2 = new PhepToan();
                 //   mTmpPhepToan2.setCongthuc(getString(R.string.hinhlucgiac));
                    if(DeviceLang.equals("vi_vn"))
                    {
                        mTmpPhepToan2.setCongthuc("Hình lục giác");
                    }
                    else if(DeviceLang.equals("fr"))
                    {
                        mTmpPhepToan2.setCongthuc("Hexagone");
                    }
                     else if(DeviceLang.equals("de"))
                    {
                        mTmpPhepToan2.setCongthuc("Sechseck");
                    }
                    else
                    {
                        mTmpPhepToan2.setCongthuc("Hexagon");
                    }

                    mTmpPhepToan2.setKetqua(-7);
                    mTmpPhepToan2.setLevel(lstPhepToanLevelTMP.get(0).getLevel());
                    mTmpPhepToan2.setTamcongthuc("LucGiac");
                    lstPhepToanLevel20.add(mTmpPhepToan2);
                }

                while (lstPhepToanLevel20.size() < 20) {
                    mTmpPhepToan1 = new PhepToan();
                    mChon = rd.nextInt(lstPhepToanLevelTMP.size());

                    mTmpPhepToan1 = lstPhepToanLevelTMP.get(mChon);


                    mTmpPhepToan2 = new PhepToan();
                    mCheckCongThuc = true;
                    if ((mGrade == 2 && mTmpPhepToan1.getLevel() == 10) ||
                            (mGrade == 3 && mTmpPhepToan1.getLevel() == 14) ||
                            (mGrade == 3 && mTmpPhepToan1.getLevel() == 15) ||
                            (mGrade == 5 && mTmpPhepToan1.getLevel() == 5)) {

                        lstPhepToanLevelTMP.remove(mChon);
                        for (int i = 0; i < lstPhepToanLevelTMP.size(); i++) {
                            if (mTmpPhepToan1.getKetqua() == lstPhepToanLevelTMP.get(i).getKetqua()) {
                                mTmpPhepToan2 = lstPhepToanLevelTMP.get(i);
                                mCheckCongThuc = false;
                                break;
                            }
                        }
                        if (mCheckCongThuc) {
                            if (mGrade == 2 && mTmpPhepToan1.getLevel() == 10) {
                                mTmpPhepToan2.setCongthuc(mTmpPhepToan1.getTamcongthuc() + "cm");
                            }
                            if (mGrade == 3 && mTmpPhepToan1.getLevel() == 14) {
                                mTmpPhepToan2.setCongthuc(mTmpPhepToan1.getTamcongthuc() + " mm");
                            }
                            if (mGrade == 3 && mTmpPhepToan1.getLevel() == 15) {
                                mTmpPhepToan2.setCongthuc(mTmpPhepToan1.getTamcongthuc() + " m");
                            }
                            if (mGrade == 5 && mTmpPhepToan1.getLevel() == 5) {
                                mTmpPhepToan2.setCongthuc(mTmpPhepToan1.getTamcongthuc() + " mm");
                            }
                            mTmpPhepToan2.setKetqua(mTmpPhepToan1.getKetqua());
                        }


                    } else {
                        if (mChon % 2 == 0) {


                            mTmpPhepToan2.setCongthuc("" + lstPhepToanLevelTMP.get(mChon).getTamcongthuc());
                            mTmpPhepToan2.setKetqua(lstPhepToanLevelTMP.get(mChon).getKetqua());

                            lstPhepToanLevelTMP.remove(mChon);
                        } else {

                            lstPhepToanLevelTMP.remove(mChon);

                            for (int i = 0; i < lstPhepToanLevelTMP.size(); i++) {
                                if (mTmpPhepToan1.getKetqua() == lstPhepToanLevelTMP.get(i).getKetqua()) {
                                    mTmpPhepToan2 = lstPhepToanLevelTMP.get(i);
                                    mCheckCongThuc = false;
                                    break;
                                }
                            }
                            if (mCheckCongThuc) {
                                mTmpPhepToan2.setCongthuc("" + mTmpPhepToan1.getTamcongthuc());
                                mTmpPhepToan2.setKetqua(mTmpPhepToan1.getKetqua());
                            }


                        }
                    }
                    lstPhepToanLevel20.add(mTmpPhepToan1);
                    lstPhepToanLevel20.add(mTmpPhepToan2);
                }
            }
            Collections.shuffle(lstPhepToanLevel20);
        }catch (Exception exception)
        {

        }
    }
    public void doResetEqual()
    {
        mScore_Equal=0;
        mNext_False_Equal=0;
        mFirtTime=1200;//con thay doi

        try {
            iv_false_equal.setImageResource(R.drawable.bamau);


            if(DeviceLang.equals("vi_vn"))
            {
                tv_score_equal.setText("Điểm: 00");
                tv_score_equal_one.setText("Điểm: 00");
                tv_score_equal_one_12.setText("Điểm: 00");
            }
            else  if(DeviceLang.equals("fr"))
            {
                tv_score_equal.setText("Score: 00");
                tv_score_equal_one.setText("Score: 00");
                tv_score_equal_one_12.setText("Score: 00");
            }
             else  if(DeviceLang.equals("de"))
            {
                tv_score_equal.setText("Punktzahl: 00");
                tv_score_equal_one.setText("Punktzahl: 00");
                tv_score_equal_one_12.setText("Punktzahl: 00");
            }
            else
            {
                tv_score_equal.setText("Score: 00");
                tv_score_equal_one.setText("Score: 00");
                tv_score_equal_one_12.setText("Score: 00");
            }


            iv_false_equal_one.setImageResource(R.drawable.bamau);

            iv_avata_equal_one.setImageResource(R.drawable.monkey_question);

            iv_false_equal_one_12.setImageResource(R.drawable.bamau);

            iv_avata_equal_one_12.setImageResource(R.drawable.monkey_question);
        }catch (Exception e)
        {

        }
    }
    void doStartEqual()
    {
        try {
            doLoadSugetEqual();
            doResetEqual();

            currentStatus=Status.EQUAL;

            viewFlipperMath.setDisplayedChild(3);
            clsHandleT.doPlaySoundAssets("start_equal.mp3",DeviceLang, player, false, MainActivity.this);
            equalAdapter=new EqualAdapter20(this,lstPhepToanLevel20);

            if(mISO1) {
//                gv_equal.getLayoutParams().width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, (int) Math.floor(mWidthDesktop)-128, getResources().getDisplayMetrics());
//                gv_equal.setColumnWidth((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, ((int) Math.floor((mWidthDesktop)- (128+20+12)) / 5), getResources().getDisplayMetrics()));
            }else
            {
                gv_equal.getLayoutParams().width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, (int) Math.floor(mWidthDesktop), getResources().getDisplayMetrics());
                gv_equal.setColumnWidth((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, ((int) Math.floor((mWidthDesktop)- (20+12)) / 5), getResources().getDisplayMetrics()));
            }

            gv_equal.setAdapter(equalAdapter);
            gv_equal.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    if(currentStatus==Status.EQUAL) {
                        doPlayClick();
                        handler.removeCallbacksAndMessages(null);
                        currentStatus=Status.EQUAL_CLICK_1;
                        rlEqual_1=(ImageView) view.findViewById(R.id.rl_item_bg_tranfom);
                        // rlEqual_1.setBackgroundResource(R.drawable.item_cloud);
                        Picasso.get().load(R.drawable.item_cloud)
                                .placeholder(R.drawable.item_cloud)
                                .error(R.drawable.item_cloud)
                                .transform(new RoundedTransformation(0, 0))
                                .fit().centerCrop()
                                .into(rlEqual_1);
                        mEqual_1=lstPhepToanLevel20.get(position).getKetqua();
                        mViewEqual_1=view;
                        mPositionTMP=position;

                    }else  if(currentStatus==Status.EQUAL_CLICK_1&&mPositionTMP!=position)
                    {
                        doPlayClick();
                        currentStatus=Status.EQUAL_CLICK_2;
                        rlEqual_2=(ImageView) view.findViewById(R.id.rl_item_bg_tranfom);
                        // rlEqual_2.setBackgroundResource(R.drawable.item_cloud);
                        Picasso.get().load(R.drawable.item_cloud)
                                .placeholder(R.drawable.item_cloud)
                                .error(R.drawable.item_cloud)
                                .transform(new RoundedTransformation(0, 0))
                                .fit().centerCrop()
                                .into(rlEqual_2);
                        mEqual_2=lstPhepToanLevel20.get(position).getKetqua();
                        mViewEqual_2=view;

                        handler.postDelayed(timerProcessEqual, 700);

                    }
                }
            });
            //  doRunTimeInGame(mFirtTime*1000,tv_time_ingame_equal,1);
        }catch (Exception exception)
        {

        }

    }
    Runnable timerProcessEqual= new Runnable() {
        @Override
        public void run() {
            if(mEqual_1==mEqual_2)
            {
                clsHandleT.doPlaySoundAssets("guess_true.ogg","", player, false, MainActivity.this);
                la_firework_equal.playAnimation();
                la_firework_equal_one.playAnimation();
                la_firework_equal_one12.playAnimation();
                handler.postDelayed(timer_True_MediaPlay,player.getDuration());
                mViewEqual_1.setVisibility(View.GONE);
                mViewEqual_2.setVisibility(View.GONE);
                mScore_Equal=mScore_Equal+10;


                if(DeviceLang.equals("vi_vn"))
                {
                    tv_score_equal.setText("Điểm: "+mScore_Equal);
                    tv_score_equal_one.setText("Điểm: "+mScore_Equal);
                    tv_score_equal_one_12.setText("Điểm: "+mScore_Equal);
                }
                else if(DeviceLang.equals("fr"))
                {
                    tv_score_equal.setText("Score: "+mScore_Equal);
                    tv_score_equal_one.setText("Score: "+mScore_Equal);
                    tv_score_equal_one_12.setText("Score: "+mScore_Equal);
                }
                  else if(DeviceLang.equals("de"))
                {
                    tv_score_equal.setText("Punktzahl: "+mScore_Equal);
                    tv_score_equal_one.setText("Punktzahl: "+mScore_Equal);
                    tv_score_equal_one_12.setText("Punktzahl: "+mScore_Equal);
                }
                    else
                {
                    tv_score_equal.setText("Score: "+mScore_Equal);
                    tv_score_equal_one.setText("Score: "+mScore_Equal);
                    tv_score_equal_one_12.setText("Score: "+mScore_Equal);
                }


                currentStatus=Status.EQUAL;
                try {


                    iv_avata_equal_one.setImageResource(R.drawable.monkey_laugh);
                    iv_avata_equal_one.startAnimation(anim_tbequal);

                    iv_avata_equal_one_12.setImageResource(R.drawable.monkey_laugh);
                    iv_avata_equal_one_12.startAnimation(anim_tbequal);
                }catch (Exception e)
                {

                }

                if(mGrade==1)
                {
                    if(mLevel<4) {
                        if (mScore_Equal > 21) {
                            handler.postDelayed(timer_GameOver_Equal, 1500);
                        }
                    }else
                    {
                        if (mScore_Equal > 51) {
                            handler.postDelayed(timer_GameOver_Equal, 1500);
                        }
                    }
                }else if(mGrade==20&&mLevel==0)
                {
                    if (mScore_Equal > 21) {
                        handler.postDelayed(timer_GameOver_Equal, 1500);
                    }
                }else if(mGrade==20&&mLevel==1)
                {
                    if (mScore_Equal > 51) {
                        handler.postDelayed(timer_GameOver_Equal, 1500);
                    }
                }
                else {
                    if (mScore_Equal > 91) {
                        handler.postDelayed(timer_GameOver_Equal, 1500);
                    }
                }
            }else
            {
                // clsHandleT.doPlaySoundAssets("sounds/over.mp3", player, false, MainActivity.this);
                if(DeviceLang.equals("vi_vn")) {

                    clsHandleT.doPlaySoundAssets("sai" + (rd.nextInt(5) + 1) + ".mp3", DeviceLang, player, false, MainActivity.this);
                }else
                {
                    clsHandleT.doPlaySoundAssets("over.mp3","", player, false, MainActivity.this);
                }
                mNext_False_Equal++;

                try {

                    iv_avata_equal_one.setImageResource(R.drawable.monkey_cry);
                    iv_avata_equal_one_12.setImageResource(R.drawable.monkey_cry);
                    if(mNext_False_Equal==1)
                    {
                        iv_false_equal.setImageResource(R.drawable.haimau);
                        iv_false_equal_one.setImageResource(R.drawable.haimau);
                        iv_false_equal_one_12.setImageResource(R.drawable.haimau);
                    }else  if(mNext_False_Equal==2)
                    {
                        iv_false_equal.setImageResource(R.drawable.motmau);
                        iv_false_equal_one.setImageResource(R.drawable.motmau);
                        iv_false_equal_one_12.setImageResource(R.drawable.motmau);
                    }else
                    {
                        iv_false_equal.setImageResource(R.drawable.khongmau);
                        iv_false_equal_one.setImageResource(R.drawable.khongmau);
                        iv_false_equal_one_12.setImageResource(R.drawable.khongmau);
                    }
                }catch (Exception e)
                {

                }

                if(mScore_Equal>5)
                {
                    mScore_Equal--;


                    if(DeviceLang.equals("vi_vn"))
                    {
                        tv_score_equal.setText("Điểm: "+mScore_Equal);
                        tv_score_equal_one.setText("Điểm: "+mScore_Equal);
                        tv_score_equal_one_12.setText("Điểm: "+mScore_Equal);
                    }
                    else if(DeviceLang.equals("fr"))
                    {
                        tv_score_equal.setText("Score: "+mScore_Equal);
                        tv_score_equal_one.setText("Score: "+mScore_Equal);
                        tv_score_equal_one_12.setText("Score: "+mScore_Equal);
                    }
                     else if(DeviceLang.equals("de"))
                    {
                        tv_score_equal.setText("Punktzahl: "+mScore_Equal);
                        tv_score_equal_one.setText("Punktzahl: "+mScore_Equal);
                        tv_score_equal_one_12.setText("Punktzahl: "+mScore_Equal);
                    }
                    else
                    {
                        tv_score_equal.setText("Score: "+mScore_Equal);
                        tv_score_equal_one.setText("Score: "+mScore_Equal);
                        tv_score_equal_one_12.setText("Score: "+mScore_Equal);
                    }

                }
//                rlEqual_1.setBackgroundResource(R.drawable.item_tranfom);
//                rlEqual_2.setBackgroundResource(R.drawable.item_tranfom);

                Picasso.get().load(R.drawable.item_tranfom)
                        .placeholder(R.drawable.item_tranfom)
                        .error(R.drawable.item_tranfom)
                        .transform(new RoundedTransformation(0, 0))
                        .fit().centerCrop()
                        .into(rlEqual_1);

                Picasso.get().load(R.drawable.item_tranfom)
                        .placeholder(R.drawable.item_tranfom)
                        .error(R.drawable.item_tranfom)
                        .transform(new RoundedTransformation(0, 0))
                        .fit().centerCrop()
                        .into(rlEqual_2);

                if(mNext_False_Equal>=3)
                {

                    handler.postDelayed(timer_GameOver_Equal, player.getDuration()+500);

                }
                else
                {
                    currentStatus=Status.EQUAL;
                }


            }
        }
    };

    Runnable timer_GameOver_Equal= new Runnable() {
        @Override
        public void run() {
            handler.removeCallbacksAndMessages(null);
            currentStatus=Status.GAME_OVER_EQUAL;

            if(DeviceLang.equals("vi_vn"))
            {
                tv_score_equal_gameover.setText("Điểm: "+mScore_Equal);
            }
            else if(DeviceLang.equals("fr"))
            {
                tv_score_equal_gameover.setText("Score: "+mScore_Equal);
            }
            else if(DeviceLang.equals("de"))
            {
                tv_score_equal_gameover.setText("Punktzahl: "+mScore_Equal);
            }
            else
            {
                tv_score_equal_gameover.setText("Score: "+mScore_Equal);
            }


            try {
                if(mNext_False_Equal==1)
                {
                    iv_flase_equal_gameover.setImageResource(R.drawable.haimau);
                }else  if(mNext_False_Equal==2)
                {
                    iv_flase_equal_gameover.setImageResource(R.drawable.motmau);
                }else if(mNext_False_Equal==3)
                {
                    iv_flase_equal_gameover.setImageResource(R.drawable.khongmau);
                }else
                {
                    iv_flase_equal_gameover.setImageResource(R.drawable.bamau);
                }
            }catch (Exception e)
            {

            }
            viewFlipperMath.setDisplayedChild(5);
            mCdt_TimeGame.cancel();
        }
    };
    public void onClickContinueGameOverEqual(View view)
    {
        try {
            doPlayClick();
            view.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shake));
            handler.postDelayed(timer_Click_Game_Over_Equal,950);
        }catch (Exception exception)
        {

        }

    }
    Runnable timer_Click_Game_Over_Equal= new Runnable() {
        @Override
        public void run() {
            if(mGrade==20)
            {
                doShowSummary();
            }else if(DeviceLang.equals("vi_vn")&&mGrade>=2)
            {
                doStartMoutain();
            }else
            {
                if(mGrade==1)
                {
                    doShowSummary();
                }else {
                   // doStartMonkey();
                    doStartMoutain_Select();
                }
            }
        }
    };

    //endregion

    //region Equal_One

    void doStartEqual_One()
    {
        try {
            doLoadSugetEqual();
            doResetEqual();
            currentStatus=Status.EQUAL;
            viewFlipperMath.setDisplayedChild(3);
            clsHandleT.doPlaySoundAssets("start_equal.mp3",DeviceLang, player, false, MainActivity.this);
            equalAdapter1 =new EqualAdapter6(this,lstPhepToanLevel20);

          //  Log.e("toan12345","lstkk:"+lstPhepToanLevel20.size());
//            if(mISO1) {
//                gv_equal_one.getLayoutParams().width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 568, getResources().getDisplayMetrics());
//                gv_equal_one.setColumnWidth((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 180, getResources().getDisplayMetrics()));
//            }else
//            {
//                gv_equal_one.getLayoutParams().width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, (int) Math.floor(mWidthDesktop), getResources().getDisplayMetrics());
//                gv_equal_one.setColumnWidth((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, (int) Math.floor((mWidthDesktop - (20+8)) / 3), getResources().getDisplayMetrics()));
//            }

            gv_equal_one.setAdapter(equalAdapter1);

          //  Log.e("toan12345","lstkk1:"+lstPhepToanLevel20.size());
            gv_equal_one.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    if(currentStatus==Status.EQUAL) {
                        doPlayClick();
                        handler.removeCallbacksAndMessages(null);
                        currentStatus=Status.EQUAL_CLICK_1;
                        rlEqual_1=(ImageView) view.findViewById(R.id.rl_item_bg_tranfom_one);
                        //rlEqual_1.setBackgroundResource(R.drawable.item_cloud);

                        Picasso.get().load(R.drawable.item_cloud)
                                .placeholder(R.drawable.item_cloud)
                                .error(R.drawable.item_cloud)
                                .transform(new RoundedTransformation(0, 0))
                                .fit().centerCrop()
                                .into(rlEqual_1);

                        mEqual_1=lstPhepToanLevel20.get(position).getKetqua();
                        mViewEqual_1=view;
                        mPositionTMP=position;
                        try {
                            iv_avata_equal_one.setImageResource(R.drawable.monkey_answer);
                        }catch (Exception e)
                        {

                        }

                    }else  if(currentStatus==Status.EQUAL_CLICK_1&&mPositionTMP!=position)
                    {
                        doPlayClick();
                        currentStatus=Status.EQUAL_CLICK_2;
                        rlEqual_2=(ImageView) view.findViewById(R.id.rl_item_bg_tranfom_one);
                        // rlEqual_2.setBackgroundResource(R.drawable.item_cloud);

                        Picasso.get().load(R.drawable.item_cloud)
                                .placeholder(R.drawable.item_cloud)
                                .error(R.drawable.item_cloud)
                                .transform(new RoundedTransformation(0, 0))
                                .fit().centerCrop()
                                .into(rlEqual_2);

                        mEqual_2=lstPhepToanLevel20.get(position).getKetqua();
                        mViewEqual_2=view;
                        try {
                            iv_avata_equal_one.setImageResource(R.drawable.monkey_answer);
                        }catch (Exception e)
                        {

                        }

                        handler.postDelayed(timerProcessEqual, 700);

                    }
                }
            });
            // doRunTimeInGame(mFirtTime*1000,tv_time_ingame_equal_one,1);
        }catch (Exception exception)
        {
//            Log.e("toan12345","loi:"+exception);
        }

    }
    void doStartEqual_One12()
    {
        try {
            doLoadSugetEqual();
            doResetEqual();
            currentStatus=Status.EQUAL;
            viewFlipperMath.setDisplayedChild(3);
            clsHandleT.doPlaySoundAssets("start_equal.mp3",DeviceLang, player, false, MainActivity.this);
            equalOneAdapter12=new EqualOneAdapter12(this,lstPhepToanLevel20);
            if(mISO1) {
////                gv_equal_one_12.getLayoutParams().width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, (int) Math.floor(mWidthDesktop)-128, getResources().getDisplayMetrics());
////                gv_equal_one_12.setColumnWidth((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, ((int) Math.floor((mWidthDesktop)) - (128+20+9)) / 4, getResources().getDisplayMetrics()));
//
//                gv_equal_one_12.getLayoutParams().width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 629, getResources().getDisplayMetrics());
//                gv_equal_one_12.setColumnWidth((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 150, getResources().getDisplayMetrics()));
            }else
            {
                gv_equal_one_12.getLayoutParams().width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, (int) Math.floor(mWidthDesktop), getResources().getDisplayMetrics());
                gv_equal_one_12.setColumnWidth((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, ((int) Math.floor((mWidthDesktop)) - (20+9)) / 4, getResources().getDisplayMetrics()));
            }
            gv_equal_one_12.setAdapter(equalOneAdapter12);
            gv_equal_one_12.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    if(currentStatus==Status.EQUAL) {
                        doPlayClick();
                        handler.removeCallbacksAndMessages(null);
                        currentStatus=Status.EQUAL_CLICK_1;
                        rlEqual_1=(ImageView) view.findViewById(R.id.rl_item_bg_tranfom_one_12);
                        //rlEqual_1.setBackgroundResource(R.drawable.item_cloud);

                        Picasso.get().load(R.drawable.item_cloud)
                                .placeholder(R.drawable.item_cloud)
                                .error(R.drawable.item_cloud)
                                .transform(new RoundedTransformation(0, 0))
                                .fit().centerCrop()
                                .into(rlEqual_1);

                        mEqual_1=lstPhepToanLevel20.get(position).getKetqua();
                        mViewEqual_1=view;
                        mPositionTMP=position;
                        try {
                            iv_avata_equal_one_12.setImageResource(R.drawable.monkey_answer);
                        }catch (Exception e)
                        {

                        }

                    }else  if(currentStatus==Status.EQUAL_CLICK_1&&mPositionTMP!=position)
                    {
                        doPlayClick();
                        currentStatus=Status.EQUAL_CLICK_2;
                        rlEqual_2=(ImageView) view.findViewById(R.id.rl_item_bg_tranfom_one_12);
                        // rlEqual_2.setBackgroundResource(R.drawable.item_cloud);

                        Picasso.get().load(R.drawable.item_cloud)
                                .placeholder(R.drawable.item_cloud)
                                .error(R.drawable.item_cloud)
                                .transform(new RoundedTransformation(0, 0))
                                .fit().centerCrop()
                                .into(rlEqual_2);

                        mEqual_2=lstPhepToanLevel20.get(position).getKetqua();
                        mViewEqual_2=view;
                        try {
                            iv_avata_equal_one_12.setImageResource(R.drawable.monkey_answer);
                        }catch (Exception e)
                        {

                        }

                        handler.postDelayed(timerProcessEqual, 700);

                    }
                }
            });
            // doRunTimeInGame(mFirtTime*1000,tv_time_ingame_equal_one,1);
        }catch (Exception exception)
        {

        }

    }

//endregion

    //region MainGame
    Runnable timer_True_MediaPlay= new Runnable() {
        @Override
        public void run() {
            clsHandleT.doPlaySoundAssets("dung"+(rd.nextInt(5)+1)+".mp3",DeviceLang, player, false, MainActivity.this);
        }
    };

    public void doRunTimeInGame(long pTimeAll,TextView pTextView,int pGame) {
        try {

            mCdt_TimeGame=new CountDownTimer(pTimeAll,1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    mTimeLine = millisUntilFinished / 1000;
                    pTextView.setText("⏰ " +clsHandleT.CoverTimeToString((int)mTimeLine));
                    if (mTimeLine < 10) {
                        pTextView.setTextColor(Color.RED);
                        if (mTimeLine == 9) {
                            pTextView.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink_max));
                        }
                    } else {
                        pTextView.setTextColor(Color.WHITE);
                    }
                }

                @Override
                public void onFinish() {
                    if(pGame==1) {
                        handler.postDelayed(timer_GameOver_Equal, 10);
                    }else if(pGame==2)
                    {
                        handler.postDelayed(timer_GameOver_Monkey, 10);

                    }else if(pGame==3)
                    {
                        handler.postDelayed(timer_GameOver_Moutain, 10);
                    }else if(pGame==4)
                    {
                        handler.postDelayed(timer_GameOver_Moutain, 10);
                    }
                }
            };
            mCdt_TimeGame.start();
        } catch (Exception ex) {

        }
    }
    public void onClickPlayEqual(View view)
    {
        doPlayClick();
        view.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shake));
        handler.postDelayed(timer_Click_Play_Equal,950);
    }
    Runnable timer_Click_Play_Equal= new Runnable() {
        @Override
        public void run() {
            try {

                if(mGrade==1)
                {
                    if(mLevel<4) {
                        viewFlipperMath.setDisplayedChild(13);
                        doRunTimeInGame(mFirtTime * 1000, tv_time_ingame_equal_one, 1);
                    }else
                    {
                        viewFlipperMath.setDisplayedChild(14);
                        doRunTimeInGame(mFirtTime * 1000, tv_time_ingame_equal_one_12, 1);
                    }
                }else if(mGrade==20)
                {
                    if(mLevel==0) {
                        viewFlipperMath.setDisplayedChild(13);
                        doRunTimeInGame(mFirtTime * 1000, tv_time_ingame_equal_one, 1);
                    }else if(mLevel==1)
                    {
                        viewFlipperMath.setDisplayedChild(14);
                        doRunTimeInGame(mFirtTime * 1000, tv_time_ingame_equal_one_12, 1);
                    }
                    else
                    {
                        viewFlipperMath.setDisplayedChild(4);
                        doRunTimeInGame(mFirtTime*1000,tv_time_ingame_equal,1);
                    }
                }
                else
                {
                    viewFlipperMath.setDisplayedChild(4);
                    doRunTimeInGame(mFirtTime*1000,tv_time_ingame_equal,1);
                }
            }catch (Exception exception)
            {

            }
        }
    };
    public void onClickMainPlay(View view)
    {
        try {
            clsHandleT.doPlaySoundAssets("coi.mp3", "", player, false, MainActivity.this);
            tv_main_start.clearAnimation();
            tv_main_start.startAnimation(aninShake_Main);
            // viewFlipper.setDisplayedChild(1);
        }catch (Exception exception)
        {

        }
    }

    public void onClick_Share(View view)
    {
        try {
            if(currentStatus==Status.MAIN)
            {
                clsHandleT. doClickShare("https://play.google.com/store/apps/details?id=" + getApplicationContext().getPackageName(), getString(R.string.share_app),MainActivity.this);
            }
        }catch (Exception exception)
        {

        }
    }
    public void onClick_FeedBack(View view)
    {
        try {
            clsHandleT.showDialogFeedBack(MainActivity.this);
        }catch (Exception exception)
        {

        }
    }
    public void doFeedBack()
    {
        try {
            startActivity(clsHandleT.onpenFanpage(MainActivity.this));
        }catch (Exception ex)
        {

        }
    }
    public void onClickLinkApp(View view) {
        try {
            if (((int) mFirebaseRemoteConfig.getValue("link_type").asDouble()) == 2 && DeviceLang.equals("vi_vn")) {
                handler.removeCallbacksAndMessages(null);
                // ViewDialog alert = new ViewDialog();
                clsHandleT.showDialog(MainActivity.this, mFirebaseRemoteConfig.getString("link_title"), mFirebaseRemoteConfig.getString("link_content"), mFirebaseRemoteConfig.getString("link_link"), mLinkAvata, editor);
            } else if (((int) mFirebaseRemoteConfig.getValue("link_type").asDouble()) == 3 && DeviceLang.equals("vi_vn")) {
                Intent i = new Intent(Intent.ACTION_VIEW,
                        Uri.parse(mFirebaseRemoteConfig.getString("link_link")));
                startActivity(i);
            }
        } catch (Exception ex) {  // Toast.makeText(MainActivity.this, "kk:"+link.getAdType(), Toast.LENGTH_LONG).show();


        }
    }

    public void onClick_Cancel_Vip(View view)
    {
        try {
            doPlayClick();
            viewFlipperMath.setDisplayedChild(0);
        }catch (Exception exception)
        {

        }
    }

    public void onClick_Rank_Main(View view)
    {
        try {
            doPlayClick();
            viewFlipperMath.setDisplayedChild(19);
            doLoadRank();
        }catch (Exception exception)
        {

        }
    }
    public void onClick_Cancel_Vip_List(View view)
    {
        try {
            doPlayClick();
            viewFlipperMath.setDisplayedChild(0);
        }catch (Exception exception)
        {

        }
    }
    public void onClick_Detail_Buy(View view)
    {
        try {
            if(DeviceLang.equals("vi_vn"))
            {
                clsHandleT.doPlaySoundAssets("select_grade_vip.mp3",DeviceLang, player, false, MainActivity.this);
            }else
            {
                doPlayClick();
            }


            viewFlipperMath.setDisplayedChild(18);
        }catch (Exception e)
        {

        }
    }

    String[] spinnerTitlesGrade;
    CountryAdapter gradeAdapter;
    TinhAdapter tinhAdapter;
    HuyenXaAdapter huyenAdapter;
    HuyenXaAdapter xaAdapter;
    Boolean mCheckLoadRank=true;
//    String mRankGrade="";
//    String mRankTinh="";
//    String mRankHuyen="";
//    String mRankXa="";

    ArrayList<Huyen_Xa> arrayHuyen;
    ArrayList<Huyen_Xa> arrayXa;
    public void doLoadRank()
    {

        if(mCheckLoadRank)
        {
            rl_profile_detail.setVisibility(View.VISIBLE);


            if(pref.getString("namefabook", "").equals("")==false)
            {
                et_name.setText(""+pref.getString("namefabook", ""));
            }

            if(pref.getString("nameschool", "").equals("")==false)
            {
                et_school.setText(""+pref.getString("nameschool", ""));
            }

            mCheckLoadRank=false;
            spinnerTitlesGrade = new String[]{"Lớp 1","Lớp 2","Lớp 3","Lớp 4","Lớp 5"};
            gradeAdapter=new CountryAdapter(this,spinnerTitlesGrade);
            sp_lop.setAdapter(gradeAdapter);
            if(pref.getInt("vitrilop", 20)!=20)
            {
                sp_lop.setSelection(pref.getInt("vitrilop", 0));
            }
            sp_lop.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                    editor.putInt("vitrilop",i);
                    editor.putString("ranklop", ""+spinnerTitlesGrade[i].replace("ớ","o").replace(" ",""));
                    editor.commit();
if(spinnerTitlesGrade[i].contains("1"))
{
    tv_lop_top.setText("Lớp 1");
    tv_score_profile_king.setText("LV "+pref.getInt("maxgrade1", 0));
}else if(spinnerTitlesGrade[i].contains("2"))
{
    tv_lop_top.setText("Lớp 2");
    tv_score_profile_king.setText("LV "+pref.getInt("maxgrade2", 0));
}else if(spinnerTitlesGrade[i].contains("3"))
{
    tv_lop_top.setText("Lớp 3");
    tv_score_profile_king.setText("LV "+pref.getInt("maxgrade3", 0));
}else if(spinnerTitlesGrade[i].contains("4"))
{
    tv_lop_top.setText("Lớp 4");
    tv_score_profile_king.setText("LV "+pref.getInt("maxgrade4", 0));
}else
{
    tv_lop_top.setText("Lớp 5");
    tv_score_profile_king.setText("LV "+pref.getInt("maxgrade5", 0));
}

                   // clsHandleT.Loge("Grade rank:"+mRankGrade);
                }
                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
            //------------------------------------
            doLoadTinh();
            doLoadHuyen();
            doLoadXa();

            tinhAdapter=new TinhAdapter(this,arrayTinh);
            sp_tinh.setAdapter(tinhAdapter);
           // sp_tinh.setSelection(3);
            if(pref.getInt("vitritinh", 500)!=500)
            {
                sp_tinh.setSelection(pref.getInt("vitritinh", 0));
            }
            sp_tinh.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                    editor.putInt("vitritinh",i);
                    editor.putString("ranktinh", ""+arrayTinh.get(i).getName());
                    editor.commit();
                    doSpinHuyen(i);
                }
                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });


        }
    }

    public void doSpinHuyen(int pViTri)
    {
        arrayHuyen=new ArrayList<Huyen_Xa>();
        for (Huyen_Xa item:arrayHuyenFull) {
            if(item.getId_phu()==arrayTinh.get(pViTri).getId())
            {
                arrayHuyen.add(item);
            }
        }

        if(arrayHuyen.size()>0) {
            huyenAdapter = new HuyenXaAdapter(MainActivity.this, arrayHuyen);
            sp_huyen.setAdapter(huyenAdapter);

            if(pref.getInt("vitrihuyen", 20000)!=20000)
            {
                sp_huyen.setSelection(pref.getInt("vitrihuyen", 0));
            }
            sp_huyen.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                    editor.putInt("vitrihuyen",position);
                    editor.putString("rankhuyen", ""+arrayHuyen.get(position).getName());
                    editor.commit();
                    doSpinXa(position);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }
    }

    public void doSpinXa(int pViTri)
    {
        arrayXa=new ArrayList<Huyen_Xa>();
        for (Huyen_Xa item:arrayXaFull) {
            if(item.getId_phu()==arrayHuyen.get(pViTri).getId())
            {
                arrayXa.add(item);
            }
        }
        if(arrayXa.size()>0)
        {
            xaAdapter=new HuyenXaAdapter(MainActivity.this,arrayXa);
            sp_xa.setAdapter(xaAdapter);
            if(pref.getInt("vitrixa", 20000)!=20000)
            {
                sp_xa.setSelection(pref.getInt("vitrixa", 0));
            }
            sp_xa.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                    editor.putInt("vitrixa",position);
                    editor.putString("rankxa", ""+arrayXa.get(position).getName());
                    editor.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }
    }
    ArrayList<Tinh> arrayTinh;
    void doLoadTinh()
    {
        try {
            arrayTinh=new ArrayList<Tinh>();
            tmpString=clsHandleT.LoadDataAssets("tinhthanhpho.txt",MainActivity.this);
            if(!tmpString.equals(""))
            {
                if (tmpString.contains("}")) {
                    String[] mang = tmpString.split("\\}");
                    Tinh loiVan;
                    for (int i = 0; i < mang.length; i++) {
                        if (mang[i].contains("^")) {
                            String[] items = mang[i].split("\\^");
                            try{
                                loiVan=new Tinh();
                                loiVan.setId(Integer.parseInt(items[0]));
                                loiVan.setName(items[1]);
                                arrayTinh.add(loiVan);

                            }
                            catch (Exception ex) {
                                // Log.e("exx:",""+ex);

                                continue;
                            }
                        }
                    }
                }
            }
        }catch (Exception e)
        {

        }
    }
    ArrayList<Huyen_Xa> arrayHuyenFull;
    void doLoadHuyen()
    {
        try {
            arrayHuyenFull=new ArrayList<Huyen_Xa>();
            tmpString=clsHandleT.LoadDataAssets("huyenthitran.txt",MainActivity.this);
            if(!tmpString.equals(""))
            {
                if (tmpString.contains("}")) {
                    String[] mang = tmpString.split("\\}");
                    Huyen_Xa loiVan;
                    for (int i = 0; i < mang.length; i++) {
                        if (mang[i].contains("^")) {
                            String[] items = mang[i].split("\\^");
                            try{
                                loiVan=new Huyen_Xa();
                                loiVan.setId(Integer.parseInt(items[0]));
                                loiVan.setName(items[1]);
                                loiVan.setId_phu(Integer.parseInt(items[2]));
                                arrayHuyenFull.add(loiVan);

                            }
                            catch (Exception ex) {
                                // Log.e("exx:",""+ex);

                                continue;
                            }
                        }
                    }
                }
            }
        }catch (Exception e)
        {

        }
    }
    ArrayList<Huyen_Xa> arrayXaFull;
    void doLoadXa()
    {
        try {
            arrayXaFull=new ArrayList<Huyen_Xa>();
            tmpString=clsHandleT.LoadDataAssets("xaphuong.txt",MainActivity.this);
            if(!tmpString.equals(""))
            {
                if (tmpString.contains("}")) {
                    String[] mang = tmpString.split("\\}");
                    Huyen_Xa loiVan;
                    for (int i = 0; i < mang.length; i++) {
                        if (mang[i].contains("^")) {
                            String[] items = mang[i].split("\\^");
                            try{
                                loiVan=new Huyen_Xa();
                                loiVan.setId(Integer.parseInt(items[0]));
                                loiVan.setName(items[1]);
                                loiVan.setId_phu(Integer.parseInt(items[2]));
                                arrayXaFull.add(loiVan);

                            }
                            catch (Exception ex) {
                                // Log.e("exx:",""+ex);

                                continue;
                            }
                        }
                    }
                }
            }
        }catch (Exception e)
        {

        }
    }

    ArrayList<UserFirebase> lstUserMax;
    ArrayList<UserFirebase> lstUserMax_CheckMyTop;
    public void onClick_GhiDanh(View view)
    {
        if(et_school.length()>3&&et_name.length()>5) {
            doLoadRankAdd();
            rl_profile_detail.setVisibility(View.GONE);
        }else
        {
            CustomToast.makeText(MainActivity.this,"Vui lòng nhập đầy đủ tên trường và tên của học sinh !",CustomToast.LONG,true).show();
        }
    }

    int mGradeRankAdd=1;
    private UserAdapter mUserAdapter ;
    public void doLoadRankAdd()
    {
        try {
         //   mDatabase
            lstUserMax = new ArrayList<UserFirebase>();
            tv_rank_school.setText(et_school.getText());
            tv_name_profile_king.setText(et_name.getText());



            tv_rank_tinh.setText(pref.getString("ranktinh", ""));
            tv_rank_huyen.setText(pref.getString("rankhuyen", ""));
            tv_rank_xa.setText(pref.getString("rankxa", ""));
            tv_rank_school.setText(pref.getString("nameschool", ""));

            editor.putString("namefabook", ""+et_name.getText());
            editor.putString("nameschool", ""+et_school.getText());
            if (pref.getString("keyname", "").equals("")) {
                editor.putString("keyname", mDatabase.push().getKey());
            }
            editor.commit();

            if(pref.getString("ranklop", "").contains("5"))
            {
                mGradeRankAdd=5;
            }else  if(pref.getString("ranklop", "").contains("2"))
            {
                mGradeRankAdd=2;
            }else  if(pref.getString("ranklop", "").contains("3"))
            {
                mGradeRankAdd=3;
            }else  if(pref.getString("ranklop", "").contains("4"))
            {
                mGradeRankAdd=4;
            }else
            {
                mGradeRankAdd=1;
            }



            UserFirebase userFirebase=new UserFirebase(pref.getString("keyname", ""),clsHandleT.capitalizeWords(pref.getString("namefabook", "")),clsHandleT.capitalizeWords(pref.getString("nameschool", "")),
                    pref.getString("ranktinh", ""),pref.getString("rankhuyen", ""),pref.getString("rankxa", ""),pref.getString("ranklop", ""),pref.getInt("maxgrade" + mGradeRankAdd, 0));
            mDatabase.child("users").child("vannien_"+pref.getString("ranklop", "")).child(pref.getString("keyname", "")).setValue(userFirebase);
            mDatabase.child("users").child("vannien_"+pref.getString("ranklop", "")).addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    UserFirebase user = snapshot.getValue(UserFirebase.class);
                    lstUserMax.add(user);
                    Collections.sort(lstUserMax, new Comparator<UserFirebase>() {
                        @Override
                        public int compare(UserFirebase lhs, UserFirebase rhs) {
                            if (lhs.getLevel() > rhs.getLevel()) {
                                return -1;
                            }  else {
                                return 1;
                            }
                        }
                    });

                    if(lstUserMax.size()>101) {
                        lstUserMax = new ArrayList<UserFirebase>(lstUserMax.subList(0, 100));
                    }
                    mUserAdapter = new UserAdapter(MainActivity.this,lstUserMax);
                    recyclerUser_king.setAdapter(mUserAdapter);
                    recyclerUser_king.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                }

                @Override
                public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                }

                @Override
                public void onChildRemoved(@NonNull DataSnapshot snapshot) {

                }

                @Override
                public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }


            });

            //------------------

            lstUserMax_CheckMyTop = new ArrayList<UserFirebase>();
            mDatabase.child("users").child("vannien_"+pref.getString("ranklop", "")).addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    UserFirebase user = snapshot.getValue(UserFirebase.class);
                    lstUserMax_CheckMyTop.add(user);
                    Collections.sort(lstUserMax_CheckMyTop, new Comparator<UserFirebase>() {
                        @Override
                        public int compare(UserFirebase lhs, UserFirebase rhs) {
                            if (lhs.getLevel() > rhs.getLevel()) {
                                return -1;
                            }  else {
                                return 1;
                            }
                        }
                    });
                    if (pref.getString("keyname", "") != "" && lstUserMax_CheckMyTop.size() > 0) {
                        for (int i = 0; i < lstUserMax_CheckMyTop.size(); i++) {
                            if (lstUserMax_CheckMyTop.get(i).getKey().equals(pref.getString("keyname", ""))) {

                                tv_top_profile_king.setText("TOP " + (i + 1));
                                break;
                            }
                        }
                    }

                }

                @Override
                public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                }

                @Override
                public void onChildRemoved(@NonNull DataSnapshot snapshot) {

                }

                @Override
                public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }


            });


        }catch (Exception exception)
        {
           // clsHandleT.Loge("loi:"+exception);
        }
    }

    public void onClickRankCancel(View view) {
        try {
            lstUserMax = new ArrayList<UserFirebase>();
            tv_rank_school.setText(pref.getString("nameschool", ""));
            tv_name_profile_king.setText(pref.getString("namefabook", ""));
            tv_rank_tinh.setText(pref.getString("ranktinh", ""));
            tv_rank_huyen.setText(pref.getString("rankhuyen", ""));
            tv_rank_xa.setText(pref.getString("rankxa", ""));
            tv_rank_school.setText(pref.getString("nameschool", ""));

            if(pref.getString("ranklop", "").contains("5"))
            {
                mGradeRankAdd=5;
                tv_lop_top.setText("Lớp 5");
            }else  if(pref.getString("ranklop", "").contains("2"))
            {
                mGradeRankAdd=2;
                tv_lop_top.setText("Lớp 2");
            }else  if(pref.getString("ranklop", "").contains("3"))
            {
                mGradeRankAdd=3;
                tv_lop_top.setText("Lớp 3");
            }else  if(pref.getString("ranklop", "").contains("4"))
            {
                mGradeRankAdd=4;
                tv_lop_top.setText("Lớp 4");
            }else
            {
                mGradeRankAdd=1;
                tv_lop_top.setText("Lớp 1");
            }
            tv_score_profile_king.setText("LV "+pref.getInt("maxgrade" + mGradeRankAdd, 0));

            mDatabase.child("users").child("vannien_"+pref.getString("ranklop", "")).addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    UserFirebase user = snapshot.getValue(UserFirebase.class);
                    //  Log.e("lol",""+user.getName());
                    lstUserMax.add(user);
                    Collections.sort(lstUserMax, new Comparator<UserFirebase>() {
                        @Override
                        public int compare(UserFirebase lhs, UserFirebase rhs) {
                            if (lhs.getLevel() > rhs.getLevel()) {
                                return -1;
                            } else {

                                return 1;

                            }
                        }
                    });
                    if (lstUserMax.size() > 101) {
                        lstUserMax = new ArrayList<UserFirebase>(lstUserMax.subList(0, 100));
                    }


                    mUserAdapter = new UserAdapter(MainActivity.this,lstUserMax);
                    recyclerUser_king.setAdapter(mUserAdapter);
                    recyclerUser_king.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                }

                @Override
                public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                }

                @Override
                public void onChildRemoved(@NonNull DataSnapshot snapshot) {

                }

                @Override
                public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

            rl_profile_detail.setVisibility(View.GONE);
        } catch (Exception exception) {

        }
    }


    public void onClick_Vip_Love(View view)
    {
        try {
                clsHandleT.showDialog_Award_Love(MainActivity.this,pref.getString("namefabook", ""),mFirebaseRemoteConfig.getString("lien_he_zalo"));
        }catch (Exception e)
        {

        }
    }

    Award_Love award_love;
    public void doSend_Award_Love(String pName,String pCode)
    {
        try {
            mDatabase.child("award_vip").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    try {

                        award_love = dataSnapshot.getValue(Award_Love.class);

                        doUpdate_Award_Love(award_love,pName,pCode.toLowerCase());

                    } catch (Exception ex) {

                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // Log.e("loi",""+databaseError);

                }
            });
        }catch (Exception e)
        {

        }
    }
    public void doUpdate_Award_Love(Award_Love pAward_Love,String pName,String pCode)
    {
        if(pAward_Love.getLop1().contains(pCode.trim()))
        {
            mMemberVip1 = 20;
            editor.putInt("vips", mMemberVip1);
            editor.commit();

             mDatabase.child("award_vip").child("lop1").setValue("a"+(10000 + rd.nextInt(90000)));
             mDatabase.child("user_award").child("lop1_"+calendar.get(Calendar.YEAR)+"_"+(calendar.get(Calendar.MONTH)+1)+"_"+calendar.get(Calendar.DAY_OF_MONTH)).setValue(""+pName.trim());
            CustomToast.makeText(this,"Phản hồi thành công !",CustomToast.LONG,true);
            clsHandleT.doPlaySoundAssets("phanhoi_done.mp3",DeviceLang, player, false, MainActivity.this);
        }

        if(pAward_Love.getLop2().contains(pCode.trim()))
        {
            mMemberVip2 = 20;
            editor.putInt("vips2", mMemberVip2);
            editor.commit();

            mDatabase.child("award_vip").child("lop2").setValue("b"+(10000 + rd.nextInt(90000)));
            mDatabase.child("user_award").child("lop2_"+calendar.get(Calendar.YEAR)+"_"+(calendar.get(Calendar.MONTH)+1)+"_"+calendar.get(Calendar.DAY_OF_MONTH)).setValue(""+pName.trim());
            CustomToast.makeText(this,"Phản hồi thành công !",CustomToast.LONG,true);
            clsHandleT.doPlaySoundAssets("phanhoi_done.mp3",DeviceLang, player, false, MainActivity.this);
        }

        if(pAward_Love.getLop3().contains(pCode.trim()))
        {
            mMemberVip3 = 20;
            editor.putInt("vips3", mMemberVip3);
            editor.commit();

            mDatabase.child("award_vip").child("lop3").setValue("c"+(10000 + rd.nextInt(90000)));
            mDatabase.child("user_award").child("lop3_"+calendar.get(Calendar.YEAR)+"_"+(calendar.get(Calendar.MONTH)+1)+"_"+calendar.get(Calendar.DAY_OF_MONTH)).setValue(""+pName.trim());
            CustomToast.makeText(this,"Phản hồi thành công !",CustomToast.LONG,true);
            clsHandleT.doPlaySoundAssets("phanhoi_done.mp3",DeviceLang, player, false, MainActivity.this);
        }

        if(pAward_Love.getLop4().contains(pCode.trim()))
        {
            mMemberVip4 = 20;
            editor.putInt("vips4", mMemberVip4);
            editor.commit();

            mDatabase.child("award_vip").child("lop4").setValue("d"+(10000 + rd.nextInt(90000)));
            mDatabase.child("user_award").child("lop4_"+calendar.get(Calendar.YEAR)+"_"+(calendar.get(Calendar.MONTH)+1)+"_"+calendar.get(Calendar.DAY_OF_MONTH)).setValue(""+pName.trim());

            CustomToast.makeText(this,"Phản hồi thành công !",CustomToast.LONG,true);
            clsHandleT.doPlaySoundAssets("phanhoi_done.mp3",DeviceLang, player, false, MainActivity.this);
        }

        if(pAward_Love.getLop5().contains(pCode.trim()))
        {
            mMemberVip5 = 20;
            editor.putInt("vips5", mMemberVip5);
            editor.commit();

            mDatabase.child("award_vip").child("lop5").setValue("e"+(10000 + rd.nextInt(90000)));
            mDatabase.child("user_award").child("lop5_"+calendar.get(Calendar.YEAR)+"_"+(calendar.get(Calendar.MONTH)+1)+"_"+calendar.get(Calendar.DAY_OF_MONTH)).setValue(""+pName.trim());

            CustomToast.makeText(this,"Phản hồi thành công !",CustomToast.LONG,true);
            clsHandleT.doPlaySoundAssets("phanhoi_done.mp3",DeviceLang, player, false, MainActivity.this);
        }

        if(pAward_Love.getFlag().contains(pCode.trim()))
        {
            mMemberVip_Flag = 20;
            editor.putInt("vipsflag", mMemberVip_Flag);
            editor.commit();

            mDatabase.child("award_vip").child("flag").setValue("f"+(10000 + rd.nextInt(90000)));
            mDatabase.child("user_award").child("flag_"+calendar.get(Calendar.YEAR)+"_"+(calendar.get(Calendar.MONTH)+1)+"_"+calendar.get(Calendar.DAY_OF_MONTH)).setValue(""+pName.trim());

            CustomToast.makeText(this,"Phản hồi thành công !",CustomToast.LONG,true);
            clsHandleT.doPlaySoundAssets("phanhoi_done.mp3",DeviceLang, player, false, MainActivity.this);
        }

        if(pAward_Love.getLopall().contains(pCode.trim()))
        {
            mMemberVip1 = 20;
            mMemberVip2 = 20;
            mMemberVip3 = 20;
            mMemberVip4 = 20;
            mMemberVip5 = 20;
            mMemberVip_Flag = 20;
            mMemberVip_All = 20;
            editor.putInt("vips", mMemberVip1);
            editor.putInt("vips2", mMemberVip2);
            editor.putInt("vips3", mMemberVip3);
            editor.putInt("vips4", mMemberVip4);
            editor.putInt("vips5", mMemberVip5);
            editor.putInt("vipsflag", mMemberVip_Flag);
            editor.putInt("vipsall", mMemberVip_All);
            editor.commit();

            mDatabase.child("award_vip").child("lopall").setValue("m"+(10000 + rd.nextInt(90000)));
            mDatabase.child("user_award").child("lopall_"+calendar.get(Calendar.YEAR)+"_"+(calendar.get(Calendar.MONTH)+1)+"_"+calendar.get(Calendar.DAY_OF_MONTH)).setValue(""+pName.trim());

            CustomToast.makeText(this,"Phản hồi thành công !",CustomToast.LONG,true);
            clsHandleT.doPlaySoundAssets("phanhoi_done.mp3",DeviceLang, player, false, MainActivity.this);
        }


    }


    //    public void onClick_Buy_Vip_Now(View view)
//    {
//        clsHandleT.doPlaySoundAssets("click.ogg", "", player, false, this);
//    }
    public void onClick_Buy_Vip_Main(View view)
    {
        doBuyVipMain();
    }
    Boolean checlLoadVip=true;
    public void  doBuyVipMain()
    {
        try
        {

            if(checlLoadVip) {

                setupBillingClient();
                doCheckTextItemVip();

                checlLoadVip=false;
            }

            viewFlipperMath.setDisplayedChild(16);
            currentStatus=Status.MAIN;
            clsHandleT.doPlaySoundAssets("pro.mp3",DeviceLang, player, false, MainActivity.this);

//            logRevenue(50000,"VND",sku_grade_1,"PRO_9");
//
//            Bundle bundle = new Bundle();
//            bundle.putString("event_name", "test_event");
//            mFirebaseAnalytics.logEvent("test_event", bundle);

        }catch (Exception exception)
        {
            //Log.e("toan12345","loi j:"+exception);
        }
    }
    BillingClient billingClient;
    String sku_grade_1 = "com.violympic.toanlop1.viplevel";
    String sku_grade_2 = "com.violympic.toanlop1.viplevel2";
    String sku_grade_3 = "com.violympic.toanlop1.viplevel3";
    String sku_grade_4 = "com.violympic.toanlop1.viplevel4";
    String sku_grade_5 = "com.violympic.toanlop1.viplevel5";

    String sku_grade_flag = "com.violympic.toanlop1.vipflag";
    String sku_grade_all = "com.violympic.toanlop1.viplevelall";
    // List skuList = new ArrayList();


    public void setupBillingClient() {

        billingClient = BillingClient.newBuilder(MainActivity.this)
                .setListener(purchaseUpdateListener)
                .enablePendingPurchases()
                .build();

        billingClient.startConnection(new BillingClientStateListener() {
            @Override
            public void onBillingSetupFinished(BillingResult billingResult) {
                if (billingResult.getResponseCode() == BillingClient.BillingResponseCode.OK) {
                    // The BillingClient is ready. You can query purchases here.

                    loadAllSKUs_Grade1();
                    loadAllSKUs_Grade2();
                    loadAllSKUs_Grade3();
                    loadAllSKUs_Grade4();
                    loadAllSKUs_Grade5();
                    loadAllSKUs_Grade_Flag();
                    loadAllSKUs_Grade_All();
                }
            }

            @Override
            public void onBillingServiceDisconnected() {
                // Try to restart the connection on the next request to
                // Google Play by calling the startConnection() method.

            }
        });
    }

    public void loadAllSKUs_Grade1() {

        if (billingClient.isReady()) {

            try {

                billingClient.queryPurchasesAsync(
                        QueryPurchasesParams.newBuilder()
                                .setProductType(BillingClient.ProductType.INAPP)
                                .build(),
                        new PurchasesResponseListener() {
                            public void onQueryPurchasesResponse(BillingResult billingResult, List purchases) {
                                // check billingResult
                                // process returned purchase list, e.g. display the plans user owns
                                if (purchases == null) {
                                    //Không có sản phẩm đã mua nào
                                    // Log.e("queryPurchasesAsync","khong co san pham nao da mua");
                                } else {
                                    //xử lý khi có sản phẩm đã mua
                                    // Log.e("queryPurchases",""+purchases.get(0).toString());
                                    if(purchases.get(0).toString().contains(sku_grade_1)&&purchases.get(0).toString().contains("\"acknowledged\":true"))
                                    {
                                        try {
                                            handler.postDelayed(ThreadReActivated_Grade1,2500);
                                        }catch (Exception exception)
                                        {

                                        }


                                    }
                                }
                            }
                        }
                );
            }catch (Exception ex)
            {

            }




            QueryProductDetailsParams queryProductDetailsParams =
                    QueryProductDetailsParams.newBuilder()
                            .setProductList(
                                    ImmutableList.of(
                                            QueryProductDetailsParams.Product.newBuilder()
                                                    .setProductId(sku_grade_1)
                                                    .setProductType(BillingClient.ProductType.INAPP)
                                                    .build()))
                            .build();

            billingClient.queryProductDetailsAsync(
                    queryProductDetailsParams,
                    new ProductDetailsResponseListener() {
                        public void onProductDetailsResponse(BillingResult billingResult,
                                                             List<ProductDetails> productDetailsList) {
                            // check billingResult
                            // process returned productDetailsList
                            if (billingResult.getResponseCode() == BillingClient.BillingResponseCode.OK) {
                                if (!productDetailsList.isEmpty()) {
                                    final ProductDetails productDetails = (ProductDetails) productDetailsList.get(0);


                                    MainActivity.this.runOnUiThread(() -> {

                                        // Log.e("toan12345","loi j:789");
                                        ll_item_vip1.setVisibility(View.VISIBLE);
                                        // Log.e("toan12345","loi j:123");
                                        ll_item_vip1.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {

                                                if(mMemberVip1==10)
                                                {
                                                    tv_item_vip1.setText(getString(R.string.vip1_check));

                                                    if(DeviceLang.equals("vi_vn"))
                                                    {
                                                        clsHandleT.doPlaySoundAssets("vip_done1.mp3",DeviceLang, player, false, MainActivity.this);
                                                    }else
                                                    {
                                                        clsHandleT.doPlaySoundAssets("win.mp3", "", player, false, MainActivity.this);
                                                    }
                                                }else
                                                {
                                                    tv_item_vip1.setText(getString(R.string.vip1_warning));

                                                    BillingFlowParams billingFlowParams =
                                                            BillingFlowParams.newBuilder()
                                                                    .setProductDetailsParamsList(
                                                                            ImmutableList.of(
                                                                                    BillingFlowParams.ProductDetailsParams.newBuilder()
                                                                                            .setProductDetails(productDetails)
                                                                                            .build()
                                                                            )
                                                                    )
                                                                    .build();

                                                    billingClient.launchBillingFlow(MainActivity.this, billingFlowParams);

                                                }


                                            }
                                        });

                                    });

                                }

                            }

                        }
                    }
            );


        }

    }
    public void loadAllSKUs_Grade2() {

        if (billingClient.isReady()) {

            try {

                billingClient.queryPurchasesAsync(
                        QueryPurchasesParams.newBuilder()
                                .setProductType(BillingClient.ProductType.INAPP)
                                .build(),
                        new PurchasesResponseListener() {
                            public void onQueryPurchasesResponse(BillingResult billingResult, List purchases) {
                                // check billingResult
                                // process returned purchase list, e.g. display the plans user owns
                                if (purchases == null) {
                                    //Không có sản phẩm đã mua nào
                                    // Log.e("queryPurchasesAsync","khong co san pham nao da mua");
                                } else {
                                    //xử lý khi có sản phẩm đã mua
                                    // Log.e("queryPurchases",""+purchases.get(0).toString());
                                    if(purchases.get(0).toString().contains(sku_grade_2)&&purchases.get(0).toString().contains("\"acknowledged\":true"))
                                    {
                                        try {
                                            handler.postDelayed(ThreadReActivated_Grade2,2500);
                                        }catch (Exception exception)
                                        {

                                        }


                                    }
                                }
                            }
                        }
                );
            }catch (Exception ex)
            {

            }




            QueryProductDetailsParams queryProductDetailsParams =
                    QueryProductDetailsParams.newBuilder()
                            .setProductList(
                                    ImmutableList.of(
                                            QueryProductDetailsParams.Product.newBuilder()
                                                    .setProductId(sku_grade_2)
                                                    .setProductType(BillingClient.ProductType.INAPP)
                                                    .build()))
                            .build();

            billingClient.queryProductDetailsAsync(
                    queryProductDetailsParams,
                    new ProductDetailsResponseListener() {
                        public void onProductDetailsResponse(BillingResult billingResult,
                                                             List<ProductDetails> productDetailsList) {
                            // check billingResult
                            // process returned productDetailsList
                            if (billingResult.getResponseCode() == BillingClient.BillingResponseCode.OK) {
                                if (!productDetailsList.isEmpty()) {
                                    final ProductDetails productDetails = (ProductDetails) productDetailsList.get(0);


                                    MainActivity.this.runOnUiThread(() -> {

                                        // Log.e("toan12345","loi j:789");
                                        ll_item_vip2.setVisibility(View.VISIBLE);
                                        // Log.e("toan12345","loi j:123");
                                        ll_item_vip2.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {

                                                if(mMemberVip2==10)
                                                {
                                                    tv_item_vip2.setText(getString(R.string.vip2_check));

                                                    if(DeviceLang.equals("vi_vn"))
                                                    {
                                                        clsHandleT.doPlaySoundAssets("vip_done2.mp3",DeviceLang, player, false, MainActivity.this);
                                                    }else
                                                    {
                                                        clsHandleT.doPlaySoundAssets("win.mp3", "", player, false, MainActivity.this);
                                                    }
                                                }else
                                                {
                                                    tv_item_vip2.setText(getString(R.string.vip2_warning));

                                                    BillingFlowParams billingFlowParams =
                                                            BillingFlowParams.newBuilder()
                                                                    .setProductDetailsParamsList(
                                                                            ImmutableList.of(
                                                                                    BillingFlowParams.ProductDetailsParams.newBuilder()
                                                                                            .setProductDetails(productDetails)
                                                                                            .build()
                                                                            )
                                                                    )
                                                                    .build();

                                                    billingClient.launchBillingFlow(MainActivity.this, billingFlowParams);

                                                }


                                            }
                                        });

                                    });

                                }

                            }

                        }
                    }
            );


        }

    }
    public void loadAllSKUs_Grade3() {

        if (billingClient.isReady()) {

            try {

                billingClient.queryPurchasesAsync(
                        QueryPurchasesParams.newBuilder()
                                .setProductType(BillingClient.ProductType.INAPP)
                                .build(),
                        new PurchasesResponseListener() {
                            public void onQueryPurchasesResponse(BillingResult billingResult, List purchases) {
                                // check billingResult
                                // process returned purchase list, e.g. display the plans user owns
                                if (purchases == null) {
                                    //Không có sản phẩm đã mua nào
                                    // Log.e("queryPurchasesAsync","khong co san pham nao da mua");
                                } else {
                                    //xử lý khi có sản phẩm đã mua
                                    // Log.e("queryPurchases",""+purchases.get(0).toString());
                                    if(purchases.get(0).toString().contains(sku_grade_3)&&purchases.get(0).toString().contains("\"acknowledged\":true"))
                                    {
                                        try {
                                            handler.postDelayed(ThreadReActivated_Grade3,2500);
                                        }catch (Exception exception)
                                        {

                                        }


                                    }
                                }
                            }
                        }
                );
            }catch (Exception ex)
            {

            }




            QueryProductDetailsParams queryProductDetailsParams =
                    QueryProductDetailsParams.newBuilder()
                            .setProductList(
                                    ImmutableList.of(
                                            QueryProductDetailsParams.Product.newBuilder()
                                                    .setProductId(sku_grade_3)
                                                    .setProductType(BillingClient.ProductType.INAPP)
                                                    .build()))
                            .build();

            billingClient.queryProductDetailsAsync(
                    queryProductDetailsParams,
                    new ProductDetailsResponseListener() {
                        public void onProductDetailsResponse(BillingResult billingResult,
                                                             List<ProductDetails> productDetailsList) {
                            // check billingResult
                            // process returned productDetailsList
                            if (billingResult.getResponseCode() == BillingClient.BillingResponseCode.OK) {
                                if (!productDetailsList.isEmpty()) {
                                    final ProductDetails productDetails = (ProductDetails) productDetailsList.get(0);


                                    MainActivity.this.runOnUiThread(() -> {

                                        // Log.e("toan12345","loi j:789");
                                        ll_item_vip3.setVisibility(View.VISIBLE);
                                        // Log.e("toan12345","loi j:123");
                                        ll_item_vip3.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {

                                                if(mMemberVip3==10)
                                                {
                                                    tv_item_vip3.setText(getString(R.string.vip3_check));
                                                    if(DeviceLang.equals("vi_vn"))
                                                    {
                                                        clsHandleT.doPlaySoundAssets("vip_done3.mp3",DeviceLang, player, false, MainActivity.this);
                                                    }else
                                                    {
                                                        clsHandleT.doPlaySoundAssets("win.mp3", "", player, false, MainActivity.this);
                                                    }
                                                }else
                                                {
                                                    tv_item_vip3.setText(getString(R.string.vip3_warning));

                                                    BillingFlowParams billingFlowParams =
                                                            BillingFlowParams.newBuilder()
                                                                    .setProductDetailsParamsList(
                                                                            ImmutableList.of(
                                                                                    BillingFlowParams.ProductDetailsParams.newBuilder()
                                                                                            .setProductDetails(productDetails)
                                                                                            .build()
                                                                            )
                                                                    )
                                                                    .build();

                                                    billingClient.launchBillingFlow(MainActivity.this, billingFlowParams);

                                                }


                                            }
                                        });

                                    });

                                }

                            }

                        }
                    }
            );


        }

    }
    public void loadAllSKUs_Grade4() {

        if (billingClient.isReady()) {

            try {

                billingClient.queryPurchasesAsync(
                        QueryPurchasesParams.newBuilder()
                                .setProductType(BillingClient.ProductType.INAPP)
                                .build(),
                        new PurchasesResponseListener() {
                            public void onQueryPurchasesResponse(BillingResult billingResult, List purchases) {
                                // check billingResult
                                // process returned purchase list, e.g. display the plans user owns
                                if (purchases == null) {
                                    //Không có sản phẩm đã mua nào
                                    // Log.e("queryPurchasesAsync","khong co san pham nao da mua");
                                } else {
                                    //xử lý khi có sản phẩm đã mua
                                    // Log.e("queryPurchases",""+purchases.get(0).toString());
                                    if(purchases.get(0).toString().contains(sku_grade_4)&&purchases.get(0).toString().contains("\"acknowledged\":true"))
                                    {
                                        try {
                                            handler.postDelayed(ThreadReActivated_Grade4,2500);
                                        }catch (Exception exception)
                                        {

                                        }


                                    }
                                }
                            }
                        }
                );
            }catch (Exception ex)
            {

            }




            QueryProductDetailsParams queryProductDetailsParams =
                    QueryProductDetailsParams.newBuilder()
                            .setProductList(
                                    ImmutableList.of(
                                            QueryProductDetailsParams.Product.newBuilder()
                                                    .setProductId(sku_grade_4)
                                                    .setProductType(BillingClient.ProductType.INAPP)
                                                    .build()))
                            .build();

            billingClient.queryProductDetailsAsync(
                    queryProductDetailsParams,
                    new ProductDetailsResponseListener() {
                        public void onProductDetailsResponse(BillingResult billingResult,
                                                             List<ProductDetails> productDetailsList) {
                            // check billingResult
                            // process returned productDetailsList
                            if (billingResult.getResponseCode() == BillingClient.BillingResponseCode.OK) {
                                if (!productDetailsList.isEmpty()) {
                                    final ProductDetails productDetails = (ProductDetails) productDetailsList.get(0);


                                    MainActivity.this.runOnUiThread(() -> {

                                        // Log.e("toan12345","loi j:789");
                                        ll_item_vip4.setVisibility(View.VISIBLE);
                                        // Log.e("toan12345","loi j:123");
                                        ll_item_vip4.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {

                                                if(mMemberVip4==10)
                                                {
                                                    tv_item_vip4.setText(getString(R.string.vip4_check));
                                                    if(DeviceLang.equals("vi_vn"))
                                                    {
                                                        clsHandleT.doPlaySoundAssets("vip_done4.mp3",DeviceLang, player, false, MainActivity.this);
                                                    }else
                                                    {
                                                        clsHandleT.doPlaySoundAssets("win.mp3", "", player, false, MainActivity.this);
                                                    }
                                                }else
                                                {
                                                    tv_item_vip4.setText(getString(R.string.vip4_warning));

                                                    BillingFlowParams billingFlowParams =
                                                            BillingFlowParams.newBuilder()
                                                                    .setProductDetailsParamsList(
                                                                            ImmutableList.of(
                                                                                    BillingFlowParams.ProductDetailsParams.newBuilder()
                                                                                            .setProductDetails(productDetails)
                                                                                            .build()
                                                                            )
                                                                    )
                                                                    .build();

                                                    billingClient.launchBillingFlow(MainActivity.this, billingFlowParams);

                                                }


                                            }
                                        });

                                    });

                                }

                            }

                        }
                    }
            );


        }

    }
    public void loadAllSKUs_Grade5() {

        if (billingClient.isReady()) {

            try {

                billingClient.queryPurchasesAsync(
                        QueryPurchasesParams.newBuilder()
                                .setProductType(BillingClient.ProductType.INAPP)
                                .build(),
                        new PurchasesResponseListener() {
                            public void onQueryPurchasesResponse(BillingResult billingResult, List purchases) {
                                // check billingResult
                                // process returned purchase list, e.g. display the plans user owns
                                if (purchases == null) {
                                    //Không có sản phẩm đã mua nào
                                    // Log.e("queryPurchasesAsync","khong co san pham nao da mua");
                                } else {
                                    //xử lý khi có sản phẩm đã mua
                                    // Log.e("queryPurchases",""+purchases.get(0).toString());
                                    if(purchases.get(0).toString().contains(sku_grade_5)&&purchases.get(0).toString().contains("\"acknowledged\":true"))
                                    {
                                        try {
                                            handler.postDelayed(ThreadReActivated_Grade5,2500);
                                        }catch (Exception exception)
                                        {

                                        }


                                    }
                                }
                            }
                        }
                );
            }catch (Exception ex)
            {

            }




            QueryProductDetailsParams queryProductDetailsParams =
                    QueryProductDetailsParams.newBuilder()
                            .setProductList(
                                    ImmutableList.of(
                                            QueryProductDetailsParams.Product.newBuilder()
                                                    .setProductId(sku_grade_5)
                                                    .setProductType(BillingClient.ProductType.INAPP)
                                                    .build()))
                            .build();

            billingClient.queryProductDetailsAsync(
                    queryProductDetailsParams,
                    new ProductDetailsResponseListener() {
                        public void onProductDetailsResponse(BillingResult billingResult,
                                                             List<ProductDetails> productDetailsList) {
                            // check billingResult
                            // process returned productDetailsList
                            if (billingResult.getResponseCode() == BillingClient.BillingResponseCode.OK) {
                                if (!productDetailsList.isEmpty()) {
                                    final ProductDetails productDetails = (ProductDetails) productDetailsList.get(0);


                                    MainActivity.this.runOnUiThread(() -> {

                                        // Log.e("toan12345","loi j:789");
                                        ll_item_vip5.setVisibility(View.VISIBLE);
                                        // Log.e("toan12345","loi j:123");
                                        ll_item_vip5.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {

                                                if(mMemberVip5==10)
                                                {
                                                    tv_item_vip5.setText(getString(R.string.vip5_check));
                                                    if(DeviceLang.equals("vi_vn"))
                                                    {
                                                        clsHandleT.doPlaySoundAssets("vip_done5.mp3",DeviceLang, player, false, MainActivity.this);
                                                    }else
                                                    {
                                                        clsHandleT.doPlaySoundAssets("win.mp3", "", player, false, MainActivity.this);
                                                    }
                                                }else
                                                {
                                                    tv_item_vip5.setText(getString(R.string.vip5_warning));

                                                    BillingFlowParams billingFlowParams =
                                                            BillingFlowParams.newBuilder()
                                                                    .setProductDetailsParamsList(
                                                                            ImmutableList.of(
                                                                                    BillingFlowParams.ProductDetailsParams.newBuilder()
                                                                                            .setProductDetails(productDetails)
                                                                                            .build()
                                                                            )
                                                                    )
                                                                    .build();

                                                    billingClient.launchBillingFlow(MainActivity.this, billingFlowParams);

                                                }


                                            }
                                        });

                                    });

                                }

                            }

                        }
                    }
            );


        }

    }

    public void loadAllSKUs_Grade_Flag() {

        if (billingClient.isReady()) {

            try {

                billingClient.queryPurchasesAsync(
                        QueryPurchasesParams.newBuilder()
                                .setProductType(BillingClient.ProductType.INAPP)
                                .build(),
                        new PurchasesResponseListener() {
                            public void onQueryPurchasesResponse(BillingResult billingResult, List purchases) {
                                // check billingResult
                                // process returned purchase list, e.g. display the plans user owns
                                if (purchases == null) {
                                    //Không có sản phẩm đã mua nào
                                    // Log.e("queryPurchasesAsync","khong co san pham nao da mua");
                                } else {
                                    //xử lý khi có sản phẩm đã mua
                                    // Log.e("queryPurchases",""+purchases.get(0).toString());
                                    if(purchases.get(0).toString().contains(sku_grade_flag)&&purchases.get(0).toString().contains("\"acknowledged\":true"))
                                    {
                                        try {
                                            handler.postDelayed(ThreadReActivated_Grade_Flag,2500);
                                        }catch (Exception exception)
                                        {

                                        }


                                    }
                                }
                            }
                        }
                );
            }catch (Exception ex)
            {

            }




            QueryProductDetailsParams queryProductDetailsParams =
                    QueryProductDetailsParams.newBuilder()
                            .setProductList(
                                    ImmutableList.of(
                                            QueryProductDetailsParams.Product.newBuilder()
                                                    .setProductId(sku_grade_flag)
                                                    .setProductType(BillingClient.ProductType.INAPP)
                                                    .build()))
                            .build();

            billingClient.queryProductDetailsAsync(
                    queryProductDetailsParams,
                    new ProductDetailsResponseListener() {
                        public void onProductDetailsResponse(BillingResult billingResult,
                                                             List<ProductDetails> productDetailsList) {
                            // check billingResult
                            // process returned productDetailsList
                            if (billingResult.getResponseCode() == BillingClient.BillingResponseCode.OK) {
                                if (!productDetailsList.isEmpty()) {
                                    final ProductDetails productDetails = (ProductDetails) productDetailsList.get(0);


                                    MainActivity.this.runOnUiThread(() -> {

                                        // Log.e("toan12345","loi j:789");
                                        ll_item_vip_flag.setVisibility(View.VISIBLE);
                                        // Log.e("toan12345","loi j:123");
                                        ll_item_vip_flag.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {

                                                if(mMemberVip_Flag==10)
                                                {
                                                    tv_item_flag.setText(getString(R.string.vip_flag_check));
                                                    if(DeviceLang.equals("vi_vn"))
                                                    {
                                                        clsHandleT.doPlaySoundAssets("vip_done_flag.mp3",DeviceLang, player, false, MainActivity.this);
                                                    }else
                                                    {
                                                        clsHandleT.doPlaySoundAssets("win.mp3", "", player, false, MainActivity.this);
                                                    }
                                                }else
                                                {
                                                    tv_item_flag.setText(getString(R.string.vip_flag_warning));

                                                    BillingFlowParams billingFlowParams =
                                                            BillingFlowParams.newBuilder()
                                                                    .setProductDetailsParamsList(
                                                                            ImmutableList.of(
                                                                                    BillingFlowParams.ProductDetailsParams.newBuilder()
                                                                                            .setProductDetails(productDetails)
                                                                                            .build()
                                                                            )
                                                                    )
                                                                    .build();

                                                    billingClient.launchBillingFlow(MainActivity.this, billingFlowParams);

                                                }


                                            }
                                        });

                                    });

                                }

                            }

                        }
                    }
            );


        }

    }
    public void loadAllSKUs_Grade_All() {

        if (billingClient.isReady()) {

            try {

                billingClient.queryPurchasesAsync(
                        QueryPurchasesParams.newBuilder()
                                .setProductType(BillingClient.ProductType.INAPP)
                                .build(),
                        new PurchasesResponseListener() {
                            public void onQueryPurchasesResponse(BillingResult billingResult, List purchases) {
                                // check billingResult
                                // process returned purchase list, e.g. display the plans user owns
                                if (purchases == null) {
                                    //Không có sản phẩm đã mua nào
                                    // Log.e("queryPurchasesAsync","khong co san pham nao da mua");
                                } else {
                                    //xử lý khi có sản phẩm đã mua
                                    // Log.e("queryPurchases",""+purchases.get(0).toString());
                                    if(purchases.get(0).toString().contains(sku_grade_all)&&purchases.get(0).toString().contains("\"acknowledged\":true"))
                                    {
                                        try {
                                            handler.postDelayed(ThreadReActivated_GradeAll,2500);
                                        }catch (Exception exception)
                                        {

                                        }


                                    }
                                }
                            }
                        }
                );
            }catch (Exception ex)
            {

            }




            QueryProductDetailsParams queryProductDetailsParams =
                    QueryProductDetailsParams.newBuilder()
                            .setProductList(
                                    ImmutableList.of(
                                            QueryProductDetailsParams.Product.newBuilder()
                                                    .setProductId(sku_grade_all)
                                                    .setProductType(BillingClient.ProductType.INAPP)
                                                    .build()))
                            .build();

            billingClient.queryProductDetailsAsync(
                    queryProductDetailsParams,
                    new ProductDetailsResponseListener() {
                        public void onProductDetailsResponse(BillingResult billingResult,
                                                             List<ProductDetails> productDetailsList) {
                            // check billingResult
                            // process returned productDetailsList
                            if (billingResult.getResponseCode() == BillingClient.BillingResponseCode.OK) {
                                if (!productDetailsList.isEmpty()) {
                                    final ProductDetails productDetails = (ProductDetails) productDetailsList.get(0);


                                    MainActivity.this.runOnUiThread(() -> {

                                        // Log.e("toan12345","loi j:789");
                                        ll_item_vip_all.setVisibility(View.VISIBLE);
                                        // Log.e("toan12345","loi j:123");
                                        ll_item_vip_all.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {

                                                if(mMemberVip_All==10)
                                                {
                                                    tv_item_vip1.setText(getString(R.string.vip1_check));
                                                    tv_item_vip2.setText(getString(R.string.vip2_check));
                                                    tv_item_vip3.setText(getString(R.string.vip3_check));
                                                    tv_item_vip4.setText(getString(R.string.vip4_check));
                                                    tv_item_vip5.setText(getString(R.string.vip5_check));
                                                    tv_item_flag.setText(getString(R.string.vip_flag_check));
                                                    tv_item_vipall.setText(getString(R.string.vip_all_check));

                                                    if(DeviceLang.equals("vi_vn"))
                                                    {
                                                        clsHandleT.doPlaySoundAssets("vip_done.mp3",DeviceLang, player, false, MainActivity.this);
                                                    }else
                                                    {
                                                        clsHandleT.doPlaySoundAssets("win.mp3", "", player, false, MainActivity.this);
                                                    }
                                                }else
                                                {
                                                    tv_item_vipall.setText(getString(R.string.vip_all_warning));

                                                    BillingFlowParams billingFlowParams =
                                                            BillingFlowParams.newBuilder()
                                                                    .setProductDetailsParamsList(
                                                                            ImmutableList.of(
                                                                                    BillingFlowParams.ProductDetailsParams.newBuilder()
                                                                                            .setProductDetails(productDetails)
                                                                                            .build()
                                                                            )
                                                                    )
                                                                    .build();

                                                    billingClient.launchBillingFlow(MainActivity.this, billingFlowParams);

                                                }


                                            }
                                        });

                                    });

                                }

                            }

                        }
                    }
            );


        }

    }
    public PurchasesUpdatedListener purchaseUpdateListener = new PurchasesUpdatedListener() {
        @Override
        public void onPurchasesUpdated(@NonNull BillingResult billingResult, @Nullable List<Purchase> list) {
            if (billingResult.getResponseCode() == BillingClient.BillingResponseCode.OK
                    && list != null) {

                for (Purchase purchase : list) {
                    handlerPurchase(purchase);
                }

            } else if (billingResult.getResponseCode() == BillingClient.BillingResponseCode.ITEM_ALREADY_OWNED) {
//                mMemberVip = 10;
//                editor.putInt("vips", mMemberVip);
//                editor.commit();
//                doResetVip();
            } else if (billingResult.getResponseCode() == BillingClient.BillingResponseCode.USER_CANCELED) {
//                mMemberVip1 = 0;
//                editor.putInt("vips", mMemberVip1);
//                editor.commit();
            } else {
//                mMemberVip1 = 0;
//                editor.putInt("vips", mMemberVip1);
//                editor.commit();
            }
        }
    };

    private void handlerPurchase(Purchase purchase) {


        if (purchase.getPurchaseState() == Purchase.PurchaseState.PURCHASED&&purchase.getProducts().contains(sku_grade_1)) {
            if (!purchase.isAcknowledged()) {
                AcknowledgePurchaseParams acknowledgePurchaseParams =
                        AcknowledgePurchaseParams.newBuilder()
                                .setPurchaseToken(purchase.getPurchaseToken())
                                .build();
                billingClient.acknowledgePurchase(acknowledgePurchaseParams, new AcknowledgePurchaseResponseListener() {
                    @Override
                    public void onAcknowledgePurchaseResponse(@NonNull BillingResult billingResult) {
                        MainActivity.this.runOnUiThread(() -> {


                            mMemberVip1 = 10;
                            editor.putInt("vips", mMemberVip1);
                            editor.commit();
                            doResetVip(getString(R.string.yesads1));

                            if(DeviceLang.equals("vi_vn"))
                            {
                                clsHandleT.doPlaySoundAssets("vip_done1.mp3",DeviceLang, player, false, MainActivity.this);
                            }else
                            {
                                clsHandleT.doPlaySoundAssets("win.mp3", "", player, false, MainActivity.this);
                            }
                            logRevenue(50000,"VND",sku_grade_1,"PRO_1");

                        });
                    }
                });
            }
        }

        if (purchase.getPurchaseState() == Purchase.PurchaseState.PURCHASED&&purchase.getProducts().contains(sku_grade_2)) {
            if (!purchase.isAcknowledged()) {
                AcknowledgePurchaseParams acknowledgePurchaseParams =
                        AcknowledgePurchaseParams.newBuilder()
                                .setPurchaseToken(purchase.getPurchaseToken())
                                .build();
                billingClient.acknowledgePurchase(acknowledgePurchaseParams, new AcknowledgePurchaseResponseListener() {
                    @Override
                    public void onAcknowledgePurchaseResponse(@NonNull BillingResult billingResult) {
                        MainActivity.this.runOnUiThread(() -> {


                            mMemberVip2 = 10;
                            editor.putInt("vips2", mMemberVip2);
                            editor.commit();
                            doResetVip(getString(R.string.yesads2));

                            if(DeviceLang.equals("vi_vn"))
                            {
                                clsHandleT.doPlaySoundAssets("vip_done2.mp3",DeviceLang, player, false, MainActivity.this);
                            }else
                            {
                                clsHandleT.doPlaySoundAssets("win.mp3", "", player, false, MainActivity.this);
                            }
                            logRevenue(50000,"VND",sku_grade_2,"PRO_2");

                        });
                    }
                });
            }
        }

        if (purchase.getPurchaseState() == Purchase.PurchaseState.PURCHASED&&purchase.getProducts().contains(sku_grade_3)) {
            if (!purchase.isAcknowledged()) {
                AcknowledgePurchaseParams acknowledgePurchaseParams =
                        AcknowledgePurchaseParams.newBuilder()
                                .setPurchaseToken(purchase.getPurchaseToken())
                                .build();
                billingClient.acknowledgePurchase(acknowledgePurchaseParams, new AcknowledgePurchaseResponseListener() {
                    @Override
                    public void onAcknowledgePurchaseResponse(@NonNull BillingResult billingResult) {
                        MainActivity.this.runOnUiThread(() -> {


                            mMemberVip3 = 10;
                            editor.putInt("vips3", mMemberVip3);
                            editor.commit();
                            doResetVip(getString(R.string.yesads3));
                            if(DeviceLang.equals("vi_vn"))
                            {
                                clsHandleT.doPlaySoundAssets("vip_done3.mp3",DeviceLang, player, false, MainActivity.this);
                            }else
                            {
                                clsHandleT.doPlaySoundAssets("win.mp3", "", player, false, MainActivity.this);
                            }
                            logRevenue(50000,"VND",sku_grade_3,"PRO_3");
                        });
                    }
                });
            }
        }

        if (purchase.getPurchaseState() == Purchase.PurchaseState.PURCHASED&&purchase.getProducts().contains(sku_grade_4)) {
            if (!purchase.isAcknowledged()) {
                AcknowledgePurchaseParams acknowledgePurchaseParams =
                        AcknowledgePurchaseParams.newBuilder()
                                .setPurchaseToken(purchase.getPurchaseToken())
                                .build();
                billingClient.acknowledgePurchase(acknowledgePurchaseParams, new AcknowledgePurchaseResponseListener() {
                    @Override
                    public void onAcknowledgePurchaseResponse(@NonNull BillingResult billingResult) {
                        MainActivity.this.runOnUiThread(() -> {


                            mMemberVip4 = 10;
                            editor.putInt("vips4", mMemberVip4);
                            editor.commit();
                            doResetVip(getString(R.string.yesads4));
                            if(DeviceLang.equals("vi_vn"))
                            {
                                clsHandleT.doPlaySoundAssets("vip_done4.mp3",DeviceLang, player, false, MainActivity.this);
                            }else
                            {
                                clsHandleT.doPlaySoundAssets("win.mp3", "", player, false, MainActivity.this);
                            }
                            logRevenue(50000,"VND",sku_grade_4,"PRO_4");
                        });
                    }
                });
            }
        }

        if (purchase.getPurchaseState() == Purchase.PurchaseState.PURCHASED&&purchase.getProducts().contains(sku_grade_5)) {
            if (!purchase.isAcknowledged()) {
                AcknowledgePurchaseParams acknowledgePurchaseParams =
                        AcknowledgePurchaseParams.newBuilder()
                                .setPurchaseToken(purchase.getPurchaseToken())
                                .build();
                billingClient.acknowledgePurchase(acknowledgePurchaseParams, new AcknowledgePurchaseResponseListener() {
                    @Override
                    public void onAcknowledgePurchaseResponse(@NonNull BillingResult billingResult) {
                        MainActivity.this.runOnUiThread(() -> {

                            mMemberVip5 = 10;
                            editor.putInt("vips5", mMemberVip5);
                            editor.commit();
                            doResetVip(getString(R.string.yesads5));

                            if(DeviceLang.equals("vi_vn"))
                            {
                                clsHandleT.doPlaySoundAssets("vip_done5.mp3",DeviceLang, player, false, MainActivity.this);
                            }else
                            {
                                clsHandleT.doPlaySoundAssets("win.mp3", "", player, false, MainActivity.this);
                            }
                            logRevenue(50000,"VND",sku_grade_5,"PRO_5");
                        });
                    }
                });
            }
        }

        if (purchase.getPurchaseState() == Purchase.PurchaseState.PURCHASED&&purchase.getProducts().contains(sku_grade_flag)) {
            if (!purchase.isAcknowledged()) {
                AcknowledgePurchaseParams acknowledgePurchaseParams =
                        AcknowledgePurchaseParams.newBuilder()
                                .setPurchaseToken(purchase.getPurchaseToken())
                                .build();
                billingClient.acknowledgePurchase(acknowledgePurchaseParams, new AcknowledgePurchaseResponseListener() {
                    @Override
                    public void onAcknowledgePurchaseResponse(@NonNull BillingResult billingResult) {
                        MainActivity.this.runOnUiThread(() -> {

                            mMemberVip_Flag = 10;
                            editor.putInt("vipsflag", mMemberVip_Flag);
                            editor.commit();
                            doResetVip(getString(R.string.yesads_flag));

                            if(DeviceLang.equals("vi_vn"))
                            {
                                clsHandleT.doPlaySoundAssets("vip_done_flag.mp3",DeviceLang, player, false, MainActivity.this);
                            }else
                            {
                                clsHandleT.doPlaySoundAssets("win.mp3", "", player, false, MainActivity.this);
                            }
                            logRevenue(50000,"VND",sku_grade_flag,"PRO_FLAG");
                        });
                    }
                });
            }
        }

        if (purchase.getPurchaseState() == Purchase.PurchaseState.PURCHASED&&purchase.getProducts().contains(sku_grade_all)) {
            if (!purchase.isAcknowledged()) {
                AcknowledgePurchaseParams acknowledgePurchaseParams =
                        AcknowledgePurchaseParams.newBuilder()
                                .setPurchaseToken(purchase.getPurchaseToken())
                                .build();
                billingClient.acknowledgePurchase(acknowledgePurchaseParams, new AcknowledgePurchaseResponseListener() {
                    @Override
                    public void onAcknowledgePurchaseResponse(@NonNull BillingResult billingResult) {
                        MainActivity.this.runOnUiThread(() -> {


                            mMemberVip1 = 10;
                            mMemberVip2 = 10;
                            mMemberVip3 = 10;
                            mMemberVip4 = 10;
                            mMemberVip5 = 10;
                            mMemberVip_Flag=10;
                            mMemberVip_All = 10;
                            editor.putInt("vips", mMemberVip1);
                            editor.putInt("vips2", mMemberVip2);
                            editor.putInt("vips3", mMemberVip3);
                            editor.putInt("vips4", mMemberVip4);
                            editor.putInt("vips5", mMemberVip5);
                            editor.putInt("vipsflag", mMemberVip_Flag);
                            editor.putInt("vipsall", mMemberVip_All);
                            editor.commit();
                            doResetVip(getString(R.string.yesadsall));
                            if(DeviceLang.equals("vi_vn"))
                            {
                                clsHandleT.doPlaySoundAssets("vip_done.mp3",DeviceLang, player, false, MainActivity.this);
                            }else
                            {
                                clsHandleT.doPlaySoundAssets("win.mp3", "", player, false, MainActivity.this);
                            }
                            logRevenue(150000,"VND",sku_grade_all,"PRO_ALL");
                        });
                    }
                });
            }
        }
    }


    private void logRevenue(double revenue, String currency,String SKU_VIO,String Name_Produc) {

        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, SKU_VIO);
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, Name_Produc);
        bundle.putDouble(FirebaseAnalytics.Param.PRICE,revenue);
       // bundle.putDouble(FirebaseAnalytics.Param.PRICE,(revenue*85)/100);
        bundle.putString(FirebaseAnalytics.Param.CURRENCY, currency);

        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.PURCHASE, bundle);

        Db("tracking v");
    }

    Runnable ThreadReActivated_Grade1 = new Runnable() {
        @Override
        public void run() {
            mMemberVip1 = 10;
            editor.putInt("vips", mMemberVip1);
            editor.commit();
            doResetVip(getString(R.string.yesads1));
        }
    };
    Runnable ThreadReActivated_Grade2 = new Runnable() {
        @Override
        public void run() {
            mMemberVip2 = 10;
            editor.putInt("vips2", mMemberVip2);
            editor.commit();
            doResetVip(getString(R.string.yesads2));
        }
    };
    Runnable ThreadReActivated_Grade3 = new Runnable() {
        @Override
        public void run() {
            mMemberVip3 = 10;
            editor.putInt("vips3", mMemberVip3);
            editor.commit();
            doResetVip(getString(R.string.yesads3));
        }
    };
    Runnable ThreadReActivated_Grade4 = new Runnable() {
        @Override
        public void run() {
            mMemberVip4 = 10;
            editor.putInt("vips4", mMemberVip4);
            editor.commit();
            doResetVip(getString(R.string.yesads4));
        }
    };
    Runnable ThreadReActivated_Grade5 = new Runnable() {
        @Override
        public void run() {
            mMemberVip5 = 10;
            editor.putInt("vips5", mMemberVip5);
            editor.commit();
            doResetVip(getString(R.string.yesads5));
        }
    };

    Runnable ThreadReActivated_Grade_Flag = new Runnable() {
        @Override
        public void run() {
            mMemberVip_Flag = 10;
            editor.putInt("vipsflag", mMemberVip_Flag);
            editor.commit();
            doResetVip(getString(R.string.yesads_flag));
        }
    };
    Runnable ThreadReActivated_GradeAll = new Runnable() {
        @Override
        public void run() {


            mMemberVip1 = 10;
            mMemberVip2 = 10;
            mMemberVip3 = 10;
            mMemberVip4 = 10;
            mMemberVip5 = 10;
            mMemberVip_Flag=10;
            mMemberVip_All = 10;
            editor.putInt("vips", mMemberVip1);
            editor.putInt("vips2", mMemberVip2);
            editor.putInt("vips3", mMemberVip3);
            editor.putInt("vips4", mMemberVip4);
            editor.putInt("vips5", mMemberVip5);
            editor.putInt("vipsflag", mMemberVip_Flag);
            editor.putInt("vipsall", mMemberVip_All);
            editor.commit();

            doResetVip(getString(R.string.yesadsall));
        }
    };

    public void doResetVip(String pTmp) {
        try {
            doCheckTextItemVip();
            la_buy_vip.setVisibility(View.VISIBLE);
            la_buy_vip.setRepeatCount(2);
            la_buy_vip.playAnimation();

            tv_title_vip_item.setText(pTmp);
            //Toast.makeText(MainActivity.this, getString(R.string.sussespro), Toast.LENGTH_LONG).show();
            CustomToast.makeText(MainActivity.this,getString(R.string.sussespro),CustomToast.LONG,true).show();
        } catch (Exception ex) {

        }

    }
    public void onClickExit_Game(View view)
    {
        try {
            System.exit(0);

        }catch (Exception ex)
        {

        }

    }
    public void onClickGrade1(View view)
    {
        doSetGrade(1,view);
    }
    public void onClickGrade2(View view)
    {
        doSetGrade(2,view);
    }
    public void onClickGrade3(View view)
    {
        doSetGrade(3,view);
    }
    public void onClickGrade4(View view)
    {
        doSetGrade(4,view);
    }
    public void onClickGrade5(View view)
    {
        doSetGrade(5,view);
    }
    public void onClickGrade20(View view)
    {
        doSetGrade(20,view);
    }


    String tmpString;
    public void doLoadPhepToan()
    {
        try {
            lstPhepToan=new ArrayList<PhepToan>();

            if(mGrade==20)
            {
                tmpString = clsHandleT.LoadDataAssets("flag_country.txt", MainActivity.this);
                if (!tmpString.equals("")) {
                    if (tmpString.contains("}")) {
                        String[] mang = tmpString.split("\\}");
                        for (int i = 0; i < mang.length; i++) {
                            if (mang[i].contains("^")) {
                                String[] items = mang[i].split("\\^");
                                try {
                                        PhepToan pt = new PhepToan();
                                        pt.setKetqua(Integer.parseInt(items[0]));
                                        pt.setTamcongthuc(items[1]);
                                        pt.setLevel(Integer.parseInt(items[2]));
                                        if(DeviceLang.equals("vi_vn"))
                                        {
                                            pt.setCongthuc(items[3]);
                                        }
                                        else  if(DeviceLang.equals("fr"))
                                        {
                                            pt.setCongthuc(items[5]);
                                        }
                                        else  if(DeviceLang.equals("de"))
                                        {
                                            pt.setCongthuc(items[6]);
                                         }
                                        else
                                        {
                                            pt.setCongthuc(items[4]);
                                        }
                                        lstPhepToan.add(pt);

                                     //Log.e("damdao","flag:"+lstPhepToan.size());
                                } catch (Exception ex) {
                                    // Log.e("exx:",""+ex);

                                    continue;
                                }
                            }
                        }
                    }
                }

            }else {
                tmpString = clsHandleT.LoadDataAssets("pheptoan" + mGrade + ".txt", MainActivity.this);
                if (!tmpString.equals("")) {
                    if (tmpString.contains("}")) {
                        String[] mang = tmpString.split("\\}");
                        for (int i = 0; i < mang.length; i++) {
                            if (mang[i].contains("^")) {
                                String[] items = mang[i].split("\\^");
                                try {

                                    if (items[1].contains(":") || items[1].contains("/")) {
                                        PhepToan pt = new PhepToan();
                                        pt.setCongthuc(items[0]);
                                        String[] a = items[1].split(":|\\/");
                                        pt.setKetqua(Double.parseDouble(a[0]) / Double.parseDouble(a[1]));
                                        pt.setLevel(Integer.parseInt(items[2]));
                                        pt.setTamcongthuc(items[1]);

                                        lstPhepToan.add(pt);


                                    } else {
                                        PhepToan pt = new PhepToan();
                                        pt.setCongthuc(items[0]);
                                        if (items[1].contains(",")) {
                                            pt.setKetqua(Double.parseDouble(items[1].replaceAll(",", ".")));
                                        } else {
                                            pt.setKetqua(Double.parseDouble(items[1]));
                                        }
                                        pt.setTamcongthuc(items[1]);
                                        pt.setLevel(Integer.parseInt(items[2]));

                                        lstPhepToan.add(pt);
                                    }

                                    // Log.e("damdao",""+items[4]);
                                } catch (Exception ex) {
                                    // Log.e("exx:",""+ex);

                                    continue;
                                }
                            }
                        }
                    }
                }
            }



        }catch (Exception exception)
        {

        }
    }
    public  void doDownLoadFileDataBlog()
    {
        new Thread(new Runnable() {
            public void run() {
                // StorageReference pStorageRef = FirebaseStorage.getInstance().getReference().child("databases/altp.txt");
                try {
                    String fileURL = "https://ailatrieuphumobi.blogspot.com/2021/05/grade"+mGrade+".html";//Loge("URL data:"+fileURL);
                    File rootPath = new File(getApplicationContext().getFilesDir().getPath(), "databases");
                    if (!rootPath.exists()) {
                        rootPath.mkdirs();
                    }
                    DownloadHtpps.downloadFileDataBlog(fileURL, rootPath.toString(), "grade"+mGrade+".txt");

                    final File localFile = new File(rootPath, "grade"+mGrade+".txt");
                    mLinkDataBase = localFile.toString();
                    editor.putString("storagedata"+mGrade, localFile.toString());
                    editor.commit();
                } catch (Exception ex) {
                    //  ex.printStackTrace();
                    // Log.e("api ","ton tai altp:"+ex);

                }
            }
        }).start();
    }

    public void doLoadMoutainSelect()
    {
        try {
            lstMountain=new ArrayList<Mountain>();

            String tmpString;
            if(DeviceLang.equals("fr"))
            {
                tmpString = clsHandleT.LoadDataAssets("mountain" + mGrade + "_fr.txt", MainActivity.this);
            }else if(DeviceLang.equals("de"))
            {
                tmpString = clsHandleT.LoadDataAssets("mountain" + mGrade + "_de.txt", MainActivity.this);
            }else {
                tmpString = clsHandleT.LoadDataAssets("mountain" + mGrade + ".txt", MainActivity.this);
            }



            if(!tmpString.equals(""))
            {

                if (tmpString.contains("#")) {

                    String[] mang = tmpString.split("\\#");
                    Mountain loiVan;
                    for (int i = 0; i < mang.length; i++) {
                        if (mang[i].contains("*")) {
                            String[] items = mang[i].split("\\*");
                            try{
                                loiVan=new Mountain();

                                loiVan.setId(items[0]);
                                loiVan.setQuestion(items[1]);
                                loiVan.setCasea(items[2]);
                                loiVan.setCaseb(items[3]);
                                loiVan.setCasec(items[4]);
                                loiVan.setCased(items[5]);
                                loiVan.setTruecase(Integer.parseInt(items[6]));
                                loiVan.setGiaithich(items[7]);
                                loiVan.setLevel(Integer.parseInt(items[8]));
                                lstMountain.add(loiVan);

                            }
                            catch (Exception ex) {
                                // Log.e("exx:",""+ex);

                                continue;
                            }
                        }
                    }
                }
            }
            clsHandleT.Loge("lst M:"+lstMountain.size());

        }catch (Exception exception)
        {

        }
    }
    public void doLoadMoutain()
    {
        try {
            lstLoiVan=new ArrayList<LoiVan>();

            File localfile = new File(mLinkDataBase);
            String tmpString="";

            // Loge("1:"+yourData.isEmpty());
            for (int i=0;i<3;i++)
            {
                // Db("A:"+i);
                if(localfile.exists())
                {
                    try {
                        tmpString = clsHandleT.loadDataApp(new File(mLinkDataBase));
                        //  Db("vao roi:");
                    }catch (Exception exception)
                    {
                        continue;
                    }
                }

                if(!tmpString.isEmpty())
                {
                    //  Db("Break:");
                    break;
                }
            }
            if(tmpString.isEmpty())
            {
                tmpString=clsHandleT.LoadDataAssets("dinhnui"+mGrade+".txt",MainActivity.this);
                //  Db("ko roi:");
            }

            if(!tmpString.equals(""))
            {
                if (tmpString.contains("}")) {
                    String[] mang = tmpString.split("\\}");
                    LoiVan loiVan;
                    for (int i = 0; i < mang.length; i++) {
                        if (mang[i].contains("^")) {
                            String[] items = mang[i].split("\\^");
                            try{
                                loiVan=new LoiVan();
                                loiVan.setId(items[0]);
                                loiVan.setQuestion(items[1]);
                                loiVan.setResult(Integer.parseInt(items[2]));
                                loiVan.setExplain(items[3]);
                                loiVan.setLevel(Integer.parseInt(items[4]));
                                lstLoiVan.add(loiVan);

                            }
                            catch (Exception ex) {
                                // Log.e("exx:",""+ex);

                                continue;
                            }
                        }
                    }
                }
            }

        }catch (Exception exception)
        {

        }
    }
    public void doSetGrade(int pGrade,View view)
    {
        v_grade=view;

        if(currentStatus==Status.MAIN) {
            try {
                mGrade = pGrade;
                mLinkDataBase = pref.getString("storagedata"+mGrade, "");

                if(DeviceLang.equals("vi_vn"))
                {
                    switch (pGrade) {
                        case 2:
                            tv_grade_level.setText("Lớp 2");
                            break;
                        case 3:
                            tv_grade_level.setText("Lớp 3");
                            break;
                        case 4:
                            tv_grade_level.setText("Lớp 4");
                            break;
                        case 5:
                            tv_grade_level.setText("Lớp 5");
                            break;
                        case 20:
                            tv_grade_level.setText("Tìm cờ các nước");
                            break;
                        default:
                            tv_grade_level.setText("Lớp 1");
                            break;
                    }
                }
                else if(DeviceLang.equals("fr"))
                {
                    switch (pGrade) {
                        case 2:
                            tv_grade_level.setText("CE1");
                            break;
                        case 3:
                            tv_grade_level.setText("CE2");
                            break;
                        case 4:
                            tv_grade_level.setText("CM1");
                            break;
                        case 5:
                            tv_grade_level.setText("CM2");
                            break;
                        case 20:
                            tv_grade_level.setText("Devine le drapeau");
                            break;
                        default:
                            tv_grade_level.setText("CP");
                            break;
                    }
                }
                 else if(DeviceLang.equals("de"))
                {
                    switch (pGrade) {
                        case 2:
                            tv_grade_level.setText("2. Klasse");
                            break;
                        case 3:
                            tv_grade_level.setText("3. Klasse");
                            break;
                        case 4:
                            tv_grade_level.setText("4. Klasse");
                            break;
                        case 5:
                            tv_grade_level.setText("5. Klasse");
                            break;
                        case 20:
                            tv_grade_level.setText("Errate die Flagge");
                            break;
                        default:
                            tv_grade_level.setText("1. Klasse");
                            break;
                    }
                }
                else
                {
                    switch (pGrade) {
                        case 2:
                            tv_grade_level.setText("Grade 2");
                            break;
                        case 3:
                            tv_grade_level.setText("Grade 3");
                            break;
                        case 4:
                            tv_grade_level.setText("Grade 4");
                            break;
                        case 5:
                            tv_grade_level.setText("Grade 5");
                            break;
                        case 20:
                            tv_grade_level.setText("Guess the Flag");
                            break;
                        default:
                            tv_grade_level.setText("Grade 1");
                            break;
                    }
                }

                clsHandleT.doPlaySoundAssets("win.mp3", "", player, false, MainActivity.this);



                doLoadPhepToan();
                if(mGrade==20)
                {
                    if (mLevel == 0) {
                        mMaxScore = 30;
                    } else if (mLevel == 1){
                        mMaxScore = 60;
                    }else
                    {
                        mMaxScore = 100;
                    }
                }else if (DeviceLang.equals("vi_vn") && mGrade >= 2) {

                    if (((int) mFirebaseRemoteConfig.getValue("grade"+mGrade).asDouble()) != pref.getInt("grade"+mGrade, 0)) {
                        doDownLoadFileDataBlog();
                        editor.putInt("grade"+mGrade, ((int) mFirebaseRemoteConfig.getValue("grade"+mGrade).asDouble()));
                        editor.commit();
                    }
                    doLoadMoutain();
                    mMaxScore = 300;
                } else {
                    if (mGrade == 1) {

                        if (mLevel < 3) {
                            mMaxScore = 30;
                        } else {
                            mMaxScore = 60;
                        }
                    } else {

                        doLoadMoutainSelect();
                        mMaxScore = 300;
                    }
                }
                doLoadLevel();
            } catch (Exception exception) {

            }


        }
        if (((int) mFirebaseRemoteConfig.getValue("b_ads_inapp_key").asDouble()) != 0
                &&mMemberVip1==0
                &&mMemberVip2==0
                &&mMemberVip3==0
                &&mMemberVip4==0
                &&mMemberVip5==0
                &&mMemberVip_Flag==0
                &&mMemberVip_All==0) {
            AdmobManager.doLoadInterstitialAd(this);
        }
        v_grade.startAnimation(aninShake_Grade);
    }

    ArrayList<LevelUser>levelUserArrayList;
    int mOpen=100;
    int cMaxTam;
    void doLoadLevel()
    {
        try {

            mLevelScore = pref.getString("levelscore" + mGrade, "1^2^3^4^5^6^7^8^9^10^11^12^13^14^15^16^17^18^19^20");
            mArrayLevel = mLevelScore.split("\\^");

            levelUserArrayList=new ArrayList<LevelUser>();
            mOpen=100;
            for (int i=0;i<mArrayLevel.length;i++)
            {
               if(i!=100)
               {
                   if(mGrade==1)
                   {
                       if (i < 4) {
                           cMaxTam = 30;
                       } else {
                           cMaxTam = 60;
                       }
                   }else if(mGrade==20)
                   {
                       if (i  ==0) {
                           cMaxTam = 30;
                       } else if(i ==1) {
                           cMaxTam = 60;
                       }else
                       {
                           cMaxTam = 100;
                       }
//                       Log.e("toan12345","i:"+i+"cMaxTam:"+cMaxTam);
//                       Log.e("toan12345","cmax/2:"+(cMaxTam/2));
                   }else
                   {
                       cMaxTam = 300;
                   }

                   if(Integer.parseInt(mArrayLevel[i])<(cMaxTam/2))
                   {

                       mOpen=i;
                     //  Log.e("toan12345","mOpen=i="+mOpen);
                       break;
                   }
               }

            }

            for (int i=0;i<mArrayLevel.length;i++)
            {
                levelUserArrayList.add(new LevelUser(i,mGrade,Integer.parseInt(mArrayLevel[i]),mOpen));
            }

            levelAdapter = new LevelAdapter(this,levelUserArrayList);
            gv_level.setAdapter(levelAdapter);
            gv_level.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {



                    if(!((RelativeLayout) view.findViewById(R.id.rlBgItemLevel)).getTag().toString().equals("0")) {

                        if(((RelativeLayout) view.findViewById(R.id.rlBgItemLevel)).getTag().toString().equals("2")&&position>1
                                &&mMemberVip1==0&&mGrade==1&&((int) mFirebaseRemoteConfig.getValue("alow_inapp").asDouble()) == 0)
                        {
                            clsHandleT.showDialogVip(MainActivity.this);
                            clsHandleT.doPlaySoundAssets("buyvip.mp3",DeviceLang, player, false, MainActivity.this);
                        }else if(((RelativeLayout) view.findViewById(R.id.rlBgItemLevel)).getTag().toString().equals("2")&&position>0
                                &&mMemberVip2==0&&mGrade==2&&((int) mFirebaseRemoteConfig.getValue("alow_inapp").asDouble()) == 0)
                        {
                            clsHandleT.showDialogVip(MainActivity.this);
                            clsHandleT.doPlaySoundAssets("buyvip.mp3",DeviceLang, player, false, MainActivity.this);
                        }  else if(((RelativeLayout) view.findViewById(R.id.rlBgItemLevel)).getTag().toString().equals("2")&&position>0
                                &&mMemberVip3==0&&mGrade==3&&((int) mFirebaseRemoteConfig.getValue("alow_inapp").asDouble()) == 0)
                        {
                            clsHandleT.showDialogVip(MainActivity.this);
                            clsHandleT.doPlaySoundAssets("buyvip.mp3",DeviceLang, player, false, MainActivity.this);
                        } else if(((RelativeLayout) view.findViewById(R.id.rlBgItemLevel)).getTag().toString().equals("2")&&position>0
                                &&mMemberVip4==0&&mGrade==4&&((int) mFirebaseRemoteConfig.getValue("alow_inapp").asDouble()) == 0)
                        {
                            clsHandleT.showDialogVip(MainActivity.this);
                            clsHandleT.doPlaySoundAssets("buyvip.mp3",DeviceLang, player, false, MainActivity.this);
                        }  else if(((RelativeLayout) view.findViewById(R.id.rlBgItemLevel)).getTag().toString().equals("2")&&position>0
                                &&mMemberVip5==0&&mGrade==5&&((int) mFirebaseRemoteConfig.getValue("alow_inapp").asDouble()) == 0)
                        {
                            clsHandleT.showDialogVip(MainActivity.this);
                            clsHandleT.doPlaySoundAssets("buyvip.mp3",DeviceLang, player, false, MainActivity.this);
                        } else if(((RelativeLayout) view.findViewById(R.id.rlBgItemLevel)).getTag().toString().equals("2")&&position>1
                                &&mMemberVip_Flag==0&&mGrade==20&&((int) mFirebaseRemoteConfig.getValue("alow_inapp").asDouble()) == 0)
                        {
                            clsHandleT.showDialogVip(MainActivity.this);
                            clsHandleT.doPlaySoundAssets("buyvip.mp3",DeviceLang, player, false, MainActivity.this);
                        }
                        else
                        {
                            doPlayClick();
                            mLevel = position;
                            lstPhepToanLevel = new ArrayList<PhepToan>();
                            if(mGrade==20)
                            {
                                if (mLevel ==0) {
                                    mMaxScore = 30;
                                } else if(mLevel==1) {
                                    mMaxScore = 60;
                                }else
                                {
                                    mMaxScore = 100;
                                }

                                if((mLevel+1)==1)
                                {
                                    for (int i = 0; i < lstPhepToan.size(); i++) {
                                        if (lstPhepToan.get(i).getLevel() ==1) {
                                            lstPhepToanLevel.add(lstPhepToan.get(i));
                                        }
                                    }

                                } else if((mLevel+1)==2)
                                {
                                    for (int i = 0; i < lstPhepToan.size(); i++) {
                                        if (lstPhepToan.get(i).getLevel() ==2) {
                                            lstPhepToanLevel.add(lstPhepToan.get(i));
                                        }
                                    }
                                }else if((mLevel+1)==3)
                                {
                                    for (int i = 0; i < lstPhepToan.size(); i++) {
                                        if (lstPhepToan.get(i).getLevel() ==3) {
                                            lstPhepToanLevel.add(lstPhepToan.get(i));
                                        }
                                    }
                                }else if((mLevel+1)==4)
                                {
                                    for (int i = 0; i < lstPhepToan.size(); i++) {
                                        if (lstPhepToan.get(i).getLevel() ==4) {
                                            lstPhepToanLevel.add(lstPhepToan.get(i));
                                        }
                                    }
                                }else if((mLevel+1)==5)
                                {
                                    for (int i = 0; i < lstPhepToan.size(); i++) {
                                        if (lstPhepToan.get(i).getLevel() ==4||lstPhepToan.get(i).getLevel() ==5) {
                                            lstPhepToanLevel.add(lstPhepToan.get(i));
                                        }
                                    }
                                }else if((mLevel+1)==6)
                                {
                                    for (int i = 0; i < lstPhepToan.size(); i++) {
                                        if (lstPhepToan.get(i).getLevel() ==2||lstPhepToan.get(i).getLevel() ==6) {
                                            lstPhepToanLevel.add(lstPhepToan.get(i));
                                        }
                                    }
                                }else if((mLevel+1)==7)
                                {
                                    for (int i = 0; i < lstPhepToan.size(); i++) {
                                        if (lstPhepToan.get(i).getLevel() ==3||lstPhepToan.get(i).getLevel() ==6) {
                                            lstPhepToanLevel.add(lstPhepToan.get(i));
                                        }
                                    }
                                }else if((mLevel+1)==8)
                                {
                                    for (int i = 0; i < lstPhepToan.size(); i++) {
                                        if (lstPhepToan.get(i).getLevel() ==1||lstPhepToan.get(i).getLevel() ==7) {
                                            lstPhepToanLevel.add(lstPhepToan.get(i));
                                        }
                                    }
                                }else if((mLevel+1)==9)
                                {
                                    for (int i = 0; i < lstPhepToan.size(); i++) {
                                        if (lstPhepToan.get(i).getLevel() ==5||lstPhepToan.get(i).getLevel() ==7) {
                                            lstPhepToanLevel.add(lstPhepToan.get(i));
                                        }
                                    }
                                }else if((mLevel+1)==10)
                                {
                                    for (int i = 0; i < lstPhepToan.size(); i++) {
                                        if (lstPhepToan.get(i).getLevel() ==8) {
                                            lstPhepToanLevel.add(lstPhepToan.get(i));
                                        }
                                    }
                                }else if((mLevel+1)==11)
                                {
                                    for (int i = 0; i < lstPhepToan.size(); i++) {
                                        if (lstPhepToan.get(i).getLevel() ==1||lstPhepToan.get(i).getLevel() ==9) {
                                            lstPhepToanLevel.add(lstPhepToan.get(i));
                                        }
                                    }
                                }else if((mLevel+1)==12)
                                {
                                    for (int i = 0; i < lstPhepToan.size(); i++) {
                                        if (lstPhepToan.get(i).getLevel() ==2||lstPhepToan.get(i).getLevel() ==10) {
                                            lstPhepToanLevel.add(lstPhepToan.get(i));
                                        }
                                    }
                                }else if((mLevel+1)==13)
                                {
                                    for (int i = 0; i < lstPhepToan.size(); i++) {
                                        if (lstPhepToan.get(i).getLevel() ==3||lstPhepToan.get(i).getLevel() ==11) {
                                            lstPhepToanLevel.add(lstPhepToan.get(i));
                                        }
                                    }
                                }else if((mLevel+1)==14)
                                {
                                    for (int i = 0; i < lstPhepToan.size(); i++) {
                                        if (lstPhepToan.get(i).getLevel() ==6||lstPhepToan.get(i).getLevel() ==11) {
                                            lstPhepToanLevel.add(lstPhepToan.get(i));
                                        }
                                    }
                                }else if((mLevel+1)==15)
                                {
                                    for (int i = 0; i < lstPhepToan.size(); i++) {
                                        if (lstPhepToan.get(i).getLevel() ==5||lstPhepToan.get(i).getLevel() ==12) {
                                            lstPhepToanLevel.add(lstPhepToan.get(i));
                                        }
                                    }
                                }else if((mLevel+1)==16)
                                {
                                    for (int i = 0; i < lstPhepToan.size(); i++) {
                                        if (lstPhepToan.get(i).getLevel() ==7||lstPhepToan.get(i).getLevel() ==13) {
                                            lstPhepToanLevel.add(lstPhepToan.get(i));
                                        }
                                    }
                                }else if((mLevel+1)==17)
                                {
                                    for (int i = 0; i < lstPhepToan.size(); i++) {
                                        if (lstPhepToan.get(i).getLevel() ==3||lstPhepToan.get(i).getLevel() ==14) {
                                            lstPhepToanLevel.add(lstPhepToan.get(i));
                                        }
                                    }
                                }else if((mLevel+1)==18)
                                {
                                    for (int i = 0; i < lstPhepToan.size(); i++) {
                                        if (lstPhepToan.get(i).getLevel() ==8||lstPhepToan.get(i).getLevel() ==15) {
                                            lstPhepToanLevel.add(lstPhepToan.get(i));
                                        }
                                    }
                                }else if((mLevel+1)==19)
                                {
                                    for (int i = 0; i < lstPhepToan.size(); i++) {
                                        if (lstPhepToan.get(i).getLevel() ==3||lstPhepToan.get(i).getLevel() ==16) {
                                            lstPhepToanLevel.add(lstPhepToan.get(i));
                                        }
                                    }
                                }else
                                {
                                    for (int i = 0; i < lstPhepToan.size(); i++) {
                                        if (lstPhepToan.get(i).getLevel() ==5||lstPhepToan.get(i).getLevel() ==16) {
                                            lstPhepToanLevel.add(lstPhepToan.get(i));
                                        }
                                    }
                                }

                               if(mLevel==0)
                               {
                                   doStartEqual_One();
                               }else if(mLevel==1)
                               {
                                   doStartEqual_One12();
                               }else
                               {
                                   doStartEqual();
                               }


                            }else {
                                for (int i = 0; i < lstPhepToan.size(); i++) {
                                    if (lstPhepToan.get(i).getLevel() == (position + 1)) {
                                        lstPhepToanLevel.add(lstPhepToan.get(i));
                                    }
                                }
                                //Db("::"+DeviceLang);
                                if (DeviceLang.equals("vi_vn") && mGrade >= 2) {
                                    lstLoiVanLevel = new ArrayList<LoiVan>();
                                    for (int i = 0; i < lstLoiVan.size(); i++) {
                                        if (lstLoiVan.get(i).getLevel() == (position + 1)) {
                                            lstLoiVanLevel.add(lstLoiVan.get(i));
                                        }
                                    }
                                    doDownloadSoundLevel();
                                    // doDownloadQuestion("1");
                                    mMaxScore = 300;
                                } else {
                                    if (mGrade == 1) {

                                        if (mLevel < 4) {
                                            mMaxScore = 30;
                                        } else {
                                            mMaxScore = 60;
                                        }
                                    } else {
                                        lstMountainLevel = new ArrayList<Mountain>();
                                        for (int i = 0; i < lstMountain.size(); i++) {
                                            if (lstMountain.get(i).getLevel() == (position + 1)) {
                                                lstMountainLevel.add(lstMountain.get(i));
                                            }
                                        }
                                        // clsHandleT.Loge("lst Level:"+lstMountainLevel.size());
                                        mMaxScore = 300;
                                    }
                                }

                                if (mGrade == 1) {
                                    if (mLevel < 4) {
                                        doStartEqual_One();
                                    } else {
                                        doStartEqual_One12();
                                    }
                                } else {
                                    doStartEqual();
                                    // doStartMonkey();
                                    // doStartMoutain();
                                }
                            }


                            playerBg.pause();
                            lengthMediaBg=playerBg.getCurrentPosition();
                       }
                    }
                }
            });
        }catch (Exception exception)
        {

        }
    }

    void doDownloadSoundLevel()
    {
        Thread dataThread=
                new Thread(new Runnable() {
                    public void run() {
                        try {
                            for(int i=0;i<lstLoiVanLevel.size();i++)
                            {
                                if(!clsHandleT.doCheckExistFile(mModeUrlQuestion_Math + "/grade" + mGrade + "/" + lstLoiVanLevel.get(i).getId() + ".mp3"))
                                {
                                    doDownloadQuestion(lstLoiVanLevel.get(i).getId());

                                }
                            }

                        }catch (Exception exception)
                        {

                        }
                    }
                });
        dataThread.start();
    }

    void Db(String pLog)
    {
       // Log.e("trangnguyen:",""+pLog);
    }



    public void onClickBackLevel(View view)
    {
        try {
            la_sun_grade0.clearAnimation();
            la_sun_grade0.setVisibility(View.GONE);
            if (!DeviceLang.equals("vi_vn")) {
                iv_grade_0.setVisibility(View.GONE);
                iv_grade_0_en.setVisibility(View.VISIBLE);
            }else
            {
                iv_grade_0_en.setVisibility(View.GONE);
                iv_grade_0.setVisibility(View.VISIBLE);
            }
            iv_grade_1.setVisibility(View.VISIBLE);
            iv_grade_2.setVisibility(View.VISIBLE);
            iv_grade_3.setVisibility(View.VISIBLE);
            iv_grade_4.setVisibility(View.VISIBLE);
            iv_grade_5.setVisibility(View.VISIBLE);
            iv_grade_20.setVisibility(View.VISIBLE);
            doPlayClick();
            viewFlipperMath.setDisplayedChild(1);
            currentStatus=Status.MAIN;
        }catch (Exception exception)
        {

        }
    }
    public void onClickBackGrade(View view)
    {
        try {
            doPlayClick();
            viewFlipperMath.setDisplayedChild(0);
            currentStatus=Status.MAIN;

        }catch (Exception exception)
        {

        }
    }
    public void onClickContinueSummary(View view)
    {
        try {
            doPlayClick();
            currentStatus=Status.MAIN;
            doLoadLevel();
            viewFlipperMath.setDisplayedChild(2);

            animation_view_summary.cancelAnimation();
            animation_view_summary.setVisibility(View.GONE);
            doResetEqual();
            doResetMoutain();
            doResetMonkey();

            if(mLevel<=1&&mRateApp==0&&DeviceLang.equals("vi_vn")) {
                clsHandleT.showDialog(MainActivity.this, getString(R.string.app_name), getString(R.string.rate), "", "", editor);
                mRateApp = 1;
            }else
            {
                if (((int) mFirebaseRemoteConfig.getValue("b_ads_inapp_key").asDouble()) != 0
                        &&mMemberVip1==0
                        &&mMemberVip2==0
                        &&mMemberVip3==0
                        &&mMemberVip4==0
                        &&mMemberVip5==0
                        &&mMemberVip_Flag==0
                        &&mMemberVip_All==0) {
                    if(rd.nextInt(((int) mFirebaseRemoteConfig.getValue("b_ads_inapp_key").asDouble()))==0) {
                        AdmobManager.doShowInterstitialAd(this);
                    }
                }

            }
        }catch (Exception exception)
        {

        }
    }
    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            System.gc();
            // System.exit(0);
            super.onBackPressed();
            return;
        }
        try {

            if (viewFlipperMath.getDisplayedChild() == 2) {
                viewFlipperMath.setDisplayedChild(1);
            }else  if (viewFlipperMath.getDisplayedChild() == 1||viewFlipperMath.getDisplayedChild() == 16||viewFlipperMath.getDisplayedChild() == 19) {
                viewFlipperMath.setDisplayedChild(0);
            }else if(viewFlipperMath.getDisplayedChild() == 0)
            {
                this.doubleBackToExitPressedOnce = true;
                Toast.makeText(this, getString(R.string.doubleclick),
                        Toast.LENGTH_SHORT).show();

                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        doubleBackToExitPressedOnce = false;
                    }
                }, 2000);
            }
            else {

            }


        } catch (Exception ex) {

        }
    }
    public void doPlayClick()
    {
        clsHandleT.doPlaySoundAssets("click.ogg","", player, false, MainActivity.this);
    }
    //endregion

}