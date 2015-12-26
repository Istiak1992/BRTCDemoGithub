package com.example.zahid.brtc;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.zahid.brtc.DataBase.DBHelper;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    EditText etSearch;
    ListView lv;
    ArrayList<String> allVehicles;
    ArrayList<String> allVehicleIDs;
    DBHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        etSearch=(EditText)findViewById(R.id.editTextSearch);
        lv=(ListView)findViewById(R.id.listView);
        dbHelper = new DBHelper(this, null, null, 1);
        ArrayList[] vh = dbHelper.getInfo();
        allVehicles = vh[0];
        allVehicleIDs = vh[1];


      ArrayAdapter  vehicles = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, allVehicles);

        lv.setAdapter(vehicles);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = (String) parent.getAdapter().getItem(position);
                int studentId =(int) parent.getAdapter().getItemId(position);

                String details[] = dbHelper.getVehicleDetails(name, Integer.valueOf(allVehicleIDs.get(studentId)));

                Intent i = new Intent(getApplicationContext(), DetailActivity.class);
                i.putExtra("Details", details);
                startActivity(i);

            }
        });







    }

}
