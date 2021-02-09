package net.yrom.screenrecorder.db;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import net.yrom.screenrecorder.R;
import net.yrom.screenrecorder.db.db.MyDbHelper;

/**
 * Created by Administrator on 2018/6/4.
 */

public class MainActivity extends Activity
{
    Button mBtn;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textview = (TextView) findViewById(R.id.tv);
        final MyDbHelper helper = new MyDbHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
//        Cursor cursor = db.query("Book",null, null, null, null, null, null);

        Cursor cursor = db.rawQuery("select id,name from Book where name=?",new String[]{"name"});

        if (cursor.moveToNext()) {
            do {
//            while (cursor.moveToFirst()) {
//                list.add(new initdate(base64ToBitmap(c.getString(c.getColumnIndex("字段名1"))), c.getString(c.getColumnIndex("字段名2")),
//                        c.getString(c.getColumnIndex("字段名3"))));

                String name = cursor.getString(cursor.getColumnIndex("name"));
                textview.setText(name);
//            }
            }while (cursor.moveToNext());
            cursor.close();
//            db.close();//关闭数据库
        }

    }

}
