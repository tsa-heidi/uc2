package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    HashMap<String, String> input_to_id = new HashMap<String,String>();
    HashMap<String, ArrayList> units = new HashMap<String, ArrayList>();
    private Button restartButton;
    private TextView inputNumber;
    private TextView outputNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input_to_id.put("km", "length");
        input_to_id.put("hm", "length");
        input_to_id.put("dam", "length");
        input_to_id.put("m", "length");
//        input_to_id.put("dm, length");
//        input_to_id.put("cm, length");
//        input_to_id.put("mm, length");

        restartButton = (Button) findViewById(R.id.restart);
        restartButton.setOnClickListener(this);
        inputNumber = (TextView) findViewById(R.id.input_num);
        outputNumber = (TextView) findViewById(R.id.output_num);
    }
    public void onClick(View view){
        inputNumber.setText("Input Number");
        outputNumber.setText("");
    }

    public static void binarySearch(int arr[], int first, int last, int key){
        int mid = (first + last)/2;
        while (first <= last){
            if (arr[mid] < key){
                first = mid + 1;
            } else if (arr[mid] == key){
                System.out.println("Function is found at index: " + mid);
                break;
            } else{
                last = mid - 1;
            }
            mid = (first + last)/2;
        }
        if (first > last){
            System.out.println("Function is not found!");
        }
    }

//    public static void linearSearch(int hello){
//       int once = hello;
//    }

//    //sample
//    public static void main(String args[]){
//        int arr[] = {10,20,30,40,50};
//        int key = 30;
//        int last=arr.length-1;
//        binarySearch(arr,0,last,key);
//    }
}
