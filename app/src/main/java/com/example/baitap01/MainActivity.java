package com.example.baitap01;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText edtArray;
    Button btnOddEven;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        edtArray = findViewById(R.id.edtArray);
        btnOddEven = findViewById(R.id.btnOddEven);

        btnOddEven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] numbers = edtArray.getText().toString().split(" ");
                List<Integer> numberList = new ArrayList<>();
                // Chuyển từng phần tử từ chuỗi sang số nguyên và thêm vào danh sách
                for (String num : numbers) {
                    numberList.add(Integer.parseInt(num));
                }
                logOddEven(numberList);
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void logOddEven(List<Integer> numberList) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int x: numberList){
            if (!map.containsKey(x)){
                map.put(x, 1);
            }
            else{
                map.put(x, map.get(x) + 1);
            }
        }
        for (int x: numberList){
            if (map.get(x) == 1){
                if (x % 2 == 0){
                    Log.d("So rieng biet", "So chan: " + x);
                }
                else{
                    Log.d("So rieng biet", "So le: " + x);
                }
            }
        }
    }
}