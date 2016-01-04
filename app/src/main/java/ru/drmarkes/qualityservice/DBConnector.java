package ru.drmarkes.qualityservice;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Андрей on 04.01.2016.
 */
public class DBConnector {

    private static final String DATABASE_NAME = "quality.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "smile";

    // Название столбцов
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_POSITIVE = "Positive";
    private static final String COLUMN_NEUTRAL = "Neutral";
    private static final String COLUMN_NEGATIVE = "Negative";

    // Номера столбцов
    private static final int NUM_COLUMN_ID = 1;
    private static final int NUM_COLUMN_POSITIVE = 1;
    private static final int NUM_COLUMN_NEUTRAL = 2;
    private static final int NUM_COLUMN_NEGATIVE = 3;

    private SQLiteDatabase mDataBase;
    private OpenHelper mOpenHelper;

    public DBConnector(Context context) {
        mOpenHelper = new OpenHelper(context);
    }

    public void open() throws SQLException {
        mDataBase = mOpenHelper.getWritableDatabase();
    }

    public void close() {
        mOpenHelper.close();
    }

    // Метод редактирования строки в БД
    public int update(Smile smile) {
        ContentValues cv=new ContentValues();
        cv.put(COLUMN_POSITIVE, smile.getCountPositive());
        cv.put(COLUMN_NEUTRAL, smile.getCountNeutral());
        cv.put(COLUMN_NEGATIVE, smile.getCountNegative());
        return mDataBase.update(TABLE_NAME, cv, COLUMN_ID + " = ?", new String[]{String.valueOf(1)});
    }

    // Метод удаления всех записей из БД
    public int deleteAll() {
        return mDataBase.delete(TABLE_NAME, null, null);
    }

    // Метод выборки одной записи
    public Smile select() {
        Cursor mCursor = mDataBase.query(TABLE_NAME, null, COLUMN_ID + " = ?", new String[]{String.valueOf(1)}, null, null, COLUMN_POSITIVE);

        mCursor.moveToFirst();
        int positive = mCursor.getInt(NUM_COLUMN_POSITIVE);
        int neutral = mCursor.getInt(NUM_COLUMN_NEUTRAL);
        int negative = mCursor.getInt(NUM_COLUMN_NEGATIVE);
        mCursor.close();
        return new Smile(positive, neutral, negative);
    }

    // Класс для создания БД
    private class OpenHelper extends SQLiteOpenHelper {

        OpenHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);	}
        @Override
        public void onCreate(SQLiteDatabase db) {
            String query = "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_POSITIVE + " INTEGER, " +
                    COLUMN_NEUTRAL + " INTEGER, " +
                    COLUMN_NEGATIVE + " INTEGER); ";
            db.execSQL(query);
            ContentValues cv=new ContentValues();
            cv.put(COLUMN_ID, 1);
            cv.put(COLUMN_POSITIVE, 0);
            cv.put(COLUMN_NEUTRAL, 0);
            cv.put(COLUMN_NEGATIVE, 0);
            db.insert(TABLE_NAME, null, cv);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }
    }
}