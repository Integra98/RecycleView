package com.example.mytweet;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    private RecyclerView recyclerView;
    private List<Tweet> tweets;
    private MyAdapter adapter;
    private TextView like;

    String newUserName;
    String newCompany;
    String newdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(this);
        like = (TextView) findViewById(R.id.like_text_view);

        recyclerView  = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        tweets = new ArrayList<>();

        tweets.add(new Tweet("Roman", "06.03.2019", "R&M", R.drawable.body1, R.drawable.roman,false));
        tweets.add(new Tweet("Alina", "05.03.2019", "Devcolibry", R.drawable.body2, R.drawable.alina,false));
        tweets.add(new Tweet("Anita", "05.03.2019", "Latte", R.drawable.body3, R.drawable.anita,false));
        tweets.add(new Tweet("Diana", "05.03.2019", "Sunflower", R.drawable.body4, R.drawable.diana,false));
        tweets.add(new Tweet("Kristi", "05.03.2019", "Rosette", R.drawable.body5, R.drawable.kristina,false));


        adapter = new MyAdapter(tweets, this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                newUserName = data.getStringExtra("userName");
                newCompany = data.getStringExtra("company");
                newdate = data.getStringExtra("date");

                tweets.add(new Tweet(newUserName, newdate, newCompany, R.drawable.image, R.drawable.image,false));


                adapter = new MyAdapter(tweets, this);
                recyclerView.setAdapter(adapter);
            }
            if (resultCode == Activity.RESULT_CANCELED) {
            }
        }
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
        case R.id.fab:
            Intent intent = new Intent(this, Main2Activity.class);
            startActivityForResult(intent,1);
            break;
        default:
            break;
    }
}



}
