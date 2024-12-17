package com.violympic.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.violympic.modul.UserFirebase;
import com.violympic.toanlop1.R;

import java.util.ArrayList;

public class UserAdapter extends   RecyclerView.Adapter<UserAdapter.ViewHolder> {
    private Context mContext;
    private ArrayList<UserFirebase> mUsers;

    public UserAdapter(Context mContext, ArrayList<UserFirebase> mUsers) {
        this.mContext = mContext;
        this.mUsers = mUsers;

    }

    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View heroView = inflater.inflate(R.layout.item_user, parent, false);
        UserAdapter.ViewHolder viewHolder = new UserAdapter.ViewHolder(heroView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolder holder, int position) {
        UserFirebase user = mUsers.get(position);

        if(position%2==0)
        {
            holder.ll_item.setBackgroundColor(Color.parseColor("#ffffff"));

        }else
        {
            holder.ll_item.setBackgroundColor(Color.parseColor("#8b9d85"));
        }

        holder.tv_item_name.setText("\uD83E\uDD16  "+user.getName_user());


        if(position==0)
        {
            holder.iv_item_top.setVisibility(View.VISIBLE);
            holder.tv_item_top.setVisibility(View.GONE);
            holder.iv_item_top.setImageResource(R.drawable.btn_rank);

        }else   if(position==1)
        {
            holder.iv_item_top.setVisibility(View.VISIBLE);
            holder.tv_item_top.setVisibility(View.GONE);
            holder.iv_item_top.setImageResource(R.drawable.top2);

        }else   if(position==2)
        {
            holder.iv_item_top.setVisibility(View.VISIBLE);
            holder.tv_item_top.setVisibility(View.GONE);
            holder.iv_item_top.setImageResource(R.drawable.top3);

        }
        else
        {
            holder.iv_item_top.setVisibility(View.GONE);
            holder.tv_item_top.setVisibility(View.VISIBLE);
            holder.tv_item_top.setText(""+(position+1));
        }


        holder.tv_item_tinh.setText(user.getTinh());
        holder.tv_item_huyen.setText(user.getHuyen());
        holder.tv_item_xa.setText(user.getXa());
        holder.tv_item_school.setText(user.getName_school());
        holder.tv_item_level.setText("LV "+user.getLevel());




//        holder.tv_item_review.setTypeface(typeok2);

    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ConstraintLayout ll_item;
        private ImageView iv_item_top;

        private TextView tv_item_top;
        private TextView tv_item_name;

        private TextView tv_item_tinh;
        private TextView tv_item_huyen;
        private TextView tv_item_xa;
        private TextView tv_item_school;
        private  TextView tv_item_level;








        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ll_item=itemView.findViewById(R.id.ll_item);
            iv_item_top = itemView.findViewById(R.id.iv_item_top);
            tv_item_top = itemView.findViewById(R.id.tv_item_top);
            tv_item_name = itemView.findViewById(R.id.tv_item_name);

              tv_item_tinh= itemView.findViewById(R.id.tv_item_tinh);
              tv_item_huyen= itemView.findViewById(R.id.tv_item_huyen);
              tv_item_xa= itemView.findViewById(R.id.tv_item_xa);
              tv_item_school= itemView.findViewById(R.id.tv_item_school);
               tv_item_level= itemView.findViewById(R.id.tv_item_level);


//            mImageHero = itemView.findViewById(R.id.image_hero);
//            mTextName = itemView.findViewById(R.id.text_name);
        }
    }
}
