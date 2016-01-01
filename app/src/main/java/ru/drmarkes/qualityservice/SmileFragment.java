package ru.drmarkes.qualityservice;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

/**
 * Created by Андрей on 29.12.2015.
 */
public class SmileFragment extends Fragment implements View.OnClickListener {
    onSmileClickListener smileClickListener;

    public interface onSmileClickListener {
        void smileClick(int smileClick);
    }

    public static SmileFragment newInstance() {
        Bundle args = new Bundle();
        SmileFragment fragment = new SmileFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        smileClickListener = (onSmileClickListener) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View smileView = inflater.inflate(R.layout.smile_page, container, false);
        initButtons(smileView);
        return smileView;
    }

    private void initButtons(View smileView) {
        ImageButton buttonPositive = (ImageButton)smileView.findViewById(R.id.positive);
        buttonPositive.setOnClickListener(this);

        ImageButton buttonNeutral = (ImageButton)smileView.findViewById(R.id.neutral);
        buttonNeutral.setOnClickListener(this);

        ImageButton buttonNegative = (ImageButton)smileView.findViewById(R.id.negative);
        buttonNegative.setOnClickListener(this);
    }

    public void onClick(View v) {
        smileClickListener.smileClick(v.getId());
    }
}
