package com.frabbi.myfirst;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private Button saveBtn;
    private TextView statusText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editTextFId);
        saveBtn = findViewById(R.id.saveBtnId);
        statusText = findViewById(R.id.statusTextId);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
            }
        });
    }

    private void saveData() {
        File file = null;
        FileOutputStream fileOutputStream = null;
        file = getFilesDir();
        try {
            fileOutputStream = openFileOutput("save.txt", Context.MODE_PRIVATE);
            fileOutputStream.write(editText.getText().toString().getBytes());
            statusText.setTextColor(Color.GREEN);
            statusText.setText("Data Save!! to "+file.getAbsolutePath());
        } catch (FileNotFoundException e) {
            statusText.setTextColor(Color.RED);
            statusText.setText("Something wrong");
            e.printStackTrace();
        } catch (IOException e) {
            statusText.setTextColor(Color.RED);
            statusText.setText("Something wrong");
            e.printStackTrace();
        }
    }
}