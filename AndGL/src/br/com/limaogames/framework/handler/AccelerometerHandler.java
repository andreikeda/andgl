package br.com.limaogames.framework.handler;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/**
 * Classe para manipular eventos e atributos do acelerômetro.
 * 
 * @author André <br />
 * <b>Email:</b> andreikeda@limaogames.com.br <br />
 * created on: 31/07/2013
 * @version 1.0
 * @see SensorEventListener
 */
public class AccelerometerHandler implements SensorEventListener {
    float accelX;
    float accelY;
    float accelZ;

    /**
     * Construtor da classe.
     * 
     * @param context - Objeto de {@link Context}.
     */
    public AccelerometerHandler(Context context) {
        SensorManager manager = (SensorManager) context
                .getSystemService(Context.SENSOR_SERVICE);
        if (manager.getSensorList(Sensor.TYPE_ACCELEROMETER).size() != 0) {
            Sensor accelerometer = manager.getSensorList(
                    Sensor.TYPE_ACCELEROMETER).get(0);
            manager.registerListener(this, accelerometer,
                    SensorManager.SENSOR_DELAY_GAME);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // nothing to do here
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        accelX = event.values[0];
        accelY = event.values[1];
        accelZ = event.values[2];
    }

    /**
     * Retorna valor x do acelerômetro.
     * 
     * @return Float valor x do acelerômetro.
     */
    public float getAccelX() {
        return accelX;
    }

    /**
     * Retorna valor y do acelerômetro.
     * 
     * @return Float valor y do acelerômetro.
     */
    public float getAccelY() {
        return accelY;
    }

    /**
     * Retorna valor z do acelerômetro.
     * 
     * @return Float valor z do acelerômetro.
     */
    public float getAccelZ() {
        return accelZ;
    }
}
