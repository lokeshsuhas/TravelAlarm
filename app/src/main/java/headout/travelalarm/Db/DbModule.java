package headout.travelalarm.Db;

import android.app.Application;
import android.database.sqlite.SQLiteOpenHelper;

import com.squareup.sqlbrite.BriteDatabase;
import com.squareup.sqlbrite.SqlBrite;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
/**
 * Created by Lokesh on 07-02-2016.
 */
@Module(complete = false, library = true)
public final class DbModule {
    @Provides @Singleton
    SQLiteOpenHelper provideOpenHelper(Application application) {
        return new DbOpenHelper(application);
    }

    @Provides @Singleton SqlBrite provideSqlBrite() {
        return SqlBrite.create(new SqlBrite.Logger() {
            @Override public void log(String message) {
            }
        });
    }

    @Provides @Singleton
    BriteDatabase provideDatabase(SqlBrite sqlBrite, SQLiteOpenHelper helper) {
        BriteDatabase db = sqlBrite.wrapDatabaseHelper(helper);
        db.setLoggingEnabled(true);
        return db;
    }
}
