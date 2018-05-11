package com.xiamen.www.myapplication3.kotlin.myview.recy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xiamen.www.myapplication3.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by White on 2018/5/9.
 */

public class RyclerTestActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<String> mData;
    private HomeAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_recler);
        initData();
        mRecyclerView = findViewById(R.id.id_recyclerview);

//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        mRecyclerView.setLayoutManager(new GridLayoutManager(this,2));
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
//        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.HORIZONTAL));

        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
//        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
//        mRecyclerView.addItemDecoration(new DividerGridItemDecoration(this));
        mAdapter = new HomeAdapter();


        mRecyclerView.setAdapter(mAdapter);

    }

    private void initData() {
        mData = new ArrayList<>();
        for (int i = 'A'; i < 'Z'; i++) {
            mData.add("" + (char) i);
        }
    }


    private class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(RyclerTestActivity.this).inflate(R.layout.item_home, parent, false));
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.textView.setText(mData.get(position));
        }

        @Override
        public int getItemCount() {
            return mData.size();
        }

        @Override
        public int getItemViewType(int position) {
            return super.getItemViewType(position);
        }

        public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

            TextView textView;

            public MyViewHolder(View itemView) {
                super(itemView);
                textView = itemView.findViewById(R.id.id_num);
                itemView.setOnClickListener(this);
            }

            @Override
            public void onClick(View v) {
                if (mItemClickListener != null) {
                    mItemClickListener.OnItemClickListener(v, getLayoutPosition());
                }
            }
        }


    }

    private OnItemClickListener mItemClickListener;

    public void setOnItemClickListener(OnItemClickListener l) {
        this.mItemClickListener = l;
    }

    interface OnItemClickListener {
        void OnItemClickListener(View itemView, int position);
    }
}
