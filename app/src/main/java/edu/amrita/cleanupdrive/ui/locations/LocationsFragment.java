package edu.amrita.cleanupdrive.ui.locations;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import edu.amrita.cleanupdrive.R;
import edu.amrita.cleanupdrive.ui.customdialog.AddLocationDialogFragment;

public class LocationsFragment extends Fragment {

    private LocationsViewModel dashboardViewModel;
    private FloatingActionButton floatingActionButton;
    private RecyclerView locationsRecyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(LocationsViewModel.class);

        View root = inflater.inflate(R.layout.fragment_locations, container, false);
        floatingActionButton = root.findViewById(R.id.fab_add_location);
        locationsRecyclerView = root.findViewById(R.id.recycler_locations);

        onFABClicked();
        return root;
    }

    private void onFABClicked() {
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getChildFragmentManager();
                AddLocationDialogFragment addLocationDialogFragment = new AddLocationDialogFragment();
                addLocationDialogFragment.setDialogListener(new AddLocationDialogFragment.DialogListener() {
                    @Override
                    public void onFinishEditLocation(String longitude, String latitude) {
                        Log.i("LOCATION FRAGMENT", longitude + " " + latitude);
                    }
                });
                addLocationDialogFragment.show(fragmentManager, "add_location_dialog");
            }
        });
    }
}