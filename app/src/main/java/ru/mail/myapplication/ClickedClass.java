package ru.mail.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.FragmentActivity;

public class ClickedClass implements View.OnClickListener {

    private FragmentActivity act;
    private final int n;
    private final int color;

    public ClickedClass(Activity act, final int n, final int color) {
        this.act = (FragmentActivity) act;
        this.n = n;
        this.color = color;
    }

    @Override
    public void onClick(View v) {
        Bundle bundle = new Bundle();
        bundle.putInt(MainActivity.POS, n);
        bundle.putInt(MainActivity.COLOR, color);
        NumberFragment nf = new NumberFragment();
        nf.setArguments(bundle);
        act.getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, nf)
                .addToBackStack(null)
                .commitAllowingStateLoss();
    }
}

