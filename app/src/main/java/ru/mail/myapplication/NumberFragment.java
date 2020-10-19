package ru.mail.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class NumberFragment extends Fragment {

    public TextView num;
    private int pos;
    private int color;

    public NumberFragment(int pos, int color) {
        this.pos = ++pos;
        this.color = color;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.big_number, container, false);
        num = view.findViewById(R.id.big_number);
        num.setText(String.valueOf(pos));
        num.setTextColor(color);
        return view;
    }
}