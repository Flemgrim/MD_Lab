package com.example.sergey.mobdev;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

    }

    public void showDialog(View v){
        secondLabFragment dialog = new secondLabFragment();
        dialog.show(getSupportFragmentManager(), "custom");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        //TextView headerView = (TextView) findViewById(R.id.header);
        switch(id){
            case R.id.lab1:
                Intent LabFirstIntent = new Intent(this, Lab1Activity.class);
                startActivity(LabFirstIntent);
                return true;
            case R.id.lab2:
                Intent LabSecondIntent = new Intent(this, Lab2Activity.class);
                startActivity(LabSecondIntent);
                return true;
            case R.id.lab4:
                Intent LabForthIntent = new Intent(this, Lab4Activity.class);
                startActivity(LabForthIntent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
