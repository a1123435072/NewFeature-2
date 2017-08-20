package com.itheima.test_md_shadow;

import android.app.Activity;
import android.graphics.Outline;
import android.os.Bundle;
import android.view.View;
import android.view.ViewOutlineProvider;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View tvs = findViewById(R.id.tvs);
        ViewOutlineProvider outlineProvider = new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                //提供阴影(圆形)
                outline.setOval(0,0,view.getWidth(),view.getHeight());
            }
        };
        tvs.setOutlineProvider(outlineProvider);

        View cut = findViewById(R.id.cut);
        cut.setOutlineProvider(outlineProvider);
        cut.setClipToOutline(true);//根据阴影进行剪裁
    }
}
