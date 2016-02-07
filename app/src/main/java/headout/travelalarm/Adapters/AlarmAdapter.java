package headout.travelalarm.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import headout.travelalarm.Models.TravelAlarm;
import rx.functions.Action1;

/**
 * Created by Lokesh on 07-02-2016.
 */
public class AlarmAdapter extends BaseAdapter implements Action1<List<TravelAlarm>>
{
    private final LayoutInflater inflater;

    private List<TravelAlarm> items = Collections.emptyList();

    public AlarmAdapter(Context context) {
        this.inflater = LayoutInflater.from(context);
    }


    @Override public int getCount() {
        return items.size();
    }

    @Override public TravelAlarm getItem(int position) {
        return items.get(position);
    }

    @Override public long getItemId(int position) {
        return getItem(position).getId();
    }

    @Override public boolean hasStableIds() {
        return true;
    }

    @Override public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
        }

        TravelAlarm item = getItem(position);
        ((TextView) convertView).setText(item.getStart() + "," + item.getDest());

        return convertView;
    }

    @Override
    public void call(List<TravelAlarm> travelAlarms) {
        items = travelAlarms;
        notifyDataSetChanged();
    }
}
