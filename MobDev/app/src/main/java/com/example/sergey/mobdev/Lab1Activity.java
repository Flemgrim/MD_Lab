package com.example.sergey.mobdev;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class Lab1Activity extends AppCompatActivity {

    long userId=0;
    ListView userList;
    HistoryDatabase historyDatabase;
    SQLiteDatabase db;
    Cursor userCursor;
    SimpleCursorAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab1);
        historyDatabase = new HistoryDatabase(getApplicationContext());
    }

    @Override
    protected void onResume() {
        super.onResume();

        db = historyDatabase.getWritableDatabase();
        //db.execSQL("DROP TABLE IF EXISTS history");
        //db.execSQL("CREATE TABLE history (" + HistoryDatabase.COLUMN_ID
          //     + " INTEGER PRIMARY KEY AUTOINCREMENT," + HistoryDatabase.COLUMN_TEXT
            //   + " TEXT, " + HistoryDatabase.COLUMN_SIZE + " INTEGER);");
    }

    public void showDialog(View v){
        secondLabFragment dialog = new secondLabFragment();
        dialog.show(getSupportFragmentManager(), "custom");
    }


    public void buttonOkClick(View view ){

        EditText editText = (EditText) findViewById(R.id.edit_message);
        EditText textSize = (EditText) findViewById(R.id.edit_textsize);

        String message = editText.getText().toString();
        int sizeOfText = Integer.parseInt(textSize.getText().toString());
        TextView textView = (TextView) findViewById(R.id.textView2);
        textView.setTextSize(sizeOfText);
        textView.setText(message);

        ContentValues cv = new ContentValues();
        cv.put(HistoryDatabase.COLUMN_TEXT, message.toString());
        cv.put(HistoryDatabase.COLUMN_SIZE, textSize.getText().toString());
        db.insert(HistoryDatabase.TABLE, null, cv);

        Toast toast = Toast.makeText(this, "Data was added to DB",1000);
        toast.setGravity(Gravity.CENTER, 0,160);
        toast.show();
    }

    public void showHistory(View view){

        userCursor =  db.rawQuery("select * from "+ HistoryDatabase.TABLE, null);
        if (userCursor.getCount()==0){
            Toast toast = Toast.makeText(this, "DB is empty",2000);
            toast.setGravity(Gravity.CENTER, 0,160);
            toast.show();
        } else {
            Intent intent = new Intent(this, ShowMessage.class);
            startActivity(intent);
        }
    }

    public void buttonCancelClick(View view){
        EditText editText = findViewById(R.id.edit_message);
        editText.setText("");

        TextView textView = findViewById(R.id.textView2);
        textView.setText("");

        EditText textSize = findViewById(R.id.edit_textsize);
        textSize.setText("");



    }
    //public void onDestroy(){
      //  super.onDestroy();
        //db.close();
        //userCursor.close();
    //}
}
