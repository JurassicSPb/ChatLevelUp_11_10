package com.github.jurassicspb.chatlevelup_11_10;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class ListExampleActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ListExampleAdapter adapter;
    private ArrayList<User> users;
    private Handler handler = new Handler();
    private boolean visible = false;

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

        adapter = new ListExampleAdapter(users);
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
                    users.add(new User(("User " + users.size()), "Description"));
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
