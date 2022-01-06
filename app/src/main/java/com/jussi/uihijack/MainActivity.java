package com.jussi.uihijack;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Intent intent = new Intent(MainActivity.this, HijackingService.class);

        findViewById(R.id.start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService(intent);
                finish();
            }
        });

        findViewById(R.id.stop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopService(intent);
            }
        });
    }

}