package ru.mail.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

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
}