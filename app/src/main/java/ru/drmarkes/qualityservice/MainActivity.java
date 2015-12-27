package ru.drmarkes.qualityservice;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends FragmentActivity implements View.OnClickListener{
    Smile smile = new Smile();
    private static String[] TEXTS = new String[] {
            "First",
            "Second",
            "Third",
            "Fourth"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page);
        //initButtons();
        ViewPager pager = (ViewPager)findViewById(R.id.pageContainer);
        FragmentManager fm = getSupportFragmentManager();

        pager.setAdapter(new SmilePagerAdapter(fm, TEXTS));
    }

    /**
     * Method creates a button and registers the listener clicks
     */
    private void initButtons() {
        ImageButton buttonPositive = (ImageButton)findViewById(R.id.positive);
        buttonPositive.setOnClickListener(this);

        ImageButton buttonNeutral = (ImageButton)findViewById(R.id.neutral);
        buttonNeutral.setOnClickListener(this);

        ImageButton buttonNegative = (ImageButton)findViewById(R.id.negative);
        buttonNegative.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Toast toast;
        switch (v.getId()) {
            case R.id.positive:
                toast = Toast.makeText(getApplicationContext(), "Спасибо за ваш положительный отзыв, " +
                                "мы всегда рады Вас видеть!",
                        Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                smile.increaseCountPositive();
                break;
            case R.id.neutral:
                toast = Toast.makeText(getApplicationContext(), "Спасибо за ваш нейтральный отзыв, " +
                                "мы постоянно улучшаем качество обслуживания!",
                        Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                smile.increaseCountNeutral();
                break;
            case R.id.negative:
                toast = Toast.makeText(getApplicationContext(), "Спасибо за ваш отрицательный отзыв, " +
                                "мы учтем Ваши пожелания!",
                        Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                smile.increaseCountNegative();
                break;
        }
        toast = Toast.makeText(getApplicationContext(), smile.getQuality(), Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP, 0, 0);
        toast.show();
    }
}
