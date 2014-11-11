package com.example.BMICalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main extends Activity {
    
    private EditText bodyHeightText;
    private EditText bodyWeightText;
    private Button calculateButton;
    private TextView resultView;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        initViews();
    }

    private void initViews()
    {
        bodyHeightText = (EditText)findViewById(R.id.body_height);
        bodyWeightText = (EditText)findViewById(R.id.body_weight);
        resultView = (TextView)findViewById(R.id.resultText);
        
        calculateButton = (Button)findViewById(R.id.calculate_bmi);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI()
    {
        String heightTxt = String.valueOf(bodyHeightText.getText());
        String weightTxt = String.valueOf(bodyWeightText.getText());

        float height = Integer.parseInt(heightTxt);
        float weight = Integer.parseInt(weightTxt);

        float heightInMeters = height/100;

        float result = heightInMeters*heightInMeters;
        result = weight/result;

        String resultText = String.valueOf(result);

        resultView.setText(resultText);
    }


}
