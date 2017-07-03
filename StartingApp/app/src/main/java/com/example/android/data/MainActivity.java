package com.example.android.data;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import model.DataItem;
import sample.DataItemAdapter;
import sample.DataItemListAdapter;
import sample.SampleDataProvider;

public class MainActivity extends AppCompatActivity {

    @SuppressWarnings("FieldCanBeLocal")
    //private TextView tvOut;
    List<DataItem> dataItemList = SampleDataProvider.dataItemList;
    List<String> itemNames = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //tvOut = (TextView) findViewById(R.id.out);
       // tvOut.setText("");


        // Sorting Data Items alphabetically
        Collections.sort(dataItemList,new Comparator<DataItem>(){
            @Override
            public int compare(DataItem dataItem, DataItem t1) {
                return dataItem.getItemName().compareTo(t1.getItemName());
            }
        });


//        for (DataItem item: dataItemList
//             ) {
//            itemNames.add(item.getItemName());
//            //tvOut.append(item.getItemName()+"\n");
//        }
//        Collections.sort(itemNames);

        // ArrayAdapter to populate the ListView
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,itemNames);

        DataItemAdapter adapter = new DataItemAdapter(this,dataItemList);
       // ListView listview = (ListView) findViewById(android.R.id.list);
        RecyclerView listview = (RecyclerView) findViewById(R.id.rvItems);
        listview.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
}
