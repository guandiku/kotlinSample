package com.xiamen.www.myapplication3.kotlin.test.activityjump;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.xiamen.www.myapplication3.R;
import com.xiamen.www.myapplication3.kotlin.view.activity.BaseActivity;

public class Main9Activity extends BaseActivity {

    private Button button;

    @Override
    public int setLayoutResource() {
        return R.layout.activity_main9;
    }

    @Override
    public void initView() {
        button=findViewById(R.id.btn_jump);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TAG", "onClick execute");
            }
        });
        button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.d("TAG", "onTouch execute, action " + event.getAction());
                return false;
            }
        });


    }

    @Override
    public void initVariable() {

    }

    @Override
    public void initData() {

    }
}
