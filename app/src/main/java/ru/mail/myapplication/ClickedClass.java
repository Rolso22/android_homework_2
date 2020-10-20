package ru.mail.myapplication;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

public class ClickedClass {

    private static String POS = "pos";
    private static String COLOR = "color";
    private FragmentActivity act;

    public ClickedClass(Activity act) {
        this.act = (FragmentActivity)act;
    }

    public void onNumberClicked(int n, int color) {
        Bundle bundle = new Bundle();
        bundle.putInt(POS, n);
        bundle.putInt(COLOR, color);
        NumberFragment nf = new NumberFragment();
        nf.setArguments(bundle);
        act.getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, nf)
                .addToBackStack(null)
                .commitAllowingStateLoss();
    }
}
