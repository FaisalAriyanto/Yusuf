package pkp.mobile.faisal.fabianpos.Sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import pkp.mobile.faisal.fabianpos.TableModel;

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
        values.put(DBQuestionHelper.KEY_QUESTION_ID, question.getQuestion_id());
        values.put(DBQuestionHelper.KEY_QUESTION_TEXT, question.getQuestion_text());
        values.put(DBQuestionHelper.KEY_DATATYPE_ID, question.getDatatype_id());
        ;

        // Inserting Row
        db.insert(DBQuestionHelper.TABLE_QUESTION, null, values);
        db.close(); // Closing database connection
    }


    public ArrayList<TableModel> getById(int id) {
        ArrayList<TableModel> temp = new ArrayList<TableModel>();
        String selectQuery = "SELECT  * FROM " + DBBaseHelper.TABLE_QUESTION + " WHERE " + DBBaseHelper.KEY_QUESTION_ID + " = " + id ;
        SQLiteDatabase db = this.openDb();
        Cursor c = db.rawQuery(selectQuery, null);
        if (c.moveToFirst()) {
            do {
                TableModel td = new TableModel(
                        c.getInt(c.getColumnIndex(DBBaseHelper.KEY_QUESTION_ID)),
                        c.getString(c.getColumnIndex(DBBaseHelper.KEY_QUESTION_TEXT)),
                        c.getInt(c.getColumnIndex(DBBaseHelper.KEY_DATATYPE_ID))
                );
                // adding to Task ArrayList
                temp.add(td);
            } while (c.moveToNext());
        }
        return temp;
    }

    public ArrayList<TableModel> getAll() {
        ArrayList<TableModel> temp = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + DBBaseHelper.TABLE_QUESTION;
        SQLiteDatabase db = this.openDb();
        Cursor c = db.rawQuery(selectQuery, null);
        if (c.moveToFirst()) {
            do {
                TableModel td = new TableModel(
                        c.getInt(c.getColumnIndex(DBBaseHelper.KEY_QUESTION_ID)),
                        c.getString(c.getColumnIndex(DBBaseHelper.KEY_QUESTION_TEXT)),
                        c.getInt(c.getColumnIndex(DBBaseHelper.KEY_DATATYPE_ID))
                );
                // adding to Task ArrayList
                temp.add(td);
            } while (c.moveToNext());
        }
        return temp;
    }


    public void resetTables() {
        SQLiteDatabase db = openDb();
        // Delete All Rows
        db.delete(DBBaseHelper.TABLE_QUESTION, null, null);
        db.close();
    }
}
