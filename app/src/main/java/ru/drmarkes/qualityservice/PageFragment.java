package ru.drmarkes.qualityservice;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Андрей on 27.12.2015.
 */
public class PageFragment extends Fragment {
    public static final String PAGE_TEXT = "pagetext";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View pageView = inflater.inflate(R.layout.page, container, false);
        String text = getArguments().getString(PAGE_TEXT);
        TextView textView = (TextView)pageView.findViewById(R.id.fragmentText);
        textView.setText(text);
        return pageView;
    }
}
