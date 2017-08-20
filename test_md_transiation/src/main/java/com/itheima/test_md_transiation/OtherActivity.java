package com.itheima.test_md_transiation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.view.Window;

public class OtherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置窗体的特点：有内容的动画
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        //设置窗体允许有进入和返回的动画
        getWindow().setAllowEnterTransitionOverlap(true);
        getWindow().setAllowReturnTransitionOverlap(true);
        //动画
        Explode explode = new Explode();
        explode.setDuration(1000);
        //设置窗体的动画
        getWindow().setEnterTransition(explode);
        getWindow().setExitTransition(explode);
        setContentView(R.layout.activity_other);
    }
}
