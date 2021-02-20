package net.yrom.screenrecorder.db;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import net.yrom.screenrecorder.R;

import sqlite.DbHelper;

/**
 * Created by Administrator on 2018/6/4.
 */

public class MainActivity extends AppCompatActivity
{
    private DbHelper helper = new DbHelper(this);
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String tempName="";
        Cursor cursor = helper.getReadableDatabase().rawQuery(
                "select id as _id,name from records where name like '%" + tempName + "%' order by id desc ", null);
        if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()){
            Toast.makeText(this, "读取数据成功！" + cursor.getCount(), Toast.LENGTH_SHORT).show();
//            if(cursor.moveToNext()) {
//                cursor.moveToFirst();

                do {
                    String name = cursor.getString(cursor.getColumnIndex("name"));
                    Log.i("TAG", "表searchHisTab的name=" + name);
                    if (name != null && !name.equals("")) {
                    }
                } while (cursor.moveToNext());
                cursor.close();
//            }
        }else {
            Toast.makeText(this, "读取数据失败！", Toast.LENGTH_SHORT).show();
        }
    }
}
