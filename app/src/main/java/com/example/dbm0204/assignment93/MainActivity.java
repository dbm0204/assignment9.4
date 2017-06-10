package com.example.dbm0204.assignment93;

import java.util.ArrayList;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.content.Context;

public class MainActivity extends Activity {
    private static ArrayList<Item> items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 1. pass context and data to the custom adapter
        MyAdapter adapter = new MyAdapter(this, generateData());
        // 2. Get ListView from activity_main.xml
        ListView listView = (ListView) findViewById(R.id.listview);
        // 3. setListAdapter
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent,
                                    View view, int position, long id) {

                //TODO:Create context Menu


                Item clickedObj = (Item) parent.getItemAtPosition(position);
                Toast.makeText(MainActivity.this,
                        "Clicked item:\n" +
                                clickedObj.getNumber() + ": " +
                                clickedObj.getName(),
                        Toast.LENGTH_LONG).show();
            }});
    }
    private ArrayList<Item> generateData(){
        items = new ArrayList<Item>();
        items.add(new Item("Ben Mathew","00000000"));
        items.add(new Item("Mathew Ben ","111111111"));
        items.add(new Item("Benjamin Mathew","222222222"));
        return items;
    }
}
