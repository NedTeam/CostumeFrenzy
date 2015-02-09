package com.neddevteam.costumefrenzy.test;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

import com.neddevteam.costumefrenzy.button.ButtonManager;
import com.neddevteam.costumefrenzy.layer.RenderingLayer;
import com.neddevteam.costumefrenzy.render.RenderingView;
import com.neddevteam.costumefrenzy.utils.BitmapUtils;

import costumefrenzy.nedteam.com.costumefrenzy.R;

/**
 * Created by mcat on 7/02/15.
 */
public class testActivity extends Activity {
    private RenderingView view;

    public testActivity(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        final Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.circle);
        final Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.square);
        final Bitmap bitmap3 = BitmapFactory.decodeResource(getResources(), R.drawable.test);
        final Bitmap bitmap4 = bitmap1.copy(bitmap1.getConfig(),true);
        view = new RenderingView(getBaseContext());
        view.addLayer(new RenderingLayer(bitmap2,-1));
        view.addLayer(new RenderingLayer(bitmap4,1));
        view.addLayer(new RenderingLayer(bitmap3, 0));
        setContentView(view);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                    BitmapUtils.setColorToAll(bitmap4, 0xff000000);
                } catch (InterruptedException e) {}
                view.postInvalidate();
            }
        }).start();
    }

    @Override
    public boolean onTouchEvent(MotionEvent e){
        int action = e.getAction();
        switch(action) {
            case MotionEvent.ACTION_DOWN:
                return onDown(e);
            case MotionEvent.ACTION_UP:
                return onUp(e);
            default:
                return false;
        }
    }


    public boolean onDown(MotionEvent e) {
        Log.i("DOWN", Float.toString(e.getRawX()) + Float.toString(e.getRawY()));
        ButtonManager.checkClick(view, (int)e.getRawX(), (int)e.getRawY());
        return false;
    }


    public boolean onUp(MotionEvent e) {
        Log.i("UP", Float.toString(e.getRawX()) + Float.toString(e.getRawY()));
        ButtonManager.checkClick(view, (int)e.getRawX(), (int)e.getRawY());
        return true;
    }
}
