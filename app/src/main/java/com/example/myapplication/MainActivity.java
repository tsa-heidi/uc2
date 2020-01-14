package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private HashMap<String, String> input_to_id;
    private HashMap<String, ArrayList> units;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input_to_id.put("England", "London");
        input_to_id.put("Germany", "Berlin");
        input_to_id.put("Norway", "Oslo");
        input_to_id.put("USA", "Washington DC");
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

    public static void linearSearch(int ){

    }

    //sample
    public static void main(String args[]){
        int arr[] = {10,20,30,40,50};
        int key = 30;
        int last=arr.length-1;
        binarySearch(arr,0,last,key);
    }
}
