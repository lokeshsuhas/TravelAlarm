package headout.travelalarm.fragments;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.gc.materialdesign.views.ButtonFlat;
import com.gc.materialdesign.views.CheckBox;
import com.google.android.gms.maps.model.LatLng;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.squareup.sqlbrite.BriteDatabase;

import java.util.List;

import javax.inject.Inject;

import headout.travelalarm.Models.TravelAlarmBuilder;
import headout.travelalarm.R;
import headout.travelalarm.Util;

/**
 * Created by Lokesh on 07-02-2016.
 */
public class AlarmDetailFragment extends DialogFragment implements Validator.ValidationListener {
    View view;
    private Validator validator;
    CheckBox wakeDistance;
    CheckBox wakeTime;
    Context context;
    ButtonFlat cancelOrder;
    ButtonFlat okOrder;
    LinearLayout innercontentBox;
    LinearLayout thankyouBox;
    LinearLayout controlBox;
    @Inject
    BriteDatabase db;
    boolean isDone = false;
    String start;
    String dest;
    int eta;
    int kms;
    public static AlarmDetailFragment newInstance() {
        AlarmDetailFragment fragment = new AlarmDetailFragment();
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        validator = new Validator(this);
        validator.setValidationListener(this);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);

        // request a window without the title
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        return dialog;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.layout_alarm, container, false);
        context = this.getActivity();
        cancelOrder = (ButtonFlat) view.findViewById(R.id.cancelOrder);
        okOrder = (ButtonFlat) view.findViewById(R.id.okOrder);
        wakeDistance = (CheckBox) view.findViewById(R.id.wakeDistance);
        wakeTime = (CheckBox) view.findViewById(R.id.wakeTime);
        innercontentBox = (LinearLayout) view.findViewById(R.id.innerBox);
        thankyouBox = (LinearLayout) view.findViewById(R.id.thankyoucontentBox);
        controlBox = (LinearLayout) view.findViewById(R.id.controlBox);
        wakeDistance.setOncheckListener(new CheckBox.OnCheckListener() {
            @Override
            public void onCheck(boolean check) {
                wakeTime.setChecked(!check);
            }
        });

        wakeTime.setOncheckListener(new CheckBox.OnCheckListener() {
            @Override
            public void onCheck(boolean check) {
                wakeDistance.setChecked(!check);
            }
        });

        okOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isDone) {
                    db.insert(TravelAlarmBuilder.TABLE, new TravelAlarmBuilder.Builder().id(Util.Operations.getRandomLong()).start(start).dest(dest).eta(eta).kms(kms).build());
                    innercontentBox.setVisibility(View.GONE);
                    thankyouBox.setVisibility(View.VISIBLE);
                    cancelOrder.setVisibility(View.GONE);
                }
                else {
                    dismiss();
                }

            }
        });

        cancelOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        return view;
    }

    @Override
    public void onValidationSucceeded() {

    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {

    }
}
