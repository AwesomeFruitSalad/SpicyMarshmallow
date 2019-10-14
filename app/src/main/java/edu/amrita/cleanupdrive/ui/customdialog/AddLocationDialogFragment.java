package edu.amrita.cleanupdrive.ui.customdialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import edu.amrita.cleanupdrive.R;
import edu.amrita.cleanupdrive.services.GpsLocationTracker;

public class AddLocationDialogFragment extends DialogFragment {

    private EditText latitude;
    private EditText longitude;
    private DialogListener dialogListener;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        final LayoutInflater inflater = requireActivity().getLayoutInflater();

        final View dialogView = inflater.inflate(R.layout.add_location_dialog, null);

        latitude = dialogView.findViewById(R.id.et_latitude);
        longitude = dialogView.findViewById(R.id.et_longitude);

        builder.setView(dialogView)
                .setPositiveButton("Done", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (!longitude.getText().toString().equals("") && !latitude.getText().toString().equals("")) {
                            dialogListener.onFinishEditLocation(latitude.getText().toString(), longitude.getText().toString());
                            Log.i("FIELD LATITUDE", latitude.getText().toString());
                            Log.i("FIELD LONGITUDE", longitude.getText().toString());
                        } else {
                            Log.e("LOCATION LOG", "Unable to get location");
                        }
                        dialogInterface.dismiss();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .setNeutralButton("Get Current Location", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Placeholder method; business logic is handled in onStart()
                    }
                })
        .setCancelable(false);
        return builder.create();
    }


    @Override
    public void onStart() {
        super.onStart();
        AlertDialog dialog = (AlertDialog) getDialog();
        if (dialog != null) {
            Button neutralButton = dialog.getButton(Dialog.BUTTON_NEUTRAL);
            neutralButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    GpsLocationTracker mGpsLocationTracker = new GpsLocationTracker(getActivity().getBaseContext());
                    /**
                     * Set GPS Location fetched address
                     */
                    if (mGpsLocationTracker.canGetLocation()) {
                        latitude.setText(String.valueOf(mGpsLocationTracker.getLatitude()));
                        longitude.setText(String.valueOf(mGpsLocationTracker.getLongitude()));
                        Log.i("LATITUDE", latitude.getText().toString());
                        Log.i("LONGITUDE", longitude.getText().toString());
                    }
                }
            });
        }
    }

    public void setDialogListener(DialogListener dialogListener) {
        this.dialogListener = dialogListener;
    }

    public interface DialogListener {
        void onFinishEditLocation(String longitude, String latitude);
    }
}
