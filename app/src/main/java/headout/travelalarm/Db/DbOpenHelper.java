package headout.travelalarm.Db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Lokesh on 07-02-2016.
 */
public class DbOpenHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;

    private static final String CREATE_ALARMS = ""
            + "CREATE TABLE alarms( _id INTEGER NOT NULL PRIMARY KEY,start FLOAT NOT NULL,dest FLOAT NOT NULL,kms FLOAT NOT NULL DEFAULT 0,eta INTEGER NOT NULL,wakeuptype INTEGER NOT NULL DEFAULT 0)";

    public DbOpenHelper(Context context) {
        super(context, "travelalarm.db", null, VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_ALARMS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
