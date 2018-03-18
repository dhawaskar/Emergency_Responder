package com.example.sandesh.iot_responder;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener{

    private EditText edit_x,edit_y,edit_z,edit_lin_x,edit_lin_y,edit_lin_z;
    private SensorManager sensorManager;
    private Sensor sensAccelerometer;
    @Override
    public void onAccuracyChanged(Sensor mysens,int x) {
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sensorManager=(SensorManager)getSystemService(Context.SENSOR_SERVICE);
        sensAccelerometer=sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this,sensAccelerometer,sensorManager.SENSOR_DELAY_NORMAL);
        edit_x=(EditText) findViewById(R.id.editText1);
        edit_y=(EditText) findViewById(R.id.editText2);
        edit_z=(EditText) findViewById(R.id.editText3);
        edit_lin_x=(EditText) findViewById(R.id.editText4);
        edit_lin_y=(EditText) findViewById(R.id.editText5);
        edit_lin_z=(EditText) findViewById(R.id.editText6);
    }
    @Override
    public void onSensorChanged(SensorEvent event){
        Sensor mysensor=event.sensor;
        if(mysensor.getType()==Sensor.TYPE_ACCELEROMETER){
            float x=event.values[0];
            float y=event.values[1];
            float z=event.values[2];
            edit_x.setText(Float.toString(x));
            edit_y.setText(Float.toString(y));
            edit_z.setText(Float.toString(z));
            edit_lin_x.setText(Float.toString(x));
            edit_lin_y.setText(Float.toString(y));
            edit_lin_z.setText(Float.toString(z));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
