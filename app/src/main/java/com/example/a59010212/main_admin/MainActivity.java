package com.example.a59010212.main_admin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AlertAdapter adapter;
    private List<Alert> alertList;
    private FirebaseAuth auth;
    private FirebaseUser currentUser;
    private DatabaseReference db,childRef;

    DatabaseReference dbAlert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        alertList = new ArrayList<>();
        adapter = new AlertAdapter(this, alertList);
        recyclerView.setAdapter(adapter);

        auth = FirebaseAuth.getInstance();
        currentUser = auth.getCurrentUser();
        db = FirebaseDatabase.getInstance().getReference();
        childRef = db.child(currentUser.getUid());

        dbAlert = FirebaseDatabase.getInstance().getReference(currentUser.getUid());

    }
}
