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

import java.util.List;

import headout.travelalarm.R;

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
