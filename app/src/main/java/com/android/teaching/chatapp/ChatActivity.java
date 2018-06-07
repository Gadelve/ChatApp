package com.android.teaching.chatapp;

import android.app.ListActivity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class ChatActivity extends AppCompatActivity {

    private MyAdapter myAdapter;
    private ListView listView;
    //private FirebaseInteractor firebaseInteractor;
    //private MyConnectivityReceiver myConnectivityReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        Toolbar myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int identificador = item.getItemId();
        switch (identificador) {
            case R.id.añadir:
                Intent intent = new Intent(this, NewMessageActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }


  /*  public class MyAdapter extends BaseAdapter {
        private Context context; //context
        private ArrayList<Item> items; //data source of the list adapter

            public void onMessages() {
                myAdapter = new MyAdapter();
                listView.setAdapter(myAdapter);
            }
        });
*/
  private class MyAdapter extends BaseAdapter {


      @Override
      public int getCount() {
          return 3; //FirebaseInteractor.getMessages().size();
      }

      @Override
      public Object getItem(int position) {
          return null;
      }

      @Override
      public long getItemId(int position) {
          return 0;
      }

      @Override
      public View getView(int position, View convertView, ViewGroup parent) {
          LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
          View rowView = inflater.inflate(R.layout.list_item, parent, false);

         /* TextView textview = rowView.findViewById(R.id.texto2);
           Glide.with(ChatActivity.this).load(FirebaseInteractor.getMessages().get(position));
          //incon.setImageResource(gameicons.get(position));

          TextView textView = rowView.findViewById(R.id.texto3);
          textView.setText(FirebaseInteractor.getMessages().get(position).getName());
*/
          return rowView;
      }
  }

}

