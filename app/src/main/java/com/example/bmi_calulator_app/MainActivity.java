package com.example.bmi_calulator_app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
        EditText edtWeight ,edtHeightFt,edtHeightIn;
        Button btnCalulate;
        TextView txtResult;

        edtWeight= findViewById(R.id.edtWeight);
        edtHeightFt= findViewById(R.id.edtHeightFt);
        edtHeightIn= findViewById(R.id.edtHeightIn);
        btnCalulate= findViewById(R.id.btncalculate);
        txtResult= findViewById(R.id.txtResult);

        btnCalulate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int wt = Integer.parseInt( edtWeight.getText().toString());
                int ft = Integer.parseInt( edtHeightFt.getText().toString());
                int inch = Integer.parseInt( edtHeightIn.getText().toString());

                int totalIn =  ft * 12 + inch;
                double totalCm = totalIn * 2.54;
                double totalM = totalCm / 100;
                double bmi = wt / (totalM * totalM);

                if(bmi > 25){
                    txtResult.setText("You are Over Weight");
                }
                else if(bmi < 18){
                    txtResult.setText("You are Under Weight");
                }
                else{
                    txtResult.setText("You are Healthy");
                }

            }
        });


    }
}