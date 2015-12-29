package ru.drmarkes.qualityservice;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * Created by Андрей on 29.12.2015.
 */
public class SmileFragment extends Fragment implements View.OnClickListener {
    Smile smile;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        smile = new Smile();
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
        Toast toast;
        switch (v.getId()) {
            case R.id.positive:
                toast = Toast.makeText(getActivity(), "Спасибо за ваш положительный отзыв, " +
                                "мы всегда рады Вас видеть!",
                        Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                smile.increaseCountPositive();
                break;
            case R.id.neutral:
                toast = Toast.makeText(getActivity(), "Спасибо за ваш нейтральный отзыв, " +
                                "мы постоянно улучшаем качество обслуживания!",
                        Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                smile.increaseCountNeutral();
                break;
            case R.id.negative:
                toast = Toast.makeText(getActivity(), "Спасибо за ваш отрицательный отзыв, " +
                                "мы учтем Ваши пожелания!",
                        Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                smile.increaseCountNegative();
                break;
        }
        toast = Toast.makeText(getActivity(), smile.getQuality(), Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP, 0, 0);
        toast.show();
    }
}
