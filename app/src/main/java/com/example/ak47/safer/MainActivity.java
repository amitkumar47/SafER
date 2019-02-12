package com.example.ak47.safer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener{

    private TextView xText, yText, zText,cha;
    private Sensor mySensor;
    private SensorManager SM;
    private double checkx=0.0;
    private double precheckx=0.0;
    private double checky=0.0;
    private double prechecky=0.0;
    private double checkz=0.0;
    private double precheckz=0.0;
 //   private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create our Sensor Manager
        SM = (SensorManager)getSystemService(SENSOR_SERVICE);

        // Accelerometer Sensor
        mySensor = SM.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        // Register sensor Listener
        SM.registerListener(this, mySensor, SensorManager.SENSOR_DELAY_NORMAL);

        // Assign TextView
        xText = (TextView)findViewById(R.id.xText);
        yText = (TextView)findViewById(R.id.yText);
        zText = (TextView)findViewById(R.id.zText);
   //     button= (Button)findViewById(R.id.Press);
        cha = (TextView)findViewById(R.id.Text);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Not in use
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        checkx=precheckx;
        checkx=event.values[0];
        checky=prechecky;
        checky=event.values[1];
        checkz=precheckz;
        checkz=event.values[2];
        xText.setText("X: " + event.values[0]);
        yText.setText("Y: " + event.values[1]);
        zText.setText("Z: " + event.values[2]);
        if ((checkx-precheckx)>30 || (checky-prechecky)>30 || (checkz-precheckz)>30 ){
            cha.setText("check: " + checkx);
          //  Intent amit = new Intent(this, stop.class);
          //  startActivity(amit);

        }

    }

    public void Press (View view) {
        Intent amit = new Intent("android.intent.action.Main2Activity");
        startActivity(amit);
    }



}

