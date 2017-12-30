package pkp.mobile.faisal.fabianpos.Sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import pkp.mobile.faisal.fabianpos.Models.FloorModel;

/**
 * Created by joko.santoso on 28/11/2016.
 */

public class DBFloorHelper extends DBBaseHelper {
    public DBFloorHelper(Context context) {
        super(context);
    }

    public void addQuestion(FloorModel floor) {
        SQLiteDatabase db = openDb();
        ContentValues values = new ContentValues();
        values.put(DBFloorHelper.KEY_FLOOR_ID, floor.getFloor_id());
        values.put(DBFloorHelper.KEY_NAME, floor.getName());

        // Inserting Row
        db.insert(DBFloorHelper.TABLE_FLOOR, null, values);
        db.close(); // Closing database connection
    }


    public ArrayList<FloorModel> getById(int id) {
        ArrayList<FloorModel> temp = new ArrayList<FloorModel>();
        String selectQuery = "SELECT  * FROM " + DBBaseHelper.TABLE_FLOOR + " WHERE " + DBBaseHelper.KEY_IS_EMPTY + " = " + id;
        SQLiteDatabase db = this.openDb();
        Cursor c = db.rawQuery(selectQuery, null);
        if (c.moveToFirst()) {
            do {
                FloorModel td = new FloorModel(
                        c.getInt(c.getColumnIndex(DBBaseHelper.KEY_FLOOR_ID)),
                        c.getString(c.getColumnIndex(DBBaseHelper.KEY_NAME))
                );
                // adding to Task ArrayList
                temp.add(td);
            } while (c.moveToNext());
        }
        return temp;
    }

    public ArrayList<FloorModel> getAll() {
        ArrayList<FloorModel> temp = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + DBBaseHelper.TABLE_FLOOR;
        SQLiteDatabase db = this.openDb();
        Cursor c = db.rawQuery(selectQuery, null);
        if (c.moveToFirst()) {
            do {
                FloorModel td = new FloorModel(
                        c.getInt(c.getColumnIndex(DBBaseHelper.KEY_FLOOR_ID)),
                        c.getString(c.getColumnIndex(DBBaseHelper.KEY_NAME))
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
