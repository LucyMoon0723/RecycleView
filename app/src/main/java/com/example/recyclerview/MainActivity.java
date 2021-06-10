package com.example.recyclerview;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView mRecyclerView = null;
    RecyclerViewAdapter mAdapter = null;
    ArrayList<RecyclerViewItem> mList;

    String[] countNum = {"0","0","0","0","0"};


    private Drawable mImageDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recycler_view);
        mList = new ArrayList<>();

        mAdapter = new RecyclerViewAdapter(mList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        addItem(ResourcesCompat.getDrawable(getResources(), R.drawable.chicken1, null), "후라이드 치킨",  "16000원", countNum[0]);
        addItem(ResourcesCompat.getDrawable(getResources(), R.drawable.chicken2, null), "양념 치킨",  "18000원", countNum[1]);
        addItem(ResourcesCompat.getDrawable(getResources(), R.drawable.chicken3, null), "간장 치킨",  "17000원", countNum[2]);
        addItem(ResourcesCompat.getDrawable(getResources(), R.drawable.side1, null), "감자 튀김",  "4000원", countNum[3]);
        addItem(ResourcesCompat.getDrawable(getResources(), R.drawable.side2, null), "치즈볼",  "5000원", countNum[4]);
        mAdapter.notifyDataSetChanged();
    }

    private void addItem(Drawable icon, String mainText, String subText, String count) {
        RecyclerViewItem item = new RecyclerViewItem();

        item.setIcon(icon);
        item.setMainTitle(mainText);
        item.setSubTitle(subText);
        item.setcount(count);

        mList.add(item);
    }
}