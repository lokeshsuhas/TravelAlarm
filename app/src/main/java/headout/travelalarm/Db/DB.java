package headout.travelalarm.Db;

import android.database.Cursor;

/**
 * Created by Lokesh on 07-02-2016.
 */
public final class DB {
    public static final int BOOLEAN_FALSE = 0;
    public static final int BOOLEAN_TRUE = 1;

    public static String getString(Cursor cursor, String columnName) {
        return cursor.getString(cursor.getColumnIndexOrThrow(columnName));
    }

    public static boolean getBoolean(Cursor cursor, String columnName) {
        return getInt(cursor, columnName) == BOOLEAN_TRUE;
    }

    public static long getLong(Cursor cursor, String columnName) {
        return cursor.getLong(cursor.getColumnIndexOrThrow(columnName));
    }

    public static float getFloat(Cursor cursor,String columnName)
    {
        return cursor.getFloat(cursor.getColumnIndexOrThrow(columnName));
    }

    public static int getInt(Cursor cursor, String columnName) {
        return cursor.getInt(cursor.getColumnIndexOrThrow(columnName));
    }

    private DB() {
        throw new AssertionError("No instances.");
    }
}
