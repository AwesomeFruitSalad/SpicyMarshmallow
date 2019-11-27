package edu.amrita.cleanupdrive.ui.locations;

import android.content.Context;

import androidx.room.Room;

import edu.amrita.cleanupdrive.roomdb.userdb.UserRoomDatabase;

public class LocationsRepository {

    private static LocationsRepository locationsRepository;
    private UserRoomDatabase userRoomDatabase;

    private LocationsRepository(Context context) {
        userRoomDatabase = Room.databaseBuilder(context, UserRoomDatabase.class, "Locations")
                .build();
    }

    public LocationsRepository getLocationsRepository(Context context) {
        if (locationsRepository == null) {
            locationsRepository = new LocationsRepository(context);
        }
        return locationsRepository;
    }

}
