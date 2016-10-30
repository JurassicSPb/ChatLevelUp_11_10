package com.github.jurassicspb.chatlevelup_11_10;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MessageExampleActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Button send;
    private MessageExampleAdapter adapter;
    private ArrayList<Message> messages;
    private Handler handler = new Handler();
    private boolean visible = false;

    private OnListItemClickListener clickListener = new OnListItemClickListener() {
        @Override
        public void onClick(View v, int position) {
            Log.d(ChatExampleAdapter.class.getSimpleName(), "Clicked pos: " + position);
            Toast.makeText(MessageExampleActivity.this, "Clicked " + position, Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_list_example);
        Log.d(MessageExampleActivity.class.getSimpleName(), "onCreate");
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        send = (Button) findViewById(R.id.send);

        messages = new ArrayList<>();
//		for (int i = 0; i < ; i++) {
//			users.add(new User("User " + i));
//		}

        adapter = new MessageExampleAdapter(messages, clickListener);
        recyclerView.setAdapter(adapter);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    public void onListChanged(int position) {
        adapter.notifyDataSetChanged();
        Log.d(MessageExampleActivity.class.getSimpleName(), "onListChanged");
    }


    @Override
    protected void onStart() {
        super.onStart();
        visible = true;
        new Thread(() -> {
            while (visible) {
                messages.add(new Message(""));
                handler.post(() -> onListChanged(messages.size() - 1));
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        Log.d(MessageExampleActivity.class.getSimpleName(), "onStart");
    }

    @Override
    protected void onStop() {
        visible = false;
        super.onStop();
        Log.d(MessageExampleActivity.class.getSimpleName(), "onStop");
    }
}
