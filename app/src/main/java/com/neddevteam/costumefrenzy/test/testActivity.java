package com.neddevteam.costumefrenzy.test;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

import com.neddevteam.costumefrenzy.button.Button;
import com.neddevteam.costumefrenzy.button.ButtonManager;
import com.neddevteam.costumefrenzy.button.SquareButton;
import com.neddevteam.costumefrenzy.layer.ButtonLayer;
import com.neddevteam.costumefrenzy.layer.RenderingLayer;
import com.neddevteam.costumefrenzy.render.RenderingView;
import com.neddevteam.costumefrenzy.utils.BitmapUtils;
import com.neddevteam.costumefrenzy.utils.Point;

import costumefrenzy.nedteam.com.costumefrenzy.R;

/**
 * Created by mcat on 7/02/15.
 */
public class testActivity extends Activity implements
        GestureDetector.OnGestureListener{

    private RenderingView view;

    public testActivity(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        view = new RenderingView(getBaseContext());
        final Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.circle);
        final Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.square);
        final Bitmap bitmap3 = BitmapFactory.decodeResource(getResources(), R.drawable.test);
        final Bitmap bitmap4 = bitmap1.copy(bitmap1.getConfig(),true);
        final Button button1 = new SquareButton(new Point(0,0),new Point(100,100));
        final ButtonLayer buttonLayer = new ButtonLayer(10);
        buttonLayer.addButton(button1);
        view.addLayer(new RenderingLayer(bitmap2,-1));
        view.addLayer(new RenderingLayer(bitmap4,1));
        view.addLayer(new RenderingLayer(bitmap3, 0));
        view.addLayer(buttonLayer);
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
    public boolean onDown(MotionEvent e) {
        Log.i("NedCore","Test");
        ButtonManager.checkClick(view, (int)e.getX(), (int)e.getY());
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        ButtonManager.checkClick(view, (int)e.getX(), (int)e.getY());
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }
}