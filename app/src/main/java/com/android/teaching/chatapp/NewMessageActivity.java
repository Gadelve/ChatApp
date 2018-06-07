package com.android.teaching.chatapp;

import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NewMessageActivity extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("message");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_message);

        Toolbar myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        /*FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        findViewById(R.id.texto2);
        myRef.setValue(R.id.texto2);

        findViewById(R.id.texto3);
        myRef.setValue(R.id.texto3);*/
    }

    private DatabaseReference mDatabase;

    {
        mDatabase = FirebaseDatabase.getInstance().getReference();
    }

    public void onEnviar(View view) {
        findViewById(R.id.texto2);
        findViewById(R.id.texto3);
        myRef.setValue(String.valueOf("Hola"));
        //myRef.setValue(String.valueOf("Hola"));
        //mDatabase.child(String.valueOf(R.id.texto2)).setValue(R.id.texto3);
    }
}
