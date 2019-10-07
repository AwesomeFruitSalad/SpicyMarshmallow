package edu.amrita.cleanupdrive.utility;

import java.util.ArrayList;

import edu.amrita.cleanupdrive.roomdb.User;

public class MockData {

    private static final ArrayList<User> users = new ArrayList<User>() {{
        add(new User("admin", "root"));
        add(new User("watermelon", "watermelon1234"));
    }};

    public static ArrayList<User> getUsers() {
        return users;
    }

}
