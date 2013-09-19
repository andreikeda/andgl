package br.com.limaogames.framework.impl;

import java.util.List;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;
import br.com.limaogames.framework.handler.AccelerometerHandler;
import br.com.limaogames.framework.handler.KeyboardHandler;
import br.com.limaogames.framework.handler.MultiTouchHandler;
import br.com.limaogames.framework.handler.SingleTouchHandler;
import br.com.limaogames.framework.interfaces.Input;
import br.com.limaogames.framework.interfaces.TouchHandler;

/**
 * Classe para prover a funcionalidade para manipulação de dados/eventos de entrada.
 * 
 * @author André <br />
 * <b>Email:</b> andreikeda@limaogames.com.br <br />
 * created on: 31/07/2013
 * @version 1.0
 * @see Input
 */
public class AndroidInput implements Input {    
    AccelerometerHandler accelHandler;
    KeyboardHandler keyHandler;
    TouchHandler touchHandler;

    /**
     * Construtor da classe.
     * 
     * @param context - Objeto de {@link Context}.
     * @param view - Objeto de {@link View}.
     * @param scaleX - Inteiro com valor da escala horizontal.
     * @param scaleY - Inteiro com valor da escala vertical.
     */
    @SuppressWarnings("deprecation")
	public AndroidInput(Context context, View view, float scaleX, float scaleY) {
        accelHandler = new AccelerometerHandler(context);
        keyHandler = new KeyboardHandler(view);               
        if(Integer.parseInt(VERSION.SDK) < 5) 
            touchHandler = new SingleTouchHandler(view, scaleX, scaleY);
        else
            touchHandler = new MultiTouchHandler(view, scaleX, scaleY);        
    }

    @Override
    public boolean isKeyPressed(int keyCode) {
        return keyHandler.isKeyPressed(keyCode);
    }

    @Override
    public boolean isTouchDown(int pointer) {
        return touchHandler.isTouchDown(pointer);
    }

    @Override
    public int getTouchX(int pointer) {
        return touchHandler.getTouchX(pointer);
    }

    @Override
    public int getTouchY(int pointer) {
        return touchHandler.getTouchY(pointer);
    }

    @Override
    public float getAccelX() {
        return accelHandler.getAccelX();
    }

    @Override
    public float getAccelY() {
        return accelHandler.getAccelY();
    }

    @Override
    public float getAccelZ() {
        return accelHandler.getAccelZ();
    }

    @Override
    public List<TouchEvent> getTouchEvents() {
        return touchHandler.getTouchEvents();
    }
    
    @Override
    public List<KeyEvent> getKeyEvents() {
        return keyHandler.getKeyEvents();
    }
}
