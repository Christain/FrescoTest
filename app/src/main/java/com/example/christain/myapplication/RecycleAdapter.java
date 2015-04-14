package com.example.christain.myapplication;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;

/**
 * Created by Christain on 15/4/14.
 */
public class RecycleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<JavaBean> list;

    public RecycleAdapter(Context context, ArrayList<JavaBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
        View convertView = null;
        RecyclerView.ViewHolder holder = null;
        switch (getItemViewType(position)) {
            case 0:
                convertView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recycle_view_one, viewGroup, false);
                holder = new TextHolder(convertView);
                break;
            case 1:
                convertView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recycle_view_two, viewGroup, false);
                holder = new ImageHolder(convertView);
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        JavaBean model = list.get(position);
        switch (getItemViewType(position)) {
            case 0:
                TextHolder textHolder = (TextHolder) viewHolder;
                textHolder.text.setText(model.getText());
                break;
            case 1:
                ImageHolder imageHolder = (ImageHolder) viewHolder;
                imageHolder.image.setImageURI(Uri.parse("http://h.hiphotos.baidu.com/image/pic/item/503d269759ee3d6da2e9897741166d224f4ade5b.jpg"));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        return list.get(position).getType();
    }

    public static class TextHolder extends RecyclerView.ViewHolder {

        public TextView text;

        public TextHolder(View itemView) {
            super(itemView);
            this.text = (TextView) itemView.findViewById(R.id.text);
        }
    }

    public static class ImageHolder extends RecyclerView.ViewHolder {

        public SimpleDraweeView image;

        public ImageHolder(View itemView) {
            super(itemView);
            this.image = (SimpleDraweeView) itemView.findViewById(R.id.image);
        }
    }
}
