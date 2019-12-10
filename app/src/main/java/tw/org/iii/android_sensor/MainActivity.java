package tw.org.iii.android_sensor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private SensorManager sensorManager;
    private Sensor sensor;
    private MyListener myListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        //看手機有哪些感應器
//        List<Sensor> sensors = sensorManager.getSensorList(Sensor.TYPE_ALL);
//        for (Sensor sensor : sensors) {
//            Log.v("DCH", sensor.getName()+ ":" +sensor.getStringType());
//        }

        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }

    //有在使用才註冊
    @Override
    protected void onResume() {
        super.onResume();
        myListener = new MyListener();
        sensorManager.registerListener(myListener, sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    //沒在使用就停止
    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(myListener);
    }

    private class MyListener implements SensorEventListener {

        @Override
        public void onSensorChanged(SensorEvent event) {

        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    }
}
