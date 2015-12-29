package ru.drmarkes.qualityservice;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/**
 * Created by Андрей on 29.12.2015.
 */
public class QualityFragment extends Fragment {
    private int num;
    private float[] values = {
            300,
            400,
            100
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View qualityView = inflater.inflate(R.layout.page, container, false);
        FrameLayout frameLayout = (FrameLayout)qualityView.findViewById(R.id.frameLayout);
        values = calculateData(values);
        frameLayout.addView(new QualityCanvas(getActivity(), values));
        return qualityView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private float[] calculateData(float[] data) {
        // TODO Auto-generated method stub
        float total=0;
        for(int i=0;i<data.length;i++)
        {
            total+=data[i];
        }
        for(int i=0;i<data.length;i++)
        {
            data[i]=360*(data[i]/total);
        }
        return data;
    }
}
