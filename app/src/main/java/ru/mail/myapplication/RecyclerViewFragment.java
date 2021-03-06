package ru.mail.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewFragment extends Fragment implements NumberClicked {

    private MyAdapter adapter;
    private static Integer count;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.recycler, container, false);
        final RecyclerView recyclerView = view.findViewById(R.id.recycler);
        int spanCount = getResources().getInteger(R.integer.column_count);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), spanCount));
        if (count == null) {
            if (savedInstanceState != null) {
                count = savedInstanceState.getInt(MainActivity.COUNT);
            } else count = getResources().getInteger(R.integer.count);
        }
        adapter = new MyAdapter(this, count);
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
            outState.putInt(MainActivity.COUNT, count);
        }
    }

    @Override
    public View.OnClickListener onClicked(final int n, final int color) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putInt(MainActivity.POS, n);
                bundle.putInt(MainActivity.COLOR, color);
                NumberFragment nf = new NumberFragment();
                nf.setArguments(bundle);
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, nf)
                        .addToBackStack(null)
                        .commitAllowingStateLoss();
            }
        };
    }
}

