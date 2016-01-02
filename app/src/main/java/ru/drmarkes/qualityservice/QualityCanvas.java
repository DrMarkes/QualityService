package ru.drmarkes.qualityservice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by Андрей on 30.12.2015.
 */
public class QualityCanvas extends View {
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final int SECTOR_BEGIN = -90;
    private ArrayList<Float> value_degree;
    int temp;
    private int[] COLORS = {Color.GREEN, Color.RED, Color.YELLOW};
    RectF rectf = new RectF(30, 30, 200, 200);

    public QualityCanvas(Context context, ArrayList<Float> values) {
        super(context);
        value_degree = values;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < value_degree.size(); i++) {
        Log.d("MyLogs", Integer.toString(value_degree.size()));
            if (i == 0) {
                temp = SECTOR_BEGIN;
                paint.setColor(COLORS[i]);
                canvas.drawArc(rectf, temp, value_degree.get(i), true, paint);
            } else {
                temp += value_degree.get(i - 1);
                paint.setColor(COLORS[i]);
                canvas.drawArc(rectf, temp, value_degree.get(i), true, paint);
            }
        }
    }
}
