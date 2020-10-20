package ru.mail.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewFragment extends Fragment {

    private MyAdapter adapter;
    private static Integer count;
    private static String COUNT = "count";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.recycler, container, false);
        final RecyclerView recyclerView = view.findViewById(R.id.recycler);
        int spanCount = getResources().getInteger(R.integer.column_count);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), spanCount));
        if (count == null) {
            if (savedInstanceState != null) {
                count = savedInstanceState.getInt(COUNT);
            } else count = getResources().getInteger(R.integer.count);
        }
        adapter = new MyAdapter(getActivity(), count);
        recyclerView.setAdapter(adapter);

        Button btn = view.findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.addItem();
            }
        });
        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
        count = adapter.getItemCount();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if (count != null) {
            outState.putInt(COUNT, count);
        }
    }
}
