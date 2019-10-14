package edu.amrita.cleanupdrive.ui.customdialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import edu.amrita.cleanupdrive.R;

public class AddLocationDialogFragment extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        final LayoutInflater inflater = requireActivity().getLayoutInflater();

        final View dialogView = inflater.inflate(R.layout.add_location_dialog, null);

        builder.setView(dialogView)
                .setPositiveButton("Done", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        DialogListener listener = (DialogListener) getActivity();

                        EditText latitude = dialogView.findViewById(R.id.et_latitude);
                        EditText longitude = dialogView.findViewById(R.id.et_longitude);

                        listener.onFinishEditFruit(latitude.getText().toString());
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                })
                .setNeutralButton("Get Current Location", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO: Get user's current location
                    }
                });
        return builder.create();
    }


    public interface DialogListener {
        void onFinishEditFruit(String inputText);
    }
}
