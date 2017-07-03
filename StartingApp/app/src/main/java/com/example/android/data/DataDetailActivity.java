package com.example.android.data;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import model.DataItem;
import sample.DataItemAdapter;
import sample.SampleDataProvider;

public class DataDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //String id = getIntent().getExtras().getString(DataItemAdapter.ITEM_KEY_NAME);
       // DataItem item = SampleDataProvider.dataItemMap.get(id);
        DataItem item = getIntent().getExtras().getParcelable(DataItemAdapter.ITEM_KEY);
        Toast.makeText(this, "Item name "+item.getItemName(), Toast.LENGTH_SHORT).show();

    }

}
