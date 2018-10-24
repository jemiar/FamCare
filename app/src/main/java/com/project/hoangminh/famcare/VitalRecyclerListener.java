package com.project.hoangminh.famcare;

import android.view.View;

//2nd method. Step 1: Define an interface for event listener of RecyclerView
public interface VitalRecyclerListener {
    public void onClick(View v, int pos);
}
