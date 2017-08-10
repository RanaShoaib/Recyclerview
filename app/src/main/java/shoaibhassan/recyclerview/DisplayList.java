package shoaibhassan.recyclerview;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class DisplayList extends Activity {
       RecyclerView recyclerView ;
      RecyclerView.Adapter adapter;
       RecyclerView.LayoutManager layoutManager;
    ArrayList<Detail>  arrayList =new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_list);
        recyclerView =  (RecyclerView)findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager( layoutManager);
        recyclerView.setHasFixedSize(true);
        NoticeDbHelper noticeDbHelper =new NoticeDbHelper(this);
        SQLiteDatabase sqLiteDatabase =noticeDbHelper.getReadableDatabase();
        Cursor cursor =noticeDbHelper.getInformation(sqLiteDatabase);

        cursor.moveToFirst();
        do
        {
           Detail detail =new Detail(cursor.getString(0),cursor.getString(1),cursor.getString(2));
             arrayList.add(detail);
        }while (cursor.moveToNext());
            noticeDbHelper.close();

        adapter =new RecyclerAdapter(arrayList);
        recyclerView.setAdapter(adapter);
    }
}
