package com.violympic.frame;

import android.graphics.Paint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import com.violympic.general.RoundedTransformation;
import com.violympic.modul.PhepToan;
import com.violympic.toanlop1.MainActivity;
import com.violympic.toanlop1.R;

import static com.violympic.toanlop1.MainActivity.lstPhepToanLevel10_1;
import static com.violympic.toanlop1.MainActivity.lstSelectedMonkey;
import static com.violympic.toanlop1.MainActivity.lstSelectedObjectMonkey;
import static com.violympic.toanlop1.MainActivity.mMonkeyPhepToan;
import static com.violympic.toanlop1.MainActivity.DeviceLang;



public class MonkeyFrame extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private int mParam1;
    private String mParam2;
    int mPosition;
    ImageView iv_monkey_pheptoan_bg;
    ImageView rl_monkey_bg_tranfom;
    RelativeLayout rl_monkey_pheptoan_bg;
    TextView tv_monkey_pheptoan;
    TextView tv_monkey_phantram_ps ;
    TextView tv_monkey_tuso_phantram ;
    TextView tv_monkey_mauso_phantram ;
    TextView tv_monkey_cua_ps1;
    TextView tv_monkey_tuso_cua1;
    TextView tv_monkey_mauso_cua1 ;
    TextView tv_monkey_tuso_cua2 ;
    TextView tv_monkey_mauso_cua2 ;

    TextView tv_monkey_pheptoan_hs ;
    TextView tv_monkey_hs1 ;
    TextView tv_monkey_tuso_hs1 ;
    TextView tv_monkey_mauso_hs1 ;
    TextView tv_monkey_hs2;
    TextView tv_monkey_tuso_hs2;
    TextView tv_monkey_mauso_hs2 ;
    TextView tv_monkey_cua_ps2;
    TextView tv_monkey_tuso_cua3;
    TextView tv_monkey_mauso_cua3;
    //--------------------------------
    RelativeLayout rl_monkey_2_pheptoan_bg;
    ImageView iv_monkey_2_pheptoan_bg;
    TextView tv_monkey_2_pheptoan;
    TextView tv_monkey_2_phantram_ps ;
    TextView tv_monkey_2_tuso_phantram ;
    TextView tv_monkey_2_mauso_phantram ;
    TextView tv_monkey_2_cua_ps1;
    TextView tv_monkey_2_tuso_cua1;
    TextView tv_monkey_2_mauso_cua1 ;
    TextView tv_monkey_2_tuso_cua2 ;
    TextView tv_monkey_2_mauso_cua2 ;

    TextView tv_monkey_2_pheptoan_hs ;
    TextView tv_monkey_2_hs1 ;
    TextView tv_monkey_2_tuso_hs1 ;
    TextView tv_monkey_2_mauso_hs1 ;
    TextView tv_monkey_2_hs2;
    TextView tv_monkey_2_tuso_hs2;
    TextView tv_monkey_2_mauso_hs2 ;
    TextView tv_monkey_2_cua_ps2;
    TextView tv_monkey_2_tuso_cua3;
    TextView tv_monkey_2_mauso_cua3;
    ImageView iv_monkey_left;
    ImageView iv_monkey_right;

    //Context context;
