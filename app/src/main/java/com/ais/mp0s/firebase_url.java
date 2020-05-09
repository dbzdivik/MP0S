package com.ais.mp0s;

import com.google.firebase.database.FirebaseDatabase;

public class firebase_url {

    private static FirebaseDatabase firebaseDatabase;

    public static FirebaseDatabase getDatabase() {
        if (firebaseDatabase == null) {
            firebaseDatabase = FirebaseDatabase.getInstance();
            firebaseDatabase.setPersistenceEnabled(true);
        }
        return firebaseDatabase;
    }
}