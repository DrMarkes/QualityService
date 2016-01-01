package ru.drmarkes.qualityservice;

/**
 * Created by Андрей on 26.12.2015.
 */
public class Smile {
    private int countPositive;
    private int countNeutral;
    private int countNegative;

    public Smile() {
        countNeutral = 15;
        countNegative = 20;
        countPositive = 30;
    }

    public void increaseCountPositive() {
        countPositive++;
    }

    public void increaseCountNeutral() {
        countNeutral++;
    }

    public void increaseCountNegative() {
        countNegative++;
    }

    public int getCountPositive() {
        return countPositive;
    }

    public int getCountNeutral() {
        return countNeutral;
    }

    public int getCountNegative() {
        return countNegative;
    }

    public String getQuality() {
        return "Позитивно: " + getCountPositive() +
                "; Нейтрально: " + getCountNeutral() +
                "; Негативно: " + getCountNegative();
    }
}