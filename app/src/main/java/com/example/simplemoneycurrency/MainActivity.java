package com.example.simplemoneycurrency;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {


    private TextView show;
    private TextView res;
    private EditText curr;
    private Button conv;
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        curr = (EditText)findViewById(R.id.editText4);
        show = (TextView)findViewById(R.id.textView);
        res = (TextView)findViewById(R.id.textView2);
        conv = (Button)findViewById(R.id.button);

        Spinner mySpinner = (Spinner)findViewById(R.id.spinner);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.names));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);

        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 1) {
                    pos = 1;
                } else if (position == 2) {
                    pos = 2;
                } else if (position == 3) {
                    pos = 3;
                } else if(position == 0){
                    pos = 0;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        conv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float number1 = Float.parseFloat(curr.getText().toString());
                double sum = 0;

                if(pos ==1) {
                    sum = number1 * 14320;
                    res.setText("IDR : " + String.valueOf(sum));
                }else if(pos==2){
                    sum = number1 *9844.06;
                    res.setText("IDR : " + String.valueOf(sum));
                }else if(pos==3){
                    sum = number1 *10444.15;
                    res.setText("IDR : " + String.valueOf(sum));
                }else if(pos ==0 ){
                    res.setText("Please Input Currency !");
                }


            }
        });
    }
}
