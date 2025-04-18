package com.violympic.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import com.violympic.general.RoundedTransformation;
import com.violympic.modul.PhepToan;
import com.violympic.toanlop1.R;


public class EqualOneAdapter12 extends BaseAdapter {

    private Context context;
    ArrayList<PhepToan> phepToanArrayList;
    public EqualOneAdapter12(Context context,ArrayList<PhepToan> phepToanArrayList1)
    {
        this.context=context;
        this.phepToanArrayList=phepToanArrayList1;

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View gridView = inflater.inflate(R.layout.item_equal_one_12, null);

        ImageView rl_item_pheptoan_bg=(ImageView) gridView.findViewById(R.id.rl_item_pheptoan_bg_one_12);
        TextView tv_item_pheptoan = (TextView) gridView.findViewById(R.id.tv_item_pheptoan_one_12);
        TextView tv_item_pheptoan_one_12_flag = (TextView) gridView.findViewById(R.id.tv_item_pheptoan_one_12_flag);
        tv_item_pheptoan.setText("");
        tv_item_pheptoan_one_12_flag.setText("");

        if(phepToanArrayList.get(position).getIs_flag()==0) {
            if (phepToanArrayList.get(position).getKetqua() < 0) {
                if (phepToanArrayList.get(position).getKetqua() == -1) {
                    if (phepToanArrayList.get(position).getCongthuc().equals("tron")) {
                        // rl_item_pheptoan_bg.setBackgroundResource(R.drawable.hinhtron);
                        Picasso.get().load(R.drawable.hinhtron)
                                .placeholder(R.drawable.hinhtron)
                                .error(R.drawable.hinhtron)
                                .transform(new RoundedTransformation(0, 0))
                                .fit().centerCrop()
                                .into(rl_item_pheptoan_bg);
                    } else {
                        tv_item_pheptoan.setText(phepToanArrayList.get(position).getCongthuc());
                    }
                }
                if (phepToanArrayList.get(position).getKetqua() == -2) {
                    if (phepToanArrayList.get(position).getCongthuc().equals("vuong")) {
                        Picasso.get().load(R.drawable.hinhvuong)
                                .placeholder(R.drawable.hinhvuong)
                                .error(R.drawable.hinhvuong)
                                .transform(new RoundedTransformation(0, 0))
                                .fit().centerCrop()
                                .into(rl_item_pheptoan_bg);
                    } else {
                        tv_item_pheptoan.setText(phepToanArrayList.get(position).getCongthuc());
                    }
                }
                if (phepToanArrayList.get(position).getKetqua() == -3) {
                    if (phepToanArrayList.get(position).getCongthuc().equals("tamgiac")) {
                        Picasso.get().load(R.drawable.hinhtamgiac)
                                .placeholder(R.drawable.hinhtamgiac)
                                .error(R.drawable.hinhtamgiac)
                                .transform(new RoundedTransformation(0, 0))
                                .fit().centerCrop()
                                .into(rl_item_pheptoan_bg);
                    } else {
                        tv_item_pheptoan.setText(phepToanArrayList.get(position).getCongthuc());
                    }
                }
                if (phepToanArrayList.get(position).getKetqua() == -4) {
                    if (phepToanArrayList.get(position).getCongthuc().equals("sao")) {
                        Picasso.get().load(R.drawable.hinhngoisao)
                                .placeholder(R.drawable.hinhngoisao)
                                .error(R.drawable.hinhngoisao)
                                .transform(new RoundedTransformation(0, 0))
                                .fit().centerCrop()
                                .into(rl_item_pheptoan_bg);
                    } else {
                        tv_item_pheptoan.setText(phepToanArrayList.get(position).getCongthuc());
                    }
                }
                if (phepToanArrayList.get(position).getKetqua() == -5) {
                    if (phepToanArrayList.get(position).getCongthuc().equals("chunhat")) {
                        Picasso.get().load(R.drawable.hinhchunhat)
                                .placeholder(R.drawable.hinhchunhat)
                                .error(R.drawable.hinhchunhat)
                                .transform(new RoundedTransformation(0, 0))
                                .fit().centerCrop()
                                .into(rl_item_pheptoan_bg);
                    } else {
                        tv_item_pheptoan.setText(phepToanArrayList.get(position).getCongthuc());
                    }
                }
                if (phepToanArrayList.get(position).getKetqua() == -6) {
                    if (phepToanArrayList.get(position).getCongthuc().equals("ngugiac")) {
                        Picasso.get().load(R.drawable.hinhngugiac)
                                .placeholder(R.drawable.hinhngugiac)
                                .error(R.drawable.hinhngugiac)
                                .transform(new RoundedTransformation(0, 0))
                                .fit().centerCrop()
                                .into(rl_item_pheptoan_bg);
                    } else {
                        tv_item_pheptoan.setText(phepToanArrayList.get(position).getCongthuc());
                    }
                }
                if (phepToanArrayList.get(position).getKetqua() == -7) {
                    if (phepToanArrayList.get(position).getCongthuc().equals("lucgiac")) {
                        Picasso.get().load(R.drawable.hinhlucgiac)
                                .placeholder(R.drawable.hinhlucgiac)
                                .error(R.drawable.hinhlucgiac)
                                .transform(new RoundedTransformation(0, 0))
                                .fit().centerCrop()
                                .into(rl_item_pheptoan_bg);
                    } else {
                        tv_item_pheptoan.setText(phepToanArrayList.get(position).getCongthuc());
                    }
                }
            } else if (phepToanArrayList.get(position).getCongthuc().equals("chicken")) {
                switch ((int) phepToanArrayList.get(position).getKetqua()) {
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

            } else if (phepToanArrayList.get(position).getCongthuc().equals("hoa")) {
                switch ((int) phepToanArrayList.get(position).getKetqua()) {
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

                tv_item_pheptoan.setText(phepToanArrayList.get(position).getCongthuc());
            }
        }else
        {
            tv_item_pheptoan_one_12_flag.setText(phepToanArrayList.get(position).getCongthuc());
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
