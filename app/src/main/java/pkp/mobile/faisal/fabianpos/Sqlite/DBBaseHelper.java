package pkp.mobile.faisal.fabianpos.Sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by joko.santoso on 28/11/2016.
 */

public class DBBaseHelper {
    protected static final String DATABASE_NAME = "salesforce";
    protected static final int DATABASE_VERSION = 1;

    protected Context mContext;
    protected static DatabaseHelper mDbHelper;
    public static final String KEY_ID = "id";


    //=====================START CREATE SQLITE===============================
    public static final String TABLE_TABLE = "tables";
    public static final String KEY_TABLE_ID = "table_id";
    public static final String KEY_NAME = "name";
    public static final String KEY_IS_EMPTY = "isempty";
    public static final String KEY_FLOOR_ID = "floor_id";
    public static final String CREATE_TABLE_TABLE = "CREATE TABLE " + TABLE_TABLE + "("
            + KEY_TABLE_ID + " INTEGER PRIMARY KEY , "
            + KEY_NAME + " TEXT , "
            + KEY_IS_EMPTY + " TEXT , "
            + KEY_FLOOR_ID + " INTEGER "
            + ")";


    public static final String TABLE_FLOOR = "floors";
    public static final String CREATE_TABLE_FLOOR = "CREATE TABLE " + TABLE_FLOOR + "("
            + KEY_FLOOR_ID + " INTEGER , "
            + KEY_NAME + " TEXT " + ")";

    //=====================END CREATE SQLITE===============================


    public DBBaseHelper(Context context) {
        mContext = context.getApplicationContext();
    }

    public SQLiteDatabase openDb() {
        if (mDbHelper == null) {
            mDbHelper = new DatabaseHelper(mContext);
        }
        return mDbHelper.getWritableDatabase();
    }

    public void closeDb() {
        mDbHelper.close();
    }

    protected static class DatabaseHelper extends SQLiteOpenHelper {

        public DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_TABLE_TABLE);
            db.execSQL(CREATE_TABLE_FLOOR);

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_TABLE);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_FLOOR);

            onCreate(db);
        }

    }
}
