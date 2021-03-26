package com.example.qrcodedoubletoch;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Intent intent;
    final int REQUEST_CODE_QrSCREEN = 1;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(1);

        LinearLayout layout = (LinearLayout)findViewById(R.id.layOut);

        layout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(getApplicationContext(), "Ok", Toast.LENGTH_SHORT).show();
                intent = new Intent(getApplicationContext(), QrReaderScreen.class);
                startActivityForResult(intent, REQUEST_CODE_QrSCREEN);
                return false;
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(getApplicationContext(), "Good", Toast.LENGTH_SHORT).show();
        tv = (TextView) findViewById(R.id.link);
        String link = data.getStringExtra("link");
        tv.setText(link);
    }
}