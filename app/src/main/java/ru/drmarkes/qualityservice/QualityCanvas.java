package ru.drmarkes.qualityservice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

/**
 * Created by Андрей on 30.12.2015.
 */
public class QualityCanvas extends View {
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final int SECTOR_BEGIN = -90;
    private float[] value_degree;
    int temp;
    private int[] COLORS = {Color.GREEN, Color.RED, Color.YELLOW};
    RectF rectf = new RectF(200, 200, 600, 600);

    public QualityCanvas(Context context, float[] values) {
        super(context);
        value_degree = new float[values.length];
        for (int i = 0; i < values.length; i++) {
            value_degree[i] = values[i];
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < value_degree.length; i++) {//values2.length; i++) {
            if (i == 0) {
                temp = SECTOR_BEGIN;
                paint.setColor(COLORS[i]);
                canvas.drawArc(rectf, temp, value_degree[i], true, paint);
            } else {
                temp += (int) value_degree[i - 1];
                paint.setColor(COLORS[i]);
                canvas.drawArc(rectf, temp, value_degree[i], true, paint);
            }
        }
    }
}
