package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import static java.lang.Math.min;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    HashMap<String, String> input_to_id = new HashMap<>();
    HashMap<String, ArrayList> units = new HashMap<>();
    HashMap<String, Integer> factors = new HashMap<>();
    private Button restartButton;
    private TextView inputNumber;
    private TextView outputNumber;
    private Spinner spinner1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        input_to_id.put("km", "length");
        input_to_id.put("hm", "length");
        input_to_id.put("dam", "length");
        input_to_id.put("m", "length");
        input_to_id.put("dm", "length");
        input_to_id.put("cm", "length");
        input_to_id.put("mm", "length");

        ArrayList<String> length_units = new ArrayList<>();
        length_units.add("km");
        length_units.add("hm");
        length_units.add("dam");
        length_units.add("m");
        length_units.add("dm");
        length_units.add("cm");
        length_units.add("mm");

        units.put("length",length_units);

        factors.put("length", 10);

        restartButton = (Button) findViewById(R.id.restart);
        restartButton.setOnClickListener(this);
        inputNumber = (TextView) findViewById(R.id.input_num);
        outputNumber = (TextView) findViewById(R.id.output_num);
        String test_compute = compute(length_units, 5,2,10);
        System.out.println(test_compute);
    }
    public void onClick(View view){
        inputNumber.setText("Input Number");
        outputNumber.setText("");
    }
    public String compute(ArrayList<String> arr, int index1, int index2, int factor) {
        int pointer1 = Math.min(index1,index2);
        System.out.println(pointer1);
        int pointer2 = pointer1 + 1;
        String output_string = "1" + arr.get(index1);
        if (index1 < index2) {
            while (pointer2 <= index2) {
                output_string += "*[(" + String.valueOf(factor) + arr.get(pointer2) + ")/(1" + arr.get(pointer1) + ")]";
                pointer2 += 1;
                pointer1 += 1;
            }
        } else {
            while (pointer2 <= index1) {
                System.out.println("case21");
                output_string += "*[(1" + arr.get(pointer2) + ")/(" + String.valueOf(factor) + arr.get(pointer1) + ")]";
                pointer2 += 1;
                pointer1 += 1;
            }
        }
        return output_string;
    }
}