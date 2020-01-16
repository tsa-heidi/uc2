package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    HashMap<String, String> input_to_id = new HashMap<>();
    HashMap<String, ArrayList> units = new HashMap<>();
    HashMap<String, Integer> factors = new HashMap<>();
    private Button restartButton;
    private TextView inputNumber;
    private TextView outputNumber;
    private Spinner spinner1;
    private Spinner spinner2;
    private Button calculateButton;
    private TextView calculateText;

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

//        String test_compute = compute(length_units, 5,2,10);
//        System.out.println(test_compute);

        restartButton = findViewById(R.id.restart);
        restartButton.setOnClickListener(this);
        calculateButton = findViewById(R.id.convert);
        calculateButton.setOnClickListener(this);

        inputNumber =  findViewById(R.id.input_num);
        outputNumber = findViewById(R.id.output_num);
        calculateText = findViewById(R.id.calculateText);

        spinner1 =  findViewById(R.id.units1);
        spinner2 = findViewById(R.id.units2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.units_array,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(this);
        spinner2.setOnItemSelectedListener(this);

    }
    @Override
    public void onItemSelected(AdapterView<?>parent, View view, int position, long id ){
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onNothingSelected(AdapterView<?>parent){
        //leave blank
    }
    @Override
    public void onClick(View view){
        switch(view.getId()){
            case R.id.restart://restart button
                inputNumber.setText("");
                outputNumber.setText("");
                calculateText.setText("");
                break;
            case R.id.convert:
                String unitText = spinner1.getSelectedItem().toString(); //this should get the selected item from the menu
                String unitText2 = spinner2.getSelectedItem().toString();
                String input_id = input_to_id.get(unitText);
                int current_factor = factors.get(input_id);
                ArrayList<String> current_units = units.get(input_id);
                int input_index = current_units.indexOf(unitText);
                int output_index = current_units.indexOf(unitText2);
                String display = compute(current_units, input_index, output_index, current_factor);
                calculateText.setText(""+display);
                //System.out.println(display);
                break;
        }
    }

    public String compute(ArrayList<String> arr, int index1, int index2, int factor) {
        String inputNum = inputNumber.getText().toString(); //this should get the inputted number as a string

        int pointer1 = Math.min(index1,index2);
        int pointer2 = pointer1 + 1;
        int distance = 1;
        String output_string = inputNum + arr.get(index1);
        if (index1 < index2) {
            while (pointer2 <= index2) {
                output_string += "*[(" + String.valueOf(factor) + arr.get(pointer2) + ")/(1" + arr.get(pointer1) + ")]";
                //calculateText.setText(output_string);
                pointer2 += 1;
                pointer1 += 1;
                distance = distance *(factor);
            }
        } else {
            while (pointer2 <= index1) {
                //System.out.println("case21");
                output_string += "*[(1" + arr.get(pointer2) + ")/(" + String.valueOf(factor) + arr.get(pointer1) + ")]";
                //calculateText.setText(output_string);
                pointer2 += 1;
                pointer1 += 1;
                distance = distance*(factor);
            }
        }
        outputNumber.setText(""+Integer.parseInt(inputNum)*distance);
        return output_string;
    }
}