package com.itheima.test_recyclerview;

import android.graphics.Color;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;
import static com.itheima.test_recyclerview.R.layout.item;

public class MainActivity extends AppCompatActivity {

    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv = (RecyclerView) findViewById(R.id.rv);
        //RecyclerView相关联的类：布局管理器(XXXLayoutManger 设置RecyclerView的显示风格：列表、网格瀑布流)、适配器（Adapter）、ViewHolder
        //1 设置布局管理器
        //LinearLayoutManager 线性布局管理器 方向：默认是垂直方向
        LinearLayoutManager lm = new LinearLayoutManager(this);
        lm.setOrientation(LinearLayoutManager.VERTICAL);

        //网格
//        GridLayoutManager lm = new GridLayoutManager(this,2);
//        lm.setOrientation(GridLayoutManager.HORIZONTAL);
        rv.setLayoutManager(lm);

        //2 设置适配器
        rv.setAdapter(new MyAdapter());

        //下拉刷新
        final SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        //设置背景
        swipeRefreshLayout.setProgressBackgroundColorSchemeColor(Color.GRAY);
        //设置进度条的颜色
        swipeRefreshLayout.setColorSchemeColors(Color.RED,Color.BLUE,Color.YELLOW);
        //设置下拉刷新的监听
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //加载数据（网络\数据库）耗时
                Toast.makeText(MainActivity.this, "正在努力的加载数据", Toast.LENGTH_SHORT).show();
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //隐藏SwipeRefreshLayout
                        swipeRefreshLayout.setRefreshing(false);
                    }
                },3000);
            }
        });
    }

    private class MyAdapter extends RecyclerView.Adapter{

        //创建ViewHolder
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getApplicationContext()).inflate(item,parent,false);
            return new MyViewHolder(view);
        }

        //对ViewHolder里面的控件进行赋值
        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            MyViewHolder viewHolder = (MyViewHolder) holder;
            viewHolder.setData(position);
        }

        //条目的数量
        @Override
        public int getItemCount() {
            return 60;
        }
    }

    private class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.tv);
        }

        public void setData(final int position) {
            tv.setText("第"+position+"条目的位置");

            //设置条目点击事件
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "点击了"+position, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
