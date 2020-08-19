package com.example.retrofitandmvvm.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.retrofitandmvvm.R;
import com.example.retrofitandmvvm.pojo.PostModel;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    PostViewModel postViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        postViewModel = ViewModelProviders
                .of(this)
                .get(PostViewModel.class);
        postViewModel.getPosts();
        RecyclerView recyclerView= findViewById(R.id.recycler);
        final PostsAdapter adapter = new PostsAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


       postViewModel.postsMutableLiveData.observe(this, new Observer<List<PostModel>>() {
           @Override
           public void onChanged(List<PostModel> postModels) {
               adapter.SetList((ArrayList<PostModel>) postModels);
           }
       });
    }
}