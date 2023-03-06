package com.violympic.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.violympic.toanlop1.R;

import static com.violympic.toanlop1.MainActivity.mMaxScore;
import static com.violympic.toanlop1.MainActivity.mGrade;

public class LevelAdapter extends BaseAdapter {

    private Context context;
    String[]mang;
    int mOpen=0;
    public LevelAdapter(Context context,String[]mang)
    {
         this.context=context;
         this.mang=mang;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View gridView=inflater.inflate(R.layout.item_level, null);

        RelativeLayout rlBgItemLevel=(RelativeLayout) gridView.findViewById(R.id.rlBgItemLevel);
        TextView tvItemLevel=(TextView) gridView.findViewById(R.id.tvItemLevel);
        ImageView ivItemStar =(ImageView) gridView.findViewById(R.id.ivItemStar);
        int cMax;
        if(mGrade==1)
        {
            if(position<=3)
            {
                cMax=30;
            }else
            {
                cMax=60;
            }
        }else
        {
            cMax=mMaxScore;
        }
        tvItemLevel.setText(""+(position+1));
        for(int i=0;i<mang.length;i++)
        {
            if(Integer.parseInt(mang[i])<(cMax/2))
            {
                mOpen=i;
                break;
            }
        }

        if(Integer.parseInt(mang[position])>(cMax-3))
        {
            rlBgItemLevel.setTag(1);
            ivItemStar.setImageResource(R.drawable.basao);
        }else  if(Integer.parseInt(mang[position])>(cMax-6))
        {
            rlBgItemLevel.setTag(1);
            ivItemStar.setImageResource(R.drawable.haisao);
        }else  if(Integer.parseInt(mang[position])>(cMax/2))
        {
            rlBgItemLevel.setTag(1);
            ivItemStar.setImageResource(R.drawable.motsao);
        }else
        {
            if(position==mOpen)
            {
                rlBgItemLevel.setTag(2);
                rlBgItemLevel.setBackgroundResource(R.drawable.levelopen_focus);
                ivItemStar.setVisibility(View.GONE);
            }else {
                rlBgItemLevel.setTag(0);
                tvItemLevel.setVisibility(View.GONE);
                ivItemStar.setVisibility(View.GONE);
                rlBgItemLevel.setBackgroundResource(R.drawable.levellock);
            }
        }

        return gridView;
    }

    @Override
    public int getCount() {
        return 20;
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
