package com.violympic.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.violympic.modul.LevelUser;
import com.violympic.toanlop1.R;

import static com.violympic.toanlop1.MainActivity.mMaxScore;
import static com.violympic.toanlop1.MainActivity.mGrade;

import java.util.ArrayList;

public class LevelAdapter extends BaseAdapter {

    private Context context;
    ArrayList<LevelUser>levelUserArrayList;

    public LevelAdapter(Context context, ArrayList<LevelUser> levelUserArrayList)
    {
         this.context=context;
         this.levelUserArrayList=levelUserArrayList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View gridView=inflater.inflate(R.layout.item_level, null);

        RelativeLayout rlBgItemLevel=(RelativeLayout) gridView.findViewById(R.id.rlBgItemLevel);
        TextView tvItemLevel=(TextView) gridView.findViewById(R.id.tvItemLevel);
        ImageView ivItemStar =(ImageView) gridView.findViewById(R.id.ivItemStar);

        tvItemLevel.setText(""+(position+1));

        if(levelUserArrayList.get(position).getStar()==3)
        {
            rlBgItemLevel.setTag(1);
            ivItemStar.setImageResource(R.drawable.basao);
        }else  if(levelUserArrayList.get(position).getStar()==2)
        {
            rlBgItemLevel.setTag(1);
            ivItemStar.setImageResource(R.drawable.haisao);
        }else  if(levelUserArrayList.get(position).getStar()==1)
        {
            rlBgItemLevel.setTag(1);
            ivItemStar.setImageResource(R.drawable.motsao);
        }else
        {
            if(levelUserArrayList.get(position).getStatus()==1)
            {
                rlBgItemLevel.setTag(2);
                rlBgItemLevel.setBackgroundResource(R.drawable.levelopen_focus);
                ivItemStar.setVisibility(View.GONE);
            }else if(levelUserArrayList.get(position).getStatus()==3)
            {
                rlBgItemLevel.setTag(2);
                rlBgItemLevel.setBackgroundResource(R.drawable.levellock);
                ivItemStar.setVisibility(View.GONE);
                tvItemLevel.setVisibility(View.GONE);
            }
            else {
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
