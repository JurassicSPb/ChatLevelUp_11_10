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
import java.util.Collections;
import java.util.Comparator;

public class ChatExampleActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ChatExampleAdapter adapter;
    private ArrayList<Chat> chats;
    private Handler handler = new Handler();
    private boolean visible = false;

    private OnListItemClickListener clickListener = new OnListItemClickListener() {
        @Override
        public void onClick(View v, int position) {
            Log.d(ChatExampleAdapter.class.getSimpleName(), "Clicked pos: " + position);
            Toast.makeText(ChatExampleActivity.this, "Clicked " + position, Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_example);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        chats = new ArrayList<>();
//		for (int i = 0; i < ; i++) {
//			users.add(new User("User " + i));
//		}

        adapter = new ChatExampleAdapter(chats, clickListener);
        recyclerView.setAdapter(adapter);
        Log.d(ChatExampleActivity.class.getSimpleName(), "onCreate");
    }

    public void onListChanged(int position) {
        adapter.notifyDataSetChanged();
        Log.d(ChatExampleActivity.class.getSimpleName(), "onListChanged");
    }

    @Override
    protected void onStart() {
        super.onStart();
        visible = true;
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (visible) {
                    chats.add(new Chat(("Title " + chats.size()), "Last Message", "T"));
                    Collections.sort(chats);
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            onListChanged(chats.size() - 1);
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
        Log.d(ChatExampleActivity.class.getSimpleName(), "onStart");
    }

    @Override
    protected void onStop() {
        visible = false;
        super.onStop();
        Log.d(ChatExampleActivity.class.getSimpleName(), "onStop");
    }
}
