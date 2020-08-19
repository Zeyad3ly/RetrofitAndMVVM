package com.example.retrofitandmvvm.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitandmvvm.R;
import com.example.retrofitandmvvm.pojo.PostModel;

import java.awt.font.TextAttribute;
import java.util.ArrayList;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostViewHolder> {
    private ArrayList<PostModel> postList = new ArrayList<>();

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        holder.titleTv.setText(postList.get(position).getTitle());
        holder.userTv.setText(postList.get(position).getUserId()+"");
        holder.BodyTv.setText(postList.get(position).getBody());

    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public void SetList(ArrayList<PostModel> postList) {
        this.postList = postList;
        notifyDataSetChanged();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {
        TextView titleTv, userTv, BodyTv;
        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTv = itemView.findViewById(R.id.titleTv);
            userTv = itemView.findViewById(R.id.userId);
            BodyTv = itemView.findViewById(R.id.bodyTv);

        }
    }
}
