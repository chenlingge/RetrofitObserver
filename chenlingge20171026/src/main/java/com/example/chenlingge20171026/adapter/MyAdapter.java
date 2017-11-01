package com.example.chenlingge20171026.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.chenlingge20171026.R;
import com.example.chenlingge20171026.bean.Bean;
import com.nostra13.universalimageloader.core.DisplayImageOptions;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private Context context;
    private List<Bean.ApkBean> list = new ArrayList<>();
    private final DisplayImageOptions options;

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener{
        void onItemClick(View view, int position);
    }


    public MyAdapter(Context context, List<Bean.ApkBean> list) {
        this.context = context;
        this.list = list;
        options = new DisplayImageOptions.Builder().build();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new MyAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.tv.setText(list.get(position).getCategoryName());
        Glide.with(context).load(list.get(position).getIconUrl()).into(holder.iv);
        // ImageLoader.getInstance().displayImage(list.get(position).getIconUrl(),holder.iv,options);

        if(onItemClickListener!=null){
            ((ViewHolder) holder).ll.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(holder.itemView,position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private View view;
        private TextView tv;
        private ImageView iv;
        private LinearLayout ll;

        public ViewHolder(View view) {
            super(view);
            this.tv = (TextView) view.findViewById(R.id.tv);
            this.iv = (ImageView) view.findViewById(R.id.iv);
            this.ll = (LinearLayout) view.findViewById(R.id.ll);
        }
    }
}





