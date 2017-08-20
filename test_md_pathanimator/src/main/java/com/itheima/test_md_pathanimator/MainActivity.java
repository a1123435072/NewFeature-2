package com.itheima.test_md_pathanimator;

import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void show(View view){
        //构建Path
        Path path = new Path();
        path.moveTo(100,100);
        path.lineTo(200,100);
        path.lineTo(200,200);
        path.lineTo(300,300);
        path.lineTo(800,800);
        path.lineTo(800,1000);
        path.lineTo(500,500);
        path.lineTo(50,50);
        //通过Path构建Animator
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(view, View.X, View.Y, path);
        objectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimator.setDuration(3000);
        //启动
        objectAnimator.start();
    }
}
