package com.example.fruit_store;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class Activity_detailbuy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailbuy);

        //取出传入数据
        Intent intent=this.getIntent();
        Bundle bundle=intent.getExtras();
        String str=bundle.getString("name");
        String str1=bundle.getString("pri");
        String str2=bundle.getString("amount");


        double x = Double.valueOf(str1);
        int y = Integer.valueOf(str2).intValue();
        double z=x*y;

        //显示
        String info="您购买了: "+str+"\n"+"单价: "+str1+"/kg"+"\n"+"数量: "+str2+"kg"+"\n"+"总计："+new DecimalFormat("#.00").format(z)+" 元";
        TextView tv=findViewById(R.id.tv_userInfo);
        tv.setText(info);

        //取出传入数据
        Intent intent1=this.getIntent();
        Bundle bundle1=intent1.getExtras();

        Toast.makeText(this, "购买成功", Toast.LENGTH_SHORT).show();

    }

    public void ontostartClick(View view) {
        // 跳转到首页
        Intent intent = new Intent(Activity_detailbuy.this, MainActivity.class);
        startActivity(intent);
    }
}
