package headout.travelalarm.Services;

import android.app.Service;
import android.content.Intent;
import android.location.Location;
import android.os.IBinder;
import android.os.SystemClock;

import com.google.android.gms.location.LocationRequest;

import pl.charmas.android.reactivelocation.ReactiveLocationProvider;
import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by Lokesh on 07-02-2016.
 */
public class AlarmKMService extends Service {
    Subscription subscription;
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        LocationRequest request = LocationRequest.create() //standard GMS LocationRequest
                .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
                .setNumUpdates(5)
                .setInterval(100);

        ReactiveLocationProvider locationProvider = new ReactiveLocationProvider(getApplicationContext());
        subscription = locationProvider.getUpdatedLocation(request)
                .subscribe(new Action1<Location>() {
                    @Override
                    public void call(Location location) {

                    }
                });

        return START_NOT_STICKY;
    }


}
