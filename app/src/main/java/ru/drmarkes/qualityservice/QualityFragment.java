package ru.drmarkes.qualityservice;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Андрей on 29.12.2015.
 */
public class QualityFragment extends Fragment implements MainActivity.onChahgedSmileFieldsListener {
    private Smile smile;
    private ArrayList<Float> values = new ArrayList<>(3);
    private View qualityView;

    public static QualityFragment newInstance(Smile smile) {
        Bundle args = new Bundle();
        QualityFragment fragment = new QualityFragment();
        fragment.smile = smile;
        fragment.setArguments(args);
        return fragment;
    }

    public ArrayList<Float> getValues() {
        values.add(0, (float) smile.getCountPositive());
        values.add(1, (float) smile.getCountNegative());
        values.add(2, (float) smile.getCountNeutral());
        return  values;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        qualityView = inflater.inflate(R.layout.page, container, false);
        drawQuality();
        return qualityView;
    }

    public void drawQuality() {
        getValues();
        // values = calculateData(values);
        TextView textPositive = (TextView)qualityView.findViewById(R.id.textViewPositive);
        textPositive.setText("Позитивных отзывов: " + Float.toString(values.get(0)));

        TextView textNeutral = (TextView)qualityView.findViewById(R.id.textViewNeutral);
        textNeutral.setText("Нейтральных отзывов: " + Float.toString(values.get(2)));

        TextView textNegative = (TextView)qualityView.findViewById(R.id.textViewNegative);
        textNegative.setText("Негативных отзывов: " + Float.toString(values.get(1)));
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

    @Override
    public void changeSmileFields() {
        drawQuality();
    }
}
