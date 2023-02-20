package com.example.hardikgoyal_paintbrush;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowMetrics;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {
    ImageView imageView;
    Bitmap bitmap;
    Canvas canvas;
    Paint paint;
    float dx=0, dy=0, ux=0, uy=0;

    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);
        WindowMetrics windowMetrics = getWindowManager().getCurrentWindowMetrics();
        float w = windowMetrics.getBounds().width();
        float h = windowMetrics.getBounds().height();
        bitmap = Bitmap.createBitmap((int)w,(int)h,Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
        paint = new Paint();
        paint.setColor(Color.BLACK);
        imageView.setImageBitmap(bitmap);
        imageView.setOnTouchListener(this);

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        switch (action)
        {
            case MotionEvent.ACTION_DOWN:
                dx = motionEvent.getX();
                dy = motionEvent.getY();
                break;

            case MotionEvent.ACTION_MOVE:
                break;

            case MotionEvent.ACTION_UP:
                ux = motionEvent.getX();
                uy = motionEvent.getY();
                canvas.drawLine(dx,dy,ux,uy,paint);
                imageView.invalidate();
                break;

            case MotionEvent.ACTION_CANCEL:
                break;
        }
        return true;
    }
}