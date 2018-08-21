package com.example.ojonugwa.yfc;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class YfcAdapter  extends RecyclerView.Adapter<YfcAdapter.YfcViewHolder> {

    private int mNumberItems;

    public YfcAdapter(int numberOfItems) {
        mNumberItems = numberOfItems;
    }

    @NonNull
    @Override
    public YfcViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.member_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        YfcViewHolder viewHolder = new YfcViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull YfcViewHolder holder, int position) {
        holder.bind(position);

    }

    @Override
    public int getItemCount() {
        return mNumberItems;
    }

    class YfcViewHolder extends RecyclerView.ViewHolder {
        TextView mMemberName;
        TextView mMemberDepartment;
        TextView mMemberLevel;
        TextView mEntryDate;
        TextView mEntryTime;

        public YfcViewHolder(View itemView) {
            super(itemView);

            mMemberName = itemView.findViewById(R.id.member_name);
            mMemberDepartment = itemView.findViewById(R.id.member_department);
            mMemberLevel = itemView.findViewById(R.id.member_level);
            mEntryDate = itemView.findViewById(R.id.entry_date);
            mEntryTime = itemView.findViewById(R.id.entry_time);
        }

        void bind(int listIndex){

        }
    }

}
