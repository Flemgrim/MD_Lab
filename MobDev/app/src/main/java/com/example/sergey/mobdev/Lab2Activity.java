package com.example.sergey.mobdev;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class Lab2Activity  extends AppCompatActivity implements fragmentEdit.OnFragmentInteractionListener {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_lab2);
                }

        @Override
        public void onFragmentInteraction(String message, String size) {
                fragmentView fragment = (fragmentView) getFragmentManager()
                .findFragmentById(R.id.viewFragment);
                if (fragment != null && fragment.isInLayout()) {
                        fragment.setText(message);
                        int sizeOfText = Integer.parseInt(size);
                        fragment.setSize(sizeOfText);
                }
        }
}

