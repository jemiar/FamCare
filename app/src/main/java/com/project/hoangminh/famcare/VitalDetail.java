package com.project.hoangminh.famcare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import static android.support.v7.widget.DividerItemDecoration.HORIZONTAL;

public class VitalDetail extends AppCompatActivity {

    private RecyclerView detailListView;
    private LinearLayoutManager detailLayoutManager;
    private VitalDetailAdapter detailAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vital_detail);

        String label = getIntent().getExtras().getString("Label");
        TextView itemName = (TextView) findViewById(R.id.itemName);
        itemName.setText(label);

        detailListView = (RecyclerView) findViewById(R.id.detailArea);
        detailListView.setHasFixedSize(true);
        detailLayoutManager = new LinearLayoutManager(this);
        detailListView.setLayoutManager(detailLayoutManager);

        detailAdapter = new VitalDetailAdapter();
        detailListView.setAdapter(detailAdapter);

        //Add divider between item
        DividerItemDecoration itemDecor = new DividerItemDecoration(this, HORIZONTAL);
        detailListView.addItemDecoration(itemDecor);

        Detail_Item item1 = new Detail_Item("1/2", "8:30 AM", "Normal");
        detailAdapter.addItem(item1);
        Detail_Item item2 = new Detail_Item("1/2", "9:00 AM", "Normal");
        detailAdapter.addItem(item2);
        Detail_Item item3 = new Detail_Item("1/2", "9:30 AM", "Normal");
        detailAdapter.addItem(item3);
        Detail_Item item4 = new Detail_Item("1/2", "10:00 AM", "Normal");
        detailAdapter.addItem(item4);
        Detail_Item item5 = new Detail_Item("1/2", "10:30 AM", "Normal");
        detailAdapter.addItem(item5);
        Detail_Item item6 = new Detail_Item("1/2", "11:00 AM", "Normal");
        detailAdapter.addItem(item6);
        Detail_Item item7 = new Detail_Item("1/2", "11:30 AM", "Normal");
        detailAdapter.addItem(item7);
        Detail_Item item8 = new Detail_Item("1/2", "12:00 PM", "Normal");
        detailAdapter.addItem(item8);
        Detail_Item item9 = new Detail_Item("1/2", "12:30 PM", "Normal");
        detailAdapter.addItem(item9);
        Detail_Item item10 = new Detail_Item("1/2", "1:00 PM", "Normal");
        detailAdapter.addItem(item10);
        Detail_Item item11 = new Detail_Item("1/2", "1:30 PM", "Normal");
        detailAdapter.addItem(item11);
        Detail_Item item12 = new Detail_Item("1/2", "2:00 PM", "Normal");
        detailAdapter.addItem(item12);
        Detail_Item item13 = new Detail_Item("1/2", "2:30 PM", "Normal");
        detailAdapter.addItem(item13);
        Detail_Item item14 = new Detail_Item("1/2", "3:00 PM", "Normal");
        detailAdapter.addItem(item14);
        Detail_Item item15 = new Detail_Item("1/2", "3:30 PM", "Normal");
        detailAdapter.addItem(item15);
        detailAdapter.notifyDataSetChanged();

        ImageView closeButton = (ImageView) findViewById(R.id.closeHistoryButton);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
