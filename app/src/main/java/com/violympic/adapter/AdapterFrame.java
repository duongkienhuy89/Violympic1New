package com.violympic.adapter;


import android.content.Context;

        import androidx.annotation.NonNull;
        import androidx.fragment.app.Fragment;
        import androidx.fragment.app.FragmentManager;
        import androidx.fragment.app.FragmentStatePagerAdapter;
        import androidx.viewpager.widget.PagerAdapter;

import com.violympic.frame.MonkeyFrame;

public class AdapterFrame extends FragmentStatePagerAdapter {
    Context context;
    public AdapterFrame(@NonNull FragmentManager fm, Context context) {
        super(fm);
        this.context=context;
    }
    int mCount;
    @NonNull
    @Override
    public Fragment getItem(int position) {
        return new MonkeyFrame().newInstance(position);
    }
    public void setmCount(int mCount) {
        this.mCount = mCount;
    }

    @Override
    public int getCount() {
        return mCount;
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return PagerAdapter.POSITION_NONE;
    }
}
