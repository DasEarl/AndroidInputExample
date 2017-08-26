package com.example.hcelik.androidinputexample;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MyLogger";
    private FloatingActionButton addButton;
    private ListView listView;
    private ItemAdapter adapter;
    private ArrayList<Item> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        items = new ArrayList<>();
        adapter = new ItemAdapter(this, R.layout.row, items);

        listView = findViewById(R.id.listview);
        listView.setAdapter(adapter);

        addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, newItemActivity.class);
                startActivityForResult(intent, 1);
                overridePendingTransition(R.anim.push_left, R.anim.pop_left);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 1) {
            String title = data.getStringExtra("title");
            String firstname = data.getStringExtra("firstname");
            String lastname = data.getStringExtra("lastname");

            Item item = new Item(title, firstname, lastname);

            adapter.add(item);
            adapter.notifyDataSetChanged();
        }
    }
}
