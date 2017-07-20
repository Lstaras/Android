package com.example.kuandemo;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

/**
 * 项目名称:KuanDemo
 * 创建人:Lstaras
 * 创建时间: ${DATA} 21:30
 */

public class IconAdapter extends RecyclerView.Adapter<IconAdapter.ViewHolder> {

    private List<Icon> mIconList;

    public IconAdapter(List<Icon> iconList){
        mIconList = iconList;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        View iconView;

        ImageView iconImage;
        TextView iconName;

        public ViewHolder(View itemView) {//此itemview为当前recyclerview子项的最外层布局
            super(itemView);

            iconView = itemView;

            iconImage = (ImageView) itemView.findViewById(R.id.icon_image);
            iconName = (TextView) itemView.findViewById(R.id.icon_name);
        }
    }

    @Override
    public IconAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {//要记住这段代码
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.icon_item,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        //定义view的点击监听器
        holder.iconView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Icon icon = mIconList.get(position);
                Toast.makeText(v.getContext(), "It's "+icon.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(IconAdapter.ViewHolder holder, int position) {
        Icon icon = mIconList.get(position);
        holder.iconImage.setImageResource(icon.getImageId());
        holder.iconName.setText(icon.getName());
    }

    @Override
    public int getItemCount() {
        return mIconList.size();
    }
}
