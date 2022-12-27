package com.dimowner.quranicmistakeshelper.app.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dimowner.quranicmistakeshelper.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class RecognizeTextAdapter extends RecyclerView.Adapter<RecognizeTextAdapter.ItemViewHolder> {
    private final ArrayList<RecognizeTextData> data;

    public RecognizeTextAdapter(ArrayList<RecognizeTextData> data) {
        this.data = data;
     //   Log.i("data================>",data.);
    }

    @NonNull
    @NotNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recogniation_text_row, viewGroup, false);
        return new RecognizeTextAdapter.ItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RecognizeTextAdapter.ItemViewHolder holder, int position) {
        holder.duration.setText("Start Time:"+data.get(position).getTime());
        holder.error.setText("Error Rate:"+data.get(position).getError());
        holder.word.setText("Word:"+data.get(position).getWord());
        holder.endTime.setText("End Time:" +data.get(position).getEndTime());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView word;
        TextView duration,endTime;
        TextView error;

        ItemViewHolder(View itemView) {
            super(itemView);
            word = itemView.findViewById(R.id.words);
            duration = itemView.findViewById(R.id.time);
            endTime = itemView.findViewById(R.id.timeEnd);
            error = itemView.findViewById(R.id.error);
        }
    }

}
