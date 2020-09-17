package com.example.retrofitapp;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import org.jsoup.nodes.Document;
import org.jsoup.Jsoup;

import org.jsoup.select.Elements;
import org.w3c.dom.Element;

import java.util.List;


public class setNewActivity extends RecyclerView.Adapter<setNewActivity.setViewHolder>{
    private Context context;
    private List<Item> item;
    public setNewActivity(List<Item> item, Context context){
        this.context=context;
        this.item=item;
    }
    @NonNull
    @Override
    public setViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.post_item,parent,false);
        return new setViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull setViewHolder holder, int position) {
        Item item1= item.get(position);
        holder.textView.setText(item1.getTitle());

        Document document=Jsoup.parse(item1.getContent());
        holder.textView1.setText(document.text());

        Elements element=document.select("img");
        Log.d("Code","Image -"+element.get(0).attr("src"));
        Glide.with(context).load(element.get(0).attr("src")).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    public class setViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        TextView textView1;

        public setViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=(ImageView) itemView.findViewById(R.id.image);
            textView=(TextView) itemView.findViewById(R.id.tv);
            textView1=(TextView) itemView.findViewById(R.id.tv1);
        }
    }

}
