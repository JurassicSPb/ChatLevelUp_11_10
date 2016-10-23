package com.github.jurassicspb.chatlevelup_11_10;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class ListExampleActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ListExampleAdapter adapter;
    private ArrayList<User> users;
    private Handler handler = new Handler();
    private boolean visible = false;

    private OnListItemClickListener clickListener = new OnListItemClickListener() {
        @Override
        public void onClick(View v, int position) {
            Log.d(ListExampleAdapter.class.getSimpleName(), "Clicked pos: " + position);
            Toast.makeText(ListExampleActivity.this, "Clicked " + position, Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_example);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        users = new ArrayList<>();
//		for (int i = 0; i < ; i++) {
//			users.add(new User("User " + i));
//		}

        adapter = new ListExampleAdapter(users, clickListener);
        recyclerView.setAdapter(adapter);
    }

    public void onListChanged(int position) {
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onStart() {
        super.onStart();
        visible = true;
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (visible) {
                    users.add(new User(("User " + users.size()), "Description", "U"));
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            onListChanged(users.size() - 1);
                        }
                    });
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    @Override
    protected void onStop() {
        visible = false;
        super.onStop();
    }
}
