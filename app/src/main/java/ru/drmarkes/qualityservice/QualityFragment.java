package ru.drmarkes.qualityservice;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import java.util.ArrayList;

/**
 * Created by Андрей on 29.12.2015.
 */
public class QualityFragment extends Fragment {
    Smile smile;
    private ArrayList<Float> values = new ArrayList<>(3);

    public static QualityFragment newInstance(Smile smile) {
        Bundle args = new Bundle();
        QualityFragment fragment = new QualityFragment();
        fragment.smile = smile;
        fragment.setArguments(args);
        return fragment;
    }

    public ArrayList<Float> getValues() {
        values.add((float)smile.getCountPositive());
        values.add((float)smile.getCountNegative());
        values.add((float)smile.getCountNeutral());
        return  values;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View qualityView = inflater.inflate(R.layout.page, container, false);
        FrameLayout frameLayout = (FrameLayout) qualityView.findViewById(R.id.frameLayout);
        values = calculateData(values);
        frameLayout.addView(new QualityCanvas(getActivity(), values));
        return qualityView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getValues();
    }

    private ArrayList<Float> calculateData(ArrayList<Float> data) {
        // TODO Auto-generated method stub
        float total = 0;
        for (float value: data) {
            total += value;
        }

        if(total == 0) {
            total = 1;
        }

        for (int i = 0; i < data.size(); i++) {
            float calculateData = 360 * (data.get(i) / total);
            data.set(i, calculateData);

        }
        return data;
    }
}
