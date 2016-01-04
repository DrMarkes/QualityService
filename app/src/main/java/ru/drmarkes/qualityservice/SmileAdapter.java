package ru.drmarkes.qualityservice;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Андрей on 27.12.2015.
 */
public class SmileAdapter extends FragmentPagerAdapter {
    private Smile smile;
    private Fragment fragment;

    public SmileAdapter(FragmentManager fm, Smile smile) {
        super(fm);
        fragment = QualityFragment.newInstance(smile);
        this.smile = smile;
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0) {
            return SmileFragment.newInstance();
        } else {
            return fragment;
        }
    }

    public Fragment getFragment() {
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

}
