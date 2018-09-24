package com.github.jurassicspb.chatlevelup_11_10;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Toast;

import com.github.jurassicspb.chatlevelup_11_10.storage.UserDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import io.realm.Realm;
import io.realm.Sort;

public class UserListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private UserListAdapter adapter;
    private List<User> users;
    private Handler handler = new Handler();
    private boolean visible = false;
    private UserDatabase userDB;

    private OnListItemClickListener clickListener = (v, position) -> {
        Log.d(UserListAdapter.class.getSimpleName(), "Clicked pos: " + position);
        Toast.makeText(UserListActivity.this, "Clicked " + position, Toast.LENGTH_SHORT).show();
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_example);
        userDB = new UserDatabase();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        toolbar.setNavigationOnClickListener(v -> onBackPressed());
        getSupportActionBar().setTitle("Title");

        createFakeUsers();

        performUsers();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new UserListAdapter(users, clickListener);
        recyclerView.setAdapter(adapter);
        Log.d(UserListActivity.class.getSimpleName(), "onCreate");
    }

    private  void createFakeUsers(){
        ArrayList<User> newUsers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            newUsers.add(new User(String.valueOf(i), "User " + i, "U"));
        }
        userDB.copyOrUpdate(newUsers);
//		new UserDatabase()
//				.beginTransaction()
//				.add(...)
//				.delete(...)
//				.commit()
//				.close();
    }
    private void performUsers(){
        users = userDB.getAll();
        userDB.addChangeListener(element -> {
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        });

    }

    public void onListChanged(int position) {
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onStart() {
        super.onStart();
        visible = true;
        Log.d(UserListActivity.class.getSimpleName(), "onStart");
        new Thread(() -> {
            UserDatabase secondRealmInstance = new UserDatabase();
            while (visible) {
                secondRealmInstance.copyOrUpdate(new User(UUID.randomUUID().toString(),
                        ("User " + (int) (Math.random() * 1000)), "U"));
//					users.get(0); //ОШИБКА
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            secondRealmInstance.close();
        }).start();
    }

    @Override
    protected void onStop() {
        visible = false;
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        userDB.close();
    }
}
