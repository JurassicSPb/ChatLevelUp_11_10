package com.github.jurassicspb.chatlevelup_11_10;


import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class ChatExampleAdapter extends RecyclerView.Adapter<ChatExampleAdapter.ViewHolder> {
    private ArrayList<Chat> chats;
    private OnListItemClickListener clickListener;

    public ChatExampleAdapter(ArrayList<Chat> chats, OnListItemClickListener clickListener) {
        this.chats = chats;
        this.clickListener = clickListener;
        Log.d(ChatExampleAdapter.class.getSimpleName(), "ChatExampleAdapter constructor");
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(ChatExampleAdapter.class.getSimpleName(), "onCreateViewHolder");
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_list_example, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(chats.get(position));
        Log.d(ChatExampleAdapter.class.getSimpleName(), "onBindViewHolder");
    }

    @Override
    public int getItemCount() {
        Log.d(ChatExampleAdapter.class.getSimpleName(), "getItemCount");
        return chats.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView chat_avatar;
        TextView title;
        TextView last_message;
        TextView updated;
        TextView chat_firstLetter;

        public ViewHolder(View itemView) {
            super(itemView);
            chat_avatar = (ImageView) itemView.findViewById(R.id.chat_avatar);
            title = (TextView) itemView.findViewById(R.id.title);
            last_message = (TextView) itemView.findViewById(R.id.last_message);
            updated = (TextView) itemView.findViewById(R.id.updated);
            chat_firstLetter = (TextView) itemView.findViewById(R.id.chat_firstLetter);
            itemView.setOnClickListener(this);
            Log.d(ChatExampleAdapter.class.getSimpleName(), "ViewHolder constructor");
        }


        public void bind(Chat chat) {
            chat_avatar.setImageResource(R.drawable.circle);
            title.setText(chat.getTitle());
            last_message.setText(chat.getLastMessage());
            updated.setText(DateUtil.fromTs(chat.getUpdated()));
            chat_firstLetter.setText(chat.getFirstLetter());
            Log.d(ChatExampleAdapter.class.getSimpleName(), "bind");

        }

        @Override
        public void onClick(View v) {
            clickListener.onClick(v, getAdapterPosition());
            Log.d(ChatExampleAdapter.class.getSimpleName(), "onClick");
        }
    }

}