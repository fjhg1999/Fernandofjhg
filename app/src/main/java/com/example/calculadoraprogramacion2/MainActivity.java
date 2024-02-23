package com.example.calculadoraprogramacion2;
import androidx.appcompat.app.AppCompatActivity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
public final class MainActivity extends AppCompatActivity {
    SensorManager SensorManager;
    Sensor sensor;
    private SensorEventListener _sensorEvenListener;
    TextView tempVal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tempVal = findViewById(R.id.lblSensorAcelerometro);
        activarSensorAcelerometro();
    }
    private void activarSensorAcelerometro() {
        SensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = SensorManager.getDefaultSensor(sensor.TYPE_ACCELEROMETER);
        if (sensor == null) {
            tempVal.setText("tu dispositivo no cuenta con el sensor acelerometro");
            finish();
        }
        _sensorEvenListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                tempVal.setText("acelerometro:x = "+ event.values[0]+", y = "+event.values[1]+", z = "+ event.values[2]);
            }
            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {};
        };
    }
    @Override
    public void onResume(){
        iniciar();
        super.onResume();
    }
    @Override
    public void onPause(){
        detener();
        super.onPause();
    }
    private void iniciar(){
        SensorManager.registerListener(_sensorEvenListener, sensor, 2000*1000);
    }
    private void detener(){
        SensorManager.unregisterListener(_sensorEvenListener);
    }
}