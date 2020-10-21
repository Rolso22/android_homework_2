package ru.mail.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.FragmentActivity;

public class ClickedClass {

    private FragmentActivity act;

    public ClickedClass(Activity act) {
        this.act = (FragmentActivity) act;
    }

    public View.OnClickListener onNumberClicked(final int n, final int color) {
        return new View.OnClickListener() {
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
        };
    }
}
