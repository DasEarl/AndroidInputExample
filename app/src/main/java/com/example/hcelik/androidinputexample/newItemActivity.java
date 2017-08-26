package com.example.hcelik.androidinputexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by hcelik on 14.08.17
 */

public class newItemActivity extends AppCompatActivity {
    private static final String TAG = "MyLogger";
    private FloatingActionButton addNewItem;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_item);

        addNewItem = findViewById(R.id.addNewItem);
        addNewItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText title = findViewById(R.id.inputTitle);
                EditText firstname = findViewById(R.id.inputFirstname);
                EditText lastname = findViewById(R.id.inputLastname);

                Intent intent = new Intent();
                intent.putExtra("title", title.getText().toString());
                intent.putExtra("firstname", firstname.getText().toString());
                intent.putExtra("lastname", lastname.getText().toString());

                setResult(1, intent);

                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.pop_right, R.anim.push_right);
    }
}
