package com.vahidglngy.testproject.ui.fragment.second.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vahidglngy.testproject.R;
import com.vahidglngy.testproject.utl.EventBus.AdapterModel;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

/**
 * Created by vahidglngy on 10/6/18.
 */

public class RndomAdapter extends RecyclerView.Adapter<RndomAdapter.ViewHolder> {

    private ArrayList<String> items;

    public RndomAdapter(ArrayList<String> list){
        this.items = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_andomnumebradapter,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.mItemValue.setText(items.get(position));




    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView mItemValue;

        public ViewHolder(View itemView) {
            super(itemView);

            mItemValue = itemView.findViewById(R.id.textview_randomadapter_value);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (getAdapterPosition() == 0) {
                        EventBus.getDefault().post(new AdapterModel(true));
                    }
                }
            });
        }
    }

}
