package ru.drmarkes.qualityservice;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

/**
 * Created by Андрей on 29.12.2015.
 */
public class QualityFragment extends Fragment implements MainActivity.onChahgedSmileFieldsListener {
    private Smile smile;
    private ArrayList<Float> values = new ArrayList<>(3);
    private View qualityView;
    PieChart chart;

    public static QualityFragment newInstance(Smile smile) {
        Bundle args = new Bundle();
        QualityFragment fragment = new QualityFragment();
        fragment.smile = smile;
        fragment.setArguments(args);
        return fragment;
    }

    public ArrayList<Float> getValues() {
        values.add(0, (float) smile.getCountPositive());
        values.add(1, (float) smile.getCountNeutral());
        values.add(2, (float) smile.getCountNegative());
        return  values;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        qualityView = inflater.inflate(R.layout.page, container, false);
        chart = (PieChart) qualityView.findViewById(R.id.chart);
        drawQuality();
        return qualityView;
    }

    public void drawQuality() {
        getValues();

        chart.setDescription("");
        chart.setDragDecelerationFrictionCoef(0.95f);
        setData(3);
    }

    private void setData(int count) {

        String[] mParties = new String[] {
                "Положительные отзыв", "Нейтральные отзывы", "Отрицательные отзывы"
        };

        ArrayList<Entry> yVals1 = new ArrayList<>();

        // IMPORTANT: In a PieChart, no values (Entry) should have the same
        // xIndex (even if from different DataSets), since no values can be
        // drawn above each other.
        for (int i = 0; i < count; i++) {
            yVals1.add(new Entry(values.get(i), i));
        }

        ArrayList<String> xVals = new ArrayList<>();

        for (int i = 0; i < count; i++)
            xVals.add("");

        PieDataSet dataSet = new PieDataSet(yVals1, "Результаты опроса");
    //    dataSet.setSliceSpace(2f);
    //    dataSet.setSelectionShift(5f);

        // add a lot of colors

        ArrayList<Integer> colors = new ArrayList<>();

        colors.add(Color.YELLOW);

        colors.add(Color.GREEN);

        colors.add(Color.RED);

        dataSet.setColors(colors);
    //    dataSet.setSelectionShift(0f);

        PieData data = new PieData(xVals, dataSet);
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(11f);
        data.setValueTextColor(Color.WHITE);
        chart.setData(data);

     //   chart.highlightValues(null);

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
