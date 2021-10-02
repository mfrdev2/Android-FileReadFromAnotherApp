package com.frabbi.mysecond;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private TextView text;
    private Button loadBtn;
    private String packageName = "com.frabbi.myfirst";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.eiditTextId);
        loadBtn = findViewById(R.id.loadBtnId);

        loadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadData();
            }
        });
    }

    private void loadData() {
        PackageManager packageManager = getPackageManager();
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(packageName,
                    PackageManager.GET_META_DATA);
            String fullPath = applicationInfo.dataDir+"/files/save.txt";
            FileInputStream
                fileInput = new FileInputStream(new File(fullPath));
            int read = -1;
            StringBuffer buffer = new StringBuffer();
            while ((read = fileInput.read()) != -1){
                buffer.append((char) read);
            }
            text.setText(buffer.toString());




        } catch (PackageManager.NameNotFoundException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}