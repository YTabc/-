package com.example.fruit_store;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.List;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {
    List<Fruit> myFruitlist;

    public FruitAdapter(List<Fruit> fruitlist) {
        myFruitlist = fruitlist;
    }

    // ViewHolder实例
    @NonNull
    @Override
    public FruitAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.fruitView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();


                Intent intent = new Intent(v.getContext(), DetailActivity.class);
                intent.putExtra("myposition", (Serializable) myFruitlist.get(position));


                v.getContext().startActivity(intent);
            }
        });
        return holder;
    }

    // 用于Recyclerview中子项的数据进行赋值
    @Override
    public void onBindViewHolder(@NonNull FruitAdapter.ViewHolder holder, int position) {
        Fruit fruit = myFruitlist.get(position);
        holder.fruitImage.setImageResource(fruit.getImageid());
        holder.fruitName.setText(fruit.getName());
        holder.fruitIntro.setText(fruit.getIntro());
        holder.fruitPrice.setText(fruit.getPrice());
    }

    // 返回Recyclerview中的行数
    @Override
    public int getItemCount() {
        return myFruitlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        View fruitView;
        ImageView fruitImage;
        TextView fruitName, fruitIntro, fruitPrice;

        public ViewHolder(@NonNull View view) {
            super(view);
            fruitView = view;
            fruitImage = view.findViewById(R.id.imageview_img);
            fruitName = view.findViewById(R.id.textview_name);
            fruitIntro = view.findViewById(R.id.textview_intro);
            fruitPrice = view.findViewById(R.id.textview_price);
        }
    }
}
