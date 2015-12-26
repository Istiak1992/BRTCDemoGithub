package com.example.zahid.brtc;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zahid.brtc.DataBase.DBHelper;

public class DetailActivity extends AppCompatActivity {
    DBHelper dbHelper;

    private String[] detail;

    TextView etV,etG,etE,etM,etO,etT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
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
        etV=(TextView)findViewById(R.id.textViewVehicle);
        etG=(TextView)findViewById(R.id.textViewGear);
        etE=(TextView)findViewById(R.id.textViewEngine);
        etM=(TextView)findViewById(R.id.textViewMobil);
        etO=(TextView)findViewById(R.id.textViewOil);
        etT=(TextView)findViewById(R.id.textViewTire1);


        this.detail = getIntent().getExtras().getStringArray("Details");
        etV.setText(this.detail[0]);
        etT.setText(this.detail[1]);
        etG.setText(this.detail[2]);
        etE.setText(this.detail[3]);
        etM.setText(this.detail[4]);
        etO.setText(this.detail[5]);



    }
    public void Close(View view){
        Intent intent=new Intent(DetailActivity.this,MainActivity.class);
        startActivity(intent);
    }
    public void Delete(View view){
      DBHelper db=new DBHelper(this, null, null, 1);

        db.delete(this.detail[0], Integer.valueOf(this.detail[6]));
        Toast.makeText(this, this.detail[0] + " deleted successfully", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(DetailActivity.this,ListActivity.class);
            startActivity(intent);




    }

}
