package com.itheima.test_md_theme;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    public static int mTheme = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(mTheme != -1){
            setTheme(mTheme);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //搜索module里面的信息 ctrl + shift + f
    public void change(View view){
        //更换主题（1 设置主题  2 重新加载 3 使用主题）
        MainActivity.mTheme = R.style.itheima;

        //清除界面跳转动画
        overridePendingTransition(0,0);
        finish();
        //重写启动
        Intent intent = new Intent(this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        overridePendingTransition(0,0);
        startActivity(intent);
    }

}
