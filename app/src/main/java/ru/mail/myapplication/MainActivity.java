package ru.mail.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private static String POS = "pos";
    private static String COLOR = "color";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportFragmentManager().findFragmentById(R.id.container) == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, new RecyclerViewFragment())
                    .addToBackStack(null)
                    .commitAllowingStateLoss();
        }
    }

    public void onNumberClicked(int n, int color) {
        Bundle bundle = new Bundle();
        bundle.putInt(POS, n);
        bundle.putInt(COLOR, color);
        NumberFragment nf = new NumberFragment();
        nf.setArguments(bundle);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, nf)
                .addToBackStack(null)
                .commitAllowingStateLoss();
    }
}