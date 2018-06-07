package com.android.teaching.chatapp;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class FirebaseInteractor {

    private ArrayList<MessageModel> messages = new ArrayList<>();

    public void getMessages(final MessageInteractor callback) {
        // 1- Llamar a Firebase
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myReference = firebaseDatabase.getReference("messages");
        myReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // 2- Obtener la lista de GameModel
                for(DataSnapshot nodoJuego : dataSnapshot.getChildren()) {
                    MessageModel model = nodoJuego.getValue(MessageModel.class);
                    Log.d("Firebase Interactor", "Game: " + model.getName());
                    messages.add(model);
                }
                // 3- Notificar a callback.onGamesAvailable()
                callback.onMessagesAvailable();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    //public static ArrayList<MessageModel> getMessages() {
        //return messages;
    //}

    public MessageModel getMessageWithId(int id) {
        for (MessageModel message: messages) {
            if (message.getId() == id) {
                return message;
            }
        }
        return null;
    }
}

