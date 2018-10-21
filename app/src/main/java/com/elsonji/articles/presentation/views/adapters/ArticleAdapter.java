package com.elsonji.articles.presentation.views.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.elsonji.articles.R;
import com.elsonji.articles.domain.models.Article;
import com.elsonji.articles.domain.models.ArticleList;
import com.elsonji.articles.presentation.di.ArticleApplication;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder> {
    private Context mContext;
    @Inject
    ArrayList<Article> mArticleList;

    @Inject
    public ArticleAdapter(Context context) {
        mContext = context;
        ArticleApplication.getComponent().inject(this);
    }
    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        CardView itemView = (CardView)LayoutInflater.from(mContext)
                .inflate(R.layout.article_item, viewGroup, false);


        return new ArticleViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
        Picasso.get().load(mArticleList.get(position).getImageUrl()).into(holder.imageView);
        holder.titleTextView.setText(mArticleList.get(position).getTitle());
        holder.descriptionTextView.setText(mArticleList.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        if (mArticleList != null) {
            return mArticleList.size();
        } else {
            return 0;
        }
    }

    public class ArticleViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.article_image_view)
        ImageView imageView;
        @BindView(R.id.article_title_text_view)
        TextView titleTextView;
        @BindView(R.id.article_description_text_view)
        TextView descriptionTextView;

        public ArticleViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public void setItems(ArticleList articles) {
        mArticleList.clear();
        mArticleList.addAll(articles.getArticles());
        notifyDataSetChanged();
    }
}
