package ru.drmarkes.qualityservice;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import java.util.ArrayList;

/**
 * Created by Андрей on 29.12.2015.
 */
public class QualityFragment extends Fragment implements MainActivity.onChahgedSmileFieldsListener {
    private Smile smile;
    ArrayList<Entry> yVals1;
    private View qualityView;
    PieChart chart;

    public static QualityFragment newInstance(Smile smile) {
        Bundle args = new Bundle();
        QualityFragment fragment = new QualityFragment();
        fragment.smile = smile;
        fragment.setArguments(args);
        return fragment;
    }

    public void setValues() {
        yVals1 = new ArrayList<>();
        yVals1.add(new Entry(smile.getCountPositive(), 0));
        yVals1.add(new Entry(smile.getCountNeutral(), 1));
        yVals1.add(new Entry(smile.getCountNegative(), 2));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        qualityView = inflater.inflate(R.layout.page, container, false);
        chart = (PieChart) qualityView.findViewById(R.id.chart);
        drawQuality();
        return qualityView;
    }

    public void drawQuality() {
        setValues();
        chart.setDescription("");
        chart.setHoleColor(getResources().getColor(R.color.backPieChart));
        chart.setCenterText("Результаты");
        chart.setHoleRadius(25);
        chart.setTransparentCircleRadius(35);
        chart.setTransparentCircleAlpha(150);
        setData();
    }

    private void setData() {
        String[] mParties = new String[] {
                "Положительные отзывы", "Нейтральные отзывы", "Отрицательные отзывы"
        };

        ArrayList<String> xVals = new ArrayList<>();

        for (int i = 0; i < 3; i++)
            xVals.add(mParties[i]);

        PieDataSet dataSet = new PieDataSet(yVals1, "");

        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(getResources().getColor(R.color.yellow));
        colors.add(getResources().getColor(R.color.green));
        colors.add(getResources().getColor(R.color.red));
        dataSet.setColors(colors);

        PieData data = new PieData(xVals, dataSet);
        data.setValueTextColor(Color.BLACK);
        chart.setData(data);

        chart.invalidate();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void changeSmileFields() {
        drawQuality();
    }
}