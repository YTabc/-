package com.example.fruit_store;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Fruitsearch extends AppCompatActivity {

    // 定义对象
    List<Fruit> fruitList = new ArrayList<>();
    private SearchView searchView;
    private ListView listView;

    //定义自动完成的列表
    private final String[] mStrings = {"陕西红富士", "大理石榴", "巨峰葡萄", "新鲜大青芒", "早春红玉西瓜", "台湾茂谷柑", "台湾菠萝"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        listView = (ListView) findViewById(R.id.listView);
        final ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mStrings);
        listView.setAdapter(adapter);
        //为ListView启动过滤
        listView.setTextFilterEnabled(true);
        searchView = (SearchView) findViewById(R.id.searchView);
        //设置SearchView自动缩小为图标
        searchView.setIconifiedByDefault(false);//设为true则搜索栏 缩小成俄日一个图标点击展开
        //设置该SearchView显示搜索按钮
        searchView.setSubmitButtonEnabled(true);
        //设置默认提示文字
        searchView.setQueryHint("输入您想查找的内容");
        //配置监听器
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            //点击搜索按钮时触发
            @Override
            public boolean onQueryTextSubmit(String query) {
                //此处添加查询开始后的具体时间和方法
                int position=-1;
                for (int i=0;i<MainActivity.fruitList.size();i++){
                    if (MainActivity.fruitList.get(i).name.equals(query)){
                        position=i;
                        break;
                    }
                }
                if (position==-1){
                    Toast.makeText(Fruitsearch.this, "输入错误", Toast.LENGTH_SHORT).show();
                    return false;
                }
                //监听查询内容，跳转至对应商品详情页
                Intent intent = new Intent(Fruitsearch.this,DetailActivity.class);
                intent.putExtra("myposition", (Serializable) MainActivity.fruitList.get(position));
                Toast.makeText(Fruitsearch.this, "you choose:" + query, Toast.LENGTH_SHORT).show();
                startActivity(intent);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //如果newText长度不为0
                if (TextUtils.isEmpty(newText)) {
                    listView.clearTextFilter();
                } else {
                    adapter.getFilter().filter(newText.toString());
                }
                return true;
            }
        });
        listView.setOnItemClickListener(new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Object string = adapter.getItem(position);
                searchView.setQuery(string.toString(), true);
            }
        });
    }
}