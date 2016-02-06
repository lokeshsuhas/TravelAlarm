package headout.travelalarm.Models;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import headout.travelalarm.Db.DB;
import rx.functions.Func1;

/**
 * Created by Lokesh on 07-02-2016.
 */

public class TravelAlarmBuilder {

    public static final String TABLE = "alarms";

    public static final String ID = "_id";
    public static final String START = "start";
    public static final String DEST = "dest";
    public static final String KMS = "kms";
    public static final String ETA = "eta";
    public static final String WAKEUPTYPE = "wakeuptype";


    public static Func1<Cursor, List<TravelAlarm>> MAP = new Func1<Cursor, List<TravelAlarm>>() {
        @Override
        public List<TravelAlarm> call(final Cursor cursor) {
            try {
                List<TravelAlarm> values = new ArrayList<>(cursor.getCount());

                while (cursor.moveToNext()) {
                    long id = DB.getLong(cursor, ID);
                    String start = DB.getString(cursor, START);
                    String dest = DB.getString(cursor, DEST);
                    int kms = DB.getInt(cursor, KMS);
                    int eta = DB.getInt(cursor, ETA);
                    int wakeType = DB.getInt(cursor,WAKEUPTYPE);
                    values.add(new TravelAlarm().setId(id).setStart(start).setDest(dest).setKms(kms).setETA(eta).setWakeUpType(wakeType));
                }
                return values;
            } finally {
                cursor.close();
            }
        }
    };

    public static final class Builder {
        private final ContentValues values = new ContentValues();

        public Builder id(long id) {
            values.put(ID, id);
            return this;
        }

        public Builder start(String start) {
            values.put(START, start);
            return this;
        }

        public Builder dest(String dest) {
            values.put(DEST, dest);
            return this;
        }

        public Builder kms(Integer kms) {
            values.put(KMS, kms);
            return this;
        }

        public Builder eta(Integer eta) {
            values.put(ETA, eta);
            return this;
        }

        public Builder wakeuptype(Integer wakeUpType) {
            values.put(WAKEUPTYPE, wakeUpType);
            return this;
        }

        public ContentValues build() {
            return values;
        }
    }
}
