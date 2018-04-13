package com.xiamen.www.myapplication3.kotlin.view.comstom;

import android.content.Context;
import android.util.AttributeSet;

/**
 * Created by white on 2018/3/14.
 */

public class MarqueeTextView extends android.support.v7.widget.AppCompatTextView {

    public MarqueeTextView(Context con) {
        super(con);
    }

    public MarqueeTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MarqueeTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean isFocused() {
        return true;
    }
}