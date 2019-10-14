package edu.amrita.cleanupdrive.ui.locations;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import edu.amrita.cleanupdrive.R;
import edu.amrita.cleanupdrive.ui.customdialog.AddLocationDialogFragment;

public class LocationsFragment extends Fragment {

    private LocationsViewModel dashboardViewModel;
    private FloatingActionButton floatingActionButton;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(LocationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_locations, container, false);
        floatingActionButton = root.findViewById(R.id.fab_add_location);
        onFABClicked();
        return root;
    }

    private void onFABClicked() {
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getChildFragmentManager();
                AddLocationDialogFragment addLocationDialogFragment = new AddLocationDialogFragment();
                addLocationDialogFragment.show(fragmentManager, "add_location_dialog");
            }
        });
    }
}