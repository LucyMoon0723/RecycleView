package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private ArrayList<RecyclerViewItem> mData = null;

    public RecyclerViewAdapter(ArrayList<RecyclerViewItem> data) {
        mData = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.recycler_item, parent, false);
        RecyclerViewAdapter.ViewHolder vh = new RecyclerViewAdapter.ViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(mData == null) {
            return;
        }
        RecyclerViewItem item = mData.get(position);
        holder.imageView.setBackground(item.getIconDrawable());
        holder.mainText.setText(item.getMainTitle());
        holder.subText.setText(item.getSubTitle());
        holder.count.setText(item.getcount());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView mainText;
        TextView subText;
        TextView count;
        String[] countNum = {"0","0","0","0","0"};

        public String Change(int Num){
            String NUMSTRING = String.valueOf(Num);
            return NUMSTRING;
        }

        ViewHolder(View itemView) {
            super(itemView);
            itemView.findViewById(R.id.icon_cnt_P).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition() ;
                    int NUM = Integer.parseInt(countNum[pos]);
                    if (pos != RecyclerView.NO_POSITION) {
                        if(NUM!=0){
                            NUM++;
                            Change(NUM);
                            count.setText(NUM);
                        }


                        notifyItemChanged(pos) ;
                    }
                }
            });

            imageView = itemView.findViewById(R.id.item_image);
            mainText = itemView.findViewById(R.id.icon_main_text);
            subText = itemView.findViewById(R.id.icon_sub_text);
            count = itemView.findViewById(R.id.cnt);
        }
    }
}