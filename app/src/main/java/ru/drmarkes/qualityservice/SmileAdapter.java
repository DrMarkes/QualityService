package ru.drmarkes.qualityservice;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Андрей on 27.12.2015.
 */
public class SmileAdapter extends FragmentPagerAdapter {

    public SmileAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return PageFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return 2;
    }
}
