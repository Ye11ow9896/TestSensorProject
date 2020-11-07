package com.example.testsensorproject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AccelActivity extends Activity implements SensorEventListener {

    private TextView xyView;
    private TextView xzView;
    private TextView zyView;

    private SensorManager sensorManager;
    private Sensor mAccel;
    private Vibrator vibrator;

    private Button BtnBack;

    @Override
    public final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accel);
        addListenerOnButton();

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        mAccel = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        xyView = (TextView) findViewById(R.id.textView);
        xzView = (TextView) findViewById(R.id.textView2);
        zyView = (TextView) findViewById(R.id.textView3);

    }

    @Override
    public final void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Do something here if sensor accuracy changes.
    }

    @Override
    public final void onSensorChanged(SensorEvent event) {

        if(event.values[0]>7 |
                event.values[0]<-7 |
                event.values[1]>7 |
                event.values[1]<-7) vibrator.vibrate(100L);
        else vibrator.cancel();

        xyView.setText(String.valueOf((int)event.values[0]));
        xzView.setText(String.valueOf((int)event.values[1]));
        zyView.setText(String.valueOf((int)event.values[2]));
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, mAccel,SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    public void addListenerOnButton(){
        BtnBack = (Button) findViewById(R.id.button);
        BtnBack.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Intent intent = new Intent(AccelActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                }
        );
    }
}