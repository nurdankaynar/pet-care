package com.android.petcare.articles;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.android.petcare.R;
import com.android.petcare.database.entities.articles.Articles;
import com.bumptech.glide.Glide;

import java.util.List;

public class ArticlesAdapter extends RecyclerView.Adapter<ArticlesAdapter.ViewHolder> {
    private List<Articles> listdata;
    private ArticleItemListener listener;

    public ArticlesAdapter(List<Articles> listdata, ArticleItemListener listener) {
        this.listdata = listdata;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.item_article, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Articles myListData = listdata.get(position);
        holder.title.setText(myListData.getTitle());
        holder.shortDesc.setText(myListData.getShortDesc());
        Glide.with(holder.itemView.getContext()).load(myListData.getImage()).into(holder.image);
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(myListData.getFie_id());
            }
        });
    }


    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public TextView title;
        public TextView shortDesc;

        public ViewHolder(View itemView) {
            super(itemView);
            this.title = (TextView) itemView.findViewById(R.id.txtTitle);
            this.shortDesc = (TextView) itemView.findViewById(R.id.txtShortDesc);
            this.image = (ImageView) itemView.findViewById(R.id.ivImage);
        }
    }

    interface ArticleItemListener {
        void onItemClick(int articleId);
    }
}