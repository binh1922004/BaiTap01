package vn.iotstar.myapplication;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
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
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title not the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);//int flag, int mask
        setContentView(R.layout.activity_main);
        EditText editTextNumber = findViewById(R.id.editTextNumbers);
        Button buttonProcess = findViewById(R.id.buttonProcess);
        EditText editText = findViewById(R.id.editTextInput);
        Button buttonTest = findViewById(R.id.buttonTest);
        TextView textViewOutput = findViewById(R.id.textViewOutput);
        buttonProcess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = editTextNumber.getText().toString();
                String[] numberStrings = input.split(" ");
                ArrayList<Integer> numbers = new ArrayList<>();
                ArrayList<Integer> sochan = new ArrayList<>();
                ArrayList<Integer> sole = new ArrayList<>();
                for(String numberString : numberStrings){
                    try{
                        int number = Integer.parseInt(numberString.trim());
                        numbers.add(number);
                        if(number%2==0)
                        {
                            sochan.add(number);
                        }
                        else{
                            sole.add(number);
                        }
                    }catch (NumberFormatException e)
                    {
                        Log.d(TAG, "Khong phai so hop le: "+numberString);
                    }
                }
                // In số chẵn và số lẻ
                Log.d(TAG, "Số chẵn: " + sochan.toString());
                Log.d(TAG, "Số lẻ: " + sole.toString());

            }
        });
        buttonTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = editText.getText().toString();

                String reversedAndUppercase = reverseAndUppercase(input);
                // Hiển thị kết quả trong TextView
                textViewOutput.setText(reversedAndUppercase);

                // Hiển thị kết quả trong Toast
                Toast.makeText(MainActivity.this, reversedAndUppercase, Toast.LENGTH_SHORT).show();
            }
        });
    }
    private String reverseAndUppercase(String input) {
        // Tách chuỗi thành các từ
        String[] words = input.split(" ");

        // Đảo ngược thứ tự các từ
        List<String> wordList = Arrays.asList(words);
        Collections.reverse(wordList);

        // Ghép lại thành chuỗi và chuyển thành chữ in hoa
        String result = String.join(" ", wordList);
        return result.toUpperCase();
    }
}