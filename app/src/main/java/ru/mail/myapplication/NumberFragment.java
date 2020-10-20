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

    private TextView num;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.big_number, container, false);
        num = view.findViewById(R.id.big_number);
        Bundle bundle = getArguments();
        num.setText(String.valueOf(bundle.getInt("pos")));
        num.setTextColor(bundle.getInt("color"));
        return view;
    }
}