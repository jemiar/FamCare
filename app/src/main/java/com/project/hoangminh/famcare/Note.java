package com.project.hoangminh.famcare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

public class Note extends AppCompatActivity {

    private RecyclerView noteList;
    private LinearLayoutManager layoutManager;
    private NoteAdapter noteAdapter;
    private ImageView closeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        noteList = (RecyclerView) findViewById(R.id.noteList);
        noteList.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        noteList.setLayoutManager(layoutManager);

        noteAdapter = new NoteAdapter();
        noteList.setAdapter(noteAdapter);

        NoteItem item1 = new NoteItem("Oct 1, 2018 8:00 AM", getString(R.string.fake));
        noteAdapter.addItem(item1);
        NoteItem item2 = new NoteItem("Oct 1, 2018 8:30 AM", getString(R.string.fake));
        noteAdapter.addItem(item2);
        NoteItem item3 = new NoteItem("Oct 1, 2018 9:00 AM", getString(R.string.fake));
        noteAdapter.addItem(item3);
        noteAdapter.notifyDataSetChanged();

        closeButton = (ImageView) findViewById(R.id.closeButton);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
