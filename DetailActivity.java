package com.example.fruit_store;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    // 定义对象
    private ImageView imageView;
    private TextView name, price, intro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        // 绑定控件
        initView();
        // 接受Intent跳转传递的数据
        Intent intent = getIntent();
        Fruit fruit = (Fruit) getIntent().getSerializableExtra("myposition");
        // 将序列化保存的水果信息显示在控件中
        imageView.setImageResource(fruit.getImageid());
        name.setText( fruit.getName());
        price.setText(fruit.getPrice());
        intro.setText("详情：" + fruit.getIntro());
    }

    private void initView() {
        imageView = findViewById(R.id.imageview_de_img);
        name = findViewById(R.id.textview_de_name);
        price = findViewById(R.id.textview_de_price);
        intro = findViewById(R.id.textview_de_intro);
    }

    public void ontosurebuyClick(View view) {
        // 跳转到购买确认页
        Intent intent = new Intent(DetailActivity.this, Activity_surebuy.class);
        startActivity(intent);
    }
}