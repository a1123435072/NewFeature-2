package com.itheima.test_md_palette;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public View v;
    private View vd;
    private View vl;
    private View m;
    private View md;
    private View ml;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        v = findViewById(R.id.v);
        vd = findViewById(R.id.vd);
        vl = findViewById(R.id.vl);
        m = findViewById(R.id.m);
        md = findViewById(R.id.md);
        ml = findViewById(R.id.ml);
    }

    public void get(View view){
        //准备Bitmap
        Drawable drawable = getResources().getDrawable(R.drawable.a);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
        Bitmap bitmap = bitmapDrawable.getBitmap();

        //通过Palette异步的提取颜色
        Palette.generateAsync(bitmap, new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                v.setBackgroundColor(palette.getVibrantColor(Color.BLACK));
                vd.setBackgroundColor(palette.getDarkVibrantColor(Color.BLACK));
                vl.setBackgroundColor(palette.getLightVibrantColor(Color.BLACK));
                m.setBackgroundColor(palette.getMutedColor(Color.BLACK));
                md.setBackgroundColor(palette.getDarkMutedColor(Color.BLACK));
                ml.setBackgroundColor(palette.getLightMutedColor(Color.BLACK));
            }
        });
    }
}
