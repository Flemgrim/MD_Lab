package com.example.sergey.mobdev;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class ShowMessage extends AppCompatActivity {


    ListView userList;
    TextView header;
    HistoryDatabase myDB;
    SQLiteDatabase db;
    Cursor userCursor;
    SimpleCursorAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_message);

        header = (TextView)findViewById(R.id.header);
        userList = (ListView)findViewById(R.id.list);


        myDB = new HistoryDatabase(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        db = myDB.getReadableDatabase();

        userCursor =  db.rawQuery("select * from "+ HistoryDatabase.TABLE, null);
        String[] headers = new String[] {HistoryDatabase.COLUMN_TEXT, HistoryDatabase.COLUMN_SIZE};
        userAdapter = new SimpleCursorAdapter(this, android.R.layout.two_line_list_item,
                userCursor, headers, new int[]{android.R.id.text1, android.R.id.text2}, 0);

        header.setText("Найдено элементов: " + String.valueOf(userCursor.getCount()));
        userList.setAdapter(userAdapter);
    }


    private void goHome(){
        // закрываем подключение
        db.close();
        // переход к главной activity
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }
}
