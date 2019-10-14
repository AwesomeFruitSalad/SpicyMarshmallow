package edu.amrita.cleanupdrive.ui.locationmap;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LocationMapViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public LocationMapViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}