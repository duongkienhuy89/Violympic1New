package com.violympic.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.violympic.toanlop1.R;

import java.util.ArrayList;

import com.violympic.general.RoundedTransformation;
import com.violympic.modul.PhepToan;


public class EqualAdapter20 extends BaseAdapter {

    private Context context;
    ArrayList<PhepToan> phepToanArrayList;
    public EqualAdapter20(Context context,ArrayList<PhepToan> phepToanArrayList1)
    {
        this.context=context;
        this.phepToanArrayList=phepToanArrayList1;

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View gridView = inflater.inflate(R.layout.item_equal, null);

        ImageView rl_item_pheptoan_bg=(ImageView) gridView.findViewById(R.id.rl_item_pheptoan_bg);
        TextView tv_item_pheptoan = (TextView) gridView.findViewById(R.id.tv_item_pheptoan);
        TextView tv_item_phantram_ps = (TextView) gridView.findViewById(R.id.tv_item_phantram_ps);
        TextView tv_item_tuso_phantram = (TextView) gridView.findViewById(R.id.tv_item_tuso_phantram);
        TextView tv_item_mauso_phantram = (TextView) gridView.findViewById(R.id.tv_item_mauso_phantram);
        TextView tv_item_cua_ps1 = (TextView) gridView.findViewById(R.id.tv_item_cua_ps1);
        TextView tv_item_tuso_cua1 = (TextView) gridView.findViewById(R.id.tv_item_tuso_cua1);
        TextView tv_item_mauso_cua1 = (TextView) gridView.findViewById(R.id.tv_item_mauso_cua1);
        TextView tv_item_tuso_cua2 = (TextView) gridView.findViewById(R.id.tv_item_tuso_cua2);
        TextView tv_item_mauso_cua2 = (TextView) gridView.findViewById(R.id.tv_item_mauso_cua2);

        TextView tv_item_pheptoan_hs = (TextView) gridView.findViewById(R.id.tv_item_pheptoan_hs);
        TextView tv_item_hs1 = (TextView) gridView.findViewById(R.id.tv_item_hs1);
        TextView tv_item_tuso_hs1 = (TextView) gridView.findViewById(R.id.tv_item_tuso_hs1);
        TextView tv_item_mauso_hs1 = (TextView) gridView.findViewById(R.id.tv_item_mauso_hs1);
        TextView tv_item_hs2 = (TextView) gridView.findViewById(R.id.tv_item_hs2);
        TextView tv_item_tuso_hs2 = (TextView) gridView.findViewById(R.id.tv_item_tuso_hs2);
        TextView tv_item_mauso_hs2 = (TextView) gridView.findViewById(R.id.tv_item_mauso_hs2);
        TextView tv_item_cua_ps2= (TextView) gridView.findViewById(R.id.tv_item_cua_ps2);
        TextView tv_item_tuso_cua3= (TextView) gridView.findViewById(R.id.tv_item_tuso_cua3);
        TextView tv_item_mauso_cua3= (TextView) gridView.findViewById(R.id.tv_item_mauso_cua3);

        if(phepToanArrayList.get(position).getKetqua()<0)
        {
            if(phepToanArrayList.get(position).getKetqua()==-1)
            {
                if(phepToanArrayList.get(position).getCongthuc().equals("tron"))
                {
                    // rl_item_pheptoan_bg.setBackgroundResource(R.drawable.hinhtron);
                    Picasso.get().load(R.drawable.hinhtron)
                            .placeholder(R.drawable.hinhtron)
                            .error(R.drawable.hinhtron)
                            .transform(new RoundedTransformation(0, 0))
                            .fit().centerCrop()
                            .into(rl_item_pheptoan_bg);
                }else {
                    tv_item_pheptoan.setText(phepToanArrayList.get(position).getCongthuc());
                }
            }
            if(phepToanArrayList.get(position).getKetqua()==-2)
            {
                if(phepToanArrayList.get(position).getCongthuc().equals("vuong"))
                {
                    Picasso.get().load(R.drawable.hinhvuong)
                            .placeholder(R.drawable.hinhvuong)
                            .error(R.drawable.hinhvuong)
                            .transform(new RoundedTransformation(0, 0))
                            .fit().centerCrop()
                            .into(rl_item_pheptoan_bg);
                }else {
                    tv_item_pheptoan.setText(phepToanArrayList.get(position).getCongthuc());
                }
            }
            if(phepToanArrayList.get(position).getKetqua()==-3)
            {
                if(phepToanArrayList.get(position).getCongthuc().equals("tamgiac"))
                {
                    Picasso.get().load(R.drawable.hinhtamgiac)
                            .placeholder(R.drawable.hinhtamgiac)
                            .error(R.drawable.hinhtamgiac)
                            .transform(new RoundedTransformation(0, 0))
                            .fit().centerCrop()
                            .into(rl_item_pheptoan_bg);
                }else {
                    tv_item_pheptoan.setText(phepToanArrayList.get(position).getCongthuc());
                }
            }
            if(phepToanArrayList.get(position).getKetqua()==-4)
            {
                if(phepToanArrayList.get(position).getCongthuc().equals("sao"))
                {
                    Picasso.get().load(R.drawable.hinhngoisao)
                            .placeholder(R.drawable.hinhngoisao)
                            .error(R.drawable.hinhngoisao)
                            .transform(new RoundedTransformation(0, 0))
                            .fit().centerCrop()
                            .into(rl_item_pheptoan_bg);
                }else {
                    tv_item_pheptoan.setText(phepToanArrayList.get(position).getCongthuc());
                }
            }
            if(phepToanArrayList.get(position).getKetqua()==-5)
            {
                if(phepToanArrayList.get(position).getCongthuc().equals("chunhat"))
                {
                    Picasso.get().load(R.drawable.hinhchunhat)
                            .placeholder(R.drawable.hinhchunhat)
                            .error(R.drawable.hinhchunhat)
                            .transform(new RoundedTransformation(0, 0))
                            .fit().centerCrop()
                            .into(rl_item_pheptoan_bg);
                }else {
                    tv_item_pheptoan.setText(phepToanArrayList.get(position).getCongthuc());
                }
            }
            if(phepToanArrayList.get(position).getKetqua()==-6)
            {
                if(phepToanArrayList.get(position).getCongthuc().equals("ngugiac"))
                {
                    Picasso.get().load(R.drawable.hinhngugiac)
                            .placeholder(R.drawable.hinhngugiac)
                            .error(R.drawable.hinhngugiac)
                            .transform(new RoundedTransformation(0, 0))
                            .fit().centerCrop()
                            .into(rl_item_pheptoan_bg);
                }else {
                    tv_item_pheptoan.setText(phepToanArrayList.get(position).getCongthuc());
                }
            }
            if(phepToanArrayList.get(position).getKetqua()==-7)
            {
                if(phepToanArrayList.get(position).getCongthuc().equals("lucgiac"))
                {
                    Picasso.get().load(R.drawable.hinhlucgiac)
                            .placeholder(R.drawable.hinhlucgiac)
                            .error(R.drawable.hinhlucgiac)
                            .transform(new RoundedTransformation(0, 0))
                            .fit().centerCrop()
                            .into(rl_item_pheptoan_bg);
                }else {
                    tv_item_pheptoan.setText(phepToanArrayList.get(position).getCongthuc());
                }
            }
        }else if(phepToanArrayList.get(position).getCongthuc().equals("chicken"))
        {
            switch ((int) phepToanArrayList.get(position).getKetqua())
            {
                case 1:
                    Picasso.get().load(R.drawable.meo1)
                            .placeholder(R.drawable.meo1)
                            .error(R.drawable.meo1)
                            .transform(new RoundedTransformation(0, 0))
                            .fit().centerCrop()
                            .into(rl_item_pheptoan_bg);
                    break;
                case 2:
                    Picasso.get().load(R.drawable.meo2)
                            .placeholder(R.drawable.meo2)
                            .error(R.drawable.meo2)
                            .transform(new RoundedTransformation(0, 0))
                            .fit().centerCrop()
                            .into(rl_item_pheptoan_bg);
                    break;
                case 3:
                    Picasso.get().load(R.drawable.meo3)
                            .placeholder(R.drawable.meo3)
                            .error(R.drawable.meo3)
                            .transform(new RoundedTransformation(0, 0))
                            .fit().centerCrop()
                            .into(rl_item_pheptoan_bg);
                    break;
                case 4:
                    Picasso.get().load(R.drawable.meo4)
                            .placeholder(R.drawable.meo4)
                            .error(R.drawable.meo4)
                            .transform(new RoundedTransformation(0, 0))
                            .fit().centerCrop()
                            .into(rl_item_pheptoan_bg);
                    break;
                case 5:
                    Picasso.get().load(R.drawable.meo5)
                            .placeholder(R.drawable.meo5)
                            .error(R.drawable.meo5)
                            .transform(new RoundedTransformation(0, 0))
                            .fit().centerCrop()
                            .into(rl_item_pheptoan_bg);
                    break;
                case 6:
                    Picasso.get().load(R.drawable.meo6)
                            .placeholder(R.drawable.meo6)
                            .error(R.drawable.meo6)
                            .transform(new RoundedTransformation(0, 0))
                            .fit().centerCrop()
                            .into(rl_item_pheptoan_bg);
                    break;
                case 7:
                    Picasso.get().load(R.drawable.meo7)
                            .placeholder(R.drawable.meo7)
                            .error(R.drawable.meo7)
                            .transform(new RoundedTransformation(0, 0))
                            .fit().centerCrop()
                            .into(rl_item_pheptoan_bg);
                    break;
                case 8:
                    Picasso.get().load(R.drawable.meo8)
                            .placeholder(R.drawable.meo8)
                            .error(R.drawable.meo8)
                            .transform(new RoundedTransformation(0, 0))
                            .fit().centerCrop()
                            .into(rl_item_pheptoan_bg);
                    break;
                case 9:
                    Picasso.get().load(R.drawable.meo9)
                            .placeholder(R.drawable.meo9)
                            .error(R.drawable.meo9)
                            .transform(new RoundedTransformation(0, 0))
                            .fit().centerCrop()
                            .into(rl_item_pheptoan_bg);
                    break;
                default:
                    Picasso.get().load(R.drawable.meo10)
                            .placeholder(R.drawable.meo10)
                            .error(R.drawable.meo10)
                            .transform(new RoundedTransformation(0, 0))
                            .fit().centerCrop()
                            .into(rl_item_pheptoan_bg);
                    break;
            }

        }else if(phepToanArrayList.get(position).getCongthuc().equals("hoa"))
        {
            switch ((int)phepToanArrayList.get(position).getKetqua())
            {
                case 1:
                    Picasso.get().load(R.drawable.hoa1)
                            .placeholder(R.drawable.hoa1)
                            .error(R.drawable.hoa1)
                            .transform(new RoundedTransformation(0, 0))
                            .fit().centerCrop()
                            .into(rl_item_pheptoan_bg);
                    break;
                case 2:
                    Picasso.get().load(R.drawable.hoa2)
                            .placeholder(R.drawable.hoa2)
                            .error(R.drawable.hoa2)
                            .transform(new RoundedTransformation(0, 0))
                            .fit().centerCrop()
                            .into(rl_item_pheptoan_bg);
                    break;
                case 3:
                    //rl_item_pheptoan_bg.setBackgroundResource(R.drawable.hoa3);
                    Picasso.get().load(R.drawable.hoa3)
                            .placeholder(R.drawable.hoa3)
                            .error(R.drawable.hoa3)
                            .transform(new RoundedTransformation(0, 0))
                            .fit().centerCrop()
                            .into(rl_item_pheptoan_bg);
                    break;
                case 4:
                    // rl_item_pheptoan_bg.setBackgroundResource(R.drawable.hoa4);
                    Picasso.get().load(R.drawable.hoa4)
                            .placeholder(R.drawable.hoa4)
                            .error(R.drawable.hoa4)
                            .transform(new RoundedTransformation(0, 0))
                            .fit().centerCrop()
                            .into(rl_item_pheptoan_bg);
                    break;
                case 5:
                    // rl_item_pheptoan_bg.setBackgroundResource(R.drawable.hoa5);
                    Picasso.get().load(R.drawable.hoa5)
                            .placeholder(R.drawable.hoa5)
                            .error(R.drawable.hoa5)
                            .transform(new RoundedTransformation(0, 0))
                            .fit().centerCrop()
                            .into(rl_item_pheptoan_bg);
                    break;
                case 6:
                    //  rl_item_pheptoan_bg.setBackgroundResource(R.drawable.hoa6);
                    Picasso.get().load(R.drawable.hoa6)
                            .placeholder(R.drawable.hoa6)
                            .error(R.drawable.hoa6)
                            .transform(new RoundedTransformation(0, 0))
                            .fit().centerCrop()
                            .into(rl_item_pheptoan_bg);
                    break;
                case 7:
                    //rl_item_pheptoan_bg.setBackgroundResource(R.drawable.hoa7);
                    Picasso.get().load(R.drawable.hoa7)
                            .placeholder(R.drawable.hoa7)
                            .error(R.drawable.hoa7)
                            .transform(new RoundedTransformation(0, 0))
                            .fit().centerCrop()
                            .into(rl_item_pheptoan_bg);
                    break;
                case 8:
                    //  rl_item_pheptoan_bg.setBackgroundResource(R.drawable.hoa8);
                    Picasso.get().load(R.drawable.hoa8)
                            .placeholder(R.drawable.hoa8)
                            .error(R.drawable.hoa8)
                            .transform(new RoundedTransformation(0, 0))
                            .fit().centerCrop()
                            .into(rl_item_pheptoan_bg);
                    break;
                case 9:
                    //  rl_item_pheptoan_bg.setBackgroundResource(R.drawable.hoa9);
                    Picasso.get().load(R.drawable.hoa9)
                            .placeholder(R.drawable.hoa9)
                            .error(R.drawable.hoa9)
                            .transform(new RoundedTransformation(0, 0))
                            .fit().centerCrop()
                            .into(rl_item_pheptoan_bg);
                    break;
                default:
                    // rl_item_pheptoan_bg.setBackgroundResource(R.drawable.hoa10);
                    Picasso.get().load(R.drawable.hoa10)
                            .placeholder(R.drawable.hoa10)
                            .error(R.drawable.hoa10)
                            .transform(new RoundedTransformation(0, 0))
                            .fit().centerCrop()
                            .into(rl_item_pheptoan_bg);
                    break;
            }

        } else {

            tv_item_tuso_cua3.setPaintFlags(tv_item_tuso_cua3.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
            tv_item_tuso_hs1.setPaintFlags(tv_item_tuso_hs1.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
            tv_item_tuso_hs2.setPaintFlags(tv_item_tuso_hs2.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
            tv_item_tuso_cua2.setPaintFlags(tv_item_tuso_cua2.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
            tv_item_tuso_cua1.setPaintFlags(tv_item_tuso_cua1.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
            tv_item_tuso_phantram.setPaintFlags(tv_item_tuso_phantram.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

            if (phepToanArrayList.get(position).getCongthuc().contains("%c")) {
                if (phepToanArrayList.get(position).getCongthuc().contains("/")) {
                    tv_item_phantram_ps.setText(phepToanArrayList.get(position).getCongthuc().substring(0, phepToanArrayList.get(position).getCongthuc().indexOf("c")) + " "+context.getString(R.string.of));
                    tv_item_tuso_phantram.setText(phepToanArrayList.get(position).getCongthuc().substring(phepToanArrayList.get(position).getCongthuc().indexOf("c") + 1, phepToanArrayList.get(position).getCongthuc().indexOf("/")));
                    tv_item_mauso_phantram.setText(phepToanArrayList.get(position).getCongthuc().substring(phepToanArrayList.get(position).getCongthuc().indexOf("/") + 1));
                } else {
                    tv_item_pheptoan.setText(phepToanArrayList.get(position).getCongthuc().replaceAll("c", " "+context.getString(R.string.of)+" "));
                }
            } else if (phepToanArrayList.get(position).getCongthuc().contains("c")) {
                if (phepToanArrayList.get(position).getCongthuc().substring(phepToanArrayList.get(position).getCongthuc().indexOf("c") + 1).contains("/")) {
                    tv_item_tuso_cua1.setText(phepToanArrayList.get(position).getCongthuc().substring(0, phepToanArrayList.get(position).getCongthuc().indexOf("/")));
                    tv_item_mauso_cua1.setText(phepToanArrayList.get(position).getCongthuc().substring(phepToanArrayList.get(position).getCongthuc().indexOf("/") + 1, phepToanArrayList.get(position).getCongthuc().indexOf("c")));
                    tv_item_cua_ps1.setText(" "+context.getString(R.string.of)+" ");
                    tv_item_tuso_cua2.setText(phepToanArrayList.get(position).getCongthuc().substring(phepToanArrayList.get(position).getCongthuc().indexOf("c") + 1, phepToanArrayList.get(position).getCongthuc().indexOf("/", phepToanArrayList.get(position).getCongthuc().indexOf("/") + 1)));
                    tv_item_mauso_cua2.setText(phepToanArrayList.get(position).getCongthuc().substring(phepToanArrayList.get(position).getCongthuc().indexOf("/", phepToanArrayList.get(position).getCongthuc().indexOf("/") + 1) + 1));

                } else {
                    try {
                        if(phepToanArrayList.get(position).getCongthuc().contains("/")&&phepToanArrayList.get(position).getCongthuc().contains("c"))
                        {
                            tv_item_tuso_cua1.setText(phepToanArrayList.get(position).getCongthuc().substring(0, phepToanArrayList.get(position).getCongthuc().indexOf("/")));
                            tv_item_mauso_cua1.setText(phepToanArrayList.get(position).getCongthuc().substring(phepToanArrayList.get(position).getCongthuc().indexOf("/") + 1, phepToanArrayList.get(position).getCongthuc().indexOf("c")));
                            tv_item_cua_ps1.setText(phepToanArrayList.get(position).getCongthuc().substring(phepToanArrayList.get(position).getCongthuc().indexOf("c")).replaceAll("c", " "+context.getString(R.string.of)+" "));
                        }else
                        {
                            tv_item_pheptoan.setText(phepToanArrayList.get(position).getCongthuc());
                        }
                    }catch (Exception e)
                    {
                        tv_item_pheptoan.setText(phepToanArrayList.get(position).getCongthuc());
                    }



                }

            } else if (phepToanArrayList.get(position).getCongthuc().contains("]") && (phepToanArrayList.get(position).getCongthuc().contains("+") || phepToanArrayList.get(position).getCongthuc().contains("-") || phepToanArrayList.get(position).getCongthuc().contains("x") || phepToanArrayList.get(position).getCongthuc().contains(":"))) {
                if (phepToanArrayList.get(position).getCongthuc().contains("x")) {
                    tv_item_pheptoan_hs.setText(" x ");
                    tv_item_mauso_hs1.setText(phepToanArrayList.get(position).getCongthuc().substring(phepToanArrayList.get(position).getCongthuc().indexOf("/") + 1, phepToanArrayList.get(position).getCongthuc().indexOf("x")));
                    tv_item_hs2.setText(phepToanArrayList.get(position).getCongthuc().substring(phepToanArrayList.get(position).getCongthuc().indexOf("x") + 1, phepToanArrayList.get(position).getCongthuc().indexOf("]", phepToanArrayList.get(position).getCongthuc().indexOf("]") + 1)));
                }
                if (phepToanArrayList.get(position).getCongthuc().contains(":")) {
                    tv_item_pheptoan_hs.setText(" : ");
                    tv_item_mauso_hs1.setText(phepToanArrayList.get(position).getCongthuc().substring(phepToanArrayList.get(position).getCongthuc().indexOf("/") + 1, phepToanArrayList.get(position).getCongthuc().indexOf(":")));
                    tv_item_hs2.setText(phepToanArrayList.get(position).getCongthuc().substring(phepToanArrayList.get(position).getCongthuc().indexOf(":") + 1, phepToanArrayList.get(position).getCongthuc().indexOf("]", phepToanArrayList.get(position).getCongthuc().indexOf("]") + 1)));
                }
                if (phepToanArrayList.get(position).getCongthuc().contains("+")) {
                    tv_item_pheptoan_hs.setText(" + ");
                    tv_item_mauso_hs1.setText(phepToanArrayList.get(position).getCongthuc().substring(phepToanArrayList.get(position).getCongthuc().indexOf("/") + 1, phepToanArrayList.get(position).getCongthuc().indexOf("+")));
                    tv_item_hs2.setText(phepToanArrayList.get(position).getCongthuc().substring(phepToanArrayList.get(position).getCongthuc().indexOf("+") + 1, phepToanArrayList.get(position).getCongthuc().indexOf("]", phepToanArrayList.get(position).getCongthuc().indexOf("]") + 1)));
                }
                if (phepToanArrayList.get(position).getCongthuc().contains("-")) {
                    tv_item_pheptoan_hs.setText(" - ");
                    tv_item_mauso_hs1.setText(phepToanArrayList.get(position).getCongthuc().substring(phepToanArrayList.get(position).getCongthuc().indexOf("/") + 1, phepToanArrayList.get(position).getCongthuc().indexOf("-")));
                    tv_item_hs2.setText(phepToanArrayList.get(position).getCongthuc().substring(phepToanArrayList.get(position).getCongthuc().indexOf("-") + 1, phepToanArrayList.get(position).getCongthuc().indexOf("]", phepToanArrayList.get(position).getCongthuc().indexOf("]") + 1)));
                }
                tv_item_hs1.setText(phepToanArrayList.get(position).getCongthuc().substring(0, phepToanArrayList.get(position).getCongthuc().indexOf("]")));
                tv_item_tuso_hs1.setText(phepToanArrayList.get(position).getCongthuc().substring(phepToanArrayList.get(position).getCongthuc().indexOf("]") + 1, phepToanArrayList.get(position).getCongthuc().indexOf("/")));
                tv_item_tuso_hs2.setText(phepToanArrayList.get(position).getCongthuc().substring(phepToanArrayList.get(position).getCongthuc().indexOf("]", phepToanArrayList.get(position).getCongthuc().indexOf("]") + 1) + 1, phepToanArrayList.get(position).getCongthuc().indexOf("/", phepToanArrayList.get(position).getCongthuc().indexOf("/") + 1)));
                tv_item_mauso_hs2.setText(phepToanArrayList.get(position).getCongthuc().substring(phepToanArrayList.get(position).getCongthuc().indexOf("/", phepToanArrayList.get(position).getCongthuc().indexOf("/") + 1) + 1));
            } else if (phepToanArrayList.get(position).getCongthuc().contains("]")) {
                tv_item_hs1.setText(phepToanArrayList.get(position).getCongthuc().substring(0, phepToanArrayList.get(position).getCongthuc().indexOf("]")));
                tv_item_tuso_hs1.setText(phepToanArrayList.get(position).getCongthuc().substring(phepToanArrayList.get(position).getCongthuc().indexOf("]") + 1, phepToanArrayList.get(position).getCongthuc().indexOf("/")));
                tv_item_mauso_hs1.setText(phepToanArrayList.get(position).getCongthuc().substring(phepToanArrayList.get(position).getCongthuc().indexOf("/") + 1));
            } else if (phepToanArrayList.get(position).getCongthuc().contains("/") && phepToanArrayList.get(position).getCongthuc().contains(")")) {
                tv_item_tuso_cua1.setText(phepToanArrayList.get(position).getCongthuc().substring(0, phepToanArrayList.get(position).getCongthuc().indexOf("/")).replaceAll("\\)", "").replaceAll("\\(", ""));
                tv_item_mauso_hs1.setText(phepToanArrayList.get(position).getCongthuc().substring(phepToanArrayList.get(position).getCongthuc().indexOf("/") + 1).replaceAll("\\)", "").replaceAll("\\(", ""));
            } else if (phepToanArrayList.get(position).getCongthuc().contains("/")) {
                if (phepToanArrayList.get(position).getCongthuc().contains("+") || phepToanArrayList.get(position).getCongthuc().contains("-") || phepToanArrayList.get(position).getCongthuc().contains("x") || phepToanArrayList.get(position).getCongthuc().contains(":")) {
                    String[] mang = phepToanArrayList.get(position).getCongthuc().split("\\+|x|:|-");
                    if (mang.length >= 3) {
                        //String pheptoan=phepToanArrayList.get(position).getCongthuc();
                        String dau1 = "";
                        String dau2 = "";
                        if (phepToanArrayList.get(position).getCongthuc().contains("+") && phepToanArrayList.get(position).getCongthuc().contains("-")) {
                            int vtd1 = phepToanArrayList.get(position).getCongthuc().indexOf('+');
                            int vtd2 = phepToanArrayList.get(position).getCongthuc().indexOf('-');
                            if (vtd1 > vtd2) {
                                dau1 = "-";
                                dau2 = "+";
                            } else {
                                dau1 = "+";
                                dau2 = "-";
                            }

                        } else if (phepToanArrayList.get(position).getCongthuc().contains("+") && phepToanArrayList.get(position).getCongthuc().contains("x")) {
                            int vtd1 = phepToanArrayList.get(position).getCongthuc().indexOf('+');
                            int vtd2 = phepToanArrayList.get(position).getCongthuc().indexOf('x');
                            if (vtd1 > vtd2) {
                                dau1 = "x";
                                dau2 = "+";
                            } else {
                                dau1 = "+";
                                dau2 = "x";
                            }
                        } else if (phepToanArrayList.get(position).getCongthuc().contains("+") && phepToanArrayList.get(position).getCongthuc().contains(":")) {
                            int vtd1 = phepToanArrayList.get(position).getCongthuc().indexOf('+');
                            int vtd2 = phepToanArrayList.get(position).getCongthuc().indexOf(':');
                            if (vtd1 > vtd2) {
                                dau1 = ":";
                                dau2 = "+";
                            } else {
                                dau1 = "+";
                                dau2 = ":";
                            }
                        } else if (phepToanArrayList.get(position).getCongthuc().contains("-") && phepToanArrayList.get(position).getCongthuc().contains("x")) {
                            int vtd1 = phepToanArrayList.get(position).getCongthuc().indexOf('-');
                            int vtd2 = phepToanArrayList.get(position).getCongthuc().indexOf('x');
                            if (vtd1 > vtd2) {
                                dau1 = "x";
                                dau2 = "-";
                            } else {
                                dau1 = "-";
                                dau2 = "x";
                            }
                        } else if (phepToanArrayList.get(position).getCongthuc().contains("-") && phepToanArrayList.get(position).getCongthuc().contains(":")) {
                            int vtd1 = phepToanArrayList.get(position).getCongthuc().indexOf('-');
                            int vtd2 = phepToanArrayList.get(position).getCongthuc().indexOf(':');
                            if (vtd1 > vtd2) {
                                dau1 = ":";
                                dau2 = "-";
                            } else {
                                dau1 = "-";
                                dau2 = ":";
                            }
                        } else if (phepToanArrayList.get(position).getCongthuc().contains("x") && phepToanArrayList.get(position).getCongthuc().contains(":")) {
                            int vtd1 = phepToanArrayList.get(position).getCongthuc().indexOf('x');
                            int vtd2 = phepToanArrayList.get(position).getCongthuc().indexOf(':');
                            if (vtd1 > vtd2) {
                                dau1 = ":";
                                dau2 = "x";
                            } else {
                                dau1 = "x";
                                dau2 = ":";
                            }
                        } else if (phepToanArrayList.get(position).getCongthuc().contains("+")) {
                            dau1 = "+";
                            dau2 = "+";
                        } else if (phepToanArrayList.get(position).getCongthuc().contains("-")) {
                            dau1 = "-";
                            dau2 = "-";
                        } else if (phepToanArrayList.get(position).getCongthuc().contains("x")) {
                            dau1 = "x";
                            dau2 = "x";
                        } else if (phepToanArrayList.get(position).getCongthuc().contains(":")) {
                            dau1 = ":";
                            dau2 = ":";
                        }
                        tv_item_tuso_cua1.setText(mang[0].substring(0, mang[0].indexOf("/")));
                        tv_item_mauso_cua1.setText(mang[0].substring(mang[0].indexOf("/") + 1));
                        tv_item_cua_ps1.setText(" " + dau1 + " ");

                        tv_item_tuso_cua2.setText(mang[1].substring(0, mang[1].indexOf("/")));
                        tv_item_mauso_cua2.setText(mang[1].substring(mang[1].indexOf("/") + 1));
                        tv_item_cua_ps2.setText(" " + dau2 + " ");
                        tv_item_tuso_cua3.setText(mang[2].substring(0, mang[2].indexOf("/")));
                        tv_item_mauso_cua3.setText(mang[2].substring(mang[2].indexOf("/") + 1));

                        //--------------------------------------
                    } else {
                        if (phepToanArrayList.get(position).getCongthuc().contains("+")) {
                            if (phepToanArrayList.get(position).getCongthuc().substring(0, phepToanArrayList.get(position).getCongthuc().indexOf("+") + 1).contains("/")) {
                                if (phepToanArrayList.get(position).getCongthuc().substring(phepToanArrayList.get(position).getCongthuc().indexOf("+") + 1).contains("/")) {
                                    //ca 2 cung co
                                    tv_item_tuso_cua1.setText(phepToanArrayList.get(position).getCongthuc().substring(0, phepToanArrayList.get(position).getCongthuc().indexOf("/")));
                                    tv_item_mauso_cua1.setText(phepToanArrayList.get(position).getCongthuc().substring(phepToanArrayList.get(position).getCongthuc().indexOf("/") + 1, phepToanArrayList.get(position).getCongthuc().indexOf("+")));
                                    tv_item_cua_ps1.setText(" + ");
                                    tv_item_tuso_cua2.setText(phepToanArrayList.get(position).getCongthuc().substring(phepToanArrayList.get(position).getCongthuc().indexOf("+") + 1, phepToanArrayList.get(position).getCongthuc().indexOf("/", phepToanArrayList.get(position).getCongthuc().indexOf("/") + 1)));
                                    tv_item_mauso_cua2.setText(phepToanArrayList.get(position).getCongthuc().substring(phepToanArrayList.get(position).getCongthuc().indexOf("/", phepToanArrayList.get(position).getCongthuc().indexOf("/") + 1) + 1));
                                } else {
                                    //ben trai co
                                    tv_item_tuso_cua1.setText(phepToanArrayList.get(position).getCongthuc().substring(0, phepToanArrayList.get(position).getCongthuc().indexOf("/")));
                                    tv_item_mauso_cua1.setText(phepToanArrayList.get(position).getCongthuc().substring(phepToanArrayList.get(position).getCongthuc().indexOf("/") + 1, phepToanArrayList.get(position).getCongthuc().indexOf("+")));
                                    tv_item_cua_ps1.setText(" + " + phepToanArrayList.get(position).getCongthuc().substring(phepToanArrayList.get(position).getCongthuc().indexOf("+") + 1));
                                }
                            } else {
                                //Ben phai co
                                tv_item_cua_ps1.setText(phepToanArrayList.get(position).getCongthuc().substring(0, phepToanArrayList.get(position).getCongthuc().indexOf("+")) + " + ");
                                tv_item_tuso_cua2.setText(phepToanArrayList.get(position).getCongthuc().substring(phepToanArrayList.get(position).getCongthuc().indexOf("+") + 1, phepToanArrayList.get(position).getCongthuc().indexOf("/")));
                                tv_item_mauso_cua2.setText(phepToanArrayList.get(position).getCongthuc().substring(phepToanArrayList.get(position).getCongthuc().indexOf("/") + 1));
                            }
                        } else if (phepToanArrayList.get(position).getCongthuc().contains("-")) {
                            if (phepToanArrayList.get(position).getCongthuc().substring(0, phepToanArrayList.get(position).getCongthuc().indexOf("-") + 1).contains("/")) {
                                if (phepToanArrayList.get(position).getCongthuc().substring(phepToanArrayList.get(position).getCongthuc().indexOf("-") + 1).contains("/")) {
                                    //ca 2 cung co
                                    tv_item_tuso_cua1.setText(phepToanArrayList.get(position).getCongthuc().substring(0, phepToanArrayList.get(position).getCongthuc().indexOf("/")));
                                    tv_item_mauso_cua1.setText(phepToanArrayList.get(position).getCongthuc().substring(phepToanArrayList.get(position).getCongthuc().indexOf("/") + 1, phepToanArrayList.get(position).getCongthuc().indexOf("-")));
                                    tv_item_cua_ps1.setText(" - ");
                                    tv_item_tuso_cua2.setText(phepToanArrayList.get(position).getCongthuc().substring(phepToanArrayList.get(position).getCongthuc().indexOf("-") + 1, phepToanArrayList.get(position).getCongthuc().indexOf("/", phepToanArrayList.get(position).getCongthuc().indexOf("/") + 1)));
                                    tv_item_mauso_cua2.setText(phepToanArrayList.get(position).getCongthuc().substring(phepToanArrayList.get(position).getCongthuc().indexOf("/", phepToanArrayList.get(position).getCongthuc().indexOf("/") + 1) + 1));
                                } else {
                                    //ben trai co
                                    tv_item_tuso_cua1.setText(phepToanArrayList.get(position).getCongthuc().substring(0, phepToanArrayList.get(position).getCongthuc().indexOf("/")));
                                    tv_item_mauso_cua1.setText(phepToanArrayList.get(position).getCongthuc().substring(phepToanArrayList.get(position).getCongthuc().indexOf("/") + 1, phepToanArrayList.get(position).getCongthuc().indexOf("-")));
                                    tv_item_cua_ps1.setText(" - " + phepToanArrayList.get(position).getCongthuc().substring(phepToanArrayList.get(position).getCongthuc().indexOf("-") + 1));
                                }
                            } else {
                                //Ben phai co
                                tv_item_cua_ps1.setText(phepToanArrayList.get(position).getCongthuc().substring(0, phepToanArrayList.get(position).getCongthuc().indexOf("-")) + " - ");
                                tv_item_tuso_cua2.setText(phepToanArrayList.get(position).getCongthuc().substring(phepToanArrayList.get(position).getCongthuc().indexOf("-") + 1, phepToanArrayList.get(position).getCongthuc().indexOf("/")));
                                tv_item_mauso_cua2.setText(phepToanArrayList.get(position).getCongthuc().substring(phepToanArrayList.get(position).getCongthuc().indexOf("/") + 1));
                            }
                        } else if (phepToanArrayList.get(position).getCongthuc().contains("x")) {
                            if (phepToanArrayList.get(position).getCongthuc().substring(0, phepToanArrayList.get(position).getCongthuc().indexOf("x") + 1).contains("/")) {
                                if (phepToanArrayList.get(position).getCongthuc().substring(phepToanArrayList.get(position).getCongthuc().indexOf("x") + 1).contains("/")) {
                                    //ca 2 cung co
                                    tv_item_tuso_cua1.setText(phepToanArrayList.get(position).getCongthuc().substring(0, phepToanArrayList.get(position).getCongthuc().indexOf("/")));
                                    tv_item_mauso_cua1.setText(phepToanArrayList.get(position).getCongthuc().substring(phepToanArrayList.get(position).getCongthuc().indexOf("/") + 1, phepToanArrayList.get(position).getCongthuc().indexOf("x")));
                                    tv_item_cua_ps1.setText(" x ");
                                    tv_item_tuso_cua2.setText(phepToanArrayList.get(position).getCongthuc().substring(phepToanArrayList.get(position).getCongthuc().indexOf("x") + 1, phepToanArrayList.get(position).getCongthuc().indexOf("/", phepToanArrayList.get(position).getCongthuc().indexOf("/") + 1)));
                                    tv_item_mauso_cua2.setText(phepToanArrayList.get(position).getCongthuc().substring(phepToanArrayList.get(position).getCongthuc().indexOf("/", phepToanArrayList.get(position).getCongthuc().indexOf("/") + 1) + 1));
                                } else {
                                    //ben trai co
                                    tv_item_tuso_cua1.setText(phepToanArrayList.get(position).getCongthuc().substring(0, phepToanArrayList.get(position).getCongthuc().indexOf("/")));
                                    tv_item_mauso_cua1.setText(phepToanArrayList.get(position).getCongthuc().substring(phepToanArrayList.get(position).getCongthuc().indexOf("/") + 1, phepToanArrayList.get(position).getCongthuc().indexOf("x")));
                                    tv_item_cua_ps1.setText(" x " + phepToanArrayList.get(position).getCongthuc().substring(phepToanArrayList.get(position).getCongthuc().indexOf("x") + 1));
                                }
                            } else {
                                //Ben phai co
                                tv_item_cua_ps1.setText(phepToanArrayList.get(position).getCongthuc().substring(0, phepToanArrayList.get(position).getCongthuc().indexOf("x")) + " x ");
                                tv_item_tuso_cua2.setText(phepToanArrayList.get(position).getCongthuc().substring(phepToanArrayList.get(position).getCongthuc().indexOf("x") + 1, phepToanArrayList.get(position).getCongthuc().indexOf("/")));
                                tv_item_mauso_cua2.setText(phepToanArrayList.get(position).getCongthuc().substring(phepToanArrayList.get(position).getCongthuc().indexOf("/") + 1));
                            }
                        } else if (phepToanArrayList.get(position).getCongthuc().contains(":")) {
                            if (phepToanArrayList.get(position).getCongthuc().substring(0, phepToanArrayList.get(position).getCongthuc().indexOf(":") + 1).contains("/")) {
                                if (phepToanArrayList.get(position).getCongthuc().substring(phepToanArrayList.get(position).getCongthuc().indexOf(":") + 1).contains("/")) {
                                    //ca 2 cung co
                                    tv_item_tuso_cua1.setText(phepToanArrayList.get(position).getCongthuc().substring(0, phepToanArrayList.get(position).getCongthuc().indexOf("/")));
                                    tv_item_mauso_cua1.setText(phepToanArrayList.get(position).getCongthuc().substring(phepToanArrayList.get(position).getCongthuc().indexOf("/") + 1, phepToanArrayList.get(position).getCongthuc().indexOf(":")));
                                    tv_item_cua_ps1.setText(" : ");
                                    tv_item_tuso_cua2.setText(phepToanArrayList.get(position).getCongthuc().substring(phepToanArrayList.get(position).getCongthuc().indexOf(":") + 1, phepToanArrayList.get(position).getCongthuc().indexOf("/", phepToanArrayList.get(position).getCongthuc().indexOf("/") + 1)));
                                    tv_item_mauso_cua2.setText(phepToanArrayList.get(position).getCongthuc().substring(phepToanArrayList.get(position).getCongthuc().indexOf("/", phepToanArrayList.get(position).getCongthuc().indexOf("/") + 1) + 1));
                                } else {
                                    //ben trai co
                                    tv_item_tuso_cua1.setText(phepToanArrayList.get(position).getCongthuc().substring(0, phepToanArrayList.get(position).getCongthuc().indexOf("/")));
                                    tv_item_mauso_cua1.setText(phepToanArrayList.get(position).getCongthuc().substring(phepToanArrayList.get(position).getCongthuc().indexOf("/") + 1, phepToanArrayList.get(position).getCongthuc().indexOf(":")));
                                    tv_item_cua_ps1.setText(" : " + phepToanArrayList.get(position).getCongthuc().substring(phepToanArrayList.get(position).getCongthuc().indexOf(":") + 1));
                                }
                            } else {
                                //Ben phai co
                                tv_item_cua_ps1.setText(phepToanArrayList.get(position).getCongthuc().substring(0, phepToanArrayList.get(position).getCongthuc().indexOf(":")) + " : ");
                                tv_item_tuso_cua2.setText(phepToanArrayList.get(position).getCongthuc().substring(phepToanArrayList.get(position).getCongthuc().indexOf(":") + 1, phepToanArrayList.get(position).getCongthuc().indexOf("/")));
                                tv_item_mauso_cua2.setText(phepToanArrayList.get(position).getCongthuc().substring(phepToanArrayList.get(position).getCongthuc().indexOf("/") + 1));
                            }
                        }
                    }
                } else {
                    tv_item_tuso_cua1.setText(phepToanArrayList.get(position).getCongthuc().substring(0, phepToanArrayList.get(position).getCongthuc().indexOf("/")));
                    tv_item_mauso_cua1.setText(phepToanArrayList.get(position).getCongthuc().substring(phepToanArrayList.get(position).getCongthuc().indexOf("/") + 1));
                }
            } else {
                if(phepToanArrayList.get(position).getCongthuc().length()>13)
                {
                    tv_item_pheptoan.setTextSize(15.5f);
                }else if(phepToanArrayList.get(position).getCongthuc().length()>12)
                {
                    tv_item_pheptoan.setTextSize(17f);
                }
                tv_item_pheptoan.setText(phepToanArrayList.get(position).getCongthuc());
            }
        }

        return gridView;
    }

    @Override
    public int getCount() {
        return phepToanArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


}
