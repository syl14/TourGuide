package com.example.szilvi.tour_guide_bp;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class SampleFragmentPagerAdapter extends FragmentPagerAdapter {
    private Context mContext;

    public SampleFragmentPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    // This determines the fragment for each tab
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new ViewFragment();
        } else if (position == 1) {
            return new FunFragment();
        } else if (position == 2){
            return new RestaurantsFragment();
        }
            else {
            return new NightFragment();
        }
    }


    // This determines the number of tabs
    @Override
    public int getCount() {
        return 4;
    }

    // This determines the title for each tab
    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        if (position == 0) {
            return mContext.getString(R.string.category_view);
        } else if (position == 1) {
            return mContext.getString(R.string.category_fun);
        } else if (position==2){
            return mContext.getString((R.string.category_restaurant));
        }
        else {
            return mContext.getString(R.string.category_night);
        }
    }

}

