package com.github.jurassicspb.chatlevelup_11_10;


import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MessageExampleAdapter extends RecyclerView.Adapter<MessageExampleAdapter.ViewHolder> {
    private ArrayList<Message> messages;
    private OnListItemClickListener clickListener;

    public MessageExampleAdapter(ArrayList<Message> messages, OnListItemClickListener clickListener) {
        this.messages = messages;
        this.clickListener = clickListener;
        Log.d(MessageExampleAdapter.class.getSimpleName(), "ChatExampleAdapter constructor");
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        if (viewType == 0) {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_bubble_list, parent, false);
        } else {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.buddy_bubble, parent, false);
        }
        return new ViewHolder(v);
    }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            int type = getItemViewType(position);
            if (type==0){
                holder.bind(messages.get(position));
            }
            else {
                holder.bind2(messages.get(position));
            }
        }

    @Override
    public int getItemCount() {
        Log.d(MessageExampleAdapter.class.getSimpleName(), "getItemCount");
        return messages.size();
    }
    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return 0;
        }
        return 1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView created;
        TextView myself;
        TextView buddy;

        public ViewHolder(View itemView) {
            super(itemView);
            myself = (TextView) itemView.findViewById(R.id.myself);
            buddy = (TextView) itemView.findViewById(R.id.buddy);
            created = (TextView) itemView.findViewById(R.id.created);
            itemView.setOnClickListener(this);
            Log.d(MessageExampleAdapter.class.getSimpleName(), "ViewHolder constructor");
        }


        public void bind(Message message) {
            myself.setText("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
            created.setText(DateUtil.fromTs(message.getCreated()));

        }
        public void bind2 (Message message) {
            buddy.setText("bbbbbbb");
            created.setText(DateUtil.fromTs(message.getCreated()));

        }

        @Override
        public void onClick(View v) {
            clickListener.onClick(v, getAdapterPosition());
            Log.d(MessageExampleAdapter.class.getSimpleName(), "onClick");
        }
    }

}