//    public FrameMonkey(int pPosition, Context context) {
//        // Required empty public constructor
//        this.mPosition=pPosition;
//        this.context=context;
//    }

    public MonkeyFrame() {
        // Required empty public constructor

    }


    // TODO: Rename and change types and number of parameters
    public static MonkeyFrame newInstance(int param1) {
        MonkeyFrame fragment = new MonkeyFrame();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.mPosition = getArguments().getInt(ARG_PARAM1);

            // mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_monkey, container, false);
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_monkey, container, false);
        rl_monkey_bg_tranfom=(ImageView) view.findViewById(R.id.rl_monkey_bg_tranfom);
        iv_monkey_pheptoan_bg=(ImageView) view.findViewById(R.id.iv_monkey_pheptoan_bg);
        rl_monkey_pheptoan_bg=(RelativeLayout) view.findViewById(R.id.rl_monkey_pheptoan_bg);
        tv_monkey_pheptoan = (TextView) view.findViewById(R.id.tv_monkey_pheptoan);
        tv_monkey_phantram_ps = (TextView) view.findViewById(R.id.tv_monkey_phantram_ps);
        tv_monkey_tuso_phantram = (TextView) view.findViewById(R.id.tv_monkey_tuso_phantram);
        tv_monkey_mauso_phantram = (TextView) view.findViewById(R.id.tv_monkey_mauso_phantram);
        tv_monkey_cua_ps1 = (TextView) view.findViewById(R.id.tv_monkey_cua_ps1);
        tv_monkey_tuso_cua1 = (TextView) view.findViewById(R.id.tv_monkey_tuso_cua1);
        tv_monkey_mauso_cua1 = (TextView) view.findViewById(R.id.tv_monkey_mauso_cua1);
        tv_monkey_tuso_cua2 = (TextView) view.findViewById(R.id.tv_monkey_tuso_cua2);
        tv_monkey_mauso_cua2 = (TextView) view.findViewById(R.id.tv_monkey_mauso_cua2);

        tv_monkey_pheptoan_hs = (TextView) view.findViewById(R.id.tv_monkey_pheptoan_hs);
        tv_monkey_hs1 = (TextView) view.findViewById(R.id.tv_monkey_hs1);
        tv_monkey_tuso_hs1 = (TextView) view.findViewById(R.id.tv_monkey_tuso_hs1);
        tv_monkey_mauso_hs1 = (TextView) view.findViewById(R.id.tv_monkey_mauso_hs1);
        tv_monkey_hs2 = (TextView) view.findViewById(R.id.tv_monkey_hs2);
        tv_monkey_tuso_hs2 = (TextView) view.findViewById(R.id.tv_monkey_tuso_hs2);
        tv_monkey_mauso_hs2 = (TextView) view.findViewById(R.id.tv_monkey_mauso_hs2);
        tv_monkey_cua_ps2= (TextView) view.findViewById(R.id.tv_monkey_cua_ps2);
        tv_monkey_tuso_cua3= (TextView) view.findViewById(R.id.tv_monkey_tuso_cua3);
        tv_monkey_mauso_cua3= (TextView) view.findViewById(R.id.tv_monkey_mauso_cua3);
        //-----------------------------------------------
        rl_monkey_2_pheptoan_bg=(RelativeLayout) view.findViewById(R.id.rl_monkey_2_pheptoan_bg);
        iv_monkey_2_pheptoan_bg=(ImageView) view.findViewById(R.id.iv_monkey_2_pheptoan_bg);
        tv_monkey_2_pheptoan = (TextView) view.findViewById(R.id.tv_monkey_2_pheptoan);
        tv_monkey_2_phantram_ps = (TextView) view.findViewById(R.id.tv_monkey_2_phantram_ps);
        tv_monkey_2_tuso_phantram = (TextView) view.findViewById(R.id.tv_monkey_2_tuso_phantram);
        tv_monkey_2_mauso_phantram = (TextView) view.findViewById(R.id.tv_monkey_2_mauso_phantram);
        tv_monkey_2_cua_ps1 = (TextView) view.findViewById(R.id.tv_monkey_2_cua_ps1);
        tv_monkey_2_tuso_cua1 = (TextView) view.findViewById(R.id.tv_monkey_2_tuso_cua1);
        tv_monkey_2_mauso_cua1 = (TextView) view.findViewById(R.id.tv_monkey_2_mauso_cua1);
        tv_monkey_2_tuso_cua2 = (TextView) view.findViewById(R.id.tv_monkey_2_tuso_cua2);
        tv_monkey_2_mauso_cua2 = (TextView) view.findViewById(R.id.tv_monkey_2_mauso_cua2);

        tv_monkey_2_pheptoan_hs = (TextView) view.findViewById(R.id.tv_monkey_2_pheptoan_hs);
        tv_monkey_2_hs1 = (TextView) view.findViewById(R.id.tv_monkey_2_hs1);
        tv_monkey_2_tuso_hs1 = (TextView) view.findViewById(R.id.tv_monkey_2_tuso_hs1);
        tv_monkey_2_mauso_hs1 = (TextView) view.findViewById(R.id.tv_monkey_2_mauso_hs1);
        tv_monkey_2_hs2 = (TextView) view.findViewById(R.id.tv_monkey_2_hs2);
        tv_monkey_2_tuso_hs2 = (TextView) view.findViewById(R.id.tv_monkey_2_tuso_hs2);
        tv_monkey_2_mauso_hs2 = (TextView) view.findViewById(R.id.tv_monkey_2_mauso_hs2);
        tv_monkey_2_cua_ps2= (TextView) view.findViewById(R.id.tv_monkey_2_cua_ps2);
        tv_monkey_2_tuso_cua3= (TextView) view.findViewById(R.id.tv_monkey_2_tuso_cua3);
        tv_monkey_2_mauso_cua3= (TextView) view.findViewById(R.id.tv_monkey_2_mauso_cua3);
        iv_monkey_left=(ImageView)view.findViewById(R.id.iv_monkey_left);
        iv_monkey_right=(ImageView)view.findViewById(R.id.iv_monkey_right);

        if(mPosition==0)
        {
            iv_monkey_left.setVisibility(View.VISIBLE);
            if(!DeviceLang.equals("vi_vn")) {
                // iv_monkey_left.setImageResource(R.drawable.bt_left_en);
                Picasso.get().load("file:///android_asset/img/bt_left_en.png")
                        .placeholder(R.drawable.bt_left_en)
                        .error(R.drawable.bt_left_en)
                        .transform(new RoundedTransformation(0, 0))
                        .fit().centerCrop()
                        .into(iv_monkey_left);
            }
        }
        if(mPosition==9)
        {
            iv_monkey_right.setVisibility(View.VISIBLE);
            if(!DeviceLang.equals("vi_vn")) {
                //  iv_monkey_right.setImageResource(R.drawable.bt_right_en);
                Picasso.get().load("file:///android_asset/img/bt_right_en.png")
                        .placeholder(R.drawable.bt_right_en)
                        .error(R.drawable.bt_right_en)
                        .transform(new RoundedTransformation(0, 0))
                        .fit().centerCrop()
                        .into(iv_monkey_right);
            }
        }

        rl_monkey_pheptoan_bg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // rl_monkey_bg_tranfom.setBackgroundResource(R.drawable.tablemonkey_cloud);

                Picasso.get().load("file:///android_asset/img/tablemonkey_cloud.png")
                        .placeholder(R.drawable.tablemonkey_cloud)
                        .error(R.drawable.tablemonkey_cloud)
                        .transform(new RoundedTransformation(0, 0))
                        .fit().centerCrop()
                        .into(rl_monkey_bg_tranfom);

                int tmpResultSelect;
                try {
                    tmpResultSelect=((MainActivity) getActivity()).doSeclecMonkey(Double.parseDouble(""+rl_monkey_pheptoan_bg.getTag()),mPosition);
                }catch (Exception exception)
                {
                    tmpResultSelect=0;
                }

                if(tmpResultSelect==1)
                {
                    ((MainActivity) getActivity()).doPlayClick();
                    MainActivity.handler.postDelayed(timerProcessMonkeyTrue,1100);
                }else if(tmpResultSelect==2)
                {
                    ((MainActivity) getActivity()).doPlayClick();
                    MainActivity.handler.postDelayed(timerProcessMonkeyFalse,1100);
                }else
                {
                    //  rl_monkey_bg_tranfom.setBackgroundResource(R.drawable.item_tranfom);
                    Picasso.get().load("file:///android_asset/img/item_tranfom.png")
                            .placeholder(R.drawable.item_tranfom)
                            .error(R.drawable.item_tranfom)
                            .transform(new RoundedTransformation(0, 0))
                            .fit().centerCrop()
                            .into(rl_monkey_bg_tranfom);
                }
            }
        });

        return view;
    }
    Runnable timerProcessMonkeyTrue = new Runnable() {
        @Override
        public void run() {
            rl_monkey_2_pheptoan_bg.setVisibility(View.VISIBLE);
            setPhepToan2(mMonkeyPhepToan);
            //rl_monkey_bg_tranfom.setBackgroundResource(R.drawable.item_tranfom);
            Picasso.get().load("file:///android_asset/img/item_tranfom.png")
                    .placeholder(R.drawable.item_tranfom)
                    .error(R.drawable.item_tranfom)
                    .transform(new RoundedTransformation(0, 0))
                    .fit().centerCrop()
                    .into(rl_monkey_bg_tranfom);
        }
    };
    Runnable timerProcessMonkeyFalse = new Runnable() {
        @Override
        public void run() {
            //  rl_monkey_bg_tranfom.setBackgroundResource(R.drawable.item_tranfom);
            Picasso.get().load("file:///android_asset/img/item_tranfom.png")
                    .placeholder(R.drawable.item_tranfom)
                    .error(R.drawable.item_tranfom)
                    .transform(new RoundedTransformation(0, 0))
                    .fit().centerCrop()
                    .into(rl_monkey_bg_tranfom);
        }
    };

    @Override
    public void onResume() {

        try {
            setPhepToan1(lstPhepToanLevel10_1.get(mPosition));
            // setPhepToan2(lstPhepToanLevel10_1.get(mPosition));
            for (int i=0;i<lstSelectedMonkey.size();i++)
            {
                if(lstSelectedMonkey.get(i)==mPosition)
                {
                    rl_monkey_2_pheptoan_bg.setVisibility(View.VISIBLE);
                    setPhepToan2(lstSelectedObjectMonkey[mPosition]);
                    break;
                }
            }
        }catch (Exception exception)
        {
            Log.e("Loi","CC:"+exception);
        }

        super.onResume();
    }
    public void setPhepToan1(PhepToan pPhepToan)
    {
        rl_monkey_pheptoan_bg.setTag(pPhepToan.getKetqua());
        if(pPhepToan.getKetqua()<0)
        {
            if(pPhepToan.getKetqua()==-1)
            {
                if(pPhepToan.getCongthuc().equals("tron"))
                {
                    // rl_monkey_pheptoan_bg.setBackgroundResource(R.drawable.hinhtron);
                    // iv_monkey_pheptoan_bg.setBackgroundResource(R.drawable.hinhtron);
                    Picasso.get().load("file:///android_asset/img/hinhtron.png")
                            .placeholder(R.drawable.hinhtron)
                            .error(R.drawable.hinhtron)
                            .transform(new RoundedTransformation(0, 0))
                            .fit().centerCrop()
                            .into(iv_monkey_pheptoan_bg);
                }else {
                    tv_monkey_pheptoan.setText(pPhepToan.getCongthuc());
                }
            }
            if(pPhepToan.getKetqua()==-2)
            {
                if(pPhepToan.getCongthuc().equals("vuong"))
                {
                    //  iv_monkey_pheptoan_bg.setBackgroundResource(R.drawable.hinhvuong);
                    Picasso.get().load("file:///android_asset/img/hinhvuong.png")
                            .placeholder(R.drawable.hinhvuong)
                            .error(R.drawable.hinhvuong)
                            .transform(new RoundedTransformation(0, 0))
                            .fit().centerCrop()
                            .into(iv_monkey_pheptoan_bg);
                }else {
                    tv_monkey_pheptoan.setText(pPhepToan.getCongthuc());
                }
            }
            if(pPhepToan.getKetqua()==-3)
            {
                if(pPhepToan.getCongthuc().equals("tamgiac"))
                {
                    //  iv_monkey_pheptoan_bg.setBackgroundResource(R.drawable.hinhtamgiac);
                    Picasso.get().load("file:///android_asset/img/hinhtamgiac.png")
                            .placeholder(R.drawable.hinhtamgiac)
                            .error(R.drawable.hinhtamgiac)
                            .transform(new RoundedTransformation(0, 0))
                            .fit().centerCrop()
                            .into(iv_monkey_pheptoan_bg);
                }else {
                    tv_monkey_pheptoan.setText(pPhepToan.getCongthuc());
                }
            }
            if(pPhepToan.getKetqua()==-5)
            {
                if(pPhepToan.getCongthuc().equals("chunhat"))
                {
                    //iv_monkey_pheptoan_bg.setBackgroundResource(R.drawable.hinhchunhat);
                    Picasso.get().load("file:///android_asset/img/hinhchunhat.png")
                            .placeholder(R.drawable.hinhchunhat)
                            .error(R.drawable.hinhchunhat)
                            .transform(new RoundedTransformation(0, 0))
                            .fit().centerCrop()
                            .into(iv_monkey_pheptoan_bg);
                }else {
                    tv_monkey_pheptoan.setText(pPhepToan.getCongthuc());
                }
            }
            if(pPhepToan.getKetqua()==-6)
            {
                if(pPhepToan.getCongthuc().equals("ngugiac"))
                {
                    // iv_monkey_pheptoan_bg.setBackgroundResource(R.drawable.hinhngugiac);
                    Picasso.get().load("file:///android_asset/img/hinhngugiac.png")
                            .placeholder(R.drawable.hinhngugiac)
                            .error(R.drawable.hinhngugiac)
                            .transform(new RoundedTransformation(0, 0))
                            .fit().centerCrop()
                            .into(iv_monkey_pheptoan_bg);
                }else {
                    tv_monkey_pheptoan.setText(pPhepToan.getCongthuc());
                }
            }
            if(pPhepToan.getKetqua()==-7)
            {
                if(pPhepToan.getCongthuc().equals("lucgiac"))
                {
                    //iv_monkey_pheptoan_bg.setBackgroundResource(R.drawable.hinhlucgiac);
                    Picasso.get().load("file:///android_asset/img/hinhlucgiac.png")
                            .placeholder(R.drawable.hinhlucgiac)
                            .error(R.drawable.hinhlucgiac)
                            .transform(new RoundedTransformation(0, 0))
                            .fit().centerCrop()
                            .into(iv_monkey_pheptoan_bg);
                }else {
                    tv_monkey_pheptoan.setText(pPhepToan.getCongthuc());
                    if(pPhepToan.getCongthuc().length()<=8)
                    {
                        tv_monkey_pheptoan.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
                    }
                }
            }
        }else {

            tv_monkey_tuso_cua3.setPaintFlags(tv_monkey_tuso_cua3.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
            tv_monkey_tuso_hs1.setPaintFlags(tv_monkey_tuso_hs1.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
            tv_monkey_tuso_hs2.setPaintFlags(tv_monkey_tuso_hs2.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
            tv_monkey_tuso_cua2.setPaintFlags(tv_monkey_tuso_cua2.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
            tv_monkey_tuso_cua1.setPaintFlags(tv_monkey_tuso_cua1.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
            tv_monkey_tuso_phantram.setPaintFlags(tv_monkey_tuso_phantram.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

            if (pPhepToan.getCongthuc().contains("%c")) {
                if (pPhepToan.getCongthuc().contains("/")) {
                    tv_monkey_phantram_ps.setText(pPhepToan.getCongthuc().substring(0, pPhepToan.getCongthuc().indexOf("c")) + " "+getActivity().getString(R.string.of));
                    tv_monkey_tuso_phantram.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("c") + 1, pPhepToan.getCongthuc().indexOf("/")));
                    tv_monkey_mauso_phantram.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/") + 1));
                } else {
                    tv_monkey_pheptoan.setText(pPhepToan.getCongthuc().replaceAll("c", " "+getActivity().getString(R.string.of)+" "));
                    if(pPhepToan.getCongthuc().length()<=8)
                    {
                        tv_monkey_pheptoan.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
                    }
                }
            } else if (pPhepToan.getCongthuc().contains("c")) {
                try {
                    if (pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("c") + 1).contains("/")) {
                        tv_monkey_tuso_cua1.setText(pPhepToan.getCongthuc().substring(0, pPhepToan.getCongthuc().indexOf("/")));
                        tv_monkey_mauso_cua1.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/") + 1, pPhepToan.getCongthuc().indexOf("c")));
                        tv_monkey_cua_ps1.setText(" "+getActivity().getString(R.string.of)+" ");
                        tv_monkey_tuso_cua2.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("c") + 1, pPhepToan.getCongthuc().indexOf("/", pPhepToan.getCongthuc().indexOf("/") + 1)));
                        tv_monkey_mauso_cua2.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/", pPhepToan.getCongthuc().indexOf("/") + 1) + 1));

                    } else {
                        tv_monkey_tuso_cua1.setText(pPhepToan.getCongthuc().substring(0, pPhepToan.getCongthuc().indexOf("/")));
                        tv_monkey_mauso_cua1.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/") + 1, pPhepToan.getCongthuc().indexOf("c")));
                        tv_monkey_cua_ps1.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("c")).replaceAll("c", " "+getActivity().getString(R.string.of)+" "));

                    }
                }catch (Exception e)
                {
                    tv_monkey_tuso_cua1.setText("");
                    tv_monkey_mauso_cua1.setText("");
                    tv_monkey_cua_ps1.setText("");
                    tv_monkey_tuso_cua2.setText("");
                    tv_monkey_mauso_cua2.setText("");

                    tv_monkey_pheptoan.setText(pPhepToan.getCongthuc());
                    if(pPhepToan.getCongthuc().length()<=8)
                    {
                        tv_monkey_pheptoan.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
                    }
                }


            } else if (pPhepToan.getCongthuc().contains("]") && (pPhepToan.getCongthuc().contains("+") || pPhepToan.getCongthuc().contains("-") || pPhepToan.getCongthuc().contains("x") || pPhepToan.getCongthuc().contains(":"))) {
                if (pPhepToan.getCongthuc().contains("x")) {
                    tv_monkey_pheptoan_hs.setText(" x ");
                    tv_monkey_mauso_hs1.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/") + 1, pPhepToan.getCongthuc().indexOf("x")));
                    tv_monkey_hs2.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("x") + 1, pPhepToan.getCongthuc().indexOf("]", pPhepToan.getCongthuc().indexOf("]") + 1)));
                }
                if (pPhepToan.getCongthuc().contains(":")) {
                    tv_monkey_pheptoan_hs.setText(" : ");
                    tv_monkey_mauso_hs1.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/") + 1, pPhepToan.getCongthuc().indexOf(":")));
                    tv_monkey_hs2.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf(":") + 1, pPhepToan.getCongthuc().indexOf("]", pPhepToan.getCongthuc().indexOf("]") + 1)));
                }
                if (pPhepToan.getCongthuc().contains("+")) {
                    tv_monkey_pheptoan_hs.setText(" + ");
                    tv_monkey_mauso_hs1.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/") + 1, pPhepToan.getCongthuc().indexOf("+")));
                    tv_monkey_hs2.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("+") + 1, pPhepToan.getCongthuc().indexOf("]", pPhepToan.getCongthuc().indexOf("]") + 1)));
                }
                if (pPhepToan.getCongthuc().contains("-")) {
                    tv_monkey_pheptoan_hs.setText(" - ");
                    tv_monkey_mauso_hs1.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/") + 1, pPhepToan.getCongthuc().indexOf("-")));
                    tv_monkey_hs2.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("-") + 1, pPhepToan.getCongthuc().indexOf("]", pPhepToan.getCongthuc().indexOf("]") + 1)));
                }
                tv_monkey_hs1.setText(pPhepToan.getCongthuc().substring(0, pPhepToan.getCongthuc().indexOf("]")));
                tv_monkey_tuso_hs1.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("]") + 1, pPhepToan.getCongthuc().indexOf("/")));
                tv_monkey_tuso_hs2.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("]", pPhepToan.getCongthuc().indexOf("]") + 1) + 1, pPhepToan.getCongthuc().indexOf("/", pPhepToan.getCongthuc().indexOf("/") + 1)));
                tv_monkey_mauso_hs2.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/", pPhepToan.getCongthuc().indexOf("/") + 1) + 1));
            } else if (pPhepToan.getCongthuc().contains("]")) {
                tv_monkey_hs1.setText(pPhepToan.getCongthuc().substring(0, pPhepToan.getCongthuc().indexOf("]")));
                tv_monkey_tuso_hs1.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("]") + 1, pPhepToan.getCongthuc().indexOf("/")));
                tv_monkey_mauso_hs1.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/") + 1));
            } else if (pPhepToan.getCongthuc().contains("/") && pPhepToan.getCongthuc().contains(")")) {
                tv_monkey_tuso_cua1.setText(pPhepToan.getCongthuc().substring(0, pPhepToan.getCongthuc().indexOf("/")).replaceAll("\\)", "").replaceAll("\\(", ""));
                tv_monkey_mauso_hs1.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/") + 1).replaceAll("\\)", "").replaceAll("\\(", ""));
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
                        tv_monkey_tuso_cua1.setText(mang[0].substring(0, mang[0].indexOf("/")));
                        tv_monkey_mauso_cua1.setText(mang[0].substring(mang[0].indexOf("/") + 1));
                        tv_monkey_cua_ps1.setText(" " + dau1 + " ");

                        tv_monkey_tuso_cua2.setText(mang[1].substring(0, mang[1].indexOf("/")));
                        tv_monkey_mauso_cua2.setText(mang[1].substring(mang[1].indexOf("/") + 1));
                        tv_monkey_cua_ps2.setText(" " + dau2 + " ");
                        tv_monkey_tuso_cua3.setText(mang[2].substring(0, mang[2].indexOf("/")));
                        tv_monkey_mauso_cua3.setText(mang[2].substring(mang[2].indexOf("/") + 1));

                        //--------------------------------------
                    } else {
                        if (pPhepToan.getCongthuc().contains("+")) {
                            if (pPhepToan.getCongthuc().substring(0, pPhepToan.getCongthuc().indexOf("+") + 1).contains("/")) {
                                if (pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("+") + 1).contains("/")) {
                                    //ca 2 cung co
                                    tv_monkey_tuso_cua1.setText(pPhepToan.getCongthuc().substring(0, pPhepToan.getCongthuc().indexOf("/")));
                                    tv_monkey_mauso_cua1.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/") + 1, pPhepToan.getCongthuc().indexOf("+")));
                                    tv_monkey_cua_ps1.setText(" + ");
                                    tv_monkey_tuso_cua2.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("+") + 1, pPhepToan.getCongthuc().indexOf("/", pPhepToan.getCongthuc().indexOf("/") + 1)));
                                    tv_monkey_mauso_cua2.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/", pPhepToan.getCongthuc().indexOf("/") + 1) + 1));
                                } else {
                                    //ben trai co
                                    tv_monkey_tuso_cua1.setText(pPhepToan.getCongthuc().substring(0, pPhepToan.getCongthuc().indexOf("/")));
                                    tv_monkey_mauso_cua1.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/") + 1, pPhepToan.getCongthuc().indexOf("+")));
                                    tv_monkey_cua_ps1.setText(" + " + pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("+") + 1));
                                }
                            } else {
                                //Ben phai co
                                tv_monkey_cua_ps1.setText(pPhepToan.getCongthuc().substring(0, pPhepToan.getCongthuc().indexOf("+")) + " + ");
                                tv_monkey_tuso_cua2.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("+") + 1, pPhepToan.getCongthuc().indexOf("/")));
                                tv_monkey_mauso_cua2.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/") + 1));
                            }
                        } else if (pPhepToan.getCongthuc().contains("-")) {
                            if (pPhepToan.getCongthuc().substring(0, pPhepToan.getCongthuc().indexOf("-") + 1).contains("/")) {
                                if (pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("-") + 1).contains("/")) {
                                    //ca 2 cung co
                                    tv_monkey_tuso_cua1.setText(pPhepToan.getCongthuc().substring(0, pPhepToan.getCongthuc().indexOf("/")));
                                    tv_monkey_mauso_cua1.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/") + 1, pPhepToan.getCongthuc().indexOf("-")));
                                    tv_monkey_cua_ps1.setText(" - ");
                                    tv_monkey_tuso_cua2.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("-") + 1, pPhepToan.getCongthuc().indexOf("/", pPhepToan.getCongthuc().indexOf("/") + 1)));
                                    tv_monkey_mauso_cua2.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/", pPhepToan.getCongthuc().indexOf("/") + 1) + 1));
                                } else {
                                    //ben trai co
                                    tv_monkey_tuso_cua1.setText(pPhepToan.getCongthuc().substring(0, pPhepToan.getCongthuc().indexOf("/")));
                                    tv_monkey_mauso_cua1.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/") + 1, pPhepToan.getCongthuc().indexOf("-")));
                                    tv_monkey_cua_ps1.setText(" - " + pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("-") + 1));
                                }
                            } else {
                                //Ben phai co
                                tv_monkey_cua_ps1.setText(pPhepToan.getCongthuc().substring(0, pPhepToan.getCongthuc().indexOf("-")) + " - ");
                                tv_monkey_tuso_cua2.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("-") + 1, pPhepToan.getCongthuc().indexOf("/")));
                                tv_monkey_mauso_cua2.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/") + 1));
                            }
                        } else if (pPhepToan.getCongthuc().contains("x")) {
                            if (pPhepToan.getCongthuc().substring(0, pPhepToan.getCongthuc().indexOf("x") + 1).contains("/")) {
                                if (pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("x") + 1).contains("/")) {
                                    //ca 2 cung co
                                    tv_monkey_tuso_cua1.setText(pPhepToan.getCongthuc().substring(0, pPhepToan.getCongthuc().indexOf("/")));
                                    tv_monkey_mauso_cua1.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/") + 1, pPhepToan.getCongthuc().indexOf("x")));
                                    tv_monkey_cua_ps1.setText(" x ");
                                    tv_monkey_tuso_cua2.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("x") + 1, pPhepToan.getCongthuc().indexOf("/", pPhepToan.getCongthuc().indexOf("/") + 1)));
                                    tv_monkey_mauso_cua2.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/", pPhepToan.getCongthuc().indexOf("/") + 1) + 1));
                                } else {
                                    //ben trai co
                                    tv_monkey_tuso_cua1.setText(pPhepToan.getCongthuc().substring(0, pPhepToan.getCongthuc().indexOf("/")));
                                    tv_monkey_mauso_cua1.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/") + 1, pPhepToan.getCongthuc().indexOf("x")));
                                    tv_monkey_cua_ps1.setText(" x " + pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("x") + 1));
                                }
                            } else {
                                //Ben phai co
                                tv_monkey_cua_ps1.setText(pPhepToan.getCongthuc().substring(0, pPhepToan.getCongthuc().indexOf("x")) + " x ");
                                tv_monkey_tuso_cua2.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("x") + 1, pPhepToan.getCongthuc().indexOf("/")));
                                tv_monkey_mauso_cua2.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/") + 1));
                            }
                        } else if (pPhepToan.getCongthuc().contains(":")) {
                            if (pPhepToan.getCongthuc().substring(0, pPhepToan.getCongthuc().indexOf(":") + 1).contains("/")) {
                                if (pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf(":") + 1).contains("/")) {
                                    //ca 2 cung co
                                    tv_monkey_tuso_cua1.setText(pPhepToan.getCongthuc().substring(0, pPhepToan.getCongthuc().indexOf("/")));
                                    tv_monkey_mauso_cua1.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/") + 1, pPhepToan.getCongthuc().indexOf(":")));
                                    tv_monkey_cua_ps1.setText(" : ");
                                    tv_monkey_tuso_cua2.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf(":") + 1, pPhepToan.getCongthuc().indexOf("/", pPhepToan.getCongthuc().indexOf("/") + 1)));
                                    tv_monkey_mauso_cua2.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/", pPhepToan.getCongthuc().indexOf("/") + 1) + 1));
                                } else {
                                    //ben trai co
                                    tv_monkey_tuso_cua1.setText(pPhepToan.getCongthuc().substring(0, pPhepToan.getCongthuc().indexOf("/")));
                                    tv_monkey_mauso_cua1.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/") + 1, pPhepToan.getCongthuc().indexOf(":")));
                                    tv_monkey_cua_ps1.setText(" : " + pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf(":") + 1));
                                }
                            } else {
                                //Ben phai co
                                tv_monkey_cua_ps1.setText(pPhepToan.getCongthuc().substring(0, pPhepToan.getCongthuc().indexOf(":")) + " : ");
                                tv_monkey_tuso_cua2.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf(":") + 1, pPhepToan.getCongthuc().indexOf("/")));
                                tv_monkey_mauso_cua2.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/") + 1));
                            }
                        }
                    }
                } else {
                    tv_monkey_tuso_cua1.setText(pPhepToan.getCongthuc().substring(0, pPhepToan.getCongthuc().indexOf("/")));
                    tv_monkey_mauso_cua1.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/") + 1));
                }
            } else {
                tv_monkey_pheptoan.setText(pPhepToan.getCongthuc());
                if(pPhepToan.getCongthuc().length()<=8)
                {
                    tv_monkey_pheptoan.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
                }
            }
        }
    }
    public void setPhepToan2(PhepToan pPhepToan)
    {
        if(pPhepToan.getKetqua()<0)
        {
            if(pPhepToan.getKetqua()==-1)
            {
                if(pPhepToan.getCongthuc().equals("tron"))
                {
                    // iv_monkey_2_pheptoan_bg.setBackgroundResource(R.drawable.hinhtron);
                    Picasso.get().load("file:///android_asset/img/hinhtron.png")
                            .placeholder(R.drawable.hinhtron)
                            .error(R.drawable.hinhtron)
                            .transform(new RoundedTransformation(0, 0))
                            .fit().centerCrop()
                            .into(iv_monkey_2_pheptoan_bg);
                }else {
                    tv_monkey_2_pheptoan.setText(pPhepToan.getCongthuc());
                }
            }
            if(pPhepToan.getKetqua()==-2)
            {
                if(pPhepToan.getCongthuc().equals("vuong"))
                {
                    // iv_monkey_2_pheptoan_bg.setBackgroundResource(R.drawable.hinhvuong);
                    Picasso.get().load("file:///android_asset/img/hinhvuong.png")
                            .placeholder(R.drawable.hinhvuong)
                            .error(R.drawable.hinhvuong)
                            .transform(new RoundedTransformation(0, 0))
                            .fit().centerCrop()
                            .into(iv_monkey_2_pheptoan_bg);
                }else {
                    tv_monkey_2_pheptoan.setText(pPhepToan.getCongthuc());
                }
            }
            if(pPhepToan.getKetqua()==-3)
            {
                if(pPhepToan.getCongthuc().equals("tamgiac"))
                {
                    //  iv_monkey_2_pheptoan_bg.setBackgroundResource(R.drawable.hinhtamgiac);
                    Picasso.get().load("file:///android_asset/img/hinhtamgiac.png")
                            .placeholder(R.drawable.hinhtamgiac)
                            .error(R.drawable.hinhtamgiac)
                            .transform(new RoundedTransformation(0, 0))
                            .fit().centerCrop()
                            .into(iv_monkey_2_pheptoan_bg);
                }else {
                    tv_monkey_2_pheptoan.setText(pPhepToan.getCongthuc());
                }
            }
            if(pPhepToan.getKetqua()==-5)
            {
                if(pPhepToan.getCongthuc().equals("chunhat"))
                {
                    // iv_monkey_2_pheptoan_bg.setBackgroundResource(R.drawable.hinhchunhat);
                    Picasso.get().load("file:///android_asset/img/hinhchunhat.png")
                            .placeholder(R.drawable.hinhchunhat)
                            .error(R.drawable.hinhchunhat)
                            .transform(new RoundedTransformation(0, 0))
                            .fit().centerCrop()
                            .into(iv_monkey_2_pheptoan_bg);
                }else {
                    tv_monkey_2_pheptoan.setText(pPhepToan.getCongthuc());
                }
            }
            if(pPhepToan.getKetqua()==-6)
            {
                if(pPhepToan.getCongthuc().equals("ngugiac"))
                {
                    //iv_monkey_2_pheptoan_bg.setBackgroundResource(R.drawable.hinhngugiac);
                    Picasso.get().load("file:///android_asset/img/hinhngugiac.png")
                            .placeholder(R.drawable.hinhngugiac)
                            .error(R.drawable.hinhngugiac)
                            .transform(new RoundedTransformation(0, 0))
                            .fit().centerCrop()
                            .into(iv_monkey_2_pheptoan_bg);
                }else {
                    tv_monkey_2_pheptoan.setText(pPhepToan.getCongthuc());
                }
            }
            if(pPhepToan.getKetqua()==-7)
            {
                if(pPhepToan.getCongthuc().equals("lucgiac"))
                {
                    //  iv_monkey_2_pheptoan_bg.setBackgroundResource(R.drawable.hinhlucgiac);
                    Picasso.get().load("file:///android_asset/img/hinhlucgiac.png")
                            .placeholder(R.drawable.hinhlucgiac)
                            .error(R.drawable.hinhlucgiac)
                            .transform(new RoundedTransformation(0, 0))
                            .fit().centerCrop()
                            .into(iv_monkey_2_pheptoan_bg);
                }else {
                    tv_monkey_2_pheptoan.setText(pPhepToan.getCongthuc());
                }
            }
        }else {

            tv_monkey_2_tuso_cua3.setPaintFlags(tv_monkey_2_tuso_cua3.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
            tv_monkey_2_tuso_hs1.setPaintFlags(tv_monkey_2_tuso_hs1.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
            tv_monkey_2_tuso_hs2.setPaintFlags(tv_monkey_2_tuso_hs2.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
            tv_monkey_2_tuso_cua2.setPaintFlags(tv_monkey_2_tuso_cua2.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
            tv_monkey_2_tuso_cua1.setPaintFlags(tv_monkey_2_tuso_cua1.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
            tv_monkey_2_tuso_phantram.setPaintFlags(tv_monkey_2_tuso_phantram.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

            if (pPhepToan.getCongthuc().contains("%c")) {
                if (pPhepToan.getCongthuc().contains("/")) {
                    tv_monkey_2_phantram_ps.setText(pPhepToan.getCongthuc().substring(0, pPhepToan.getCongthuc().indexOf("c")) + " của");
                    tv_monkey_2_tuso_phantram.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("c") + 1, pPhepToan.getCongthuc().indexOf("/")));
                    tv_monkey_2_mauso_phantram.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/") + 1));
                } else {
                    tv_monkey_2_pheptoan.setText(pPhepToan.getCongthuc().replaceAll("c", " của "));
                }
            } else if (pPhepToan.getCongthuc().contains("c")) {
                try {
                    if (pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("c") + 1).contains("/")) {
                        tv_monkey_2_tuso_cua1.setText(pPhepToan.getCongthuc().substring(0, pPhepToan.getCongthuc().indexOf("/")));
                        tv_monkey_2_mauso_cua1.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/") + 1, pPhepToan.getCongthuc().indexOf("c")));
                        tv_monkey_2_cua_ps1.setText(" của ");
                        tv_monkey_2_tuso_cua2.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("c") + 1, pPhepToan.getCongthuc().indexOf("/", pPhepToan.getCongthuc().indexOf("/") + 1)));
                        tv_monkey_2_mauso_cua2.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/", pPhepToan.getCongthuc().indexOf("/") + 1) + 1));

                    } else {
                        tv_monkey_2_tuso_cua1.setText(pPhepToan.getCongthuc().substring(0, pPhepToan.getCongthuc().indexOf("/")));
                        tv_monkey_2_mauso_cua1.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/") + 1, pPhepToan.getCongthuc().indexOf("c")));
                        tv_monkey_2_cua_ps1.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("c")).replaceAll("c", " của "));

                    }
                }catch (Exception e)
                {
                    tv_monkey_2_tuso_cua1.setText("");
                    tv_monkey_2_mauso_cua1.setText("");
                    tv_monkey_2_cua_ps1.setText("");
                    tv_monkey_2_tuso_cua2.setText("");
                    tv_monkey_2_mauso_cua2.setText("");

                    tv_monkey_2_pheptoan.setText(pPhepToan.getCongthuc());
                    if(pPhepToan.getCongthuc().length()<=8)
                    {
                        tv_monkey_2_pheptoan.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);

                    }
                }


            } else if (pPhepToan.getCongthuc().contains("]") && (pPhepToan.getCongthuc().contains("+") || pPhepToan.getCongthuc().contains("-") || pPhepToan.getCongthuc().contains("x") || pPhepToan.getCongthuc().contains(":"))) {
                if (pPhepToan.getCongthuc().contains("x")) {
                    tv_monkey_2_pheptoan_hs.setText(" x ");
                    tv_monkey_2_mauso_hs1.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/") + 1, pPhepToan.getCongthuc().indexOf("x")));
                    tv_monkey_2_hs2.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("x") + 1, pPhepToan.getCongthuc().indexOf("]", pPhepToan.getCongthuc().indexOf("]") + 1)));
                }
                if (pPhepToan.getCongthuc().contains(":")) {
                    tv_monkey_2_pheptoan_hs.setText(" : ");
                    tv_monkey_2_mauso_hs1.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/") + 1, pPhepToan.getCongthuc().indexOf(":")));
                    tv_monkey_2_hs2.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf(":") + 1, pPhepToan.getCongthuc().indexOf("]", pPhepToan.getCongthuc().indexOf("]") + 1)));
                }
                if (pPhepToan.getCongthuc().contains("+")) {
                    tv_monkey_2_pheptoan_hs.setText(" + ");
                    tv_monkey_2_mauso_hs1.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/") + 1, pPhepToan.getCongthuc().indexOf("+")));
                    tv_monkey_2_hs2.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("+") + 1, pPhepToan.getCongthuc().indexOf("]", pPhepToan.getCongthuc().indexOf("]") + 1)));
                }
                if (pPhepToan.getCongthuc().contains("-")) {
                    tv_monkey_2_pheptoan_hs.setText(" - ");
                    tv_monkey_2_mauso_hs1.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/") + 1, pPhepToan.getCongthuc().indexOf("-")));
                    tv_monkey_2_hs2.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("-") + 1, pPhepToan.getCongthuc().indexOf("]", pPhepToan.getCongthuc().indexOf("]") + 1)));
                }
                tv_monkey_2_hs1.setText(pPhepToan.getCongthuc().substring(0, pPhepToan.getCongthuc().indexOf("]")));
                tv_monkey_2_tuso_hs1.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("]") + 1, pPhepToan.getCongthuc().indexOf("/")));
                tv_monkey_2_tuso_hs2.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("]", pPhepToan.getCongthuc().indexOf("]") + 1) + 1, pPhepToan.getCongthuc().indexOf("/", pPhepToan.getCongthuc().indexOf("/") + 1)));
                tv_monkey_2_mauso_hs2.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/", pPhepToan.getCongthuc().indexOf("/") + 1) + 1));
            } else if (pPhepToan.getCongthuc().contains("]")) {
                tv_monkey_2_hs1.setText(pPhepToan.getCongthuc().substring(0, pPhepToan.getCongthuc().indexOf("]")));
                tv_monkey_2_tuso_hs1.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("]") + 1, pPhepToan.getCongthuc().indexOf("/")));
                tv_monkey_2_mauso_hs1.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/") + 1));
            } else if (pPhepToan.getCongthuc().contains("/") && pPhepToan.getCongthuc().contains(")")) {
                tv_monkey_2_tuso_cua1.setText(pPhepToan.getCongthuc().substring(0, pPhepToan.getCongthuc().indexOf("/")).replaceAll("\\)", "").replaceAll("\\(", ""));
                tv_monkey_2_mauso_hs1.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/") + 1).replaceAll("\\)", "").replaceAll("\\(", ""));
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
                        tv_monkey_2_tuso_cua1.setText(mang[0].substring(0, mang[0].indexOf("/")));
                        tv_monkey_2_mauso_cua1.setText(mang[0].substring(mang[0].indexOf("/") + 1));
                        tv_monkey_2_cua_ps1.setText(" " + dau1 + " ");

                        tv_monkey_2_tuso_cua2.setText(mang[1].substring(0, mang[1].indexOf("/")));
                        tv_monkey_2_mauso_cua2.setText(mang[1].substring(mang[1].indexOf("/") + 1));
                        tv_monkey_2_cua_ps2.setText(" " + dau2 + " ");
                        tv_monkey_2_tuso_cua3.setText(mang[2].substring(0, mang[2].indexOf("/")));
                        tv_monkey_2_mauso_cua3.setText(mang[2].substring(mang[2].indexOf("/") + 1));

                        //--------------------------------------
                    } else {
                        if (pPhepToan.getCongthuc().contains("+")) {
                            if (pPhepToan.getCongthuc().substring(0, pPhepToan.getCongthuc().indexOf("+") + 1).contains("/")) {
                                if (pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("+") + 1).contains("/")) {
                                    //ca 2 cung co
                                    tv_monkey_2_tuso_cua1.setText(pPhepToan.getCongthuc().substring(0, pPhepToan.getCongthuc().indexOf("/")));
                                    tv_monkey_2_mauso_cua1.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/") + 1, pPhepToan.getCongthuc().indexOf("+")));
                                    tv_monkey_2_cua_ps1.setText(" + ");
                                    tv_monkey_2_tuso_cua2.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("+") + 1, pPhepToan.getCongthuc().indexOf("/", pPhepToan.getCongthuc().indexOf("/") + 1)));
                                    tv_monkey_2_mauso_cua2.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/", pPhepToan.getCongthuc().indexOf("/") + 1) + 1));
                                } else {
                                    //ben trai co
                                    tv_monkey_2_tuso_cua1.setText(pPhepToan.getCongthuc().substring(0, pPhepToan.getCongthuc().indexOf("/")));
                                    tv_monkey_2_mauso_cua1.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/") + 1, pPhepToan.getCongthuc().indexOf("+")));
                                    tv_monkey_2_cua_ps1.setText(" + " + pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("+") + 1));
                                }
                            } else {
                                //Ben phai co
                                tv_monkey_2_cua_ps1.setText(pPhepToan.getCongthuc().substring(0, pPhepToan.getCongthuc().indexOf("+")) + " + ");
                                tv_monkey_2_tuso_cua2.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("+") + 1, pPhepToan.getCongthuc().indexOf("/")));
                                tv_monkey_2_mauso_cua2.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/") + 1));
                            }
                        } else if (pPhepToan.getCongthuc().contains("-")) {
                            if (pPhepToan.getCongthuc().substring(0, pPhepToan.getCongthuc().indexOf("-") + 1).contains("/")) {
                                if (pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("-") + 1).contains("/")) {
                                    //ca 2 cung co
                                    tv_monkey_2_tuso_cua1.setText(pPhepToan.getCongthuc().substring(0, pPhepToan.getCongthuc().indexOf("/")));
                                    tv_monkey_2_mauso_cua1.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/") + 1, pPhepToan.getCongthuc().indexOf("-")));
                                    tv_monkey_2_cua_ps1.setText(" - ");
                                    tv_monkey_2_tuso_cua2.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("-") + 1, pPhepToan.getCongthuc().indexOf("/", pPhepToan.getCongthuc().indexOf("/") + 1)));
                                    tv_monkey_2_mauso_cua2.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/", pPhepToan.getCongthuc().indexOf("/") + 1) + 1));
                                } else {
                                    //ben trai co
                                    tv_monkey_2_tuso_cua1.setText(pPhepToan.getCongthuc().substring(0, pPhepToan.getCongthuc().indexOf("/")));
                                    tv_monkey_2_mauso_cua1.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/") + 1, pPhepToan.getCongthuc().indexOf("-")));
                                    tv_monkey_2_cua_ps1.setText(" - " + pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("-") + 1));
                                }
                            } else {
                                //Ben phai co
                                tv_monkey_2_cua_ps1.setText(pPhepToan.getCongthuc().substring(0, pPhepToan.getCongthuc().indexOf("-")) + " - ");
                                tv_monkey_2_tuso_cua2.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("-") + 1, pPhepToan.getCongthuc().indexOf("/")));
                                tv_monkey_2_mauso_cua2.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/") + 1));
                            }
                        } else if (pPhepToan.getCongthuc().contains("x")) {
                            if (pPhepToan.getCongthuc().substring(0, pPhepToan.getCongthuc().indexOf("x") + 1).contains("/")) {
                                if (pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("x") + 1).contains("/")) {
                                    //ca 2 cung co
                                    tv_monkey_2_tuso_cua1.setText(pPhepToan.getCongthuc().substring(0, pPhepToan.getCongthuc().indexOf("/")));
                                    tv_monkey_2_mauso_cua1.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/") + 1, pPhepToan.getCongthuc().indexOf("x")));
                                    tv_monkey_2_cua_ps1.setText(" x ");
                                    tv_monkey_2_tuso_cua2.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("x") + 1, pPhepToan.getCongthuc().indexOf("/", pPhepToan.getCongthuc().indexOf("/") + 1)));
                                    tv_monkey_2_mauso_cua2.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/", pPhepToan.getCongthuc().indexOf("/") + 1) + 1));
                                } else {
                                    //ben trai co
                                    tv_monkey_2_tuso_cua1.setText(pPhepToan.getCongthuc().substring(0, pPhepToan.getCongthuc().indexOf("/")));
                                    tv_monkey_2_mauso_cua1.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/") + 1, pPhepToan.getCongthuc().indexOf("x")));
                                    tv_monkey_2_cua_ps1.setText(" x " + pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("x") + 1));
                                }
                            } else {
                                //Ben phai co
                                tv_monkey_2_cua_ps1.setText(pPhepToan.getCongthuc().substring(0, pPhepToan.getCongthuc().indexOf("x")) + " x ");
                                tv_monkey_2_tuso_cua2.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("x") + 1, pPhepToan.getCongthuc().indexOf("/")));
                                tv_monkey_2_mauso_cua2.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/") + 1));
                            }
                        } else if (pPhepToan.getCongthuc().contains(":")) {
                            if (pPhepToan.getCongthuc().substring(0, pPhepToan.getCongthuc().indexOf(":") + 1).contains("/")) {
                                if (pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf(":") + 1).contains("/")) {
                                    //ca 2 cung co
                                    tv_monkey_2_tuso_cua1.setText(pPhepToan.getCongthuc().substring(0, pPhepToan.getCongthuc().indexOf("/")));
                                    tv_monkey_2_mauso_cua1.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/") + 1, pPhepToan.getCongthuc().indexOf(":")));
                                    tv_monkey_2_cua_ps1.setText(" : ");
                                    tv_monkey_2_tuso_cua2.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf(":") + 1, pPhepToan.getCongthuc().indexOf("/", pPhepToan.getCongthuc().indexOf("/") + 1)));
                                    tv_monkey_2_mauso_cua2.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/", pPhepToan.getCongthuc().indexOf("/") + 1) + 1));
                                } else {
                                    //ben trai co
                                    tv_monkey_2_tuso_cua1.setText(pPhepToan.getCongthuc().substring(0, pPhepToan.getCongthuc().indexOf("/")));
                                    tv_monkey_2_mauso_cua1.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/") + 1, pPhepToan.getCongthuc().indexOf(":")));
                                    tv_monkey_2_cua_ps1.setText(" : " + pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf(":") + 1));
                                }
                            } else {
                                //Ben phai co
                                tv_monkey_2_cua_ps1.setText(pPhepToan.getCongthuc().substring(0, pPhepToan.getCongthuc().indexOf(":")) + " : ");
                                tv_monkey_2_tuso_cua2.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf(":") + 1, pPhepToan.getCongthuc().indexOf("/")));
                                tv_monkey_2_mauso_cua2.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/") + 1));
                            }
                        }
                    }
                } else {
                    tv_monkey_2_tuso_cua1.setText(pPhepToan.getCongthuc().substring(0, pPhepToan.getCongthuc().indexOf("/")));
                    tv_monkey_2_mauso_cua1.setText(pPhepToan.getCongthuc().substring(pPhepToan.getCongthuc().indexOf("/") + 1));
                }
            } else {

                tv_monkey_2_pheptoan.setText(pPhepToan.getCongthuc());
                if(pPhepToan.getCongthuc().length()<=8)
                {
                    tv_monkey_2_pheptoan.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
                }
            }
        }
    }
}