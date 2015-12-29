package ru.drmarkes.qualityservice;

import android.support.v4.app.Fragment;

/**
 * Created by Андрей on 27.12.2015.
 */
public class PageFragment {

    public static Fragment newInstance(int page) {
      //  if(page == 0) {
            return new SmileFragment();
    //    } else {
     //       return new QualityFragment();
     //   }
    }
}