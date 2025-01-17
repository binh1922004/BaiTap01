package com.example.baitap01;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText edtArray, edtString;
    TextView tvRes;
    Button btnOddEven, btnReverse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        edtArray = findViewById(R.id.edtArray);
        edtString = findViewById(R.id.edtString);
        tvRes = findViewById(R.id.tvRes);
        btnReverse = findViewById(R.id.btnReverse);
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

        btnReverse.setOnClickListener(v -> {
            String input = edtString.getText().toString();
            String res = reverse(input);
            tvRes.setText(res);
            Toast.makeText(getApplicationContext(), res, Toast.LENGTH_LONG).show();
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

    private String reverse(String input){
        String[] s = input.split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = s.length - 1; i >= 0; i--) {
            res.append(s[i].toUpperCase());
            if (i != 0)
                res.append(" ");
        }
        return res.toString();
    }
}