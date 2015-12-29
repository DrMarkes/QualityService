package ru.drmarkes.qualityservice;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Андрей on 29.12.2015.
 */
public class QualityFragment extends Fragment {
    private int num;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View qualityView = inflater.inflate(R.layout.page, container, false);
        TextView textView = (TextView)qualityView.findViewById(R.id.displayText);
        textView.setText("Фрагмент " + num);
        return qualityView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = new Bundle();
        args.putInt("num", num);
        setArguments(args);
    }
}
