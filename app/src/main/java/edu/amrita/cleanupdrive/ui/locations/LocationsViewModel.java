package edu.amrita.cleanupdrive.ui.locations;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import edu.amrita.cleanupdrive.roomdb.locationdb.Location;

public class LocationsViewModel extends ViewModel {

    private MutableLiveData<List<Location>> mLocationList;

    public LocationsViewModel() {
        mLocationList = new MutableLiveData<>();
    }

    public LiveData<List<Location>> getmLocationList() {
        return mLocationList;
    }

    public void setLocationList(List<Location> locationList) {
        mLocationList.setValue(locationList);
    }

    public void setLocation(Location location) {
        mLocationList.getValue().add(location);
    }
}