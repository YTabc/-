package com.example.fruit_store;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    // 定义对象
    RecyclerView recyclerView_show;
    public static List<Fruit>  fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 绑定控件
        initView();
        // 准备数据
        initFruits();
        // 设计每一行的子布局
        // 创建适配器
        FruitAdapter adapter = new FruitAdapter(fruitList);
        // 让数据显示在控件中
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView_show.setLayoutManager(layoutManager);
        recyclerView_show.setAdapter(adapter);

    }

    private void initFruits() {
        for (int i = 0; i < 3; i++) {
            Fruit apple = new Fruit("陕西红富士", "优质苹果 香甜爽口", R.drawable.apple, "¥20元 / kg");
            fruitList.add(apple);
            Fruit shiliu = new Fruit("大理石榴", "新鲜石榴 全新上市", R.drawable.pomegranate, "¥15元 / kg");
            fruitList.add(shiliu);
            Fruit chengzi = new Fruit("台湾茂谷柑", "浓甜无渣 瓣瓣多汁", R.drawable.orange, "¥49.9元 / kg");
            fruitList.add(chengzi);
            Fruit mangguo = new Fruit("新鲜大青芒", "精选大果 肥厚饱满", R.drawable.mangguo, "¥29.9元 / kg");
            fruitList.add(mangguo);
            Fruit putao = new Fruit("巨峰葡萄", "爆汁超甜 新鲜采摘", R.drawable.putao, "¥19.9元 / kg");
            fruitList.add(putao);
            Fruit boluo = new Fruit("台湾菠萝", "香甜可口 汁水浓厚", R.drawable.boluo, "¥38.9元 / kg");
            fruitList.add(boluo);
            Fruit xigua = new Fruit("早春红玉西瓜", "皮薄肉甜 物美价廉", R.drawable.xigua, "¥28.8元 / kg");
            fruitList.add(xigua);
        }
    }


    public void ontosearchClick(View view) {
        // 跳转到搜索页
        Intent intent = new Intent(MainActivity.this, Fruitsearch.class);
        startActivity(intent);
    }

    public void ontobuydetailClick(View view) {
        // 跳转到购买历史页
        Intent intent = new Intent(MainActivity.this, Activity_detailbuy.class);
        startActivity(intent);
    }

    private void initView() {

        recyclerView_show = findViewById(R.id.recyclerview_show);
    }

}
