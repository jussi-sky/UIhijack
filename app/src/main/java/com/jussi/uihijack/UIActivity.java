package com.jussi.uihijack;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.Nullable;

public class UIActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_layout);
    }
}
