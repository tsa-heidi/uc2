package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    HashMap<String, String> input_to_id = new HashMap<>();
    HashMap<String, ArrayList> units = new HashMap<>();
    HashMap<String, Integer> factors = new HashMap<>();
    private Button restartButton;
    private TextView inputNumber;
    private TextView outputNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int arr[] = {10,20,30,40,50};
        int target = 30;
        int last=arr.length-1;


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
    }
    public void onClick(View view){
        inputNumber.setText("Input Number");
        outputNumber.setText("");
    }

    public static void binarySearch(int arr[], int first, int last, int target){
        int mid = (first + last)/2;
        while (first <= last){
            if (arr[mid] < target){
                first = mid + 1;
            } else if (arr[mid] == target){
                System.out.println("Function" +
                        " found at index: " + mid);
                break;
            } else{
                last = mid - 1;
            }
            mid = (first + last)/2;
        }
        if (first > last){
            System.out.println("Function not found!");
        }
        binarySearch(arr,0,last,target);

    }

    public static int linearSearch(int arr[], int target){
        int result = linearSearch(arr, target);
        if(result == -1)
            System.out.print("Function not present!");
        else
            System.out.print("Function is present!" + result);


        int n = arr.length;
            for(int i = 0; i < n; i++){
                if(arr[i] == target)
                    return i;
            }
            return -1;
        }

}
