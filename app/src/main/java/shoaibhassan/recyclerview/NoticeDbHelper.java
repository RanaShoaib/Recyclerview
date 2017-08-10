package shoaibhassan.recyclerview;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class NoticeDbHelper extends SQLiteOpenHelper {

    public static final  String DB_NAME= "detail";
    public static final  int DB_VERSION = 1;
   public  static  final String CREATE_TABLE = " created table " + Detail.DetailUser.TABLE_NAME+ "( " +Detail.DetailUser.TITLE+
    " text," +Detail.DetailUser.NOTICE + " text ," +Detail.DetailUser.DETAIL+ " text);";
    private static final String DROP_QUERY = "drop table if exist "  + Detail.DetailUser.TABLE_NAME+ ";";

    public NoticeDbHelper(Context context)
    {

        super(context,DB_NAME,null,DB_VERSION);
        Log.d("Database operation","Database created..");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

      db.execSQL(CREATE_TABLE);
        Log.d("Database operation","Table created..");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_QUERY);
        Log.d("Database operation","Database updated..");

    }

    public void putInformation(String title,String notice ,String detail , SQLiteDatabase db)
    {
        ContentValues contentValues = new ContentValues();
         contentValues.put(Detail.DetailUser.TITLE,title);
       contentValues.put(Detail.DetailUser.NOTICE,notice);
        contentValues.put(Detail.DetailUser.DETAIL,detail);
        long l = db.insert(Detail.DetailUser.TABLE_NAME,null,contentValues);
        Log.d("Database operation" ,"one row inserted..");
        Log.d("Database operation","Database updated..");


    }

    public Cursor getInformation(SQLiteDatabase db )
    {
        String[] projection ={Detail.DetailUser.TITLE,Detail.DetailUser.NOTICE, Detail.DetailUser.DETAIL };
        Cursor cursor =db.query(Detail.DetailUser.TABLE_NAME, projection,null,null,null,null,null);
      return cursor;
    }


}
