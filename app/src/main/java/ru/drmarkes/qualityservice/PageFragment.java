package ru.drmarkes.qualityservice;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by Андрей on 27.12.2015.
 */
public class PageFragment extends Fragment implements View.OnClickListener{
    private int pageNumber;

    public static PageFragment newInstance(int page) {
        PageFragment fragment = new PageFragment();
        Bundle args=new Bundle();
        args.putInt("num", page);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageNumber = getArguments().getInt("num");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View result;
        if(pageNumber == 0) {
            result = inflater.inflate(R.layout.smile_page, container, false);
        } else {
            result = inflater.inflate(R.layout.page, container, false);
            TextView pageHeader = (TextView) result.findViewById(R.id.displayText);
            pageHeader.setText("Фрагмент " + String.valueOf(pageNumber + 1));
        }
        return result;
    }

    @Override
    public void onClick(View v) {

    }
}