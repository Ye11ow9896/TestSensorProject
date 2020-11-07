package com.example.testsensorproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button BtnLight, BtnAccel, BtnCoords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();
    }

    public void addListenerOnButton(){
        BtnLight = (Button) findViewById(R.id.btnLight);
        BtnAccel = (Button) findViewById(R.id.btnAccl);
        BtnCoords = (Button) findViewById(R.id.btnCoords);

        BtnLight.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Intent intent = new Intent(MainActivity.this, LightActivity.class);
                        startActivity(intent);
                    }
                }
        );

        BtnAccel.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Intent intent = new Intent(MainActivity.this, AccelActivity.class);
                        startActivity(intent);
                    }
                }
        );

        BtnCoords.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, CoordsActivity.class);
                        startActivity(intent);
                    }
                }
        );
    }
}