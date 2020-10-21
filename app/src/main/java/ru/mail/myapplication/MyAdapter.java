package ru.mail.myapplication;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private ArrayList<Integer> data;
    private ClickedClass click;

    public MyAdapter(Activity act, int count) {
        data = new ArrayList<>();
        for (int i = 1; i < count + 1; i++) {
            data.add(i);
        }
        click = new ClickedClass(act);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.number, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

        int number = data.get(position);
        holder.num.setText(String.valueOf(number));
        final int color = (number % 2 == 0) ? Color.RED : Color.BLUE;
        holder.num.setTextColor(color);
        holder.num.setOnClickListener(click.onNumberClicked(position + 1, color));
    }

    public void addItem() {
        data.add(data.size() + 1);
        this.notifyItemInserted(data.size());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
