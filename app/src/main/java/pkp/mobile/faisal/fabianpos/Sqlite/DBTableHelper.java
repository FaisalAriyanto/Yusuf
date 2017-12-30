package pkp.mobile.faisal.fabianpos.Sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import pkp.mobile.faisal.fabianpos.Models.TableModel;

/**
 * Created by joko.santoso on 28/11/2016.
 */

public class DBTableHelper extends DBBaseHelper {
    public DBTableHelper(Context context) {
        super(context);
    }

    public void addQuestion(TableModel question) {
        SQLiteDatabase db = openDb();
        ContentValues values = new ContentValues();
        values.put(DBTableHelper.KEY_TABLE_ID, question.getId());
        values.put(DBTableHelper.KEY_NAME, question.getName());
        values.put(DBTableHelper.KEY_IS_EMPTY, question.isEmpty());
        values.put(DBTableHelper.KEY_FLOOR_ID, question.getFloor_id());

        // Inserting Row
        db.insert(DBTableHelper.TABLE_FLOOR, null, values);
        db.close(); // Closing database connection
    }


    public ArrayList<TableModel> getById(int id) {
        ArrayList<TableModel> temp = new ArrayList<TableModel>();
        String selectQuery = "SELECT  * FROM " + DBBaseHelper.TABLE_FLOOR + " WHERE " + DBBaseHelper.KEY_IS_EMPTY + " = " + id;
        SQLiteDatabase db = this.openDb();
        Cursor c = db.rawQuery(selectQuery, null);
        if (c.moveToFirst()) {
            do {
                TableModel td = new TableModel(
                        c.getInt(c.getColumnIndex(DBBaseHelper.KEY_TABLE_ID)),
                        c.getString(c.getColumnIndex(DBBaseHelper.KEY_NAME)),
                        c.getString(c.getColumnIndex(DBBaseHelper.KEY_IS_EMPTY)),
                        c.getInt(c.getColumnIndex(DBBaseHelper.KEY_FLOOR_ID))
                );
                // adding to Task ArrayList
                temp.add(td);
            } while (c.moveToNext());
        }
        return temp;
    }

    public ArrayList<TableModel> getAll() {
        ArrayList<TableModel> temp = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + DBBaseHelper.TABLE_FLOOR;
        SQLiteDatabase db = this.openDb();
        Cursor c = db.rawQuery(selectQuery, null);
        if (c.moveToFirst()) {
            do {
                TableModel td = new TableModel(
                        c.getInt(c.getColumnIndex(DBBaseHelper.KEY_TABLE_ID)),
                        c.getString(c.getColumnIndex(DBBaseHelper.KEY_NAME)),
                        c.getString(c.getColumnIndex(DBBaseHelper.KEY_IS_EMPTY)),
                        c.getInt(c.getColumnIndex(DBBaseHelper.KEY_FLOOR_ID))
                );

                temp.add(td);
            } while (c.moveToNext());
        }
        return temp;
    }


    public void resetTables() {
        SQLiteDatabase db = openDb();
        // Delete All Rows
        db.delete(DBBaseHelper.TABLE_FLOOR, null, null);
        db.close();
    }
}
