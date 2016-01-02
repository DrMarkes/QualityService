package ru.drmarkes.qualityservice;

/**
 * Created by Андрей on 26.12.2015.
 */
public class Smile {
    private int countPositive;
    private int countNeutral;
    private int countNegative;

    public Smile() {
        countNeutral = 1;
        countNegative = 1;
        countPositive = 1;
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