package org.launchcode.spaday.data;

import org.launchcode.spaday.models.User;

import java.util.ArrayList;

public class UserData {
    // add, getAll, and getById
    private static ArrayList<User> myUsers = new ArrayList<>();

    // add
    public static void addUser(User user) {
        myUsers.add(user);
    }
    // getALL
    public static ArrayList<User>getAll(){
        return myUsers;
    }

    // get ById
    public static User getById(int id) {
        for (User user : myUsers) {
            if (user.getId() == id) return user;
        }
        return null;
    }
}
