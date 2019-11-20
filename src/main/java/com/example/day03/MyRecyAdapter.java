package com.example.day03;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MyRecyAdapter extends RecyclerView.Adapter<MyRecyAdapter.Viewholder> {

    Context context;
    List<FuLibean.ResultsBean> resultsBeanse;

    public MyRecyAdapter(Context context, List<FuLibean.ResultsBean> resultsBeanse) {
        this.context = context;
        this.resultsBeanse = resultsBeanse;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.shu_item, viewGroup, false);
        return new Viewholder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder viewholder, final int i) {
        FuLibean.ResultsBean resultsBean = resultsBeanse.get(i);
        Glide.with(context).load(resultsBean.getUrl()).into(((Viewholder)viewholder).imageView);
        ((Viewholder)viewholder).itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onClickListener!=null)
                {
                    onClickListener.onclicklistener(i);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return resultsBeanse.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.img);

        }
    }
    OnClickListener onClickListener;

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    interface OnClickListener{
        void onclicklistener(int i);
    }
}
