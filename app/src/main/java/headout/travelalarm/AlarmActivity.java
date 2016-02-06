package headout.travelalarm;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.squareup.sqlbrite.BriteDatabase;
import com.squareup.sqlbrite.SqlBrite;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import de.greenrobot.event.EventBus;
import headout.travelalarm.Adapters.AlarmAdapter;
import headout.travelalarm.Db.DbOpenHelper;
import headout.travelalarm.Models.TravelAlarm;
import headout.travelalarm.Models.TravelAlarmBuilder;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class AlarmActivity extends AppCompatActivity {

    private static final String LIST_QUERY = "SELECT * FROM "
            + TravelAlarmBuilder.TABLE;
    Context context;
    @Inject
    BriteDatabase db;
    @InjectView(R.id.listView)
    ListView listView;
    @InjectView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @InjectView(R.id.toolbar)
    Toolbar toolBar;
    @InjectView(R.id.addAlarm)
    FloatingActionButton addAlarm;
    @InjectView(R.id.empty)
    ImageView empty;
    AlarmAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        ButterKnife.inject(this);
        context = this;
        adapter = new AlarmAdapter(this);
        SqlBrite sqlBrite = SqlBrite.create(new SqlBrite.Logger() {
            @Override public void log(String message) {
            }
        });
        db = sqlBrite.wrapDatabaseHelper(new DbOpenHelper(this));
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        setSupportActionBar(toolBar);
        listView.setEmptyView(empty);
        listView.setAdapter(adapter);
        db.createQuery(TravelAlarmBuilder.TABLE, LIST_QUERY)
                .mapToList(TravelAlarmBuilder.MAP)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(adapter);

        addAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context,AddAlarmActivity.class));
            }
        });
    }

}
