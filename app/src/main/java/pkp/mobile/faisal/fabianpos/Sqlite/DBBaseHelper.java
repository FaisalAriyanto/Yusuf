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
    public static final String TABLE_TEMPLATE = "template";
    public static final String KEY_TEMPLATE_ID = "template_id";
    public static final String KEY_COMPANY_ID = "coyId";
    public static final String KEY_QUESTION_ID = "question_id";
    public static final String KEY_TEMPLATE_SORT = "template_sort";
    public static final String KEY_IS_MANDATORY = "is_mandatory";
    public static final String KEY_ISACTIVE = "is_active";
    public static final String CREATE_TABLE_TEMPLATE = "CREATE TABLE " + TABLE_TEMPLATE + "("
            + KEY_TEMPLATE_ID + " INTEGER PRIMARY KEY , "
            + KEY_COMPANY_ID + " INTEGER , "
            + KEY_QUESTION_ID + " INTEGER , "
            + KEY_TEMPLATE_SORT + " INTEGER , "
            + KEY_IS_MANDATORY + " TEXT ,"
            + KEY_ISACTIVE + " TEXT " + ")";


    public static final String TABLE_QUESTION = "question";
    public static final String KEY_QUESTION_TEXT = "question_text";
    public static final String KEY_DATATYPE_ID = "dataype_id";
    public static final String CREATE_TABLE_QUESTION = "CREATE TABLE " + TABLE_QUESTION + "("
            + KEY_QUESTION_ID + " INTEGER PRIMARY KEY , "
            + KEY_QUESTION_TEXT + " TEXT  , "
            + KEY_DATATYPE_ID + " INTEGER " + ")";


    public static final String TABLE_COLLECTION = "collection";
    public static final String KEY_COLLECTION_ID = "collection_id";
    public static final String KEY_USER_ID = "user_id";
    public static final String KEY_POSITION = "position";
    public static final String KEY_ISAPPROVED = "is_approved";
    public static final String KEY_CREATED_DATE = "created_date";
    public static final String KEY_APPROVED_BY = "approved_by";
    public static final String KEY_APPROVED_DATE = "approved_date";
    public static final String KEY_IMAGE_ID = "image_id";
    public static final String CREATE_TABLE_COLLECTION = "CREATE TABLE " + TABLE_COLLECTION + "("
            + KEY_COLLECTION_ID + " INTEGER PRIMARY KEY, "
            + KEY_USER_ID + " INTEGER  , "
            + KEY_POSITION + " TEXT  , "
            + KEY_ISAPPROVED + " TEXT , "
            + KEY_CREATED_DATE + " DATETIME ,"
            + KEY_APPROVED_BY + " TEXT ,"
            + KEY_APPROVED_DATE + " DATETIME ,"
            + KEY_IMAGE_ID + " INTEGER"
            + ")";


    public static final String TABLE_DETAIL_COLECTION = "detail_collection";
    public static final String KEY_DETAIL_COLLECTION_ID = "detail_collection_id";
    public static final String KEY_ANSWER_TEXT = "answer_text";
    public static final String CREATE_TABLE_DETAIL_COLLECTION = "CREATE TABLE " + TABLE_DETAIL_COLECTION + "("
            + KEY_DETAIL_COLLECTION_ID + " INTEGER PRIMARY KEY, "
            + KEY_COLLECTION_ID + " INTEGER  , "
            + KEY_QUESTION_ID + " INTEGER  , "
            + KEY_ANSWER_TEXT + " TEXT  ,"
            + KEY_CREATED_DATE + " DATETIME, "
            + KEY_QUESTION_TEXT + " TEXT "
            + ")";

    public static final String TABLE_SUMMARY = "summary";
    public static final String KEY_WEEK = "week";
    public static final String KEY_COLL_COUNT = "coll_count";

    public static final String CREATE_TABLE_SUMMARY = "CREATE TABLE " + TABLE_SUMMARY + "("
            + KEY_ID + " INTEGER PRIMARY KEY, "
            + KEY_WEEK + " INTEGER , "
            + KEY_COLL_COUNT + " INTEGER" + ")";

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
            db.execSQL(CREATE_TABLE_TEMPLATE);
            db.execSQL(CREATE_TABLE_QUESTION);
            db.execSQL(CREATE_TABLE_DETAIL_COLLECTION);
            db.execSQL(CREATE_TABLE_SUMMARY);
            db.execSQL(CREATE_TABLE_COLLECTION);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_TEMPLATE);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUESTION);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_DETAIL_COLECTION);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_SUMMARY);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_COLLECTION);
            onCreate(db);
        }

    }
}
