package com.ais.mp0s;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseListOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

public class c_product_main extends AppCompatActivity {

    private DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_product_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        databaseReference = firebase_url.getDatabase().getReference("product_main");
        fetch_items();
    }

    private void fetch_items() {
        try {
            ListView listView_items = findViewById(R.id.c_product_main_listView);
            Query query = databaseReference.orderByChild("product_main_mrp");
            FirebaseListOptions<firebase_product_main> firebaseListOptions = new FirebaseListOptions.
                    Builder<firebase_product_main>().setQuery(query, firebase_product_main.class).
                    setLayout(android.R.layout.two_line_list_item).setLifecycleOwner(this).build();
            FirebaseListAdapter<firebase_product_main> firebaseListAdapter =
                    new FirebaseListAdapter<firebase_product_main>(firebaseListOptions) {
                        @SuppressLint("SetTextI18n")
                        @Override
                        protected void populateView(@NonNull View v, @NonNull firebase_product_main model, int position) {
                            ((TextView) v.findViewById(android.R.id.text1)).setText(model.getProduct_main_name());
                            ((TextView) v.findViewById(android.R.id.text2)).setText(model.getProduct_main_mrp().toString());
                        }
                    };
            listView_items.setAdapter(firebaseListAdapter);
        } catch (Exception e) {
            Log.e("Error", e.toString());
        }
    }
}