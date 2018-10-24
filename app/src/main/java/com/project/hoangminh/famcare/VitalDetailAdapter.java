package com.project.hoangminh.famcare;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class VitalDetailAdapter extends RecyclerView.Adapter<VitalDetailAdapter.DetailViewHolder> {

    private List<Detail_Item> dataSet;

    public static class DetailViewHolder extends RecyclerView.ViewHolder {

        public TextView detailDay;
        public TextView detailTime;
        public TextView detailValue;

        public DetailViewHolder(View v) {
            super(v);
            detailDay = (TextView) v.findViewById(R.id.detailDay);
            detailTime = (TextView) v.findViewById(R.id.detailTime);
            detailValue = (TextView) v.findViewById(R.id.detailValue);
        }

    }

    public VitalDetailAdapter() {
        dataSet = new ArrayList<>();
    }

    public VitalDetailAdapter(List<Detail_Item> ds) {
        dataSet = ds;
    }

    public void addItem(Detail_Item di) {
        dataSet.add(di);
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    @NonNull
    @Override
    public DetailViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = (View) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.detail_item, viewGroup, false);
        return new DetailViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailViewHolder detailViewHolder, int i) {
        Detail_Item item = dataSet.get(i);
        detailViewHolder.detailDay.setText(item.getDay());
        detailViewHolder.detailTime.setText(item.getTime());
        detailViewHolder.detailValue.setText(item.getValue());
    }
}
