package com.violympic.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.violympic.toanlop1.R;


public class CountryAdapter extends ArrayAdapter {
    String[] spinnerTitles;
    Context mContext;

    public CountryAdapter(@NonNull Context context, String[] titles) {
        super(context, R.layout.spinner_row_country);
        this.spinnerTitles = titles;


        this.mContext = context;
    }
    @Override
    public int getCount() {
        return spinnerTitles.length;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder mViewHolder = new ViewHolder();
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) mContext.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.spinner_row_country, parent, false);

            mViewHolder.mName = (TextView) convertView.findViewById(R.id.tvName_Country);

            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }

        mViewHolder.mName.setText(spinnerTitles[position]);


        return convertView;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getView(position, convertView, parent);
    }

    private static class ViewHolder {

        TextView mName;
    }
}
