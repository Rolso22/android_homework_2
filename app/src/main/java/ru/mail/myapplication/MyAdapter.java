package ru.mail.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private ArrayList<Integer> data;
    private FragmentManager fm;

    public MyAdapter(FragmentManager fragmentManager, int count) {
        data = new ArrayList<>();
        fm = fragmentManager;
        for (int i = 1; i < count + 1; i++) {
            data.add(i);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("MyAdapter", "onCreateViewHolder");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.number, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        Log.d("MyAdapter", "onBindViewHolder with position " + position);
        int number = data.get(position);
        holder.num.setText(String.valueOf(number));
        final int color = (number % 2 == 0) ? Color.RED : Color.BLUE;
        holder.num.setTextColor(color);
        holder.num.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putInt("pos", position + 1);
                bundle.putInt("color", color);
                NumberFragment nf = new NumberFragment();
                nf.setArguments(bundle);
                fm.beginTransaction()
                        .replace(R.id.container, nf)
                        .addToBackStack(null)
                        .commitAllowingStateLoss();
            }
        });
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
