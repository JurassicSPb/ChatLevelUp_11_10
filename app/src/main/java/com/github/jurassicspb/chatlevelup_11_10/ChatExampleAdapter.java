package com.github.jurassicspb.chatlevelup_11_10;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ChatExampleAdapter extends RecyclerView.Adapter<ChatExampleAdapter.ViewHolder> {
    private ArrayList<Chat> chats;
    private OnListItemClickListener clickListener;

    public ChatExampleAdapter(ArrayList<Chat> chats, OnListItemClickListener clickListener) {
        this.chats = chats;
        this.clickListener = clickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_list_example, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(chats.get(position));
    }

    @Override
    public int getItemCount() {
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
        }

        public void bind(Chat chat) {
            chat_avatar.setImageResource(R.drawable.circle);
            title.setText(chat.getTitle());
            last_message.setText(chat.getLastMessage());
            updated.setText(DateUtil.fromTs(chat.getUpdated()));
            chat_firstLetter.setText(chat.getFirstLetter());

        }

        @Override
        public void onClick(View v) {
            clickListener.onClick(v, getAdapterPosition());
        }
    }

}