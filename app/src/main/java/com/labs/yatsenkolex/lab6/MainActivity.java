package com.labs.yatsenkolex.lab6;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new DrawView(this));
    }

    class DrawView extends View {

        Paint paint;
        Path path;

        public DrawView(Context context) {
            super(context);
            paint = new Paint();
            paint.setColor(Color.GRAY);
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
            path = new Path();
        }
        @Override
        protected void onDraw(Canvas canvas) {

            float mid = getWidth() / 2;
            float min = Math.min(getWidth()/2, getHeight());
            float half = min/2;
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
            // star
            mid = mid - half;
            path.reset();
            paint.setColor(Color.rgb(00,00,00));
            // top left
            path.moveTo(mid + half * 0.5f, half * 0.84f + 500f);
            // top right
            path.lineTo(mid + half * 1.5f, half * 0.84f + 500f);
            // bottom left
            path.lineTo(mid + half * 0.68f, half * 1.45f + 500f);
            // top tip
            path.lineTo(mid + half * 1.0f, half * 0.5f + 500f);
            // bottom right
            path.lineTo(mid + half * 1.32f, half * 1.45f + 500f);
            // top left
            path.lineTo(mid + half * 0.5f, half * 0.84f + 500f);
            canvas.drawPath(path, paint);
            path.close();
            super.onDraw(canvas);
        }
    }

}
