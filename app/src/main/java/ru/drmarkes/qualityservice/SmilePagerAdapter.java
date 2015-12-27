package ru.drmarkes.qualityservice;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.Fragment;

/**
 * Created by Андрей on 27.12.2015.
 */
public class SmilePagerAdapter extends FragmentStatePagerAdapter {
    private final String[] managerTexts;

    public SmilePagerAdapter(FragmentManager fm, String[] texts) {
        super(fm);

        managerTexts = texts;

    }

    @Override
    public int getCount() {
        return managerTexts.length;
    }


    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new PageFragment();
        Bundle args = new Bundle();
        args.putString(PageFragment.PAGE_TEXT, managerTexts[position]);
        fragment.setArguments(args);
        return fragment;
    }
}
