package com.project.hoangminh.famcare;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class FamCareViewPager extends ViewPager {

    private boolean enabled;

    public FamCareViewPager(Context c, AttributeSet a) {
        super(c, a);
        this.enabled = true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent m) {
        if(this.enabled)
            return super.onTouchEvent(m);
        return false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent m) {
        if(this.enabled)
            return super.onInterceptTouchEvent(m);
        return false;
    }

    public void setEnable(boolean b) {
        this.enabled = b;
    }
}
