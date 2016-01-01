package ru.drmarkes.qualityservice;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.widget.Toast;

public class MainActivity extends FragmentActivity implements SmileFragment.onSmileClickListener {
    protected Smile smile;
    protected FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        smile = new Smile();
        ViewPager pager = (ViewPager) findViewById(R.id.pageContainer);
        fragmentManager = getSupportFragmentManager();
        pager.setAdapter(new SmileAdapter(fragmentManager, smile));
    }

    @Override
    public void smileClick(int smileClick) {
        Toast toast;
        switch (smileClick) {
            case R.id.positive:
                toast = Toast.makeText(this, "Спасибо за ваш положительный отзыв, " +
                                "мы всегда рады Вас видеть!",
                        Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                smile.increaseCountPositive();
                break;
            case R.id.neutral:
                toast = Toast.makeText(this, "Спасибо за ваш нейтральный отзыв, " +
                                "мы постоянно улучшаем качество обслуживания!",
                        Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                smile.increaseCountNeutral();
                break;
            case R.id.negative:
                toast = Toast.makeText(this, "Спасибо за ваш отрицательный отзыв, " +
                                "мы учтем Ваши пожелания!",
                        Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                smile.increaseCountNegative();
                break;
        }
        toast = Toast.makeText(this, smile.getQuality(), Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP, 0, 0);
        toast.show();
    }
}