package com.github.jurassicspb.chatlevelup_11_10;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Мария on 01.11.2016.
 */

public class UserListFragment extends Fragment {
    private UserListAdapter adapter;
    UserListActivity activity;

    private OnListItemClickListener clickListener = (v, position) -> {
        Log.d(UserListAdapter.class.getSimpleName(), "Clicked pos: " + position);
        Toast.makeText(activity, "Clicked " + position, Toast.LENGTH_SHORT).show();
    };

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_list_example, container, false);

        ArrayList<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            users.add(new User(String.valueOf(i), "User " + i, "U"));
        }

        RecyclerView  recyclerView = (RecyclerView) v.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new UserListAdapter(users, clickListener);
        recyclerView.setAdapter(adapter);


        Log.d(UserListFragment.class.getSimpleName(), "onCreate");
        //v.findViewById()...
        return v;
    }
}
