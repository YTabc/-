package com.example.fruit_store;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Activity_surebuy extends AppCompatActivity {

    List<String> fruitName = new ArrayList<>();
    List<String> fruitPrice = new ArrayList<>();
    Spinner spinner_name;
    TextView TextViewPrice;


    public void surebuy(View view) {
        EditText amount = findViewById(R.id.et_amount);
       String stram = amount.getText().toString();

       if (stram.equals("")){
           Toast.makeText(this, "数量不能为空", Toast.LENGTH_SHORT).show();
        return;
       }

        Spinner name = findViewById(R.id.sp_name);
        String strnm = name.getSelectedItem().toString();
        String pri = TextViewPrice.getText().toString();


        Intent intent = new Intent(Activity_surebuy.this, Activity_detailbuy.class);
        Bundle bundle = new Bundle();

        bundle.putString("name", strnm);
        bundle.putString("amount", stram);
        bundle.putString("pri",pri+"");


        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surebuy);
        spinner_name = findViewById(R.id.sp_name);
        TextViewPrice = findViewById(R.id.price);
        initSpinner();
        Log.i("name", "onCreate: "+fruitName);
        ArrayAdapter<String> fruitNameAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, fruitName);
        spinner_name.setAdapter(fruitNameAdapter);
       spinner_name.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               String p = fruitPrice.get(position).substring(1).split("元")[0];
               Log.i("price", "onItemSelected: "+p);
               TextViewPrice.setText(p);
           }

           @Override
           public void onNothingSelected(AdapterView<?> parent) {

           }
       });
    }
    public void initSpinner(){
        for (Fruit fruit : MainActivity.fruitList) {
            fruitName.add(fruit.name);
            fruitPrice.add(fruit.price);
        }
        Log.i("name", "initSpinner: "+fruitName);
    }
}
